/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.RoomDatabase$Callback
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.work.impl.WorkDatabase
 */
package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;

/*
 * Exception performing whole class analysis ignored.
 */
class WorkDatabase.2
extends RoomDatabase.Callback {
    WorkDatabase.2() {
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onOpen(supportSQLiteDatabase);
        supportSQLiteDatabase.beginTransaction();
        try {
            supportSQLiteDatabase.execSQL(WorkDatabase.getPruneSQL());
            supportSQLiteDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            supportSQLiteDatabase.endTransaction();
        }
    }
}
