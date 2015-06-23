package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;
import android.provider.BaseColumns;

/**
 * Created by gombal on 23.06.2015.
 */
public class TableWithRelationToMany extends BaseSampleEntity {

    public TableWithRelationToMany(long id) {
        super(id);
    }

    public TableWithRelationToMany(long id, String sampleStringColl01, String sampleStringColl02, String sampleStringColl03, String sampleStringColl04, String sampleStringColl05,
                                   String sampleStringColl06, String sampleStringColl07, String sampleStringColl08, String sampleStringColl09, String sampleStringColl10,
                                   int sampleIntColl01, Integer sampleIntColl02, Double sampleRealColl01, Double sampleRealColl02, Integer sampleIntCollIndexed) {

        super(id, sampleStringColl01, sampleStringColl02, sampleStringColl03, sampleStringColl04, sampleStringColl05,
                sampleStringColl06, sampleStringColl07, sampleStringColl08, sampleStringColl09, sampleStringColl10,
                sampleIntColl01, sampleIntColl02, sampleRealColl01, sampleRealColl02, sampleIntCollIndexed);

    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(BaseColumns._ID, id);
        values.put(TableWithRelationToManyDao.SAMPLE_STRING_COLL_01, SampleStringColl01);
        values.put(TableWithRelationToManyDao.SAMPLE_STRING_COLL_02, SampleStringColl02);
        values.put(TableWithRelationToManyDao.SAMPLE_STRING_COLL_03, SampleStringColl03);
        values.put(TableWithRelationToManyDao.SAMPLE_STRING_COLL_04, SampleStringColl04);
        values.put(TableWithRelationToManyDao.SAMPLE_STRING_COLL_05, SampleStringColl05);
        values.put(TableWithRelationToManyDao.SAMPLE_STRING_COLL_06, SampleStringColl06);
        values.put(TableWithRelationToManyDao.SAMPLE_STRING_COLL_07, SampleStringColl07);
        values.put(TableWithRelationToManyDao.SAMPLE_STRING_COLL_08, SampleStringColl08);
        values.put(TableWithRelationToManyDao.SAMPLE_STRING_COLL_09, SampleStringColl09);
        values.put(TableWithRelationToManyDao.SAMPLE_STRING_COLL_10, SampleStringColl10);
        values.put(TableWithRelationToManyDao.SAMPLE_INT_COLL_01, SampleIntColl01);
        values.put(TableWithRelationToManyDao.SAMPLE_INT_COLL_02, SampleIntColl02);
        values.put(TableWithRelationToManyDao.SAMPLE_REAL_COLL_01, SampleRealColl01);
        values.put(TableWithRelationToManyDao.SAMPLE_REAL_COLL_02, SampleRealColl02);
        values.put(TableWithRelationToManyDao.SAMPLE_INT_COLL_INDEXED, SampleIntCollIndexed);

        return values;
    }
}
