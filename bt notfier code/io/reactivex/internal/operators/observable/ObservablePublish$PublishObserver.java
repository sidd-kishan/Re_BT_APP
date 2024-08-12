/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservablePublish.PublishObserver<T>
implements Observer<T>,
Disposable {
    static final ObservablePublish.InnerDisposable[] EMPTY = new ObservablePublish.InnerDisposable[0];
    static final ObservablePublish.InnerDisposable[] TERMINATED = new ObservablePublish.InnerDisposable[0];
    final AtomicReference<ObservablePublish.PublishObserver<T>> current;
    final AtomicReference<ObservablePublish.InnerDisposable<T>[]> observers;
    final AtomicBoolean shouldConnect;
    final AtomicReference<Disposable> upstream = new AtomicReference();

    ObservablePublish.PublishObserver(AtomicReference<ObservablePublish.PublishObserver<T>> atomicReference) {
        this.observers = new AtomicReference<ObservablePublish.InnerDisposable[]>(EMPTY);
        this.current = atomicReference;
        this.shouldConnect = new AtomicBoolean();
    }

    boolean add(ObservablePublish.InnerDisposable<T> innerDisposable) {
        ObservablePublish.InnerDisposable[] innerDisposableArray;
        ObservablePublish.InnerDisposable<T>[] innerDisposableArray2;
        do {
            if ((innerDisposableArray2 = this.observers.get()) == TERMINATED) {
                return false;
            }
            int n = innerDisposableArray2.length;
            innerDisposableArray = new ObservablePublish.InnerDisposable[n + 1];
            System.arraycopy(innerDisposableArray2, 0, innerDisposableArray, 0, n);
            innerDisposableArray[n] = innerDisposable;
        } while (!this.observers.compareAndSet(innerDisposableArray2, innerDisposableArray));
        return true;
    }

    public void dispose() {
        if (this.observers.getAndSet(TERMINATED) == TERMINATED) return;
        this.current.compareAndSet(this, null);
        DisposableHelper.dispose(this.upstream);
    }

    public boolean isDisposed() {
        boolean bl = this.observers.get() == TERMINATED;
        return bl;
    }

    public void onComplete() {
        this.current.compareAndSet(this, null);
        ObservablePublish.InnerDisposable[] innerDisposableArray = this.observers.getAndSet(TERMINATED);
        int n = innerDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            innerDisposableArray[n2].child.onComplete();
            ++n2;
        }
    }

    public void onError(Throwable throwable) {
        this.current.compareAndSet(this, null);
        ObservablePublish.InnerDisposable[] innerDisposableArray = this.observers.getAndSet(TERMINATED);
        if (innerDisposableArray.length == 0) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        int n = innerDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            innerDisposableArray[n2].child.onError(throwable);
            ++n2;
        }
    }

    public void onNext(T t) {
        ObservablePublish.InnerDisposable<T>[] innerDisposableArray = this.observers.get();
        int n = innerDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            innerDisposableArray[n2].child.onNext(t);
            ++n2;
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.upstream, (Disposable)disposable);
    }

    void remove(ObservablePublish.InnerDisposable<T> innerDisposable) {
        ObservablePublish.InnerDisposable[] innerDisposableArray;
        ObservablePublish.InnerDisposable<T>[] innerDisposableArray2;
        do {
            int n;
            int n2;
            if ((n2 = (innerDisposableArray2 = this.observers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (innerDisposableArray2[n4].equals(innerDisposable)) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                innerDisposableArray = EMPTY;
                continue;
            }
            innerDisposableArray = new ObservablePublish.InnerDisposable[n2 - 1];
            System.arraycopy(innerDisposableArray2, 0, innerDisposableArray, 0, n);
            System.arraycopy(innerDisposableArray2, n + 1, innerDisposableArray, n, n2 - n - 1);
        } while (!this.observers.compareAndSet(innerDisposableArray2, innerDisposableArray));
    }
}
