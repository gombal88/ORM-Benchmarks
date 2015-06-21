package pl.gombal.orm_benchmarks.io.greendao.entity;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig singleTableDaoConfig;
    private final DaoConfig multiTable_10DaoConfig;
    private final DaoConfig multiTable_09DaoConfig;
    private final DaoConfig multiTable_08DaoConfig;
    private final DaoConfig multiTable_07DaoConfig;
    private final DaoConfig multiTable_06DaoConfig;
    private final DaoConfig multiTable_05DaoConfig;
    private final DaoConfig multiTable_04DaoConfig;
    private final DaoConfig multiTable_03DaoConfig;
    private final DaoConfig multiTable_02DaoConfig;
    private final DaoConfig multiTable_01DaoConfig;
    private final DaoConfig bigSingleTableDaoConfig;
    private final DaoConfig tableWithRelationToManyDaoConfig;
    private final DaoConfig tableWithRelationToOneDaoConfig;

    private final SingleTableDao singleTableDao;
    private final MultiTable_10Dao multiTable_10Dao;
    private final MultiTable_09Dao multiTable_09Dao;
    private final MultiTable_08Dao multiTable_08Dao;
    private final MultiTable_07Dao multiTable_07Dao;
    private final MultiTable_06Dao multiTable_06Dao;
    private final MultiTable_05Dao multiTable_05Dao;
    private final MultiTable_04Dao multiTable_04Dao;
    private final MultiTable_03Dao multiTable_03Dao;
    private final MultiTable_02Dao multiTable_02Dao;
    private final MultiTable_01Dao multiTable_01Dao;
    private final BigSingleTableDao bigSingleTableDao;
    private final TableWithRelationToManyDao tableWithRelationToManyDao;
    private final TableWithRelationToOneDao tableWithRelationToOneDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        singleTableDaoConfig = daoConfigMap.get(SingleTableDao.class).clone();
        singleTableDaoConfig.initIdentityScope(type);

        multiTable_10DaoConfig = daoConfigMap.get(MultiTable_10Dao.class).clone();
        multiTable_10DaoConfig.initIdentityScope(type);

        multiTable_09DaoConfig = daoConfigMap.get(MultiTable_09Dao.class).clone();
        multiTable_09DaoConfig.initIdentityScope(type);

        multiTable_08DaoConfig = daoConfigMap.get(MultiTable_08Dao.class).clone();
        multiTable_08DaoConfig.initIdentityScope(type);

        multiTable_07DaoConfig = daoConfigMap.get(MultiTable_07Dao.class).clone();
        multiTable_07DaoConfig.initIdentityScope(type);

        multiTable_06DaoConfig = daoConfigMap.get(MultiTable_06Dao.class).clone();
        multiTable_06DaoConfig.initIdentityScope(type);

        multiTable_05DaoConfig = daoConfigMap.get(MultiTable_05Dao.class).clone();
        multiTable_05DaoConfig.initIdentityScope(type);

        multiTable_04DaoConfig = daoConfigMap.get(MultiTable_04Dao.class).clone();
        multiTable_04DaoConfig.initIdentityScope(type);

        multiTable_03DaoConfig = daoConfigMap.get(MultiTable_03Dao.class).clone();
        multiTable_03DaoConfig.initIdentityScope(type);

        multiTable_02DaoConfig = daoConfigMap.get(MultiTable_02Dao.class).clone();
        multiTable_02DaoConfig.initIdentityScope(type);

        multiTable_01DaoConfig = daoConfigMap.get(MultiTable_01Dao.class).clone();
        multiTable_01DaoConfig.initIdentityScope(type);

        bigSingleTableDaoConfig = daoConfigMap.get(BigSingleTableDao.class).clone();
        bigSingleTableDaoConfig.initIdentityScope(type);

        tableWithRelationToManyDaoConfig = daoConfigMap.get(TableWithRelationToManyDao.class).clone();
        tableWithRelationToManyDaoConfig.initIdentityScope(type);

        tableWithRelationToOneDaoConfig = daoConfigMap.get(TableWithRelationToOneDao.class).clone();
        tableWithRelationToOneDaoConfig.initIdentityScope(type);

        singleTableDao = new SingleTableDao(singleTableDaoConfig, this);
        multiTable_10Dao = new MultiTable_10Dao(multiTable_10DaoConfig, this);
        multiTable_09Dao = new MultiTable_09Dao(multiTable_09DaoConfig, this);
        multiTable_08Dao = new MultiTable_08Dao(multiTable_08DaoConfig, this);
        multiTable_07Dao = new MultiTable_07Dao(multiTable_07DaoConfig, this);
        multiTable_06Dao = new MultiTable_06Dao(multiTable_06DaoConfig, this);
        multiTable_05Dao = new MultiTable_05Dao(multiTable_05DaoConfig, this);
        multiTable_04Dao = new MultiTable_04Dao(multiTable_04DaoConfig, this);
        multiTable_03Dao = new MultiTable_03Dao(multiTable_03DaoConfig, this);
        multiTable_02Dao = new MultiTable_02Dao(multiTable_02DaoConfig, this);
        multiTable_01Dao = new MultiTable_01Dao(multiTable_01DaoConfig, this);
        bigSingleTableDao = new BigSingleTableDao(bigSingleTableDaoConfig, this);
        tableWithRelationToManyDao = new TableWithRelationToManyDao(tableWithRelationToManyDaoConfig, this);
        tableWithRelationToOneDao = new TableWithRelationToOneDao(tableWithRelationToOneDaoConfig, this);

        registerDao(SingleTable.class, singleTableDao);
        registerDao(MultiTable_10.class, multiTable_10Dao);
        registerDao(MultiTable_09.class, multiTable_09Dao);
        registerDao(MultiTable_08.class, multiTable_08Dao);
        registerDao(MultiTable_07.class, multiTable_07Dao);
        registerDao(MultiTable_06.class, multiTable_06Dao);
        registerDao(MultiTable_05.class, multiTable_05Dao);
        registerDao(MultiTable_04.class, multiTable_04Dao);
        registerDao(MultiTable_03.class, multiTable_03Dao);
        registerDao(MultiTable_02.class, multiTable_02Dao);
        registerDao(MultiTable_01.class, multiTable_01Dao);
        registerDao(BigSingleTable.class, bigSingleTableDao);
        registerDao(TableWithRelationToMany.class, tableWithRelationToManyDao);
        registerDao(TableWithRelationToOne.class, tableWithRelationToOneDao);
    }
    
    public void clear() {
        singleTableDaoConfig.getIdentityScope().clear();
        multiTable_10DaoConfig.getIdentityScope().clear();
        multiTable_09DaoConfig.getIdentityScope().clear();
        multiTable_08DaoConfig.getIdentityScope().clear();
        multiTable_07DaoConfig.getIdentityScope().clear();
        multiTable_06DaoConfig.getIdentityScope().clear();
        multiTable_05DaoConfig.getIdentityScope().clear();
        multiTable_04DaoConfig.getIdentityScope().clear();
        multiTable_03DaoConfig.getIdentityScope().clear();
        multiTable_02DaoConfig.getIdentityScope().clear();
        multiTable_01DaoConfig.getIdentityScope().clear();
        bigSingleTableDaoConfig.getIdentityScope().clear();
        tableWithRelationToManyDaoConfig.getIdentityScope().clear();
        tableWithRelationToOneDaoConfig.getIdentityScope().clear();
    }

    public SingleTableDao getSingleTableDao() {
        return singleTableDao;
    }

    public MultiTable_10Dao getMultiTable_10Dao() {
        return multiTable_10Dao;
    }

    public MultiTable_09Dao getMultiTable_09Dao() {
        return multiTable_09Dao;
    }

    public MultiTable_08Dao getMultiTable_08Dao() {
        return multiTable_08Dao;
    }

    public MultiTable_07Dao getMultiTable_07Dao() {
        return multiTable_07Dao;
    }

    public MultiTable_06Dao getMultiTable_06Dao() {
        return multiTable_06Dao;
    }

    public MultiTable_05Dao getMultiTable_05Dao() {
        return multiTable_05Dao;
    }

    public MultiTable_04Dao getMultiTable_04Dao() {
        return multiTable_04Dao;
    }

    public MultiTable_03Dao getMultiTable_03Dao() {
        return multiTable_03Dao;
    }

    public MultiTable_02Dao getMultiTable_02Dao() {
        return multiTable_02Dao;
    }

    public MultiTable_01Dao getMultiTable_01Dao() {
        return multiTable_01Dao;
    }

    public BigSingleTableDao getBigSingleTableDao() {
        return bigSingleTableDao;
    }

    public TableWithRelationToManyDao getTableWithRelationToManyDao() {
        return tableWithRelationToManyDao;
    }

    public TableWithRelationToOneDao getTableWithRelationToOneDao() {
        return tableWithRelationToOneDao;
    }

}
