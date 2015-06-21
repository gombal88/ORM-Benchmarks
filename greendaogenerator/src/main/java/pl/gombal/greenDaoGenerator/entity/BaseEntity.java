package pl.gombal.greenDaoGenerator.entity;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToOne;

/**
 * Created by gombal on 19.06.2015.
 */
public abstract class BaseEntity {

    public static final String SAMPLE_STRING_COLL_01 = "SampleStringColl01";
    public static final String SAMPLE_STRING_COLL_02 = "SampleStringColl02";
    public static final String SAMPLE_STRING_COLL_03 = "SampleStringColl03";
    public static final String SAMPLE_STRING_COLL_04 = "SampleStringColl04";
    public static final String SAMPLE_STRING_COLL_05 = "SampleStringColl05";
    public static final String SAMPLE_STRING_COLL_06 = "SampleStringColl06";
    public static final String SAMPLE_STRING_COLL_07 = "SampleStringColl07";
    public static final String SAMPLE_STRING_COLL_08 = "SampleStringColl08";
    public static final String SAMPLE_STRING_COLL_09 = "SampleStringColl09";
    public static final String SAMPLE_STRING_COLL_10 = "SampleStringColl10";
    public static final String SAMPLE_INT_COLL_01 = "SampleIntColl01";
    public static final String SAMPLE_INT_COLL_02 = "SampleIntColl02";
    public static final String SAMPLE_REAL_COLL_01 = "SampleRealColl01";
    public static final String SAMPLE_REAL_COLL_02 = "SampleRealColl02";
    public static final String SAMPLE_INT_COLL_INDEXED = "SampleIntCollIndexed";

    private Entity entity = null;


    protected abstract String getTableName();

    protected abstract void addExtraProperties(Entity entity);

    public BaseEntity addRelationToOne(BaseEntity relationTO) {
        if (entity == null)
            throw new IllegalStateException("Create entity first!");

        Property relationProperty = entity.addLongProperty(relationTO.getTableName() + "Id").getProperty();
        ToOne toOne = entity.addToOne(relationTO.getEntity(), relationProperty);
//        toOne.setName(relationTO.getTableName());

        return this;
    }

    public BaseEntity addRelationToMany(BaseEntity relationTO) {
        if (entity == null)
            throw new IllegalStateException("Create entity first!");

        Property relationProperty = relationTO.getEntity().addLongProperty(relationTO.getTableName() + "Id").notNull().getProperty();
        entity.addToMany(relationTO.getEntity(), relationProperty);

        return this;
    }

    public BaseEntity createEntity(Schema schema) {
        entity = schema.addEntity(getTableName());
        entity.addIdProperty().autoincrement();
        entity.addStringProperty(SAMPLE_STRING_COLL_01).notNull();
        entity.addStringProperty(SAMPLE_STRING_COLL_02);
        entity.addStringProperty(SAMPLE_STRING_COLL_03);
        entity.addStringProperty(SAMPLE_STRING_COLL_04);
        entity.addStringProperty(SAMPLE_STRING_COLL_05);
        entity.addStringProperty(SAMPLE_STRING_COLL_06);
        entity.addStringProperty(SAMPLE_STRING_COLL_07);
        entity.addStringProperty(SAMPLE_STRING_COLL_08);
        entity.addStringProperty(SAMPLE_STRING_COLL_09);
        entity.addStringProperty(SAMPLE_STRING_COLL_10);
        entity.addIntProperty(SAMPLE_INT_COLL_01).notNull();
        entity.addIntProperty(SAMPLE_INT_COLL_02);
        entity.addDoubleProperty(SAMPLE_REAL_COLL_01);
        entity.addDoubleProperty(SAMPLE_REAL_COLL_02);
        entity.addIntProperty(SAMPLE_INT_COLL_INDEXED).index();

        addExtraProperties(entity);

        return this;
    }

    public Entity getEntity() {
        return entity;
    }
}
