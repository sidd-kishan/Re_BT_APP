/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.subjects.ReplaySubject$ReplayBuffer
 *  io.reactivex.subjects.ReplaySubject$ReplayDisposable
 *  io.reactivex.subjects.ReplaySubject$TimedNode
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.ReplaySubject;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

static final class ReplaySubject.SizeAndTimeBoundReplayBuffer<T>
extends AtomicReference<Object>
implements ReplaySubject.ReplayBuffer<T> {
    private static final long serialVersionUID = -8056260896137901749L;
    volatile boolean done;
    volatile ReplaySubject.TimedNode<Object> head;
    final long maxAge;
    final int maxSize;
    final Scheduler scheduler;
    int size;
    ReplaySubject.TimedNode<Object> tail;
    final TimeUnit unit;

    ReplaySubject.SizeAndTimeBoundReplayBuffer(int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.maxSize = ObjectHelper.verifyPositive((int)n, (String)"maxSize");
        this.maxAge = ObjectHelper.verifyPositive((long)l, (String)"maxAge");
        this.unit = (TimeUnit)((Object)ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null"));
        this.scheduler = (Scheduler)ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        timeUnit = new ReplaySubject.TimedNode(null, 0L);
        this.tail = timeUnit;
        this.head = timeUnit;
    }

    public void add(T object) {
        ReplaySubject.TimedNode timedNode = new ReplaySubject.TimedNode(object, this.scheduler.now(this.unit));
        object = this.tail;
        this.tail = timedNode;
        ++this.size;
        object.set((Object)timedNode);
        this.trim();
    }

    public void addFinal(Object object) {
        object = new ReplaySubject.TimedNode(object, Long.MAX_VALUE);
        ReplaySubject.TimedNode<Object> timedNode = this.tail;
        this.tail = object;
        ++this.size;
        timedNode.lazySet(object);
        this.trimFinal();
        this.done = true;
    }

    ReplaySubject.TimedNode<Object> getHead() {
        ReplaySubject.TimedNode timedNode = this.head;
        long l = this.scheduler.now(this.unit);
        long l2 = this.maxAge;
        ReplaySubject.TimedNode timedNode2 = (ReplaySubject.TimedNode)timedNode.get();
        while (timedNode2 != null) {
            if (timedNode2.time > l - l2) {
                return timedNode;
            }
            ReplaySubject.TimedNode timedNode3 = (ReplaySubject.TimedNode)timedNode2.get();
            timedNode = timedNode2;
            timedNode2 = timedNode3;
        }
        return timedNode;
    }

    public T getValue() {
        Object object = this.head;
        ReplaySubject.TimedNode timedNode = null;
        while (true) {
            ReplaySubject.TimedNode timedNode2;
            if ((timedNode2 = (ReplaySubject.TimedNode)object.get()) == null) {
                long l;
                long l2 = this.scheduler.now(this.unit);
                if (object.time < l2 - (l = this.maxAge)) {
                    return null;
                }
                object = object.value;
                if (object == null) {
                    return null;
                }
                if (NotificationLite.isComplete((Object)object)) return (T)timedNode.value;
                if (!NotificationLite.isError((Object)object)) return (T)object;
                return (T)timedNode.value;
            }
            timedNode = object;
            object = timedNode2;
        }
    }

    public T[] getValues(T[] timedNode) {
        ReplaySubject.TimedNode timedNode2;
        ReplaySubject.TimedNode timedNode3 = this.getHead();
        int n = this.size(timedNode3);
        int n2 = 0;
        if (n == 0) {
            timedNode2 = timedNode;
            if (((ReplaySubject.TimedNode<Object>)timedNode).length == 0) return timedNode2;
            timedNode[0] = null;
            timedNode2 = timedNode;
        } else {
            timedNode2 = timedNode3;
            int n3 = n2;
            ReplaySubject.TimedNode timedNode4 = timedNode;
            if (((ReplaySubject.TimedNode<Object>)timedNode).length < n) {
                timedNode4 = (ReplaySubject.TimedNode)Array.newInstance(timedNode.getClass().getComponentType(), n);
                n3 = n2;
                timedNode2 = timedNode3;
            }
            while (n3 != n) {
                timedNode2 = (ReplaySubject.TimedNode)timedNode2.get();
                timedNode4[n3] = timedNode2.value;
                ++n3;
            }
            timedNode2 = timedNode4;
            if (((ReplaySubject.TimedNode)timedNode4).length <= n) return timedNode2;
            timedNode4[n] = null;
            timedNode2 = timedNode4;
        }
        return timedNode2;
    }

    public void replay(ReplaySubject.ReplayDisposable<T> replayDisposable) {
        ReplaySubject.TimedNode timedNode;
        if (replayDisposable.getAndIncrement() != 0) {
            return;
        }
        Observer observer = replayDisposable.downstream;
        Object object = timedNode = (ReplaySubject.TimedNode)replayDisposable.index;
        if (timedNode == null) {
            object = this.getHead();
        }
        int n = 1;
        block0: while (true) {
            if (replayDisposable.cancelled) {
                replayDisposable.index = null;
                return;
            }
            while (true) {
                if (replayDisposable.cancelled) {
                    replayDisposable.index = null;
                    return;
                }
                timedNode = (ReplaySubject.TimedNode)object.get();
                if (timedNode == null) {
                    int n2;
                    if (object.get() != null) continue block0;
                    replayDisposable.index = object;
                    n = n2 = replayDisposable.addAndGet(-n);
                    if (n2 == 0) return;
                    continue block0;
                }
                object = timedNode.value;
                if (this.done && timedNode.get() == null) {
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
                object = timedNode;
            }
            break;
        }
    }

    public int size() {
        return this.size(this.getHead());
    }

    int size(ReplaySubject.TimedNode<Object> object) {
        int n = 0;
        while (true) {
            int n2 = ++n;
            if (n == Integer.MAX_VALUE) return n2;
            ReplaySubject.TimedNode timedNode = (ReplaySubject.TimedNode)object.get();
            if (timedNode == null) {
                object = object.value;
                if (!NotificationLite.isComplete((Object)object)) {
                    n2 = n;
                    if (!NotificationLite.isError((Object)object)) return n2;
                }
                n2 = n - 1;
                return n2;
            }
            object = timedNode;
        }
    }

    void trim() {
        int n = this.size;
        if (n > this.maxSize) {
            this.size = n - 1;
            this.head = (ReplaySubject.TimedNode)this.head.get();
        }
        long l = this.scheduler.now(this.unit);
        long l2 = this.maxAge;
        ReplaySubject.TimedNode timedNode = this.head;
        while (true) {
            ReplaySubject.TimedNode timedNode2;
            if ((timedNode2 = (ReplaySubject.TimedNode)timedNode.get()) == null) {
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
        ReplaySubject.TimedNode timedNode = this.head;
        while (true) {
            ReplaySubject.TimedNode timedNode2;
            if ((timedNode2 = (ReplaySubject.TimedNode)timedNode.get()).get() == null) {
                if (timedNode.value != null) {
                    timedNode2 = new ReplaySubject.TimedNode(null, 0L);
                    timedNode2.lazySet(timedNode.get());
                    this.head = timedNode2;
                    break;
                }
                this.head = timedNode;
                break;
            }
            if (timedNode2.time > l - l2) {
                if (timedNode.value != null) {
                    timedNode2 = new ReplaySubject.TimedNode(null, 0L);
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
        ReplaySubject.TimedNode<Object> timedNode = this.head;
        if (timedNode.value == null) return;
        ReplaySubject.TimedNode timedNode2 = new ReplaySubject.TimedNode(null, 0L);
        timedNode2.lazySet(timedNode.get());
        this.head = timedNode2;
    }
}
