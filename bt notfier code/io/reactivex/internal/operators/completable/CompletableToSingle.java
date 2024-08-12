/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.operators.completable.CompletableToSingle$ToSingle
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.operators.completable.CompletableToSingle;
import java.util.concurrent.Callable;

public final class CompletableToSingle<T>
extends Single<T> {
    final T completionValue;
    final Callable<? extends T> completionValueSupplier;
    final CompletableSource source;

    public CompletableToSingle(CompletableSource completableSource, Callable<? extends T> callable, T t) {
        this.source = completableSource;
        this.completionValue = t;
        this.completionValueSupplier = callable;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((CompletableObserver)new ToSingle(this, singleObserver));
    }
}
