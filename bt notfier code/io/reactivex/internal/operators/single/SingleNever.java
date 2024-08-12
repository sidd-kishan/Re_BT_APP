/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.EmptyDisposable
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class SingleNever
extends Single<Object> {
    public static final Single<Object> INSTANCE = new SingleNever();

    private SingleNever() {
    }

    protected void subscribeActual(SingleObserver<? super Object> singleObserver) {
        singleObserver.onSubscribe((Disposable)EmptyDisposable.NEVER);
    }
}
