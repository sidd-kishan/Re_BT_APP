/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposingSingleObserverImpl
 *  io.reactivex.CompletableSource
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposingSingleObserverImpl;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;

final class AutoDisposeSingle<T>
extends Single<T> {
    private final CompletableSource scope;
    private final SingleSource<T> source;

    AutoDisposeSingle(SingleSource<T> singleSource, CompletableSource completableSource) {
        this.source = singleSource;
        this.scope = completableSource;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((SingleObserver)new AutoDisposingSingleObserverImpl(this.scope, singleObserver));
    }
}
