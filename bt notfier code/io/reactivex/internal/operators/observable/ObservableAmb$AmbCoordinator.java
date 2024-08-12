/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableAmb$AmbInnerObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableAmb;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableAmb.AmbCoordinator<T>
implements Disposable {
    final Observer<? super T> downstream;
    final ObservableAmb.AmbInnerObserver<T>[] observers;
    final AtomicInteger winner = new AtomicInteger();

    ObservableAmb.AmbCoordinator(Observer<? super T> observer, int n) {
        this.downstream = observer;
        this.observers = new ObservableAmb.AmbInnerObserver[n];
    }

    public void dispose() {
        if (this.winner.get() == -1) return;
        this.winner.lazySet(-1);
        ObservableAmb.AmbInnerObserver<T>[] ambInnerObserverArray = this.observers;
        int n = ambInnerObserverArray.length;
        int n2 = 0;
        while (n2 < n) {
            ambInnerObserverArray[n2].dispose();
            ++n2;
        }
    }

    public boolean isDisposed() {
        boolean bl = this.winner.get() == -1;
        return bl;
    }

    public void subscribe(ObservableSource<? extends T>[] observableSourceArray) {
        ObservableAmb.AmbInnerObserver<T>[] ambInnerObserverArray = this.observers;
        int n = ambInnerObserverArray.length;
        int n2 = 0;
        int n3 = 0;
        while (n3 < n) {
            int n4 = n3 + 1;
            ambInnerObserverArray[n3] = new ObservableAmb.AmbInnerObserver(this, n4, this.downstream);
            n3 = n4;
        }
        this.winner.lazySet(0);
        this.downstream.onSubscribe((Disposable)this);
        n3 = n2;
        while (n3 < n) {
            if (this.winner.get() != 0) {
                return;
            }
            observableSourceArray[n3].subscribe(ambInnerObserverArray[n3]);
            ++n3;
        }
    }

    public boolean win(int n) {
        int n2 = this.winner.get();
        boolean bl = true;
        int n3 = 0;
        if (n2 == 0) {
            if (!this.winner.compareAndSet(0, n)) return false;
            ObservableAmb.AmbInnerObserver<T>[] ambInnerObserverArray = this.observers;
            int n4 = ambInnerObserverArray.length;
            while (n3 < n4) {
                n2 = n3 + 1;
                if (n2 != n) {
                    ambInnerObserverArray[n3].dispose();
                }
                n3 = n2;
            }
            return true;
        }
        if (n2 == n) return bl;
        bl = false;
        return bl;
    }
}
