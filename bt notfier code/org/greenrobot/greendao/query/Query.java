/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.query.AbstractQuery
 *  org.greenrobot.greendao.query.AbstractQueryWithLimit
 *  org.greenrobot.greendao.query.CloseableListIterator
 *  org.greenrobot.greendao.query.LazyList
 *  org.greenrobot.greendao.query.Query$QueryData
 *  org.greenrobot.greendao.rx.RxQuery
 *  rx.schedulers.Schedulers
 */
package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.query.AbstractQuery;
import org.greenrobot.greendao.query.AbstractQueryWithLimit;
import org.greenrobot.greendao.query.CloseableListIterator;
import org.greenrobot.greendao.query.LazyList;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.rx.RxQuery;
import rx.schedulers.Schedulers;

public class Query<T>
extends AbstractQueryWithLimit<T> {
    private final QueryData<T> queryData;
    private volatile RxQuery rxTxIo;
    private volatile RxQuery rxTxPlain;

    private Query(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String string, String[] stringArray, int n, int n2) {
        super(abstractDao, string, stringArray, n, n2);
        this.queryData = queryData;
    }

    static <T2> Query<T2> create(AbstractDao<T2, ?> abstractDao, String string, Object[] objectArray, int n, int n2) {
        return (Query)new QueryData(abstractDao, string, Query.toStringArray((Object[])objectArray), n, n2).forCurrentThread();
    }

    public static <T2> Query<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String string, Object[] objectArray) {
        return Query.create(abstractDao, string, objectArray, -1, -1);
    }

    public RxQuery __InternalRx() {
        if (this.rxTxIo != null) return this.rxTxIo;
        this.rxTxIo = new RxQuery(this, Schedulers.io());
        return this.rxTxIo;
    }

    public RxQuery __internalRxPlain() {
        if (this.rxTxPlain != null) return this.rxTxPlain;
        this.rxTxPlain = new RxQuery(this);
        return this.rxTxPlain;
    }

    public Query<T> forCurrentThread() {
        return (Query)this.queryData.forCurrentThread((AbstractQuery)this);
    }

    public List<T> list() {
        this.checkThread();
        Cursor cursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
        return this.daoAccess.loadAllAndCloseCursor(cursor);
    }

    public CloseableListIterator<T> listIterator() {
        return this.listLazyUncached().listIteratorAutoClose();
    }

    public LazyList<T> listLazy() {
        this.checkThread();
        Cursor cursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
        return new LazyList(this.daoAccess, cursor, true);
    }

    public LazyList<T> listLazyUncached() {
        this.checkThread();
        Cursor cursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
        return new LazyList(this.daoAccess, cursor, false);
    }

    public Query<T> setParameter(int n, Boolean bl) {
        return (Query)super.setParameter(n, bl);
    }

    public Query<T> setParameter(int n, Object object) {
        return (Query)super.setParameter(n, object);
    }

    public Query<T> setParameter(int n, Date date) {
        return (Query)super.setParameter(n, date);
    }

    public T unique() {
        this.checkThread();
        Cursor cursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
        return (T)this.daoAccess.loadUniqueAndCloseCursor(cursor);
    }

    public T uniqueOrThrow() {
        T t = this.unique();
        if (t == null) throw new DaoException("No entity found for query");
        return t;
    }
}
