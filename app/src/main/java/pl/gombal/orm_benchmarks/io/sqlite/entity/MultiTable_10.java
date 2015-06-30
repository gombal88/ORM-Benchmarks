package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;
import android.provider.BaseColumns;

import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

public class MultiTable_10 extends BaseSampleEntity {

    public MultiTable_10() {
    }

    public MultiTable_10(long id) {
        super(id);
    }

    public MultiTable_10(long id, String sampleStringColl01, String sampleStringColl02, String sampleStringColl03, String sampleStringColl04, String sampleStringColl05, String sampleStringColl06, String sampleStringColl07, String sampleStringColl08, String sampleStringColl09, String sampleStringColl10, int sampleIntColl01, Integer sampleIntColl02, Double sampleRealColl01, Double sampleRealColl02, Integer sampleIntCollIndexed) {
        super(id, sampleStringColl01, sampleStringColl02, sampleStringColl03, sampleStringColl04, sampleStringColl05, sampleStringColl06, sampleStringColl07, sampleStringColl08, sampleStringColl09, sampleStringColl10, sampleIntColl01, sampleIntColl02, sampleRealColl01, sampleRealColl02, sampleIntCollIndexed);
    }

    public static MultiTable_10 getNewEntityWithRandomData(int nextUniqueRandomInt) {
        return getNewEntityWithRandomData(null, nextUniqueRandomInt);
    }

    public static MultiTable_10 getNewEntityWithRandomData(Long id, int nextUniqueRandomInt) {
        MultiTable_10 multiTable_10 = new MultiTable_10();
        if (id != null)
            multiTable_10.setId(id);
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
        multiTable_10.setSampleIntCollIndexed(nextUniqueRandomInt);
        return multiTable_10;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(BaseColumns._ID, id);
        values.put(MultiTable_10Dao.SAMPLE_STRING_COLL_01, SampleStringColl01);
        values.put(MultiTable_10Dao.SAMPLE_STRING_COLL_02, SampleStringColl02);
        values.put(MultiTable_10Dao.SAMPLE_STRING_COLL_03, SampleStringColl03);
        values.put(MultiTable_10Dao.SAMPLE_STRING_COLL_04, SampleStringColl04);
        values.put(MultiTable_10Dao.SAMPLE_STRING_COLL_05, SampleStringColl05);
        values.put(MultiTable_10Dao.SAMPLE_STRING_COLL_06, SampleStringColl06);
        values.put(MultiTable_10Dao.SAMPLE_STRING_COLL_07, SampleStringColl07);
        values.put(MultiTable_10Dao.SAMPLE_STRING_COLL_08, SampleStringColl08);
        values.put(MultiTable_10Dao.SAMPLE_STRING_COLL_09, SampleStringColl09);
        values.put(MultiTable_10Dao.SAMPLE_STRING_COLL_10, SampleStringColl10);
        values.put(MultiTable_10Dao.SAMPLE_INT_COLL_01, SampleIntColl01);
        values.put(MultiTable_10Dao.SAMPLE_INT_COLL_02, SampleIntColl02);
        values.put(MultiTable_10Dao.SAMPLE_REAL_COLL_01, SampleRealColl01);
        values.put(MultiTable_10Dao.SAMPLE_REAL_COLL_02, SampleRealColl02);
        values.put(MultiTable_10Dao.SAMPLE_INT_COLL_INDEXED, SampleIntCollIndexed);

        return values;
    }
}
