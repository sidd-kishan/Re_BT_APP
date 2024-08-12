/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeOperator
 *  io.reactivex.MaybeSource
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOperator;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;

public final class MaybeLift<T, R>
extends AbstractMaybeWithUpstream<T, R> {
    final MaybeOperator<? extends R, ? super T> operator;

    public MaybeLift(MaybeSource<T> maybeSource, MaybeOperator<? extends R, ? super T> maybeOperator) {
        super(maybeSource);
        this.operator = maybeOperator;
    }

    protected void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeObserver maybeObserver2;
        try {
            maybeObserver2 = (MaybeObserver)ObjectHelper.requireNonNull((Object)this.operator.apply(maybeObserver), (String)"The operator returned a null MaybeObserver");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, maybeObserver);
            return;
        }
        this.source.subscribe(maybeObserver2);
    }
}
