/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposingMaybeObserverImpl
 *  io.reactivex.CompletableSource
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposingMaybeObserverImpl;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;

final class AutoDisposeMaybe<T>
extends Maybe<T> {
    private final CompletableSource scope;
    private final MaybeSource<T> source;

    AutoDisposeMaybe(MaybeSource<T> maybeSource, CompletableSource completableSource) {
        this.source = maybeSource;
        this.scope = completableSource;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((MaybeObserver)new AutoDisposingMaybeObserverImpl(this.scope, maybeObserver));
    }
}
