package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;

import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

public class MultiTable_03 extends BaseSampleEntity {

    private MultiTable_04 multiTable_04;

    public MultiTable_03() {
    }

    public MultiTable_03(long id) {
        super(id);
    }

    public MultiTable_03(long id, String sampleStringColl01, String sampleStringColl02, String sampleStringColl03, String sampleStringColl04, String sampleStringColl05,
                         String sampleStringColl06, String sampleStringColl07, String sampleStringColl08, String sampleStringColl09, String sampleStringColl10,
                         int sampleIntColl01, Integer sampleIntColl02, Double sampleRealColl01, Double sampleRealColl02, Integer sampleIntCollIndexed, MultiTable_04 MultiTable_04) {

        super(id, sampleStringColl01, sampleStringColl02, sampleStringColl03, sampleStringColl04, sampleStringColl05,
                sampleStringColl06, sampleStringColl07, sampleStringColl08, sampleStringColl09, sampleStringColl10,
                sampleIntColl01, sampleIntColl02, sampleRealColl01, sampleRealColl02, sampleIntCollIndexed);

        this.multiTable_04 = MultiTable_04;
    }

    public static MultiTable_03 getNewEntityWithRandomData(int range) {
        return getNewEntityWithRandomData(null, range);
    }

    public static MultiTable_03 getNewEntityWithRandomData(Long id, int range) {
        MultiTable_03 table = new MultiTable_03();
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
        EntityFieldGeneratorUtils generatorUtils = EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.RAW_SQL_ENTITY_FIELD_GENERATOR_ID + 3, range);
        table.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());
        table.setMultiTable_04(MultiTable_04.getNewEntityWithRandomData(table.getId(), generatorUtils.getUniqueNumberRange()));
        return table;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = super.getContentValues();
        values.put(MultiTable_03Dao.MULTI_TABLE_04_ID, multiTable_04.getId());

        return values;
    }

    public MultiTable_04 getMultiTable_04() {
        return multiTable_04;
    }

    public void setMultiTable_04(MultiTable_04 MultiTable_04) {
        this.multiTable_04 = MultiTable_04;
    }
}
