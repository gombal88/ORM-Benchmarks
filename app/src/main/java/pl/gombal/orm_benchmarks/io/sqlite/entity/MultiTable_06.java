package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;

import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;


public class MultiTable_06 extends BaseSampleEntity {

    private MultiTable_07 multiTable_07;

    public MultiTable_06() {
    }

    public MultiTable_06(long id) {
        super(id);
    }

    public MultiTable_06(long id, String sampleStringColl01, String sampleStringColl02, String sampleStringColl03, String sampleStringColl04, String sampleStringColl05,
                         String sampleStringColl06, String sampleStringColl07, String sampleStringColl08, String sampleStringColl09, String sampleStringColl10,
                         int sampleIntColl01, Integer sampleIntColl02, Double sampleRealColl01, Double sampleRealColl02, Integer sampleIntCollIndexed, MultiTable_07 MultiTable_07) {

        super(id, sampleStringColl01, sampleStringColl02, sampleStringColl03, sampleStringColl04, sampleStringColl05,
                sampleStringColl06, sampleStringColl07, sampleStringColl08, sampleStringColl09, sampleStringColl10,
                sampleIntColl01, sampleIntColl02, sampleRealColl01, sampleRealColl02, sampleIntCollIndexed);

        this.multiTable_07 = MultiTable_07;
    }

    public static MultiTable_06 getNewEntityWithRandomData(int nextUniqueRandomInt) {
        return getNewEntityWithRandomData(null, nextUniqueRandomInt);
    }

    public static MultiTable_06 getNewEntityWithRandomData(Long id, int nextUniqueRandomInt) {
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
        table.setSampleIntCollIndexed(nextUniqueRandomInt);
        table.setMultiTable_07(MultiTable_07.getNewEntityWithRandomData(table.getId(), nextUniqueRandomInt));
        return table;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = super.getContentValues();
        values.put(MultiTable_06Dao.MULTI_TABLE_07_ID, multiTable_07.getId());

        return values;
    }

    public MultiTable_07 getMultiTable_07() {
        return multiTable_07;
    }

    public void setMultiTable_07(MultiTable_07 MultiTable_07) {
        this.multiTable_07 = MultiTable_07;
    }
}
