package pl.gombal.orm_benchmarks.io.sugarorm.entity;


import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

public class MultiTable_05 extends BaseSampleEntity {

    private MultiTable_06 multiTable_06;

    public MultiTable_05() {

    }

    public static MultiTable_05 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, generatorUtils);
    }

    public static MultiTable_05 getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_05 table = new MultiTable_05();
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

        EntityFieldGeneratorUtils generatorUtilsTab06 =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.SUGAR_ORM_ENTITY_FIELD_GENERATOR_ID + 6, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_06(MultiTable_06.getNewEntityWithRandomData(table.getId(), generatorUtilsTab06));

        return table;
    }

    public MultiTable_06 getMultiTable_06() {
        return multiTable_06;
    }

    public void setMultiTable_06(MultiTable_06 multiTable_06) {
        this.multiTable_06 = multiTable_06;
    }
}
