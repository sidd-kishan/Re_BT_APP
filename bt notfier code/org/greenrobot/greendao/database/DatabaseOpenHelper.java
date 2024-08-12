/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.database.DatabaseOpenHelper$EncryptedHelper
 *  org.greenrobot.greendao.database.StandardDatabase
 */
package org.greenrobot.greendao.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;

public abstract class DatabaseOpenHelper
extends SQLiteOpenHelper {
    private final Context context;
    private EncryptedHelper encryptedHelper;
    private boolean loadSQLCipherNativeLibs = true;
    private final String name;
    private final int version;

    public DatabaseOpenHelper(Context context, String string, int n) {
        this(context, string, null, n);
    }

    public DatabaseOpenHelper(Context context, String string, SQLiteDatabase.CursorFactory cursorFactory, int n) {
        super(context, string, cursorFactory, n);
        this.context = context;
        this.name = string;
        this.version = n;
    }

    private EncryptedHelper checkEncryptedHelper() {
        if (this.encryptedHelper != null) return this.encryptedHelper;
        this.encryptedHelper = new EncryptedHelper(this, this.context, this.name, this.version, this.loadSQLCipherNativeLibs);
        return this.encryptedHelper;
    }

    public Database getEncryptedReadableDb(String string) {
        EncryptedHelper encryptedHelper = this.checkEncryptedHelper();
        return encryptedHelper.wrap(encryptedHelper.getReadableDatabase(string));
    }

    public Database getEncryptedReadableDb(char[] cArray) {
        EncryptedHelper encryptedHelper = this.checkEncryptedHelper();
        return encryptedHelper.wrap(encryptedHelper.getReadableDatabase(cArray));
    }

    public Database getEncryptedWritableDb(String string) {
        EncryptedHelper encryptedHelper = this.checkEncryptedHelper();
        return encryptedHelper.wrap(encryptedHelper.getWritableDatabase(string));
    }

    public Database getEncryptedWritableDb(char[] cArray) {
        EncryptedHelper encryptedHelper = this.checkEncryptedHelper();
        return encryptedHelper.wrap(encryptedHelper.getWritableDatabase(cArray));
    }

    public Database getReadableDb() {
        return this.wrap(this.getReadableDatabase());
    }

    public Database getWritableDb() {
        return this.wrap(this.getWritableDatabase());
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.onCreate(this.wrap(sQLiteDatabase));
    }

    public void onCreate(Database database) {
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        this.onOpen(this.wrap(sQLiteDatabase));
    }

    public void onOpen(Database database) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        this.onUpgrade(this.wrap(sQLiteDatabase), n, n2);
    }

    public void onUpgrade(Database database, int n, int n2) {
    }

    public void setLoadSQLCipherNativeLibs(boolean bl) {
        this.loadSQLCipherNativeLibs = bl;
    }

    protected Database wrap(SQLiteDatabase sQLiteDatabase) {
        return new StandardDatabase(sQLiteDatabase);
    }
}
