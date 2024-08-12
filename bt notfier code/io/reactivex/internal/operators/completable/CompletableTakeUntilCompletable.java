/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable$TakeUntilMainObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable;

public final class CompletableTakeUntilCompletable
extends Completable {
    final CompletableSource other;
    final Completable source;

    public CompletableTakeUntilCompletable(Completable completable, CompletableSource completableSource) {
        this.source = completable;
        this.other = completableSource;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(completableObserver);
        completableObserver.onSubscribe((Disposable)takeUntilMainObserver);
        this.other.subscribe((CompletableObserver)takeUntilMainObserver.other);
        this.source.subscribe((CompletableObserver)takeUntilMainObserver);
    }
}
