package pl.gombal.orm_benchmarks.io.activeandroid;


import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

import pl.gombal.orm_benchmarks.io.activeandroid.entity.BigSingleTable;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_01;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_02;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_03;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_04;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_05;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_06;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_07;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_08;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_09;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_10;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.SingleTable;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.TableWithRelationToMany;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.TableWithRelationToOne;
import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

public class ActiveAndroidBenchmarkTaskHelper {

    public static List<SingleTable> getSingleTableListToUpdate(int num) {
        List<SingleTable> tableList = new Select().from(SingleTable.class).limit(num).execute();
        for (SingleTable table : tableList) {
            table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
        }
        return tableList;
    }

    public static List<BigSingleTable> getBigSingleTableListToUpdate(int num) {
        List<BigSingleTable> tableList = new Select().from(BigSingleTable.class).limit(num).execute();
        for (BigSingleTable table : tableList) {
            table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
        }
        return tableList;
    }

    public static List<MultiTable_01> getMultiTableListToUpdate(int num) {
        List<MultiTable_01> tableList = new Select().from(MultiTable_01.class).limit(num).execute();
        for (MultiTable_01 table01 : tableList) {
            MultiTable_02 table02 = table01.getMultiTable_02();
            MultiTable_03 table03 = table02.getMultiTable_03();
            MultiTable_04 table04 = table03.getMultiTable_04();
            MultiTable_05 table05 = table04.getMultiTable_05();
            MultiTable_06 table06 = table05.getMultiTable_06();
            MultiTable_07 table07 = table06.getMultiTable_07();
            MultiTable_08 table08 = table07.getMultiTable_08();
            MultiTable_09 table09 = table08.getMultiTable_09();
            MultiTable_10 table10 = table09.getMultiTable_10();

            table01.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
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

    public static List<TableWithRelationToMany> getTableToManyListToUpdate(int num) {
        List<TableWithRelationToMany> tableList = new Select().from(TableWithRelationToMany.class).limit(num).execute();
        for (TableWithRelationToMany table : tableList)
            table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
        return tableList;
    }

    public static List<TableWithRelationToOne> getTableToOneListToUpdate(List<TableWithRelationToMany> tableList) {
        List<TableWithRelationToOne> tableToOneList = new ArrayList<>();
        for (TableWithRelationToMany table : tableList)
            for (TableWithRelationToOne tableToOne : table.getTableWithRelationToOneList()) {
                tableToOne.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                tableToOneList.add(tableToOne);
            }
        return tableToOneList;
    }

}
