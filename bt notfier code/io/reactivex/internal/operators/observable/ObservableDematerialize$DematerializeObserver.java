/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Notification
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

static final class ObservableDematerialize.DematerializeObserver<T, R>
implements Observer<T>,
Disposable {
    boolean done;
    final Observer<? super R> downstream;
    final Function<? super T, ? extends Notification<R>> selector;
    Disposable upstream;

    ObservableDematerialize.DematerializeObserver(Observer<? super R> observer, Function<? super T, ? extends Notification<R>> function) {
        this.downstream = observer;
        this.selector = function;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(T object) {
        if (this.done) {
            if (!(object instanceof Notification)) return;
            if (!(object = (Notification)object).isOnError()) return;
            RxJavaPlugins.onError((Throwable)object.getError());
            return;
        }
        try {
            object = (Notification)ObjectHelper.requireNonNull((Object)this.selector.apply(object), (String)"The selector returned a null Notification");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.dispose();
            this.onError(throwable);
            return;
        }
        if (object.isOnError()) {
            this.upstream.dispose();
            this.onError(object.getError());
        } else if (object.isOnComplete()) {
            this.upstream.dispose();
            this.onComplete();
        } else {
            this.downstream.onNext(object.getValue());
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
