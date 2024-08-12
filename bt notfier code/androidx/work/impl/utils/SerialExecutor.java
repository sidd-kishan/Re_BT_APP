/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.SerialExecutor$Task
 */
package androidx.work.impl.utils;

import androidx.work.impl.utils.SerialExecutor;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class SerialExecutor
implements Executor {
    private volatile Runnable mActive;
    private final Executor mExecutor;
    private final Object mLock;
    private final ArrayDeque<Task> mTasks;

    public SerialExecutor(Executor executor) {
        this.mExecutor = executor;
        this.mTasks = new ArrayDeque();
        this.mLock = new Object();
    }

    @Override
    public void execute(Runnable runnable) {
        Object object = this.mLock;
        synchronized (object) {
            ArrayDeque<Task> arrayDeque = this.mTasks;
            Task task = new Task(this, runnable);
            arrayDeque.add(task);
            if (this.mActive != null) return;
            this.scheduleNext();
            return;
        }
    }

    public Executor getDelegatedExecutor() {
        return this.mExecutor;
    }

    public boolean hasPendingTasks() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl = !this.mTasks.isEmpty();
            return bl;
        }
    }

    void scheduleNext() {
        Object object = this.mLock;
        synchronized (object) {
            Runnable runnable;
            this.mActive = runnable = (Runnable)this.mTasks.poll();
            if (runnable == null) return;
            this.mExecutor.execute(this.mActive);
            return;
        }
    }
}
