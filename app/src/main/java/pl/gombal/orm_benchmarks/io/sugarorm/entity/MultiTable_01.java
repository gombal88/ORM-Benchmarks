package pl.gombal.orm_benchmarks.io.sugarorm.entity;


import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

public class MultiTable_01 extends BaseSampleEntity {

    private MultiTable_02 multiTable_02;

    public MultiTable_01() {

    }

    public static MultiTable_01 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, generatorUtils);
    }

    public static MultiTable_01 getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_01 table = new MultiTable_01();
        if (id != null)
            table.setId(id);
        table.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        table.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        table.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        table.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));

        EntityFieldGeneratorUtils generatorUtilsTab02 =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.SUGAR_ORM_ENTITY_FIELD_GENERATOR_ID + 2, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_02(MultiTable_02.getNewEntityWithRandomData(table.getId(), generatorUtilsTab02));
        return table;
    }

    public MultiTable_02 getMultiTable_02() {
        return multiTable_02;
    }

    public void setMultiTable_02(MultiTable_02 multiTable_02) {
        this.multiTable_02 = multiTable_02;
    }
}
