/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.room.migration.Migration
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.work.impl.utils.IdGenerator
 *  androidx.work.impl.utils.PreferenceUtils
 */
package androidx.work.impl;

import android.content.Context;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.utils.IdGenerator;
import androidx.work.impl.utils.PreferenceUtils;

public static class WorkDatabaseMigrations.WorkMigration9To10
extends Migration {
    final Context mContext;

    public WorkDatabaseMigrations.WorkMigration9To10(Context context) {
        super(9, 10);
        this.mContext = context;
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        PreferenceUtils.migrateLegacyPreferences((Context)this.mContext, (SupportSQLiteDatabase)supportSQLiteDatabase);
        IdGenerator.migrateLegacyIdGenerator((Context)this.mContext, (SupportSQLiteDatabase)supportSQLiteDatabase);
    }
}
