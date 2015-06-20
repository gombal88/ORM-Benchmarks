package pl.gombal.orm_benchmarks.io.greendao;

import pl.gombal.orm_benchmarks.io.greendao.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table MULTI_TABLE01.
 */
public class MultiTable01 {

    private Long id;
    private short SampleStringColl01;
    private Short SampleStringColl02;
    private Short SampleStringColl03;
    private Short SampleStringColl04;
    private Short SampleStringColl05;
    private Short SampleStringColl06;
    private Short SampleStringColl07;
    private Short SampleStringColl08;
    private Short SampleStringColl09;
    private Short SampleStringColl10;
    private int SampleIntColl01;
    private Integer SampleIntColl02;
    private Double SampleRealColl01;
    private Double SampleRealColl02;
    private Integer SampleIntCollIndexed;
    private Long MultiTable01Id;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient MultiTable01Dao myDao;

    private MultiTable02 multiTable02;
    private Long multiTable02__resolvedKey;


    public MultiTable01() {
    }

    public MultiTable01(Long id) {
        this.id = id;
    }

    public MultiTable01(Long id, short SampleStringColl01, Short SampleStringColl02, Short SampleStringColl03, Short SampleStringColl04, Short SampleStringColl05, Short SampleStringColl06, Short SampleStringColl07, Short SampleStringColl08, Short SampleStringColl09, Short SampleStringColl10, int SampleIntColl01, Integer SampleIntColl02, Double SampleRealColl01, Double SampleRealColl02, Integer SampleIntCollIndexed, Long MultiTable01Id) {
        this.id = id;
        this.SampleStringColl01 = SampleStringColl01;
        this.SampleStringColl02 = SampleStringColl02;
        this.SampleStringColl03 = SampleStringColl03;
        this.SampleStringColl04 = SampleStringColl04;
        this.SampleStringColl05 = SampleStringColl05;
        this.SampleStringColl06 = SampleStringColl06;
        this.SampleStringColl07 = SampleStringColl07;
        this.SampleStringColl08 = SampleStringColl08;
        this.SampleStringColl09 = SampleStringColl09;
        this.SampleStringColl10 = SampleStringColl10;
        this.SampleIntColl01 = SampleIntColl01;
        this.SampleIntColl02 = SampleIntColl02;
        this.SampleRealColl01 = SampleRealColl01;
        this.SampleRealColl02 = SampleRealColl02;
        this.SampleIntCollIndexed = SampleIntCollIndexed;
        this.MultiTable01Id = MultiTable01Id;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMultiTable01Dao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getSampleStringColl01() {
        return SampleStringColl01;
    }

    public void setSampleStringColl01(short SampleStringColl01) {
        this.SampleStringColl01 = SampleStringColl01;
    }

    public Short getSampleStringColl02() {
        return SampleStringColl02;
    }

    public void setSampleStringColl02(Short SampleStringColl02) {
        this.SampleStringColl02 = SampleStringColl02;
    }

    public Short getSampleStringColl03() {
        return SampleStringColl03;
    }

    public void setSampleStringColl03(Short SampleStringColl03) {
        this.SampleStringColl03 = SampleStringColl03;
    }

    public Short getSampleStringColl04() {
        return SampleStringColl04;
    }

    public void setSampleStringColl04(Short SampleStringColl04) {
        this.SampleStringColl04 = SampleStringColl04;
    }

    public Short getSampleStringColl05() {
        return SampleStringColl05;
    }

    public void setSampleStringColl05(Short SampleStringColl05) {
        this.SampleStringColl05 = SampleStringColl05;
    }

    public Short getSampleStringColl06() {
        return SampleStringColl06;
    }

    public void setSampleStringColl06(Short SampleStringColl06) {
        this.SampleStringColl06 = SampleStringColl06;
    }

    public Short getSampleStringColl07() {
        return SampleStringColl07;
    }

    public void setSampleStringColl07(Short SampleStringColl07) {
        this.SampleStringColl07 = SampleStringColl07;
    }

    public Short getSampleStringColl08() {
        return SampleStringColl08;
    }

    public void setSampleStringColl08(Short SampleStringColl08) {
        this.SampleStringColl08 = SampleStringColl08;
    }

    public Short getSampleStringColl09() {
        return SampleStringColl09;
    }

    public void setSampleStringColl09(Short SampleStringColl09) {
        this.SampleStringColl09 = SampleStringColl09;
    }

    public Short getSampleStringColl10() {
        return SampleStringColl10;
    }

    public void setSampleStringColl10(Short SampleStringColl10) {
        this.SampleStringColl10 = SampleStringColl10;
    }

    public int getSampleIntColl01() {
        return SampleIntColl01;
    }

    public void setSampleIntColl01(int SampleIntColl01) {
        this.SampleIntColl01 = SampleIntColl01;
    }

    public Integer getSampleIntColl02() {
        return SampleIntColl02;
    }

    public void setSampleIntColl02(Integer SampleIntColl02) {
        this.SampleIntColl02 = SampleIntColl02;
    }

    public Double getSampleRealColl01() {
        return SampleRealColl01;
    }

    public void setSampleRealColl01(Double SampleRealColl01) {
        this.SampleRealColl01 = SampleRealColl01;
    }

    public Double getSampleRealColl02() {
        return SampleRealColl02;
    }

    public void setSampleRealColl02(Double SampleRealColl02) {
        this.SampleRealColl02 = SampleRealColl02;
    }

    public Integer getSampleIntCollIndexed() {
        return SampleIntCollIndexed;
    }

    public void setSampleIntCollIndexed(Integer SampleIntCollIndexed) {
        this.SampleIntCollIndexed = SampleIntCollIndexed;
    }

    public Long getMultiTable01Id() {
        return MultiTable01Id;
    }

    public void setMultiTable01Id(Long MultiTable01Id) {
        this.MultiTable01Id = MultiTable01Id;
    }

    /** To-one relationship, resolved on first access. */
    public MultiTable02 getMultiTable02() {
        Long __key = this.MultiTable01Id;
        if (multiTable02__resolvedKey == null || !multiTable02__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MultiTable02Dao targetDao = daoSession.getMultiTable02Dao();
            MultiTable02 multiTable02New = targetDao.load(__key);
            synchronized (this) {
                multiTable02 = multiTable02New;
            	multiTable02__resolvedKey = __key;
            }
        }
        return multiTable02;
    }

    public void setMultiTable02(MultiTable02 multiTable02) {
        synchronized (this) {
            this.multiTable02 = multiTable02;
            MultiTable01Id = multiTable02 == null ? null : multiTable02.getId();
            multiTable02__resolvedKey = MultiTable01Id;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
