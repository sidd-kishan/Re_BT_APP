/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Notification
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.operators.mixed.MaterializeSingleObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

public final class SingleMaterialize<T>
extends Single<Notification<T>> {
    final Single<T> source;

    public SingleMaterialize(Single<T> single) {
        this.source = single;
    }

    protected void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.source.subscribe((SingleObserver)new MaterializeSingleObserver(singleObserver));
    }
}
