package pl.gombal.orm_benchmarks.io.ormlite.entity;


import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = SingleTable.TABLE_NAME)
public class SingleTable extends BaseSampleEntity {

    public static final String TABLE_NAME = "SINGLE_TABLE";

}
