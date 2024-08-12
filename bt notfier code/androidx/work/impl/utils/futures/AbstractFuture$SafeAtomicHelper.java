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
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

private static final class AbstractFuture.SafeAtomicHelper
extends AbstractFuture.AtomicHelper {
    final AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Listener> listenersUpdater;
    final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
    final AtomicReferenceFieldUpdater<AbstractFuture.Waiter, AbstractFuture.Waiter> waiterNextUpdater;
    final AtomicReferenceFieldUpdater<AbstractFuture.Waiter, Thread> waiterThreadUpdater;
    final AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Waiter> waitersUpdater;

    AbstractFuture.SafeAtomicHelper(AtomicReferenceFieldUpdater<AbstractFuture.Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<AbstractFuture.Waiter, AbstractFuture.Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
        super(null);
        this.waiterThreadUpdater = atomicReferenceFieldUpdater;
        this.waiterNextUpdater = atomicReferenceFieldUpdater2;
        this.waitersUpdater = atomicReferenceFieldUpdater3;
        this.listenersUpdater = atomicReferenceFieldUpdater4;
        this.valueUpdater = atomicReferenceFieldUpdater5;
    }

    boolean casListeners(AbstractFuture<?> abstractFuture, AbstractFuture.Listener listener, AbstractFuture.Listener listener2) {
        return this.listenersUpdater.compareAndSet(abstractFuture, listener, listener2);
    }

    boolean casValue(AbstractFuture<?> abstractFuture, Object object, Object object2) {
        return this.valueUpdater.compareAndSet(abstractFuture, object, object2);
    }

    boolean casWaiters(AbstractFuture<?> abstractFuture, AbstractFuture.Waiter waiter, AbstractFuture.Waiter waiter2) {
        return this.waitersUpdater.compareAndSet(abstractFuture, waiter, waiter2);
    }

    void putNext(AbstractFuture.Waiter waiter, AbstractFuture.Waiter waiter2) {
        this.waiterNextUpdater.lazySet(waiter, waiter2);
    }

    void putThread(AbstractFuture.Waiter waiter, Thread thread) {
        this.waiterThreadUpdater.lazySet(waiter, thread);
    }
}
