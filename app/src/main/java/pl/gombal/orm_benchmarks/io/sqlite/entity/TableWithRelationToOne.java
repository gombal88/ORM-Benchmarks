package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;

import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;

public class TableWithRelationToOne extends BaseSampleEntity {

    private TableWithRelationToMany TableWithRelationToMany;

    public TableWithRelationToOne() {

    }

    public TableWithRelationToOne(long id) {
        super(id);
    }

    public TableWithRelationToOne(long id, String sampleStringColl01, String sampleStringColl02, String sampleStringColl03, String sampleStringColl04, String sampleStringColl05,
                                  String sampleStringColl06, String sampleStringColl07, String sampleStringColl08, String sampleStringColl09, String sampleStringColl10,
                                  int sampleIntColl01, Integer sampleIntColl02, Double sampleRealColl01, Double sampleRealColl02, Integer sampleIntCollIndexed, TableWithRelationToMany TableWithRelationToMany) {

        super(id, sampleStringColl01, sampleStringColl02, sampleStringColl03, sampleStringColl04, sampleStringColl05,
                sampleStringColl06, sampleStringColl07, sampleStringColl08, sampleStringColl09, sampleStringColl10,
                sampleIntColl01, sampleIntColl02, sampleRealColl01, sampleRealColl02, sampleIntCollIndexed);

        this.TableWithRelationToMany = TableWithRelationToMany;
    }

    protected static TableWithRelationToOne getNewEntityWithRandomData(TableWithRelationToMany parent, int generatedIndexedInt) {
        return getNewEntityWithRandomData(null, parent, generatedIndexedInt);
    }

    public static TableWithRelationToOne getNewEntityWithRandomData(Long id, TableWithRelationToMany parent, int generatedIndexedInt) {
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
        table.setSampleIntCollIndexed(generatedIndexedInt);

        table.setTableWithRelationToMany(parent);
        return table;
    }

    public ContentValues getContentValues() {
        ContentValues values = super.getContentValues();
        values.put(TableWithRelationToOneDao.TABLE_WITH_RELATION_TO_MANY_ID, TableWithRelationToMany.getId());

        return values;
    }

    public TableWithRelationToMany getTableWithRelationToMany() {
        return TableWithRelationToMany;
    }

    public void setTableWithRelationToMany(TableWithRelationToMany TableWithRelationToMany) {
        this.TableWithRelationToMany = TableWithRelationToMany;
    }
}
