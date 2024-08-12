/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.util.Log
 *  com.lianhezhuli.btnotification.greendao.bean.DaoMaster
 *  com.lianhezhuli.btnotification.greendao.bean.DaoMaster$OpenHelper
 *  org.greenrobot.greendao.database.Database
 */
package com.lianhezhuli.btnotification.greendao.bean;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.lianhezhuli.btnotification.greendao.bean.DaoMaster;
import org.greenrobot.greendao.database.Database;

/*
 * Exception performing whole class analysis ignored.
 */
public static class DaoMaster.DevOpenHelper
extends DaoMaster.OpenHelper {
    public DaoMaster.DevOpenHelper(Context context, String string) {
        super(context, string);
    }

    public DaoMaster.DevOpenHelper(Context context, String string, SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, string, cursorFactory);
    }

    public void onUpgrade(Database database, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Upgrading schema from version ");
        stringBuilder.append(n);
        stringBuilder.append(" to ");
        stringBuilder.append(n2);
        stringBuilder.append(" by dropping all tables");
        Log.i((String)"greenDAO", (String)stringBuilder.toString());
        DaoMaster.dropAllTables((Database)database, (boolean)true);
        this.onCreate(database);
    }
}
