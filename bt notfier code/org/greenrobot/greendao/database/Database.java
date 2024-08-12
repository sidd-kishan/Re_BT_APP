/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.SQLException
 *  org.greenrobot.greendao.database.DatabaseStatement
 */
package org.greenrobot.greendao.database;

import android.database.Cursor;
import android.database.SQLException;
import org.greenrobot.greendao.database.DatabaseStatement;

public interface Database {
    public void beginTransaction();

    public void close();

    public DatabaseStatement compileStatement(String var1);

    public void endTransaction();

    public void execSQL(String var1) throws SQLException;

    public void execSQL(String var1, Object[] var2) throws SQLException;

    public Object getRawDatabase();

    public boolean inTransaction();

    public boolean isDbLockedByCurrentThread();

    public Cursor rawQuery(String var1, String[] var2);

    public void setTransactionSuccessful();
}
