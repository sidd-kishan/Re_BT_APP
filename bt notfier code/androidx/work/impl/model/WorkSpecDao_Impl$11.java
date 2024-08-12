/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.collection.ArrayMap
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomSQLiteQuery
 *  androidx.room.util.CursorUtil
 *  androidx.room.util.DBUtil
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.work.Data
 *  androidx.work.impl.model.WorkSpec$WorkInfoPojo
 *  androidx.work.impl.model.WorkSpecDao_Impl
 *  androidx.work.impl.model.WorkTypeConverters
 */
package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/*
 * Exception performing whole class analysis ignored.
 */
class WorkSpecDao_Impl.11
implements Callable<List<WorkSpec.WorkInfoPojo>> {
    final WorkSpecDao_Impl this$0;
    final RoomSQLiteQuery val$_statement;

    WorkSpecDao_Impl.11(WorkSpecDao_Impl workSpecDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = workSpecDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public List<WorkSpec.WorkInfoPojo> call() throws Exception {
        ArrayList<WorkSpec.WorkInfoPojo> arrayList2;
        WorkSpecDao_Impl.access$000((WorkSpecDao_Impl)this.this$0).beginTransaction();
        Cursor cursor = DBUtil.query((RoomDatabase)WorkSpecDao_Impl.access$000((WorkSpecDao_Impl)this.this$0), (SupportSQLiteQuery)this.val$_statement, (boolean)true, null);
        try {
            ArrayList arrayList;
            Object object;
            int n = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"id");
            int n2 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"state");
            int n3 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"output");
            int n4 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (cursor.moveToNext()) {
                if (!cursor.isNull(n) && (ArrayList)arrayMap.get(object = cursor.getString(n)) == null) {
                    arrayList = new ArrayList();
                    arrayMap.put(object, arrayList);
                }
                if (cursor.isNull(n) || (ArrayList)arrayMap2.get((Object)(arrayList = cursor.getString(n))) != null) continue;
                object = new ArrayList();
                arrayMap2.put(arrayList, object);
            }
            cursor.moveToPosition(-1);
            WorkSpecDao_Impl.access$100((WorkSpecDao_Impl)this.this$0, (ArrayMap)arrayMap);
            WorkSpecDao_Impl.access$200((WorkSpecDao_Impl)this.this$0, (ArrayMap)arrayMap2);
            arrayList2 = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
            while (cursor.moveToNext()) {
                object = !cursor.isNull(n) ? (WorkSpec.WorkInfoPojo)arrayMap.get((Object)cursor.getString(n)) : null;
                arrayList = object;
                if (object == null) {
                    arrayList = new ArrayList();
                }
                object = !cursor.isNull(n) ? (ArrayList)arrayMap2.get((Object)cursor.getString(n)) : null;
                WorkSpec.WorkInfoPojo workInfoPojo = object;
                if (object == null) {
                    workInfoPojo = new ArrayList();
                }
                object = new WorkSpec.WorkInfoPojo();
                object.id = cursor.getString(n);
                object.state = WorkTypeConverters.intToState((int)cursor.getInt(n2));
                object.output = Data.fromByteArray((byte[])cursor.getBlob(n3));
                object.runAttemptCount = cursor.getInt(n4);
                object.tags = arrayList;
                object.progress = workInfoPojo;
                arrayList2.add((WorkSpec.WorkInfoPojo)object);
            }
            WorkSpecDao_Impl.access$000((WorkSpecDao_Impl)this.this$0).setTransactionSuccessful();
        }
        catch (Throwable throwable) {
            cursor.close();
            throw throwable;
        }
        try {
            cursor.close();
            return arrayList2;
        }
        finally {
            WorkSpecDao_Impl.access$000((WorkSpecDao_Impl)this.this$0).endTransaction();
        }
    }

    protected void finalize() {
        this.val$_statement.release();
    }
}
