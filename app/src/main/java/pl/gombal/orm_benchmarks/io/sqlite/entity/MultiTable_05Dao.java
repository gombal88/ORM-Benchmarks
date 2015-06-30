package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.database.sqlite.SQLiteDatabase;

import pl.gombal.orm_benchmarks.io.sqlite.SelectionBuilder;

public class MultiTable_05Dao extends BaseSampleDao<MultiTable_05> {

    public static final String TABLE_NAME = "MULTI_TABLE_05";

    public static final String MULTI_TABLE_06_ID = "MULTI_TABLE_06_ID";

    public MultiTable_05Dao() {
        super(TABLE_NAME, true);
    }

    @Override
    public String getCreateTableStatement(boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        return "CREATE TABLE " + constraint + tableName + " ("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
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
                + SAMPLE_REAL_COLL_01 + " REAL ,"
                + SAMPLE_REAL_COLL_02 + " REAL ,"
                + SAMPLE_INT_COLL_INDEXED + " INTEGER, "
                + MULTI_TABLE_06_ID + " INTEGER, "
                + "FOREIGN KEY(" + MULTI_TABLE_06_ID + ") REFERENCES " + MultiTable_06Dao.TABLE_NAME + "(" + _ID + ") ON DELETE CASCADE ON UPDATE CASCADE);";
    }

    @Override
    public String[] getCreateIndexStatements(boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        return new String[]{"CREATE INDEX " + constraint
                + "IDX_MULTI_TABLE_05_SAMPLE_INT_COLL_INDEXED ON "
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
                MULTI_TABLE_06_ID};
    }

    @Override
    protected long saveAction(SQLiteDatabase db, MultiTable_05 entity) {
        SelectionBuilder builder = new SelectionBuilder();
        long id = builder.table(tableName).insert(db, entity.getContentValues());
        entity.setId(id);
        new MultiTable_06Dao().saveAction(db, entity.getMultiTable_06());
        return id;
    }

    @Override
    protected int updateAction(SQLiteDatabase db, MultiTable_05 entity, String selection, String[] selectionArgs) {
        SelectionBuilder builder = new SelectionBuilder();
        return builder.table(tableName).where(selection, selectionArgs).update(db, entity.getContentValues());
    }
}
