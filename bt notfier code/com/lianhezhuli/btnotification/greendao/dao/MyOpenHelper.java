/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  com.lianhezhuli.btnotification.greendao.dao.DaoMaster$OpenHelper
 *  com.lianhezhuli.btnotification.greendao.dao.MigrationHelper
 *  com.lianhezhuli.btnotification.greendao.dao.SleepDataBeanDao
 *  com.lianhezhuli.btnotification.greendao.dao.StepDataBeanDao
 *  com.orhanobut.logger.Logger
 *  org.greenrobot.greendao.database.Database
 */
package com.lianhezhuli.btnotification.greendao.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.lianhezhuli.btnotification.greendao.dao.DaoMaster;
import com.lianhezhuli.btnotification.greendao.dao.MigrationHelper;
import com.lianhezhuli.btnotification.greendao.dao.SleepDataBeanDao;
import com.lianhezhuli.btnotification.greendao.dao.StepDataBeanDao;
import com.orhanobut.logger.Logger;
import org.greenrobot.greendao.database.Database;

public class MyOpenHelper
extends DaoMaster.OpenHelper {
    public MyOpenHelper(Context context, String string) {
        super(context, string);
    }

    public MyOpenHelper(Context context, String string, SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, string, cursorFactory);
    }

    public void onUpgrade(Database object, int n, int n2) {
        MigrationHelper.migrate((Database)object, (Class[])new Class[]{StepDataBeanDao.class, SleepDataBeanDao.class});
        object = new StringBuilder();
        ((StringBuilder)object).append("onUpgrade: ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" newVersion = ");
        ((StringBuilder)object).append(n2);
        Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
    }
}
