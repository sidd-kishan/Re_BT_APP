/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.collection.ArrayMap
 *  androidx.room.RoomDatabase
 *  androidx.room.util.CursorUtil
 *  androidx.room.util.DBUtil
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.work.Data
 *  androidx.work.impl.model.RawWorkInfoDao_Impl
 *  androidx.work.impl.model.WorkSpec$WorkInfoPojo
 *  androidx.work.impl.model.WorkTypeConverters
 */
package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import androidx.work.impl.model.RawWorkInfoDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/*
 * Exception performing whole class analysis ignored.
 */
class RawWorkInfoDao_Impl.1
implements Callable<List<WorkSpec.WorkInfoPojo>> {
    final RawWorkInfoDao_Impl this$0;
    final SupportSQLiteQuery val$_internalQuery;

    RawWorkInfoDao_Impl.1(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SupportSQLiteQuery supportSQLiteQuery) {
        this.this$0 = rawWorkInfoDao_Impl;
        this.val$_internalQuery = supportSQLiteQuery;
    }

    @Override
    public List<WorkSpec.WorkInfoPojo> call() throws Exception {
        Cursor cursor = DBUtil.query((RoomDatabase)RawWorkInfoDao_Impl.access$000((RawWorkInfoDao_Impl)this.this$0), (SupportSQLiteQuery)this.val$_internalQuery, (boolean)true, null);
        try {
            ArrayList arrayList;
            Object object;
            int n = CursorUtil.getColumnIndex((Cursor)cursor, (String)"id");
            int n2 = CursorUtil.getColumnIndex((Cursor)cursor, (String)"state");
            int n3 = CursorUtil.getColumnIndex((Cursor)cursor, (String)"output");
            int n4 = CursorUtil.getColumnIndex((Cursor)cursor, (String)"run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (cursor.moveToNext()) {
                if (!cursor.isNull(n) && (ArrayList)arrayMap.get(object = cursor.getString(n)) == null) {
                    arrayList = new ArrayList();
                    arrayMap.put(object, (Object)arrayList);
                }
                if (cursor.isNull(n) || (ArrayList)arrayMap2.get(object = cursor.getString(n)) != null) continue;
                arrayList = new ArrayList();
                arrayMap2.put(object, arrayList);
            }
            cursor.moveToPosition(-1);
            RawWorkInfoDao_Impl.access$100((RawWorkInfoDao_Impl)this.this$0, (ArrayMap)arrayMap);
            RawWorkInfoDao_Impl.access$200((RawWorkInfoDao_Impl)this.this$0, (ArrayMap)arrayMap2);
            ArrayList<WorkSpec.WorkInfoPojo> arrayList2 = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
            while (cursor.moveToNext()) {
                object = !cursor.isNull(n) ? (ArrayList)arrayMap.get((Object)cursor.getString(n)) : null;
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
                if (n != -1) {
                    object.id = cursor.getString(n);
                }
                if (n2 != -1) {
                    object.state = WorkTypeConverters.intToState((int)cursor.getInt(n2));
                }
                if (n3 != -1) {
                    object.output = Data.fromByteArray((byte[])cursor.getBlob(n3));
                }
                if (n4 != -1) {
                    object.runAttemptCount = cursor.getInt(n4);
                }
                object.tags = arrayList;
                object.progress = workInfoPojo;
                arrayList2.add((WorkSpec.WorkInfoPojo)object);
            }
            return arrayList2;
        }
        finally {
            cursor.close();
        }
    }
}
