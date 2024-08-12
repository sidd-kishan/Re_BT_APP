/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.operators.completable.CompletableDoOnEvent$DoOnEvent
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.completable.CompletableDoOnEvent;

public final class CompletableDoOnEvent
extends Completable {
    final Consumer<? super Throwable> onEvent;
    final CompletableSource source;

    public CompletableDoOnEvent(CompletableSource completableSource, Consumer<? super Throwable> consumer) {
        this.source = completableSource;
        this.onEvent = consumer;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((CompletableObserver)new DoOnEvent(this, completableObserver));
    }
}
