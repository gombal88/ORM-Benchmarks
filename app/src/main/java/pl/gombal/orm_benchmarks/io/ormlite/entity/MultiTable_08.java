package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

@DatabaseTable(tableName = MultiTable_08.TABLE_NAME)
public class MultiTable_08 extends BaseSampleEntity  {

    public static final String TABLE_NAME = "MULTI_TABLE_08";

    public static final String MULTI_TABLE_09_ID = "MULTI_TABLE_09_ID";

    @DatabaseField(columnName = MULTI_TABLE_09_ID, foreign = true,
            columnDefinition = "integer references " + MultiTable_09.TABLE_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_09 multiTable_09;


    public static MultiTable_08 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, generatorUtils);
    }

    public static MultiTable_08 getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_08 table = new MultiTable_08();
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

        EntityFieldGeneratorUtils generatorUtilsTab09 =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ORM_LITE_ENTITY_FIELD_GENERATOR_ID + 9, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_09(MultiTable_09.getNewEntityWithRandomData(table.getId(), generatorUtilsTab09));

        return table;
    }

    public MultiTable_09 getMultiTable_09() {
        return multiTable_09;
    }

    public void setMultiTable_09(MultiTable_09 multiTable_09) {
        this.multiTable_09 = multiTable_09;
    }
}
