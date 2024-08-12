/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposingCompletableObserverImpl
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposingCompletableObserverImpl;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;

final class AutoDisposeCompletable
extends Completable {
    private final CompletableSource scope;
    private final Completable source;

    AutoDisposeCompletable(Completable completable, CompletableSource completableSource) {
        this.source = completable;
        this.scope = completableSource;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((CompletableObserver)new AutoDisposingCompletableObserverImpl(this.scope, completableObserver));
    }
}
