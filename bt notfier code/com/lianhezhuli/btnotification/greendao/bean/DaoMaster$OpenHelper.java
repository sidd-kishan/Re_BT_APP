/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.util.Log
 *  com.lianhezhuli.btnotification.greendao.bean.DaoMaster
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.database.DatabaseOpenHelper
 */
package com.lianhezhuli.btnotification.greendao.bean;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.lianhezhuli.btnotification.greendao.bean.DaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

/*
 * Exception performing whole class analysis ignored.
 */
public static abstract class DaoMaster.OpenHelper
extends DatabaseOpenHelper {
    public DaoMaster.OpenHelper(Context context, String string) {
        super(context, string, 6);
    }

    public DaoMaster.OpenHelper(Context context, String string, SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, string, cursorFactory, 6);
    }

    public void onCreate(Database database) {
        Log.i((String)"greenDAO", (String)"Creating tables for schema version 6");
        DaoMaster.createAllTables((Database)database, (boolean)false);
    }
}
