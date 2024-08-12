/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.EmptyDisposable
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class MaybeNever
extends Maybe<Object> {
    public static final MaybeNever INSTANCE = new MaybeNever();

    protected void subscribeActual(MaybeObserver<? super Object> maybeObserver) {
        maybeObserver.onSubscribe((Disposable)EmptyDisposable.NEVER);
    }
}
