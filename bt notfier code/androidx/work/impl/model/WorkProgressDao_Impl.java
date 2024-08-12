/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomSQLiteQuery
 *  androidx.room.SharedSQLiteStatement
 *  androidx.room.util.DBUtil
 *  androidx.room.util.StringUtil
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteStatement
 *  androidx.work.Data
 *  androidx.work.impl.model.WorkProgress
 *  androidx.work.impl.model.WorkProgressDao
 */
package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao;
import java.util.ArrayList;
import java.util.List;

public final class WorkProgressDao_Impl
implements WorkProgressDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkProgress> __insertionAdapterOfWorkProgress;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public WorkProgressDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkProgress = new /* Unavailable Anonymous Inner Class!! */;
        this.__preparedStmtOfDelete = new /* Unavailable Anonymous Inner Class!! */;
        this.__preparedStmtOfDeleteAll = new /* Unavailable Anonymous Inner Class!! */;
    }

    public void delete(String string) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDelete.acquire();
        if (string == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, string);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(supportSQLiteStatement);
        }
    }

    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(supportSQLiteStatement);
        }
    }

    public Data getProgressForWorkSpecId(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT progress FROM WorkProgress WHERE work_spec_id=?", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        this.__db.assertNotSuspendingTransaction();
        RoomDatabase roomDatabase = this.__db;
        string = null;
        roomDatabase = DBUtil.query((RoomDatabase)roomDatabase, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            if (!roomDatabase.moveToFirst()) return string;
            string = Data.fromByteArray((byte[])roomDatabase.getBlob(0));
            return string;
        }
        finally {
            roomDatabase.close();
            roomSQLiteQuery.release();
        }
    }

    public List<Data> getProgressForWorkSpecIds(List<String> object) {
        StringBuilder stringBuilder = StringUtil.newStringBuilder();
        stringBuilder.append("SELECT progress FROM WorkProgress WHERE work_spec_id IN (");
        int n = object.size();
        StringUtil.appendPlaceholders((StringBuilder)stringBuilder, (int)n);
        stringBuilder.append(")");
        stringBuilder = RoomSQLiteQuery.acquire((String)stringBuilder.toString(), (int)(n + 0));
        ArrayList<Data> arrayList = object.iterator();
        n = 1;
        while (arrayList.hasNext()) {
            object = arrayList.next();
            if (object == null) {
                stringBuilder.bindNull(n);
            } else {
                stringBuilder.bindString(n, (String)object);
            }
            ++n;
        }
        this.__db.assertNotSuspendingTransaction();
        object = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)stringBuilder, (boolean)false, null);
        try {
            arrayList = new ArrayList<Data>(object.getCount());
            while (object.moveToNext()) {
                arrayList.add(Data.fromByteArray((byte[])object.getBlob(0)));
            }
            return arrayList;
        }
        finally {
            object.close();
            stringBuilder.release();
        }
    }

    public void insert(WorkProgress workProgress) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkProgress.insert((Object)workProgress);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}
