/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AppendOnlyLinkedArrayList
 *  io.reactivex.internal.util.AppendOnlyLinkedArrayList$NonThrowingPredicate
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.processors.BehaviorProcessor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.processors;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.BehaviorProcessor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class BehaviorProcessor.BehaviorSubscription<T>
extends AtomicLong
implements Subscription,
AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
    private static final long serialVersionUID = 3293175281126227086L;
    volatile boolean cancelled;
    final Subscriber<? super T> downstream;
    boolean emitting;
    boolean fastPath;
    long index;
    boolean next;
    AppendOnlyLinkedArrayList<Object> queue;
    final BehaviorProcessor<T> state;

    BehaviorProcessor.BehaviorSubscription(Subscriber<? super T> subscriber, BehaviorProcessor<T> behaviorProcessor) {
        this.downstream = subscriber;
        this.state = behaviorProcessor;
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.state.remove(this);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void emitFirst() {
        Object object;
        if (this.cancelled) {
            return;
        }
        synchronized (this) {
            if (this.cancelled) {
                return;
            }
            if (this.next) {
                return;
            }
            object = this.state;
            Lock lock = object.readLock;
            lock.lock();
            this.index = object.index;
            object = object.value.get();
            lock.unlock();
            boolean bl = object != null;
            this.emitting = bl;
            this.next = true;
        }
        if (object == null) return;
        if (this.test(object)) {
            return;
        }
        this.emitLoop();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    void emitLoop() {
        while (!this.cancelled) {
            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
            synchronized (this) {
                appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
                {
                    catch (Throwable throwable) {}
                    {
                        throw throwable;
                    }
                }
            }
            appendOnlyLinkedArrayList.forEachWhile((AppendOnlyLinkedArrayList.NonThrowingPredicate)this);
        }
        return;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void emitNext(Object object, long l) {
        if (this.cancelled) {
            return;
        }
        if (!this.fastPath) {
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.index == l) {
                    return;
                }
                if (this.emitting) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList = this.queue;
                    if (appendOnlyLinkedArrayList == null) {
                        this.queue = appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList(4);
                    }
                    appendOnlyLinkedArrayList2.add(object);
                    return;
                }
                this.next = true;
            }
            this.fastPath = true;
        }
        this.test(object);
    }

    public boolean isFull() {
        boolean bl = this.get() == 0L;
        return bl;
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this, (long)l);
    }

    public boolean test(Object object) {
        if (this.cancelled) {
            return true;
        }
        if (NotificationLite.isComplete((Object)object)) {
            this.downstream.onComplete();
            return true;
        }
        if (NotificationLite.isError((Object)object)) {
            this.downstream.onError(NotificationLite.getError((Object)object));
            return true;
        }
        long l = this.get();
        if (l != 0L) {
            this.downstream.onNext(NotificationLite.getValue((Object)object));
            if (l == Long.MAX_VALUE) return false;
            this.decrementAndGet();
            return false;
        }
        this.cancel();
        this.downstream.onError((Throwable)new MissingBackpressureException("Could not deliver value due to lack of requests"));
        return true;
    }
}
