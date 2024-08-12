/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomSQLiteQuery
 *  androidx.room.util.DBUtil
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.work.impl.model.Dependency
 *  androidx.work.impl.model.DependencyDao
 */
package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import java.util.ArrayList;
import java.util.List;

public final class DependencyDao_Impl
implements DependencyDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Dependency> __insertionAdapterOfDependency;

    public DependencyDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfDependency = new /* Unavailable Anonymous Inner Class!! */;
    }

    public List<String> getDependentWorkIds(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        this.__db.assertNotSuspendingTransaction();
        string = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            ArrayList<String> arrayList = new ArrayList<String>(string.getCount());
            while (string.moveToNext()) {
                arrayList.add(string.getString(0));
            }
            return arrayList;
        }
        finally {
            string.close();
            roomSQLiteQuery.release();
        }
    }

    public List<String> getPrerequisites(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT prerequisite_id FROM dependency WHERE work_spec_id=?", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        this.__db.assertNotSuspendingTransaction();
        string = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            ArrayList<String> arrayList = new ArrayList<String>(string.getCount());
            while (string.moveToNext()) {
                arrayList.add(string.getString(0));
            }
            return arrayList;
        }
        finally {
            string.close();
            roomSQLiteQuery.release();
        }
    }

    public boolean hasCompletedAllPrerequisites(String string) {
        boolean bl = true;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        this.__db.assertNotSuspendingTransaction();
        string = this.__db;
        boolean bl2 = false;
        string = DBUtil.query((RoomDatabase)string, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            if (!string.moveToFirst()) return bl2;
            int n = string.getInt(0);
            bl2 = n != 0 ? bl : false;
        }
        finally {
            string.close();
            roomSQLiteQuery.release();
        }
        return bl2;
    }

    public boolean hasDependents(String string) {
        boolean bl = true;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        this.__db.assertNotSuspendingTransaction();
        string = this.__db;
        boolean bl2 = false;
        Cursor cursor = DBUtil.query((RoomDatabase)string, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            if (!cursor.moveToFirst()) return bl2;
            int n = cursor.getInt(0);
            bl2 = n != 0 ? bl : false;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
        return bl2;
    }

    public void insertDependency(Dependency dependency) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDependency.insert((Object)dependency);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}
