/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Notification
 *  io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Notification;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

static final class FlowableMaterialize.MaterializeSubscriber<T>
extends SinglePostCompleteSubscriber<T, Notification<T>> {
    private static final long serialVersionUID = -3740826063558713822L;

    FlowableMaterialize.MaterializeSubscriber(Subscriber<? super Notification<T>> subscriber) {
        super(subscriber);
    }

    public void onComplete() {
        this.complete(Notification.createOnComplete());
    }

    protected void onDrop(Notification<T> notification) {
        if (!notification.isOnError()) return;
        RxJavaPlugins.onError((Throwable)notification.getError());
    }

    public void onError(Throwable throwable) {
        this.complete(Notification.createOnError((Throwable)throwable));
    }

    public void onNext(T t) {
        ++this.produced;
        this.downstream.onNext((Object)Notification.createOnNext(t));
    }
}
