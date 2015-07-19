package pl.gombal.orm_benchmarks.io.activeandroid.entity;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@Table(name = MultiTable_07.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_07 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_07";

    public static final String MULTI_TABLE_08_ID = "MULTI_TABLE_08_ID";


    @Column(name = MULTI_TABLE_08_ID)
    private MultiTable_08 multiTable_08;

    public MultiTable_07() {
        super();
    }

    public static MultiTable_07 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_07 table = new MultiTable_07();

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

        EntityFieldGeneratorUtils generatorUtilsTab08 =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ACTIVE_ANDROID_ENTITY_FIELD_GENERATOR_ID + 8, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_08(MultiTable_08.getNewEntityWithRandomData(generatorUtilsTab08));

        return table;
    }

    public MultiTable_08 getMultiTable_08() {
        return multiTable_08;
    }

    public void setMultiTable_08(MultiTable_08 multiTable_08) {
        this.multiTable_08 = multiTable_08;
    }
}
