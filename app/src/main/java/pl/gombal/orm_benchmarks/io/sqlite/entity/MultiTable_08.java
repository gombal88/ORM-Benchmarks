package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;

import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

public class MultiTable_08 extends BaseSampleEntity {

    private MultiTable_09 multiTable_09;

    public MultiTable_08() {
    }

    public MultiTable_08(long id) {
        super(id);
    }

    public MultiTable_08(long id, String sampleStringColl01, String sampleStringColl02, String sampleStringColl03, String sampleStringColl04, String sampleStringColl05,
                         String sampleStringColl06, String sampleStringColl07, String sampleStringColl08, String sampleStringColl09, String sampleStringColl10,
                         int sampleIntColl01, Integer sampleIntColl02, Double sampleRealColl01, Double sampleRealColl02, Integer sampleIntCollIndexed, MultiTable_09 multiTable_09) {

        super(id, sampleStringColl01, sampleStringColl02, sampleStringColl03, sampleStringColl04, sampleStringColl05,
                sampleStringColl06, sampleStringColl07, sampleStringColl08, sampleStringColl09, sampleStringColl10,
                sampleIntColl01, sampleIntColl02, sampleRealColl01, sampleRealColl02, sampleIntCollIndexed);

        this.multiTable_09 = multiTable_09;
    }

    public static MultiTable_08 getNewEntityWithRandomData(int range) {
        return getNewEntityWithRandomData(null, range);
    }

    public static MultiTable_08 getNewEntityWithRandomData(Long id, int range) {
        MultiTable_08 table = new MultiTable_08();
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
        EntityFieldGeneratorUtils generatorUtils = EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.RAW_SQL_ENTITY_FIELD_GENERATOR_ID + 8, range);
        table.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());
        table.setMultiTable_09(MultiTable_09.getNewEntityWithRandomData(table.getId(), generatorUtils.getUniqueNumberRange()));
        return table;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = super.getContentValues();
        values.put(MultiTable_08Dao.MULTI_TABLE_09_ID, multiTable_09.getId());

        return values;
    }

    public MultiTable_09 getMultiTable_09() {
        return multiTable_09;
    }

    public void setMultiTable_09(MultiTable_09 table) {
        this.multiTable_09 = table;
    }
}
