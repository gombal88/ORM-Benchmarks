package pl.gombal.orm_benchmarks.io.sugarorm;


public class MultiTable_02 extends BaseSampleEntity<MultiTable_02> {

    private MultiTable_03 multiTable_03;

    public MultiTable_02() {

    }

    public MultiTable_03 getMultiTable_03() {
        return multiTable_03;
    }

    public void setMultiTable_03(MultiTable_03 multiTable_03) {
        this.multiTable_03 = multiTable_03;
    }
}
