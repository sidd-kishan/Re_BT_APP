/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposingSubscriberImpl
 *  io.reactivex.CompletableSource
 *  io.reactivex.Flowable
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposingSubscriberImpl;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

final class AutoDisposeFlowable<T>
extends Flowable<T> {
    private final CompletableSource scope;
    private final Publisher<T> source;

    AutoDisposeFlowable(Publisher<T> publisher, CompletableSource completableSource) {
        this.source = publisher;
        this.scope = completableSource;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((Subscriber)new AutoDisposingSubscriberImpl(this.scope, subscriber));
    }
}
