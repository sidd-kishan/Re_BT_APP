/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.SQLException
 *  net.sqlcipher.database.SQLiteDatabase
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.database.DatabaseStatement
 *  org.greenrobot.greendao.database.EncryptedDatabaseStatement
 */
package org.greenrobot.greendao.database;

import android.database.Cursor;
import android.database.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.database.EncryptedDatabaseStatement;

public class EncryptedDatabase
implements Database {
    private final SQLiteDatabase delegate;

    public EncryptedDatabase(SQLiteDatabase sQLiteDatabase) {
        this.delegate = sQLiteDatabase;
    }

    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    public void close() {
        this.delegate.close();
    }

    public DatabaseStatement compileStatement(String string) {
        return new EncryptedDatabaseStatement(this.delegate.compileStatement(string));
    }

    public void endTransaction() {
        this.delegate.endTransaction();
    }

    public void execSQL(String string) throws SQLException {
        this.delegate.execSQL(string);
    }

    public void execSQL(String string, Object[] objectArray) throws SQLException {
        this.delegate.execSQL(string, objectArray);
    }

    public Object getRawDatabase() {
        return this.delegate;
    }

    public SQLiteDatabase getSQLiteDatabase() {
        return this.delegate;
    }

    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public Cursor rawQuery(String string, String[] stringArray) {
        return this.delegate.rawQuery(string, stringArray);
    }

    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }
}
