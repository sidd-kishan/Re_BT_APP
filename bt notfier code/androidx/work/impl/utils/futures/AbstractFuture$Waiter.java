/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.futures.AbstractFuture
 */
package androidx.work.impl.utils.futures;

import androidx.work.impl.utils.futures.AbstractFuture;
import java.util.concurrent.locks.LockSupport;

private static final class AbstractFuture.Waiter {
    static final AbstractFuture.Waiter TOMBSTONE = new AbstractFuture.Waiter(false);
    volatile AbstractFuture.Waiter next;
    volatile Thread thread;

    AbstractFuture.Waiter() {
        AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
    }

    AbstractFuture.Waiter(boolean bl) {
    }

    void setNext(AbstractFuture.Waiter waiter) {
        AbstractFuture.ATOMIC_HELPER.putNext(this, waiter);
    }

    void unpark() {
        Thread thread = this.thread;
        if (thread == null) return;
        this.thread = null;
        LockSupport.unpark(thread);
    }
}
