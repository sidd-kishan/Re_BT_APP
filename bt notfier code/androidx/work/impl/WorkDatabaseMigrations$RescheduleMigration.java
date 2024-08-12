/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.room.migration.Migration
 *  androidx.sqlite.db.SupportSQLiteDatabase
 */
package androidx.work.impl;

import android.content.Context;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public static class WorkDatabaseMigrations.RescheduleMigration
extends Migration {
    final Context mContext;

    public WorkDatabaseMigrations.RescheduleMigration(Context context, int n, int n2) {
        super(n, n2);
        this.mContext = context;
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (this.endVersion >= 10) {
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
        } else {
            this.mContext.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }
}
