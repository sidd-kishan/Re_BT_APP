/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.futures.AbstractFuture
 *  androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper
 *  androidx.work.impl.utils.futures.AbstractFuture$Listener
 *  androidx.work.impl.utils.futures.AbstractFuture$Waiter
 */
package androidx.work.impl.utils.futures;

import androidx.work.impl.utils.futures.AbstractFuture;

private static final class AbstractFuture.SynchronizedHelper
extends AbstractFuture.AtomicHelper {
    AbstractFuture.SynchronizedHelper() {
        super(null);
    }

    boolean casListeners(AbstractFuture<?> abstractFuture, AbstractFuture.Listener listener, AbstractFuture.Listener listener2) {
        synchronized (abstractFuture) {
            if (abstractFuture.listeners != listener) return false;
            abstractFuture.listeners = listener2;
            return true;
        }
    }

    boolean casValue(AbstractFuture<?> abstractFuture, Object object, Object object2) {
        synchronized (abstractFuture) {
            if (abstractFuture.value != object) return false;
            abstractFuture.value = object2;
            return true;
        }
    }

    boolean casWaiters(AbstractFuture<?> abstractFuture, AbstractFuture.Waiter waiter, AbstractFuture.Waiter waiter2) {
        synchronized (abstractFuture) {
            if (abstractFuture.waiters != waiter) return false;
            abstractFuture.waiters = waiter2;
            return true;
        }
    }

    void putNext(AbstractFuture.Waiter waiter, AbstractFuture.Waiter waiter2) {
        waiter.next = waiter2;
    }

    void putThread(AbstractFuture.Waiter waiter, Thread thread) {
        waiter.thread = thread;
    }
}
