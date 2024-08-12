/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.MaybeSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe;
import org.reactivestreams.Subscriber;

public final class FlowableSwitchMapMaybe<T, R>
extends Flowable<R> {
    final boolean delayErrors;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final Flowable<T> source;

    public FlowableSwitchMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean bl) {
        this.source = flowable;
        this.mapper = function;
        this.delayErrors = bl;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber)new SwitchMapMaybeSubscriber(subscriber, this.mapper, this.delayErrors));
    }
}
