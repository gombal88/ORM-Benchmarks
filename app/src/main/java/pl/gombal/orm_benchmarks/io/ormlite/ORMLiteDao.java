package pl.gombal.orm_benchmarks.io.ormlite;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import pl.gombal.orm_benchmarks.io.ormlite.ORMLiteDataBaseOpenHelper;

public class ORMLiteDao<Entity, PrimaryKeyType> {

    private Class<Entity> type;

    public ORMLiteDao(Class<Entity> type) {
        this.type = type;
    }

    public Dao<Entity, PrimaryKeyType> getDao() {
        Dao<Entity, PrimaryKeyType> dao = null;
        try {
            dao = ORMLiteDataBaseOpenHelper.getInstance().getDao(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dao;
    }
}
