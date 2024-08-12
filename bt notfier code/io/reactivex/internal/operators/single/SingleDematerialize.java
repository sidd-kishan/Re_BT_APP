/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Notification
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.single.SingleDematerialize$DematerializeObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.single.SingleDematerialize;

public final class SingleDematerialize<T, R>
extends Maybe<R> {
    final Function<? super T, Notification<R>> selector;
    final Single<T> source;

    public SingleDematerialize(Single<T> single, Function<? super T, Notification<R>> function) {
        this.source = single;
        this.selector = function;
    }

    protected void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe((SingleObserver)new DematerializeObserver(maybeObserver, this.selector));
    }
}
