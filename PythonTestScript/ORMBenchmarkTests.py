#!/usr/bin/python

import sys, getopt

# libraries imports
import logger
import logmatcher
import adb_interface

PACKAGE_NAME = 'pl.gombal.orm_benchmarks'
ORM_SERVICE_PACKAGE_PATH = PACKAGE_NAME + '/.task.ORMBenchmarkService'

INTENT_EXTRA_KEY_ROW_COUNT = PACKAGE_NAME + '.intent_key.ROW_COUNT'
INTENT_ACTION_SQLITE = PACKAGE_NAME + '.action.START_SQLITE_BENCHMARK'
INTENT_ACTION_GREENDAO = PACKAGE_NAME + '.action.START_GREENDAO_BENCHMARK'
INTENT_ACTION_ORMLITE = PACKAGE_NAME + '.action.START_ORMLITE_BENCHMARK'
INTENT_ACTION_ACTIVE_ANDROID = PACKAGE_NAME + '.action.START_ACTIVE_ANDROID_BENCHMARK'
INTENT_ACTION_SUGAR_ORM = PACKAGE_NAME + '.action.START_SUGAR_ORM_BENCHMARK'
INTENT_ACTIONS = {
    'SQLite RAW': INTENT_ACTION_SQLITE,
    'GreenDAO': INTENT_ACTION_GREENDAO,
    'ORMLite': INTENT_ACTION_ORMLITE,
    'ActiveAndroid': INTENT_ACTION_ACTIVE_ANDROID,
    'SugarORM': INTENT_ACTION_SUGAR_ORM
}

INTENT_EXTRA_KEY_WITH_TRANSACTION = PACKAGE_NAME + '.intent_key.WITH_TRANSACTION'
INTENT_EXTRA_KEY_SELECT_TYPE = PACKAGE_NAME + '.intent_key.SELECTION_TYPE'

WITH_TRANSACTION = (0, 1)
SELECT_TYPE = (0, 1, 2)
ROW_COUNT_TAB = (2, 4, 8, 16, 32, 64, 128, 256, 512, 1024)

adb = adb_interface.AdbInterface()


def reinstall_app():
    logger.Log('Uninstalling apk')
    print adb.Uninstall(PACKAGE_NAME)
    logger.Log('Installing apk')
    print adb.Install('app-debug.apk')


def start_orm_service(orm, row_number, with_transaction=0, select_type=0):
    shell_command = build_shell_command_to_start_orm_benchmark(orm, row_number, with_transaction, select_type)
    logger.Log(shell_command)
    adb.SendShellCommand(shell_command)


def build_shell_command_to_start_orm_benchmark(intent_action, row_number, with_transaction, select_type):
    shell_command = 'am startservice -n %s -a %s --ei %s %s --ei %s %s --ei %s %s' % (
        ORM_SERVICE_PACKAGE_PATH, intent_action, INTENT_EXTRA_KEY_ROW_COUNT, row_number,
        INTENT_EXTRA_KEY_WITH_TRANSACTION, with_transaction, INTENT_EXTRA_KEY_SELECT_TYPE, select_type)

    return shell_command


def build_pattern_for_logcat(orm_name, row_number, transaction, select_type):
    pattern = 'FINISH_%s_rows=%s_t=%s_select=%s' % (orm_name, row_number, transaction, select_type)
    print pattern
    return pattern


def main(argv):
    logger.Log("ORM TEST STARTED")
    logger.Log('Installing apk')
    print adb.Install('app-debug.apk')

    for with_trans in WITH_TRANSACTION:
        for select_type in SELECT_TYPE:
            for name, orm_intent in INTENT_ACTIONS.items():
                for row_number in ROW_COUNT_TAB:
                    logger.Log('Tested ORM: ' + name + ' WITH TRANSACTION = %d' % with_trans)
                    logger.Log('Rows: ' + str(row_number))

                    adb.StopAppProcess(PACKAGE_NAME)
                    adb.ClearAppData(PACKAGE_NAME)

                    start_orm_service(orm_intent, row_number, with_trans, select_type)

                    logmatcher.start()
                    if logmatcher.wait(build_pattern_for_logcat(name, row_number, with_trans, select_type), 43200):
                        logger.Log('FINISH %s TEST' % name)


if __name__ == '__main__':
    main(sys.argv[1:])
