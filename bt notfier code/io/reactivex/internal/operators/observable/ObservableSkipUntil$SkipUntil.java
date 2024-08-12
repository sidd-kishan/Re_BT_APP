/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.ArrayCompositeDisposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableSkipUntil
 *  io.reactivex.internal.operators.observable.ObservableSkipUntil$SkipUntilObserver
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.observers.SerializedObserver;

final class ObservableSkipUntil.SkipUntil
implements Observer<U> {
    final ArrayCompositeDisposable frc;
    final SerializedObserver<T> serial;
    final ObservableSkipUntil.SkipUntilObserver<T> sus;
    final ObservableSkipUntil this$0;
    Disposable upstream;

    ObservableSkipUntil.SkipUntil(ObservableSkipUntil observableSkipUntil, ArrayCompositeDisposable arrayCompositeDisposable, ObservableSkipUntil.SkipUntilObserver<T> skipUntilObserver, SerializedObserver<T> serializedObserver) {
        this.this$0 = observableSkipUntil;
        this.frc = arrayCompositeDisposable;
        this.sus = skipUntilObserver;
        this.serial = serializedObserver;
    }

    public void onComplete() {
        this.sus.notSkipping = true;
    }

    public void onError(Throwable throwable) {
        this.frc.dispose();
        this.serial.onError(throwable);
    }

    public void onNext(U u) {
        this.upstream.dispose();
        this.sus.notSkipping = true;
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.frc.setResource(1, disposable);
    }
}
