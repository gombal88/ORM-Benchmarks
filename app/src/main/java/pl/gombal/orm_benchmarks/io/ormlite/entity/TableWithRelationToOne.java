package pl.gombal.orm_benchmarks.io.ormlite.entity;


import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = TableWithRelationToOne.TABLE_NAME)
public class TableWithRelationToOne extends BaseSampleEntity {

    public static final String TABLE_NAME = "TABLE_WITH_RELATION_TO_ONE";

    public static final String TABLE_WITH_RELATION_TO_MANY_ID = "TABLE_WITH_RELATION_TO_MANY_ID";


    @DatabaseField(columnName = TABLE_WITH_RELATION_TO_MANY_ID, foreign = true,
            columnDefinition = "integer references " + TableWithRelationToMany.TABLE_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private TableWithRelationToMany tableWithRelationToMany;

    public TableWithRelationToMany getTableWithRelationToMany() {
        return tableWithRelationToMany;
    }

    public void setTableWithRelationToMany(TableWithRelationToMany tableWithRelationToMany) {
        this.tableWithRelationToMany = tableWithRelationToMany;
    }
}
