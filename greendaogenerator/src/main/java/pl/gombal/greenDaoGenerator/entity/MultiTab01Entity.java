package pl.gombal.greenDaoGenerator.entity;

import de.greenrobot.daogenerator.Entity;

/**
 * Created by gombal on 19.06.2015.
 */
public class MultiTab01Entity extends BaseEntity {

    public static final String TABLE_NAME = "MultiTable_01";

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected void addExtraProperties(Entity entity) {

    }
}
