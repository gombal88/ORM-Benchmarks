package pl.gombal.orm_benchmarks.io.sugarorm;


public class TableWithRelationToOne extends BaseSampleEntity<TableWithRelationToOne> {

    private TableWithRelationToMany tableWithRelationToMany;

    public TableWithRelationToOne() {

    }

    public TableWithRelationToMany getTableWithRelationToMany() {
        return tableWithRelationToMany;
    }

    public void setTableWithRelationToMany(TableWithRelationToMany tableWithRelationToMany) {
        this.tableWithRelationToMany = tableWithRelationToMany;
    }
}
