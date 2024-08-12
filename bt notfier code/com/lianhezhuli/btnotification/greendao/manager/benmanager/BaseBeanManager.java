/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.query.QueryBuilder
 */
package com.lianhezhuli.btnotification.greendao.manager.benmanager;

import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.QueryBuilder;

public class BaseBeanManager<T, K> {
    private AbstractDao<T, K> mDao;

    public BaseBeanManager(AbstractDao abstractDao) {
        this.mDao = abstractDao;
    }

    public long count() {
        return this.mDao.count();
    }

    public void delete(T t) {
        this.mDao.delete(t);
    }

    public void delete(List<T> list) {
        this.mDao.deleteInTx(list);
    }

    public void delete(T ... TArray) {
        this.mDao.deleteInTx((Object[])TArray);
    }

    public void deleteAll() {
        this.mDao.deleteAll();
    }

    public void deleteByKey(K k) {
        this.mDao.deleteByKey(k);
    }

    public void detach(T t) {
        this.mDao.detach(t);
    }

    public T query(K k) {
        return (T)this.mDao.load(k);
    }

    public List<T> query(String string, String ... stringArray) {
        return this.mDao.queryRaw(string, stringArray);
    }

    public List<T> queryAll() {
        return this.mDao.loadAll();
    }

    public QueryBuilder<T> queryBuilder() {
        return this.mDao.queryBuilder();
    }

    public void refresh(T t) {
        this.mDao.refresh(t);
    }

    public void save(T t) {
        this.mDao.insert(t);
    }

    public void save(List<T> list) {
        this.mDao.insertInTx(list);
    }

    public void save(T ... TArray) {
        this.mDao.insertInTx((Object[])TArray);
    }

    public void saveOrUpdate(T t) {
        this.mDao.insertOrReplace(t);
    }

    public void saveOrUpdate(List<T> list) {
        this.mDao.insertOrReplaceInTx(list);
    }

    public void saveOrUpdate(T ... TArray) {
        this.mDao.insertOrReplaceInTx((Object[])TArray);
    }

    public void update(T t) {
        this.mDao.update(t);
    }

    public void update(List<T> list) {
        this.mDao.updateInTx(list);
    }

    public void update(T ... TArray) {
        this.mDao.updateInTx((Object[])TArray);
    }
}
