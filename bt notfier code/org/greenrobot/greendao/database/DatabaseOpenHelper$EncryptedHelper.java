/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  net.sqlcipher.database.SQLiteDatabase
 *  net.sqlcipher.database.SQLiteOpenHelper
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.database.DatabaseOpenHelper
 *  org.greenrobot.greendao.database.EncryptedDatabase
 */
package org.greenrobot.greendao.database;

import android.content.Context;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.EncryptedDatabase;

private class DatabaseOpenHelper.EncryptedHelper
extends SQLiteOpenHelper {
    final DatabaseOpenHelper this$0;

    public DatabaseOpenHelper.EncryptedHelper(DatabaseOpenHelper databaseOpenHelper, Context context, String string, int n, boolean bl) {
        this.this$0 = databaseOpenHelper;
        super(context, string, null, n);
        if (!bl) return;
        SQLiteDatabase.loadLibs((Context)context);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.this$0.onCreate(this.wrap(sQLiteDatabase));
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        this.this$0.onOpen(this.wrap(sQLiteDatabase));
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        this.this$0.onUpgrade(this.wrap(sQLiteDatabase), n, n2);
    }

    protected Database wrap(SQLiteDatabase sQLiteDatabase) {
        return new EncryptedDatabase(sQLiteDatabase);
    }
}
