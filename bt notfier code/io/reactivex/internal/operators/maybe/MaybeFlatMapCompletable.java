/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable$FlatMapCompletableObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable;

public final class MaybeFlatMapCompletable<T>
extends Completable {
    final Function<? super T, ? extends CompletableSource> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapCompletable(MaybeSource<T> maybeSource, Function<? super T, ? extends CompletableSource> function) {
        this.source = maybeSource;
        this.mapper = function;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(completableObserver, this.mapper);
        completableObserver.onSubscribe((Disposable)flatMapCompletableObserver);
        this.source.subscribe((MaybeObserver)flatMapCompletableObserver);
    }
}
