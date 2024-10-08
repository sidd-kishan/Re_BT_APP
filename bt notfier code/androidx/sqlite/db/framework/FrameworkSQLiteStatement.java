/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteProgram
 *  android.database.sqlite.SQLiteStatement
 *  androidx.sqlite.db.SupportSQLiteStatement
 *  androidx.sqlite.db.framework.FrameworkSQLiteProgram
 */
package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;

class FrameworkSQLiteStatement
extends FrameworkSQLiteProgram
implements SupportSQLiteStatement {
    private final SQLiteStatement mDelegate;

    FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super((SQLiteProgram)sQLiteStatement);
        this.mDelegate = sQLiteStatement;
    }

    public void execute() {
        this.mDelegate.execute();
    }

    public long executeInsert() {
        return this.mDelegate.executeInsert();
    }

    public int executeUpdateDelete() {
        return this.mDelegate.executeUpdateDelete();
    }

    public long simpleQueryForLong() {
        return this.mDelegate.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        return this.mDelegate.simpleQueryForString();
    }
}
