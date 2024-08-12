/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomSQLiteQuery
 *  androidx.room.util.DBUtil
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.work.impl.model.WorkSpecDao_Impl
 */
package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/*
 * Exception performing whole class analysis ignored.
 */
class WorkSpecDao_Impl.10
implements Callable<List<String>> {
    final WorkSpecDao_Impl this$0;
    final RoomSQLiteQuery val$_statement;

    WorkSpecDao_Impl.10(WorkSpecDao_Impl workSpecDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = workSpecDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public List<String> call() throws Exception {
        ArrayList<String> arrayList;
        WorkSpecDao_Impl.access$000((WorkSpecDao_Impl)this.this$0).beginTransaction();
        Cursor cursor = DBUtil.query((RoomDatabase)WorkSpecDao_Impl.access$000((WorkSpecDao_Impl)this.this$0), (SupportSQLiteQuery)this.val$_statement, (boolean)false, null);
        try {
            arrayList = new ArrayList<String>(cursor.getCount());
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(0));
            }
            WorkSpecDao_Impl.access$000((WorkSpecDao_Impl)this.this$0).setTransactionSuccessful();
        }
        catch (Throwable throwable) {
            cursor.close();
            throw throwable;
        }
        try {
            cursor.close();
            return arrayList;
        }
        finally {
            WorkSpecDao_Impl.access$000((WorkSpecDao_Impl)this.this$0).endTransaction();
        }
    }

    protected void finalize() {
        this.val$_statement.release();
    }
}
