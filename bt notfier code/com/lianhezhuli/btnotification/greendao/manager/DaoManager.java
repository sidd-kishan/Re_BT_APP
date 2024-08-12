/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.greendao.dao.DaoMaster
 *  com.lianhezhuli.btnotification.greendao.dao.DaoSession
 *  com.lianhezhuli.btnotification.greendao.dao.MyOpenHelper
 *  org.greenrobot.greendao.query.QueryBuilder
 */
package com.lianhezhuli.btnotification.greendao.manager;

import android.content.Context;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.greendao.dao.DaoMaster;
import com.lianhezhuli.btnotification.greendao.dao.DaoSession;
import com.lianhezhuli.btnotification.greendao.dao.MyOpenHelper;
import org.greenrobot.greendao.query.QueryBuilder;

public class DaoManager {
    private static final String DB_NAME = "BTDATADB";
    private static DaoManager mInstance;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private MyOpenHelper devOpenHelper;

    private DaoManager() {
        MyOpenHelper myOpenHelper;
        if (mInstance != null) return;
        this.devOpenHelper = myOpenHelper = new MyOpenHelper((Context)MApplication.getInstance(), DB_NAME);
        myOpenHelper = new DaoMaster(myOpenHelper.getWritableDatabase());
        this.daoMaster = myOpenHelper;
        this.daoSession = myOpenHelper.newSession();
    }

    private void closeDaoSession() {
        DaoSession daoSession = this.daoSession;
        if (daoSession == null) return;
        daoSession.clear();
        this.daoSession = null;
    }

    private void closeHelper() {
        MyOpenHelper myOpenHelper = this.devOpenHelper;
        if (myOpenHelper == null) return;
        myOpenHelper.close();
        this.devOpenHelper = null;
    }

    public static DaoManager getInstance() {
        if (mInstance != null) return mInstance;
        synchronized (DaoManager.class) {
            DaoManager daoManager;
            if (mInstance != null) return mInstance;
            mInstance = daoManager = new DaoManager();
        }
        return mInstance;
    }

    public void closeConnection() {
        this.closeHelper();
        this.closeDaoSession();
    }

    public DaoMaster getDaoMaster() {
        return this.daoMaster;
    }

    public DaoSession getDaoSession() {
        return this.daoSession;
    }

    public void setDebug() {
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }
}
