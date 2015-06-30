package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;
import android.provider.BaseColumns;

import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

public class BigSingleTable extends BaseSampleEntity{

    private String ExtraSmplStringColl01;
    private String ExtraSmplStringColl02;
    private String ExtraSmplStringColl03;
    private String ExtraSmplStringColl04;
    private String ExtraSmplStringColl05;
    private String ExtraSmplStringColl06;
    private String ExtraSmplStringColl07;
    private String ExtraSmplStringColl08;
    private String ExtraSmplStringColl09;
    private String ExtraSmplStringColl10;
    private String ExtraSmplStringColl11;
    private String ExtraSmplStringColl12;
    private String ExtraSmplStringColl13;
    private String ExtraSmplStringColl14;
    private String ExtraSmplStringColl15;
    private String ExtraSmplStringColl16;
    private String ExtraSmplStringColl17;
    private String ExtraSmplStringColl18;
    private String ExtraSmplStringColl19;
    private String ExtraSmplStringColl20;
    private Double ExtraSmplDoubleColl01;
    private Double ExtraSmplDoubleColl02;
    private Double ExtraSmplDoubleColl03;
    private Double ExtraSmplDoubleColl04;
    private Double ExtraSmplDoubleColl05;
    private Double ExtraSmplDoubleColl06;
    private Double ExtraSmplDoubleColl07;
    private Double ExtraSmplDoubleColl08;
    private Double ExtraSmplDoubleColl09;
    private Double ExtraSmplDoubleColl10;
    private Double ExtraSmplDoubleColl11;
    private Double ExtraSmplDoubleColl12;
    private Double ExtraSmplDoubleColl13;
    private Double ExtraSmplDoubleColl14;
    private Double ExtraSmplDoubleColl15;
    private Double ExtraSmplDoubleColl16;
    private Double ExtraSmplDoubleColl17;
    private Double ExtraSmplDoubleColl18;
    private Double ExtraSmplDoubleColl19;
    private Double ExtraSmplDoubleColl20;

    public BigSingleTable() {

    }

    public BigSingleTable(long id) {
        super(id);
    }

