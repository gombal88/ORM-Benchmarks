package pl.gombal.orm_benchmarks.io.sqlite;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pl.gombal.orm_benchmarks.io.sqlite.entity.BigSingleTable;
import pl.gombal.orm_benchmarks.io.sqlite.entity.BigSingleTableDao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_01;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_01Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_02;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_02Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_03;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_03Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_04;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_04Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_05;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_05Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_06;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_06Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_07;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_07Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_08;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_08Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_09;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_09Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_10;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_10Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.SingleTable;
import pl.gombal.orm_benchmarks.io.sqlite.entity.SingleTableDao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToMany;
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToManyDao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToOne;
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToOneDao;
import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

public class SQLiteBenchmarkTasksHelper {

    protected static void createDatabase(SQLiteDatabase db, boolean createTablesIfNotExists) {
        db.execSQL(new SingleTableDao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new BigSingleTableDao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new MultiTable_01Dao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new MultiTable_02Dao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new MultiTable_03Dao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new MultiTable_04Dao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new MultiTable_05Dao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new MultiTable_06Dao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new MultiTable_07Dao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new MultiTable_08Dao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new MultiTable_09Dao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new MultiTable_10Dao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new TableWithRelationToManyDao().getCreateTableStatement(createTablesIfNotExists));
        db.execSQL(new TableWithRelationToOneDao().getCreateTableStatement(createTablesIfNotExists));

        List<String> indexStatements = new ArrayList<>();
        indexStatements.addAll(Arrays.asList(new SingleTableDao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new BigSingleTableDao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new MultiTable_01Dao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new MultiTable_02Dao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new MultiTable_03Dao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new MultiTable_04Dao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new MultiTable_05Dao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new MultiTable_06Dao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new MultiTable_07Dao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new MultiTable_08Dao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new MultiTable_09Dao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new MultiTable_10Dao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new TableWithRelationToManyDao().getCreateIndexStatements(false)));
        indexStatements.addAll(Arrays.asList(new TableWithRelationToOneDao().getCreateIndexStatements(false)));

        for (String indexStatement : indexStatements)
            db.execSQL(indexStatement);
    }

    protected static void dropDatabase(SQLiteDatabase db, boolean ifNotExists) {
        db.execSQL(new SingleTableDao().getDropTableStatement(ifNotExists));
        db.execSQL(new BigSingleTableDao().getDropTableStatement(ifNotExists));
        db.execSQL(new MultiTable_01Dao().getDropTableStatement(ifNotExists));
        db.execSQL(new MultiTable_02Dao().getDropTableStatement(ifNotExists));
        db.execSQL(new MultiTable_03Dao().getDropTableStatement(ifNotExists));
        db.execSQL(new MultiTable_04Dao().getDropTableStatement(ifNotExists));
        db.execSQL(new MultiTable_05Dao().getDropTableStatement(ifNotExists));
        db.execSQL(new MultiTable_06Dao().getDropTableStatement(ifNotExists));
        db.execSQL(new MultiTable_07Dao().getDropTableStatement(ifNotExists));
        db.execSQL(new MultiTable_08Dao().getDropTableStatement(ifNotExists));
        db.execSQL(new MultiTable_09Dao().getDropTableStatement(ifNotExists));
        db.execSQL(new MultiTable_10Dao().getDropTableStatement(ifNotExists));
        db.execSQL(new TableWithRelationToManyDao().getDropTableStatement(ifNotExists));
        db.execSQL(new TableWithRelationToOneDao().getDropTableStatement(ifNotExists));
    }

    protected static void dropDatabase(Context context, String dbName) {
        context.deleteDatabase(dbName);
    }

    protected static List<SingleTable> getSingleTableList(SQLiteDatabase db, int num) {
        List<SingleTable> singleTableList = new ArrayList<>();
        Cursor cursorSingleTable = null;

        try {
            cursorSingleTable = new SelectionBuilder().table("SINGLE_TABLE").query(db, null, null, null, null, String.valueOf(num));
            if (cursorSingleTable == null || cursorSingleTable.getCount() < num)
                throw new ExceptionInInitializerError("Number entities is smaller than: " + num);

            cursorSingleTable.moveToNext();
            do {
                SingleTable table = (SingleTable) new SingleTable().fromCursor(cursorSingleTable);
                table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                singleTableList.add(table);
            } while (cursorSingleTable.moveToNext());
        } finally {
            if (cursorSingleTable != null)
                cursorSingleTable.close();
        }
        return singleTableList;
    }

