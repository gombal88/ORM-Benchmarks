package pl.gombal.greenDaoGenerator.entity;

import de.greenrobot.daogenerator.Entity;

/**
 * Created by gombal on 19.06.2015.
 */
public class SingleTabEntity extends BaseEntity{

    public static final String TABLE_NAME = "SingleTable";


    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected void addExtraProperties(Entity entity) {

    }
}
