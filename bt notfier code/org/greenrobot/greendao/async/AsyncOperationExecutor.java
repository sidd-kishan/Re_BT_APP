/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.DaoLog
 *  org.greenrobot.greendao.async.AsyncOperation
 *  org.greenrobot.greendao.async.AsyncOperationExecutor$1
 *  org.greenrobot.greendao.async.AsyncOperationListener
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.query.Query
 */
package org.greenrobot.greendao.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.async.AsyncOperation;
import org.greenrobot.greendao.async.AsyncOperationExecutor;
import org.greenrobot.greendao.async.AsyncOperationListener;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.Query;

class AsyncOperationExecutor
implements Runnable,
Handler.Callback {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private int countOperationsCompleted;
    private int countOperationsEnqueued;
    private volatile boolean executorRunning;
    private Handler handlerMainThread;
    private int lastSequenceNumber;
    private volatile AsyncOperationListener listener;
    private volatile AsyncOperationListener listenerMainThread;
    private volatile int maxOperationCountToMerge = 50;
    private final BlockingQueue<AsyncOperation> queue = new LinkedBlockingQueue<AsyncOperation>();
    private volatile int waitForMergeMillis = 50;

    AsyncOperationExecutor() {
    }

    private void executeOperation(AsyncOperation asyncOperation) {
        block26: {
            asyncOperation.timeStarted = System.currentTimeMillis();
            try {
                switch (1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[asyncOperation.type.ordinal()]) {
                    default: {
                        break;
                    }
                    case 22: {
                        asyncOperation.dao.refresh(asyncOperation.parameter);
                        break block26;
                    }
                    case 21: {
                        asyncOperation.result = asyncOperation.dao.count();
                        break block26;
                    }
                    case 20: {
                        asyncOperation.result = asyncOperation.dao.loadAll();
                        break block26;
                    }
                    case 19: {
                        asyncOperation.result = asyncOperation.dao.load(asyncOperation.parameter);
                        break block26;
                    }
                    case 18: {
                        asyncOperation.dao.deleteAll();
                        break block26;
                    }
                    case 17: {
                        asyncOperation.dao.deleteByKey(asyncOperation.parameter);
                        break block26;
                    }
                    case 16: {
                        asyncOperation.result = ((Query)asyncOperation.parameter).forCurrentThread().unique();
                        break block26;
                    }
                    case 15: {
                        asyncOperation.result = ((Query)asyncOperation.parameter).forCurrentThread().list();
                        break block26;
                    }
                    case 14: {
                        this.executeTransactionCallable(asyncOperation);
                        break block26;
                    }
                    case 13: {
                        this.executeTransactionRunnable(asyncOperation);
                        break block26;
                    }
                    case 12: {
                        asyncOperation.dao.updateInTx((Object[])asyncOperation.parameter);
                        break block26;
                    }
                    case 11: {
                        asyncOperation.dao.updateInTx((Iterable)asyncOperation.parameter);
                        break block26;
                    }
                    case 10: {
                        asyncOperation.dao.update(asyncOperation.parameter);
                        break block26;
                    }
                    case 9: {
                        asyncOperation.dao.insertOrReplaceInTx((Object[])asyncOperation.parameter);
                        break block26;
                    }
                    case 8: {
                        asyncOperation.dao.insertOrReplaceInTx((Iterable)asyncOperation.parameter);
                        break block26;
                    }
                    case 7: {
                        asyncOperation.dao.insertOrReplace(asyncOperation.parameter);
                        break block26;
                    }
                    case 6: {
                        asyncOperation.dao.insertInTx((Object[])asyncOperation.parameter);
                        break block26;
                    }
                    case 5: {
                        asyncOperation.dao.insertInTx((Iterable)asyncOperation.parameter);
                        break block26;
                    }
                    case 4: {
                        asyncOperation.dao.insert(asyncOperation.parameter);
                        break block26;
                    }
                    case 3: {
                        asyncOperation.dao.deleteInTx((Object[])asyncOperation.parameter);
                        break block26;
                    }
                    case 2: {
                        asyncOperation.dao.deleteInTx((Iterable)asyncOperation.parameter);
                        break block26;
                    }
                    case 1: {
                        asyncOperation.dao.delete(asyncOperation.parameter);
                        break block26;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported operation: ");
                stringBuilder.append(asyncOperation.type);
                DaoException daoException = new DaoException(stringBuilder.toString());
                throw daoException;
            }
            catch (Throwable throwable) {
                asyncOperation.throwable = throwable;
            }
        }
        asyncOperation.timeCompleted = System.currentTimeMillis();
    }

    private void executeOperationAndPostCompleted(AsyncOperation asyncOperation) {
        this.executeOperation(asyncOperation);
        this.handleOperationCompleted(asyncOperation);
    }

    private void executeTransactionCallable(AsyncOperation asyncOperation) throws Exception {
        Database database = asyncOperation.getDatabase();
        database.beginTransaction();
        try {
            asyncOperation.result = ((Callable)asyncOperation.parameter).call();
            database.setTransactionSuccessful();
            return;
        }
        finally {
            database.endTransaction();
        }
    }

    private void executeTransactionRunnable(AsyncOperation asyncOperation) {
        Database database = asyncOperation.getDatabase();
        database.beginTransaction();
        try {
            ((Runnable)asyncOperation.parameter).run();
            database.setTransactionSuccessful();
            return;
        }
        finally {
            database.endTransaction();
        }
    }

    private void handleOperationCompleted(AsyncOperation asyncOperation) {
        asyncOperation.setCompleted();
        AsyncOperationListener asyncOperationListener = this.listener;
        if (asyncOperationListener != null) {
            asyncOperationListener.onAsyncOperationCompleted(asyncOperation);
        }
        if (this.listenerMainThread != null) {
            if (this.handlerMainThread == null) {
                this.handlerMainThread = new Handler(Looper.getMainLooper(), (Handler.Callback)this);
            }
            asyncOperation = this.handlerMainThread.obtainMessage(1, (Object)asyncOperation);
            this.handlerMainThread.sendMessage((Message)asyncOperation);
        }
        synchronized (this) {
            int n;
            this.countOperationsCompleted = n = this.countOperationsCompleted + 1;
            if (n != this.countOperationsEnqueued) return;
            this.notifyAll();
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private void mergeTxAndExecute(AsyncOperation object, AsyncOperation object2) {
        boolean bl;
        int n;
        boolean bl2;
        ArrayList<Object> arrayList;
        block16: {
            arrayList = new ArrayList<Object>();
            arrayList.add(object);
            arrayList.add(object2);
            object = object.getDatabase();
            object.beginTransaction();
            bl2 = false;
            n = 0;
            while (true) {
                block15: {
                    int n2 = arrayList.size();
                    bl = true;
                    if (n >= n2) break;
                    AsyncOperation asyncOperation = (AsyncOperation)arrayList.get(n);
                    this.executeOperation(asyncOperation);
                    if (asyncOperation.isFailed()) break;
                    if (n == arrayList.size() - 1) {
                        object2 = (AsyncOperation)this.queue.peek();
                        if (n < this.maxOperationCountToMerge && asyncOperation.isMergeableWith((AsyncOperation)object2)) {
                            asyncOperation = (AsyncOperation)this.queue.remove();
                            if (asyncOperation == object2) {
                                arrayList.add(asyncOperation);
                                break block15;
                            } else {
                                object2 = new DaoException("Internal error: peeked op did not match removed op");
                                throw object2;
                            }
                        }
                        object.setTransactionSuccessful();
                        break block16;
                    }
                }
                ++n;
            }
            bl = false;
        }
        try {
            object.endTransaction();
        }
        catch (RuntimeException runtimeException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Async transaction could not be ended, success so far was: ");
            ((StringBuilder)object).append(bl);
            DaoLog.i((String)((StringBuilder)object).toString(), (Throwable)runtimeException);
            bl = bl2;
        }
        if (bl) {
            n = arrayList.size();
            object = arrayList.iterator();
            while (object.hasNext()) {
                object2 = (AsyncOperation)object.next();
                ((AsyncOperation)object2).mergedOperationsCount = n;
                this.handleOperationCompleted((AsyncOperation)object2);
            }
            return;
        }
        DaoLog.i((String)"Reverted merged transaction because one of the operations failed. Executing operations one by one instead...");
        object2 = arrayList.iterator();
        while (object2.hasNext()) {
            object = (AsyncOperation)object2.next();
            object.reset();
            this.executeOperationAndPostCompleted((AsyncOperation)object);
        }
        return;
        catch (Throwable throwable) {
            try {
                object.endTransaction();
                throw throwable;
            }
            catch (RuntimeException runtimeException) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Async transaction could not be ended, success so far was: ");
                ((StringBuilder)object).append(false);
                DaoLog.i((String)((StringBuilder)object).toString(), (Throwable)runtimeException);
                throw throwable;
            }
        }
    }

    public void enqueue(AsyncOperation asyncOperation) {
        synchronized (this) {
            int n;
            this.lastSequenceNumber = n = this.lastSequenceNumber + 1;
            asyncOperation.sequenceNumber = n;
            this.queue.add(asyncOperation);
            ++this.countOperationsEnqueued;
            if (this.executorRunning) return;
            this.executorRunning = true;
            executorService.execute(this);
            return;
        }
    }

    public AsyncOperationListener getListener() {
        return this.listener;
    }

    public AsyncOperationListener getListenerMainThread() {
        return this.listenerMainThread;
    }

    public int getMaxOperationCountToMerge() {
        return this.maxOperationCountToMerge;
    }

    public int getWaitForMergeMillis() {
        return this.waitForMergeMillis;
    }

    public boolean handleMessage(Message message) {
        AsyncOperationListener asyncOperationListener = this.listenerMainThread;
        if (asyncOperationListener == null) return false;
        asyncOperationListener.onAsyncOperationCompleted((AsyncOperation)message.obj);
        return false;
    }

    public boolean isCompleted() {
        synchronized (this) {
            int n = this.countOperationsEnqueued;
            int n2 = this.countOperationsCompleted;
            boolean bl = n == n2;
            return bl;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        Throwable throwable2;
        while (true) {
            StringBuilder stringBuilder;
            AsyncOperation asyncOperation;
            block12: {
                try {
                    asyncOperation = this.queue.poll(1L, TimeUnit.SECONDS);
                    stringBuilder = asyncOperation;
                    if (asyncOperation != null) break block12;
                    synchronized (this) {
                    }
                }
                catch (Throwable throwable2) {
                    break;
                }
                catch (InterruptedException interruptedException) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(Thread.currentThread().getName());
                    stringBuilder.append(" was interruppted");
                    DaoLog.w((String)stringBuilder.toString(), (Throwable)interruptedException);
                    this.executorRunning = false;
                    return;
                }
                {
                    stringBuilder = (AsyncOperation)this.queue.poll();
                    if (stringBuilder == null) {
                        this.executorRunning = false;
                        // MONITOREXIT @DISABLED, blocks:[5, 8, 11] lbl23 : MonitorExitStatement: MONITOREXIT : this
                        this.executorRunning = false;
                        return;
                    }
                }
            }
            if (stringBuilder.isMergeTx() && (asyncOperation = this.queue.poll(this.waitForMergeMillis, TimeUnit.MILLISECONDS)) != null) {
                if (stringBuilder.isMergeableWith(asyncOperation)) {
                    this.mergeTxAndExecute((AsyncOperation)stringBuilder, asyncOperation);
                    continue;
                }
                this.executeOperationAndPostCompleted((AsyncOperation)stringBuilder);
                this.executeOperationAndPostCompleted(asyncOperation);
                continue;
            }
            this.executeOperationAndPostCompleted((AsyncOperation)stringBuilder);
        }
        this.executorRunning = false;
        throw throwable2;
    }

    public void setListener(AsyncOperationListener asyncOperationListener) {
        this.listener = asyncOperationListener;
    }

    public void setListenerMainThread(AsyncOperationListener asyncOperationListener) {
        this.listenerMainThread = asyncOperationListener;
    }

    public void setMaxOperationCountToMerge(int n) {
        this.maxOperationCountToMerge = n;
    }

    public void setWaitForMergeMillis(int n) {
        this.waitForMergeMillis = n;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void waitForCompletion() {
        // MONITORENTER : this
        while (true) lbl-1000:
        // 2 sources

        {
            if (var1_1 = this.isCompleted()) {
                // MONITOREXIT : this
                return;
            }
            try {
                this.wait();
                continue;
            }
            catch (InterruptedException var2_2) {
                var3_4 = new DaoException("Interrupted while waiting for all operations to complete", (Throwable)var2_2);
                throw var3_4;
            }
            break;
        }
        {
            ** while (true)
        }
    }

    public boolean waitForCompletion(int n) {
        synchronized (this) {
            boolean bl = this.isCompleted();
            if (!bl) {
                long l = n;
                try {
                    this.wait(l);
                }
                catch (InterruptedException interruptedException) {
                    DaoException daoException = new DaoException("Interrupted while waiting for all operations to complete", (Throwable)interruptedException);
                    throw daoException;
                }
            }
            bl = this.isCompleted();
            return bl;
        }
    }
}
