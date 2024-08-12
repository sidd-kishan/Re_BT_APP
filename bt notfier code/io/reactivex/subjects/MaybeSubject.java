/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.MaybeSubject$MaybeDisposable
 */
package io.reactivex.subjects;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.MaybeSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubject<T>
extends Maybe<T>
implements MaybeObserver<T> {
    static final MaybeDisposable[] EMPTY = new MaybeDisposable[0];
    static final MaybeDisposable[] TERMINATED = new MaybeDisposable[0];
    Throwable error;
    final AtomicReference<MaybeDisposable<T>[]> observers;
    final AtomicBoolean once = new AtomicBoolean();
    T value;

    MaybeSubject() {
        this.observers = new AtomicReference<MaybeDisposable[]>(EMPTY);
    }

    @CheckReturnValue
    public static <T> MaybeSubject<T> create() {
        return new MaybeSubject<T>();
    }

    boolean add(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable[] maybeDisposableArray;
        MaybeDisposable<T>[] maybeDisposableArray2;
        do {
            if ((maybeDisposableArray2 = this.observers.get()) == TERMINATED) {
                return false;
            }
            int n = maybeDisposableArray2.length;
            maybeDisposableArray = new MaybeDisposable[n + 1];
            System.arraycopy(maybeDisposableArray2, 0, maybeDisposableArray, 0, n);
            maybeDisposableArray[n] = maybeDisposable;
        } while (!this.observers.compareAndSet(maybeDisposableArray2, maybeDisposableArray));
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

    public boolean hasComplete() {
        boolean bl = this.observers.get() == TERMINATED && this.value == null && this.error == null;
        return bl;
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

    public void onComplete() {
        MaybeDisposable[] maybeDisposableArray = this.once;
        int n = 0;
        if (!maybeDisposableArray.compareAndSet(false, true)) return;
        maybeDisposableArray = this.observers.getAndSet(TERMINATED);
        int n2 = maybeDisposableArray.length;
        while (n < n2) {
            maybeDisposableArray[n].downstream.onComplete();
            ++n;
        }
    }

    public void onError(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        MaybeDisposable[] maybeDisposableArray = this.once;
        int n = 0;
        if (!maybeDisposableArray.compareAndSet(false, true)) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        maybeDisposableArray = this.observers.getAndSet(TERMINATED);
        int n2 = maybeDisposableArray.length;
        while (n < n2) {
            maybeDisposableArray[n].downstream.onError(throwable);
            ++n;
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.observers.get() != TERMINATED) return;
        disposable.dispose();
    }

    public void onSuccess(T t) {
        ObjectHelper.requireNonNull(t, (String)"onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        MaybeDisposable[] maybeDisposableArray = this.once;
        int n = 0;
        if (!maybeDisposableArray.compareAndSet(false, true)) return;
        this.value = t;
        maybeDisposableArray = this.observers.getAndSet(TERMINATED);
        int n2 = maybeDisposableArray.length;
        while (n < n2) {
            maybeDisposableArray[n].downstream.onSuccess(t);
            ++n;
        }
    }

    void remove(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable[] maybeDisposableArray;
        MaybeDisposable<T>[] maybeDisposableArray2;
        do {
            int n;
            int n2;
            if ((n2 = (maybeDisposableArray2 = this.observers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (maybeDisposableArray2[n4] == maybeDisposable) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                maybeDisposableArray = EMPTY;
                continue;
            }
            maybeDisposableArray = new MaybeDisposable[n2 - 1];
            System.arraycopy(maybeDisposableArray2, 0, maybeDisposableArray, 0, n);
            System.arraycopy(maybeDisposableArray2, n + 1, maybeDisposableArray, n, n2 - n - 1);
        } while (!this.observers.compareAndSet(maybeDisposableArray2, maybeDisposableArray));
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Object object = new MaybeDisposable(maybeObserver, this);
        maybeObserver.onSubscribe((Disposable)object);
        if (this.add((MaybeDisposable<T>)object)) {
            if (!object.isDisposed()) return;
            this.remove((MaybeDisposable<T>)object);
        } else {
            object = this.error;
            if (object != null) {
                maybeObserver.onError((Throwable)object);
            } else {
                object = this.value;
                if (object == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(object);
                }
            }
        }
    }
}
