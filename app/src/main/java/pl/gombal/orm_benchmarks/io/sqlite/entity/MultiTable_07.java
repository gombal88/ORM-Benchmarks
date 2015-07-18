package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;

import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

/**
 * Created by gombal on 23.06.2015.
 */
public class MultiTable_07 extends BaseSampleEntity {

    private MultiTable_08 multiTable_08;

    public MultiTable_07() {

    }

    public MultiTable_07(long id) {
        super(id);
    }

    public MultiTable_07(long id, String sampleStringColl01, String sampleStringColl02, String sampleStringColl03, String sampleStringColl04, String sampleStringColl05,
                         String sampleStringColl06, String sampleStringColl07, String sampleStringColl08, String sampleStringColl09, String sampleStringColl10,
                         int sampleIntColl01, Integer sampleIntColl02, Double sampleRealColl01, Double sampleRealColl02, Integer sampleIntCollIndexed, MultiTable_08 MultiTable_08) {

        super(id, sampleStringColl01, sampleStringColl02, sampleStringColl03, sampleStringColl04, sampleStringColl05,
                sampleStringColl06, sampleStringColl07, sampleStringColl08, sampleStringColl09, sampleStringColl10,
                sampleIntColl01, sampleIntColl02, sampleRealColl01, sampleRealColl02, sampleIntCollIndexed);

        this.multiTable_08 = MultiTable_08;
    }

    public static MultiTable_07 getNewEntityWithRandomData(int range) {
        return getNewEntityWithRandomData(null, range);
    }

    public static MultiTable_07 getNewEntityWithRandomData(Long id, int range) {
        MultiTable_07 table = new MultiTable_07();
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
        EntityFieldGeneratorUtils generatorUtils = EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.RAW_SQL_ENTITY_FIELD_GENERATOR_ID + 7, range);
        table.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());
        table.setMultiTable_08(MultiTable_08.getNewEntityWithRandomData(table.getId(), generatorUtils.getUniqueNumberRange()));
        return table;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = super.getContentValues();
        values.put(MultiTable_07Dao.MULTI_TABLE_08_ID, multiTable_08.getId());

        return values;
    }

    public MultiTable_08 getMultiTable_08() {
        return multiTable_08;
    }

    public void setMultiTable_08(MultiTable_08 MultiTable_08) {
        this.multiTable_08 = MultiTable_08;
    }
}
