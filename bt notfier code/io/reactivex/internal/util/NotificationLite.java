/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.util.NotificationLite$DisposableNotification
 *  io.reactivex.internal.util.NotificationLite$ErrorNotification
 *  io.reactivex.internal.util.NotificationLite$SubscriptionNotification
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class NotificationLite
extends Enum<NotificationLite> {
    private static final NotificationLite[] $VALUES;
    public static final /* enum */ NotificationLite COMPLETE;

    static {
        NotificationLite notificationLite;
        COMPLETE = notificationLite = new NotificationLite();
        $VALUES = new NotificationLite[]{notificationLite};
    }

    public static <T> boolean accept(Object object, Observer<? super T> observer) {
        if (object == COMPLETE) {
            observer.onComplete();
            return true;
        }
        if (object instanceof ErrorNotification) {
            observer.onError(((ErrorNotification)object).e);
            return true;
        }
        observer.onNext(object);
        return false;
    }

    public static <T> boolean accept(Object object, Subscriber<? super T> subscriber) {
        if (object == COMPLETE) {
            subscriber.onComplete();
            return true;
        }
        if (object instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification)object).e);
            return true;
        }
        subscriber.onNext(object);
        return false;
    }

    public static <T> boolean acceptFull(Object object, Observer<? super T> observer) {
        if (object == COMPLETE) {
            observer.onComplete();
            return true;
        }
        if (object instanceof ErrorNotification) {
            observer.onError(((ErrorNotification)object).e);
            return true;
        }
        if (object instanceof DisposableNotification) {
            observer.onSubscribe(((DisposableNotification)object).upstream);
            return false;
        }
        observer.onNext(object);
        return false;
    }

    public static <T> boolean acceptFull(Object object, Subscriber<? super T> subscriber) {
        if (object == COMPLETE) {
            subscriber.onComplete();
            return true;
        }
        if (object instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification)object).e);
            return true;
        }
        if (object instanceof SubscriptionNotification) {
            subscriber.onSubscribe(((SubscriptionNotification)object).upstream);
            return false;
        }
        subscriber.onNext(object);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(Disposable disposable) {
        return new DisposableNotification(disposable);
    }

    public static Object error(Throwable throwable) {
        return new ErrorNotification(throwable);
    }

    public static Disposable getDisposable(Object object) {
        return ((DisposableNotification)object).upstream;
    }

    public static Throwable getError(Object object) {
        return ((ErrorNotification)object).e;
    }

    public static Subscription getSubscription(Object object) {
        return ((SubscriptionNotification)object).upstream;
    }

    public static <T> T getValue(Object object) {
        return (T)object;
    }

    public static boolean isComplete(Object object) {
        boolean bl = object == COMPLETE;
        return bl;
    }

    public static boolean isDisposable(Object object) {
        return object instanceof DisposableNotification;
    }

    public static boolean isError(Object object) {
        return object instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object object) {
        return object instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(Subscription subscription) {
        return new SubscriptionNotification(subscription);
    }

    public static NotificationLite valueOf(String string) {
        return Enum.valueOf(NotificationLite.class, string);
    }

    public static NotificationLite[] values() {
        return (NotificationLite[])$VALUES.clone();
    }

    public String toString() {
        return "NotificationLite.Complete";
    }
}
