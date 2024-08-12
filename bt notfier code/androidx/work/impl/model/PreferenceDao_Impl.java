/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.lifecycle.LiveData
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomSQLiteQuery
 *  androidx.room.util.DBUtil
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.work.impl.model.Preference
 *  androidx.work.impl.model.PreferenceDao
 */
package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao;
import java.util.concurrent.Callable;

public final class PreferenceDao_Impl
implements PreferenceDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Preference> __insertionAdapterOfPreference;

    public PreferenceDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfPreference = new /* Unavailable Anonymous Inner Class!! */;
    }

    static /* synthetic */ RoomDatabase access$000(PreferenceDao_Impl preferenceDao_Impl) {
        return preferenceDao_Impl.__db;
    }

    public Long getLongValue(String object) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT long_value FROM Preference where `key`=?", (int)1);
        if (object == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, (String)object);
        }
        this.__db.assertNotSuspendingTransaction();
        object = this.__db;
        Object var2_4 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        object = var2_4;
        try {
            if (!cursor.moveToFirst()) return object;
            object = cursor.isNull(0) ? var2_4 : Long.valueOf(cursor.getLong(0));
            return object;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData<Long> getObservableLongValue(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT long_value FROM Preference where `key`=?", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        string = this.__db.getInvalidationTracker();
        roomSQLiteQuery = new /* Unavailable Anonymous Inner Class!! */;
        return string.createLiveData(new String[]{"Preference"}, false, (Callable)roomSQLiteQuery);
    }

    public void insertPreference(Preference preference) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPreference.insert((Object)preference);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}
