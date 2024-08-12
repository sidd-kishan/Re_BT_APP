/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.paging.PositionalDataSource
 *  androidx.paging.PositionalDataSource$LoadInitialCallback
 *  androidx.paging.PositionalDataSource$LoadInitialParams
 *  androidx.paging.PositionalDataSource$LoadRangeCallback
 *  androidx.paging.PositionalDataSource$LoadRangeParams
 *  androidx.room.InvalidationTracker$Observer
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteQuery
 */
package androidx.room.paging;

import android.database.Cursor;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Collections;
import java.util.List;

public abstract class LimitOffsetDataSource<T>
extends PositionalDataSource<T> {
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker.Observer mObserver;
    private final RoomSQLiteQuery mSourceQuery;

    protected LimitOffsetDataSource(RoomDatabase roomDatabase, RoomSQLiteQuery object, boolean bl, String ... stringArray) {
        this.mDb = roomDatabase;
        this.mSourceQuery = object;
        this.mInTransaction = bl;
        object = new StringBuilder();
        ((StringBuilder)object).append("SELECT COUNT(*) FROM ( ");
        ((StringBuilder)object).append(this.mSourceQuery.getSql());
        ((StringBuilder)object).append(" )");
        this.mCountQuery = ((StringBuilder)object).toString();
        object = new StringBuilder();
        ((StringBuilder)object).append("SELECT * FROM ( ");
        ((StringBuilder)object).append(this.mSourceQuery.getSql());
        ((StringBuilder)object).append(" ) LIMIT ? OFFSET ?");
        this.mLimitOffsetQuery = ((StringBuilder)object).toString();
        this.mObserver = new /* Unavailable Anonymous Inner Class!! */;
        roomDatabase.getInvalidationTracker().addWeakObserver(this.mObserver);
    }

    protected LimitOffsetDataSource(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean bl, String ... stringArray) {
        this(roomDatabase, RoomSQLiteQuery.copyFrom((SupportSQLiteQuery)supportSQLiteQuery), bl, stringArray);
    }

    private RoomSQLiteQuery getSQLiteQuery(int n, int n2) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)this.mLimitOffsetQuery, (int)(this.mSourceQuery.getArgCount() + 2));
        roomSQLiteQuery.copyArgumentsFrom(this.mSourceQuery);
        roomSQLiteQuery.bindLong(roomSQLiteQuery.getArgCount() - 1, (long)n2);
        roomSQLiteQuery.bindLong(roomSQLiteQuery.getArgCount(), (long)n);
        return roomSQLiteQuery;
    }

    protected abstract List<T> convertRows(Cursor var1);

    public int countItems() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)this.mCountQuery, (int)this.mSourceQuery.getArgCount());
        roomSQLiteQuery.copyArgumentsFrom(this.mSourceQuery);
        Cursor cursor = this.mDb.query((SupportSQLiteQuery)roomSQLiteQuery);
        try {
            if (!cursor.moveToFirst()) return 0;
            int n = cursor.getInt(0);
            return n;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public boolean isInvalid() {
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    public void loadInitial(PositionalDataSource.LoadInitialParams object, PositionalDataSource.LoadInitialCallback<T> loadInitialCallback) {
        RoomSQLiteQuery roomSQLiteQuery;
        Object object2;
        block8: {
            int n;
            int n2;
            block9: {
                Object object3;
                List list;
                block7: {
                    list = Collections.emptyList();
                    this.mDb.beginTransaction();
                    object3 = null;
                    object2 = null;
                    Object var9_8 = null;
                    try {
                        n2 = this.countItems();
                        if (n2 == 0) break block7;
                        n = LimitOffsetDataSource.computeInitialLoadPosition((PositionalDataSource.LoadInitialParams)object, (int)n2);
                        roomSQLiteQuery = this.getSQLiteQuery(n, LimitOffsetDataSource.computeInitialLoadSize((PositionalDataSource.LoadInitialParams)object, (int)n, (int)n2));
                        object = var9_8;
                    }
                    catch (Throwable throwable) {
                        roomSQLiteQuery = null;
                        break block8;
                    }
                    try {
                        object = object2 = this.mDb.query((SupportSQLiteQuery)roomSQLiteQuery);
                        list = this.convertRows((Cursor)object2);
                        object = object2;
                        this.mDb.setTransactionSuccessful();
                        object = list;
                        break block9;
                    }
                    catch (Throwable throwable) {
                        object2 = object;
                        object = throwable;
                        break block8;
                    }
                }
                n = 0;
                roomSQLiteQuery = null;
                object2 = object3;
                object = list;
            }
            if (object2 != null) {
                object2.close();
            }
            this.mDb.endTransaction();
            if (roomSQLiteQuery != null) {
                roomSQLiteQuery.release();
            }
            loadInitialCallback.onResult((List)object, n, n2);
            return;
        }
        if (object2 != null) {
            object2.close();
        }
        this.mDb.endTransaction();
        if (roomSQLiteQuery == null) throw object;
        roomSQLiteQuery.release();
        throw object;
    }

    public List<T> loadRange(int n, int n2) {
        RoomSQLiteQuery roomSQLiteQuery = this.getSQLiteQuery(n, n2);
        if (this.mInTransaction) {
            List<T> list;
            block7: {
                Cursor cursor;
                this.mDb.beginTransaction();
                Cursor cursor2 = null;
                try {
                    cursor2 = cursor = this.mDb.query((SupportSQLiteQuery)roomSQLiteQuery);
                    list = this.convertRows(cursor);
                    cursor2 = cursor;
                    this.mDb.setTransactionSuccessful();
                    if (cursor == null) break block7;
                }
                catch (Throwable throwable) {
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    this.mDb.endTransaction();
                    roomSQLiteQuery.release();
                    throw throwable;
                }
                cursor.close();
            }
            this.mDb.endTransaction();
            roomSQLiteQuery.release();
            return list;
        }
        Cursor cursor = this.mDb.query((SupportSQLiteQuery)roomSQLiteQuery);
        try {
            List<T> list = this.convertRows(cursor);
            return list;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public void loadRange(PositionalDataSource.LoadRangeParams loadRangeParams, PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(this.loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }
}
