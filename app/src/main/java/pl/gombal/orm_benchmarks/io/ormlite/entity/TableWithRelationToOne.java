package pl.gombal.orm_benchmarks.io.ormlite.entity;


import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@DatabaseTable(tableName = TableWithRelationToOne.TABLE_NAME)
public class TableWithRelationToOne extends BaseSampleEntity {

    public static final String TABLE_NAME = "TABLE_WITH_RELATION_TO_ONE";

    public static final String TABLE_WITH_RELATION_TO_MANY_ID = "TABLE_WITH_RELATION_TO_MANY_ID";


    @DatabaseField(columnName = TABLE_WITH_RELATION_TO_MANY_ID, foreign = true,
            columnDefinition = "integer references " + TableWithRelationToMany.TABLE_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private TableWithRelationToMany tableWithRelationToMany;


    public static TableWithRelationToOne getNewEntityWithRandomData(TableWithRelationToMany parent, EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, parent, generatorUtils);
    }

    public static TableWithRelationToOne getNewEntityWithRandomData(Long id, TableWithRelationToMany parent, EntityFieldGeneratorUtils generatorUtils) {
        TableWithRelationToOne table = new TableWithRelationToOne();
        if (id != null)
            table.setId(id);
        table.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        table.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        table.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        table.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        table.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        table.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());

        table.setTableWithRelationToMany(parent);

        return table;
    }

    public TableWithRelationToMany getTableWithRelationToMany() {
        return tableWithRelationToMany;
    }

    public void setTableWithRelationToMany(TableWithRelationToMany tableWithRelationToMany) {
        this.tableWithRelationToMany = tableWithRelationToMany;
    }
}
