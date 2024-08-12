/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.HasUpstreamPublisher
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import org.reactivestreams.Publisher;

abstract class AbstractFlowableWithUpstream<T, R>
extends Flowable<R>
implements HasUpstreamPublisher<T> {
    protected final Flowable<T> source;

    AbstractFlowableWithUpstream(Flowable<T> flowable) {
        this.source = (Flowable)ObjectHelper.requireNonNull(flowable, (String)"source is null");
    }

    public final Publisher<T> source() {
        return this.source;
    }
}
