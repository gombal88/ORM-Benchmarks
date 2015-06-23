package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;
import android.provider.BaseColumns;

public class SingleTable extends BaseSampleEntity {

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(BaseColumns._ID, id);
        values.put(SingleTableDao.SAMPLE_STRING_COLL_01, SampleStringColl01);
        values.put(SingleTableDao.SAMPLE_STRING_COLL_02, SampleStringColl02);
        values.put(SingleTableDao.SAMPLE_STRING_COLL_03, SampleStringColl03);
        values.put(SingleTableDao.SAMPLE_STRING_COLL_04, SampleStringColl04);
        values.put(SingleTableDao.SAMPLE_STRING_COLL_05, SampleStringColl05);
        values.put(SingleTableDao.SAMPLE_STRING_COLL_06, SampleStringColl06);
        values.put(SingleTableDao.SAMPLE_STRING_COLL_07, SampleStringColl07);
        values.put(SingleTableDao.SAMPLE_STRING_COLL_08, SampleStringColl08);
        values.put(SingleTableDao.SAMPLE_STRING_COLL_09, SampleStringColl09);
        values.put(SingleTableDao.SAMPLE_STRING_COLL_10, SampleStringColl10);
        values.put(SingleTableDao.SAMPLE_INT_COLL_01, SampleIntColl01);
        values.put(SingleTableDao.SAMPLE_INT_COLL_02, SampleIntColl02);
        values.put(SingleTableDao.SAMPLE_REAL_COLL_01, SampleRealColl01);
        values.put(SingleTableDao.SAMPLE_REAL_COLL_02, SampleRealColl02);
        values.put(SingleTableDao.SAMPLE_INT_COLL_INDEXED, SampleIntCollIndexed);

        return values;
    }
}