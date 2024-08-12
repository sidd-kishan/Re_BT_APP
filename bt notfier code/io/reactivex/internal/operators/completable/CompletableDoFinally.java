/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.operators.completable.CompletableDoFinally$DoFinallyObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.completable.CompletableDoFinally;

public final class CompletableDoFinally
extends Completable {
    final Action onFinally;
    final CompletableSource source;

    public CompletableDoFinally(CompletableSource completableSource, Action action) {
        this.source = completableSource;
        this.onFinally = action;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((CompletableObserver)new DoFinallyObserver(completableObserver, this.onFinally));
    }
}
