/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.single.SingleToFlowable$SingleToFlowableObserver
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.single.SingleToFlowable;
import org.reactivestreams.Subscriber;

public final class SingleToFlowable<T>
extends Flowable<T> {
    final SingleSource<? extends T> source;

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.source = singleSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((SingleObserver)new SingleToFlowableObserver(subscriber));
    }
}
