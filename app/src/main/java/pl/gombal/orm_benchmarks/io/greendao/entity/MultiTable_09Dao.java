package pl.gombal.orm_benchmarks.io.greendao.entity;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_09;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table MULTI_TABLE_09.
*/
public class MultiTable_09Dao extends AbstractDao<MultiTable_09, Long> {

    public static final String TABLENAME = "MULTI_TABLE_09";

    /**
     * Properties of entity MultiTable_09.<br/>
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
        public final static Property MultiTable_10Id = new Property(16, Long.class, "MultiTable_10Id", false, "MULTI_TABLE_10_ID");
    };

    private DaoSession daoSession;


    public MultiTable_09Dao(DaoConfig config) {
        super(config);
    }
    
    public MultiTable_09Dao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'MULTI_TABLE_09' (" + //
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
                "'MULTI_TABLE_10_ID' INTEGER);"); // 16: MultiTable_10Id
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_MULTI_TABLE_09_SAMPLE_INT_COLL_INDEXED ON MULTI_TABLE_09" +
                " (SAMPLE_INT_COLL_INDEXED);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'MULTI_TABLE_09'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MultiTable_09 entity) {
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
 
        Long MultiTable_10Id = entity.getMultiTable_10Id();
        if (MultiTable_10Id != null) {
            stmt.bindLong(17, MultiTable_10Id);
        }
    }

    @Override
    protected void attachEntity(MultiTable_09 entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public MultiTable_09 readEntity(Cursor cursor, int offset) {
        MultiTable_09 entity = new MultiTable_09( //
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
            cursor.isNull(offset + 16) ? null : cursor.getLong(offset + 16) // MultiTable_10Id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MultiTable_09 entity, int offset) {
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
        entity.setMultiTable_10Id(cursor.isNull(offset + 16) ? null : cursor.getLong(offset + 16));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(MultiTable_09 entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(MultiTable_09 entity) {
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
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getMultiTable_10Dao().getAllColumns());
            builder.append(" FROM MULTI_TABLE_09 T");
            builder.append(" LEFT JOIN MULTI_TABLE_10 T0 ON T.'MULTI_TABLE_10_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected MultiTable_09 loadCurrentDeep(Cursor cursor, boolean lock) {
        MultiTable_09 entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        MultiTable_10 multiTable_10 = loadCurrentOther(daoSession.getMultiTable_10Dao(), cursor, offset);
        entity.setMultiTable_10(multiTable_10);

        return entity;    
    }

    public MultiTable_09 loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<MultiTable_09> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<MultiTable_09> list = new ArrayList<MultiTable_09>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<MultiTable_09> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<MultiTable_09> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
