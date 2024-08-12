/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.flowables.GroupedFlowable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupedUnicast
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class FlowableGroupBy.GroupBySubscriber<T, K, V>
extends BasicIntQueueSubscription<GroupedFlowable<K, V>>
implements FlowableSubscriber<T> {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final boolean delayError;
    boolean done;
    final Subscriber<? super GroupedFlowable<K, V>> downstream;
    Throwable error;
    final Queue<FlowableGroupBy.GroupedUnicast<K, V>> evictedGroups;
    volatile boolean finished;
    final AtomicInteger groupCount;
    final Map<Object, FlowableGroupBy.GroupedUnicast<K, V>> groups;
    final Function<? super T, ? extends K> keySelector;
    boolean outputFused;
    final SpscLinkedArrayQueue<GroupedFlowable<K, V>> queue;
    final AtomicLong requested = new AtomicLong();
    Subscription upstream;
    final Function<? super T, ? extends V> valueSelector;

    public FlowableGroupBy.GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int n, boolean bl, Map<Object, FlowableGroupBy.GroupedUnicast<K, V>> map, Queue<FlowableGroupBy.GroupedUnicast<K, V>> queue) {
        this.groupCount = new AtomicInteger(1);
        this.downstream = subscriber;
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = n;
        this.delayError = bl;
        this.groups = map;
        this.evictedGroups = queue;
        this.queue = new SpscLinkedArrayQueue(n);
    }

    private void completeEvictions() {
        if (this.evictedGroups == null) return;
        int n = 0;
        while (true) {
            FlowableGroupBy.GroupedUnicast<K, V> groupedUnicast;
            if ((groupedUnicast = this.evictedGroups.poll()) == null) {
                if (n == 0) return;
                this.groupCount.addAndGet(-n);
                return;
            }
            groupedUnicast.onComplete();
            ++n;
        }
    }

    public void cancel() {
        if (!this.cancelled.compareAndSet(false, true)) return;
        this.completeEvictions();
        if (this.groupCount.decrementAndGet() != 0) return;
        this.upstream.cancel();
    }

    public void cancel(K object) {
        if (object == null) {
            object = NULL_KEY;
        }
        this.groups.remove(object);
        if (this.groupCount.decrementAndGet() != 0) return;
        this.upstream.cancel();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    boolean checkTerminated(boolean bl, boolean bl2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> object) {
        if (this.cancelled.get()) {
            object.clear();
            return true;
        }
        if (this.delayError) {
            if (!bl) return false;
            if (!bl2) return false;
            object = this.error;
            if (object != null) {
                subscriber.onError(object);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        if (!bl) return false;
        Throwable throwable = this.error;
        if (throwable != null) {
            object.clear();
            subscriber.onError(throwable);
            return true;
        }
        if (!bl2) return false;
        subscriber.onComplete();
        return true;
    }

    public void clear() {
        this.queue.clear();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        if (this.outputFused) {
            this.drainFused();
        } else {
            this.drainNormal();
        }
    }

    void drainFused() {
        int n;
        Object object = this.queue;
        Subscriber<? super GroupedFlowable<K, V>> subscriber = this.downstream;
        int n2 = 1;
        do {
            Throwable throwable;
            if (this.cancelled.get()) {
                object.clear();
                return;
            }
            boolean bl = this.finished;
            if (bl && !this.delayError && (throwable = this.error) != null) {
                object.clear();
                subscriber.onError(throwable);
                return;
            }
            subscriber.onNext(null);
            if (bl) {
                object = this.error;
                if (object != null) {
                    subscriber.onError(object);
                } else {
                    subscriber.onComplete();
                }
                return;
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    void drainNormal() {
        int n;
        SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue = this.queue;
        Subscriber<? super GroupedFlowable<K, V>> subscriber = this.downstream;
        int n2 = 1;
        do {
            long l;
            long l2 = this.requested.get();
            for (l = 0L; l != l2; ++l) {
                boolean bl = this.finished;
                GroupedFlowable groupedFlowable = (GroupedFlowable)spscLinkedArrayQueue.poll();
                boolean bl2 = groupedFlowable == null;
                if (this.checkTerminated(bl, bl2, subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (bl2) break;
                subscriber.onNext((Object)groupedFlowable);
            }
            if (l == l2 && this.checkTerminated(this.finished, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (l != 0L) {
                if (l2 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-l);
                }
                this.upstream.request(l);
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        if (this.done) return;
        Object object = this.groups.values().iterator();
        while (object.hasNext()) {
            object.next().onComplete();
        }
        this.groups.clear();
        object = this.evictedGroups;
        if (object != null) {
            object.clear();
        }
        this.done = true;
        this.finished = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        Object object = this.groups.values().iterator();
        while (object.hasNext()) {
            object.next().onError(throwable);
        }
        this.groups.clear();
        object = this.evictedGroups;
        if (object != null) {
            object.clear();
        }
        this.error = throwable;
        this.finished = true;
        this.drain();
    }

    public void onNext(T object) {
        FlowableGroupBy.GroupedUnicast groupedUnicast;
        boolean bl;
        SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue;
        block6: {
            Object object2;
            Object object3;
            if (this.done) {
                return;
            }
            spscLinkedArrayQueue = this.queue;
            try {
                FlowableGroupBy.GroupedUnicast groupedUnicast2;
                object3 = this.keySelector.apply(object);
                bl = false;
                object2 = object3 != null ? object3 : NULL_KEY;
                groupedUnicast = groupedUnicast2 = this.groups.get(object2);
                if (groupedUnicast2 != null) break block6;
                if (this.cancelled.get()) {
                    return;
                }
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.cancel();
                this.onError(throwable);
                return;
            }
            groupedUnicast = FlowableGroupBy.GroupedUnicast.createWith((Object)object3, (int)this.bufferSize, (FlowableGroupBy.GroupBySubscriber)this, (boolean)this.delayError);
            this.groups.put(object2, groupedUnicast);
            this.groupCount.getAndIncrement();
            bl = true;
        }
        try {
            object = ObjectHelper.requireNonNull((Object)this.valueSelector.apply(object), (String)"The valueSelector returned null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        groupedUnicast.onNext(object);
        this.completeEvictions();
        if (!bl) return;
        spscLinkedArrayQueue.offer((Object)groupedUnicast);
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request((long)this.bufferSize);
    }

    public GroupedFlowable<K, V> poll() {
        return (GroupedFlowable)this.queue.poll();
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }

    public int requestFusion(int n) {
        if ((n & 2) == 0) return 0;
        this.outputFused = true;
        return 2;
    }
}
