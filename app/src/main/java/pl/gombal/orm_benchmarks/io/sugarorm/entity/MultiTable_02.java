package pl.gombal.orm_benchmarks.io.sugarorm.entity;


import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

public class MultiTable_02 extends BaseSampleEntity {

    private MultiTable_03 multiTable_03;

    public MultiTable_02() {

    }

    public static MultiTable_02 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, generatorUtils);
    }

    public static MultiTable_02 getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_02 table = new MultiTable_02();
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

        EntityFieldGeneratorUtils generatorUtilsTab03 =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.SUGAR_ORM_ENTITY_FIELD_GENERATOR_ID + 3, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_03(MultiTable_03.getNewEntityWithRandomData(table.getId(), generatorUtilsTab03));

        return table;
    }

    public MultiTable_03 getMultiTable_03() {
        return multiTable_03;
    }

    public void setMultiTable_03(MultiTable_03 multiTable_03) {
        this.multiTable_03 = multiTable_03;
    }
}
