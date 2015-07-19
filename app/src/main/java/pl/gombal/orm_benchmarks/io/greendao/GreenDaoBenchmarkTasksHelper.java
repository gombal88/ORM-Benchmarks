package pl.gombal.orm_benchmarks.io.greendao;


import java.util.ArrayList;
import java.util.List;

import pl.gombal.orm_benchmarks.io.greendao.entity.BigSingleTable;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_01;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_02;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_03;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_04;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_05;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_06;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_07;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_08;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_09;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_10;
import pl.gombal.orm_benchmarks.io.greendao.entity.SingleTable;
import pl.gombal.orm_benchmarks.io.greendao.entity.TableWithRelationToMany;
import pl.gombal.orm_benchmarks.io.greendao.entity.TableWithRelationToOne;
import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

public class GreenDaoBenchmarkTasksHelper {

    protected static SingleTable getNewSingleTable(EntityFieldGeneratorUtils generatorUtils) {
        SingleTable singleTable = new SingleTable();
        singleTable.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        singleTable.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        singleTable.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        singleTable.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        singleTable.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());
        return singleTable;
    }

    protected static BigSingleTable getNewBigSingleTable(EntityFieldGeneratorUtils generatorUtils) {
        BigSingleTable bigSingleTable = new BigSingleTable();
        bigSingleTable.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        bigSingleTable.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        bigSingleTable.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        bigSingleTable.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        bigSingleTable.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());

        bigSingleTable.setExtraSmplStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl11(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl12(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl13(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl14(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl15(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl16(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl17(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl18(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl19(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl20(EntityFieldGeneratorUtils.getRandomString(20));

        bigSingleTable.setExtraSmplDoubleColl01(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl02(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl03(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl04(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl05(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl06(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl07(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl08(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl09(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl10(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl11(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl12(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl13(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl14(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl15(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl16(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl17(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl18(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl19(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl20(EntityFieldGeneratorUtils.getRandomDouble(20));

        return bigSingleTable;
    }

    protected static MultiTable_01 getNewMultiTableWithRelationToOne(long id, EntityFieldGeneratorUtils generatorUtils, int num) {

        MultiTable_10 multiTable_10 = new MultiTable_10(id);
        multiTable_10.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_10.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_10.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_10.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_10.setSampleIntCollIndexed(EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.GREEN_DAO_ENTITY_FIELD_GENERATOR_ID + 10, num).getNextUniqueRandomInt());

        MultiTable_09 multiTable_09 = new MultiTable_09(id);
        multiTable_09.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_09.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_09.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_09.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_09.setSampleIntCollIndexed(EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.GREEN_DAO_ENTITY_FIELD_GENERATOR_ID + 9, num).getNextUniqueRandomInt());
        multiTable_09.setMultiTable_10(multiTable_10);
        multiTable_09.setMultiTable_10Id(id);

        MultiTable_08 multiTable_08 = new MultiTable_08(id);
        multiTable_08.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_08.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_08.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_08.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_08.setSampleIntCollIndexed(EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.GREEN_DAO_ENTITY_FIELD_GENERATOR_ID + 8, num).getNextUniqueRandomInt());
        multiTable_08.setMultiTable_09(multiTable_09);
        multiTable_08.setMultiTable_09Id(id);

        MultiTable_07 multiTable_07 = new MultiTable_07(id);
        multiTable_07.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_07.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_07.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_07.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_07.setSampleIntCollIndexed(EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.GREEN_DAO_ENTITY_FIELD_GENERATOR_ID + 7, num).getNextUniqueRandomInt());
        multiTable_07.setMultiTable_08(multiTable_08);
        multiTable_07.setMultiTable_08Id(id);

        MultiTable_06 multiTable_06 = new MultiTable_06(id);
        multiTable_06.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_06.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_06.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_06.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_06.setSampleIntCollIndexed(EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.GREEN_DAO_ENTITY_FIELD_GENERATOR_ID + 6, num).getNextUniqueRandomInt());
        multiTable_06.setMultiTable_07(multiTable_07);
        multiTable_06.setMultiTable_07Id(id);

        MultiTable_05 multiTable_05 = new MultiTable_05(id);
        multiTable_05.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_05.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_05.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_05.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_05.setSampleIntCollIndexed(EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.GREEN_DAO_ENTITY_FIELD_GENERATOR_ID + 5, num).getNextUniqueRandomInt());
        multiTable_05.setMultiTable_06(multiTable_06);
        multiTable_05.setMultiTable_06Id(id);

        MultiTable_04 multiTable_04 = new MultiTable_04(id);
        multiTable_04.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_04.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_04.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_04.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_04.setSampleIntCollIndexed(EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.GREEN_DAO_ENTITY_FIELD_GENERATOR_ID + 4, num).getNextUniqueRandomInt());
        multiTable_04.setMultiTable_05(multiTable_05);
        multiTable_04.setMultiTable_05Id(id);

        MultiTable_03 multiTable_03 = new MultiTable_03(id);
        multiTable_03.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_03.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_03.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_03.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_03.setSampleIntCollIndexed(EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.GREEN_DAO_ENTITY_FIELD_GENERATOR_ID + 3, num).getNextUniqueRandomInt());
        multiTable_03.setMultiTable_04(multiTable_04);
        multiTable_03.setMultiTable_04Id(id);

        MultiTable_02 multiTable_02 = new MultiTable_02(id);
        multiTable_02.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_02.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_02.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_02.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_02.setSampleIntCollIndexed(EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.GREEN_DAO_ENTITY_FIELD_GENERATOR_ID + 2, num).getNextUniqueRandomInt());
        multiTable_02.setMultiTable_03(multiTable_03);
        multiTable_02.setMultiTable_03Id(id);

        MultiTable_01 multiTable_01 = new MultiTable_01(id);
        multiTable_01.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_01.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_01.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_01.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_01.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());
        multiTable_01.setMultiTable_02(multiTable_02);
        multiTable_01.setMultiTable_02Id(id);

        return multiTable_01;
    }

    protected static TableWithRelationToMany getNewTableWithRelationToMany(long id, EntityFieldGeneratorUtils generatorUtils) {

        TableWithRelationToMany relationToMany = new TableWithRelationToMany(id);
        relationToMany.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        relationToMany.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        relationToMany.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        relationToMany.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        relationToMany.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());

        return relationToMany;
    }

    protected static List<TableWithRelationToOne> getNewTableWithRelationToOneList(long parentTableID, int parentCount, int count) {

        List<TableWithRelationToOne> tableWithRelationToOneList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            TableWithRelationToOne relationToOne = new TableWithRelationToOne();
            relationToOne.setTableWithRelationToManyId(parentTableID);
            relationToOne.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
            relationToOne.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
            relationToOne.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
            relationToOne.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
            EntityFieldGeneratorUtils generatorUtils = EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.GREEN_DAO_ENTITY_FIELD_GENERATOR_ID + 50, parentCount * count);
            relationToOne.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());

            tableWithRelationToOneList.add(relationToOne);
        }

        return tableWithRelationToOneList;
    }

}
