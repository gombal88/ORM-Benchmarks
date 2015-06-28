package pl.gombal.orm_benchmarks.io.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table BIG_SINGLE_TABLE.
*/
public class BigSingleTableDao extends AbstractDao<BigSingleTable, Long> {

    public static final String TABLENAME = "BIG_SINGLE_TABLE";

    /**
     * Properties of entity BigSingleTable.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property SampleStringColl01 = new Property(1, String.class, "SampleStringColl01", false, "SAMPLE_STRING_COLL01");
        public final static Property SampleStringColl02 = new Property(2, String.class, "SampleStringColl02", false, "SAMPLE_STRING_COLL02");
        public final static Property SampleStringColl03 = new Property(3, String.class, "SampleStringColl03", false, "SAMPLE_STRING_COLL03");
        public final static Property SampleStringColl04 = new Property(4, String.class, "SampleStringColl04", false, "SAMPLE_STRING_COLL04");
        public final static Property SampleStringColl05 = new Property(5, String.class, "SampleStringColl05", false, "SAMPLE_STRING_COLL05");
        public final static Property SampleStringColl06 = new Property(6, String.class, "SampleStringColl06", false, "SAMPLE_STRING_COLL06");
        public final static Property SampleStringColl07 = new Property(7, String.class, "SampleStringColl07", false, "SAMPLE_STRING_COLL07");
        public final static Property SampleStringColl08 = new Property(8, String.class, "SampleStringColl08", false, "SAMPLE_STRING_COLL08");
        public final static Property SampleStringColl09 = new Property(9, String.class, "SampleStringColl09", false, "SAMPLE_STRING_COLL09");
        public final static Property SampleStringColl10 = new Property(10, String.class, "SampleStringColl10", false, "SAMPLE_STRING_COLL10");
        public final static Property SampleIntColl01 = new Property(11, int.class, "SampleIntColl01", false, "SAMPLE_INT_COLL01");
        public final static Property SampleIntColl02 = new Property(12, Integer.class, "SampleIntColl02", false, "SAMPLE_INT_COLL02");
        public final static Property SampleRealColl01 = new Property(13, Double.class, "SampleRealColl01", false, "SAMPLE_REAL_COLL01");
        public final static Property SampleRealColl02 = new Property(14, Double.class, "SampleRealColl02", false, "SAMPLE_REAL_COLL02");
        public final static Property SampleIntCollIndexed = new Property(15, Integer.class, "SampleIntCollIndexed", false, "SAMPLE_INT_COLL_INDEXED");
        public final static Property ExtraSmplStringColl01 = new Property(16, String.class, "ExtraSmplStringColl01", false, "EXTRA_SMPL_STRING_COLL01");
        public final static Property ExtraSmplStringColl02 = new Property(17, String.class, "ExtraSmplStringColl02", false, "EXTRA_SMPL_STRING_COLL02");
        public final static Property ExtraSmplStringColl03 = new Property(18, String.class, "ExtraSmplStringColl03", false, "EXTRA_SMPL_STRING_COLL03");
        public final static Property ExtraSmplStringColl04 = new Property(19, String.class, "ExtraSmplStringColl04", false, "EXTRA_SMPL_STRING_COLL04");
        public final static Property ExtraSmplStringColl05 = new Property(20, String.class, "ExtraSmplStringColl05", false, "EXTRA_SMPL_STRING_COLL05");
        public final static Property ExtraSmplStringColl06 = new Property(21, String.class, "ExtraSmplStringColl06", false, "EXTRA_SMPL_STRING_COLL06");
        public final static Property ExtraSmplStringColl07 = new Property(22, String.class, "ExtraSmplStringColl07", false, "EXTRA_SMPL_STRING_COLL07");
        public final static Property ExtraSmplStringColl08 = new Property(23, String.class, "ExtraSmplStringColl08", false, "EXTRA_SMPL_STRING_COLL08");
        public final static Property ExtraSmplStringColl09 = new Property(24, String.class, "ExtraSmplStringColl09", false, "EXTRA_SMPL_STRING_COLL09");
        public final static Property ExtraSmplStringColl10 = new Property(25, String.class, "ExtraSmplStringColl10", false, "EXTRA_SMPL_STRING_COLL10");
        public final static Property ExtraSmplStringColl11 = new Property(26, String.class, "ExtraSmplStringColl11", false, "EXTRA_SMPL_STRING_COLL11");
        public final static Property ExtraSmplStringColl12 = new Property(27, String.class, "ExtraSmplStringColl12", false, "EXTRA_SMPL_STRING_COLL12");
        public final static Property ExtraSmplStringColl13 = new Property(28, String.class, "ExtraSmplStringColl13", false, "EXTRA_SMPL_STRING_COLL13");
        public final static Property ExtraSmplStringColl14 = new Property(29, String.class, "ExtraSmplStringColl14", false, "EXTRA_SMPL_STRING_COLL14");
        public final static Property ExtraSmplStringColl15 = new Property(30, String.class, "ExtraSmplStringColl15", false, "EXTRA_SMPL_STRING_COLL15");
        public final static Property ExtraSmplStringColl16 = new Property(31, String.class, "ExtraSmplStringColl16", false, "EXTRA_SMPL_STRING_COLL16");
        public final static Property ExtraSmplStringColl17 = new Property(32, String.class, "ExtraSmplStringColl17", false, "EXTRA_SMPL_STRING_COLL17");
        public final static Property ExtraSmplStringColl18 = new Property(33, String.class, "ExtraSmplStringColl18", false, "EXTRA_SMPL_STRING_COLL18");
        public final static Property ExtraSmplStringColl19 = new Property(34, String.class, "ExtraSmplStringColl19", false, "EXTRA_SMPL_STRING_COLL19");
        public final static Property ExtraSmplStringColl20 = new Property(35, String.class, "ExtraSmplStringColl20", false, "EXTRA_SMPL_STRING_COLL20");
        public final static Property ExtraSmplDoubleColl01 = new Property(36, Double.class, "ExtraSmplDoubleColl01", false, "EXTRA_SMPL_DOUBLE_COLL01");
        public final static Property ExtraSmplDoubleColl02 = new Property(37, Double.class, "ExtraSmplDoubleColl02", false, "EXTRA_SMPL_DOUBLE_COLL02");
        public final static Property ExtraSmplDoubleColl03 = new Property(38, Double.class, "ExtraSmplDoubleColl03", false, "EXTRA_SMPL_DOUBLE_COLL03");
        public final static Property ExtraSmplDoubleColl04 = new Property(39, Double.class, "ExtraSmplDoubleColl04", false, "EXTRA_SMPL_DOUBLE_COLL04");
        public final static Property ExtraSmplDoubleColl05 = new Property(40, Double.class, "ExtraSmplDoubleColl05", false, "EXTRA_SMPL_DOUBLE_COLL05");
        public final static Property ExtraSmplDoubleColl06 = new Property(41, Double.class, "ExtraSmplDoubleColl06", false, "EXTRA_SMPL_DOUBLE_COLL06");
        public final static Property ExtraSmplDoubleColl07 = new Property(42, Double.class, "ExtraSmplDoubleColl07", false, "EXTRA_SMPL_DOUBLE_COLL07");
        public final static Property ExtraSmplDoubleColl08 = new Property(43, Double.class, "ExtraSmplDoubleColl08", false, "EXTRA_SMPL_DOUBLE_COLL08");
        public final static Property ExtraSmplDoubleColl09 = new Property(44, Double.class, "ExtraSmplDoubleColl09", false, "EXTRA_SMPL_DOUBLE_COLL09");
        public final static Property ExtraSmplDoubleColl10 = new Property(45, Double.class, "ExtraSmplDoubleColl10", false, "EXTRA_SMPL_DOUBLE_COLL10");
        public final static Property ExtraSmplDoubleColl11 = new Property(46, Double.class, "ExtraSmplDoubleColl11", false, "EXTRA_SMPL_DOUBLE_COLL11");
        public final static Property ExtraSmplDoubleColl12 = new Property(47, Double.class, "ExtraSmplDoubleColl12", false, "EXTRA_SMPL_DOUBLE_COLL12");
        public final static Property ExtraSmplDoubleColl13 = new Property(48, Double.class, "ExtraSmplDoubleColl13", false, "EXTRA_SMPL_DOUBLE_COLL13");
        public final static Property ExtraSmplDoubleColl14 = new Property(49, Double.class, "ExtraSmplDoubleColl14", false, "EXTRA_SMPL_DOUBLE_COLL14");
        public final static Property ExtraSmplDoubleColl15 = new Property(50, Double.class, "ExtraSmplDoubleColl15", false, "EXTRA_SMPL_DOUBLE_COLL15");
        public final static Property ExtraSmplDoubleColl16 = new Property(51, Double.class, "ExtraSmplDoubleColl16", false, "EXTRA_SMPL_DOUBLE_COLL16");
        public final static Property ExtraSmplDoubleColl17 = new Property(52, Double.class, "ExtraSmplDoubleColl17", false, "EXTRA_SMPL_DOUBLE_COLL17");
        public final static Property ExtraSmplDoubleColl18 = new Property(53, Double.class, "ExtraSmplDoubleColl18", false, "EXTRA_SMPL_DOUBLE_COLL18");
        public final static Property ExtraSmplDoubleColl19 = new Property(54, Double.class, "ExtraSmplDoubleColl19", false, "EXTRA_SMPL_DOUBLE_COLL19");
        public final static Property ExtraSmplDoubleColl20 = new Property(55, Double.class, "ExtraSmplDoubleColl20", false, "EXTRA_SMPL_DOUBLE_COLL20");
    };


    public BigSingleTableDao(DaoConfig config) {
        super(config);
    }
    
    public BigSingleTableDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'BIG_SINGLE_TABLE' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'SAMPLE_STRING_COLL01' TEXT NOT NULL ," + // 1: SampleStringColl01
                "'SAMPLE_STRING_COLL02' TEXT," + // 2: SampleStringColl02
                "'SAMPLE_STRING_COLL03' TEXT," + // 3: SampleStringColl03
                "'SAMPLE_STRING_COLL04' TEXT," + // 4: SampleStringColl04
                "'SAMPLE_STRING_COLL05' TEXT," + // 5: SampleStringColl05
                "'SAMPLE_STRING_COLL06' TEXT," + // 6: SampleStringColl06
                "'SAMPLE_STRING_COLL07' TEXT," + // 7: SampleStringColl07
                "'SAMPLE_STRING_COLL08' TEXT," + // 8: SampleStringColl08
                "'SAMPLE_STRING_COLL09' TEXT," + // 9: SampleStringColl09
                "'SAMPLE_STRING_COLL10' TEXT," + // 10: SampleStringColl10
                "'SAMPLE_INT_COLL01' INTEGER NOT NULL ," + // 11: SampleIntColl01
                "'SAMPLE_INT_COLL02' INTEGER," + // 12: SampleIntColl02
                "'SAMPLE_REAL_COLL01' REAL," + // 13: SampleRealColl01
                "'SAMPLE_REAL_COLL02' REAL," + // 14: SampleRealColl02
                "'SAMPLE_INT_COLL_INDEXED' INTEGER," + // 15: SampleIntCollIndexed
                "'EXTRA_SMPL_STRING_COLL01' TEXT," + // 16: ExtraSmplStringColl01
                "'EXTRA_SMPL_STRING_COLL02' TEXT," + // 17: ExtraSmplStringColl02
                "'EXTRA_SMPL_STRING_COLL03' TEXT," + // 18: ExtraSmplStringColl03
                "'EXTRA_SMPL_STRING_COLL04' TEXT," + // 19: ExtraSmplStringColl04
                "'EXTRA_SMPL_STRING_COLL05' TEXT," + // 20: ExtraSmplStringColl05
                "'EXTRA_SMPL_STRING_COLL06' TEXT," + // 21: ExtraSmplStringColl06
                "'EXTRA_SMPL_STRING_COLL07' TEXT," + // 22: ExtraSmplStringColl07
                "'EXTRA_SMPL_STRING_COLL08' TEXT," + // 23: ExtraSmplStringColl08
                "'EXTRA_SMPL_STRING_COLL09' TEXT," + // 24: ExtraSmplStringColl09
                "'EXTRA_SMPL_STRING_COLL10' TEXT," + // 25: ExtraSmplStringColl10
                "'EXTRA_SMPL_STRING_COLL11' TEXT," + // 26: ExtraSmplStringColl11
                "'EXTRA_SMPL_STRING_COLL12' TEXT," + // 27: ExtraSmplStringColl12
                "'EXTRA_SMPL_STRING_COLL13' TEXT," + // 28: ExtraSmplStringColl13
                "'EXTRA_SMPL_STRING_COLL14' TEXT," + // 29: ExtraSmplStringColl14
                "'EXTRA_SMPL_STRING_COLL15' TEXT," + // 30: ExtraSmplStringColl15
                "'EXTRA_SMPL_STRING_COLL16' TEXT," + // 31: ExtraSmplStringColl16
                "'EXTRA_SMPL_STRING_COLL17' TEXT," + // 32: ExtraSmplStringColl17
                "'EXTRA_SMPL_STRING_COLL18' TEXT," + // 33: ExtraSmplStringColl18
                "'EXTRA_SMPL_STRING_COLL19' TEXT," + // 34: ExtraSmplStringColl19
                "'EXTRA_SMPL_STRING_COLL20' TEXT," + // 35: ExtraSmplStringColl20
                "'EXTRA_SMPL_DOUBLE_COLL01' REAL," + // 36: ExtraSmplDoubleColl01
                "'EXTRA_SMPL_DOUBLE_COLL02' REAL," + // 37: ExtraSmplDoubleColl02
                "'EXTRA_SMPL_DOUBLE_COLL03' REAL," + // 38: ExtraSmplDoubleColl03
                "'EXTRA_SMPL_DOUBLE_COLL04' REAL," + // 39: ExtraSmplDoubleColl04
                "'EXTRA_SMPL_DOUBLE_COLL05' REAL," + // 40: ExtraSmplDoubleColl05
                "'EXTRA_SMPL_DOUBLE_COLL06' REAL," + // 41: ExtraSmplDoubleColl06
                "'EXTRA_SMPL_DOUBLE_COLL07' REAL," + // 42: ExtraSmplDoubleColl07
                "'EXTRA_SMPL_DOUBLE_COLL08' REAL," + // 43: ExtraSmplDoubleColl08
                "'EXTRA_SMPL_DOUBLE_COLL09' REAL," + // 44: ExtraSmplDoubleColl09
                "'EXTRA_SMPL_DOUBLE_COLL10' REAL," + // 45: ExtraSmplDoubleColl10
                "'EXTRA_SMPL_DOUBLE_COLL11' REAL," + // 46: ExtraSmplDoubleColl11
                "'EXTRA_SMPL_DOUBLE_COLL12' REAL," + // 47: ExtraSmplDoubleColl12
                "'EXTRA_SMPL_DOUBLE_COLL13' REAL," + // 48: ExtraSmplDoubleColl13
                "'EXTRA_SMPL_DOUBLE_COLL14' REAL," + // 49: ExtraSmplDoubleColl14
                "'EXTRA_SMPL_DOUBLE_COLL15' REAL," + // 50: ExtraSmplDoubleColl15
                "'EXTRA_SMPL_DOUBLE_COLL16' REAL," + // 51: ExtraSmplDoubleColl16
                "'EXTRA_SMPL_DOUBLE_COLL17' REAL," + // 52: ExtraSmplDoubleColl17
                "'EXTRA_SMPL_DOUBLE_COLL18' REAL," + // 53: ExtraSmplDoubleColl18
                "'EXTRA_SMPL_DOUBLE_COLL19' REAL," + // 54: ExtraSmplDoubleColl19
                "'EXTRA_SMPL_DOUBLE_COLL20' REAL);"); // 55: ExtraSmplDoubleColl20
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_BIG_SINGLE_TABLE_SAMPLE_INT_COLL_INDEXED ON BIG_SINGLE_TABLE" +
                " (SAMPLE_INT_COLL_INDEXED);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'BIG_SINGLE_TABLE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, BigSingleTable entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getSampleStringColl01());
 
        String SampleStringColl02 = entity.getSampleStringColl02();
        if (SampleStringColl02 != null) {
            stmt.bindString(3, SampleStringColl02);
        }
 
        String SampleStringColl03 = entity.getSampleStringColl03();
        if (SampleStringColl03 != null) {
            stmt.bindString(4, SampleStringColl03);
        }
 
        String SampleStringColl04 = entity.getSampleStringColl04();
        if (SampleStringColl04 != null) {
            stmt.bindString(5, SampleStringColl04);
        }
 
        String SampleStringColl05 = entity.getSampleStringColl05();
        if (SampleStringColl05 != null) {
            stmt.bindString(6, SampleStringColl05);
        }
 
        String SampleStringColl06 = entity.getSampleStringColl06();
        if (SampleStringColl06 != null) {
            stmt.bindString(7, SampleStringColl06);
        }
 
        String SampleStringColl07 = entity.getSampleStringColl07();
        if (SampleStringColl07 != null) {
            stmt.bindString(8, SampleStringColl07);
        }
 
        String SampleStringColl08 = entity.getSampleStringColl08();
        if (SampleStringColl08 != null) {
            stmt.bindString(9, SampleStringColl08);
        }
 
        String SampleStringColl09 = entity.getSampleStringColl09();
        if (SampleStringColl09 != null) {
            stmt.bindString(10, SampleStringColl09);
        }
 
        String SampleStringColl10 = entity.getSampleStringColl10();
        if (SampleStringColl10 != null) {
            stmt.bindString(11, SampleStringColl10);
        }
        stmt.bindLong(12, entity.getSampleIntColl01());
 
        Integer SampleIntColl02 = entity.getSampleIntColl02();
        if (SampleIntColl02 != null) {
            stmt.bindLong(13, SampleIntColl02);
        }
 
        Double SampleRealColl01 = entity.getSampleRealColl01();
        if (SampleRealColl01 != null) {
            stmt.bindDouble(14, SampleRealColl01);
        }
 
        Double SampleRealColl02 = entity.getSampleRealColl02();
        if (SampleRealColl02 != null) {
            stmt.bindDouble(15, SampleRealColl02);
        }
 
        Integer SampleIntCollIndexed = entity.getSampleIntCollIndexed();
        if (SampleIntCollIndexed != null) {
            stmt.bindLong(16, SampleIntCollIndexed);
        }
 
        String ExtraSmplStringColl01 = entity.getExtraSmplStringColl01();
        if (ExtraSmplStringColl01 != null) {
            stmt.bindString(17, ExtraSmplStringColl01);
        }
 
        String ExtraSmplStringColl02 = entity.getExtraSmplStringColl02();
        if (ExtraSmplStringColl02 != null) {
            stmt.bindString(18, ExtraSmplStringColl02);
        }
 
        String ExtraSmplStringColl03 = entity.getExtraSmplStringColl03();
        if (ExtraSmplStringColl03 != null) {
            stmt.bindString(19, ExtraSmplStringColl03);
        }
 
        String ExtraSmplStringColl04 = entity.getExtraSmplStringColl04();
        if (ExtraSmplStringColl04 != null) {
            stmt.bindString(20, ExtraSmplStringColl04);
        }
 
        String ExtraSmplStringColl05 = entity.getExtraSmplStringColl05();
        if (ExtraSmplStringColl05 != null) {
            stmt.bindString(21, ExtraSmplStringColl05);
        }
 
        String ExtraSmplStringColl06 = entity.getExtraSmplStringColl06();
        if (ExtraSmplStringColl06 != null) {
            stmt.bindString(22, ExtraSmplStringColl06);
        }
 
        String ExtraSmplStringColl07 = entity.getExtraSmplStringColl07();
        if (ExtraSmplStringColl07 != null) {
            stmt.bindString(23, ExtraSmplStringColl07);
        }
 
        String ExtraSmplStringColl08 = entity.getExtraSmplStringColl08();
        if (ExtraSmplStringColl08 != null) {
            stmt.bindString(24, ExtraSmplStringColl08);
        }
 
        String ExtraSmplStringColl09 = entity.getExtraSmplStringColl09();
        if (ExtraSmplStringColl09 != null) {
            stmt.bindString(25, ExtraSmplStringColl09);
        }
 
        String ExtraSmplStringColl10 = entity.getExtraSmplStringColl10();
        if (ExtraSmplStringColl10 != null) {
            stmt.bindString(26, ExtraSmplStringColl10);
        }
 
        String ExtraSmplStringColl11 = entity.getExtraSmplStringColl11();
        if (ExtraSmplStringColl11 != null) {
            stmt.bindString(27, ExtraSmplStringColl11);
        }
 
        String ExtraSmplStringColl12 = entity.getExtraSmplStringColl12();
        if (ExtraSmplStringColl12 != null) {
            stmt.bindString(28, ExtraSmplStringColl12);
        }
 
        String ExtraSmplStringColl13 = entity.getExtraSmplStringColl13();
        if (ExtraSmplStringColl13 != null) {
            stmt.bindString(29, ExtraSmplStringColl13);
        }
 
        String ExtraSmplStringColl14 = entity.getExtraSmplStringColl14();
        if (ExtraSmplStringColl14 != null) {
            stmt.bindString(30, ExtraSmplStringColl14);
        }
 
        String ExtraSmplStringColl15 = entity.getExtraSmplStringColl15();
        if (ExtraSmplStringColl15 != null) {
            stmt.bindString(31, ExtraSmplStringColl15);
        }
 
        String ExtraSmplStringColl16 = entity.getExtraSmplStringColl16();
        if (ExtraSmplStringColl16 != null) {
            stmt.bindString(32, ExtraSmplStringColl16);
        }
 
        String ExtraSmplStringColl17 = entity.getExtraSmplStringColl17();
        if (ExtraSmplStringColl17 != null) {
            stmt.bindString(33, ExtraSmplStringColl17);
        }
 
        String ExtraSmplStringColl18 = entity.getExtraSmplStringColl18();
        if (ExtraSmplStringColl18 != null) {
            stmt.bindString(34, ExtraSmplStringColl18);
        }
 
        String ExtraSmplStringColl19 = entity.getExtraSmplStringColl19();
        if (ExtraSmplStringColl19 != null) {
            stmt.bindString(35, ExtraSmplStringColl19);
        }
 
        String ExtraSmplStringColl20 = entity.getExtraSmplStringColl20();
        if (ExtraSmplStringColl20 != null) {
            stmt.bindString(36, ExtraSmplStringColl20);
        }
 
        Double ExtraSmplDoubleColl01 = entity.getExtraSmplDoubleColl01();
        if (ExtraSmplDoubleColl01 != null) {
            stmt.bindDouble(37, ExtraSmplDoubleColl01);
        }
 
        Double ExtraSmplDoubleColl02 = entity.getExtraSmplDoubleColl02();
        if (ExtraSmplDoubleColl02 != null) {
            stmt.bindDouble(38, ExtraSmplDoubleColl02);
        }
 
        Double ExtraSmplDoubleColl03 = entity.getExtraSmplDoubleColl03();
        if (ExtraSmplDoubleColl03 != null) {
            stmt.bindDouble(39, ExtraSmplDoubleColl03);
        }
 
        Double ExtraSmplDoubleColl04 = entity.getExtraSmplDoubleColl04();
        if (ExtraSmplDoubleColl04 != null) {
            stmt.bindDouble(40, ExtraSmplDoubleColl04);
        }
 
        Double ExtraSmplDoubleColl05 = entity.getExtraSmplDoubleColl05();
        if (ExtraSmplDoubleColl05 != null) {
            stmt.bindDouble(41, ExtraSmplDoubleColl05);
        }
 
        Double ExtraSmplDoubleColl06 = entity.getExtraSmplDoubleColl06();
        if (ExtraSmplDoubleColl06 != null) {
            stmt.bindDouble(42, ExtraSmplDoubleColl06);
        }
 
        Double ExtraSmplDoubleColl07 = entity.getExtraSmplDoubleColl07();
        if (ExtraSmplDoubleColl07 != null) {
            stmt.bindDouble(43, ExtraSmplDoubleColl07);
        }
 
        Double ExtraSmplDoubleColl08 = entity.getExtraSmplDoubleColl08();
        if (ExtraSmplDoubleColl08 != null) {
            stmt.bindDouble(44, ExtraSmplDoubleColl08);
        }
 
        Double ExtraSmplDoubleColl09 = entity.getExtraSmplDoubleColl09();
        if (ExtraSmplDoubleColl09 != null) {
            stmt.bindDouble(45, ExtraSmplDoubleColl09);
        }
 
        Double ExtraSmplDoubleColl10 = entity.getExtraSmplDoubleColl10();
        if (ExtraSmplDoubleColl10 != null) {
            stmt.bindDouble(46, ExtraSmplDoubleColl10);
        }
 
        Double ExtraSmplDoubleColl11 = entity.getExtraSmplDoubleColl11();
        if (ExtraSmplDoubleColl11 != null) {
            stmt.bindDouble(47, ExtraSmplDoubleColl11);
        }
 
        Double ExtraSmplDoubleColl12 = entity.getExtraSmplDoubleColl12();
        if (ExtraSmplDoubleColl12 != null) {
            stmt.bindDouble(48, ExtraSmplDoubleColl12);
        }
 
        Double ExtraSmplDoubleColl13 = entity.getExtraSmplDoubleColl13();
        if (ExtraSmplDoubleColl13 != null) {
            stmt.bindDouble(49, ExtraSmplDoubleColl13);
        }
 
        Double ExtraSmplDoubleColl14 = entity.getExtraSmplDoubleColl14();
        if (ExtraSmplDoubleColl14 != null) {
            stmt.bindDouble(50, ExtraSmplDoubleColl14);
        }
 
        Double ExtraSmplDoubleColl15 = entity.getExtraSmplDoubleColl15();
        if (ExtraSmplDoubleColl15 != null) {
            stmt.bindDouble(51, ExtraSmplDoubleColl15);
        }
 
        Double ExtraSmplDoubleColl16 = entity.getExtraSmplDoubleColl16();
        if (ExtraSmplDoubleColl16 != null) {
            stmt.bindDouble(52, ExtraSmplDoubleColl16);
        }
 
        Double ExtraSmplDoubleColl17 = entity.getExtraSmplDoubleColl17();
        if (ExtraSmplDoubleColl17 != null) {
            stmt.bindDouble(53, ExtraSmplDoubleColl17);
        }
 
        Double ExtraSmplDoubleColl18 = entity.getExtraSmplDoubleColl18();
        if (ExtraSmplDoubleColl18 != null) {
            stmt.bindDouble(54, ExtraSmplDoubleColl18);
        }
 
        Double ExtraSmplDoubleColl19 = entity.getExtraSmplDoubleColl19();
        if (ExtraSmplDoubleColl19 != null) {
            stmt.bindDouble(55, ExtraSmplDoubleColl19);
        }
 
        Double ExtraSmplDoubleColl20 = entity.getExtraSmplDoubleColl20();
        if (ExtraSmplDoubleColl20 != null) {
            stmt.bindDouble(56, ExtraSmplDoubleColl20);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public BigSingleTable readEntity(Cursor cursor, int offset) {
        BigSingleTable entity = new BigSingleTable( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // SampleStringColl01
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // SampleStringColl02
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // SampleStringColl03
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // SampleStringColl04
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // SampleStringColl05
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // SampleStringColl06
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // SampleStringColl07
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // SampleStringColl08
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // SampleStringColl09
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // SampleStringColl10
            cursor.getInt(offset + 11), // SampleIntColl01
            cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12), // SampleIntColl02
            cursor.isNull(offset + 13) ? null : cursor.getDouble(offset + 13), // SampleRealColl01
            cursor.isNull(offset + 14) ? null : cursor.getDouble(offset + 14), // SampleRealColl02
            cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15), // SampleIntCollIndexed
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // ExtraSmplStringColl01
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // ExtraSmplStringColl02
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // ExtraSmplStringColl03
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // ExtraSmplStringColl04
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // ExtraSmplStringColl05
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // ExtraSmplStringColl06
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // ExtraSmplStringColl07
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // ExtraSmplStringColl08
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // ExtraSmplStringColl09
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // ExtraSmplStringColl10
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // ExtraSmplStringColl11
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // ExtraSmplStringColl12
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // ExtraSmplStringColl13
            cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29), // ExtraSmplStringColl14
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30), // ExtraSmplStringColl15
            cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31), // ExtraSmplStringColl16
            cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32), // ExtraSmplStringColl17
            cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33), // ExtraSmplStringColl18
            cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34), // ExtraSmplStringColl19
            cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35), // ExtraSmplStringColl20
            cursor.isNull(offset + 36) ? null : cursor.getDouble(offset + 36), // ExtraSmplDoubleColl01
            cursor.isNull(offset + 37) ? null : cursor.getDouble(offset + 37), // ExtraSmplDoubleColl02
            cursor.isNull(offset + 38) ? null : cursor.getDouble(offset + 38), // ExtraSmplDoubleColl03
            cursor.isNull(offset + 39) ? null : cursor.getDouble(offset + 39), // ExtraSmplDoubleColl04
            cursor.isNull(offset + 40) ? null : cursor.getDouble(offset + 40), // ExtraSmplDoubleColl05
            cursor.isNull(offset + 41) ? null : cursor.getDouble(offset + 41), // ExtraSmplDoubleColl06
            cursor.isNull(offset + 42) ? null : cursor.getDouble(offset + 42), // ExtraSmplDoubleColl07
            cursor.isNull(offset + 43) ? null : cursor.getDouble(offset + 43), // ExtraSmplDoubleColl08
            cursor.isNull(offset + 44) ? null : cursor.getDouble(offset + 44), // ExtraSmplDoubleColl09
            cursor.isNull(offset + 45) ? null : cursor.getDouble(offset + 45), // ExtraSmplDoubleColl10
            cursor.isNull(offset + 46) ? null : cursor.getDouble(offset + 46), // ExtraSmplDoubleColl11
            cursor.isNull(offset + 47) ? null : cursor.getDouble(offset + 47), // ExtraSmplDoubleColl12
            cursor.isNull(offset + 48) ? null : cursor.getDouble(offset + 48), // ExtraSmplDoubleColl13
            cursor.isNull(offset + 49) ? null : cursor.getDouble(offset + 49), // ExtraSmplDoubleColl14
            cursor.isNull(offset + 50) ? null : cursor.getDouble(offset + 50), // ExtraSmplDoubleColl15
            cursor.isNull(offset + 51) ? null : cursor.getDouble(offset + 51), // ExtraSmplDoubleColl16
            cursor.isNull(offset + 52) ? null : cursor.getDouble(offset + 52), // ExtraSmplDoubleColl17
            cursor.isNull(offset + 53) ? null : cursor.getDouble(offset + 53), // ExtraSmplDoubleColl18
            cursor.isNull(offset + 54) ? null : cursor.getDouble(offset + 54), // ExtraSmplDoubleColl19
            cursor.isNull(offset + 55) ? null : cursor.getDouble(offset + 55) // ExtraSmplDoubleColl20
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, BigSingleTable entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSampleStringColl01(cursor.getString(offset + 1));
        entity.setSampleStringColl02(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSampleStringColl03(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSampleStringColl04(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSampleStringColl05(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSampleStringColl06(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSampleStringColl07(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setSampleStringColl08(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setSampleStringColl09(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setSampleStringColl10(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setSampleIntColl01(cursor.getInt(offset + 11));
        entity.setSampleIntColl02(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        entity.setSampleRealColl01(cursor.isNull(offset + 13) ? null : cursor.getDouble(offset + 13));
        entity.setSampleRealColl02(cursor.isNull(offset + 14) ? null : cursor.getDouble(offset + 14));
        entity.setSampleIntCollIndexed(cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15));
        entity.setExtraSmplStringColl01(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setExtraSmplStringColl02(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setExtraSmplStringColl03(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setExtraSmplStringColl04(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setExtraSmplStringColl05(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setExtraSmplStringColl06(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setExtraSmplStringColl07(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setExtraSmplStringColl08(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setExtraSmplStringColl09(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setExtraSmplStringColl10(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setExtraSmplStringColl11(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setExtraSmplStringColl12(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setExtraSmplStringColl13(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setExtraSmplStringColl14(cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29));
        entity.setExtraSmplStringColl15(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
        entity.setExtraSmplStringColl16(cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31));
        entity.setExtraSmplStringColl17(cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32));
        entity.setExtraSmplStringColl18(cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33));
        entity.setExtraSmplStringColl19(cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34));
        entity.setExtraSmplStringColl20(cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35));
        entity.setExtraSmplDoubleColl01(cursor.isNull(offset + 36) ? null : cursor.getDouble(offset + 36));
        entity.setExtraSmplDoubleColl02(cursor.isNull(offset + 37) ? null : cursor.getDouble(offset + 37));
        entity.setExtraSmplDoubleColl03(cursor.isNull(offset + 38) ? null : cursor.getDouble(offset + 38));
        entity.setExtraSmplDoubleColl04(cursor.isNull(offset + 39) ? null : cursor.getDouble(offset + 39));
        entity.setExtraSmplDoubleColl05(cursor.isNull(offset + 40) ? null : cursor.getDouble(offset + 40));
        entity.setExtraSmplDoubleColl06(cursor.isNull(offset + 41) ? null : cursor.getDouble(offset + 41));
        entity.setExtraSmplDoubleColl07(cursor.isNull(offset + 42) ? null : cursor.getDouble(offset + 42));
        entity.setExtraSmplDoubleColl08(cursor.isNull(offset + 43) ? null : cursor.getDouble(offset + 43));
        entity.setExtraSmplDoubleColl09(cursor.isNull(offset + 44) ? null : cursor.getDouble(offset + 44));
        entity.setExtraSmplDoubleColl10(cursor.isNull(offset + 45) ? null : cursor.getDouble(offset + 45));
        entity.setExtraSmplDoubleColl11(cursor.isNull(offset + 46) ? null : cursor.getDouble(offset + 46));
        entity.setExtraSmplDoubleColl12(cursor.isNull(offset + 47) ? null : cursor.getDouble(offset + 47));
        entity.setExtraSmplDoubleColl13(cursor.isNull(offset + 48) ? null : cursor.getDouble(offset + 48));
        entity.setExtraSmplDoubleColl14(cursor.isNull(offset + 49) ? null : cursor.getDouble(offset + 49));
        entity.setExtraSmplDoubleColl15(cursor.isNull(offset + 50) ? null : cursor.getDouble(offset + 50));
        entity.setExtraSmplDoubleColl16(cursor.isNull(offset + 51) ? null : cursor.getDouble(offset + 51));
        entity.setExtraSmplDoubleColl17(cursor.isNull(offset + 52) ? null : cursor.getDouble(offset + 52));
        entity.setExtraSmplDoubleColl18(cursor.isNull(offset + 53) ? null : cursor.getDouble(offset + 53));
        entity.setExtraSmplDoubleColl19(cursor.isNull(offset + 54) ? null : cursor.getDouble(offset + 54));
        entity.setExtraSmplDoubleColl20(cursor.isNull(offset + 55) ? null : cursor.getDouble(offset + 55));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(BigSingleTable entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(BigSingleTable entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
