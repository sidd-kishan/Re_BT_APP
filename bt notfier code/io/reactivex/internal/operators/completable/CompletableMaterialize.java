/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Notification
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.operators.mixed.MaterializeSingleObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

public final class CompletableMaterialize<T>
extends Single<Notification<T>> {
    final Completable source;

    public CompletableMaterialize(Completable completable) {
        this.source = completable;
    }

    protected void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.source.subscribe((CompletableObserver)new MaterializeSingleObserver(singleObserver));
    }
}
