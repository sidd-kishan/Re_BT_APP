/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable
 *  io.reactivex.internal.operators.observable.ObservableReplay$Node
 *  io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer
 *  io.reactivex.internal.util.NotificationLite
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

static abstract class ObservableReplay.BoundedReplayBuffer<T>
extends AtomicReference<ObservableReplay.Node>
implements ObservableReplay.ReplayBuffer<T> {
    private static final long serialVersionUID = 2346567790059478686L;
    int size;
    ObservableReplay.Node tail;

    ObservableReplay.BoundedReplayBuffer() {
        ObservableReplay.Node node;
        this.tail = node = new ObservableReplay.Node(null);
        this.set(node);
    }

    final void addLast(ObservableReplay.Node node) {
        this.tail.set((Object)node);
        this.tail = node;
        ++this.size;
    }

    final void collect(Collection<? super T> collection) {
        ObservableReplay.Node node = this.getHead();
        while ((node = (ObservableReplay.Node)node.get()) != null) {
            Object object = this.leaveTransform(node.value);
            if (NotificationLite.isComplete((Object)object)) return;
            if (NotificationLite.isError((Object)object)) {
                return;
            }
            collection.add(NotificationLite.getValue((Object)object));
        }
    }

    public final void complete() {
        this.addLast(new ObservableReplay.Node(this.enterTransform(NotificationLite.complete())));
        this.truncateFinal();
    }

    Object enterTransform(Object object) {
        return object;
    }

    public final void error(Throwable throwable) {
        this.addLast(new ObservableReplay.Node(this.enterTransform(NotificationLite.error((Throwable)throwable))));
        this.truncateFinal();
    }

    ObservableReplay.Node getHead() {
        return (ObservableReplay.Node)this.get();
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

    public final void next(T t) {
        this.addLast(new ObservableReplay.Node(this.enterTransform(NotificationLite.next(t))));
        this.truncate();
    }

    final void removeFirst() {
        ObservableReplay.Node node = (ObservableReplay.Node)((ObservableReplay.Node)this.get()).get();
        --this.size;
        this.setFirst(node);
    }

    final void removeSome(int n) {
        ObservableReplay.Node node = (ObservableReplay.Node)this.get();
        while (true) {
            if (n <= 0) {
                this.setFirst(node);
                return;
            }
            node = (ObservableReplay.Node)node.get();
            --n;
            --this.size;
        }
    }

    public final void replay(ObservableReplay.InnerDisposable<T> innerDisposable) {
        int n;
        if (innerDisposable.getAndIncrement() != 0) {
            return;
        }
        int n2 = 1;
        do {
            ObservableReplay.Node node;
            ObservableReplay.Node node2 = node = (ObservableReplay.Node)innerDisposable.index();
            if (node == null) {
                node2 = this.getHead();
                innerDisposable.index = node2;
            }
            while (true) {
                if (innerDisposable.isDisposed()) {
                    innerDisposable.index = null;
                    return;
                }
                node = (ObservableReplay.Node)node2.get();
                if (node == null) break;
                if (NotificationLite.accept((Object)this.leaveTransform(node.value), (Observer)innerDisposable.child)) {
                    innerDisposable.index = null;
                    return;
                }
                node2 = node;
            }
            innerDisposable.index = node2;
            n2 = n = innerDisposable.addAndGet(-n2);
        } while (n != 0);
    }

    final void setFirst(ObservableReplay.Node node) {
        this.set(node);
    }

    final void trimHead() {
        ObservableReplay.Node node = (ObservableReplay.Node)this.get();
        if (node.value == null) return;
        ObservableReplay.Node node2 = new ObservableReplay.Node(null);
        node2.lazySet(node.get());
        this.set(node2);
    }

    abstract void truncate();

    void truncateFinal() {
        this.trimHead();
    }
}
