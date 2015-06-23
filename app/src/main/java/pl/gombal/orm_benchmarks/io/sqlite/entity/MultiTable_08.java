package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;
import android.provider.BaseColumns;

/**
 * Created by gombal on 23.06.2015.
 */
public class MultiTable_08 extends BaseSampleEntity {

    private MultiTable_09 MultiTable_09;

    public MultiTable_08(long id) {
        super(id);
    }

    public MultiTable_08(long id, String sampleStringColl01, String sampleStringColl02, String sampleStringColl03, String sampleStringColl04, String sampleStringColl05,
                         String sampleStringColl06, String sampleStringColl07, String sampleStringColl08, String sampleStringColl09, String sampleStringColl10,
                         int sampleIntColl01, Integer sampleIntColl02, Double sampleRealColl01, Double sampleRealColl02, Integer sampleIntCollIndexed, MultiTable_09 MultiTable_09) {

        super(id, sampleStringColl01, sampleStringColl02, sampleStringColl03, sampleStringColl04, sampleStringColl05,
                sampleStringColl06, sampleStringColl07, sampleStringColl08, sampleStringColl09, sampleStringColl10,
                sampleIntColl01, sampleIntColl02, sampleRealColl01, sampleRealColl02, sampleIntCollIndexed);

        this.MultiTable_09 = MultiTable_09;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(BaseColumns._ID, id);
        values.put(MultiTable_08Dao.SAMPLE_STRING_COLL_01, SampleStringColl01);
        values.put(MultiTable_08Dao.SAMPLE_STRING_COLL_02, SampleStringColl02);
        values.put(MultiTable_08Dao.SAMPLE_STRING_COLL_03, SampleStringColl03);
        values.put(MultiTable_08Dao.SAMPLE_STRING_COLL_04, SampleStringColl04);
        values.put(MultiTable_08Dao.SAMPLE_STRING_COLL_05, SampleStringColl05);
        values.put(MultiTable_08Dao.SAMPLE_STRING_COLL_06, SampleStringColl06);
        values.put(MultiTable_08Dao.SAMPLE_STRING_COLL_07, SampleStringColl07);
        values.put(MultiTable_08Dao.SAMPLE_STRING_COLL_08, SampleStringColl08);
        values.put(MultiTable_08Dao.SAMPLE_STRING_COLL_09, SampleStringColl09);
        values.put(MultiTable_08Dao.SAMPLE_STRING_COLL_10, SampleStringColl10);
        values.put(MultiTable_08Dao.SAMPLE_INT_COLL_01, SampleIntColl01);
        values.put(MultiTable_08Dao.SAMPLE_INT_COLL_02, SampleIntColl02);
        values.put(MultiTable_08Dao.SAMPLE_REAL_COLL_01, SampleRealColl01);
        values.put(MultiTable_08Dao.SAMPLE_REAL_COLL_02, SampleRealColl02);
        values.put(MultiTable_08Dao.SAMPLE_INT_COLL_INDEXED, SampleIntCollIndexed);
        values.put(MultiTable_08Dao.MULTI_TABLE_09_ID, MultiTable_09.getId());

        return values;
    }

    public MultiTable_09 getMultiTable_09() {
        return MultiTable_09;
    }

    public void setMultiTable_09(MultiTable_09 MultiTable_09) {
        this.MultiTable_09 = MultiTable_09;
    }
}
