/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Notification
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.single;

import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

static final class SingleDematerialize.DematerializeObserver<T, R>
implements SingleObserver<T>,
Disposable {
    final MaybeObserver<? super R> downstream;
    final Function<? super T, Notification<R>> selector;
    Disposable upstream;

    SingleDematerialize.DematerializeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, Notification<R>> function) {
        this.downstream = maybeObserver;
        this.selector = function;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T object) {
        try {
            object = (Notification)ObjectHelper.requireNonNull((Object)this.selector.apply(object), (String)"The selector returned a null Notification");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        if (object.isOnNext()) {
            this.downstream.onSuccess(object.getValue());
        } else if (object.isOnComplete()) {
            this.downstream.onComplete();
        } else {
            this.downstream.onError(object.getError());
        }
    }
}
