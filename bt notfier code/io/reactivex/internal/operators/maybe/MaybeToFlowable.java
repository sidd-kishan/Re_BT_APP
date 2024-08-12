/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.internal.fuseable.HasUpstreamMaybeSource
 *  io.reactivex.internal.operators.maybe.MaybeToFlowable$MaybeToFlowableSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;
import org.reactivestreams.Subscriber;

public final class MaybeToFlowable<T>
extends Flowable<T>
implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> source;

    public MaybeToFlowable(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    public MaybeSource<T> source() {
        return this.source;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((MaybeObserver)new MaybeToFlowableSubscriber(subscriber));
    }
}
