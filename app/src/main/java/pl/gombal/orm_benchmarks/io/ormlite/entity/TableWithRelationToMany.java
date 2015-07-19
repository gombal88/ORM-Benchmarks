package pl.gombal.orm_benchmarks.io.ormlite.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@DatabaseTable(tableName = TableWithRelationToMany.TABLE_NAME)
public class TableWithRelationToMany extends BaseSampleEntity {

    public static final String TABLE_NAME = "TABLE_WITH_RELATION_TO_MANY";
    public static final String FOREIGN_TABLE_TO_ONE_COLLECTION_FIELD_NAME = "tableWithRelationToOneList";

    @ForeignCollectionField(eager = false, columnName = FOREIGN_TABLE_TO_ONE_COLLECTION_FIELD_NAME)
    private ForeignCollection<TableWithRelationToOne> tableWithRelationToOneList;


    public static TableWithRelationToMany getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        return getNewEntityWithRandomData(null, generatorUtils);
    }

    public static TableWithRelationToMany getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils) {
        TableWithRelationToMany table = new TableWithRelationToMany();
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

        return table;
    }

    public ForeignCollection<TableWithRelationToOne> getTableWithRelationToOneList() {
        return tableWithRelationToOneList;
    }

    public void setTableWithRelationToOneList(ForeignCollection<TableWithRelationToOne> tableWithRelationToOneList) {
        this.tableWithRelationToOneList = tableWithRelationToOneList;
    }

}
