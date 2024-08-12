/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscription;

static final class FlowableSubscribeOn.SubscribeOnSubscriber.Request
implements Runnable {
    final long n;
    final Subscription upstream;

    FlowableSubscribeOn.SubscribeOnSubscriber.Request(Subscription subscription, long l) {
        this.upstream = subscription;
        this.n = l;
    }

    @Override
    public void run() {
        this.upstream.request(this.n);
    }
}
