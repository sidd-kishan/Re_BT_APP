/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDaoSession
 *  org.greenrobot.greendao.async.AsyncOperation
 *  org.greenrobot.greendao.async.AsyncOperation$OperationType
 *  org.greenrobot.greendao.async.AsyncOperationExecutor
 *  org.greenrobot.greendao.async.AsyncOperationListener
 *  org.greenrobot.greendao.query.Query
 */
package org.greenrobot.greendao.async;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.async.AsyncOperation;
import org.greenrobot.greendao.async.AsyncOperationExecutor;
import org.greenrobot.greendao.async.AsyncOperationListener;
import org.greenrobot.greendao.query.Query;

public class AsyncSession {
    private final AbstractDaoSession daoSession;
    private final AsyncOperationExecutor executor;
    private int sessionFlags;

    public AsyncSession(AbstractDaoSession abstractDaoSession) {
        this.daoSession = abstractDaoSession;
        this.executor = new AsyncOperationExecutor();
    }

    private <E> AsyncOperation enqueEntityOperation(AsyncOperation.OperationType operationType, Class<E> clazz, Object object, int n) {
        operationType = new AsyncOperation(operationType, this.daoSession.getDao(clazz), null, object, n | this.sessionFlags);
        this.executor.enqueue((AsyncOperation)operationType);
        return operationType;
    }

    private AsyncOperation enqueueDatabaseOperation(AsyncOperation.OperationType operationType, Object object, int n) {
        operationType = new AsyncOperation(operationType, null, this.daoSession.getDatabase(), object, n | this.sessionFlags);
        this.executor.enqueue((AsyncOperation)operationType);
        return operationType;
    }

    private AsyncOperation enqueueEntityOperation(AsyncOperation.OperationType operationType, Object object, int n) {
        return this.enqueEntityOperation(operationType, object.getClass(), object, n);
    }

    public AsyncOperation callInTx(Callable<?> callable) {
        return this.callInTx(callable, 0);
    }

    public AsyncOperation callInTx(Callable<?> callable, int n) {
        return this.enqueueDatabaseOperation(AsyncOperation.OperationType.TransactionCallable, callable, n);
    }

    public AsyncOperation count(Class<?> clazz) {
        return this.count(clazz, 0);
    }

    public AsyncOperation count(Class<?> clazz, int n) {
        return this.enqueEntityOperation(AsyncOperation.OperationType.Count, clazz, null, n);
    }

    public AsyncOperation delete(Object object) {
        return this.delete(object, 0);
    }

    public AsyncOperation delete(Object object, int n) {
        return this.enqueueEntityOperation(AsyncOperation.OperationType.Delete, object, n);
    }

    public <E> AsyncOperation deleteAll(Class<E> clazz) {
        return this.deleteAll(clazz, 0);
    }

    public <E> AsyncOperation deleteAll(Class<E> clazz, int n) {
        return this.enqueEntityOperation(AsyncOperation.OperationType.DeleteAll, clazz, null, n);
    }

    public AsyncOperation deleteByKey(Object object) {
        return this.deleteByKey(object, 0);
    }

    public AsyncOperation deleteByKey(Object object, int n) {
        return this.enqueueEntityOperation(AsyncOperation.OperationType.DeleteByKey, object, n);
    }

    public <E> AsyncOperation deleteInTx(Class<E> clazz, int n, E ... EArray) {
        return this.enqueEntityOperation(AsyncOperation.OperationType.DeleteInTxArray, clazz, EArray, n);
    }

    public <E> AsyncOperation deleteInTx(Class<E> clazz, Iterable<E> iterable) {
        return this.deleteInTx(clazz, iterable, 0);
    }

    public <E> AsyncOperation deleteInTx(Class<E> clazz, Iterable<E> iterable, int n) {
        return this.enqueEntityOperation(AsyncOperation.OperationType.DeleteInTxIterable, clazz, iterable, n);
    }

    public <E> AsyncOperation deleteInTx(Class<E> clazz, E ... EArray) {
        return this.deleteInTx(clazz, 0, EArray);
    }

    public AsyncOperationListener getListener() {
        return this.executor.getListener();
    }

    public AsyncOperationListener getListenerMainThread() {
        return this.executor.getListenerMainThread();
    }

    public int getMaxOperationCountToMerge() {
        return this.executor.getMaxOperationCountToMerge();
    }

    public int getSessionFlags() {
        return this.sessionFlags;
    }

    public int getWaitForMergeMillis() {
        return this.executor.getWaitForMergeMillis();
    }

    public AsyncOperation insert(Object object) {
        return this.insert(object, 0);
    }

    public AsyncOperation insert(Object object, int n) {
        return this.enqueueEntityOperation(AsyncOperation.OperationType.Insert, object, n);
    }

    public <E> AsyncOperation insertInTx(Class<E> clazz, int n, E ... EArray) {
        return this.enqueEntityOperation(AsyncOperation.OperationType.InsertInTxArray, clazz, EArray, n);
    }

