package pl.gombal.orm_benchmarks.io.sqlite.entity;

import java.util.ArrayList;
import java.util.List;

import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

public class TableWithRelationToMany extends BaseSampleEntity {

    private List<TableWithRelationToOne> tableWithRelationToOneList;

    public TableWithRelationToMany() {
    }

    public TableWithRelationToMany(long id) {
        super(id);
    }

    public TableWithRelationToMany(long id, String sampleStringColl01, String sampleStringColl02, String sampleStringColl03, String sampleStringColl04, String sampleStringColl05,
                                   String sampleStringColl06, String sampleStringColl07, String sampleStringColl08, String sampleStringColl09, String sampleStringColl10,
                                   int sampleIntColl01, Integer sampleIntColl02, Double sampleRealColl01, Double sampleRealColl02, Integer sampleIntCollIndexed) {

        super(id, sampleStringColl01, sampleStringColl02, sampleStringColl03, sampleStringColl04, sampleStringColl05,
                sampleStringColl06, sampleStringColl07, sampleStringColl08, sampleStringColl09, sampleStringColl10,
                sampleIntColl01, sampleIntColl02, sampleRealColl01, sampleRealColl02, sampleIntCollIndexed);

    }

    public static TableWithRelationToMany getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils, int childCount) {
        return getNewEntityWithRandomData(null, generatorUtils, childCount);
    }

    public static TableWithRelationToMany getNewEntityWithRandomData(Long id, EntityFieldGeneratorUtils generatorUtils, int childCount) {
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

        List<TableWithRelationToOne> childList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            EntityFieldGeneratorUtils generatorUtilsToOne =
                    EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.RAW_SQL_ENTITY_FIELD_GENERATOR_ID + 50, generatorUtils.getUniqueNumberRange() * childCount);
            childList.add(TableWithRelationToOne.getNewEntityWithRandomData(table, generatorUtilsToOne.getNextUniqueRandomInt()));
        }
        table.setTableWithRelationToOneList(childList);
        return table;
    }

    public List<TableWithRelationToOne> getTableWithRelationToOneList() {
        return tableWithRelationToOneList;
    }

    public void setTableWithRelationToOneList(List<TableWithRelationToOne> tableWithRelationToOneList) {
        this.tableWithRelationToOneList = tableWithRelationToOneList;
    }
}
