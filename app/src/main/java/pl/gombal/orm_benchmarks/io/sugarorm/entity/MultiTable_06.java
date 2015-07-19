package pl.gombal.orm_benchmarks.io.sugarorm.entity;


import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

public class MultiTable_06 extends BaseSampleEntity {

    private MultiTable_07 multiTable_07;

    public MultiTable_06() {

    }

    public static MultiTable_06 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, generatorUtils);
    }

    public static MultiTable_06 getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_06 table = new MultiTable_06();
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

        EntityFieldGeneratorUtils generatorUtilsTab07 =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.SUGAR_ORM_ENTITY_FIELD_GENERATOR_ID + 7, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_07(MultiTable_07.getNewEntityWithRandomData(table.getId(), generatorUtilsTab07));

        return table;
    }

    public MultiTable_07 getMultiTable_07() {
        return multiTable_07;
    }

    public void setMultiTable_07(MultiTable_07 multiTable_07) {
        this.multiTable_07 = multiTable_07;
    }
}
