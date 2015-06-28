package pl.gombal.orm_benchmarks.io.activeandroid;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Table;

import java.util.List;

@Table(name = TableWithRelationToMany.TABLE_NAME, id = BaseColumns._ID)
public class TableWithRelationToMany extends BaseSimpleEntity {

    public static final String TABLE_NAME = "TABLE_WITH_RELATION_TO_MANY";

    public TableWithRelationToMany() {
        super();
    }

    public List<TableWithRelationToOne> getTableWithRelationToOneList() {
        return getMany(TableWithRelationToOne.class, TableWithRelationToOne.TABLE_WITH_RELATION_TO_MANY_ID);
    }

}
