/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription
 *  io.reactivex.internal.operators.flowable.FlowableReplay$Node
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.NotificationLite
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

static class FlowableReplay.BoundedReplayBuffer<T>
extends AtomicReference<FlowableReplay.Node>
implements FlowableReplay.ReplayBuffer<T> {
    private static final long serialVersionUID = 2346567790059478686L;
    long index;
    int size;
    FlowableReplay.Node tail;

    FlowableReplay.BoundedReplayBuffer() {
        FlowableReplay.Node node;
        this.tail = node = new FlowableReplay.Node(null, 0L);
        this.set(node);
    }

    final void addLast(FlowableReplay.Node node) {
        this.tail.set((Object)node);
        this.tail = node;
        ++this.size;
    }

    final void collect(Collection<? super T> collection) {
        FlowableReplay.Node node = this.getHead();
        while ((node = (FlowableReplay.Node)node.get()) != null) {
            Object object = this.leaveTransform(node.value);
            if (NotificationLite.isComplete((Object)object)) return;
            if (NotificationLite.isError((Object)object)) {
                return;
            }
            collection.add(NotificationLite.getValue((Object)object));
        }
    }

    public final void complete() {
        long l;
        Object object = this.enterTransform(NotificationLite.complete());
        this.index = l = this.index + 1L;
        this.addLast(new FlowableReplay.Node(object, l));
        this.truncateFinal();
    }

    Object enterTransform(Object object) {
        return object;
    }

    public final void error(Throwable object) {
        long l;
        object = this.enterTransform(NotificationLite.error((Throwable)object));
        this.index = l = this.index + 1L;
        this.addLast(new FlowableReplay.Node(object, l));
        this.truncateFinal();
    }

    FlowableReplay.Node getHead() {
        return (FlowableReplay.Node)this.get();
    }

    boolean hasCompleted() {
        boolean bl = this.tail.value != null && NotificationLite.isComplete((Object)this.leaveTransform(this.tail.value));
        return bl;
    }

    boolean hasError() {
        boolean bl = this.tail.value != null && NotificationLite.isError((Object)this.leaveTransform(this.tail.value));
        return bl;
    }

    Object leaveTransform(Object object) {
        return object;
    }

    public final void next(T object) {
        long l;
        object = this.enterTransform(NotificationLite.next(object));
        this.index = l = this.index + 1L;
        this.addLast(new FlowableReplay.Node(object, l));
        this.truncate();
    }

    final void removeFirst() {
        FlowableReplay.Node node = (FlowableReplay.Node)((FlowableReplay.Node)this.get()).get();
        if (node == null) throw new IllegalStateException("Empty list!");
        --this.size;
        this.setFirst(node);
    }

    final void removeSome(int n) {
        FlowableReplay.Node node = (FlowableReplay.Node)this.get();
        while (true) {
            if (n <= 0) {
                this.setFirst(node);
                return;
            }
            node = (FlowableReplay.Node)node.get();
            --n;
            --this.size;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final void replay(FlowableReplay.InnerSubscription<T> innerSubscription) {
        synchronized (innerSubscription) {
            if (innerSubscription.emitting) {
                innerSubscription.missed = true;
                return;
            }
            innerSubscription.emitting = true;
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        while (true) {
            FlowableReplay.Node node;
            if (innerSubscription.isDisposed()) {
                innerSubscription.index = null;
                return;
            }
            long l = innerSubscription.get();
            boolean bl = l == Long.MAX_VALUE;
            Object object = node = (FlowableReplay.Node)innerSubscription.index();
            if (node == null) {
                object = this.getHead();
                innerSubscription.index = object;
                BackpressureHelper.add((AtomicLong)innerSubscription.totalRequested, (long)object.index);
            }
            long l2 = 0L;
            while (l != 0L && (node = (FlowableReplay.Node)object.get()) != null) {
                object = this.leaveTransform(node.value);
                try {
                    if (NotificationLite.accept((Object)object, (Subscriber)innerSubscription.child)) {
                        innerSubscription.index = null;
                        return;
                    }
                    ++l2;
                    --l;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    innerSubscription.index = null;
                    innerSubscription.dispose();
                    if (NotificationLite.isError((Object)object)) return;
                    if (NotificationLite.isComplete((Object)object)) return;
                    innerSubscription.child.onError(throwable);
                    return;
                }
                if (innerSubscription.isDisposed()) {
                    innerSubscription.index = null;
                    return;
                }
                object = node;
            }
            if (l2 != 0L) {
                innerSubscription.index = object;
                if (!bl) {
                    innerSubscription.produced(l2);
                }
            }
            synchronized (innerSubscription) {
                if (!innerSubscription.missed) {
                    innerSubscription.emitting = false;
                    return;
                }
                innerSubscription.missed = false;
            }
        }
    }

    final void setFirst(FlowableReplay.Node node) {
        this.set(node);
    }

    final void trimHead() {
        FlowableReplay.Node node = (FlowableReplay.Node)this.get();
        if (node.value == null) return;
        FlowableReplay.Node node2 = new FlowableReplay.Node(null, 0L);
        node2.lazySet(node.get());
        this.set(node2);
    }

    void truncate() {
    }

    void truncateFinal() {
        this.trimHead();
    }
}
