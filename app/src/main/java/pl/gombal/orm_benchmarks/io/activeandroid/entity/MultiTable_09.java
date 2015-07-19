package pl.gombal.orm_benchmarks.io.activeandroid.entity;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@Table(name = MultiTable_09.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_09 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_09";

    public static final String MULTI_TABLE_10_ID = "MULTI_TABLE_10_ID";


    @Column(name = MULTI_TABLE_10_ID)
    private MultiTable_10 multiTable_10;

    public MultiTable_09() {
        super();
    }


    public static MultiTable_09 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_09 table = new MultiTable_09();

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

        EntityFieldGeneratorUtils generatorUtilsTab10 =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ACTIVE_ANDROID_ENTITY_FIELD_GENERATOR_ID + 10, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_10(MultiTable_10.getNewEntityWithRandomData(generatorUtilsTab10));

        return table;
    }

    public MultiTable_10 getMultiTable_10() {
        return multiTable_10;
    }

    public void setMultiTable_10(MultiTable_10 multiTable_10) {
        this.multiTable_10 = multiTable_10;
    }
}
