package pl.gombal.orm_benchmarks.io.ormlite;


import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.gombal.orm_benchmarks.io.ormlite.entity.BigSingleTable;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_01;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_02;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_03;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_04;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_05;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_06;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_07;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_08;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_09;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_10;
import pl.gombal.orm_benchmarks.io.ormlite.entity.SingleTable;
import pl.gombal.orm_benchmarks.io.ormlite.entity.TableWithRelationToMany;
import pl.gombal.orm_benchmarks.io.ormlite.entity.TableWithRelationToOne;
import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

public class ORMLiteBenchmarkTasksHelper {

    protected static List<SingleTable> getSingleTableListToUpdate(long num) throws SQLException {
        Dao<SingleTable, Long> dao = new ORMLiteDao<SingleTable, Long>(SingleTable.class).getDao();
        List<SingleTable> tableList = dao.queryBuilder().limit(num).query();
        for (SingleTable table : tableList) {
            table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
        }
        return tableList;
    }

    protected static List<BigSingleTable> getBigSingleTableListToUpdate(long num) throws SQLException {
        Dao<BigSingleTable, Long> dao = new ORMLiteDao<BigSingleTable, Long>(BigSingleTable.class).getDao();
        List<BigSingleTable> tableList = dao.queryBuilder().limit(num).query();
        for (BigSingleTable table : tableList) {
            table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
        }
        return tableList;
    }

    protected static List<MultiTable_01> getMultiTableListToUpdate(long num) throws SQLException {
        Dao<MultiTable_01, Long> toOneDao01 = new ORMLiteDao<MultiTable_01, Long>(MultiTable_01.class).getDao();
        Dao<MultiTable_02, Long> toOneDao02 = new ORMLiteDao<MultiTable_02, Long>(MultiTable_02.class).getDao();
        Dao<MultiTable_03, Long> toOneDao03 = new ORMLiteDao<MultiTable_03, Long>(MultiTable_03.class).getDao();
        Dao<MultiTable_04, Long> toOneDao04 = new ORMLiteDao<MultiTable_04, Long>(MultiTable_04.class).getDao();
        Dao<MultiTable_05, Long> toOneDao05 = new ORMLiteDao<MultiTable_05, Long>(MultiTable_05.class).getDao();
        Dao<MultiTable_06, Long> toOneDao06 = new ORMLiteDao<MultiTable_06, Long>(MultiTable_06.class).getDao();
        Dao<MultiTable_07, Long> toOneDao07 = new ORMLiteDao<MultiTable_07, Long>(MultiTable_07.class).getDao();
        Dao<MultiTable_08, Long> toOneDao08 = new ORMLiteDao<MultiTable_08, Long>(MultiTable_08.class).getDao();
        Dao<MultiTable_09, Long> toOneDao09 = new ORMLiteDao<MultiTable_09, Long>(MultiTable_09.class).getDao();
        Dao<MultiTable_10, Long> toOneDao10 = new ORMLiteDao<MultiTable_10, Long>(MultiTable_10.class).getDao();

        List<MultiTable_01> tableList = toOneDao01.queryBuilder().limit(num).query();

        for (MultiTable_01 table : tableList) {
            MultiTable_02 table02 = table.getMultiTable_02();
            toOneDao02.refresh(table02);
            MultiTable_03 table03 = table02.getMultiTable_03();
            toOneDao03.refresh(table03);
            MultiTable_04 table04 = table03.getMultiTable_04();
            toOneDao04.refresh(table04);
            MultiTable_05 table05 = table04.getMultiTable_05();
            toOneDao05.refresh(table05);
            MultiTable_06 table06 = table05.getMultiTable_06();
            toOneDao06.refresh(table06);
            MultiTable_07 table07 = table06.getMultiTable_07();
            toOneDao07.refresh(table07);
            MultiTable_08 table08 = table07.getMultiTable_08();
            toOneDao08.refresh(table08);
            MultiTable_09 table09 = table08.getMultiTable_09();
            toOneDao09.refresh(table09);
            MultiTable_10 table10 = table09.getMultiTable_10();
            toOneDao10.refresh(table10);

            table.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
            table02.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
            table03.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
            table04.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
            table05.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
            table06.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
            table07.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
            table08.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
            table09.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
            table10.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
        }
        return tableList;
    }

    protected static List<TableWithRelationToMany> getTableToManyListToUpdate(long num) throws SQLException {
        Dao<TableWithRelationToMany, Long> dao = new ORMLiteDao<TableWithRelationToMany, Long>(TableWithRelationToMany.class).getDao();
        List<TableWithRelationToMany> tableList = dao.queryBuilder().limit(num).query();
        for (TableWithRelationToMany table : tableList) {
            table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
            List<TableWithRelationToOne> toOneList = new ArrayList<>();
            for (TableWithRelationToOne tableToOne : table.getTableWithRelationToOneList()) {
                tableToOne.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                toOneList.add(tableToOne);
            }
            table.getTableWithRelationToOneList().clear();
            for (TableWithRelationToOne tableToOne : toOneList) {
                table.getTableWithRelationToOneList().add(tableToOne);
            }
        }
        return tableList;
    }
}
