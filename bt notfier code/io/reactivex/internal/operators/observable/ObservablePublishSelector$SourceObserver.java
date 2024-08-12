/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.subjects.PublishSubject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservablePublishSelector.SourceObserver<T, R>
implements Observer<T> {
    final PublishSubject<T> subject;
    final AtomicReference<Disposable> target;

    ObservablePublishSelector.SourceObserver(PublishSubject<T> publishSubject, AtomicReference<Disposable> atomicReference) {
        this.subject = publishSubject;
        this.target = atomicReference;
    }

    public void onComplete() {
        this.subject.onComplete();
    }

    public void onError(Throwable throwable) {
        this.subject.onError(throwable);
    }

    public void onNext(T t) {
        this.subject.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.target, (Disposable)disposable);
    }
}
