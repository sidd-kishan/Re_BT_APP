/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableAmb$AmbCoordinator
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableAmb.AmbInnerObserver<T>
extends AtomicReference<Disposable>
implements Observer<T> {
    private static final long serialVersionUID = -1185974347409665484L;
    final Observer<? super T> downstream;
    final int index;
    final ObservableAmb.AmbCoordinator<T> parent;
    boolean won;

    ObservableAmb.AmbInnerObserver(ObservableAmb.AmbCoordinator<T> ambCoordinator, int n, Observer<? super T> observer) {
        this.parent = ambCoordinator;
        this.index = n;
        this.downstream = observer;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onComplete() {
        if (this.won) {
            this.downstream.onComplete();
        } else {
            if (!this.parent.win(this.index)) return;
            this.won = true;
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        if (this.won) {
            this.downstream.onError(throwable);
        } else if (this.parent.win(this.index)) {
            this.won = true;
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (this.won) {
            this.downstream.onNext(t);
        } else if (this.parent.win(this.index)) {
            this.won = true;
            this.downstream.onNext(t);
        } else {
            ((Disposable)this.get()).dispose();
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