    public BigSingleTable(long id, String sampleStringColl01, String sampleStringColl02, String sampleStringColl03, String sampleStringColl04, String sampleStringColl05, String sampleStringColl06, String sampleStringColl07, String sampleStringColl08, String sampleStringColl09, String sampleStringColl10, int sampleIntColl01, Integer sampleIntColl02, Double sampleRealColl01, Double sampleRealColl02, Integer sampleIntCollIndexed,
                          String extraSmplStringColl01, String extraSmplStringColl02, String extraSmplStringColl03, String extraSmplStringColl04, String extraSmplStringColl05, String extraSmplStringColl06, String extraSmplStringColl07, String extraSmplStringColl08, String extraSmplStringColl09, String extraSmplStringColl10,
                          String extraSmplStringColl11, String extraSmplStringColl12, String extraSmplStringColl13, String extraSmplStringColl14, String extraSmplStringColl15, String extraSmplStringColl16, String extraSmplStringColl17, String extraSmplStringColl18, String extraSmplStringColl19, String extraSmplStringColl20,
                          Double extraSmplDoubleColl01, Double extraSmplDoubleColl02, Double extraSmplDoubleColl03, Double extraSmplDoubleColl04, Double extraSmplDoubleColl05, Double extraSmplDoubleColl06, Double extraSmplDoubleColl07, Double extraSmplDoubleColl08, Double extraSmplDoubleColl09, Double extraSmplDoubleColl10,
                          Double extraSmplDoubleColl11, Double extraSmplDoubleColl12, Double extraSmplDoubleColl13, Double extraSmplDoubleColl14, Double extraSmplDoubleColl15, Double extraSmplDoubleColl16, Double extraSmplDoubleColl17, Double extraSmplDoubleColl18, Double extraSmplDoubleColl19, Double extraSmplDoubleColl20) {

        super(id, sampleStringColl01, sampleStringColl02, sampleStringColl03, sampleStringColl04, sampleStringColl05, sampleStringColl06, sampleStringColl07, sampleStringColl08, sampleStringColl09, sampleStringColl10, sampleIntColl01, sampleIntColl02, sampleRealColl01, sampleRealColl02, sampleIntCollIndexed);
        ExtraSmplStringColl01 = extraSmplStringColl01;
        ExtraSmplStringColl02 = extraSmplStringColl02;
        ExtraSmplStringColl03 = extraSmplStringColl03;
        ExtraSmplStringColl04 = extraSmplStringColl04;
        ExtraSmplStringColl05 = extraSmplStringColl05;
        ExtraSmplStringColl06 = extraSmplStringColl06;
        ExtraSmplStringColl07 = extraSmplStringColl07;
        ExtraSmplStringColl08 = extraSmplStringColl08;
        ExtraSmplStringColl09 = extraSmplStringColl09;
        ExtraSmplStringColl10 = extraSmplStringColl10;
        ExtraSmplStringColl11 = extraSmplStringColl11;
        ExtraSmplStringColl12 = extraSmplStringColl12;
        ExtraSmplStringColl13 = extraSmplStringColl13;
        ExtraSmplStringColl14 = extraSmplStringColl14;
        ExtraSmplStringColl15 = extraSmplStringColl15;
        ExtraSmplStringColl16 = extraSmplStringColl16;
        ExtraSmplStringColl17 = extraSmplStringColl17;
        ExtraSmplStringColl18 = extraSmplStringColl18;
        ExtraSmplStringColl19 = extraSmplStringColl19;
        ExtraSmplStringColl20 = extraSmplStringColl20;
        ExtraSmplDoubleColl01 = extraSmplDoubleColl01;
        ExtraSmplDoubleColl02 = extraSmplDoubleColl02;
        ExtraSmplDoubleColl03 = extraSmplDoubleColl03;
        ExtraSmplDoubleColl04 = extraSmplDoubleColl04;
        ExtraSmplDoubleColl05 = extraSmplDoubleColl05;
        ExtraSmplDoubleColl06 = extraSmplDoubleColl06;
        ExtraSmplDoubleColl07 = extraSmplDoubleColl07;
        ExtraSmplDoubleColl08 = extraSmplDoubleColl08;
        ExtraSmplDoubleColl09 = extraSmplDoubleColl09;
        ExtraSmplDoubleColl10 = extraSmplDoubleColl10;
        ExtraSmplDoubleColl11 = extraSmplDoubleColl11;
        ExtraSmplDoubleColl12 = extraSmplDoubleColl12;
        ExtraSmplDoubleColl13 = extraSmplDoubleColl13;
        ExtraSmplDoubleColl14 = extraSmplDoubleColl14;
        ExtraSmplDoubleColl15 = extraSmplDoubleColl15;
        ExtraSmplDoubleColl16 = extraSmplDoubleColl16;
        ExtraSmplDoubleColl17 = extraSmplDoubleColl17;
        ExtraSmplDoubleColl18 = extraSmplDoubleColl18;
        ExtraSmplDoubleColl19 = extraSmplDoubleColl19;
        ExtraSmplDoubleColl20 = extraSmplDoubleColl20;
    }

