/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomSQLiteQuery
 *  androidx.room.SharedSQLiteStatement
 *  androidx.room.util.CursorUtil
 *  androidx.room.util.DBUtil
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteStatement
 *  androidx.work.impl.model.SystemIdInfo
 *  androidx.work.impl.model.SystemIdInfoDao
 */
package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import java.util.ArrayList;
import java.util.List;

public final class SystemIdInfoDao_Impl
implements SystemIdInfoDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SystemIdInfo> __insertionAdapterOfSystemIdInfo;
    private final SharedSQLiteStatement __preparedStmtOfRemoveSystemIdInfo;

    public SystemIdInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSystemIdInfo = new /* Unavailable Anonymous Inner Class!! */;
        this.__preparedStmtOfRemoveSystemIdInfo = new /* Unavailable Anonymous Inner Class!! */;
    }

    public SystemIdInfo getSystemIdInfo(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", (int)1);
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
            int n = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)"work_spec_id");
            int n2 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)"system_id");
            if (!roomDatabase.moveToFirst()) return string;
            string = new SystemIdInfo(roomDatabase.getString(n), roomDatabase.getInt(n2));
            return string;
        }
        finally {
            roomDatabase.close();
            roomSQLiteQuery.release();
        }
    }

    public List<String> getWorkSpecIds() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT DISTINCT work_spec_id FROM SystemIdInfo", (int)0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            ArrayList<String> arrayList = new ArrayList<String>(cursor.getCount());
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(0));
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public void insertSystemIdInfo(SystemIdInfo systemIdInfo) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSystemIdInfo.insert((Object)systemIdInfo);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void removeSystemIdInfo(String string) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfRemoveSystemIdInfo.acquire();
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
            this.__preparedStmtOfRemoveSystemIdInfo.release(supportSQLiteStatement);
        }
    }
}
