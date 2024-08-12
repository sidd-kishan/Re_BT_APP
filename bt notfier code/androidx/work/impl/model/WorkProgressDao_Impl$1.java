/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.RoomDatabase
 *  androidx.sqlite.db.SupportSQLiteStatement
 *  androidx.work.Data
 *  androidx.work.impl.model.WorkProgress
 *  androidx.work.impl.model.WorkProgressDao_Impl
 */
package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao_Impl;

class WorkProgressDao_Impl.1
extends EntityInsertionAdapter<WorkProgress> {
    final WorkProgressDao_Impl this$0;

    WorkProgressDao_Impl.1(WorkProgressDao_Impl workProgressDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = workProgressDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkProgress object) {
        if (object.mWorkSpecId == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, object.mWorkSpecId);
        }
        object = Data.toByteArrayInternal((Data)object.mProgress);
        if (object == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindBlob(2, (byte[])object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
    }
}
