/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.CompletableSubject$CompletableDisposable
 */
package io.reactivex.subjects;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.CompletableSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubject
extends Completable
implements CompletableObserver {
    static final CompletableDisposable[] EMPTY = new CompletableDisposable[0];
    static final CompletableDisposable[] TERMINATED = new CompletableDisposable[0];
    Throwable error;
    final AtomicReference<CompletableDisposable[]> observers;
    final AtomicBoolean once = new AtomicBoolean();

    CompletableSubject() {
        this.observers = new AtomicReference<CompletableDisposable[]>(EMPTY);
    }

    @CheckReturnValue
    public static CompletableSubject create() {
        return new CompletableSubject();
    }

    boolean add(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArray;
        CompletableDisposable[] completableDisposableArray2;
        do {
            if ((completableDisposableArray2 = this.observers.get()) == TERMINATED) {
                return false;
            }
            int n = completableDisposableArray2.length;
            completableDisposableArray = new CompletableDisposable[n + 1];
            System.arraycopy(completableDisposableArray2, 0, completableDisposableArray, 0, n);
            completableDisposableArray[n] = completableDisposable;
        } while (!this.observers.compareAndSet(completableDisposableArray2, completableDisposableArray));
        return true;
    }

    public Throwable getThrowable() {
        if (this.observers.get() != TERMINATED) return null;
        return this.error;
    }

    public boolean hasComplete() {
        boolean bl = this.observers.get() == TERMINATED && this.error == null;
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

    int observerCount() {
        return this.observers.get().length;
    }

    public void onComplete() {
        CompletableDisposable[] completableDisposableArray = this.once;
        int n = 0;
        if (!completableDisposableArray.compareAndSet(false, true)) return;
        completableDisposableArray = this.observers.getAndSet(TERMINATED);
        int n2 = completableDisposableArray.length;
        while (n < n2) {
            completableDisposableArray[n].downstream.onComplete();
            ++n;
        }
    }

    public void onError(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        CompletableDisposable[] completableDisposableArray = this.once;
        int n = 0;
        if (!completableDisposableArray.compareAndSet(false, true)) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        completableDisposableArray = this.observers.getAndSet(TERMINATED);
        int n2 = completableDisposableArray.length;
        while (n < n2) {
            completableDisposableArray[n].downstream.onError(throwable);
            ++n;
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.observers.get() != TERMINATED) return;
        disposable.dispose();
    }

    void remove(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArray;
        CompletableDisposable[] completableDisposableArray2;
        do {
            int n;
            int n2;
            if ((n2 = (completableDisposableArray2 = this.observers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (completableDisposableArray2[n4] == completableDisposable) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                completableDisposableArray = EMPTY;
                continue;
            }
            completableDisposableArray = new CompletableDisposable[n2 - 1];
            System.arraycopy(completableDisposableArray2, 0, completableDisposableArray, 0, n);
            System.arraycopy(completableDisposableArray2, n + 1, completableDisposableArray, n, n2 - n - 1);
        } while (!this.observers.compareAndSet(completableDisposableArray2, completableDisposableArray));
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        Object object = new CompletableDisposable(completableObserver, this);
        completableObserver.onSubscribe((Disposable)object);
        if (this.add((CompletableDisposable)object)) {
            if (!object.isDisposed()) return;
            this.remove((CompletableDisposable)object);
        } else {
            object = this.error;
            if (object != null) {
                completableObserver.onError((Throwable)object);
            } else {
                completableObserver.onComplete();
            }
        }
    }
}
