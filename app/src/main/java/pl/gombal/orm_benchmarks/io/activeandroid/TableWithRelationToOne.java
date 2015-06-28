package pl.gombal.orm_benchmarks.io.activeandroid;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = TableWithRelationToOne.TABLE_NAME, id = BaseColumns._ID)
public class TableWithRelationToOne extends BaseSimpleEntity {

    public static final String TABLE_NAME = "TABLE_WITH_RELATION_TO_ONE";

    public static final String TABLE_WITH_RELATION_TO_MANY_ID = "TABLE_WITH_RELATION_TO_MANY_ID";


    @Column(name = TABLE_WITH_RELATION_TO_MANY_ID)
    private TableWithRelationToMany tableWithRelationToMany;

    public TableWithRelationToOne() {
        super();
    }

    public TableWithRelationToMany getTableWithRelationToMany() {
        return tableWithRelationToMany;
    }

    public void setTableWithRelationToMany(TableWithRelationToMany tableWithRelationToMany) {
        this.tableWithRelationToMany = tableWithRelationToMany;
    }
}
