/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.DatabaseErrorHandler
 *  android.database.sqlite.SQLiteDatabase
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Callback
 *  androidx.sqlite.db.framework.FrameworkSQLiteDatabase
 *  androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper
 */
package androidx.sqlite.db.framework;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;

/*
 * Exception performing whole class analysis ignored.
 */
class FrameworkSQLiteOpenHelper.OpenHelper.1
implements DatabaseErrorHandler {
    final SupportSQLiteOpenHelper.Callback val$callback;
    final FrameworkSQLiteDatabase[] val$dbRef;

    FrameworkSQLiteOpenHelper.OpenHelper.1(SupportSQLiteOpenHelper.Callback callback, FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArray) {
        this.val$callback = callback;
        this.val$dbRef = frameworkSQLiteDatabaseArray;
    }

    public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        this.val$callback.onCorruption((SupportSQLiteDatabase)FrameworkSQLiteOpenHelper.OpenHelper.getWrappedDb((FrameworkSQLiteDatabase[])this.val$dbRef, (SQLiteDatabase)sQLiteDatabase));
    }
}
