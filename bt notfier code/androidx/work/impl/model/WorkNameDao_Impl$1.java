/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.RoomDatabase
 *  androidx.sqlite.db.SupportSQLiteStatement
 *  androidx.work.impl.model.WorkName
 *  androidx.work.impl.model.WorkNameDao_Impl
 */
package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkNameDao_Impl;

class WorkNameDao_Impl.1
extends EntityInsertionAdapter<WorkName> {
    final WorkNameDao_Impl this$0;

    WorkNameDao_Impl.1(WorkNameDao_Impl workNameDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = workNameDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkName workName) {
        if (workName.name == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, workName.name);
        }
        if (workName.workSpecId == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, workName.workSpecId);
        }
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
    }
}
