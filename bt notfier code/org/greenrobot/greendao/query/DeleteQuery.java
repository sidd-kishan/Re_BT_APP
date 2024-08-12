/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.query.AbstractQuery
 *  org.greenrobot.greendao.query.DeleteQuery$QueryData
 */
package org.greenrobot.greendao.query;

import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.AbstractQuery;
import org.greenrobot.greendao.query.DeleteQuery;

public class DeleteQuery<T>
extends AbstractQuery<T> {
    private final QueryData<T> queryData;

    private DeleteQuery(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String string, String[] stringArray) {
        super(abstractDao, string, stringArray);
        this.queryData = queryData;
    }

    static <T2> DeleteQuery<T2> create(AbstractDao<T2, ?> abstractDao, String string, Object[] objectArray) {
        return (DeleteQuery)new QueryData(abstractDao, string, DeleteQuery.toStringArray((Object[])objectArray), null).forCurrentThread();
    }

    public void executeDeleteWithoutDetachingEntities() {
        this.checkThread();
        Database database = this.dao.getDatabase();
        if (database.isDbLockedByCurrentThread()) {
            this.dao.getDatabase().execSQL(this.sql, (Object[])this.parameters);
        } else {
            database.beginTransaction();
            this.dao.getDatabase().execSQL(this.sql, (Object[])this.parameters);
            database.setTransactionSuccessful();
        }
        return;
        finally {
            database.endTransaction();
        }
    }

    public DeleteQuery<T> forCurrentThread() {
        return (DeleteQuery)this.queryData.forCurrentThread((AbstractQuery)this);
    }

    public DeleteQuery<T> setParameter(int n, Boolean bl) {
        return (DeleteQuery)super.setParameter(n, bl);
    }

    public DeleteQuery<T> setParameter(int n, Object object) {
        return (DeleteQuery)super.setParameter(n, object);
    }

    public DeleteQuery<T> setParameter(int n, Date date) {
        return (DeleteQuery)super.setParameter(n, date);
    }
}
