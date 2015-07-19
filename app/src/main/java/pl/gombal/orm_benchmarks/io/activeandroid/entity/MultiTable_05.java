package pl.gombal.orm_benchmarks.io.activeandroid.entity;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@Table(name = MultiTable_05.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_05 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_05";

    public static final String MULTI_TABLE_06_ID = "MULTI_TABLE_06_ID";


    @Column(name = MULTI_TABLE_06_ID)
    private MultiTable_06 multiTable_06;

    public MultiTable_05() {
        super();
    }

    public static MultiTable_05 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_05 table = new MultiTable_05();

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
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ACTIVE_ANDROID_ENTITY_FIELD_GENERATOR_ID + 6, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_06(MultiTable_06.getNewEntityWithRandomData(generatorUtilsTab06));

        return table;
    }

    public MultiTable_06 getMultiTable_06() {
        return multiTable_06;
    }

    public void setMultiTable_06(MultiTable_06 multiTable_06) {
        this.multiTable_06 = multiTable_06;
    }
}
