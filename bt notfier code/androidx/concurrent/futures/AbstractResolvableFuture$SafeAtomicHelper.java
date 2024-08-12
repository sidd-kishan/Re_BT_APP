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
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

private static final class AbstractResolvableFuture.SafeAtomicHelper
extends AbstractResolvableFuture.AtomicHelper {
    final AtomicReferenceFieldUpdater<AbstractResolvableFuture, AbstractResolvableFuture.Listener> listenersUpdater;
    final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> valueUpdater;
    final AtomicReferenceFieldUpdater<AbstractResolvableFuture.Waiter, AbstractResolvableFuture.Waiter> waiterNextUpdater;
    final AtomicReferenceFieldUpdater<AbstractResolvableFuture.Waiter, Thread> waiterThreadUpdater;
    final AtomicReferenceFieldUpdater<AbstractResolvableFuture, AbstractResolvableFuture.Waiter> waitersUpdater;

    AbstractResolvableFuture.SafeAtomicHelper(AtomicReferenceFieldUpdater<AbstractResolvableFuture.Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<AbstractResolvableFuture.Waiter, AbstractResolvableFuture.Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, AbstractResolvableFuture.Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, AbstractResolvableFuture.Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
        super(null);
        this.waiterThreadUpdater = atomicReferenceFieldUpdater;
        this.waiterNextUpdater = atomicReferenceFieldUpdater2;
        this.waitersUpdater = atomicReferenceFieldUpdater3;
        this.listenersUpdater = atomicReferenceFieldUpdater4;
        this.valueUpdater = atomicReferenceFieldUpdater5;
    }

    boolean casListeners(AbstractResolvableFuture<?> abstractResolvableFuture, AbstractResolvableFuture.Listener listener, AbstractResolvableFuture.Listener listener2) {
        return this.listenersUpdater.compareAndSet(abstractResolvableFuture, listener, listener2);
    }

    boolean casValue(AbstractResolvableFuture<?> abstractResolvableFuture, Object object, Object object2) {
        return this.valueUpdater.compareAndSet(abstractResolvableFuture, object, object2);
    }

    boolean casWaiters(AbstractResolvableFuture<?> abstractResolvableFuture, AbstractResolvableFuture.Waiter waiter, AbstractResolvableFuture.Waiter waiter2) {
        return this.waitersUpdater.compareAndSet(abstractResolvableFuture, waiter, waiter2);
    }

    void putNext(AbstractResolvableFuture.Waiter waiter, AbstractResolvableFuture.Waiter waiter2) {
        this.waiterNextUpdater.lazySet(waiter, waiter2);
    }

    void putThread(AbstractResolvableFuture.Waiter waiter, Thread thread) {
        this.waiterThreadUpdater.lazySet(waiter, thread);
    }
}
