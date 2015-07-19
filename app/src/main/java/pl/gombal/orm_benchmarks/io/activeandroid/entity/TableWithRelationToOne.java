package pl.gombal.orm_benchmarks.io.activeandroid.entity;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

@Table(name = TableWithRelationToOne.TABLE_NAME, id = BaseColumns._ID)
public class TableWithRelationToOne extends BaseSimpleEntity {

    public static final String TABLE_NAME = "TABLE_WITH_RELATION_TO_ONE";

    public static final String TABLE_WITH_RELATION_TO_MANY_ID = "TABLE_WITH_RELATION_TO_MANY_ID";


    @Column(name = TABLE_WITH_RELATION_TO_MANY_ID)
    private TableWithRelationToMany tableWithRelationToMany;

    public TableWithRelationToOne() {
        super();
    }

    public static TableWithRelationToOne getNewEntityWithRandomData(TableWithRelationToMany parent, EntityFieldGeneratorUtils generatorUtils) {
        TableWithRelationToOne table = new TableWithRelationToOne();

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