    public static BigSingleTable getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, generatorUtils);
    }

    public static BigSingleTable getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils) {
        BigSingleTable bigSingleTable = new BigSingleTable();
        if (id != null)
            bigSingleTable.setId(id);
        bigSingleTable.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        bigSingleTable.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        bigSingleTable.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        bigSingleTable.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        bigSingleTable.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());

        bigSingleTable.setExtraSmplStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl11(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl12(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl13(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl14(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl15(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl16(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl17(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl18(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl19(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl20(EntityFieldGeneratorUtils.getRandomString(20));

        bigSingleTable.setExtraSmplDoubleColl01(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl02(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl03(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl04(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl05(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl06(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl07(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl08(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl09(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl10(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl11(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl12(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl13(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl14(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl15(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl16(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl17(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl18(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl19(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl20(EntityFieldGeneratorUtils.getRandomDouble(20));

        return bigSingleTable;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(BaseColumns._ID, id);
        values.put(BigSingleTableDao.SAMPLE_STRING_COLL_01, SampleStringColl01);
        values.put(BigSingleTableDao.SAMPLE_STRING_COLL_02, SampleStringColl02);
        values.put(BigSingleTableDao.SAMPLE_STRING_COLL_03, SampleStringColl03);
        values.put(BigSingleTableDao.SAMPLE_STRING_COLL_04, SampleStringColl04);
        values.put(BigSingleTableDao.SAMPLE_STRING_COLL_05, SampleStringColl05);
        values.put(BigSingleTableDao.SAMPLE_STRING_COLL_06, SampleStringColl06);
        values.put(BigSingleTableDao.SAMPLE_STRING_COLL_07, SampleStringColl07);
        values.put(BigSingleTableDao.SAMPLE_STRING_COLL_08, SampleStringColl08);
        values.put(BigSingleTableDao.SAMPLE_STRING_COLL_09, SampleStringColl09);
        values.put(BigSingleTableDao.SAMPLE_STRING_COLL_10, SampleStringColl10);
        values.put(BigSingleTableDao.SAMPLE_INT_COLL_01, SampleIntColl01);
        values.put(BigSingleTableDao.SAMPLE_INT_COLL_02, SampleIntColl02);
        values.put(BigSingleTableDao.SAMPLE_REAL_COLL_01, SampleRealColl01);
        values.put(BigSingleTableDao.SAMPLE_REAL_COLL_02, SampleRealColl02);
        values.put(BigSingleTableDao.SAMPLE_INT_COLL_INDEXED, SampleIntCollIndexed);

        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_01, ExtraSmplStringColl01);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_02, ExtraSmplStringColl02);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_03, ExtraSmplStringColl03);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_04, ExtraSmplStringColl04);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_05, ExtraSmplStringColl05);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_06, ExtraSmplStringColl06);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_07, ExtraSmplStringColl07);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_08, ExtraSmplStringColl08);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_09, ExtraSmplStringColl09);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_10, ExtraSmplStringColl10);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_11, ExtraSmplStringColl11);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_12, ExtraSmplStringColl12);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_13, ExtraSmplStringColl13);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_14, ExtraSmplStringColl14);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_15, ExtraSmplStringColl15);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_16, ExtraSmplStringColl16);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_17, ExtraSmplStringColl17);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_18, ExtraSmplStringColl18);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_19, ExtraSmplStringColl19);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_STRING_COLL_20, ExtraSmplStringColl20);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_01, ExtraSmplDoubleColl01);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_02, ExtraSmplDoubleColl02);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_03, ExtraSmplDoubleColl03);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_04, ExtraSmplDoubleColl04);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_05, ExtraSmplDoubleColl05);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_06, ExtraSmplDoubleColl06);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_07, ExtraSmplDoubleColl07);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_08, ExtraSmplDoubleColl08);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_09, ExtraSmplDoubleColl09);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_10, ExtraSmplDoubleColl10);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_11, ExtraSmplDoubleColl11);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_12, ExtraSmplDoubleColl12);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_13, ExtraSmplDoubleColl13);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_14, ExtraSmplDoubleColl14);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_15, ExtraSmplDoubleColl15);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_16, ExtraSmplDoubleColl16);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_17, ExtraSmplDoubleColl17);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_18, ExtraSmplDoubleColl18);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_19, ExtraSmplDoubleColl19);
        values.put(BigSingleTableDao.EXTRA_SAMPLE_DOUBLE_COLL_20, ExtraSmplDoubleColl20);
        
        return values;
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