    public <E> AsyncOperation insertInTx(Class<E> clazz, Iterable<E> iterable) {
        return this.insertInTx(clazz, iterable, 0);
    }

    public <E> AsyncOperation insertInTx(Class<E> clazz, Iterable<E> iterable, int n) {
        return this.enqueEntityOperation(AsyncOperation.OperationType.InsertInTxIterable, clazz, iterable, n);
    }

    public <E> AsyncOperation insertInTx(Class<E> clazz, E ... EArray) {
        return this.insertInTx(clazz, 0, EArray);
    }

    public AsyncOperation insertOrReplace(Object object) {
        return this.insertOrReplace(object, 0);
    }

    public AsyncOperation insertOrReplace(Object object, int n) {
        return this.enqueueEntityOperation(AsyncOperation.OperationType.InsertOrReplace, object, n);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> clazz, int n, E ... EArray) {
        return this.enqueEntityOperation(AsyncOperation.OperationType.InsertOrReplaceInTxArray, clazz, EArray, n);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> clazz, Iterable<E> iterable) {
        return this.insertOrReplaceInTx(clazz, iterable, 0);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> clazz, Iterable<E> iterable, int n) {
        return this.enqueEntityOperation(AsyncOperation.OperationType.InsertOrReplaceInTxIterable, clazz, iterable, n);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> clazz, E ... EArray) {
        return this.insertOrReplaceInTx(clazz, 0, EArray);
    }

    public boolean isCompleted() {
        return this.executor.isCompleted();
    }

    public AsyncOperation load(Class<?> clazz, Object object) {
        return this.load(clazz, object, 0);
    }

    public AsyncOperation load(Class<?> clazz, Object object, int n) {
        return this.enqueEntityOperation(AsyncOperation.OperationType.Load, clazz, object, n);
    }

    public AsyncOperation loadAll(Class<?> clazz) {
        return this.loadAll(clazz, 0);
    }

    public AsyncOperation loadAll(Class<?> clazz, int n) {
        return this.enqueEntityOperation(AsyncOperation.OperationType.LoadAll, clazz, null, n);
    }

    public AsyncOperation queryList(Query<?> query) {
        return this.queryList(query, 0);
    }

    public AsyncOperation queryList(Query<?> query, int n) {
        return this.enqueueDatabaseOperation(AsyncOperation.OperationType.QueryList, query, n);
    }

    public AsyncOperation queryUnique(Query<?> query) {
        return this.queryUnique(query, 0);
    }

    public AsyncOperation queryUnique(Query<?> query, int n) {
        return this.enqueueDatabaseOperation(AsyncOperation.OperationType.QueryUnique, query, n);
    }

    public AsyncOperation refresh(Object object) {
        return this.refresh(object, 0);
    }

    public AsyncOperation refresh(Object object, int n) {
        return this.enqueueEntityOperation(AsyncOperation.OperationType.Refresh, object, n);
    }

    public AsyncOperation runInTx(Runnable runnable) {
        return this.runInTx(runnable, 0);
    }

    public AsyncOperation runInTx(Runnable runnable, int n) {
        return this.enqueueDatabaseOperation(AsyncOperation.OperationType.TransactionRunnable, runnable, n);
    }

    public void setListener(AsyncOperationListener asyncOperationListener) {
        this.executor.setListener(asyncOperationListener);
    }

    public void setListenerMainThread(AsyncOperationListener asyncOperationListener) {
        this.executor.setListenerMainThread(asyncOperationListener);
    }

    public void setMaxOperationCountToMerge(int n) {
        this.executor.setMaxOperationCountToMerge(n);
    }

    public void setSessionFlags(int n) {
        this.sessionFlags = n;
    }

    public void setWaitForMergeMillis(int n) {
        this.executor.setWaitForMergeMillis(n);
    }

    public AsyncOperation update(Object object) {
        return this.update(object, 0);
    }

    public AsyncOperation update(Object object, int n) {
        return this.enqueueEntityOperation(AsyncOperation.OperationType.Update, object, n);
    }

    public <E> AsyncOperation updateInTx(Class<E> clazz, int n, E ... EArray) {
        return this.enqueEntityOperation(AsyncOperation.OperationType.UpdateInTxArray, clazz, EArray, n);
    }

    public <E> AsyncOperation updateInTx(Class<E> clazz, Iterable<E> iterable) {
        return this.updateInTx(clazz, iterable, 0);
    }

    public <E> AsyncOperation updateInTx(Class<E> clazz, Iterable<E> iterable, int n) {
        return this.enqueEntityOperation(AsyncOperation.OperationType.UpdateInTxIterable, clazz, iterable, n);
    }

    public <E> AsyncOperation updateInTx(Class<E> clazz, E ... EArray) {
        return this.updateInTx(clazz, 0, EArray);
    }

    public void waitForCompletion() {
        this.executor.waitForCompletion();
    }

    public boolean waitForCompletion(int n) {
        return this.executor.waitForCompletion(n);
    }
}
