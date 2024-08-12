/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable$ConcatMapCompletableObserver
 *  io.reactivex.internal.util.ErrorMode
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable;
import io.reactivex.internal.util.ErrorMode;

public final class FlowableConcatMapCompletable<T>
extends Completable {
    final ErrorMode errorMode;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int prefetch;
    final Flowable<T> source;

    public FlowableConcatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int n) {
        this.source = flowable;
        this.mapper = function;
        this.errorMode = errorMode;
        this.prefetch = n;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((FlowableSubscriber)new ConcatMapCompletableObserver(completableObserver, this.mapper, this.errorMode, this.prefetch));
    }
}
