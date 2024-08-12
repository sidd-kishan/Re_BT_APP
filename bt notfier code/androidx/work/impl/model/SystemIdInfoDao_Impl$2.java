/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.RoomDatabase
 *  androidx.room.SharedSQLiteStatement
 *  androidx.work.impl.model.SystemIdInfoDao_Impl
 */
package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.work.impl.model.SystemIdInfoDao_Impl;

class SystemIdInfoDao_Impl.2
extends SharedSQLiteStatement {
    final SystemIdInfoDao_Impl this$0;

    SystemIdInfoDao_Impl.2(SystemIdInfoDao_Impl systemIdInfoDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = systemIdInfoDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM SystemIdInfo where work_spec_id=?";
    }
}
