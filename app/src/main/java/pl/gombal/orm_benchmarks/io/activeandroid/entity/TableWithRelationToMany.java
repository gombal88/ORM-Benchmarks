package pl.gombal.orm_benchmarks.io.activeandroid.entity;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Table;

import java.util.List;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@Table(name = TableWithRelationToMany.TABLE_NAME, id = BaseColumns._ID)
public class TableWithRelationToMany extends BaseSimpleEntity {

    public static final String TABLE_NAME = "TABLE_WITH_RELATION_TO_MANY";

    public TableWithRelationToMany() {
        super();
    }

    public static TableWithRelationToMany getNewEntityWithRandomData(EntityFieldGeneratorUtils generatorUtils) {
        TableWithRelationToMany table = new TableWithRelationToMany();

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

    public List<TableWithRelationToOne> getTableWithRelationToOneList() {
        return getMany(TableWithRelationToOne.class, TableWithRelationToOne.TABLE_WITH_RELATION_TO_MANY_ID);
    }

}
