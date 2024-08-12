/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Notification
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.operators.mixed.MaterializeSingleObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

public final class MaybeMaterialize<T>
extends Single<Notification<T>> {
    final Maybe<T> source;

    public MaybeMaterialize(Maybe<T> maybe) {
        this.source = maybe;
    }

    protected void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.source.subscribe((MaybeObserver)new MaterializeSingleObserver(singleObserver));
    }
}
