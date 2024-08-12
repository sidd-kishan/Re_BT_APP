/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.SingleSubject$SingleDisposable
 */
package io.reactivex.subjects;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.SingleSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubject<T>
extends Single<T>
implements SingleObserver<T> {
    static final SingleDisposable[] EMPTY = new SingleDisposable[0];
    static final SingleDisposable[] TERMINATED = new SingleDisposable[0];
    Throwable error;
    final AtomicReference<SingleDisposable<T>[]> observers;
    final AtomicBoolean once = new AtomicBoolean();
    T value;

    SingleSubject() {
        this.observers = new AtomicReference<SingleDisposable[]>(EMPTY);
    }

    @CheckReturnValue
    public static <T> SingleSubject<T> create() {
        return new SingleSubject<T>();
    }

    boolean add(SingleDisposable<T> singleDisposable) {
        SingleDisposable[] singleDisposableArray;
        SingleDisposable<T>[] singleDisposableArray2;
        do {
            if ((singleDisposableArray2 = this.observers.get()) == TERMINATED) {
                return false;
            }
            int n = singleDisposableArray2.length;
            singleDisposableArray = new SingleDisposable[n + 1];
            System.arraycopy(singleDisposableArray2, 0, singleDisposableArray, 0, n);
            singleDisposableArray[n] = singleDisposable;
        } while (!this.observers.compareAndSet(singleDisposableArray2, singleDisposableArray));
        return true;
    }

    public Throwable getThrowable() {
        if (this.observers.get() != TERMINATED) return null;
        return this.error;
    }

    public T getValue() {
        if (this.observers.get() != TERMINATED) return null;
        return this.value;
    }

    public boolean hasObservers() {
        boolean bl = this.observers.get().length != 0;
        return bl;
    }

    public boolean hasThrowable() {
        boolean bl = this.observers.get() == TERMINATED && this.error != null;
        return bl;
    }

    public boolean hasValue() {
        boolean bl = this.observers.get() == TERMINATED && this.value != null;
        return bl;
    }

    int observerCount() {
        return this.observers.get().length;
    }

    public void onError(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        SingleDisposable[] singleDisposableArray = this.once;
        int n = 0;
        if (!singleDisposableArray.compareAndSet(false, true)) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        singleDisposableArray = this.observers.getAndSet(TERMINATED);
        int n2 = singleDisposableArray.length;
        while (n < n2) {
            singleDisposableArray[n].downstream.onError(throwable);
            ++n;
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.observers.get() != TERMINATED) return;
        disposable.dispose();
    }

    public void onSuccess(T t) {
        ObjectHelper.requireNonNull(t, (String)"onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        SingleDisposable[] singleDisposableArray = this.once;
        int n = 0;
        if (!singleDisposableArray.compareAndSet(false, true)) return;
        this.value = t;
        singleDisposableArray = this.observers.getAndSet(TERMINATED);
        int n2 = singleDisposableArray.length;
        while (n < n2) {
            singleDisposableArray[n].downstream.onSuccess(t);
            ++n;
        }
    }

    void remove(SingleDisposable<T> singleDisposable) {
        SingleDisposable[] singleDisposableArray;
        SingleDisposable<T>[] singleDisposableArray2;
        do {
            int n;
            int n2;
            if ((n2 = (singleDisposableArray2 = this.observers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (singleDisposableArray2[n4] == singleDisposable) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                singleDisposableArray = EMPTY;
                continue;
            }
            singleDisposableArray = new SingleDisposable[n2 - 1];
            System.arraycopy(singleDisposableArray2, 0, singleDisposableArray, 0, n);
            System.arraycopy(singleDisposableArray2, n + 1, singleDisposableArray, n, n2 - n - 1);
        } while (!this.observers.compareAndSet(singleDisposableArray2, singleDisposableArray));
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        Object object = new SingleDisposable(singleObserver, this);
        singleObserver.onSubscribe((Disposable)object);
        if (this.add((SingleDisposable<T>)object)) {
            if (!object.isDisposed()) return;
            this.remove((SingleDisposable<T>)object);
        } else {
            object = this.error;
            if (object != null) {
                singleObserver.onError((Throwable)object);
            } else {
                singleObserver.onSuccess(this.value);
            }
        }
    }
}
