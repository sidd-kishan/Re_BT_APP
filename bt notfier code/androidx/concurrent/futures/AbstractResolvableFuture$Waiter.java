/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.AbstractResolvableFuture
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.locks.LockSupport;

private static final class AbstractResolvableFuture.Waiter {
    static final AbstractResolvableFuture.Waiter TOMBSTONE = new AbstractResolvableFuture.Waiter(false);
    volatile AbstractResolvableFuture.Waiter next;
    volatile Thread thread;

    AbstractResolvableFuture.Waiter() {
        AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
    }

    AbstractResolvableFuture.Waiter(boolean bl) {
    }

    void setNext(AbstractResolvableFuture.Waiter waiter) {
        AbstractResolvableFuture.ATOMIC_HELPER.putNext(this, waiter);
    }

    void unpark() {
        Thread thread = this.thread;
        if (thread == null) return;
        this.thread = null;
        LockSupport.unpark(thread);
    }
}
