/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.PublishSubject$PublishDisposable
 *  io.reactivex.subjects.Subject
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishSubject<T>
extends Subject<T> {
    static final PublishDisposable[] EMPTY;
    static final PublishDisposable[] TERMINATED;
    Throwable error;
    final AtomicReference<PublishDisposable<T>[]> subscribers = new AtomicReference<PublishDisposable[]>(EMPTY);

    static {
        TERMINATED = new PublishDisposable[0];
        EMPTY = new PublishDisposable[0];
    }

    PublishSubject() {
    }

    @CheckReturnValue
    public static <T> PublishSubject<T> create() {
        return new PublishSubject<T>();
    }

    boolean add(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArray;
        PublishDisposable<T>[] publishDisposableArray2;
        do {
            if ((publishDisposableArray2 = this.subscribers.get()) == TERMINATED) {
                return false;
            }
            int n = publishDisposableArray2.length;
            publishDisposableArray = new PublishDisposable[n + 1];
            System.arraycopy(publishDisposableArray2, 0, publishDisposableArray, 0, n);
            publishDisposableArray[n] = publishDisposable;
        } while (!this.subscribers.compareAndSet(publishDisposableArray2, publishDisposableArray));
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

    public boolean hasObservers() {
        boolean bl = this.subscribers.get().length != 0;
        return bl;
    }

    public boolean hasThrowable() {
        boolean bl = this.subscribers.get() == TERMINATED && this.error != null;
        return bl;
    }

    public void onComplete() {
        PublishDisposable[] publishDisposableArray;
        PublishDisposable<T>[] publishDisposableArray2 = this.subscribers.get();
        if (publishDisposableArray2 == (publishDisposableArray = TERMINATED)) {
            return;
        }
        publishDisposableArray2 = this.subscribers.getAndSet(publishDisposableArray);
        int n = publishDisposableArray2.length;
        int n2 = 0;
        while (n2 < n) {
            publishDisposableArray2[n2].onComplete();
            ++n2;
        }
    }

    public void onError(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArray = this.subscribers.get();
        PublishDisposable[] publishDisposableArray2 = TERMINATED;
        if (publishDisposableArray == publishDisposableArray2) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        publishDisposableArray = this.subscribers.getAndSet(publishDisposableArray2);
        int n = publishDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            publishDisposableArray[n2].onError(throwable);
            ++n2;
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, (String)"onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArray = this.subscribers.get();
        int n = publishDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            publishDisposableArray[n2].onNext(t);
            ++n2;
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.subscribers.get() != TERMINATED) return;
        disposable.dispose();
    }

    void remove(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArray;
        PublishDisposable<T>[] publishDisposableArray2;
        do {
            int n;
            if ((publishDisposableArray2 = this.subscribers.get()) == TERMINATED) return;
            if (publishDisposableArray2 == EMPTY) return;
            int n2 = publishDisposableArray2.length;
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (publishDisposableArray2[n4] == publishDisposable) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                publishDisposableArray = EMPTY;
                continue;
            }
            publishDisposableArray = new PublishDisposable[n2 - 1];
            System.arraycopy(publishDisposableArray2, 0, publishDisposableArray, 0, n);
            System.arraycopy(publishDisposableArray2, n + 1, publishDisposableArray, n, n2 - n - 1);
        } while (!this.subscribers.compareAndSet(publishDisposableArray2, publishDisposableArray));
    }

    protected void subscribeActual(Observer<? super T> observer) {
        Object object = new PublishDisposable(observer, this);
        observer.onSubscribe((Disposable)object);
        if (this.add((PublishDisposable<T>)object)) {
            if (!object.isDisposed()) return;
            this.remove((PublishDisposable<T>)object);
        } else {
            object = this.error;
            if (object != null) {
                observer.onError((Throwable)object);
            } else {
                observer.onComplete();
            }
        }
    }
}
