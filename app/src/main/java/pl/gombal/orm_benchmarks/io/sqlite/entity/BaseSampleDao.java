package pl.gombal.orm_benchmarks.io.sqlite.entity;

/**
 * Created by gombal on 23.06.2015.
 */
public abstract class BaseSampleDao<T extends BaseEntity> extends BaseDao<T> {

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


    public BaseSampleDao(String tableName) {
        super(tableName);
    }

    public BaseSampleDao(String tableName, boolean innerTab) {
        super(tableName, innerTab);
    }
}
