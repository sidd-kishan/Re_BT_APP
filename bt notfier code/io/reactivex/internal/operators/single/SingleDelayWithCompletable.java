/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.single.SingleDelayWithCompletable$OtherObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;

public final class SingleDelayWithCompletable<T>
extends Single<T> {
    final CompletableSource other;
    final SingleSource<T> source;

    public SingleDelayWithCompletable(SingleSource<T> singleSource, CompletableSource completableSource) {
        this.source = singleSource;
        this.other = completableSource;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.other.subscribe((CompletableObserver)new OtherObserver(singleObserver, this.source));
    }
}
