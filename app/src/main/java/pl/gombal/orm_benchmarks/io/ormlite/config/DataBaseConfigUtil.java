package pl.gombal.orm_benchmarks.io.ormlite.config;


import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import pl.gombal.orm_benchmarks.io.ormlite.entity.BigSingleTable;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_01;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_02;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_03;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_04;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_05;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_06;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_07;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_08;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_09;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_10;
import pl.gombal.orm_benchmarks.io.ormlite.entity.SingleTable;
import pl.gombal.orm_benchmarks.io.ormlite.entity.TableWithRelationToMany;
import pl.gombal.orm_benchmarks.io.ormlite.entity.TableWithRelationToOne;

public class DataBaseConfigUtil extends OrmLiteConfigUtil {

    private static final Class<?>[] classes = new Class[]{
            SingleTable.class,
            BigSingleTable.class,
            MultiTable_01.class,
            MultiTable_02.class,
            MultiTable_03.class,
            MultiTable_04.class,
            MultiTable_05.class,
            MultiTable_06.class,
            MultiTable_07.class,
            MultiTable_08.class,
            MultiTable_09.class,
            MultiTable_10.class,
            TableWithRelationToMany.class,
            TableWithRelationToOne.class
    };

    public static void main(String[] args) throws IOException, SQLException {

        String configPath = "/app/src/main/res/raw/ormlite_config.txt";

        String fullConfigPath = System.getProperty("user.dir") + configPath;

        File configFile = new File(fullConfigPath);

        if (configFile.exists()) {
            configFile.delete();
        }

        configFile = new File(fullConfigPath);

        writeConfigFile(configFile, classes);
    }
}
