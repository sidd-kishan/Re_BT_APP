/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.internal.operators.completable.CompletableAndThenCompletable$SourceObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;

public final class CompletableAndThenCompletable
extends Completable {
    final CompletableSource next;
    final CompletableSource source;

    public CompletableAndThenCompletable(CompletableSource completableSource, CompletableSource completableSource2) {
        this.source = completableSource;
        this.next = completableSource2;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((CompletableObserver)new SourceObserver(completableObserver, this.next));
    }
}
