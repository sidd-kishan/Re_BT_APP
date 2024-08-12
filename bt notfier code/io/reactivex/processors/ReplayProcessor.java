/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.FlowableProcessor
 *  io.reactivex.processors.ReplayProcessor$ReplayBuffer
 *  io.reactivex.processors.ReplayProcessor$ReplaySubscription
 *  io.reactivex.processors.ReplayProcessor$SizeAndTimeBoundReplayBuffer
 *  io.reactivex.processors.ReplayProcessor$SizeBoundReplayBuffer
 *  io.reactivex.processors.ReplayProcessor$UnboundedReplayBuffer
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.processors;

import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.ReplayProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ReplayProcessor<T>
extends FlowableProcessor<T> {
    static final ReplaySubscription[] EMPTY;
    private static final Object[] EMPTY_ARRAY;
    static final ReplaySubscription[] TERMINATED;
    final ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ReplaySubscription<T>[]> subscribers;

    static {
        EMPTY_ARRAY = new Object[0];
        EMPTY = new ReplaySubscription[0];
        TERMINATED = new ReplaySubscription[0];
    }

    ReplayProcessor(ReplayBuffer<T> replayBuffer) {
        this.buffer = replayBuffer;
        this.subscribers = new AtomicReference<ReplaySubscription[]>(EMPTY);
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> create() {
        return new ReplayProcessor<T>(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> create(int n) {
        return new ReplayProcessor<T>(new UnboundedReplayBuffer(n));
    }

    static <T> ReplayProcessor<T> createUnbounded() {
        return new ReplayProcessor<T>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithSize(int n) {
        return new ReplayProcessor<T>(new SizeBoundReplayBuffer(n));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTime(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplayProcessor<T>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, l, timeUnit, scheduler));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTimeAndSize(long l, TimeUnit timeUnit, Scheduler scheduler, int n) {
        return new ReplayProcessor<T>(new SizeAndTimeBoundReplayBuffer(n, l, timeUnit, scheduler));
    }

    boolean add(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription[] replaySubscriptionArray;
        ReplaySubscription<T>[] replaySubscriptionArray2;
        do {
            if ((replaySubscriptionArray2 = this.subscribers.get()) == TERMINATED) {
                return false;
            }
            int n = replaySubscriptionArray2.length;
            replaySubscriptionArray = new ReplaySubscription[n + 1];
            System.arraycopy(replaySubscriptionArray2, 0, replaySubscriptionArray, 0, n);
            replaySubscriptionArray[n] = replaySubscription;
        } while (!this.subscribers.compareAndSet(replaySubscriptionArray2, replaySubscriptionArray));
        return true;
    }

    public void cleanupBuffer() {
        this.buffer.trimHead();
    }

    public Throwable getThrowable() {
        ReplayBuffer<T> replayBuffer = this.buffer;
        if (!replayBuffer.isDone()) return null;
        return replayBuffer.getError();
    }

    public T getValue() {
        return (T)this.buffer.getValue();
    }

    public Object[] getValues() {
        Object[] objectArray;
        Object[] objectArray2 = objectArray = this.getValues(EMPTY_ARRAY);
        if (objectArray != EMPTY_ARRAY) return objectArray2;
        objectArray2 = new Object[]{};
        return objectArray2;
    }

    public T[] getValues(T[] TArray) {
        return this.buffer.getValues((Object[])TArray);
    }

    public boolean hasComplete() {
        ReplayBuffer<T> replayBuffer = this.buffer;
        boolean bl = replayBuffer.isDone() && replayBuffer.getError() == null;
        return bl;
    }

    public boolean hasSubscribers() {
        boolean bl = this.subscribers.get().length != 0;
        return bl;
    }

    public boolean hasThrowable() {
        ReplayBuffer<T> replayBuffer = this.buffer;
        boolean bl = replayBuffer.isDone() && replayBuffer.getError() != null;
        return bl;
    }

    public boolean hasValue() {
        boolean bl = this.buffer.size() != 0;
        return bl;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.complete();
        ReplaySubscription[] replaySubscriptionArray = this.subscribers.getAndSet(TERMINATED);
        int n = replaySubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            replayBuffer.replay(replaySubscriptionArray[n2]);
            ++n2;
        }
    }

    public void onError(Throwable replaySubscriptionArray) {
        ObjectHelper.requireNonNull((Object)replaySubscriptionArray, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done) {
            RxJavaPlugins.onError((Throwable)replaySubscriptionArray);
            return;
        }
        this.done = true;
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.error((Throwable)replaySubscriptionArray);
        replaySubscriptionArray = this.subscribers.getAndSet(TERMINATED);
        int n = replaySubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            replayBuffer.replay(replaySubscriptionArray[n2]);
            ++n2;
        }
    }

    public void onNext(T object) {
        ObjectHelper.requireNonNull(object, (String)"onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done) {
            return;
        }
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.next(object);
        object = this.subscribers.get();
        int n = ((T)object).length;
        int n2 = 0;
        while (n2 < n) {
            replayBuffer.replay(object[n2]);
            ++n2;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.done) {
            subscription.cancel();
            return;
        }
        subscription.request(Long.MAX_VALUE);
    }

    void remove(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription[] replaySubscriptionArray;
        ReplaySubscription<T>[] replaySubscriptionArray2;
        do {
            int n;
            if ((replaySubscriptionArray2 = this.subscribers.get()) == TERMINATED) return;
            if (replaySubscriptionArray2 == EMPTY) return;
            int n2 = replaySubscriptionArray2.length;
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (replaySubscriptionArray2[n4] == replaySubscription) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                replaySubscriptionArray = EMPTY;
                continue;
            }
            replaySubscriptionArray = new ReplaySubscription[n2 - 1];
            System.arraycopy(replaySubscriptionArray2, 0, replaySubscriptionArray, 0, n);
            System.arraycopy(replaySubscriptionArray2, n + 1, replaySubscriptionArray, n, n2 - n - 1);
        } while (!this.subscribers.compareAndSet(replaySubscriptionArray2, replaySubscriptionArray));
    }

    int size() {
        return this.buffer.size();
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ReplaySubscription replaySubscription = new ReplaySubscription(subscriber, this);
        subscriber.onSubscribe((Subscription)replaySubscription);
        if (this.add(replaySubscription) && replaySubscription.cancelled) {
            this.remove(replaySubscription);
            return;
        }
        this.buffer.replay(replaySubscription);
    }

    int subscriberCount() {
        return this.subscribers.get().length;
    }
}
