package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;
import android.provider.BaseColumns;

import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

public class SingleTable extends BaseSampleEntity {

    public static SingleTable getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, generatorUtils);
    }

    public static SingleTable getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils) {
        SingleTable singleTable = new SingleTable();
        if (id != null)
            singleTable.setId(id);
        singleTable.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        singleTable.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        singleTable.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        singleTable.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        singleTable.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());
        return singleTable;
    }

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