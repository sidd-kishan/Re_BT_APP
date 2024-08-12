/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.RoomDatabase
 *  androidx.sqlite.db.SupportSQLiteStatement
 *  androidx.work.impl.model.SystemIdInfo
 *  androidx.work.impl.model.SystemIdInfoDao_Impl
 */
package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao_Impl;

class SystemIdInfoDao_Impl.1
extends EntityInsertionAdapter<SystemIdInfo> {
    final SystemIdInfoDao_Impl this$0;

    SystemIdInfoDao_Impl.1(SystemIdInfoDao_Impl systemIdInfoDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = systemIdInfoDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, SystemIdInfo systemIdInfo) {
        if (systemIdInfo.workSpecId == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, systemIdInfo.workSpecId);
        }
        supportSQLiteStatement.bindLong(2, (long)systemIdInfo.systemId);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
    }
}
