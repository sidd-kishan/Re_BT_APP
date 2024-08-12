/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.collection.ArrayMap
 *  androidx.lifecycle.LiveData
 *  androidx.room.InvalidationTracker
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomSQLiteQuery
 *  androidx.room.util.CursorUtil
 *  androidx.room.util.DBUtil
 *  androidx.room.util.StringUtil
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.work.Data
 *  androidx.work.impl.model.RawWorkInfoDao
 *  androidx.work.impl.model.WorkSpec$WorkInfoPojo
 *  androidx.work.impl.model.WorkTypeConverters
 */
package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class RawWorkInfoDao_Impl
implements RawWorkInfoDao {
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void __fetchRelationshipWorkProgressAsandroidxWorkData(ArrayMap<String, ArrayList<Data>> arrayMap) {
        Object object = arrayMap.keySet();
        if (object.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            ArrayMap arrayMap2 = new ArrayMap(999);
            int n = arrayMap.size();
            int n2 = 0;
            while (true) {
                int n3;
                int n4;
                int n5 = 0;
                do {
                    if (n2 >= n) {
                        if (n5 <= 0) return;
                        this.__fetchRelationshipWorkProgressAsandroidxWorkData((ArrayMap<String, ArrayList<Data>>)arrayMap2);
                        return;
                    }
                    arrayMap2.put((Object)((String)arrayMap.keyAt(n2)), (Object)((ArrayList)arrayMap.valueAt(n2)));
                    n3 = n2 + 1;
                    n4 = n5 + 1;
                    n2 = n3;
                    n5 = n4;
                } while (n4 != 999);
                this.__fetchRelationshipWorkProgressAsandroidxWorkData((ArrayMap<String, ArrayList<Data>>)arrayMap2);
                arrayMap2 = new ArrayMap(999);
                n2 = n3;
            }
        }
        StringBuilder stringBuilder = StringUtil.newStringBuilder();
        stringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int n = object.size();
        StringUtil.appendPlaceholders((StringBuilder)stringBuilder, (int)n);
        stringBuilder.append(")");
        stringBuilder = RoomSQLiteQuery.acquire((String)stringBuilder.toString(), (int)(n + 0));
        object = object.iterator();
        n = 1;
        while (object.hasNext()) {
            String string = (String)object.next();
            if (string == null) {
                stringBuilder.bindNull(n);
            } else {
                stringBuilder.bindString(n, string);
            }
            ++n;
        }
        stringBuilder = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)stringBuilder, (boolean)false, null);
        try {
            n = CursorUtil.getColumnIndex((Cursor)stringBuilder, (String)"work_spec_id");
            if (n == -1) {
                return;
            }
            while (stringBuilder.moveToNext()) {
                if (stringBuilder.isNull(n) || (object = (ArrayList)arrayMap.get((Object)stringBuilder.getString(n))) == null) continue;
                ((ArrayList)object).add(Data.fromByteArray((byte[])stringBuilder.getBlob(0)));
            }
            return;
        }
        finally {
            stringBuilder.close();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void __fetchRelationshipWorkTagAsjavaLangString(ArrayMap<String, ArrayList<String>> arrayMap) {
        Object object = arrayMap.keySet();
        if (object.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            ArrayMap arrayMap2 = new ArrayMap(999);
            int n = arrayMap.size();
            int n2 = 0;
            while (true) {
                int n3;
                int n4;
                int n5 = 0;
                do {
                    if (n2 >= n) {
                        if (n5 <= 0) return;
                        this.__fetchRelationshipWorkTagAsjavaLangString((ArrayMap<String, ArrayList<String>>)arrayMap2);
                        return;
                    }
                    arrayMap2.put((Object)((String)arrayMap.keyAt(n2)), (Object)((ArrayList)arrayMap.valueAt(n2)));
                    n3 = n2 + 1;
                    n4 = n5 + 1;
                    n2 = n3;
                    n5 = n4;
                } while (n4 != 999);
                this.__fetchRelationshipWorkTagAsjavaLangString((ArrayMap<String, ArrayList<String>>)arrayMap2);
                arrayMap2 = new ArrayMap(999);
                n2 = n3;
            }
        }
        StringBuilder stringBuilder = StringUtil.newStringBuilder();
        stringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int n = object.size();
        StringUtil.appendPlaceholders((StringBuilder)stringBuilder, (int)n);
        stringBuilder.append(")");
        stringBuilder = RoomSQLiteQuery.acquire((String)stringBuilder.toString(), (int)(n + 0));
        object = object.iterator();
        n = 1;
        while (object.hasNext()) {
            String string = (String)object.next();
            if (string == null) {
                stringBuilder.bindNull(n);
            } else {
                stringBuilder.bindString(n, string);
            }
            ++n;
        }
        stringBuilder = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)stringBuilder, (boolean)false, null);
        try {
            n = CursorUtil.getColumnIndex((Cursor)stringBuilder, (String)"work_spec_id");
            if (n == -1) {
                return;
            }
            while (stringBuilder.moveToNext()) {
                if (stringBuilder.isNull(n) || (object = (ArrayList)arrayMap.get((Object)stringBuilder.getString(n))) == null) continue;
                ((ArrayList)object).add(stringBuilder.getString(0));
            }
            return;
        }
        finally {
            stringBuilder.close();
        }
    }

    static /* synthetic */ RoomDatabase access$000(RawWorkInfoDao_Impl rawWorkInfoDao_Impl) {
        return rawWorkInfoDao_Impl.__db;
    }

    static /* synthetic */ void access$100(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, ArrayMap arrayMap) {
        rawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString((ArrayMap<String, ArrayList<String>>)arrayMap);
    }

    static /* synthetic */ void access$200(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, ArrayMap arrayMap) {
        rawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData((ArrayMap<String, ArrayList<Data>>)arrayMap);
    }

    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery object) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)object, (boolean)true, null);
        try {
            ArrayList arrayList;
            int n = CursorUtil.getColumnIndex((Cursor)cursor, (String)"id");
            int n2 = CursorUtil.getColumnIndex((Cursor)cursor, (String)"state");
            int n3 = CursorUtil.getColumnIndex((Cursor)cursor, (String)"output");
            int n4 = CursorUtil.getColumnIndex((Cursor)cursor, (String)"run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (cursor.moveToNext()) {
                if (!cursor.isNull(n) && (ArrayList)arrayMap.get((Object)(arrayList = cursor.getString(n))) == null) {
                    object = new ArrayList();
                    arrayMap.put((Object)arrayList, object);
                }
                if (cursor.isNull(n) || (ArrayList)arrayMap2.get((Object)(arrayList = cursor.getString(n))) != null) continue;
                object = new ArrayList();
                arrayMap2.put((Object)arrayList, object);
            }
            cursor.moveToPosition(-1);
            this.__fetchRelationshipWorkTagAsjavaLangString((ArrayMap<String, ArrayList<String>>)arrayMap);
            this.__fetchRelationshipWorkProgressAsandroidxWorkData((ArrayMap<String, ArrayList<Data>>)arrayMap2);
            ArrayList<WorkSpec.WorkInfoPojo> arrayList2 = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
            while (cursor.moveToNext()) {
                object = !cursor.isNull(n) ? (ArrayList)arrayMap.get((Object)cursor.getString(n)) : null;
                arrayList = object;
                if (object == null) {
                    arrayList = new ArrayList();
                }
                object = !cursor.isNull(n) ? (ArrayList)arrayMap2.get((Object)cursor.getString(n)) : null;
                Object object2 = object;
                if (object == null) {
                    object2 = new ArrayList();
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
                object.progress = object2;
                arrayList2.add((WorkSpec.WorkInfoPojo)object);
            }
            return arrayList2;
        }
        finally {
            cursor.close();
        }
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(SupportSQLiteQuery supportSQLiteQuery) {
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        supportSQLiteQuery = new /* Unavailable Anonymous Inner Class!! */;
        return invalidationTracker.createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, (Callable)supportSQLiteQuery);
    }
}
