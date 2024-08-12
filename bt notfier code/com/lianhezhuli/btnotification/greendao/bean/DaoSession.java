/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.greendao.bean.SleepDataBean
 *  com.lianhezhuli.btnotification.greendao.bean.SleepDataBeanDao
 *  com.lianhezhuli.btnotification.greendao.bean.StepDataBean
 *  com.lianhezhuli.btnotification.greendao.bean.StepDataBeanDao
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.AbstractDaoSession
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.identityscope.IdentityScopeType
 *  org.greenrobot.greendao.internal.DaoConfig
 */
package com.lianhezhuli.btnotification.greendao.bean;

import com.lianhezhuli.btnotification.greendao.bean.SleepDataBean;
import com.lianhezhuli.btnotification.greendao.bean.SleepDataBeanDao;
import com.lianhezhuli.btnotification.greendao.bean.StepDataBean;
import com.lianhezhuli.btnotification.greendao.bean.StepDataBeanDao;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class DaoSession
extends AbstractDaoSession {
    private final SleepDataBeanDao sleepDataBeanDao;
    private final DaoConfig sleepDataBeanDaoConfig;
    private final StepDataBeanDao stepDataBeanDao;
    private final DaoConfig stepDataBeanDaoConfig;

    public DaoSession(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        database = map.get(SleepDataBeanDao.class).clone();
        this.sleepDataBeanDaoConfig = database;
        database.initIdentityScope(identityScopeType);
        database = map.get(StepDataBeanDao.class).clone();
        this.stepDataBeanDaoConfig = database;
        database.initIdentityScope(identityScopeType);
        this.sleepDataBeanDao = new SleepDataBeanDao(this.sleepDataBeanDaoConfig, this);
        this.stepDataBeanDao = new StepDataBeanDao(this.stepDataBeanDaoConfig, this);
        this.registerDao(SleepDataBean.class, (AbstractDao)this.sleepDataBeanDao);
        this.registerDao(StepDataBean.class, (AbstractDao)this.stepDataBeanDao);
    }

    public void clear() {
        this.sleepDataBeanDaoConfig.clearIdentityScope();
        this.stepDataBeanDaoConfig.clearIdentityScope();
    }

    public SleepDataBeanDao getSleepDataBeanDao() {
        return this.sleepDataBeanDao;
    }

    public StepDataBeanDao getStepDataBeanDao() {
        return this.stepDataBeanDao;
    }
}
