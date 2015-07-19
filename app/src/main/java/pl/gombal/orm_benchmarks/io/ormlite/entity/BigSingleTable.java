package pl.gombal.orm_benchmarks.io.ormlite.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@DatabaseTable(tableName = BigSingleTable.TABLE_NAME)
public class BigSingleTable extends BaseSampleEntity {

    public static final String TABLE_NAME = "BIG_SINGLE_TABLE";

    public static final String EXTRA_SAMPLE_STRING_COLL_01 = "EXTRA_SMPL_STRING_COLL01";
    public static final String EXTRA_SAMPLE_STRING_COLL_02 = "EXTRA_SMPL_STRING_COLL02";
    public static final String EXTRA_SAMPLE_STRING_COLL_03 = "EXTRA_SMPL_STRING_COLL03";
    public static final String EXTRA_SAMPLE_STRING_COLL_04 = "EXTRA_SMPL_STRING_COLL04";
    public static final String EXTRA_SAMPLE_STRING_COLL_05 = "EXTRA_SMPL_STRING_COLL05";
    public static final String EXTRA_SAMPLE_STRING_COLL_06 = "EXTRA_SMPL_STRING_COLL06";
    public static final String EXTRA_SAMPLE_STRING_COLL_07 = "EXTRA_SMPL_STRING_COLL07";
    public static final String EXTRA_SAMPLE_STRING_COLL_08 = "EXTRA_SMPL_STRING_COLL08";
    public static final String EXTRA_SAMPLE_STRING_COLL_09 = "EXTRA_SMPL_STRING_COLL09";
    public static final String EXTRA_SAMPLE_STRING_COLL_10 = "EXTRA_SMPL_STRING_COLL10";
    public static final String EXTRA_SAMPLE_STRING_COLL_11 = "EXTRA_SMPL_STRING_COLL11";
    public static final String EXTRA_SAMPLE_STRING_COLL_12 = "EXTRA_SMPL_STRING_COLL12";
    public static final String EXTRA_SAMPLE_STRING_COLL_13 = "EXTRA_SMPL_STRING_COLL13";
    public static final String EXTRA_SAMPLE_STRING_COLL_14 = "EXTRA_SMPL_STRING_COLL14";
    public static final String EXTRA_SAMPLE_STRING_COLL_15 = "EXTRA_SMPL_STRING_COLL15";
    public static final String EXTRA_SAMPLE_STRING_COLL_16 = "EXTRA_SMPL_STRING_COLL16";
    public static final String EXTRA_SAMPLE_STRING_COLL_17 = "EXTRA_SMPL_STRING_COLL17";
    public static final String EXTRA_SAMPLE_STRING_COLL_18 = "EXTRA_SMPL_STRING_COLL18";
    public static final String EXTRA_SAMPLE_STRING_COLL_19 = "EXTRA_SMPL_STRING_COLL19";
    public static final String EXTRA_SAMPLE_STRING_COLL_20 = "EXTRA_SMPL_STRING_COLL20";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_01 = "EXTRA_SMPL_DOUBLE_COLL01";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_02 = "EXTRA_SMPL_DOUBLE_COLL02";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_03 = "EXTRA_SMPL_DOUBLE_COLL03";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_04 = "EXTRA_SMPL_DOUBLE_COLL04";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_05 = "EXTRA_SMPL_DOUBLE_COLL05";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_06 = "EXTRA_SMPL_DOUBLE_COLL06";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_07 = "EXTRA_SMPL_DOUBLE_COLL07";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_08 = "EXTRA_SMPL_DOUBLE_COLL08";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_09 = "EXTRA_SMPL_DOUBLE_COLL09";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_10 = "EXTRA_SMPL_DOUBLE_COLL10";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_11 = "EXTRA_SMPL_DOUBLE_COLL11";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_12 = "EXTRA_SMPL_DOUBLE_COLL12";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_13 = "EXTRA_SMPL_DOUBLE_COLL13";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_14 = "EXTRA_SMPL_DOUBLE_COLL14";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_15 = "EXTRA_SMPL_DOUBLE_COLL15";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_16 = "EXTRA_SMPL_DOUBLE_COLL16";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_17 = "EXTRA_SMPL_DOUBLE_COLL17";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_18 = "EXTRA_SMPL_DOUBLE_COLL18";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_19 = "EXTRA_SMPL_DOUBLE_COLL19";
    public static final String EXTRA_SAMPLE_DOUBLE_COLL_20 = "EXTRA_SMPL_DOUBLE_COLL20";





    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_01, dataType = DataType.STRING)
    private String ExtraSmplStringColl01;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_02, dataType = DataType.STRING)
    private String ExtraSmplStringColl02;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_03, dataType = DataType.STRING)
    private String ExtraSmplStringColl03;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_04, dataType = DataType.STRING)
    private String ExtraSmplStringColl04;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_05, dataType = DataType.STRING)
    private String ExtraSmplStringColl05;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_06, dataType = DataType.STRING)
    private String ExtraSmplStringColl06;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_07, dataType = DataType.STRING)
    private String ExtraSmplStringColl07;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_08, dataType = DataType.STRING)
    private String ExtraSmplStringColl08;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_09, dataType = DataType.STRING)
    private String ExtraSmplStringColl09;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_10, dataType = DataType.STRING)
    private String ExtraSmplStringColl10;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_11, dataType = DataType.STRING)
    private String ExtraSmplStringColl11;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_12, dataType = DataType.STRING)
    private String ExtraSmplStringColl12;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_13, dataType = DataType.STRING)
    private String ExtraSmplStringColl13;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_14, dataType = DataType.STRING)
    private String ExtraSmplStringColl14;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_15, dataType = DataType.STRING)
    private String ExtraSmplStringColl15;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_16, dataType = DataType.STRING)
    private String ExtraSmplStringColl16;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_17, dataType = DataType.STRING)
    private String ExtraSmplStringColl17;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_18, dataType = DataType.STRING)
    private String ExtraSmplStringColl18;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_19, dataType = DataType.STRING)
    private String ExtraSmplStringColl19;

    @DatabaseField(columnName = EXTRA_SAMPLE_STRING_COLL_20, dataType = DataType.STRING)
    private String ExtraSmplStringColl20;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_01, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl01;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_02, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl02;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_03, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl03;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_04, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl04;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_05, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl05;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_06, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl06;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_07, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl07;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_08, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl08;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_09, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl09;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_10, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl10;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_11, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl11;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_12, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl12;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_13, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl13;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_14, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl14;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_15, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl15;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_16, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl16;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_17, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl17;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_18, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl18;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_19, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl19;

    @DatabaseField(columnName = EXTRA_SAMPLE_DOUBLE_COLL_20, dataType = DataType.DOUBLE_OBJ)
    private Double ExtraSmplDoubleColl20;


    public static BigSingleTable getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, generatorUtils);
    }

    public static BigSingleTable getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils) {
        BigSingleTable table = new BigSingleTable();
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

        table.setExtraSmplStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl11(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl12(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl13(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl14(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl15(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl16(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl17(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl18(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl19(EntityFieldGeneratorUtils.getRandomString(20));
        table.setExtraSmplStringColl20(EntityFieldGeneratorUtils.getRandomString(20));

        table.setExtraSmplDoubleColl01(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl02(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl03(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl04(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl05(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl06(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl07(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl08(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl09(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl10(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl11(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl12(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl13(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl14(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl15(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl16(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl17(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl18(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl19(EntityFieldGeneratorUtils.getRandomDouble(20));
        table.setExtraSmplDoubleColl20(EntityFieldGeneratorUtils.getRandomDouble(20));

        return table;
    }

    public String getExtraSmplStringColl01() {
        return ExtraSmplStringColl01;
    }

    public void setExtraSmplStringColl01(String extraSmplStringColl01) {
        ExtraSmplStringColl01 = extraSmplStringColl01;
    }

    public String getExtraSmplStringColl02() {
        return ExtraSmplStringColl02;
    }

    public void setExtraSmplStringColl02(String extraSmplStringColl02) {
        ExtraSmplStringColl02 = extraSmplStringColl02;
    }

    public String getExtraSmplStringColl03() {
        return ExtraSmplStringColl03;
    }

    public void setExtraSmplStringColl03(String extraSmplStringColl03) {
        ExtraSmplStringColl03 = extraSmplStringColl03;
    }

    public String getExtraSmplStringColl04() {
        return ExtraSmplStringColl04;
    }

    public void setExtraSmplStringColl04(String extraSmplStringColl04) {
        ExtraSmplStringColl04 = extraSmplStringColl04;
    }

    public String getExtraSmplStringColl05() {
        return ExtraSmplStringColl05;
    }

    public void setExtraSmplStringColl05(String extraSmplStringColl05) {
        ExtraSmplStringColl05 = extraSmplStringColl05;
    }

    public String getExtraSmplStringColl06() {
        return ExtraSmplStringColl06;
    }

    public void setExtraSmplStringColl06(String extraSmplStringColl06) {
        ExtraSmplStringColl06 = extraSmplStringColl06;
    }

    public String getExtraSmplStringColl07() {
        return ExtraSmplStringColl07;
    }

    public void setExtraSmplStringColl07(String extraSmplStringColl07) {
        ExtraSmplStringColl07 = extraSmplStringColl07;
    }

    public String getExtraSmplStringColl08() {
        return ExtraSmplStringColl08;
    }

    public void setExtraSmplStringColl08(String extraSmplStringColl08) {
        ExtraSmplStringColl08 = extraSmplStringColl08;
    }

    public String getExtraSmplStringColl09() {
        return ExtraSmplStringColl09;
    }

    public void setExtraSmplStringColl09(String extraSmplStringColl09) {
        ExtraSmplStringColl09 = extraSmplStringColl09;
    }

    public String getExtraSmplStringColl10() {
        return ExtraSmplStringColl10;
    }

    public void setExtraSmplStringColl10(String extraSmplStringColl10) {
        ExtraSmplStringColl10 = extraSmplStringColl10;
    }

    public String getExtraSmplStringColl11() {
        return ExtraSmplStringColl11;
    }

    public void setExtraSmplStringColl11(String extraSmplStringColl11) {
        ExtraSmplStringColl11 = extraSmplStringColl11;
    }

    public String getExtraSmplStringColl12() {
        return ExtraSmplStringColl12;
    }

    public void setExtraSmplStringColl12(String extraSmplStringColl12) {
        ExtraSmplStringColl12 = extraSmplStringColl12;
    }

    public String getExtraSmplStringColl13() {
        return ExtraSmplStringColl13;
    }

    public void setExtraSmplStringColl13(String extraSmplStringColl13) {
        ExtraSmplStringColl13 = extraSmplStringColl13;
    }

    public String getExtraSmplStringColl14() {
        return ExtraSmplStringColl14;
    }

    public void setExtraSmplStringColl14(String extraSmplStringColl14) {
        ExtraSmplStringColl14 = extraSmplStringColl14;
    }

    public String getExtraSmplStringColl15() {
        return ExtraSmplStringColl15;
    }

    public void setExtraSmplStringColl15(String extraSmplStringColl15) {
        ExtraSmplStringColl15 = extraSmplStringColl15;
    }

    public String getExtraSmplStringColl16() {
        return ExtraSmplStringColl16;
    }

    public void setExtraSmplStringColl16(String extraSmplStringColl16) {
        ExtraSmplStringColl16 = extraSmplStringColl16;
    }

    public String getExtraSmplStringColl17() {
        return ExtraSmplStringColl17;
    }

    public void setExtraSmplStringColl17(String extraSmplStringColl17) {
        ExtraSmplStringColl17 = extraSmplStringColl17;
    }

    public String getExtraSmplStringColl18() {
        return ExtraSmplStringColl18;
    }

    public void setExtraSmplStringColl18(String extraSmplStringColl18) {
        ExtraSmplStringColl18 = extraSmplStringColl18;
    }

    public String getExtraSmplStringColl19() {
        return ExtraSmplStringColl19;
    }

    public void setExtraSmplStringColl19(String extraSmplStringColl19) {
        ExtraSmplStringColl19 = extraSmplStringColl19;
    }

    public String getExtraSmplStringColl20() {
        return ExtraSmplStringColl20;
    }

    public void setExtraSmplStringColl20(String extraSmplStringColl20) {
        ExtraSmplStringColl20 = extraSmplStringColl20;
    }

    public Double getExtraSmplDoubleColl01() {
        return ExtraSmplDoubleColl01;
    }

    public void setExtraSmplDoubleColl01(Double extraSmplDoubleColl01) {
        ExtraSmplDoubleColl01 = extraSmplDoubleColl01;
    }

    public Double getExtraSmplDoubleColl02() {
        return ExtraSmplDoubleColl02;
    }

    public void setExtraSmplDoubleColl02(Double extraSmplDoubleColl02) {
        ExtraSmplDoubleColl02 = extraSmplDoubleColl02;
    }

    public Double getExtraSmplDoubleColl03() {
        return ExtraSmplDoubleColl03;
    }

    public void setExtraSmplDoubleColl03(Double extraSmplDoubleColl03) {
        ExtraSmplDoubleColl03 = extraSmplDoubleColl03;
    }

    public Double getExtraSmplDoubleColl04() {
        return ExtraSmplDoubleColl04;
    }

    public void setExtraSmplDoubleColl04(Double extraSmplDoubleColl04) {
        ExtraSmplDoubleColl04 = extraSmplDoubleColl04;
    }

    public Double getExtraSmplDoubleColl05() {
        return ExtraSmplDoubleColl05;
    }

    public void setExtraSmplDoubleColl05(Double extraSmplDoubleColl05) {
        ExtraSmplDoubleColl05 = extraSmplDoubleColl05;
    }

    public Double getExtraSmplDoubleColl06() {
        return ExtraSmplDoubleColl06;
    }

    public void setExtraSmplDoubleColl06(Double extraSmplDoubleColl06) {
        ExtraSmplDoubleColl06 = extraSmplDoubleColl06;
    }

    public Double getExtraSmplDoubleColl07() {
        return ExtraSmplDoubleColl07;
    }

    public void setExtraSmplDoubleColl07(Double extraSmplDoubleColl07) {
        ExtraSmplDoubleColl07 = extraSmplDoubleColl07;
    }

    public Double getExtraSmplDoubleColl08() {
        return ExtraSmplDoubleColl08;
    }

    public void setExtraSmplDoubleColl08(Double extraSmplDoubleColl08) {
        ExtraSmplDoubleColl08 = extraSmplDoubleColl08;
    }

    public Double getExtraSmplDoubleColl09() {
        return ExtraSmplDoubleColl09;
    }

    public void setExtraSmplDoubleColl09(Double extraSmplDoubleColl09) {
        ExtraSmplDoubleColl09 = extraSmplDoubleColl09;
    }

    public Double getExtraSmplDoubleColl10() {
        return ExtraSmplDoubleColl10;
    }

    public void setExtraSmplDoubleColl10(Double extraSmplDoubleColl10) {
        ExtraSmplDoubleColl10 = extraSmplDoubleColl10;
    }

    public Double getExtraSmplDoubleColl11() {
        return ExtraSmplDoubleColl11;
    }

    public void setExtraSmplDoubleColl11(Double extraSmplDoubleColl11) {
        ExtraSmplDoubleColl11 = extraSmplDoubleColl11;
    }

    public Double getExtraSmplDoubleColl12() {
        return ExtraSmplDoubleColl12;
    }

    public void setExtraSmplDoubleColl12(Double extraSmplDoubleColl12) {
        ExtraSmplDoubleColl12 = extraSmplDoubleColl12;
    }

    public Double getExtraSmplDoubleColl13() {
        return ExtraSmplDoubleColl13;
    }

    public void setExtraSmplDoubleColl13(Double extraSmplDoubleColl13) {
        ExtraSmplDoubleColl13 = extraSmplDoubleColl13;
    }

    public Double getExtraSmplDoubleColl14() {
        return ExtraSmplDoubleColl14;
    }

    public void setExtraSmplDoubleColl14(Double extraSmplDoubleColl14) {
        ExtraSmplDoubleColl14 = extraSmplDoubleColl14;
    }

    public Double getExtraSmplDoubleColl15() {
        return ExtraSmplDoubleColl15;
    }

    public void setExtraSmplDoubleColl15(Double extraSmplDoubleColl15) {
        ExtraSmplDoubleColl15 = extraSmplDoubleColl15;
    }

    public Double getExtraSmplDoubleColl16() {
        return ExtraSmplDoubleColl16;
    }

    public void setExtraSmplDoubleColl16(Double extraSmplDoubleColl16) {
        ExtraSmplDoubleColl16 = extraSmplDoubleColl16;
    }

    public Double getExtraSmplDoubleColl17() {
        return ExtraSmplDoubleColl17;
    }

    public void setExtraSmplDoubleColl17(Double extraSmplDoubleColl17) {
        ExtraSmplDoubleColl17 = extraSmplDoubleColl17;
    }

    public Double getExtraSmplDoubleColl18() {
        return ExtraSmplDoubleColl18;
    }

    public void setExtraSmplDoubleColl18(Double extraSmplDoubleColl18) {
        ExtraSmplDoubleColl18 = extraSmplDoubleColl18;
    }

    public Double getExtraSmplDoubleColl19() {
        return ExtraSmplDoubleColl19;
    }

    public void setExtraSmplDoubleColl19(Double extraSmplDoubleColl19) {
        ExtraSmplDoubleColl19 = extraSmplDoubleColl19;
    }

    public Double getExtraSmplDoubleColl20() {
        return ExtraSmplDoubleColl20;
    }

    public void setExtraSmplDoubleColl20(Double extraSmplDoubleColl20) {
        ExtraSmplDoubleColl20 = extraSmplDoubleColl20;
    }
}
