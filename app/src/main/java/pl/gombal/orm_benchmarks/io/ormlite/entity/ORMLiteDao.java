package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.os.Message;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import pl.gombal.orm_benchmarks.io.ormlite.ORMLiteDataBaseOpenHelper;

public class ORMLiteDao<Entity, PrimaryKeyType> {

    public static Dao<Entity, PrimaryKeyType> getDao() {
        if (sDao == null) {
            try {
                sDao = ORMLiteDataBaseOpenHelper.getInstance().getDao(Message.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sDao;
    }
}
