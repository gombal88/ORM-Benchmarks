package pl.gombal.orm_benchmarks.io.ormlite.entity;


import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public abstract class BaseSampleEntity extends BaseEntity {

    public static final String SAMPLE_STRING_COLL_01 = "SAMPLE_STRING_COLL01";
    public static final String SAMPLE_STRING_COLL_02 = "SAMPLE_STRING_COLL02";
    public static final String SAMPLE_STRING_COLL_03 = "SAMPLE_STRING_COLL03";
    public static final String SAMPLE_STRING_COLL_04 = "SAMPLE_STRING_COLL04";
    public static final String SAMPLE_STRING_COLL_05 = "SAMPLE_STRING_COLL05";
    public static final String SAMPLE_STRING_COLL_06 = "SAMPLE_STRING_COLL06";
    public static final String SAMPLE_STRING_COLL_07 = "SAMPLE_STRING_COLL07";
    public static final String SAMPLE_STRING_COLL_08 = "SAMPLE_STRING_COLL08";
    public static final String SAMPLE_STRING_COLL_09 = "SAMPLE_STRING_COLL09";
    public static final String SAMPLE_STRING_COLL_10 = "SAMPLE_STRING_COLL10";
    public static final String SAMPLE_INT_COLL_01 = "SAMPLE_INT_COLL01";
    public static final String SAMPLE_INT_COLL_02 = "SAMPLE_INT_COLL02";
    public static final String SAMPLE_REAL_COLL_01 = "SAMPLE_REAL_COLL01";
    public static final String SAMPLE_REAL_COLL_02 = "SAMPLE_REAL_COLL02";
    public static final String SAMPLE_INT_COLL_INDEXED = "SAMPLE_INT_COLL_INDEXED";


    @DatabaseField(columnName = SAMPLE_STRING_COLL_01, canBeNull = false, dataType = DataType.STRING)
    protected String SampleStringColl01;

    @DatabaseField(columnName = SAMPLE_STRING_COLL_02, dataType = DataType.STRING)
    protected String SampleStringColl02;

    @DatabaseField(columnName = SAMPLE_STRING_COLL_03, dataType = DataType.STRING)
    protected String SampleStringColl03;

    @DatabaseField(columnName = SAMPLE_STRING_COLL_04, dataType = DataType.STRING)
    protected String SampleStringColl04;

    @DatabaseField(columnName = SAMPLE_STRING_COLL_05, dataType = DataType.STRING)
    protected String SampleStringColl05;

    @DatabaseField(columnName = SAMPLE_STRING_COLL_06, dataType = DataType.STRING)
    protected String SampleStringColl06;

    @DatabaseField(columnName = SAMPLE_STRING_COLL_07, dataType = DataType.STRING)
    protected String SampleStringColl07;

    @DatabaseField(columnName = SAMPLE_STRING_COLL_08, dataType = DataType.STRING)
    protected String SampleStringColl08;

    @DatabaseField(columnName = SAMPLE_STRING_COLL_09, dataType = DataType.STRING)
    protected String SampleStringColl09;

    @DatabaseField(columnName = SAMPLE_STRING_COLL_10, dataType = DataType.STRING)
    protected String SampleStringColl10;

    @DatabaseField(columnName = SAMPLE_INT_COLL_01, canBeNull = false, dataType = DataType.INTEGER)
    protected int SampleIntColl01;

    @DatabaseField(columnName = SAMPLE_INT_COLL_02, dataType = DataType.INTEGER_OBJ)
    protected Integer SampleIntColl02;

    @DatabaseField(columnName = SAMPLE_REAL_COLL_01, dataType = DataType.DOUBLE_OBJ)
    protected Double SampleRealColl01;

    @DatabaseField(columnName = SAMPLE_REAL_COLL_02, dataType = DataType.DOUBLE_OBJ)
    protected Double SampleRealColl02;

    @DatabaseField(columnName = SAMPLE_INT_COLL_INDEXED, index = true, dataType = DataType.INTEGER_OBJ)
    protected Integer SampleIntCollIndexed;


    public String getSampleStringColl01() {
        return SampleStringColl01;
    }

    public void setSampleStringColl01(String sampleStringColl01) {
        SampleStringColl01 = sampleStringColl01;
    }

    public String getSampleStringColl02() {
        return SampleStringColl02;
    }

    public void setSampleStringColl02(String sampleStringColl02) {
        SampleStringColl02 = sampleStringColl02;
    }

    public String getSampleStringColl03() {
        return SampleStringColl03;
    }

    public void setSampleStringColl03(String sampleStringColl03) {
        SampleStringColl03 = sampleStringColl03;
    }

    public String getSampleStringColl04() {
        return SampleStringColl04;
    }

    public void setSampleStringColl04(String sampleStringColl04) {
        SampleStringColl04 = sampleStringColl04;
    }

    public String getSampleStringColl05() {
        return SampleStringColl05;
    }

    public void setSampleStringColl05(String sampleStringColl05) {
        SampleStringColl05 = sampleStringColl05;
    }

    public String getSampleStringColl06() {
        return SampleStringColl06;
    }

    public void setSampleStringColl06(String sampleStringColl06) {
        SampleStringColl06 = sampleStringColl06;
    }

    public String getSampleStringColl07() {
        return SampleStringColl07;
    }

    public void setSampleStringColl07(String sampleStringColl07) {
        SampleStringColl07 = sampleStringColl07;
    }

    public String getSampleStringColl08() {
        return SampleStringColl08;
    }

    public void setSampleStringColl08(String sampleStringColl08) {
        SampleStringColl08 = sampleStringColl08;
    }

    public String getSampleStringColl09() {
        return SampleStringColl09;
    }

    public void setSampleStringColl09(String sampleStringColl09) {
        SampleStringColl09 = sampleStringColl09;
    }

    public String getSampleStringColl10() {
        return SampleStringColl10;
    }

    public void setSampleStringColl10(String sampleStringColl10) {
        SampleStringColl10 = sampleStringColl10;
    }

    public int getSampleIntColl01() {
        return SampleIntColl01;
    }

    public void setSampleIntColl01(int sampleIntColl01) {
        SampleIntColl01 = sampleIntColl01;
    }

    public Integer getSampleIntColl02() {
        return SampleIntColl02;
    }

    public void setSampleIntColl02(Integer sampleIntColl02) {
        SampleIntColl02 = sampleIntColl02;
    }

    public Double getSampleRealColl01() {
        return SampleRealColl01;
    }

    public void setSampleRealColl01(Double sampleRealColl01) {
        SampleRealColl01 = sampleRealColl01;
    }

    public Double getSampleRealColl02() {
        return SampleRealColl02;
    }

    public void setSampleRealColl02(Double sampleRealColl02) {
        SampleRealColl02 = sampleRealColl02;
    }

    public Integer getSampleIntCollIndexed() {
        return SampleIntCollIndexed;
    }

    public void setSampleIntCollIndexed(Integer sampleIntCollIndexed) {
        SampleIntCollIndexed = sampleIntCollIndexed;
    }
}
