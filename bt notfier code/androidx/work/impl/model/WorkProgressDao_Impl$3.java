/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.RoomDatabase
 *  androidx.room.SharedSQLiteStatement
 *  androidx.work.impl.model.WorkProgressDao_Impl
 */
package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.work.impl.model.WorkProgressDao_Impl;

class WorkProgressDao_Impl.3
extends SharedSQLiteStatement {
    final WorkProgressDao_Impl this$0;

    WorkProgressDao_Impl.3(WorkProgressDao_Impl workProgressDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = workProgressDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM WorkProgress";
    }
}
