/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.query.AbstractQuery
 *  org.greenrobot.greendao.query.CountQuery$QueryData
 */
package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.query.AbstractQuery;
import org.greenrobot.greendao.query.CountQuery;

public class CountQuery<T>
extends AbstractQuery<T> {
    private final QueryData<T> queryData;

    private CountQuery(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String string, String[] stringArray) {
        super(abstractDao, string, stringArray);
        this.queryData = queryData;
    }

    static <T2> CountQuery<T2> create(AbstractDao<T2, ?> abstractDao, String string, Object[] objectArray) {
        return (CountQuery)new QueryData(abstractDao, string, CountQuery.toStringArray((Object[])objectArray), null).forCurrentThread();
    }

    public long count() {
        this.checkThread();
        Cursor cursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
        try {
            if (cursor.moveToNext()) {
                if (!cursor.isLast()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected row count: ");
                    stringBuilder.append(cursor.getCount());
                    DaoException daoException = new DaoException(stringBuilder.toString());
                    throw daoException;
                }
                if (cursor.getColumnCount() == 1) {
                    long l = cursor.getLong(0);
                    return l;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected column count: ");
                stringBuilder.append(cursor.getColumnCount());
                DaoException daoException = new DaoException(stringBuilder.toString());
                throw daoException;
            }
            DaoException daoException = new DaoException("No result for count");
            throw daoException;
        }
        finally {
            cursor.close();
        }
    }

    public CountQuery<T> forCurrentThread() {
        return (CountQuery)this.queryData.forCurrentThread((AbstractQuery)this);
    }

    public CountQuery<T> setParameter(int n, Boolean bl) {
        return (CountQuery)super.setParameter(n, bl);
    }

    public CountQuery<T> setParameter(int n, Object object) {
        return (CountQuery)super.setParameter(n, object);
    }

    public CountQuery<T> setParameter(int n, Date date) {
        return (CountQuery)super.setParameter(n, date);
    }
}
