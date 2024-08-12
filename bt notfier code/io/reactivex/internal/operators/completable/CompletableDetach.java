/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.internal.operators.completable.CompletableDetach$DetachCompletableObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.internal.operators.completable.CompletableDetach;

public final class CompletableDetach
extends Completable {
    final CompletableSource source;

    public CompletableDetach(CompletableSource completableSource) {
        this.source = completableSource;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((CompletableObserver)new DetachCompletableObserver(completableObserver));
    }
}
