/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable$ConcatMapCompletableObserver
 *  io.reactivex.internal.operators.mixed.ScalarXMapZHelper
 *  io.reactivex.internal.util.ErrorMode
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ScalarXMapZHelper;
import io.reactivex.internal.util.ErrorMode;

public final class ObservableConcatMapCompletable<T>
extends Completable {
    final ErrorMode errorMode;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int prefetch;
    final Observable<T> source;

    public ObservableConcatMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int n) {
        this.source = observable;
        this.mapper = function;
        this.errorMode = errorMode;
        this.prefetch = n;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        if (ScalarXMapZHelper.tryAsCompletable(this.source, this.mapper, (CompletableObserver)completableObserver)) return;
        this.source.subscribe((Observer)new ConcatMapCompletableObserver(completableObserver, this.mapper, this.errorMode, this.prefetch));
    }
}
