/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class HalfSerializer {
    private HalfSerializer() {
        throw new IllegalStateException("No instances!");
    }

    public static void onComplete(Observer<?> observer, AtomicInteger serializable, AtomicThrowable atomicThrowable) {
        if (serializable.getAndIncrement() != 0) return;
        serializable = atomicThrowable.terminate();
        if (serializable != null) {
            observer.onError((Throwable)serializable);
        } else {
            observer.onComplete();
        }
    }

    public static void onComplete(Subscriber<?> subscriber, AtomicInteger serializable, AtomicThrowable atomicThrowable) {
        if (serializable.getAndIncrement() != 0) return;
        serializable = atomicThrowable.terminate();
        if (serializable != null) {
            subscriber.onError((Throwable)serializable);
        } else {
            subscriber.onComplete();
        }
    }

    public static void onError(Observer<?> observer, Throwable throwable, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(throwable)) {
            if (atomicInteger.getAndIncrement() != 0) return;
            observer.onError(atomicThrowable.terminate());
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public static void onError(Subscriber<?> subscriber, Throwable throwable, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(throwable)) {
            if (atomicInteger.getAndIncrement() != 0) return;
            subscriber.onError(atomicThrowable.terminate());
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public static <T> void onNext(Observer<? super T> observer, T object, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() != 0) return;
        if (!atomicInteger.compareAndSet(0, 1)) return;
        observer.onNext(object);
        if (atomicInteger.decrementAndGet() == 0) return;
        object = atomicThrowable.terminate();
        if (object != null) {
            observer.onError(object);
        } else {
            observer.onComplete();
        }
    }

    public static <T> void onNext(Subscriber<? super T> subscriber, T object, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() != 0) return;
        if (!atomicInteger.compareAndSet(0, 1)) return;
        subscriber.onNext(object);
        if (atomicInteger.decrementAndGet() == 0) return;
        object = atomicThrowable.terminate();
        if (object != null) {
            subscriber.onError(object);
        } else {
            subscriber.onComplete();
        }
    }
}
