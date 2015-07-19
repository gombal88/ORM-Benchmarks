package pl.gombal.orm_benchmarks.io.activeandroid.entity;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@Table(name = MultiTable_08.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_08 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_08";

    public static final String MULTI_TABLE_09_ID = "MULTI_TABLE_09_ID";


    @Column(name = MULTI_TABLE_09_ID)
    private MultiTable_09 multiTable_09;

    public MultiTable_08() {
        super();
    }

    public static MultiTable_08 getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        MultiTable_08 table = new MultiTable_08();

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
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ACTIVE_ANDROID_ENTITY_FIELD_GENERATOR_ID + 9, generatorUtils.getUniqueNumberRange());
        table.setMultiTable_09(MultiTable_09.getNewEntityWithRandomData(generatorUtilsTab09));

        return table;
    }

    public MultiTable_09 getMultiTable_09() {
        return multiTable_09;
    }

    public void setMultiTable_09(MultiTable_09 multiTable_09) {
        this.multiTable_09 = multiTable_09;
    }
}
