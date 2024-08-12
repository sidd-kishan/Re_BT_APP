/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableElementAt$ElementAtSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableElementAt;
import org.reactivestreams.Subscriber;

public final class FlowableElementAt<T>
extends AbstractFlowableWithUpstream<T, T> {
    final T defaultValue;
    final boolean errorOnFewer;
    final long index;

    public FlowableElementAt(Flowable<T> flowable, long l, T t, boolean bl) {
        super(flowable);
        this.index = l;
        this.defaultValue = t;
        this.errorOnFewer = bl;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new ElementAtSubscriber(subscriber, this.index, this.defaultValue, this.errorOnFewer));
    }
}
