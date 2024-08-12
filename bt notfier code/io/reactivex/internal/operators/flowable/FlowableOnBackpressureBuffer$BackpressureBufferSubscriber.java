/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableOnBackpressureBuffer.BackpressureBufferSubscriber<T>
extends BasicIntQueueSubscription<T>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -2514538129242366402L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    Throwable error;
    final Action onOverflow;
    boolean outputFused;
    final SimplePlainQueue<T> queue;
    final AtomicLong requested = new AtomicLong();
    Subscription upstream;

    FlowableOnBackpressureBuffer.BackpressureBufferSubscriber(Subscriber<? super T> object, int n, boolean bl, boolean bl2, Action action) {
        this.downstream = object;
        this.onOverflow = action;
        this.delayError = bl2;
        object = bl ? new SpscLinkedArrayQueue(n) : new SpscArrayQueue(n);
        this.queue = object;
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.cancel();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    boolean checkTerminated(boolean bl, boolean bl2, Subscriber<? super T> subscriber) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        }
        if (!bl) return false;
        if (this.delayError) {
            if (!bl2) return false;
            Throwable throwable = this.error;
            if (throwable != null) {
                subscriber.onError(throwable);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        Throwable throwable = this.error;
        if (throwable != null) {
            this.queue.clear();
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
        int n;
        if (this.getAndIncrement() != 0) return;
        SimplePlainQueue<T> simplePlainQueue = this.queue;
        Subscriber<? super T> subscriber = this.downstream;
        int n2 = 1;
        do {
            long l;
            if (this.checkTerminated(this.done, simplePlainQueue.isEmpty(), subscriber)) {
                return;
            }
            long l2 = this.requested.get();
            for (l = 0L; l != l2; ++l) {
                boolean bl = this.done;
                Object object = simplePlainQueue.poll();
                boolean bl2 = object == null;
                if (this.checkTerminated(bl, bl2, subscriber)) {
                    return;
                }
                if (bl2) break;
                subscriber.onNext(object);
            }
            if (l == l2 && this.checkTerminated(this.done, simplePlainQueue.isEmpty(), subscriber)) {
                return;
            }
            if (l != 0L && l2 != Long.MAX_VALUE) {
                this.requested.addAndGet(-l);
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        this.done = true;
        if (this.outputFused) {
            this.downstream.onComplete();
        } else {
            this.drain();
        }
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        if (this.outputFused) {
            this.downstream.onError(throwable);
        } else {
            this.drain();
        }
    }

    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.upstream.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.onOverflow.run();
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                missingBackpressureException.initCause(throwable);
            }
            this.onError((Throwable)missingBackpressureException);
            return;
        }
        if (this.outputFused) {
            this.downstream.onNext(null);
        } else {
            this.drain();
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }

    public T poll() throws Exception {
        return (T)this.queue.poll();
    }

    public void request(long l) {
        if (this.outputFused) return;
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
