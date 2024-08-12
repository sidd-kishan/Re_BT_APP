/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.internal.operators.completable.CompletableHide$HideCompletableObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.internal.operators.completable.CompletableHide;

public final class CompletableHide
extends Completable {
    final CompletableSource source;

    public CompletableHide(CompletableSource completableSource) {
        this.source = completableSource;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((CompletableObserver)new HideCompletableObserver(completableObserver));
    }
}
