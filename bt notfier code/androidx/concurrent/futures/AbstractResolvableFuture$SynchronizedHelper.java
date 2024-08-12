/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.AbstractResolvableFuture
 *  androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
 *  androidx.concurrent.futures.AbstractResolvableFuture$Listener
 *  androidx.concurrent.futures.AbstractResolvableFuture$Waiter
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;

private static final class AbstractResolvableFuture.SynchronizedHelper
extends AbstractResolvableFuture.AtomicHelper {
    AbstractResolvableFuture.SynchronizedHelper() {
        super(null);
    }

    boolean casListeners(AbstractResolvableFuture<?> abstractResolvableFuture, AbstractResolvableFuture.Listener listener, AbstractResolvableFuture.Listener listener2) {
        synchronized (abstractResolvableFuture) {
            if (abstractResolvableFuture.listeners != listener) return false;
            abstractResolvableFuture.listeners = listener2;
            return true;
        }
    }

    boolean casValue(AbstractResolvableFuture<?> abstractResolvableFuture, Object object, Object object2) {
        synchronized (abstractResolvableFuture) {
            if (abstractResolvableFuture.value != object) return false;
            abstractResolvableFuture.value = object2;
            return true;
        }
    }

    boolean casWaiters(AbstractResolvableFuture<?> abstractResolvableFuture, AbstractResolvableFuture.Waiter waiter, AbstractResolvableFuture.Waiter waiter2) {
        synchronized (abstractResolvableFuture) {
            if (abstractResolvableFuture.waiters != waiter) return false;
            abstractResolvableFuture.waiters = waiter2;
            return true;
        }
    }

    void putNext(AbstractResolvableFuture.Waiter waiter, AbstractResolvableFuture.Waiter waiter2) {
        waiter.next = waiter2;
    }

    void putThread(AbstractResolvableFuture.Waiter waiter, Thread thread) {
        waiter.thread = thread;
    }
}
