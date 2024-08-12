/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.BehaviorProcessor$BehaviorSubscription
 *  io.reactivex.processors.FlowableProcessor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.BehaviorProcessor;
import io.reactivex.processors.FlowableProcessor;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class BehaviorProcessor<T>
extends FlowableProcessor<T> {
    static final BehaviorSubscription[] EMPTY;
    static final Object[] EMPTY_ARRAY;
    static final BehaviorSubscription[] TERMINATED;
    long index;
    final ReadWriteLock lock;
    final Lock readLock;
    final AtomicReference<BehaviorSubscription<T>[]> subscribers;
    final AtomicReference<Throwable> terminalEvent;
    final AtomicReference<Object> value = new AtomicReference();
    final Lock writeLock;

    static {
        EMPTY_ARRAY = new Object[0];
        EMPTY = new BehaviorSubscription[0];
        TERMINATED = new BehaviorSubscription[0];
    }

    BehaviorProcessor() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.lock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = this.lock.writeLock();
        this.subscribers = new AtomicReference<BehaviorSubscription[]>(EMPTY);
        this.terminalEvent = new AtomicReference();
    }

    BehaviorProcessor(T t) {
        this();
        this.value.lazySet(ObjectHelper.requireNonNull(t, (String)"defaultValue is null"));
    }

    @CheckReturnValue
    public static <T> BehaviorProcessor<T> create() {
        return new BehaviorProcessor<T>();
    }

    @CheckReturnValue
    public static <T> BehaviorProcessor<T> createDefault(T t) {
        ObjectHelper.requireNonNull(t, (String)"defaultValue is null");
        return new BehaviorProcessor<T>(t);
    }

    boolean add(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArray;
        BehaviorSubscription<T>[] behaviorSubscriptionArray2;
        do {
            if ((behaviorSubscriptionArray2 = this.subscribers.get()) == TERMINATED) {
                return false;
            }
            int n = behaviorSubscriptionArray2.length;
            behaviorSubscriptionArray = new BehaviorSubscription[n + 1];
            System.arraycopy(behaviorSubscriptionArray2, 0, behaviorSubscriptionArray, 0, n);
            behaviorSubscriptionArray[n] = behaviorSubscription;
        } while (!this.subscribers.compareAndSet(behaviorSubscriptionArray2, behaviorSubscriptionArray));
        return true;
    }

    public Throwable getThrowable() {
        Object object = this.value.get();
        if (!NotificationLite.isError((Object)object)) return null;
        return NotificationLite.getError((Object)object);
    }

    public T getValue() {
        Object object = this.value.get();
        if (NotificationLite.isComplete((Object)object)) return null;
        if (!NotificationLite.isError((Object)object)) return (T)NotificationLite.getValue((Object)object);
        return null;
    }

    @Deprecated
    public Object[] getValues() {
        Object[] objectArray;
        Object[] objectArray2 = objectArray = this.getValues(EMPTY_ARRAY);
        if (objectArray != EMPTY_ARRAY) return objectArray2;
        objectArray2 = new Object[]{};
        return objectArray2;
    }

    @Deprecated
    public T[] getValues(T[] TArray) {
        Object[] objectArray = this.value.get();
        if (objectArray != null && !NotificationLite.isComplete((Object)objectArray) && !NotificationLite.isError((Object)objectArray)) {
            Object object = NotificationLite.getValue((Object)objectArray);
            if (TArray.length != 0) {
                TArray[0] = object;
                objectArray = TArray;
                if (TArray.length == 1) return objectArray;
                TArray[1] = null;
                objectArray = TArray;
            } else {
                objectArray = (Object[])Array.newInstance(TArray.getClass().getComponentType(), 1);
                objectArray[0] = object;
            }
            return objectArray;
        }
        if (TArray.length == 0) return TArray;
        TArray[0] = null;
        return TArray;
    }

    public boolean hasComplete() {
        return NotificationLite.isComplete((Object)this.value.get());
    }

    public boolean hasSubscribers() {
        boolean bl = this.subscribers.get().length != 0;
        return bl;
    }

    public boolean hasThrowable() {
        return NotificationLite.isError((Object)this.value.get());
    }

    public boolean hasValue() {
        Object object = this.value.get();
        boolean bl = object != null && !NotificationLite.isComplete((Object)object) && !NotificationLite.isError((Object)object);
        return bl;
    }

    public boolean offer(T object) {
        int n;
        if (object == null) {
            this.onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        BehaviorSubscription<T>[] behaviorSubscriptionArray = this.subscribers.get();
        int n2 = behaviorSubscriptionArray.length;
        int n3 = 0;
        for (n = 0; n < n2; ++n) {
            if (!behaviorSubscriptionArray[n].isFull()) continue;
            return false;
        }
        object = NotificationLite.next(object);
        this.setCurrent(object);
        n2 = behaviorSubscriptionArray.length;
        n = n3;
        while (n < n2) {
            behaviorSubscriptionArray[n].emitNext(object, this.index);
            ++n;
        }
        return true;
    }

    public void onComplete() {
        if (!this.terminalEvent.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            return;
        }
        Object object = NotificationLite.complete();
        BehaviorSubscription<T>[] behaviorSubscriptionArray = this.terminate(object);
        int n = behaviorSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            behaviorSubscriptionArray[n2].emitNext(object, this.index);
            ++n2;
        }
    }

    public void onError(Throwable behaviorSubscriptionArray) {
        ObjectHelper.requireNonNull((Object)behaviorSubscriptionArray, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.terminalEvent.compareAndSet(null, (Throwable)behaviorSubscriptionArray)) {
            RxJavaPlugins.onError((Throwable)behaviorSubscriptionArray);
            return;
        }
        Object object = NotificationLite.error((Throwable)behaviorSubscriptionArray);
        behaviorSubscriptionArray = this.terminate(object);
        int n = behaviorSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            behaviorSubscriptionArray[n2].emitNext(object, this.index);
            ++n2;
        }
    }

    public void onNext(T object) {
        ObjectHelper.requireNonNull(object, (String)"onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.terminalEvent.get() != null) {
            return;
        }
        object = NotificationLite.next(object);
        this.setCurrent(object);
        BehaviorSubscription<T>[] behaviorSubscriptionArray = this.subscribers.get();
        int n = behaviorSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            behaviorSubscriptionArray[n2].emitNext(object, this.index);
            ++n2;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.terminalEvent.get() != null) {
            subscription.cancel();
            return;
        }
        subscription.request(Long.MAX_VALUE);
    }

    void remove(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArray;
        BehaviorSubscription<T>[] behaviorSubscriptionArray2;
        do {
            int n;
            int n2;
            if ((n2 = (behaviorSubscriptionArray2 = this.subscribers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (behaviorSubscriptionArray2[n4] == behaviorSubscription) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                behaviorSubscriptionArray = EMPTY;
                continue;
            }
            behaviorSubscriptionArray = new BehaviorSubscription[n2 - 1];
            System.arraycopy(behaviorSubscriptionArray2, 0, behaviorSubscriptionArray, 0, n);
            System.arraycopy(behaviorSubscriptionArray2, n + 1, behaviorSubscriptionArray, n, n2 - n - 1);
        } while (!this.subscribers.compareAndSet(behaviorSubscriptionArray2, behaviorSubscriptionArray));
    }

    void setCurrent(Object object) {
        Lock lock = this.writeLock;
        lock.lock();
        ++this.index;
        this.value.lazySet(object);
        lock.unlock();
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Object object = new BehaviorSubscription(subscriber, this);
        subscriber.onSubscribe((Subscription)object);
        if (this.add((BehaviorSubscription<T>)object)) {
            if (object.cancelled) {
                this.remove((BehaviorSubscription<T>)object);
            } else {
                object.emitFirst();
            }
        } else {
            object = this.terminalEvent.get();
            if (object == ExceptionHelper.TERMINATED) {
                subscriber.onComplete();
            } else {
                subscriber.onError((Throwable)object);
            }
        }
    }

    int subscriberCount() {
        return this.subscribers.get().length;
    }

    BehaviorSubscription<T>[] terminate(Object object) {
        BehaviorSubscription<T>[] behaviorSubscriptionArray = this.subscribers.get();
        BehaviorSubscription[] behaviorSubscriptionArray2 = TERMINATED;
        BehaviorSubscription<T>[] behaviorSubscriptionArray3 = behaviorSubscriptionArray;
        if (behaviorSubscriptionArray == behaviorSubscriptionArray2) return behaviorSubscriptionArray3;
        behaviorSubscriptionArray3 = behaviorSubscriptionArray = this.subscribers.getAndSet(behaviorSubscriptionArray2);
        if (behaviorSubscriptionArray == TERMINATED) return behaviorSubscriptionArray3;
        this.setCurrent(object);
        behaviorSubscriptionArray3 = behaviorSubscriptionArray;
        return behaviorSubscriptionArray3;
    }
}
