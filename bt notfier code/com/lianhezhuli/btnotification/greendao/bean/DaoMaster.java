/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  com.lianhezhuli.btnotification.greendao.bean.DaoMaster$DevOpenHelper
 *  com.lianhezhuli.btnotification.greendao.bean.DaoSession
 *  com.lianhezhuli.btnotification.greendao.bean.SleepDataBeanDao
 *  com.lianhezhuli.btnotification.greendao.bean.StepDataBeanDao
 *  org.greenrobot.greendao.AbstractDaoMaster
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.database.StandardDatabase
 *  org.greenrobot.greendao.identityscope.IdentityScopeType
 */
package com.lianhezhuli.btnotification.greendao.bean;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.lianhezhuli.btnotification.greendao.bean.DaoMaster;
import com.lianhezhuli.btnotification.greendao.bean.DaoSession;
import com.lianhezhuli.btnotification.greendao.bean.SleepDataBeanDao;
import com.lianhezhuli.btnotification.greendao.bean.StepDataBeanDao;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

public class DaoMaster
extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 6;

    public DaoMaster(SQLiteDatabase sQLiteDatabase) {
        this((Database)new StandardDatabase(sQLiteDatabase));
    }

    public DaoMaster(Database database) {
        super(database, 6);
        this.registerDaoClass(SleepDataBeanDao.class);
        this.registerDaoClass(StepDataBeanDao.class);
    }

    public static void createAllTables(Database database, boolean bl) {
        SleepDataBeanDao.createTable((Database)database, (boolean)bl);
        StepDataBeanDao.createTable((Database)database, (boolean)bl);
    }

    public static void dropAllTables(Database database, boolean bl) {
        SleepDataBeanDao.dropTable((Database)database, (boolean)bl);
        StepDataBeanDao.dropTable((Database)database, (boolean)bl);
    }

    public static DaoSession newDevSession(Context context, String string) {
        return new DaoMaster(new DevOpenHelper(context, string).getWritableDb()).newSession();
    }

    public DaoSession newSession() {
        return new DaoSession(this.db, IdentityScopeType.Session, this.daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType identityScopeType) {
        return new DaoSession(this.db, identityScopeType, this.daoConfigMap);
    }
}
