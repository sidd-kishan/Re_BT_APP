/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.AsyncProcessor$AsyncSubscription
 *  io.reactivex.processors.FlowableProcessor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.AsyncProcessor;
import io.reactivex.processors.FlowableProcessor;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class AsyncProcessor<T>
extends FlowableProcessor<T> {
    static final AsyncSubscription[] EMPTY = new AsyncSubscription[0];
    static final AsyncSubscription[] TERMINATED = new AsyncSubscription[0];
    Throwable error;
    final AtomicReference<AsyncSubscription<T>[]> subscribers = new AtomicReference<AsyncSubscription[]>(EMPTY);
    T value;

    AsyncProcessor() {
    }

    @CheckReturnValue
    public static <T> AsyncProcessor<T> create() {
        return new AsyncProcessor<T>();
    }

    boolean add(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription[] asyncSubscriptionArray;
        AsyncSubscription<T>[] asyncSubscriptionArray2;
        do {
            if ((asyncSubscriptionArray2 = this.subscribers.get()) == TERMINATED) {
                return false;
            }
            int n = asyncSubscriptionArray2.length;
            asyncSubscriptionArray = new AsyncSubscription[n + 1];
            System.arraycopy(asyncSubscriptionArray2, 0, asyncSubscriptionArray, 0, n);
            asyncSubscriptionArray[n] = asyncSubscription;
        } while (!this.subscribers.compareAndSet(asyncSubscriptionArray2, asyncSubscriptionArray));
        return true;
    }

    public Throwable getThrowable() {
        Throwable throwable = this.subscribers.get() == TERMINATED ? this.error : null;
        return throwable;
    }

    public T getValue() {
        T t = this.subscribers.get() == TERMINATED ? (T)this.value : null;
        return t;
    }

    @Deprecated
    public Object[] getValues() {
        T t = this.getValue();
        Object[] objectArray = t != null ? new Object[]{t} : new Object[]{};
        return objectArray;
    }

    @Deprecated
    public T[] getValues(T[] TArray) {
        T t = this.getValue();
        if (t == null) {
            if (TArray.length == 0) return TArray;
            TArray[0] = null;
            return TArray;
        }
        T[] TArray2 = TArray;
        if (TArray.length == 0) {
            TArray2 = Arrays.copyOf(TArray, 1);
        }
        TArray2[0] = t;
        if (TArray2.length == 1) return TArray2;
        TArray2[1] = null;
        return TArray2;
    }

    public boolean hasComplete() {
        boolean bl = this.subscribers.get() == TERMINATED && this.error == null;
        return bl;
    }

    public boolean hasSubscribers() {
        boolean bl = this.subscribers.get().length != 0;
        return bl;
    }

    public boolean hasThrowable() {
        boolean bl = this.subscribers.get() == TERMINATED && this.error != null;
        return bl;
    }

    public boolean hasValue() {
        boolean bl = this.subscribers.get() == TERMINATED && this.value != null;
        return bl;
    }

    public void onComplete() {
        AsyncSubscription[] asyncSubscriptionArray;
        Object object = this.subscribers.get();
        if (object == (asyncSubscriptionArray = TERMINATED)) {
            return;
        }
        object = this.value;
        asyncSubscriptionArray = this.subscribers.getAndSet(asyncSubscriptionArray);
        int n = 0;
        int n2 = 0;
        if (object == null) {
            int n3 = asyncSubscriptionArray.length;
            n = n2;
            while (n < n3) {
                asyncSubscriptionArray[n].onComplete();
                ++n;
            }
            return;
        }
        n2 = asyncSubscriptionArray.length;
        while (n < n2) {
            asyncSubscriptionArray[n].complete(object);
            ++n;
        }
    }

    public void onError(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncSubscription<T>[] asyncSubscriptionArray = this.subscribers.get();
        AsyncSubscription[] asyncSubscriptionArray2 = TERMINATED;
        if (asyncSubscriptionArray == asyncSubscriptionArray2) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.value = null;
        this.error = throwable;
        asyncSubscriptionArray = this.subscribers.getAndSet(asyncSubscriptionArray2);
        int n = asyncSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            asyncSubscriptionArray[n2].onError(throwable);
            ++n2;
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, (String)"onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() == TERMINATED) {
            return;
        }
        this.value = t;
    }

    public void onSubscribe(Subscription subscription) {
        if (this.subscribers.get() == TERMINATED) {
            subscription.cancel();
            return;
        }
        subscription.request(Long.MAX_VALUE);
    }

    void remove(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription[] asyncSubscriptionArray;
        AsyncSubscription<T>[] asyncSubscriptionArray2;
        do {
            int n;
            int n2;
            if ((n2 = (asyncSubscriptionArray2 = this.subscribers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (asyncSubscriptionArray2[n4] == asyncSubscription) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                asyncSubscriptionArray = EMPTY;
                continue;
            }
            asyncSubscriptionArray = new AsyncSubscription[n2 - 1];
            System.arraycopy(asyncSubscriptionArray2, 0, asyncSubscriptionArray, 0, n);
            System.arraycopy(asyncSubscriptionArray2, n + 1, asyncSubscriptionArray, n, n2 - n - 1);
        } while (!this.subscribers.compareAndSet(asyncSubscriptionArray2, asyncSubscriptionArray));
    }

    protected void subscribeActual(Subscriber<? super T> object) {
        AsyncSubscription asyncSubscription = new AsyncSubscription(object, this);
        object.onSubscribe((Subscription)asyncSubscription);
        if (this.add(asyncSubscription)) {
            if (!asyncSubscription.isCancelled()) return;
            this.remove(asyncSubscription);
        } else {
            Throwable throwable = this.error;
            if (throwable != null) {
                object.onError(throwable);
            } else {
                object = this.value;
                if (object != null) {
                    asyncSubscription.complete(object);
                } else {
                    asyncSubscription.onComplete();
                }
            }
        }
    }
}
