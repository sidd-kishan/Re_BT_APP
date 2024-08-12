/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomSQLiteQuery
 *  androidx.room.util.DBUtil
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.work.impl.model.WorkTag
 *  androidx.work.impl.model.WorkTagDao
 */
package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao;
import java.util.ArrayList;
import java.util.List;

public final class WorkTagDao_Impl
implements WorkTagDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkTag> __insertionAdapterOfWorkTag;

    public WorkTagDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkTag = new /* Unavailable Anonymous Inner Class!! */;
    }

    public List<String> getTagsForWorkSpecId(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", (int)1);
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

    public List<String> getWorkSpecIdsWithTag(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT work_spec_id FROM worktag WHERE tag=?", (int)1);
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

    public void insert(WorkTag workTag) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkTag.insert((Object)workTag);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}
