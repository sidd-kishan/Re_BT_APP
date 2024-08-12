/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package com.uber.autodispose.observers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public interface AutoDisposingSubscriber<T>
extends FlowableSubscriber<T>,
Subscription,
Disposable {
    public Subscriber<? super T> delegateSubscriber();
}
