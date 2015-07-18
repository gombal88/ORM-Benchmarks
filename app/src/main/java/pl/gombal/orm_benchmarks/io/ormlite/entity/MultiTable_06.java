package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

@DatabaseTable(tableName = MultiTable_06.TABLE_NAME)
public class MultiTable_06 extends BaseSampleEntity  {

    public static final String TABLE_NAME = "MULTI_TABLE_06";

    public static final String MULTI_TABLE_07_ID = "MULTI_TABLE_07_ID";

    @DatabaseField(columnName = MULTI_TABLE_07_ID, foreign = true,
            columnDefinition = "integer references " + MultiTable_07.TABLE_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_07 multiTable_07;


    public static MultiTable_06 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, generatorUtils);
    }

    public static MultiTable_06 getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils) {
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
        table.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());

        EntityFieldGeneratorUtils generatorUtilsTab07 =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ORM_LITE_ENTITY_FIELD_GENERATOR_ID + 7, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_07(MultiTable_07.getNewEntityWithRandomData(table.getId(), generatorUtilsTab07));

        return table;
    }

    public MultiTable_07 getMultiTable_07() {
        return multiTable_07;
    }

    public void setMultiTable_07(MultiTable_07 multiTable_07) {
        this.multiTable_07 = multiTable_07;
    }
}
