/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.completable.CompletableConcatArray$ConcatInnerObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.completable.CompletableConcatArray;

public final class CompletableConcatArray
extends Completable {
    final CompletableSource[] sources;

    public CompletableConcatArray(CompletableSource[] completableSourceArray) {
        this.sources = completableSourceArray;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, this.sources);
        completableObserver.onSubscribe((Disposable)concatInnerObserver.sd);
        concatInnerObserver.next();
    }
}
