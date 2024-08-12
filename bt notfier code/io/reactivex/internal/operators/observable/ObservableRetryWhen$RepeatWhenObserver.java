/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableRetryWhen$RepeatWhenObserver$InnerRepeatObserver
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.HalfSerializer
 *  io.reactivex.subjects.Subject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableRetryWhen.RepeatWhenObserver<T>
extends AtomicInteger
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = 802743776666017014L;
    volatile boolean active;
    final Observer<? super T> downstream;
    final AtomicThrowable error;
    final InnerRepeatObserver inner;
    final Subject<Throwable> signaller;
    final ObservableSource<T> source;
    final AtomicReference<Disposable> upstream;
    final AtomicInteger wip;

    ObservableRetryWhen.RepeatWhenObserver(Observer<? super T> observer, Subject<Throwable> subject, ObservableSource<T> observableSource) {
        this.downstream = observer;
        this.signaller = subject;
        this.source = observableSource;
        this.wip = new AtomicInteger();
        this.error = new AtomicThrowable();
        this.inner = new InnerRepeatObserver(this);
        this.upstream = new AtomicReference();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose((AtomicReference)this.inner);
    }

    void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    void innerError(Throwable throwable) {
        DisposableHelper.dispose(this.upstream);
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    void innerNext() {
        this.subscribeNext();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)this.upstream.get());
    }

    public void onComplete() {
        DisposableHelper.dispose((AtomicReference)this.inner);
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onError(Throwable throwable) {
        DisposableHelper.replace(this.upstream, null);
        this.active = false;
        this.signaller.onNext((Object)throwable);
    }

    public void onNext(T t) {
        HalfSerializer.onNext(this.downstream, t, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.upstream, (Disposable)disposable);
    }

    void subscribeNext() {
        if (this.wip.getAndIncrement() != 0) return;
        do {
            if (this.isDisposed()) {
                return;
            }
            if (this.active) continue;
            this.active = true;
            this.source.subscribe((Observer)this);
        } while (this.wip.decrementAndGet() != 0);
    }
}
