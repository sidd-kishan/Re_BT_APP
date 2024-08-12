/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.operators.completable.CompletableOnErrorComplete$OnError
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;

public final class CompletableOnErrorComplete
extends Completable {
    final Predicate<? super Throwable> predicate;
    final CompletableSource source;

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.source = completableSource;
        this.predicate = predicate;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((CompletableObserver)new OnError(this, completableObserver));
    }
}
