/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteCursor
 *  android.database.sqlite.SQLiteCursorDriver
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteProgram
 *  android.database.sqlite.SQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteProgram
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.sqlite.db.framework.FrameworkSQLiteDatabase
 *  androidx.sqlite.db.framework.FrameworkSQLiteProgram
 */
package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;

class FrameworkSQLiteDatabase.2
implements SQLiteDatabase.CursorFactory {
    final FrameworkSQLiteDatabase this$0;
    final SupportSQLiteQuery val$supportQuery;

    FrameworkSQLiteDatabase.2(FrameworkSQLiteDatabase frameworkSQLiteDatabase, SupportSQLiteQuery supportSQLiteQuery) {
        this.this$0 = frameworkSQLiteDatabase;
        this.val$supportQuery = supportSQLiteQuery;
    }

    public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String string, SQLiteQuery sQLiteQuery) {
        this.val$supportQuery.bindTo((SupportSQLiteProgram)new FrameworkSQLiteProgram((SQLiteProgram)sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, string, sQLiteQuery);
    }
}
