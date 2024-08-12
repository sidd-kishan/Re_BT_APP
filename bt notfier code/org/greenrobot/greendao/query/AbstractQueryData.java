/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.query.AbstractQuery
 */
package org.greenrobot.greendao.query;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQuery;

abstract class AbstractQueryData<T, Q extends AbstractQuery<T>> {
    final AbstractDao<T, ?> dao;
    final String[] initialValues;
    final Map<Long, WeakReference<Q>> queriesForThreads;
    final String sql;

    AbstractQueryData(AbstractDao<T, ?> abstractDao, String string, String[] stringArray) {
        this.dao = abstractDao;
        this.sql = string;
        this.initialValues = stringArray;
        this.queriesForThreads = new HashMap<Long, WeakReference<Q>>();
    }

    protected abstract Q createQuery();

    Q forCurrentThread() {
        long l = Thread.currentThread().getId();
        Map<Long, WeakReference<Q>> map = this.queriesForThreads;
        synchronized (map) {
            Object object = this.queriesForThreads.get(l);
            object = object != null ? (AbstractQuery)object.get() : null;
            if (object == null) {
                this.gc();
                object = this.createQuery();
                Map<Long, WeakReference<Q>> map2 = this.queriesForThreads;
                WeakReference<AbstractQuery> weakReference = new WeakReference<AbstractQuery>((AbstractQuery)object);
                map2.put(l, weakReference);
            } else {
                System.arraycopy(this.initialValues, 0, object.parameters, 0, this.initialValues.length);
            }
            return (Q)object;
        }
    }

    Q forCurrentThread(Q q) {
        if (Thread.currentThread() != ((AbstractQuery)q).ownerThread) return this.forCurrentThread();
        System.arraycopy(this.initialValues, 0, ((AbstractQuery)q).parameters, 0, this.initialValues.length);
        return q;
    }

    void gc() {
        Map<Long, WeakReference<Q>> map = this.queriesForThreads;
        synchronized (map) {
            try {
                Iterator<Map.Entry<Long, WeakReference<Q>>> iterator = this.queriesForThreads.entrySet().iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().getValue().get() != null) continue;
                    iterator.remove();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
