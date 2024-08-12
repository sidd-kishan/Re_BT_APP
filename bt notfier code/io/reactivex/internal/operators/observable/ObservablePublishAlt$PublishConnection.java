/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservablePublishAlt$InnerDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservablePublishAlt.PublishConnection<T>
extends AtomicReference<ObservablePublishAlt.InnerDisposable<T>[]>
implements Observer<T>,
Disposable {
    static final ObservablePublishAlt.InnerDisposable[] EMPTY = new ObservablePublishAlt.InnerDisposable[0];
    static final ObservablePublishAlt.InnerDisposable[] TERMINATED = new ObservablePublishAlt.InnerDisposable[0];
    private static final long serialVersionUID = -3251430252873581268L;
    final AtomicBoolean connect = new AtomicBoolean();
    final AtomicReference<ObservablePublishAlt.PublishConnection<T>> current;
    Throwable error;
    final AtomicReference<Disposable> upstream;

    public ObservablePublishAlt.PublishConnection(AtomicReference<ObservablePublishAlt.PublishConnection<T>> atomicReference) {
        this.current = atomicReference;
        this.upstream = new AtomicReference();
        this.lazySet(EMPTY);
    }

    public boolean add(ObservablePublishAlt.InnerDisposable<T> innerDisposable) {
        ObservablePublishAlt.InnerDisposable[] innerDisposableArray;
        ObservablePublishAlt.InnerDisposable[] innerDisposableArray2;
        do {
            if ((innerDisposableArray2 = (ObservablePublishAlt.InnerDisposable[])this.get()) == TERMINATED) {
                return false;
            }
            int n = innerDisposableArray2.length;
            innerDisposableArray = new ObservablePublishAlt.InnerDisposable[n + 1];
            System.arraycopy(innerDisposableArray2, 0, innerDisposableArray, 0, n);
            innerDisposableArray[n] = innerDisposable;
        } while (!this.compareAndSet(innerDisposableArray2, innerDisposableArray));
        return true;
    }

    public void dispose() {
        this.getAndSet(TERMINATED);
        this.current.compareAndSet(this, null);
        DisposableHelper.dispose(this.upstream);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == TERMINATED;
        return bl;
    }

    public void onComplete() {
        this.upstream.lazySet((Disposable)DisposableHelper.DISPOSED);
        ObservablePublishAlt.InnerDisposable[] innerDisposableArray = this.getAndSet(TERMINATED);
        int n = innerDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            innerDisposableArray[n2].downstream.onComplete();
            ++n2;
        }
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.upstream.lazySet((Disposable)DisposableHelper.DISPOSED);
        ObservablePublishAlt.InnerDisposable[] innerDisposableArray = this.getAndSet(TERMINATED);
        int n = innerDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            innerDisposableArray[n2].downstream.onError(throwable);
            ++n2;
        }
    }

    public void onNext(T t) {
        ObservablePublishAlt.InnerDisposable[] innerDisposableArray = (ObservablePublishAlt.InnerDisposable[])this.get();
        int n = innerDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            innerDisposableArray[n2].downstream.onNext(t);
            ++n2;
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.upstream, (Disposable)disposable);
    }

    public void remove(ObservablePublishAlt.InnerDisposable<T> innerDisposable) {
        ObservablePublishAlt.InnerDisposable[] innerDisposableArray;
        ObservablePublishAlt.InnerDisposable[] innerDisposableArray2;
        do {
            int n;
            int n2;
            if ((n2 = (innerDisposableArray2 = (ObservablePublishAlt.InnerDisposable[])this.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (innerDisposableArray2[n4] == innerDisposable) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            innerDisposableArray = EMPTY;
            if (n2 == 1) continue;
            innerDisposableArray = new ObservablePublishAlt.InnerDisposable[n2 - 1];
            System.arraycopy(innerDisposableArray2, 0, innerDisposableArray, 0, n);
            System.arraycopy(innerDisposableArray2, n + 1, innerDisposableArray, n, n2 - n - 1);
        } while (!this.compareAndSet(innerDisposableArray2, innerDisposableArray));
    }
}
