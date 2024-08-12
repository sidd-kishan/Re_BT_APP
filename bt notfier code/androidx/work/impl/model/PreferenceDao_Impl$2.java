/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomSQLiteQuery
 *  androidx.room.util.DBUtil
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.work.impl.model.PreferenceDao_Impl
 */
package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.model.PreferenceDao_Impl;
import java.util.concurrent.Callable;

/*
 * Exception performing whole class analysis ignored.
 */
class PreferenceDao_Impl.2
implements Callable<Long> {
    final PreferenceDao_Impl this$0;
    final RoomSQLiteQuery val$_statement;

    PreferenceDao_Impl.2(PreferenceDao_Impl preferenceDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = preferenceDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    @Override
    public Long call() throws Exception {
        Object object = PreferenceDao_Impl.access$000((PreferenceDao_Impl)this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        Object var2_4 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        object = var2_4;
        try {
            if (!roomSQLiteQuery.moveToFirst()) return object;
            object = roomSQLiteQuery.isNull(0) ? var2_4 : Long.valueOf(roomSQLiteQuery.getLong(0));
            return object;
        }
        finally {
            roomSQLiteQuery.close();
        }
    }

    protected void finalize() {
        this.val$_statement.release();
    }
}
