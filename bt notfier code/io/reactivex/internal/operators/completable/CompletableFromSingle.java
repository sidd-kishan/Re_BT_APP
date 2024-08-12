/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.completable.CompletableFromSingle$CompletableFromSingleObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.completable.CompletableFromSingle;

public final class CompletableFromSingle<T>
extends Completable {
    final SingleSource<T> single;

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.single = singleSource;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.single.subscribe((SingleObserver)new CompletableFromSingleObserver(completableObserver));
    }
}
