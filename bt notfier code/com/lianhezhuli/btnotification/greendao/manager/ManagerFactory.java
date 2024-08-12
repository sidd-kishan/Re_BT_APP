/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.greendao.manager.DaoManager
 *  com.lianhezhuli.btnotification.greendao.manager.benmanager.SleepDataBeanManager
 *  com.lianhezhuli.btnotification.greendao.manager.benmanager.StepDataBeanManager
 *  org.greenrobot.greendao.AbstractDao
 */
package com.lianhezhuli.btnotification.greendao.manager;

import com.lianhezhuli.btnotification.greendao.manager.DaoManager;
import com.lianhezhuli.btnotification.greendao.manager.benmanager.SleepDataBeanManager;
import com.lianhezhuli.btnotification.greendao.manager.benmanager.StepDataBeanManager;
import org.greenrobot.greendao.AbstractDao;

public class ManagerFactory {
    private static ManagerFactory mInstance;
    private SleepDataBeanManager sleepManager;
    private StepDataBeanManager stepManager;

    public static ManagerFactory getInstance() {
        if (mInstance != null) return mInstance;
        synchronized (ManagerFactory.class) {
            ManagerFactory managerFactory;
            if (mInstance != null) return mInstance;
            mInstance = managerFactory = new ManagerFactory();
        }
        return mInstance;
    }

    public SleepDataBeanManager getSleepManager() {
        synchronized (this) {
            SleepDataBeanManager sleepDataBeanManager;
            if (this.sleepManager == null) {
                this.sleepManager = sleepDataBeanManager = new SleepDataBeanManager((AbstractDao)DaoManager.getInstance().getDaoSession().getSleepDataBeanDao());
            }
            sleepDataBeanManager = this.sleepManager;
            return sleepDataBeanManager;
        }
    }

    public StepDataBeanManager getStepManager() {
        synchronized (this) {
            StepDataBeanManager stepDataBeanManager;
            if (this.stepManager == null) {
                this.stepManager = stepDataBeanManager = new StepDataBeanManager((AbstractDao)DaoManager.getInstance().getDaoSession().getStepDataBeanDao());
            }
            stepDataBeanManager = this.stepManager;
            return stepDataBeanManager;
        }
    }
}
