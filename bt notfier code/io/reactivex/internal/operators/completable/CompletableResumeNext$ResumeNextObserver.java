/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableResumeNext.ResumeNextObserver
extends AtomicReference<Disposable>
implements CompletableObserver,
Disposable {
    private static final long serialVersionUID = 5018523762564524046L;
    final CompletableObserver downstream;
    final Function<? super Throwable, ? extends CompletableSource> errorMapper;
    boolean once;

    CompletableResumeNext.ResumeNextObserver(CompletableObserver completableObserver, Function<? super Throwable, ? extends CompletableSource> function) {
        this.downstream = completableObserver;
        this.errorMapper = function;
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
        CompletableSource completableSource;
        if (this.once) {
            this.downstream.onError(throwable);
            return;
        }
        this.once = true;
        try {
            completableSource = (CompletableSource)ObjectHelper.requireNonNull((Object)this.errorMapper.apply((Object)throwable), (String)"The errorMapper returned a null CompletableSource");
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
            return;
        }
        completableSource.subscribe((CompletableObserver)this);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
    }
}