    protected static List<BigSingleTable> getBigSingleTableList(SQLiteDatabase db, int num) {
        List<BigSingleTable> bigSingleTableList = new ArrayList<>();
        Cursor cursorBigSingleTable = null;

        try {
            cursorBigSingleTable = new SelectionBuilder().table("BIG_SINGLE_TABLE").query(db, null, null, null, null, String.valueOf(num));
            if (cursorBigSingleTable == null || cursorBigSingleTable.getCount() < num)
                throw new ExceptionInInitializerError("Number entities is smaller than: " + num);

            cursorBigSingleTable.moveToFirst();
            do {
                BigSingleTable table = (BigSingleTable) new BigSingleTable().fromCursor(cursorBigSingleTable);
                table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                bigSingleTableList.add(table);
            } while (cursorBigSingleTable.moveToNext());
        } finally {
            if (cursorBigSingleTable != null)
                cursorBigSingleTable.close();
        }
        return bigSingleTableList;
    }

    protected static List<MultiTable_01> getMultiTableList(SQLiteDatabase db, int num) {
        List<MultiTable_01> multiTableList = new ArrayList<>();
        SelectionBuilder selectionBuilder = new SelectionBuilder();
        Cursor c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null, c7 = null, c8 = null, c9 = null, c10 = null;
        try {
            c1 = selectionBuilder.table("MULTI_TABLE_01").query(db, null, null, null, null, String.valueOf(num));
            if (c1 == null || c1.getCount() < num)
                throw new ExceptionInInitializerError("Number entities is smaller than: " + num);

            MultiTable_02Dao table02Dao = new MultiTable_02Dao();
            MultiTable_03Dao table03Dao = new MultiTable_03Dao();
            MultiTable_04Dao table04Dao = new MultiTable_04Dao();
            MultiTable_05Dao table05Dao = new MultiTable_05Dao();
            MultiTable_06Dao table06Dao = new MultiTable_06Dao();
            MultiTable_07Dao table07Dao = new MultiTable_07Dao();
            MultiTable_08Dao table08Dao = new MultiTable_08Dao();
            MultiTable_09Dao table09Dao = new MultiTable_09Dao();
            MultiTable_10Dao table10Dao = new MultiTable_10Dao();

            c1.moveToFirst();
            do {
                MultiTable_01 table01 = (MultiTable_01) new MultiTable_01().fromCursor(c1);
                table01.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));

                c2 = table02Dao.selectById(db, c1.getLong(c1.getColumnIndexOrThrow(MultiTable_01Dao.MULTI_TABLE_02_ID)));
                c2.moveToFirst();
                MultiTable_02 table02 = (MultiTable_02) new MultiTable_02().fromCursor(c2);
                table02.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table01.setMultiTable_02(table02);

                c3 = table03Dao.selectById(db, c2.getLong(c2.getColumnIndexOrThrow(MultiTable_02Dao.MULTI_TABLE_03_ID)));
                c3.moveToFirst();
                c2.close();
                MultiTable_03 table03 = (MultiTable_03) new MultiTable_03().fromCursor(c3);
                table03.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table02.setMultiTable_03(table03);

                c4 = table04Dao.selectById(db, c3.getLong(c3.getColumnIndexOrThrow(MultiTable_03Dao.MULTI_TABLE_04_ID)));
                c4.moveToFirst();
                c3.close();
                MultiTable_04 table04 = (MultiTable_04) new MultiTable_04().fromCursor(c4);
                table04.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table03.setMultiTable_04(table04);

                c5 = table05Dao.selectById(db, c4.getLong(c4.getColumnIndexOrThrow(MultiTable_04Dao.MULTI_TABLE_05_ID)));
                c5.moveToFirst();
                c4.close();
                MultiTable_05 table05 = (MultiTable_05) new MultiTable_05().fromCursor(c5);
                table05.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table04.setMultiTable_05(table05);

                c6 = table06Dao.selectById(db, c5.getLong(c5.getColumnIndexOrThrow(MultiTable_05Dao.MULTI_TABLE_06_ID)));
                c6.moveToFirst();
                c5.close();
                MultiTable_06 table06 = (MultiTable_06) new MultiTable_06().fromCursor(c6);
                table06.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table05.setMultiTable_06(table06);

                c7 = table07Dao.selectById(db, c6.getLong(c6.getColumnIndexOrThrow(MultiTable_06Dao.MULTI_TABLE_07_ID)));
                c7.moveToFirst();
                c6.close();
                MultiTable_07 table07 = (MultiTable_07) new MultiTable_07().fromCursor(c7);
                table07.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table06.setMultiTable_07(table07);

                c8 = table08Dao.selectById(db, c7.getLong(c7.getColumnIndexOrThrow(MultiTable_07Dao.MULTI_TABLE_08_ID)));
                c8.moveToFirst();
                c7.close();
                MultiTable_08 table08 = (MultiTable_08) new MultiTable_08().fromCursor(c8);
                table08.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table07.setMultiTable_08(table08);

                c9 = table09Dao.selectById(db, c8.getLong(c8.getColumnIndexOrThrow(MultiTable_08Dao.MULTI_TABLE_09_ID)));
                c9.moveToFirst();
                c8.close();
                MultiTable_09 table09 = (MultiTable_09) new MultiTable_09().fromCursor(c9);
                table09.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table08.setMultiTable_09(table09);

                c10 = table10Dao.selectById(db, c9.getLong(c9.getColumnIndexOrThrow(MultiTable_09Dao.MULTI_TABLE_10_ID)));
                c10.moveToFirst();
                c9.close();
                MultiTable_10 table10 = (MultiTable_10) new MultiTable_10().fromCursor(c10);
                table10.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table09.setMultiTable_10(table10);
                c10.close();

                multiTableList.add(table01);
            } while (c1.moveToNext());

        } finally {
            if (c1 != null) c1.close();
            if (c2 != null) c2.close();
            if (c3 != null) c3.close();
            if (c4 != null) c4.close();
            if (c5 != null) c5.close();
            if (c6 != null) c6.close();
            if (c7 != null) c7.close();
            if (c8 != null) c8.close();
            if (c9 != null) c9.close();
            if (c10 != null) c10.close();
        }
        return multiTableList;
    }

    protected static List<TableWithRelationToMany> getTableToManyList(SQLiteDatabase db, int num) {
        List<TableWithRelationToMany> toManyList = new ArrayList<>();
        Cursor cursorToMany = null;
        Cursor cursorToOne = null;
        try {

            cursorToMany = new SelectionBuilder().table("TABLE_WITH_RELATION_TO_MANY").query(db, null, null, null, null, String.valueOf(num));
            if (cursorToMany == null || cursorToMany.getCount() < num)
                throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);

            cursorToMany.moveToFirst();
            do {
                TableWithRelationToMany tableToMany = (TableWithRelationToMany) new TableWithRelationToMany().fromCursor(cursorToMany);
                tableToMany.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                cursorToOne = new SelectionBuilder().table("TABLE_WITH_RELATION_TO_ONE")
                        .where(TableWithRelationToOneDao.TABLE_WITH_RELATION_TO_MANY_ID + " =? ", String.valueOf(tableToMany.getId()))
                        .query(db, null, null);

                List<TableWithRelationToOne> toOneList = new ArrayList<>();
                cursorToOne.moveToFirst();
                do {
                    TableWithRelationToOne tableToOne = (TableWithRelationToOne) new TableWithRelationToOne().fromCursor(cursorToOne);
                    tableToOne.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    tableToOne.setTableWithRelationToMany(tableToMany);
                    toOneList.add(tableToOne);
                } while (cursorToOne.moveToNext());
                cursorToOne.close();

                tableToMany.setTableWithRelationToOneList(toOneList);
                toManyList.add(tableToMany);
            } while (cursorToMany.moveToNext());
        } finally

        {
            if (cursorToMany != null) cursorToMany.close();
            if (cursorToOne != null) cursorToOne.close();
        }

        return toManyList;
    }

}
