/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.query.AbstractQuery
 *  org.greenrobot.greendao.query.AbstractQueryWithLimit
 *  org.greenrobot.greendao.query.CursorQuery$QueryData
 */
package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQuery;
import org.greenrobot.greendao.query.AbstractQueryWithLimit;
import org.greenrobot.greendao.query.CursorQuery;

public class CursorQuery<T>
extends AbstractQueryWithLimit<T> {
    private final QueryData<T> queryData;

    private CursorQuery(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String string, String[] stringArray, int n, int n2) {
        super(abstractDao, string, stringArray, n, n2);
        this.queryData = queryData;
    }

    static <T2> CursorQuery<T2> create(AbstractDao<T2, ?> abstractDao, String string, Object[] objectArray, int n, int n2) {
        return (CursorQuery)new QueryData(abstractDao, string, CursorQuery.toStringArray((Object[])objectArray), n, n2).forCurrentThread();
    }

    public static <T2> CursorQuery<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String string, Object[] objectArray) {
        return CursorQuery.create(abstractDao, string, objectArray, -1, -1);
    }

    public CursorQuery forCurrentThread() {
        return (CursorQuery)this.queryData.forCurrentThread((AbstractQuery)this);
    }

    public Cursor query() {
        this.checkThread();
        return this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    }

    public CursorQuery<T> setParameter(int n, Boolean bl) {
        return (CursorQuery)super.setParameter(n, bl);
    }

    public CursorQuery<T> setParameter(int n, Object object) {
        return (CursorQuery)super.setParameter(n, object);
    }

    public CursorQuery<T> setParameter(int n, Date date) {
        return (CursorQuery)super.setParameter(n, date);
    }
}
