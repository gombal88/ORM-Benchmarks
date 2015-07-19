package pl.gombal.orm_benchmarks.io.activeandroid.entity;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@Table(name = MultiTable_02.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_02 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_02";

    public static final String MULTI_TABLE_03_ID = "MULTI_TABLE_03_ID";


    @Column(name = MULTI_TABLE_03_ID)
    private MultiTable_03 multiTable_03;

    public MultiTable_02() {
        super();
    }

    public static MultiTable_02 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_02 table = new MultiTable_02();

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

        EntityFieldGeneratorUtils generatorUtilsTab03 =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ACTIVE_ANDROID_ENTITY_FIELD_GENERATOR_ID + 3, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_03(MultiTable_03.getNewEntityWithRandomData(generatorUtilsTab03));

        return table;
    }

    public MultiTable_03 getMultiTable_03() {
        return multiTable_03;
    }

    public void setMultiTable_03(MultiTable_03 multiTable_03) {
        this.multiTable_03 = multiTable_03;
    }
}
