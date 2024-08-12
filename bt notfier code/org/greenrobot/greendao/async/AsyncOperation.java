/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.async.AsyncDaoException
 *  org.greenrobot.greendao.async.AsyncOperation$OperationType
 *  org.greenrobot.greendao.database.Database
 */
package org.greenrobot.greendao.async;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.async.AsyncDaoException;
import org.greenrobot.greendao.async.AsyncOperation;
import org.greenrobot.greendao.database.Database;

public class AsyncOperation {
    public static final int FLAG_MERGE_TX = 1;
    public static final int FLAG_STOP_QUEUE_ON_EXCEPTION = 2;
    public static final int FLAG_TRACK_CREATOR_STACKTRACE = 4;
    private volatile boolean completed;
    final Exception creatorStacktrace;
    final AbstractDao<Object, Object> dao;
    private final Database database;
    final int flags;
    volatile int mergedOperationsCount;
    final Object parameter;
    volatile Object result;
    int sequenceNumber;
    volatile Throwable throwable;
    volatile long timeCompleted;
    volatile long timeStarted;
    final OperationType type;

    AsyncOperation(OperationType object, AbstractDao<?, ?> abstractDao, Database database, Object object2, int n) {
        this.type = object;
        this.flags = n;
        this.dao = abstractDao;
        this.database = database;
        this.parameter = object2;
        object = (n & 4) != 0 ? new Exception("AsyncOperation was created here") : null;
        this.creatorStacktrace = object;
    }

    public Exception getCreatorStacktrace() {
        return this.creatorStacktrace;
    }

    Database getDatabase() {
        Database database = this.database;
        if (database != null) return database;
        database = this.dao.getDatabase();
        return database;
    }

    public long getDuration() {
        if (this.timeCompleted == 0L) throw new DaoException("This operation did not yet complete");
        return this.timeCompleted - this.timeStarted;
    }

    public int getMergedOperationsCount() {
        return this.mergedOperationsCount;
    }

    public Object getParameter() {
        return this.parameter;
    }

    public Object getResult() {
        synchronized (this) {
            if (!this.completed) {
                this.waitForCompletion();
            }
            if (this.throwable == null) {
                Object object = this.result;
                return object;
            }
            AsyncDaoException asyncDaoException = new AsyncDaoException(this, this.throwable);
            throw asyncDaoException;
        }
    }

    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public long getTimeCompleted() {
        return this.timeCompleted;
    }

    public long getTimeStarted() {
        return this.timeStarted;
    }

    public OperationType getType() {
        return this.type;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public boolean isCompletedSucessfully() {
        boolean bl = this.completed && this.throwable == null;
        return bl;
    }

    public boolean isFailed() {
        boolean bl = this.throwable != null;
        return bl;
    }

    public boolean isMergeTx() {
        int n = this.flags;
        boolean bl = true;
        if ((n & 1) != 0) return bl;
        bl = false;
        return bl;
    }

    boolean isMergeableWith(AsyncOperation asyncOperation) {
        boolean bl = asyncOperation != null && this.isMergeTx() && asyncOperation.isMergeTx() && this.getDatabase() == asyncOperation.getDatabase();
        return bl;
    }

    void reset() {
        this.timeStarted = 0L;
        this.timeCompleted = 0L;
        this.completed = false;
        this.throwable = null;
        this.result = null;
        this.mergedOperationsCount = 0;
    }

    void setCompleted() {
        synchronized (this) {
            this.completed = true;
            this.notifyAll();
            return;
        }
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    /*
     * Unable to fully structure code
     */
    public Object waitForCompletion() {
        synchronized (this) {
            try {
                while (true) lbl-1000:
                // 2 sources

                {
                    if (var1_1 = this.completed) {
                        var2_3 = this.result;
                        return var2_3;
                    }
                    try {
                        this.wait();
                        continue;
                    }
                    catch (InterruptedException var2_2) {
                        var3_5 = new DaoException("Interrupted while waiting for operation to complete", (Throwable)var2_2);
                        throw var3_5;
                    }
                    break;
                }
            }
            catch (Throwable var2_4) {}
            {
                throw var2_4;
            }
            {
                ** while (true)
            }
        }
    }

    public boolean waitForCompletion(int n) {
        synchronized (this) {
            boolean bl = this.completed;
            if (!bl) {
                long l = n;
                try {
                    this.wait(l);
                }
                catch (InterruptedException interruptedException) {
                    DaoException daoException = new DaoException("Interrupted while waiting for operation to complete", (Throwable)interruptedException);
                    throw daoException;
                }
            }
            bl = this.completed;
            return bl;
        }
    }
}
