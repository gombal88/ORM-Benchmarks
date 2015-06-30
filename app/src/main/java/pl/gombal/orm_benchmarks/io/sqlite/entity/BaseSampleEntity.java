package pl.gombal.orm_benchmarks.io.sqlite.entity;

public abstract class BaseSampleEntity extends BaseEntity {

    protected String SampleStringColl01;
    protected String SampleStringColl02;
    protected String SampleStringColl03;
    protected String SampleStringColl04;
    protected String SampleStringColl05;
    protected String SampleStringColl06;
    protected String SampleStringColl07;
    protected String SampleStringColl08;
    protected String SampleStringColl09;
    protected String SampleStringColl10;
    protected int SampleIntColl01;
    protected Integer SampleIntColl02;
    protected Double SampleRealColl01;
    protected Double SampleRealColl02;
    protected Integer SampleIntCollIndexed;


    public BaseSampleEntity() {
    }

    public BaseSampleEntity(long id) {
        super(id);
    }

    public BaseSampleEntity(long id, String sampleStringColl01, String sampleStringColl02, String sampleStringColl03, String sampleStringColl04, String sampleStringColl05, String sampleStringColl06, String sampleStringColl07, String sampleStringColl08, String sampleStringColl09, String sampleStringColl10, int sampleIntColl01, Integer sampleIntColl02, Double sampleRealColl01, Double sampleRealColl02, Integer sampleIntCollIndexed) {
        super(id);
        SampleStringColl01 = sampleStringColl01;
        SampleStringColl02 = sampleStringColl02;
        SampleStringColl03 = sampleStringColl03;
        SampleStringColl04 = sampleStringColl04;
        SampleStringColl05 = sampleStringColl05;
        SampleStringColl06 = sampleStringColl06;
        SampleStringColl07 = sampleStringColl07;
        SampleStringColl08 = sampleStringColl08;
        SampleStringColl09 = sampleStringColl09;
        SampleStringColl10 = sampleStringColl10;
        SampleIntColl01 = sampleIntColl01;
        SampleIntColl02 = sampleIntColl02;
        SampleRealColl01 = sampleRealColl01;
        SampleRealColl02 = sampleRealColl02;
        SampleIntCollIndexed = sampleIntCollIndexed;
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
