/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.FlowableProcessor
 *  io.reactivex.processors.PublishProcessor$PublishSubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class PublishProcessor<T>
extends FlowableProcessor<T> {
    static final PublishSubscription[] EMPTY;
    static final PublishSubscription[] TERMINATED;
    Throwable error;
    final AtomicReference<PublishSubscription<T>[]> subscribers = new AtomicReference<PublishSubscription[]>(EMPTY);

    static {
        TERMINATED = new PublishSubscription[0];
        EMPTY = new PublishSubscription[0];
    }

    PublishProcessor() {
    }

    @CheckReturnValue
    public static <T> PublishProcessor<T> create() {
        return new PublishProcessor<T>();
    }

    boolean add(PublishSubscription<T> publishSubscription) {
        PublishSubscription[] publishSubscriptionArray;
        PublishSubscription<T>[] publishSubscriptionArray2;
        do {
            if ((publishSubscriptionArray2 = this.subscribers.get()) == TERMINATED) {
                return false;
            }
            int n = publishSubscriptionArray2.length;
            publishSubscriptionArray = new PublishSubscription[n + 1];
            System.arraycopy(publishSubscriptionArray2, 0, publishSubscriptionArray, 0, n);
            publishSubscriptionArray[n] = publishSubscription;
        } while (!this.subscribers.compareAndSet(publishSubscriptionArray2, publishSubscriptionArray));
        return true;
    }

    public Throwable getThrowable() {
        if (this.subscribers.get() != TERMINATED) return null;
        return this.error;
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

    public boolean offer(T t) {
        int n;
        if (t == null) {
            this.onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        PublishSubscription<T>[] publishSubscriptionArray = this.subscribers.get();
        int n2 = publishSubscriptionArray.length;
        int n3 = 0;
        for (n = 0; n < n2; ++n) {
            if (!publishSubscriptionArray[n].isFull()) continue;
            return false;
        }
        n2 = publishSubscriptionArray.length;
        n = n3;
        while (n < n2) {
            publishSubscriptionArray[n].onNext(t);
            ++n;
        }
        return true;
    }

    public void onComplete() {
        PublishSubscription[] publishSubscriptionArray;
        PublishSubscription<T>[] publishSubscriptionArray2 = this.subscribers.get();
        if (publishSubscriptionArray2 == (publishSubscriptionArray = TERMINATED)) {
            return;
        }
        publishSubscriptionArray = this.subscribers.getAndSet(publishSubscriptionArray);
        int n = publishSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            publishSubscriptionArray[n2].onComplete();
            ++n2;
        }
    }

    public void onError(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription<T>[] publishSubscriptionArray = this.subscribers.get();
        PublishSubscription[] publishSubscriptionArray2 = TERMINATED;
        if (publishSubscriptionArray == publishSubscriptionArray2) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        publishSubscriptionArray = this.subscribers.getAndSet(publishSubscriptionArray2);
        int n = publishSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            publishSubscriptionArray[n2].onError(throwable);
            ++n2;
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, (String)"onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription<T>[] publishSubscriptionArray = this.subscribers.get();
        int n = publishSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            publishSubscriptionArray[n2].onNext(t);
            ++n2;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.subscribers.get() == TERMINATED) {
            subscription.cancel();
            return;
        }
        subscription.request(Long.MAX_VALUE);
    }

    void remove(PublishSubscription<T> publishSubscription) {
        PublishSubscription[] publishSubscriptionArray;
        PublishSubscription<T>[] publishSubscriptionArray2;
        do {
            int n;
            if ((publishSubscriptionArray2 = this.subscribers.get()) == TERMINATED) return;
            if (publishSubscriptionArray2 == EMPTY) return;
            int n2 = publishSubscriptionArray2.length;
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (publishSubscriptionArray2[n4] == publishSubscription) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                publishSubscriptionArray = EMPTY;
                continue;
            }
            publishSubscriptionArray = new PublishSubscription[n2 - 1];
            System.arraycopy(publishSubscriptionArray2, 0, publishSubscriptionArray, 0, n);
            System.arraycopy(publishSubscriptionArray2, n + 1, publishSubscriptionArray, n, n2 - n - 1);
        } while (!this.subscribers.compareAndSet(publishSubscriptionArray2, publishSubscriptionArray));
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Object object = new PublishSubscription(subscriber, this);
        subscriber.onSubscribe((Subscription)object);
        if (this.add((PublishSubscription<T>)object)) {
            if (!object.isCancelled()) return;
            this.remove((PublishSubscription<T>)object);
        } else {
            object = this.error;
            if (object != null) {
                subscriber.onError((Throwable)object);
            } else {
                subscriber.onComplete();
            }
        }
    }
}
