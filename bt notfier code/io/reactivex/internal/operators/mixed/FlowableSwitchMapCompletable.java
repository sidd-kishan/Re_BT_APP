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
 *  io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable$SwitchMapCompletableObserver
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable;

public final class FlowableSwitchMapCompletable<T>
extends Completable {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final Flowable<T> source;

    public FlowableSwitchMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean bl) {
        this.source = flowable;
        this.mapper = function;
        this.delayErrors = bl;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((FlowableSubscriber)new SwitchMapCompletableObserver(completableObserver, this.mapper, this.delayErrors));
    }
}
