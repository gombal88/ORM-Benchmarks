package pl.gombal.orm_benchmarks.io.sugarorm.entity;


import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

public class TableWithRelationToOne extends BaseSampleEntity {

    private TableWithRelationToMany tableWithRelationToMany;

    public TableWithRelationToOne() {

    }

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
