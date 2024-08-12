/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.migration.Migration
 *  androidx.sqlite.db.SupportSQLiteDatabase
 */
package androidx.work.impl;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

class WorkDatabaseMigrations.6
extends Migration {
    WorkDatabaseMigrations.6(int n, int n2) {
        super(n, n2);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
    }
}
