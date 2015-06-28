package pl.gombal.orm_benchmarks.io.ormlite.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = TableWithRelationToMany.TABLE_NAME)
public class TableWithRelationToMany extends BaseSampleEntity {

    public static final String TABLE_NAME = "TABLE_WITH_RELATION_TO_MANY";

    @ForeignCollectionField(eager = false, columnName = "tableWithRelationToOneList")
    private ForeignCollection<TableWithRelationToOne> tableWithRelationToOneList;

    public ForeignCollection<TableWithRelationToOne> getTableWithRelationToOneList() {
        return tableWithRelationToOneList;
    }

    public void setTableWithRelationToOneList(ForeignCollection<TableWithRelationToOne> tableWithRelationToOneList) {
        this.tableWithRelationToOneList = tableWithRelationToOneList;
    }
}
