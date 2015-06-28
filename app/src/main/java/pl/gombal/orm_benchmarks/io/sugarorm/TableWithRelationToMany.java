package pl.gombal.orm_benchmarks.io.sugarorm;


import java.util.List;

public class TableWithRelationToMany extends BaseSampleEntity<TableWithRelationToMany> {

    private List<TableWithRelationToOne> tableWithRelationToOneList;

    public TableWithRelationToMany() {
    }

    public List<TableWithRelationToOne> getTableWithRelationToOneList() {
        return tableWithRelationToOneList;
    }

    public void setTableWithRelationToOneList(List<TableWithRelationToOne> tableWithRelationToOneList) {
        this.tableWithRelationToOneList = tableWithRelationToOneList;
    }
}
