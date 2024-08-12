/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.RoomDatabase
 *  androidx.room.SharedSQLiteStatement
 *  androidx.work.impl.model.WorkSpecDao_Impl
 */
package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.work.impl.model.WorkSpecDao_Impl;

class WorkSpecDao_Impl.3
extends SharedSQLiteStatement {
    final WorkSpecDao_Impl this$0;

    WorkSpecDao_Impl.3(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = workSpecDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "UPDATE workspec SET output=? WHERE id=?";
    }
}
