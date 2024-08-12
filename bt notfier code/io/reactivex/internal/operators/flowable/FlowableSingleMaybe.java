/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.operators.flowable.FlowableSingle
 *  io.reactivex.internal.operators.flowable.FlowableSingleMaybe$SingleElementSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.operators.flowable.FlowableSingle;
import io.reactivex.internal.operators.flowable.FlowableSingleMaybe;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableSingleMaybe<T>
extends Maybe<T>
implements FuseToFlowable<T> {
    final Flowable<T> source;

    public FlowableSingleMaybe(Flowable<T> flowable) {
        this.source = flowable;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSingle(this.source, null, false));
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((FlowableSubscriber)new SingleElementSubscriber(maybeObserver));
    }
}
