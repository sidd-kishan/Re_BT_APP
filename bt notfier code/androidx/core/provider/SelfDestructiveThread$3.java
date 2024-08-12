/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.provider.SelfDestructiveThread
 */
package androidx.core.provider;

import androidx.core.provider.SelfDestructiveThread;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class SelfDestructiveThread.3
implements Runnable {
    final SelfDestructiveThread this$0;
    final Callable val$callable;
    final Condition val$cond;
    final AtomicReference val$holder;
    final ReentrantLock val$lock;
    final AtomicBoolean val$running;

    SelfDestructiveThread.3(SelfDestructiveThread selfDestructiveThread, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
        this.this$0 = selfDestructiveThread;
        this.val$holder = atomicReference;
        this.val$callable = callable;
        this.val$lock = reentrantLock;
        this.val$running = atomicBoolean;
        this.val$cond = condition;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void run() {
        try {
            this.val$holder.set(this.val$callable.call());
lbl3:
            // 2 sources

            while (true) {
                this.val$lock.lock();
                break;
            }
        }
        catch (Exception var1_1) {
            ** continue;
        }
        try {
            this.val$running.set(false);
            this.val$cond.signal();
            return;
        }
        finally {
            this.val$lock.unlock();
        }
    }
}
