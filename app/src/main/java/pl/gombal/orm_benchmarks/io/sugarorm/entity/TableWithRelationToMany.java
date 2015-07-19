package pl.gombal.orm_benchmarks.io.sugarorm.entity;


import android.provider.BaseColumns;

import java.util.List;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

public class TableWithRelationToMany extends BaseSampleEntity<TableWithRelationToMany> {

    public TableWithRelationToMany() {
    }

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

        return table;
    }

    public List<TableWithRelationToOne> getTableWithRelationToOneList() {
        return TableWithRelationToOne.find(TableWithRelationToOne.class, BaseColumns._ID + " = ?", String.valueOf(this.getId()));
    }

}
