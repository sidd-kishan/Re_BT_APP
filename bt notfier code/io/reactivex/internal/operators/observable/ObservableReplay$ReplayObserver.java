/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable
 *  io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableReplay.ReplayObserver<T>
extends AtomicReference<Disposable>
implements Observer<T>,
Disposable {
    static final ObservableReplay.InnerDisposable[] EMPTY = new ObservableReplay.InnerDisposable[0];
    static final ObservableReplay.InnerDisposable[] TERMINATED = new ObservableReplay.InnerDisposable[0];
    private static final long serialVersionUID = -533785617179540163L;
    final ObservableReplay.ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ObservableReplay.InnerDisposable[]> observers;
    final AtomicBoolean shouldConnect;

    ObservableReplay.ReplayObserver(ObservableReplay.ReplayBuffer<T> replayBuffer) {
        this.buffer = replayBuffer;
        this.observers = new AtomicReference<ObservableReplay.InnerDisposable[]>(EMPTY);
        this.shouldConnect = new AtomicBoolean();
    }

    boolean add(ObservableReplay.InnerDisposable<T> innerDisposable) {
        ObservableReplay.InnerDisposable[] innerDisposableArray;
        ObservableReplay.InnerDisposable[] innerDisposableArray2;
        do {
            if ((innerDisposableArray2 = this.observers.get()) == TERMINATED) {
                return false;
            }
            int n = innerDisposableArray2.length;
            innerDisposableArray = new ObservableReplay.InnerDisposable[n + 1];
            System.arraycopy(innerDisposableArray2, 0, innerDisposableArray, 0, n);
            innerDisposableArray[n] = innerDisposable;
        } while (!this.observers.compareAndSet(innerDisposableArray2, innerDisposableArray));
        return true;
    }

    public void dispose() {
        this.observers.set(TERMINATED);
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.observers.get() == TERMINATED;
        return bl;
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        this.buffer.complete();
        this.replayFinal();
    }

    public void onError(Throwable throwable) {
        if (!this.done) {
            this.done = true;
            this.buffer.error(throwable);
            this.replayFinal();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (this.done) return;
        this.buffer.next(t);
        this.replay();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        this.replay();
    }

    void remove(ObservableReplay.InnerDisposable<T> innerDisposable) {
        ObservableReplay.InnerDisposable[] innerDisposableArray;
        ObservableReplay.InnerDisposable[] innerDisposableArray2;
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
            innerDisposableArray = new ObservableReplay.InnerDisposable[n2 - 1];
            System.arraycopy(innerDisposableArray2, 0, innerDisposableArray, 0, n);
            System.arraycopy(innerDisposableArray2, n + 1, innerDisposableArray, n, n2 - n - 1);
        } while (!this.observers.compareAndSet(innerDisposableArray2, innerDisposableArray));
    }

    void replay() {
        ObservableReplay.InnerDisposable[] innerDisposableArray = this.observers.get();
        int n = innerDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            ObservableReplay.InnerDisposable innerDisposable = innerDisposableArray[n2];
            this.buffer.replay(innerDisposable);
            ++n2;
        }
    }

    void replayFinal() {
        ObservableReplay.InnerDisposable[] innerDisposableArray = this.observers.getAndSet(TERMINATED);
        int n = innerDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            ObservableReplay.InnerDisposable innerDisposable = innerDisposableArray[n2];
            this.buffer.replay(innerDisposable);
            ++n2;
        }
    }
}
