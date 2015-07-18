package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

@DatabaseTable(tableName = MultiTable_05.TABLE_NAME)
public class MultiTable_05 extends BaseSampleEntity  {

    public static final String TABLE_NAME = "MULTI_TABLE_05";

    public static final String MULTI_TABLE_06_ID = "MULTI_TABLE_06_ID";

    @DatabaseField(columnName = MULTI_TABLE_06_ID, foreign = true,
            columnDefinition = "integer references " + MultiTable_06.TABLE_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_06 multiTable_06;


    public static MultiTable_05 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, generatorUtils);
    }

    public static MultiTable_05 getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_05 table = new MultiTable_05();
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

        EntityFieldGeneratorUtils generatorUtilsTab06 =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ORM_LITE_ENTITY_FIELD_GENERATOR_ID + 6, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_06(MultiTable_06.getNewEntityWithRandomData(table.getId(), generatorUtilsTab06));

        return table;
    }

    public MultiTable_06 getMultiTable_06() {
        return multiTable_06;
    }

    public void setMultiTable_06(MultiTable_06 multiTable_06) {
        this.multiTable_06 = multiTable_06;
    }
}
