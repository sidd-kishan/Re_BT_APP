/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.DatabaseErrorHandler
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Callback
 *  androidx.sqlite.db.framework.FrameworkSQLiteDatabase
 */
package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

static class FrameworkSQLiteOpenHelper.OpenHelper
extends SQLiteOpenHelper {
    final SupportSQLiteOpenHelper.Callback mCallback;
    final FrameworkSQLiteDatabase[] mDbRef;
    private boolean mMigrated;

    FrameworkSQLiteOpenHelper.OpenHelper(Context context, String string, FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArray, SupportSQLiteOpenHelper.Callback callback) {
        super(context, string, null, callback.version, (DatabaseErrorHandler)new /* Unavailable Anonymous Inner Class!! */);
        this.mCallback = callback;
        this.mDbRef = frameworkSQLiteDatabaseArray;
    }

    static FrameworkSQLiteDatabase getWrappedDb(FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArray, SQLiteDatabase sQLiteDatabase) {
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArray[0];
        if (frameworkSQLiteDatabase != null) {
            if (frameworkSQLiteDatabase.isDelegate(sQLiteDatabase)) return frameworkSQLiteDatabaseArray[0];
        }
        frameworkSQLiteDatabaseArray[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
        return frameworkSQLiteDatabaseArray[0];
    }

    public void close() {
        synchronized (this) {
            super.close();
            this.mDbRef[0] = null;
            return;
        }
    }

    SupportSQLiteDatabase getReadableSupportDatabase() {
        synchronized (this) {
            this.mMigrated = false;
            SQLiteDatabase sQLiteDatabase = super.getReadableDatabase();
            if (this.mMigrated) {
                this.close();
                sQLiteDatabase = this.getReadableSupportDatabase();
                return sQLiteDatabase;
            }
            sQLiteDatabase = this.getWrappedDb(sQLiteDatabase);
            return sQLiteDatabase;
        }
    }

    FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
        return FrameworkSQLiteOpenHelper.OpenHelper.getWrappedDb(this.mDbRef, sQLiteDatabase);
    }

    SupportSQLiteDatabase getWritableSupportDatabase() {
        synchronized (this) {
            this.mMigrated = false;
            SQLiteDatabase sQLiteDatabase = super.getWritableDatabase();
            if (this.mMigrated) {
                this.close();
                sQLiteDatabase = this.getWritableSupportDatabase();
                return sQLiteDatabase;
            }
            sQLiteDatabase = this.getWrappedDb(sQLiteDatabase);
            return sQLiteDatabase;
        }
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.mCallback.onConfigure((SupportSQLiteDatabase)this.getWrappedDb(sQLiteDatabase));
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.mCallback.onCreate((SupportSQLiteDatabase)this.getWrappedDb(sQLiteDatabase));
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        this.mMigrated = true;
        this.mCallback.onDowngrade((SupportSQLiteDatabase)this.getWrappedDb(sQLiteDatabase), n, n2);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (this.mMigrated) return;
        this.mCallback.onOpen((SupportSQLiteDatabase)this.getWrappedDb(sQLiteDatabase));
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        this.mMigrated = true;
        this.mCallback.onUpgrade((SupportSQLiteDatabase)this.getWrappedDb(sQLiteDatabase), n, n2);
    }
}
