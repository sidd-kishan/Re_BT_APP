/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.async.AsyncSession
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.query.QueryBuilder
 *  org.greenrobot.greendao.rx.RxTransaction
 *  rx.schedulers.Schedulers
 */
package org.greenrobot.greendao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxTransaction;
import rx.schedulers.Schedulers;

public class AbstractDaoSession {
    private final Database db;
    private final Map<Class<?>, AbstractDao<?, ?>> entityToDao;
    private volatile RxTransaction rxTxIo;
    private volatile RxTransaction rxTxPlain;

    public AbstractDaoSession(Database database) {
        this.db = database;
        this.entityToDao = new HashMap();
    }

    public <V> V callInTx(Callable<V> callable) throws Exception {
        this.db.beginTransaction();
        try {
            callable = callable.call();
            this.db.setTransactionSuccessful();
            return (V)callable;
        }
        finally {
            this.db.endTransaction();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public <V> V callInTxNoException(Callable<V> var1_1) {
        block5: {
            this.db.beginTransaction();
            var1_1 /* !! */  = var1_1 /* !! */ .call();
            ** GOTO lbl8
            {
                catch (Throwable var1_2) {
                    break block5;
                }
lbl8:
                // 1 sources

                this.db.setTransactionSuccessful();
                this.db.endTransaction();
                return (V)var1_1 /* !! */ ;
                catch (Exception var1_3) {}
                {
                    var2_4 = new DaoException("Callable failed", (Throwable)var1_3);
                    throw var2_4;
                }
            }
        }
        this.db.endTransaction();
        throw var1_2;
    }

    public <T> void delete(T t) {
        this.getDao(t.getClass()).delete(t);
    }

    public <T> void deleteAll(Class<T> clazz) {
        this.getDao(clazz).deleteAll();
    }

    public Collection<AbstractDao<?, ?>> getAllDaos() {
        return Collections.unmodifiableCollection(this.entityToDao.values());
    }

    public AbstractDao<?, ?> getDao(Class<? extends Object> clazz) {
        Object object = this.entityToDao.get(clazz);
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No DAO registered for ");
        ((StringBuilder)object).append(clazz);
        throw new DaoException(((StringBuilder)object).toString());
    }

    public Database getDatabase() {
        return this.db;
    }

    public <T> long insert(T t) {
        return this.getDao(t.getClass()).insert(t);
    }

    public <T> long insertOrReplace(T t) {
        return this.getDao(t.getClass()).insertOrReplace(t);
    }

    public <T, K> T load(Class<T> clazz, K k) {
        return (T)this.getDao(clazz).load(k);
    }

    public <T, K> List<T> loadAll(Class<T> clazz) {
        return this.getDao(clazz).loadAll();
    }

    public <T> QueryBuilder<T> queryBuilder(Class<T> clazz) {
        return this.getDao(clazz).queryBuilder();
    }

    public <T, K> List<T> queryRaw(Class<T> clazz, String string, String ... stringArray) {
        return this.getDao(clazz).queryRaw(string, stringArray);
    }

    public <T> void refresh(T t) {
        this.getDao(t.getClass()).refresh(t);
    }

    protected <T> void registerDao(Class<T> clazz, AbstractDao<T, ?> abstractDao) {
        this.entityToDao.put(clazz, abstractDao);
    }

    public void runInTx(Runnable runnable) {
        this.db.beginTransaction();
        try {
            runnable.run();
            this.db.setTransactionSuccessful();
            return;
        }
        finally {
            this.db.endTransaction();
        }
    }

    public RxTransaction rxTx() {
        if (this.rxTxIo != null) return this.rxTxIo;
        this.rxTxIo = new RxTransaction(this, Schedulers.io());
        return this.rxTxIo;
    }

    public RxTransaction rxTxPlain() {
        if (this.rxTxPlain != null) return this.rxTxPlain;
        this.rxTxPlain = new RxTransaction(this);
        return this.rxTxPlain;
    }

    public AsyncSession startAsyncSession() {
        return new AsyncSession(this);
    }

    public <T> void update(T t) {
        this.getDao(t.getClass()).update(t);
    }
}
