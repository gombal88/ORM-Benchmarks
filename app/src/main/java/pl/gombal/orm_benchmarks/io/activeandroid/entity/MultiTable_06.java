package pl.gombal.orm_benchmarks.io.activeandroid.entity;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@Table(name = MultiTable_06.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_06 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_06";

    public static final String MULTI_TABLE_07_ID = "MULTI_TABLE_07_ID";


    @Column(name = MULTI_TABLE_07_ID)
    private MultiTable_07 multiTable_07;

    public MultiTable_06() {
        super();
    }

    public static MultiTable_06 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_06 table = new MultiTable_06();

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
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ACTIVE_ANDROID_ENTITY_FIELD_GENERATOR_ID + 7, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_07(MultiTable_07.getNewEntityWithRandomData(generatorUtilsTab07));

        return table;
    }

    public MultiTable_07 getMultiTable_07() {
        return multiTable_07;
    }

    public void setMultiTable_07(MultiTable_07 multiTable_07) {
        this.multiTable_07 = multiTable_07;
    }
}
