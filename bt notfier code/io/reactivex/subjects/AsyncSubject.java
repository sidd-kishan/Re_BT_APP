/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.AsyncSubject$AsyncDisposable
 *  io.reactivex.subjects.Subject
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.Subject;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class AsyncSubject<T>
extends Subject<T> {
    static final AsyncDisposable[] EMPTY = new AsyncDisposable[0];
    static final AsyncDisposable[] TERMINATED = new AsyncDisposable[0];
    Throwable error;
    final AtomicReference<AsyncDisposable<T>[]> subscribers = new AtomicReference<AsyncDisposable[]>(EMPTY);
    T value;

    AsyncSubject() {
    }

    @CheckReturnValue
    public static <T> AsyncSubject<T> create() {
        return new AsyncSubject<T>();
    }

    boolean add(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable[] asyncDisposableArray;
        AsyncDisposable<T>[] asyncDisposableArray2;
        do {
            if ((asyncDisposableArray2 = this.subscribers.get()) == TERMINATED) {
                return false;
            }
            int n = asyncDisposableArray2.length;
            asyncDisposableArray = new AsyncDisposable[n + 1];
            System.arraycopy(asyncDisposableArray2, 0, asyncDisposableArray, 0, n);
            asyncDisposableArray[n] = asyncDisposable;
        } while (!this.subscribers.compareAndSet(asyncDisposableArray2, asyncDisposableArray));
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

    public boolean hasObservers() {
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
        AsyncDisposable[] asyncDisposableArray;
        Object object = this.subscribers.get();
        if (object == (asyncDisposableArray = TERMINATED)) {
            return;
        }
        object = this.value;
        asyncDisposableArray = this.subscribers.getAndSet(asyncDisposableArray);
        int n = 0;
        int n2 = 0;
        if (object == null) {
            int n3 = asyncDisposableArray.length;
            n = n2;
            while (n < n3) {
                asyncDisposableArray[n].onComplete();
                ++n;
            }
            return;
        }
        n2 = asyncDisposableArray.length;
        while (n < n2) {
            asyncDisposableArray[n].complete(object);
            ++n;
        }
    }

    public void onError(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncDisposable<T>[] asyncDisposableArray = this.subscribers.get();
        AsyncDisposable[] asyncDisposableArray2 = TERMINATED;
        if (asyncDisposableArray == asyncDisposableArray2) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.value = null;
        this.error = throwable;
        asyncDisposableArray = this.subscribers.getAndSet(asyncDisposableArray2);
        int n = asyncDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            asyncDisposableArray[n2].onError(throwable);
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

    public void onSubscribe(Disposable disposable) {
        if (this.subscribers.get() != TERMINATED) return;
        disposable.dispose();
    }

    void remove(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable[] asyncDisposableArray;
        AsyncDisposable<T>[] asyncDisposableArray2;
        do {
            int n;
            int n2;
            if ((n2 = (asyncDisposableArray2 = this.subscribers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (asyncDisposableArray2[n4] == asyncDisposable) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                asyncDisposableArray = EMPTY;
                continue;
            }
            asyncDisposableArray = new AsyncDisposable[n2 - 1];
            System.arraycopy(asyncDisposableArray2, 0, asyncDisposableArray, 0, n);
            System.arraycopy(asyncDisposableArray2, n + 1, asyncDisposableArray, n, n2 - n - 1);
        } while (!this.subscribers.compareAndSet(asyncDisposableArray2, asyncDisposableArray));
    }

    protected void subscribeActual(Observer<? super T> object) {
        AsyncDisposable asyncDisposable = new AsyncDisposable(object, this);
        object.onSubscribe((Disposable)asyncDisposable);
        if (this.add(asyncDisposable)) {
            if (!asyncDisposable.isDisposed()) return;
            this.remove(asyncDisposable);
        } else {
            Throwable throwable = this.error;
            if (throwable != null) {
                object.onError(throwable);
            } else {
                object = this.value;
                if (object != null) {
                    asyncDisposable.complete(object);
                } else {
                    asyncDisposable.onComplete();
                }
            }
        }
    }
}
