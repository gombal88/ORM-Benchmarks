package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@DatabaseTable(tableName = MultiTable_03.TABLE_NAME)
public class MultiTable_03 extends BaseSampleEntity  {

    public static final String TABLE_NAME = "MULTI_TABLE_03";

    public static final String MULTI_TABLE_04_ID = "MULTI_TABLE_04_ID";

    @DatabaseField(columnName = MULTI_TABLE_04_ID, foreign = true, foreignAutoCreate = true,
            columnDefinition = "integer references " + MultiTable_04.TABLE_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_04 multiTable_04;


    public static MultiTable_03 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, generatorUtils);
    }

    public static MultiTable_03 getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils) {
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
        table.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());

        EntityFieldGeneratorUtils generatorUtilsTab04 =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ORM_LITE_ENTITY_FIELD_GENERATOR_ID + 4, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_04(MultiTable_04.getNewEntityWithRandomData(table.getId(), generatorUtilsTab04));

        return table;
    }

    public MultiTable_04 getMultiTable_04() {
        return multiTable_04;
    }

    public void setMultiTable_04(MultiTable_04 multiTable_04) {
        this.multiTable_04 = multiTable_04;
    }
}
