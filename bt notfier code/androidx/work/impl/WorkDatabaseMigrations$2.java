/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  androidx.room.migration.Migration
 *  androidx.sqlite.db.SupportSQLiteDatabase
 */
package androidx.work.impl;

import android.os.Build;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

class WorkDatabaseMigrations.2
extends Migration {
    WorkDatabaseMigrations.2(int n, int n2) {
        super(n, n2);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (Build.VERSION.SDK_INT < 23) return;
        supportSQLiteDatabase.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
    }
}
