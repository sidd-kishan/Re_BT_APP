/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.processors.ReplayProcessor$Node
 *  io.reactivex.processors.ReplayProcessor$ReplayBuffer
 *  io.reactivex.processors.ReplayProcessor$ReplaySubscription
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.processors;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.processors.ReplayProcessor;
import java.lang.reflect.Array;
import org.reactivestreams.Subscriber;

static final class ReplayProcessor.SizeBoundReplayBuffer<T>
implements ReplayProcessor.ReplayBuffer<T> {
    volatile boolean done;
    Throwable error;
    volatile ReplayProcessor.Node<T> head;
    final int maxSize;
    int size;
    ReplayProcessor.Node<T> tail;

    ReplayProcessor.SizeBoundReplayBuffer(int n) {
        ReplayProcessor.Node node;
        this.maxSize = ObjectHelper.verifyPositive((int)n, (String)"maxSize");
        this.tail = node = new ReplayProcessor.Node(null);
        this.head = node;
    }

    public void complete() {
        this.trimHead();
        this.done = true;
    }

    public void error(Throwable throwable) {
        this.error = throwable;
        this.trimHead();
        this.done = true;
    }

    public Throwable getError() {
        return this.error;
    }

    public T getValue() {
        ReplayProcessor.Node node = this.head;
        ReplayProcessor.Node node2;
        while ((node2 = (ReplayProcessor.Node)node.get()) != null) {
            node = node2;
        }
        return (T)node.value;
    }

    public T[] getValues(T[] node) {
        ReplayProcessor.Node node2 = this.head;
        int n = 0;
        Object object = node2;
        int n2 = 0;
        while (true) {
            if ((object = (ReplayProcessor.Node)object.get()) == null) {
                ReplayProcessor.Node node3 = node2;
                int n3 = n;
                object = node;
                if (((T[])node).length < n2) {
                    object = (Object[])Array.newInstance(node.getClass().getComponentType(), n2);
                    n3 = n;
                    node3 = node2;
                }
                while (true) {
                    if (n3 >= n2) {
                        if (((T[])object).length <= n2) return object;
                        object[n2] = null;
                        return object;
                    }
                    node3 = (ReplayProcessor.Node)node3.get();
                    object[n3] = node3.value;
                    ++n3;
                }
            }
            ++n2;
        }
    }

    public boolean isDone() {
        return this.done;
    }

    public void next(T object) {
        ReplayProcessor.Node node = new ReplayProcessor.Node(object);
        object = this.tail;
        this.tail = node;
        ++this.size;
        object.set((Object)node);
        this.trim();
    }

    public void replay(ReplayProcessor.ReplaySubscription<T> object) {
        int n;
        ReplayProcessor.Node node;
        if (object.getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = object.downstream;
        ReplayProcessor.Node node2 = node = (ReplayProcessor.Node)object.index;
        if (node == null) {
            node2 = this.head;
        }
        long l = object.emitted;
        int n2 = 1;
        do {
            long l2 = object.requested.get();
            while (l != l2) {
                if (object.cancelled) {
                    object.index = null;
                    return;
                }
                boolean bl = this.done;
                node = (ReplayProcessor.Node)node2.get();
                n = node == null ? 1 : 0;
                if (bl && n != 0) {
                    object.index = null;
                    object.cancelled = true;
                    object = this.error;
                    if (object == null) {
                        subscriber.onComplete();
                    } else {
                        subscriber.onError(object);
                    }
                    return;
                }
                if (n != 0) break;
                subscriber.onNext(node.value);
                ++l;
                node2 = node;
            }
            if (l == l2) {
                if (object.cancelled) {
                    object.index = null;
                    return;
                }
                if (this.done && node2.get() == null) {
                    object.index = null;
                    object.cancelled = true;
                    object = this.error;
                    if (object == null) {
                        subscriber.onComplete();
                    } else {
                        subscriber.onError(object);
                    }
                    return;
                }
            }
            object.index = node2;
            object.emitted = l;
            n2 = n = object.addAndGet(-n2);
        } while (n != 0);
    }

    public int size() {
        ReplayProcessor.Node node = this.head;
        int n = 0;
        while (n != Integer.MAX_VALUE) {
            if ((node = (ReplayProcessor.Node)node.get()) == null) {
                return n;
            }
            ++n;
        }
        return n;
    }

    void trim() {
        int n = this.size;
        if (n <= this.maxSize) return;
        this.size = n - 1;
        this.head = (ReplayProcessor.Node)this.head.get();
    }

    public void trimHead() {
        if (this.head.value == null) return;
        ReplayProcessor.Node node = new ReplayProcessor.Node(null);
        node.lazySet(this.head.get());
        this.head = node;
    }
}
