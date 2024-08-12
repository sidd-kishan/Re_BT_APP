/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.internal.disposables.EmptyDisposable
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class CompletableError
extends Completable {
    final Throwable error;

    public CompletableError(Throwable throwable) {
        this.error = throwable;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.error((Throwable)this.error, (CompletableObserver)completableObserver);
    }
}
