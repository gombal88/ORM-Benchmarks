package pl.gombal.orm_benchmarks.io.activeandroid.entity;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@Table(name = MultiTable_03.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_03 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_03";

    public static final String MULTI_TABLE_04_ID = "MULTI_TABLE_04_ID";


    @Column(name = MULTI_TABLE_04_ID)
    private MultiTable_04 multiTable_04;

    public MultiTable_03() {
        super();
    }

    public static MultiTable_03 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_03 table = new MultiTable_03();

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
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ACTIVE_ANDROID_ENTITY_FIELD_GENERATOR_ID + 4, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_04(MultiTable_04.getNewEntityWithRandomData(generatorUtilsTab04));

        return table;
    }

    public MultiTable_04 getMultiTable_04() {
        return multiTable_04;
    }

    public void setMultiTable_04(MultiTable_04 multiTable_04) {
        this.multiTable_04 = multiTable_04;
    }
}
