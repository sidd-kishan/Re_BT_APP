/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableConcatMap.ConcatMapDelayErrorObserver.DelayErrorInnerObserver<R>
extends AtomicReference<Disposable>
implements Observer<R> {
    private static final long serialVersionUID = 2620149119579502636L;
    final Observer<? super R> downstream;
    final ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> parent;

    ObservableConcatMap.ConcatMapDelayErrorObserver.DelayErrorInnerObserver(Observer<? super R> observer, ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
        this.downstream = observer;
        this.parent = concatMapDelayErrorObserver;
    }

    void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onComplete() {
        ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
        concatMapDelayErrorObserver.active = false;
        concatMapDelayErrorObserver.drain();
    }

    public void onError(Throwable throwable) {
        ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
        if (concatMapDelayErrorObserver.error.addThrowable(throwable)) {
            if (!concatMapDelayErrorObserver.tillTheEnd) {
                concatMapDelayErrorObserver.upstream.dispose();
            }
            concatMapDelayErrorObserver.active = false;
            concatMapDelayErrorObserver.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(R r) {
        this.downstream.onNext(r);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
    }
}
