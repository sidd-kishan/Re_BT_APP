/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableCombineLatest$CombineLatestInnerSubscriber
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

static final class FlowableCombineLatest.CombineLatestCoordinator<T, R>
extends BasicIntQueueSubscription<R> {
    private static final long serialVersionUID = -5082275438355852221L;
    volatile boolean cancelled;
    final Function<? super Object[], ? extends R> combiner;
    int completedSources;
    final boolean delayErrors;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final AtomicReference<Throwable> error;
    final Object[] latest;
    int nonEmptySources;
    boolean outputFused;
    final SpscLinkedArrayQueue<Object> queue;
    final AtomicLong requested;
    final FlowableCombineLatest.CombineLatestInnerSubscriber<T>[] subscribers;

    FlowableCombineLatest.CombineLatestCoordinator(Subscriber<? super R> combineLatestInnerSubscriberArray, Function<? super Object[], ? extends R> function, int n, int n2, boolean bl) {
        this.downstream = combineLatestInnerSubscriberArray;
        this.combiner = function;
        combineLatestInnerSubscriberArray = new FlowableCombineLatest.CombineLatestInnerSubscriber[n];
        int n3 = 0;
        while (true) {
            if (n3 >= n) {
                this.subscribers = combineLatestInnerSubscriberArray;
                this.latest = new Object[n];
                this.queue = new SpscLinkedArrayQueue(n2);
                this.requested = new AtomicLong();
                this.error = new AtomicReference();
                this.delayErrors = bl;
                return;
            }
            combineLatestInnerSubscriberArray[n3] = new FlowableCombineLatest.CombineLatestInnerSubscriber(this, n3, n2);
            ++n3;
        }
    }

    public void cancel() {
        this.cancelled = true;
        this.cancelAll();
    }

    void cancelAll() {
        FlowableCombineLatest.CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArray = this.subscribers;
        int n = combineLatestInnerSubscriberArray.length;
        int n2 = 0;
        while (n2 < n) {
            combineLatestInnerSubscriberArray[n2].cancel();
            ++n2;
        }
    }

    boolean checkTerminated(boolean bl, boolean bl2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> object) {
        if (this.cancelled) {
            this.cancelAll();
            object.clear();
            return true;
        }
        if (!bl) return false;
        if (this.delayErrors) {
            if (!bl2) return false;
            this.cancelAll();
            object = ExceptionHelper.terminate(this.error);
            if (object != null && object != ExceptionHelper.TERMINATED) {
                subscriber.onError(object);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        Throwable throwable = ExceptionHelper.terminate(this.error);
        if (throwable != null && throwable != ExceptionHelper.TERMINATED) {
            this.cancelAll();
            object.clear();
            subscriber.onError(throwable);
            return true;
        }
        if (!bl2) return false;
        this.cancelAll();
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
            this.drainOutput();
        } else {
            this.drainAsync();
        }
    }

    void drainAsync() {
        int n;
        Subscriber<? super R> subscriber = this.downstream;
        SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
        int n2 = 1;
        do {
            long l;
            long l2 = this.requested.get();
            for (l = 0L; l != l2; ++l) {
                boolean bl = this.done;
                Object object = spscLinkedArrayQueue.poll();
                boolean bl2 = object == null;
                if (this.checkTerminated(bl, bl2, subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (bl2) break;
                Object object2 = (Object[])spscLinkedArrayQueue.poll();
                try {
                    object2 = ObjectHelper.requireNonNull((Object)this.combiner.apply(object2), (String)"The combiner returned a null value");
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.cancelAll();
                    ExceptionHelper.addThrowable(this.error, (Throwable)throwable);
                    subscriber.onError(ExceptionHelper.terminate(this.error));
                    return;
                }
                subscriber.onNext(object2);
                ((FlowableCombineLatest.CombineLatestInnerSubscriber)object).requestOne();
            }
            if (l == l2 && this.checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (l != 0L && l2 != Long.MAX_VALUE) {
                this.requested.addAndGet(-l);
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    void drainOutput() {
        int n;
        Subscriber<? super R> subscriber = this.downstream;
        SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
        int n2 = 1;
        do {
            if (this.cancelled) {
                spscLinkedArrayQueue.clear();
                return;
            }
            Throwable throwable = this.error.get();
            if (throwable != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(throwable);
                return;
            }
            boolean bl = this.done;
            boolean bl2 = spscLinkedArrayQueue.isEmpty();
            if (!bl2) {
                subscriber.onNext(null);
            }
            if (bl && bl2) {
                subscriber.onComplete();
                return;
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void innerComplete(int n) {
        synchronized (this) {
            Object[] objectArray = this.latest;
            if (objectArray[n] != null) {
                n = this.completedSources + 1;
                if (n != objectArray.length) {
                    this.completedSources = n;
                    return;
                }
                this.done = true;
            } else {
                this.done = true;
            }
        }
        this.drain();
    }

    void innerError(int n, Throwable throwable) {
        if (ExceptionHelper.addThrowable(this.error, (Throwable)throwable)) {
            if (!this.delayErrors) {
                this.cancelAll();
                this.done = true;
                this.drain();
            } else {
                this.innerComplete(n);
            }
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    void innerValue(int n, T t) {
        int n2;
        // MONITORENTER : this
        Object[] objectArray = this.latest;
        int n3 = n2 = this.nonEmptySources;
        if (objectArray[n] == null) {
            this.nonEmptySources = n3 = n2 + 1;
        }
        objectArray[n] = t;
        if (objectArray.length == n3) {
            this.queue.offer(this.subscribers[n], objectArray.clone());
            n3 = 0;
        } else {
            n3 = 1;
        }
        // MONITOREXIT : this
        if (n3 != 0) {
            this.subscribers[n].requestOne();
            return;
        }
        this.drain();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public R poll() throws Exception {
        Object object = this.queue.poll();
        if (object == null) {
            return null;
        }
        Object object2 = (Object[])this.queue.poll();
        object2 = ObjectHelper.requireNonNull((Object)this.combiner.apply(object2), (String)"The combiner returned a null value");
        ((FlowableCombineLatest.CombineLatestInnerSubscriber)object).requestOne();
        return (R)object2;
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }

    public int requestFusion(int n) {
        boolean bl = false;
        if ((n & 4) != 0) {
            return 0;
        }
        if ((n &= 2) != 0) {
            bl = true;
        }
        this.outputFused = bl;
        return n;
    }

    void subscribe(Publisher<? extends T>[] publisherArray, int n) {
        FlowableCombineLatest.CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArray = this.subscribers;
        int n2 = 0;
        while (n2 < n) {
            if (this.done) return;
            if (this.cancelled) {
                return;
            }
            publisherArray[n2].subscribe(combineLatestInnerSubscriberArray[n2]);
            ++n2;
        }
    }
}
