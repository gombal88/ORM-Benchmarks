package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;
import android.provider.BaseColumns;

import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

public class MultiTable_01 extends BaseSampleEntity {

    private MultiTable_02 multiTable_02;

    public MultiTable_01() {
    }

    public MultiTable_01(long id) {
        super(id);
    }

    public MultiTable_01(long id, String sampleStringColl01, String sampleStringColl02, String sampleStringColl03, String sampleStringColl04, String sampleStringColl05,
                         String sampleStringColl06, String sampleStringColl07, String sampleStringColl08, String sampleStringColl09, String sampleStringColl10,
                         int sampleIntColl01, Integer sampleIntColl02, Double sampleRealColl01, Double sampleRealColl02, Integer sampleIntCollIndexed, MultiTable_02 MultiTable_02) {

        super(id, sampleStringColl01, sampleStringColl02, sampleStringColl03, sampleStringColl04, sampleStringColl05,
                sampleStringColl06, sampleStringColl07, sampleStringColl08, sampleStringColl09, sampleStringColl10,
                sampleIntColl01, sampleIntColl02, sampleRealColl01, sampleRealColl02, sampleIntCollIndexed);

        this.multiTable_02 = MultiTable_02;
    }

    public static MultiTable_01 getNewEntityWithRandomData(int nextUniqueRandomInt) {
        return getNewEntityWithRandomData(null, nextUniqueRandomInt);
    }

    public static MultiTable_01 getNewEntityWithRandomData(Long id, int nextUniqueRandomInt) {
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
        table.setSampleIntCollIndexed(nextUniqueRandomInt);
        table.setMultiTable_02(MultiTable_02.getNewEntityWithRandomData(table.getId(), nextUniqueRandomInt));
        return table;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(BaseColumns._ID, id);
        values.put(MultiTable_01Dao.SAMPLE_STRING_COLL_01, SampleStringColl01);
        values.put(MultiTable_01Dao.SAMPLE_STRING_COLL_02, SampleStringColl02);
        values.put(MultiTable_01Dao.SAMPLE_STRING_COLL_03, SampleStringColl03);
        values.put(MultiTable_01Dao.SAMPLE_STRING_COLL_04, SampleStringColl04);
        values.put(MultiTable_01Dao.SAMPLE_STRING_COLL_05, SampleStringColl05);
        values.put(MultiTable_01Dao.SAMPLE_STRING_COLL_06, SampleStringColl06);
        values.put(MultiTable_01Dao.SAMPLE_STRING_COLL_07, SampleStringColl07);
        values.put(MultiTable_01Dao.SAMPLE_STRING_COLL_08, SampleStringColl08);
        values.put(MultiTable_01Dao.SAMPLE_STRING_COLL_09, SampleStringColl09);
        values.put(MultiTable_01Dao.SAMPLE_STRING_COLL_10, SampleStringColl10);
        values.put(MultiTable_01Dao.SAMPLE_INT_COLL_01, SampleIntColl01);
        values.put(MultiTable_01Dao.SAMPLE_INT_COLL_02, SampleIntColl02);
        values.put(MultiTable_01Dao.SAMPLE_REAL_COLL_01, SampleRealColl01);
        values.put(MultiTable_01Dao.SAMPLE_REAL_COLL_02, SampleRealColl02);
        values.put(MultiTable_01Dao.SAMPLE_INT_COLL_INDEXED, SampleIntCollIndexed);
        values.put(MultiTable_01Dao.MULTI_TABLE_02_ID, multiTable_02.getId());

        return values;
    }

    public MultiTable_02 getMultiTable_02() {
        return multiTable_02;
    }

    public void setMultiTable_02(MultiTable_02 MultiTable_02) {
        this.multiTable_02 = MultiTable_02;
    }
}
