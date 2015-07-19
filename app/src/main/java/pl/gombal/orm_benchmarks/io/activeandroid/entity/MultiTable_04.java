package pl.gombal.orm_benchmarks.io.activeandroid.entity;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@Table(name = MultiTable_04.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_04 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_04";

    public static final String MULTI_TABLE_05_ID = "MULTI_TABLE_05_ID";


    @Column(name = MULTI_TABLE_05_ID)
    private MultiTable_05 multiTable_05;

    public MultiTable_04() {
        super();
    }

    public static MultiTable_04 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_04 table = new MultiTable_04();

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

        EntityFieldGeneratorUtils generatorUtilsTab05 =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ACTIVE_ANDROID_ENTITY_FIELD_GENERATOR_ID + 5, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_05(MultiTable_05.getNewEntityWithRandomData(generatorUtilsTab05));

        return table;
    }

    public MultiTable_05 getMultiTable_05() {
        return multiTable_05;
    }

    public void setMultiTable_05(MultiTable_05 multiTable_05) {
        this.multiTable_05 = multiTable_05;
    }
}
