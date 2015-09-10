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
INTENT_ACTIONS = (
    # INTENT_ACTION_SQLITE,
    INTENT_ACTION_GREENDAO,
    INTENT_ACTION_ORMLITE,
    INTENT_ACTION_ACTIVE_ANDROID,
    INTENT_ACTION_SUGAR_ORM)

INTENT_EXTRA_KEY_WITH_TRANSACTION = PACKAGE_NAME + '.intent_key.WITH_TRANSACTION'
WITH_TRANSACTION = (0, 1)

ROW_COUNT_TAB = (10, 50, 100, 500, 1000, 5000, 10000)
# ROW_COUNT_TAB = (5, 10, 15, 20)

adb = adb_interface.AdbInterface()


def reinstall_app():
    logger.Log('Uninstalling apk')
    print adb.Uninstall(PACKAGE_NAME)
    logger.Log('Installing apk')
    print adb.Install('app-debug.apk')


def start_orm_service(orm, row_number, with_transaction=0):
    shell_command = build_shell_command_to_start_orm_benchmark(orm, row_number, with_transaction)
    logger.Log(shell_command)
    adb.SendShellCommand(shell_command)


def build_shell_command_to_start_orm_benchmark(intent_action, row_number, with_transaction):
    shell_command = 'am startservice -n %s -a %s --ei %s %s --ei %s %s' % (
        ORM_SERVICE_PACKAGE_PATH, intent_action, INTENT_EXTRA_KEY_ROW_COUNT, row_number,
        INTENT_EXTRA_KEY_WITH_TRANSACTION, with_transaction)

    return shell_command


def main(argv):
    logger.Log("ORM TEST STARTED")
    logger.Log('Installing apk')
    print adb.Install('app-debug.apk')

    for withTrans in WITH_TRANSACTION:
        for orm in INTENT_ACTIONS:
            for row_number in ROW_COUNT_TAB:
                logger.Log('Tested ORM: ' + orm + ' WITH TRANSACTION = %d' % withTrans)
                logger.Log('Rows: ' + str(row_number))

                adb.StopAppProcess(PACKAGE_NAME)
                adb.ClearAppData(PACKAGE_NAME)

                # reinstall_app()

                start_orm_service(orm, row_number, withTrans)

                logmatcher.start()
                if logmatcher.wait('FINISH_ORM_BENCHMARK', 43200):
                    logger.Log('ORM FINISH BENCHMARK')

                    # adb.SendShellCommand('am start  -n pl.gombal.orm_benchmarks/.ui.MainActivity')


if __name__ == '__main__':
    main(sys.argv[1:])
