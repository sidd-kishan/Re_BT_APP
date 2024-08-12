/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;

static final class ObservableSampleWithObservable.SamplerObserver<T>
implements Observer<Object> {
    final ObservableSampleWithObservable.SampleMainObserver<T> parent;

    ObservableSampleWithObservable.SamplerObserver(ObservableSampleWithObservable.SampleMainObserver<T> sampleMainObserver) {
        this.parent = sampleMainObserver;
    }

    public void onComplete() {
        this.parent.complete();
    }

    public void onError(Throwable throwable) {
        this.parent.error(throwable);
    }

    public void onNext(Object object) {
        this.parent.run();
    }

    public void onSubscribe(Disposable disposable) {
        this.parent.setOther(disposable);
    }
}
