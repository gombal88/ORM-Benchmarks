package pl.gombal.orm_benchmarks.io.sugarorm;


public class MultiTable_01 extends BaseSampleEntity<MultiTable_01> {

    private MultiTable_02 multiTable_02;

    public MultiTable_01() {

    }

    public MultiTable_02 getMultiTable_02() {
        return multiTable_02;
    }

    public void setMultiTable_02(MultiTable_02 multiTable_02) {
        this.multiTable_02 = multiTable_02;
    }
}
