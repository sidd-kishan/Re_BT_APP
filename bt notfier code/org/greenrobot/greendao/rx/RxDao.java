/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.rx.RxBase
 *  rx.Observable
 *  rx.Scheduler
 */
package org.greenrobot.greendao.rx;

import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.rx.RxBase;
import rx.Observable;
import rx.Scheduler;

public class RxDao<T, K>
extends RxBase {
    private final AbstractDao<T, K> dao;

    public RxDao(AbstractDao<T, K> abstractDao) {
        this(abstractDao, null);
    }

    public RxDao(AbstractDao<T, K> abstractDao, Scheduler scheduler) {
        super(scheduler);
        this.dao = abstractDao;
    }

    static /* synthetic */ AbstractDao access$000(RxDao rxDao) {
        return rxDao.dao;
    }

    public Observable<Long> count() {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Void> delete(T t) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Void> deleteAll() {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Void> deleteByKey(K k) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Void> deleteByKeyInTx(Iterable<K> iterable) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Void> deleteByKeyInTx(K ... KArray) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Void> deleteInTx(Iterable<T> iterable) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Void> deleteInTx(T ... TArray) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public AbstractDao<T, K> getDao() {
        return this.dao;
    }

    public Observable<T> insert(T t) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Iterable<T>> insertInTx(Iterable<T> iterable) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Object[]> insertInTx(T ... TArray) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<T> insertOrReplace(T t) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Iterable<T>> insertOrReplaceInTx(Iterable<T> iterable) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Object[]> insertOrReplaceInTx(T ... TArray) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<T> load(K k) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<List<T>> loadAll() {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<T> refresh(T t) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<T> save(T t) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Iterable<T>> saveInTx(Iterable<T> iterable) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Object[]> saveInTx(T ... TArray) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<T> update(T t) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Iterable<T>> updateInTx(Iterable<T> iterable) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<Object[]> updateInTx(T ... TArray) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
