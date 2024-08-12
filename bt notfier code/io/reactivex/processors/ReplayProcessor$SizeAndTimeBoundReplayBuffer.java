/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.processors.ReplayProcessor$ReplayBuffer
 *  io.reactivex.processors.ReplayProcessor$ReplaySubscription
 *  io.reactivex.processors.ReplayProcessor$TimedNode
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.processors;

import io.reactivex.Scheduler;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.processors.ReplayProcessor;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

static final class ReplayProcessor.SizeAndTimeBoundReplayBuffer<T>
implements ReplayProcessor.ReplayBuffer<T> {
    volatile boolean done;
    Throwable error;
    volatile ReplayProcessor.TimedNode<T> head;
    final long maxAge;
    final int maxSize;
    final Scheduler scheduler;
    int size;
    ReplayProcessor.TimedNode<T> tail;
    final TimeUnit unit;

    ReplayProcessor.SizeAndTimeBoundReplayBuffer(int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.maxSize = ObjectHelper.verifyPositive((int)n, (String)"maxSize");
        this.maxAge = ObjectHelper.verifyPositive((long)l, (String)"maxAge");
        this.unit = (TimeUnit)((Object)ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null"));
        this.scheduler = (Scheduler)ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        timeUnit = new ReplayProcessor.TimedNode(null, 0L);
        this.tail = timeUnit;
        this.head = timeUnit;
    }

    public void complete() {
        this.trimFinal();
        this.done = true;
    }

    public void error(Throwable throwable) {
        this.trimFinal();
        this.error = throwable;
        this.done = true;
    }

    public Throwable getError() {
        return this.error;
    }

    ReplayProcessor.TimedNode<T> getHead() {
        ReplayProcessor.TimedNode timedNode = this.head;
        long l = this.scheduler.now(this.unit);
        long l2 = this.maxAge;
        ReplayProcessor.TimedNode timedNode2 = (ReplayProcessor.TimedNode)timedNode.get();
        while (timedNode2 != null) {
            if (timedNode2.time > l - l2) {
                return timedNode;
            }
            ReplayProcessor.TimedNode timedNode3 = (ReplayProcessor.TimedNode)timedNode2.get();
            timedNode = timedNode2;
            timedNode2 = timedNode3;
        }
        return timedNode;
    }

    public T getValue() {
        ReplayProcessor.TimedNode timedNode = this.head;
        while (true) {
            ReplayProcessor.TimedNode timedNode2;
            if ((timedNode2 = (ReplayProcessor.TimedNode)timedNode.get()) == null) {
                long l;
                long l2 = this.scheduler.now(this.unit);
                if (timedNode.time >= l2 - (l = this.maxAge)) return (T)timedNode.value;
                return null;
            }
            timedNode = timedNode2;
        }
    }

    public T[] getValues(T[] timedNode) {
        ReplayProcessor.TimedNode timedNode2;
        ReplayProcessor.TimedNode timedNode3 = this.getHead();
        int n = this.size(timedNode3);
        int n2 = 0;
        if (n == 0) {
            timedNode2 = timedNode;
            if (((ReplayProcessor.TimedNode<T>)timedNode).length == 0) return timedNode2;
            timedNode[0] = null;
            timedNode2 = timedNode;
        } else {
            timedNode2 = timedNode3;
            int n3 = n2;
            ReplayProcessor.TimedNode timedNode4 = timedNode;
            if (((ReplayProcessor.TimedNode<T>)timedNode).length < n) {
                timedNode4 = (ReplayProcessor.TimedNode)Array.newInstance(timedNode.getClass().getComponentType(), n);
                n3 = n2;
                timedNode2 = timedNode3;
            }
            while (n3 != n) {
                timedNode2 = (ReplayProcessor.TimedNode)timedNode2.get();
                timedNode4[n3] = timedNode2.value;
                ++n3;
            }
            timedNode2 = timedNode4;
            if (((ReplayProcessor.TimedNode)timedNode4).length <= n) return timedNode2;
            timedNode4[n] = null;
            timedNode2 = timedNode4;
        }
        return timedNode2;
    }

    public boolean isDone() {
        return this.done;
    }

    public void next(T object) {
        object = new ReplayProcessor.TimedNode(object, this.scheduler.now(this.unit));
        ReplayProcessor.TimedNode<T> timedNode = this.tail;
        this.tail = object;
        ++this.size;
        timedNode.set(object);
        this.trim();
    }

    public void replay(ReplayProcessor.ReplaySubscription<T> object) {
        int n;
        ReplayProcessor.TimedNode timedNode;
        if (object.getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = object.downstream;
        ReplayProcessor.TimedNode timedNode2 = timedNode = (ReplayProcessor.TimedNode)object.index;
        if (timedNode == null) {
            timedNode2 = this.getHead();
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
                timedNode = (ReplayProcessor.TimedNode)timedNode2.get();
                n = timedNode == null ? 1 : 0;
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
                subscriber.onNext(timedNode.value);
                ++l;
                timedNode2 = timedNode;
            }
            if (l == l2) {
                if (object.cancelled) {
                    object.index = null;
                    return;
                }
                if (this.done && timedNode2.get() == null) {
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
            object.index = timedNode2;
            object.emitted = l;
            n2 = n = object.addAndGet(-n2);
        } while (n != 0);
    }

    public int size() {
        return this.size(this.getHead());
    }

    int size(ReplayProcessor.TimedNode<T> timedNode) {
        int n = 0;
        while (n != Integer.MAX_VALUE) {
            if ((timedNode = (ReplayProcessor.TimedNode)timedNode.get()) == null) {
                return n;
            }
            ++n;
        }
        return n;
    }

    void trim() {
        int n = this.size;
        if (n > this.maxSize) {
            this.size = n - 1;
            this.head = (ReplayProcessor.TimedNode)this.head.get();
        }
        long l = this.scheduler.now(this.unit);
        long l2 = this.maxAge;
        ReplayProcessor.TimedNode timedNode = this.head;
        while (true) {
            ReplayProcessor.TimedNode timedNode2;
            if ((timedNode2 = (ReplayProcessor.TimedNode)timedNode.get()) == null) {
                this.head = timedNode;
                break;
            }
            if (timedNode2.time > l - l2) {
                this.head = timedNode;
                break;
            }
            timedNode = timedNode2;
        }
    }

    void trimFinal() {
        long l = this.scheduler.now(this.unit);
        long l2 = this.maxAge;
        ReplayProcessor.TimedNode timedNode = this.head;
        while (true) {
            ReplayProcessor.TimedNode timedNode2;
            if ((timedNode2 = (ReplayProcessor.TimedNode)timedNode.get()) == null) {
                if (timedNode.value != null) {
                    this.head = new ReplayProcessor.TimedNode(null, 0L);
                    break;
                }
                this.head = timedNode;
                break;
            }
            if (timedNode2.time > l - l2) {
                if (timedNode.value != null) {
                    timedNode2 = new ReplayProcessor.TimedNode(null, 0L);
                    timedNode2.lazySet(timedNode.get());
                    this.head = timedNode2;
                    break;
                }
                this.head = timedNode;
                break;
            }
            timedNode = timedNode2;
        }
    }

    public void trimHead() {
        if (this.head.value == null) return;
        ReplayProcessor.TimedNode timedNode = new ReplayProcessor.TimedNode(null, 0L);
        timedNode.lazySet(this.head.get());
        this.head = timedNode;
    }
}
