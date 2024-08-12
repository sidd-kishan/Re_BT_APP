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
 *  io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable$SwitchMapCompletableObserver
 *  io.reactivex.internal.operators.mixed.ScalarXMapZHelper
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ScalarXMapZHelper;

public final class ObservableSwitchMapCompletable<T>
extends Completable {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final Observable<T> source;

    public ObservableSwitchMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, boolean bl) {
        this.source = observable;
        this.mapper = function;
        this.delayErrors = bl;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        if (ScalarXMapZHelper.tryAsCompletable(this.source, this.mapper, (CompletableObserver)completableObserver)) return;
        this.source.subscribe((Observer)new SwitchMapCompletableObserver(completableObserver, this.mapper, this.delayErrors));
    }
}
