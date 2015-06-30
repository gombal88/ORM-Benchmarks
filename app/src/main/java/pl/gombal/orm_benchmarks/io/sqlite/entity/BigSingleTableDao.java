package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import pl.gombal.orm_benchmarks.io.sqlite.SelectionBuilder;

public class BigSingleTableDao extends BaseSampleDao<BigSingleTable> {

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


    public BigSingleTableDao() {
        super("BIG_SINGLE_TABLE");
    }

    @Override
    public String getCreateTableStatement(boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        return "CREATE TABLE " + constraint + tableName + " ("
                + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SAMPLE_STRING_COLL_01 + " TEXT NOT NULL ,"
                + SAMPLE_STRING_COLL_02 + " TEXT, "
                + SAMPLE_STRING_COLL_03 + " TEXT, "
                + SAMPLE_STRING_COLL_04 + " TEXT, "
                + SAMPLE_STRING_COLL_05 + " TEXT, "
                + SAMPLE_STRING_COLL_06 + " TEXT, "
                + SAMPLE_STRING_COLL_07 + " TEXT, "
                + SAMPLE_STRING_COLL_08 + " TEXT, "
                + SAMPLE_STRING_COLL_09 + " TEXT, "
                + SAMPLE_STRING_COLL_10 + " TEXT, "
                + SAMPLE_INT_COLL_01 + " INTEGER NOT NULL, "
                + SAMPLE_INT_COLL_02 + " INTEGER, "
                + SAMPLE_REAL_COLL_01 + " REAL, "
                + SAMPLE_REAL_COLL_02 + " REAL, "
                + SAMPLE_INT_COLL_INDEXED + " INTEGER, "
                + EXTRA_SAMPLE_STRING_COLL_01 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_02 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_03 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_04 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_05 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_06 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_07 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_08 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_09 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_10 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_11 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_12 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_13 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_14 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_15 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_16 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_17 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_18 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_19 + " TEXT, "
                + EXTRA_SAMPLE_STRING_COLL_20 + " TEXT, "
                + EXTRA_SAMPLE_DOUBLE_COLL_01 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_02 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_03 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_04 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_05 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_06 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_07 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_08 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_09 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_10 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_11 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_12 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_13 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_14 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_15 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_16 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_17 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_18 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_19 + " REAL, "
                + EXTRA_SAMPLE_DOUBLE_COLL_20 + " REAL);";
    }

    @Override
    public String[] getCreateIndexStatements(boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        return new String[]{"CREATE INDEX " + constraint
                + "IDX_BIG_SINGLE_TABLE_SAMPLE_INT_COLL_INDEXED ON "
                + tableName + " (" + SAMPLE_INT_COLL_INDEXED + " );"};
    }

    @Override
    public String getDropTableStatement(boolean ifExists) {
        return "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + tableName;
    }

    @Override
    public String[] getColumns() {
        return new String[]{
                SAMPLE_STRING_COLL_01,
                SAMPLE_STRING_COLL_02,
                SAMPLE_STRING_COLL_03,
                SAMPLE_STRING_COLL_04,
                SAMPLE_STRING_COLL_05,
                SAMPLE_STRING_COLL_06,
                SAMPLE_STRING_COLL_07,
                SAMPLE_STRING_COLL_08,
                SAMPLE_STRING_COLL_09,
                SAMPLE_STRING_COLL_10,
                SAMPLE_INT_COLL_01,
                SAMPLE_INT_COLL_02,
                SAMPLE_REAL_COLL_01,
                SAMPLE_REAL_COLL_02,
                SAMPLE_INT_COLL_INDEXED,
                EXTRA_SAMPLE_STRING_COLL_01,
                EXTRA_SAMPLE_STRING_COLL_02,
                EXTRA_SAMPLE_STRING_COLL_03,
                EXTRA_SAMPLE_STRING_COLL_04,
                EXTRA_SAMPLE_STRING_COLL_05,
                EXTRA_SAMPLE_STRING_COLL_06,
                EXTRA_SAMPLE_STRING_COLL_07,
                EXTRA_SAMPLE_STRING_COLL_08,
                EXTRA_SAMPLE_STRING_COLL_09,
                EXTRA_SAMPLE_STRING_COLL_10,
                EXTRA_SAMPLE_STRING_COLL_11,
                EXTRA_SAMPLE_STRING_COLL_12,
                EXTRA_SAMPLE_STRING_COLL_13,
                EXTRA_SAMPLE_STRING_COLL_14,
                EXTRA_SAMPLE_STRING_COLL_15,
                EXTRA_SAMPLE_STRING_COLL_16,
                EXTRA_SAMPLE_STRING_COLL_17,
                EXTRA_SAMPLE_STRING_COLL_18,
                EXTRA_SAMPLE_STRING_COLL_19,
                EXTRA_SAMPLE_STRING_COLL_20,
                EXTRA_SAMPLE_DOUBLE_COLL_01,
                EXTRA_SAMPLE_DOUBLE_COLL_02,
                EXTRA_SAMPLE_DOUBLE_COLL_03,
                EXTRA_SAMPLE_DOUBLE_COLL_04,
                EXTRA_SAMPLE_DOUBLE_COLL_05,
                EXTRA_SAMPLE_DOUBLE_COLL_06,
                EXTRA_SAMPLE_DOUBLE_COLL_07,
                EXTRA_SAMPLE_DOUBLE_COLL_08,
                EXTRA_SAMPLE_DOUBLE_COLL_09,
                EXTRA_SAMPLE_DOUBLE_COLL_10,
                EXTRA_SAMPLE_DOUBLE_COLL_11,
                EXTRA_SAMPLE_DOUBLE_COLL_12,
                EXTRA_SAMPLE_DOUBLE_COLL_13,
                EXTRA_SAMPLE_DOUBLE_COLL_14,
                EXTRA_SAMPLE_DOUBLE_COLL_15,
                EXTRA_SAMPLE_DOUBLE_COLL_16,
                EXTRA_SAMPLE_DOUBLE_COLL_17,
                EXTRA_SAMPLE_DOUBLE_COLL_18,
                EXTRA_SAMPLE_DOUBLE_COLL_19,
                EXTRA_SAMPLE_DOUBLE_COLL_20};
    }

    @Override
    protected long saveAction(SQLiteDatabase db, BigSingleTable entity) {
        SelectionBuilder builder = new SelectionBuilder();
        long id = builder.table(tableName).insert(db, entity.getContentValues());
        entity.setId(id);
        return id;
    }

    @Override
    protected int updateAction(SQLiteDatabase db, BigSingleTable entity, String selection, String[] selectionArgs) {
        SelectionBuilder builder = new SelectionBuilder();
        return builder.table(tableName).where(selection, selectionArgs).update(db, entity.getContentValues());
    }
}
