/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.flowables.ConnectableFlowable
 *  io.reactivex.functions.Consumer
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscriber;

static final class FlowableReplay.ConnectableFlowableReplay<T>
extends ConnectableFlowable<T> {
    private final ConnectableFlowable<T> cf;
    private final Flowable<T> flowable;

    FlowableReplay.ConnectableFlowableReplay(ConnectableFlowable<T> connectableFlowable, Flowable<T> flowable) {
        this.cf = connectableFlowable;
        this.flowable = flowable;
    }

    public void connect(Consumer<? super Disposable> consumer) {
        this.cf.connect(consumer);
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.flowable.subscribe(subscriber);
    }
}
