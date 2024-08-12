/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.InternalQueryDaoAccess
 */
package org.greenrobot.greendao.query;

import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;

abstract class AbstractQuery<T> {
    protected final AbstractDao<T, ?> dao;
    protected final InternalQueryDaoAccess<T> daoAccess;
    protected final Thread ownerThread;
    protected final String[] parameters;
    protected final String sql;

    protected AbstractQuery(AbstractDao<T, ?> abstractDao, String string, String[] stringArray) {
        this.dao = abstractDao;
        this.daoAccess = new InternalQueryDaoAccess(abstractDao);
        this.sql = string;
        this.parameters = stringArray;
        this.ownerThread = Thread.currentThread();
    }

    protected static String[] toStringArray(Object[] objectArray) {
        int n = objectArray.length;
        String[] stringArray = new String[n];
        int n2 = 0;
        while (n2 < n) {
            Object object = objectArray[n2];
            stringArray[n2] = object != null ? object.toString() : null;
            ++n2;
        }
        return stringArray;
    }

    protected void checkThread() {
        if (Thread.currentThread() != this.ownerThread) throw new DaoException("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
    }

    public AbstractQuery<T> setParameter(int n, Boolean comparable) {
        comparable = comparable != null ? Integer.valueOf(comparable.booleanValue() ? 1 : 0) : null;
        return this.setParameter(n, comparable);
    }

    public AbstractQuery<T> setParameter(int n, Object object) {
        this.checkThread();
        this.parameters[n] = object != null ? object.toString() : null;
        return this;
    }

    public AbstractQuery<T> setParameter(int n, Date comparable) {
        comparable = comparable != null ? Long.valueOf(comparable.getTime()) : null;
        return this.setParameter(n, comparable);
    }
}
