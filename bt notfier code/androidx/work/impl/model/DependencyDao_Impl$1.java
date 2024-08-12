/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.RoomDatabase
 *  androidx.sqlite.db.SupportSQLiteStatement
 *  androidx.work.impl.model.Dependency
 *  androidx.work.impl.model.DependencyDao_Impl
 */
package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao_Impl;

class DependencyDao_Impl.1
extends EntityInsertionAdapter<Dependency> {
    final DependencyDao_Impl this$0;

    DependencyDao_Impl.1(DependencyDao_Impl dependencyDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = dependencyDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Dependency dependency) {
        if (dependency.workSpecId == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, dependency.workSpecId);
        }
        if (dependency.prerequisiteId == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, dependency.prerequisiteId);
        }
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
    }
}
