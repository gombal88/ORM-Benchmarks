package pl.gombal.orm_benchmarks.io.sqlite;


import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

import pl.gombal.orm_benchmarks.io.sqlite.entity.BaseSampleDao;
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
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToMany;
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToOne;
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToOneDao;
import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

public class SQLiteBenchmarkTasksHelper {

    protected static List<SingleTable> getSingleTableList(SQLiteOpenHelper dbOpenHelper, int num) {
        List<SingleTable> singleTableList = new ArrayList<>();
        Cursor cursorSingleTable = null;

        try {
            cursorSingleTable = new SelectionBuilder().table("SINGLE_TABLE")
                    .query(dbOpenHelper.getWritableDatabase(), null, null, null, null, String.valueOf(num));
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

    protected static List<BigSingleTable> getBigSingleTableList(SQLiteOpenHelper dbOpenHelper, int num) {
        List<BigSingleTable> bigSingleTableList = new ArrayList<>();
        Cursor cursorBigSingleTable = null;

        try {
            cursorBigSingleTable = new SelectionBuilder().table("BIG_SINGLE_TABLE")
                    .query(dbOpenHelper.getWritableDatabase(), null, null, null, null, String.valueOf(num));
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

    protected static List<MultiTable_01> getMultiTableList(SQLiteOpenHelper dbOpenHelper, int num) {
        List<MultiTable_01> multiTableList = new ArrayList<>();
        SelectionBuilder selectionBuilder = new SelectionBuilder();
        Cursor c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null, c7 = null, c8 = null, c9 = null, c10 = null;
        try {
            c1 = selectionBuilder.table("MULTI_TABLE_01")
                    .query(dbOpenHelper.getWritableDatabase(), null, null, null, null, String.valueOf(num));
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

                c2 = table02Dao.selectById(dbOpenHelper, c1.getLong(c1.getColumnIndexOrThrow(MultiTable_01Dao.MULTI_TABLE_02_ID)));
                c2.moveToFirst();
                MultiTable_02 table02 = (MultiTable_02) new MultiTable_02().fromCursor(c2);
                table02.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table01.setMultiTable_02(table02);

                c3 = table03Dao.selectById(dbOpenHelper, c2.getLong(c2.getColumnIndexOrThrow(MultiTable_02Dao.MULTI_TABLE_03_ID)));
                c3.moveToFirst();
                MultiTable_03 table03 = (MultiTable_03) new MultiTable_03().fromCursor(c3);
                table03.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table02.setMultiTable_03(table03);

                c4 = table04Dao.selectById(dbOpenHelper, c3.getLong(c3.getColumnIndexOrThrow(MultiTable_03Dao.MULTI_TABLE_04_ID)));
                c4.moveToFirst();
                MultiTable_04 table04 = (MultiTable_04) new MultiTable_04().fromCursor(c4);
                table04.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table03.setMultiTable_04(table04);

                c5 = table05Dao.selectById(dbOpenHelper, c4.getLong(c4.getColumnIndexOrThrow(MultiTable_04Dao.MULTI_TABLE_05_ID)));
                c5.moveToFirst();
                MultiTable_05 table05 = (MultiTable_05) new MultiTable_05().fromCursor(c5);
                table05.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table04.setMultiTable_05(table05);

                c6 = table06Dao.selectById(dbOpenHelper, c5.getLong(c5.getColumnIndexOrThrow(MultiTable_05Dao.MULTI_TABLE_06_ID)));
                c6.moveToFirst();
                MultiTable_06 table06 = (MultiTable_06) new MultiTable_06().fromCursor(c6);
                table06.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table05.setMultiTable_06(table06);

                c7 = table07Dao.selectById(dbOpenHelper, c6.getLong(c6.getColumnIndexOrThrow(MultiTable_06Dao.MULTI_TABLE_07_ID)));
                c7.moveToFirst();
                MultiTable_07 table07 = (MultiTable_07) new MultiTable_07().fromCursor(c7);
                table07.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table06.setMultiTable_07(table07);

                c8 = table08Dao.selectById(dbOpenHelper, c7.getLong(c7.getColumnIndexOrThrow(MultiTable_07Dao.MULTI_TABLE_08_ID)));
                c8.moveToFirst();
                MultiTable_08 table08 = (MultiTable_08) new MultiTable_08().fromCursor(c8);
                table08.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table07.setMultiTable_08(table08);

                c9 = table09Dao.selectById(dbOpenHelper, c8.getLong(c8.getColumnIndexOrThrow(MultiTable_08Dao.MULTI_TABLE_09_ID)));
                c9.moveToFirst();
                MultiTable_09 table09 = (MultiTable_09) new MultiTable_09().fromCursor(c9);
                table09.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table08.setMultiTable_09(table09);

                c10 = table10Dao.selectById(dbOpenHelper, c9.getLong(c9.getColumnIndexOrThrow(MultiTable_09Dao.MULTI_TABLE_10_ID)));
                c10.moveToFirst();
                MultiTable_10 table10 = (MultiTable_10) new MultiTable_10().fromCursor(c10);
                table10.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                table09.setMultiTable_10(table10);

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

    protected static List<TableWithRelationToMany> getTableToManyList(SQLiteOpenHelper dbOpenHelper, int num) {
        List<TableWithRelationToMany> toManyList = new ArrayList<>();
        Cursor cursorToMany = null;
        Cursor cursorToOne = null;
        try {

            cursorToMany = new SelectionBuilder().table("TABLE_WITH_RELATION_TO_MANY")
                    .query(dbOpenHelper.getWritableDatabase(), null, null, null, null, String.valueOf(num));
            if (cursorToMany == null || cursorToMany.getCount() < num)
                throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);

            cursorToMany.moveToFirst();
            do {
                TableWithRelationToMany tableToMany = (TableWithRelationToMany) new TableWithRelationToMany().fromCursor(cursorToMany);
                tableToMany.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                cursorToOne = new SelectionBuilder().table("TABLE_WITH_RELATION_TO_ONE")
                        .where(TableWithRelationToOneDao.TABLE_WITH_RELATION_TO_MANY_ID + " =? ", String.valueOf(tableToMany.getId()))
                        .query(dbOpenHelper.getWritableDatabase(), null, null);

                List<TableWithRelationToOne> toOneList = new ArrayList<>();
                cursorToOne.moveToFirst();
                do {
                    TableWithRelationToOne tableToOne = (TableWithRelationToOne) new TableWithRelationToOne().fromCursor(cursorToOne);
                    tableToOne.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    tableToOne.setTableWithRelationToMany(tableToMany);
                    toOneList.add(tableToOne);
                } while (cursorToOne.moveToNext());

                tableToMany.setTableWithRelationToOneList(toOneList);
                toManyList.add(tableToMany);
            } while (cursorToMany.moveToNext());
        } finally

        {
            if (cursorToMany != null)
                cursorToMany.close();
            if (cursorToOne != null)
                cursorToOne.close();
        }

        return toManyList;
    }

    protected static void mapCursorToSingleTable(Cursor cursor) {
        List<SingleTable> tableList = new ArrayList<>();

        int idIndex = cursor.getColumnIndexOrThrow(BaseColumns._ID);
        int sampleStringColl01Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_01);
        int sampleStringColl02Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_02);
        int sampleStringColl03Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_03);
        int sampleStringColl04Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_04);
        int sampleStringColl05Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_05);
        int sampleStringColl06Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_06);
        int sampleStringColl07Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_07);
        int sampleStringColl08Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_08);
        int sampleStringColl09Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_09);
        int sampleStringColl10Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_10);
        int sampleIntColl01Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_INT_COLL_01);
        int sampleIntColl02Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_INT_COLL_02);
        int sampleRealColl01Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_REAL_COLL_01);
        int sampleRealColl02Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_REAL_COLL_02);
        int sampleIntCollIndexedIndex = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_INT_COLL_INDEXED);

        while (cursor.moveToNext()) {
            SingleTable singleTable = new SingleTable();
            singleTable.setId(cursor.getLong(idIndex));
            singleTable.setSampleStringColl01(cursor.getString(sampleStringColl01Index));
            singleTable.setSampleStringColl02(cursor.getString(sampleStringColl02Index));
            singleTable.setSampleStringColl03(cursor.getString(sampleStringColl03Index));
            singleTable.setSampleStringColl04(cursor.getString(sampleStringColl04Index));
            singleTable.setSampleStringColl05(cursor.getString(sampleStringColl05Index));
            singleTable.setSampleStringColl06(cursor.getString(sampleStringColl06Index));
            singleTable.setSampleStringColl07(cursor.getString(sampleStringColl07Index));
            singleTable.setSampleStringColl08(cursor.getString(sampleStringColl08Index));
            singleTable.setSampleStringColl09(cursor.getString(sampleStringColl09Index));
            singleTable.setSampleStringColl10(cursor.getString(sampleStringColl10Index));
            singleTable.setSampleIntColl01(cursor.getInt(sampleIntColl01Index));
            singleTable.setSampleIntColl02(cursor.getInt(sampleIntColl02Index));
            singleTable.setSampleRealColl01(cursor.getDouble(sampleRealColl01Index));
            singleTable.setSampleRealColl02(cursor.getDouble(sampleRealColl02Index));
            singleTable.setSampleIntCollIndexed(cursor.getInt(sampleIntCollIndexedIndex));
            tableList.add(singleTable);
        }
    }

    protected static void mapCursorToBigSingleTable(Cursor cursor) {
        List<BigSingleTable> tableList = new ArrayList<>();

        int idIndex = cursor.getColumnIndexOrThrow(BaseColumns._ID);
        int sampleStringColl01Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_01);
        int sampleStringColl02Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_02);
        int sampleStringColl03Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_03);
        int sampleStringColl04Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_04);
        int sampleStringColl05Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_05);
        int sampleStringColl06Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_06);
        int sampleStringColl07Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_07);
        int sampleStringColl08Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_08);
        int sampleStringColl09Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_09);
        int sampleStringColl10Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_STRING_COLL_10);
        int sampleIntColl01Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_INT_COLL_01);
        int sampleIntColl02Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_INT_COLL_02);
        int sampleRealColl01Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_REAL_COLL_01);
        int sampleRealColl02Index = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_REAL_COLL_02);
        int sampleIntCollIndexedIndex = cursor.getColumnIndexOrThrow(BaseSampleDao.SAMPLE_INT_COLL_INDEXED);

        int extraSmplStringColl01Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_01);
        int extraSmplStringColl02Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_02);
        int extraSmplStringColl03Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_03);
        int extraSmplStringColl04Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_04);
        int extraSmplStringColl05Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_05);
        int extraSmplStringColl06Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_06);
        int extraSmplStringColl07Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_07);
        int extraSmplStringColl08Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_08);
        int extraSmplStringColl09Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_09);
        int extraSmplStringColl10Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_10);
        int extraSmplStringColl11Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_11);
        int extraSmplStringColl12Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_12);
        int extraSmplStringColl13Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_13);
        int extraSmplStringColl14Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_14);
        int extraSmplStringColl15Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_15);
        int extraSmplStringColl16Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_16);
        int extraSmplStringColl17Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_17);
        int extraSmplStringColl18Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_18);
        int extraSmplStringColl19Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_19);
        int extraSmplStringColl20Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_20);

        int extraSmplDoubleColl01Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_01);
        int extraSmplDoubleColl02Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_02);
        int extraSmplDoubleColl03Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_03);
        int extraSmplDoubleColl04Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_04);
        int extraSmplDoubleColl05Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_05);
        int extraSmplDoubleColl06Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_06);
        int extraSmplDoubleColl07Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_07);
        int extraSmplDoubleColl08Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_08);
        int extraSmplDoubleColl09Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_09);
        int extraSmplDoubleColl10Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_10);
        int extraSmplDoubleColl11Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_11);
        int extraSmplDoubleColl12Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_12);
        int extraSmplDoubleColl13Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_13);
        int extraSmplDoubleColl14Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_14);
        int extraSmplDoubleColl15Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_15);
        int extraSmplDoubleColl16Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_16);
        int extraSmplDoubleColl17Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_17);
        int extraSmplDoubleColl18Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_18);
        int extraSmplDoubleColl19Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_19);
        int extraSmplDoubleColl20Index = cursor.getColumnIndexOrThrow(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_20);

        while (cursor.moveToNext()) {
            BigSingleTable table = new BigSingleTable();
            table.setId(cursor.getLong(idIndex));
            table.setSampleStringColl01(cursor.getString(sampleStringColl01Index));
            table.setSampleStringColl02(cursor.getString(sampleStringColl02Index));
            table.setSampleStringColl03(cursor.getString(sampleStringColl03Index));
            table.setSampleStringColl04(cursor.getString(sampleStringColl04Index));
            table.setSampleStringColl05(cursor.getString(sampleStringColl05Index));
            table.setSampleStringColl06(cursor.getString(sampleStringColl06Index));
            table.setSampleStringColl07(cursor.getString(sampleStringColl07Index));
            table.setSampleStringColl08(cursor.getString(sampleStringColl08Index));
            table.setSampleStringColl09(cursor.getString(sampleStringColl09Index));
            table.setSampleStringColl10(cursor.getString(sampleStringColl10Index));
            table.setSampleIntColl01(cursor.getInt(sampleIntColl01Index));
            table.setSampleIntColl02(cursor.getInt(sampleIntColl02Index));
            table.setSampleRealColl01(cursor.getDouble(sampleRealColl01Index));
            table.setSampleRealColl02(cursor.getDouble(sampleRealColl02Index));
            table.setSampleIntCollIndexed(cursor.getInt(sampleIntCollIndexedIndex));

            table.setExtraSmplStringColl01(cursor.getString(extraSmplStringColl01Index));
            table.setExtraSmplStringColl02(cursor.getString(extraSmplStringColl02Index));
            table.setExtraSmplStringColl03(cursor.getString(extraSmplStringColl03Index));
            table.setExtraSmplStringColl04(cursor.getString(extraSmplStringColl04Index));
            table.setExtraSmplStringColl05(cursor.getString(extraSmplStringColl05Index));
            table.setExtraSmplStringColl06(cursor.getString(extraSmplStringColl06Index));
            table.setExtraSmplStringColl07(cursor.getString(extraSmplStringColl07Index));
            table.setExtraSmplStringColl08(cursor.getString(extraSmplStringColl08Index));
            table.setExtraSmplStringColl09(cursor.getString(extraSmplStringColl09Index));
            table.setExtraSmplStringColl10(cursor.getString(extraSmplStringColl10Index));
            table.setExtraSmplStringColl11(cursor.getString(extraSmplStringColl11Index));
            table.setExtraSmplStringColl12(cursor.getString(extraSmplStringColl12Index));
            table.setExtraSmplStringColl13(cursor.getString(extraSmplStringColl13Index));
            table.setExtraSmplStringColl14(cursor.getString(extraSmplStringColl14Index));
            table.setExtraSmplStringColl15(cursor.getString(extraSmplStringColl15Index));
            table.setExtraSmplStringColl16(cursor.getString(extraSmplStringColl16Index));
            table.setExtraSmplStringColl17(cursor.getString(extraSmplStringColl17Index));
            table.setExtraSmplStringColl18(cursor.getString(extraSmplStringColl18Index));
            table.setExtraSmplStringColl19(cursor.getString(extraSmplStringColl19Index));
            table.setExtraSmplStringColl20(cursor.getString(extraSmplStringColl20Index));

            table.setExtraSmplDoubleColl01(cursor.getDouble(extraSmplDoubleColl01Index));
            table.setExtraSmplDoubleColl02(cursor.getDouble(extraSmplDoubleColl02Index));
            table.setExtraSmplDoubleColl03(cursor.getDouble(extraSmplDoubleColl03Index));
            table.setExtraSmplDoubleColl04(cursor.getDouble(extraSmplDoubleColl04Index));
            table.setExtraSmplDoubleColl05(cursor.getDouble(extraSmplDoubleColl05Index));
            table.setExtraSmplDoubleColl06(cursor.getDouble(extraSmplDoubleColl06Index));
            table.setExtraSmplDoubleColl07(cursor.getDouble(extraSmplDoubleColl07Index));
            table.setExtraSmplDoubleColl08(cursor.getDouble(extraSmplDoubleColl08Index));
            table.setExtraSmplDoubleColl09(cursor.getDouble(extraSmplDoubleColl09Index));
            table.setExtraSmplDoubleColl10(cursor.getDouble(extraSmplDoubleColl10Index));
            table.setExtraSmplDoubleColl11(cursor.getDouble(extraSmplDoubleColl11Index));
            table.setExtraSmplDoubleColl12(cursor.getDouble(extraSmplDoubleColl12Index));
            table.setExtraSmplDoubleColl13(cursor.getDouble(extraSmplDoubleColl13Index));
            table.setExtraSmplDoubleColl14(cursor.getDouble(extraSmplDoubleColl14Index));
            table.setExtraSmplDoubleColl15(cursor.getDouble(extraSmplDoubleColl15Index));
            table.setExtraSmplDoubleColl16(cursor.getDouble(extraSmplDoubleColl16Index));
            table.setExtraSmplDoubleColl17(cursor.getDouble(extraSmplDoubleColl17Index));
            table.setExtraSmplDoubleColl18(cursor.getDouble(extraSmplDoubleColl18Index));
            table.setExtraSmplDoubleColl19(cursor.getDouble(extraSmplDoubleColl19Index));
            table.setExtraSmplDoubleColl20(cursor.getDouble(extraSmplDoubleColl20Index));
            tableList.add(table);
        }
    }

}
