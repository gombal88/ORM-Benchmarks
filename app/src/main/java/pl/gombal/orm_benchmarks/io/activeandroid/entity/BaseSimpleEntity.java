package pl.gombal.orm_benchmarks.io.activeandroid.entity;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

public abstract class BaseSimpleEntity extends Model {

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


    @Column(name = SAMPLE_STRING_COLL_01)
    protected String SampleStringColl01;

    @Column(name = SAMPLE_STRING_COLL_02)
    protected String SampleStringColl02;

    @Column(name = SAMPLE_STRING_COLL_03)
    protected String SampleStringColl03;

    @Column(name = SAMPLE_STRING_COLL_04)
    protected String SampleStringColl04;

    @Column(name = SAMPLE_STRING_COLL_05)
    protected String SampleStringColl05;

    @Column(name = SAMPLE_STRING_COLL_06)
    protected String SampleStringColl06;

    @Column(name = SAMPLE_STRING_COLL_07)
    protected String SampleStringColl07;

    @Column(name = SAMPLE_STRING_COLL_08)
    protected String SampleStringColl08;

    @Column(name = SAMPLE_STRING_COLL_09)
    protected String SampleStringColl09;

    @Column(name = SAMPLE_STRING_COLL_10)
    protected String SampleStringColl10;

    @Column(name = SAMPLE_INT_COLL_01)
    protected int SampleIntColl01;

    @Column(name = SAMPLE_INT_COLL_02)
    protected Integer SampleIntColl02;

    @Column(name = SAMPLE_REAL_COLL_01)
    protected Double SampleRealColl01;

    @Column(name = SAMPLE_REAL_COLL_02)
    protected Double SampleRealColl02;

    @Column(name = SAMPLE_INT_COLL_INDEXED, index = true)
    protected Integer SampleIntCollIndexed;

    public BaseSimpleEntity() {
        super();
    }

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
