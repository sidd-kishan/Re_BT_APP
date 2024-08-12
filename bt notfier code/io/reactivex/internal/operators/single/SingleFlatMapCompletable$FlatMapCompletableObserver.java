/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.single;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleFlatMapCompletable.FlatMapCompletableObserver<T>
extends AtomicReference<Disposable>
implements SingleObserver<T>,
CompletableObserver,
Disposable {
    private static final long serialVersionUID = -2177128922851101253L;
    final CompletableObserver downstream;
    final Function<? super T, ? extends CompletableSource> mapper;

    SingleFlatMapCompletable.FlatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function) {
        this.downstream = completableObserver;
        this.mapper = function;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(T object) {
        try {
            object = (CompletableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null CompletableSource");
            if (this.isDisposed()) return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.onError(throwable);
            return;
        }
        object.subscribe((CompletableObserver)this);
    }
}
