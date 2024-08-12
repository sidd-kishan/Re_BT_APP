/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.RoomDatabase
 *  androidx.sqlite.db.SupportSQLiteStatement
 *  androidx.work.impl.model.WorkTag
 *  androidx.work.impl.model.WorkTagDao_Impl
 */
package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao_Impl;

class WorkTagDao_Impl.1
extends EntityInsertionAdapter<WorkTag> {
    final WorkTagDao_Impl this$0;

    WorkTagDao_Impl.1(WorkTagDao_Impl workTagDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = workTagDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkTag workTag) {
        if (workTag.tag == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, workTag.tag);
        }
        if (workTag.workSpecId == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, workTag.workSpecId);
        }
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
    }
}
