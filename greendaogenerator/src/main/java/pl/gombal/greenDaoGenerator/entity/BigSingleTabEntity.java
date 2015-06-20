package pl.gombal.greenDaoGenerator.entity;

import de.greenrobot.daogenerator.Entity;

/**
 * Created by gombal on 19.06.2015.
 */
public class BigSingleTabEntity extends BaseEntity{

    public static final String TABLE_NAME = "BigSingleTable";


    public static final String EXTRA_SAMPLE_STRING_COLL_01 = "ExtraSmplStringColl01";
    public static final String EXTRA_SAMPLE_STRING_COLL_02 = "ExtraSmplStringColl02";
    public static final String EXTRA_SAMPLE_STRING_COLL_03 = "ExtraSmplStringColl03";
    public static final String EXTRA_SAMPLE_STRING_COLL_04 = "ExtraSmplStringColl04";
    public static final String EXTRA_SAMPLE_STRING_COLL_05 = "ExtraSmplStringColl05";
    public static final String EXTRA_SAMPLE_STRING_COLL_06 = "ExtraSmplStringColl06";
    public static final String EXTRA_SAMPLE_STRING_COLL_07 = "ExtraSmplStringColl07";
    public static final String EXTRA_SAMPLE_STRING_COLL_08 = "ExtraSmplStringColl08";
    public static final String EXTRA_SAMPLE_STRING_COLL_09 = "ExtraSmplStringColl09";
    public static final String EXTRA_SAMPLE_STRING_COLL_10 = "ExtraSmplStringColl10";
    public static final String EXTRA_SAMPLE_STRING_COLL_11 = "ExtraSmplStringColl11";
    public static final String EXTRA_SAMPLE_STRING_COLL_12 = "ExtraSmplStringColl12";
    public static final String EXTRA_SAMPLE_STRING_COLL_13 = "ExtraSmplStringColl13";
    public static final String EXTRA_SAMPLE_STRING_COLL_14 = "ExtraSmplStringColl14";
    public static final String EXTRA_SAMPLE_STRING_COLL_15 = "ExtraSmplStringColl15";
    public static final String EXTRA_SAMPLE_STRING_COLL_16 = "ExtraSmplStringColl16";
    public static final String EXTRA_SAMPLE_STRING_COLL_17 = "ExtraSmplStringColl17";
    public static final String EXTRA_SAMPLE_STRING_COLL_18 = "ExtraSmplStringColl18";
    public static final String EXTRA_SAMPLE_STRING_COLL_19 = "ExtraSmplStringColl19";
    public static final String EXTRA_SAMPLE_STRING_COLL_20 = "ExtraSmplStringColl20";

    public static final String EXTRA_SAMPLE_DOUBLE_COLL_01 = "ExtraSmplDoubleColl01";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_02 = "ExtraSmplDoubleColl02";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_03 = "ExtraSmplDoubleColl03";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_04 = "ExtraSmplDoubleColl04";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_05 = "ExtraSmplDoubleColl05";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_06 = "ExtraSmplDoubleColl06";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_07 = "ExtraSmplDoubleColl07";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_08 = "ExtraSmplDoubleColl08";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_09 = "ExtraSmplDoubleColl09";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_10 = "ExtraSmplDoubleColl10";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_11 = "ExtraSmplDoubleColl11";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_12 = "ExtraSmplDoubleColl12";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_13 = "ExtraSmplDoubleColl13";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_14 = "ExtraSmplDoubleColl14";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_15 = "ExtraSmplDoubleColl15";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_16 = "ExtraSmplDoubleColl16";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_17 = "ExtraSmplDoubleColl17";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_18 = "ExtraSmplDoubleColl18";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_19 = "ExtraSmplDoubleColl19";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_20 = "ExtraSmplDoubleColl20";


    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected void addExtraProperties(Entity entity) {
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_01);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_02);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_03);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_04);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_05);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_06);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_07);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_08);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_09);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_10);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_11);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_12);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_13);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_14);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_15);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_16);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_17);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_18);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_19);
        entity.addStringProperty(EXTRA_SAMPLE_STRING_COLL_20);

        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_01);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_02);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_03);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_04);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_05);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_06);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_07);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_08);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_09);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_10);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_11);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_12);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_13);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_14);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_15);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_16);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_17);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_18);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_19);
        entity.addStringProperty(EXTRA_SAMPLE_DOUBLE_COLL_20);

    }
}
