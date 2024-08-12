/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteStatement
 *  org.greenrobot.greendao.database.DatabaseStatement
 */
package org.greenrobot.greendao.database;

import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.database.DatabaseStatement;

public class StandardDatabaseStatement
implements DatabaseStatement {
    private final SQLiteStatement delegate;

    public StandardDatabaseStatement(SQLiteStatement sQLiteStatement) {
        this.delegate = sQLiteStatement;
    }

    public void bindBlob(int n, byte[] byArray) {
        this.delegate.bindBlob(n, byArray);
    }

    public void bindDouble(int n, double d) {
        this.delegate.bindDouble(n, d);
    }

    public void bindLong(int n, long l) {
        this.delegate.bindLong(n, l);
    }

    public void bindNull(int n) {
        this.delegate.bindNull(n);
    }

    public void bindString(int n, String string) {
        this.delegate.bindString(n, string);
    }

    public void clearBindings() {
        this.delegate.clearBindings();
    }

    public void close() {
        this.delegate.close();
    }

    public void execute() {
        this.delegate.execute();
    }

    public long executeInsert() {
        return this.delegate.executeInsert();
    }

    public Object getRawStatement() {
        return this.delegate;
    }

    public long simpleQueryForLong() {
        return this.delegate.simpleQueryForLong();
    }
}
