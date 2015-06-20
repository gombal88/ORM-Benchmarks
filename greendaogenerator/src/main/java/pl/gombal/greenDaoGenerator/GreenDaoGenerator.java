package pl.gombal.greenDaoGenerator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Schema;
import pl.gombal.greenDaoGenerator.entity.BaseEntity;
import pl.gombal.greenDaoGenerator.entity.BigSingleTabEntity;
import pl.gombal.greenDaoGenerator.entity.MultiTab01Entity;
import pl.gombal.greenDaoGenerator.entity.MultiTab02Entity;
import pl.gombal.greenDaoGenerator.entity.MultiTab03Entity;
import pl.gombal.greenDaoGenerator.entity.MultiTab04Entity;
import pl.gombal.greenDaoGenerator.entity.MultiTab05Entity;
import pl.gombal.greenDaoGenerator.entity.MultiTab06Entity;
import pl.gombal.greenDaoGenerator.entity.MultiTab07Entity;
import pl.gombal.greenDaoGenerator.entity.MultiTab08Entity;
import pl.gombal.greenDaoGenerator.entity.MultiTab09Entity;
import pl.gombal.greenDaoGenerator.entity.MultiTab10Entity;
import pl.gombal.greenDaoGenerator.entity.SingleTabEntity;
import pl.gombal.greenDaoGenerator.entity.TabWithRelationToManyEntity;
import pl.gombal.greenDaoGenerator.entity.TabWithRelationToOneEntity;

public class GreenDaoGenerator {

    private static final int DB_VERSION = 7;
    private static final String DEFAULT_JAVA_PACKAGE = "pl.gombal.orm_benchmarks.io.greendao";

    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(DB_VERSION, DEFAULT_JAVA_PACKAGE);
        new SingleTabEntity().createEntity(schema);

        BaseEntity entity10 = new MultiTab10Entity().createEntity(schema);
        BaseEntity entity09 = new MultiTab09Entity().createEntity(schema).addRelationToOne(entity10);
        BaseEntity entity08 = new MultiTab08Entity().createEntity(schema).addRelationToOne(entity09);
        BaseEntity entity07 = new MultiTab07Entity().createEntity(schema).addRelationToOne(entity08);
        BaseEntity entity06 = new MultiTab06Entity().createEntity(schema).addRelationToOne(entity07);
        BaseEntity entity05 = new MultiTab05Entity().createEntity(schema).addRelationToOne(entity06);
        BaseEntity entity04 = new MultiTab04Entity().createEntity(schema).addRelationToOne(entity05);
        BaseEntity entity03 = new MultiTab03Entity().createEntity(schema).addRelationToOne(entity04);
        BaseEntity entity02 = new MultiTab02Entity().createEntity(schema).addRelationToOne(entity03);
        BaseEntity entity01 = new MultiTab01Entity().createEntity(schema).addRelationToOne(entity02);

        new BigSingleTabEntity().createEntity(schema);

        BaseEntity tabWithRelationToMany = new TabWithRelationToManyEntity().createEntity(schema);
        BaseEntity tabWithRelationToOne = new TabWithRelationToOneEntity().createEntity(schema);

        tabWithRelationToMany.addRelationToMany(tabWithRelationToOne);
        tabWithRelationToOne.addRelationToOne(tabWithRelationToMany);

        new DaoGenerator().generateAll(schema, args[0]);

    }
}
