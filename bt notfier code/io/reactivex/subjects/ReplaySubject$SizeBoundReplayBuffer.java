/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.subjects.ReplaySubject$Node
 *  io.reactivex.subjects.ReplaySubject$ReplayBuffer
 *  io.reactivex.subjects.ReplaySubject$ReplayDisposable
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.ReplaySubject;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;

static final class ReplaySubject.SizeBoundReplayBuffer<T>
extends AtomicReference<Object>
implements ReplaySubject.ReplayBuffer<T> {
    private static final long serialVersionUID = 1107649250281456395L;
    volatile boolean done;
    volatile ReplaySubject.Node<Object> head;
    final int maxSize;
    int size;
    ReplaySubject.Node<Object> tail;

    ReplaySubject.SizeBoundReplayBuffer(int n) {
        ReplaySubject.Node node;
        this.maxSize = ObjectHelper.verifyPositive((int)n, (String)"maxSize");
        this.tail = node = new ReplaySubject.Node(null);
        this.head = node;
    }

    public void add(T object) {
        object = new ReplaySubject.Node(object);
        ReplaySubject.Node<Object> node = this.tail;
        this.tail = object;
        ++this.size;
        node.set(object);
        this.trim();
    }

    public void addFinal(Object object) {
        object = new ReplaySubject.Node(object);
        ReplaySubject.Node<Object> node = this.tail;
        this.tail = object;
        ++this.size;
        node.lazySet(object);
        this.trimHead();
        this.done = true;
    }

    public T getValue() {
        Object object = this.head;
        ReplaySubject.Node<Object> node = null;
        while (true) {
            ReplaySubject.Node node2;
            if ((node2 = (ReplaySubject.Node)object.get()) == null) {
                object = object.value;
                if (object != null) break;
                return null;
            }
            node = object;
            object = node2;
        }
        if (NotificationLite.isComplete((Object)object)) return (T)node.value;
        if (!NotificationLite.isError((Object)object)) return (T)object;
        return (T)node.value;
    }

    public T[] getValues(T[] node) {
        ReplaySubject.Node node2;
        ReplaySubject.Node node3 = this.head;
        int n = this.size();
        int n2 = 0;
        if (n == 0) {
            node2 = node;
            if (((ReplaySubject.Node<Object>)node).length == 0) return node2;
            node[0] = null;
            node2 = node;
        } else {
            node2 = node3;
            int n3 = n2;
            ReplaySubject.Node node4 = node;
            if (((ReplaySubject.Node<Object>)node).length < n) {
                node4 = (ReplaySubject.Node)Array.newInstance(node.getClass().getComponentType(), n);
                n3 = n2;
                node2 = node3;
            }
            while (n3 != n) {
                node2 = (ReplaySubject.Node)node2.get();
                node4[n3] = node2.value;
                ++n3;
            }
            node2 = node4;
            if (((ReplaySubject.Node)node4).length <= n) return node2;
            node4[n] = null;
            node2 = node4;
        }
        return node2;
    }

    public void replay(ReplaySubject.ReplayDisposable<T> replayDisposable) {
        ReplaySubject.Node node;
        if (replayDisposable.getAndIncrement() != 0) {
            return;
        }
        Observer observer = replayDisposable.downstream;
        Object object = node = (ReplaySubject.Node)replayDisposable.index;
        if (node == null) {
            object = this.head;
        }
        int n = 1;
        while (true) {
            if (replayDisposable.cancelled) {
                replayDisposable.index = null;
                return;
            }
            node = (ReplaySubject.Node)object.get();
            if (node == null) {
                int n2;
                if (object.get() != null) continue;
                replayDisposable.index = object;
                n = n2 = replayDisposable.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            object = node.value;
            if (this.done && node.get() == null) {
                if (NotificationLite.isComplete((Object)object)) {
                    observer.onComplete();
                } else {
                    observer.onError(NotificationLite.getError((Object)object));
                }
                replayDisposable.index = null;
                replayDisposable.cancelled = true;
                return;
            }
            observer.onNext(object);
            object = node;
        }
    }

    public int size() {
        Object object = this.head;
        int n = 0;
        while (true) {
            int n2 = ++n;
            if (n == Integer.MAX_VALUE) return n2;
            ReplaySubject.Node node = (ReplaySubject.Node)object.get();
            if (node == null) {
                object = object.value;
                if (!NotificationLite.isComplete((Object)object)) {
                    n2 = n;
                    if (!NotificationLite.isError((Object)object)) return n2;
                }
                n2 = n - 1;
                return n2;
            }
            object = node;
        }
    }

    void trim() {
        int n = this.size;
        if (n <= this.maxSize) return;
        this.size = n - 1;
        this.head = (ReplaySubject.Node)this.head.get();
    }

    public void trimHead() {
        ReplaySubject.Node<Object> node = this.head;
        if (node.value == null) return;
        ReplaySubject.Node node2 = new ReplaySubject.Node(null);
        node2.lazySet(node.get());
        this.head = node2;
    }
}
