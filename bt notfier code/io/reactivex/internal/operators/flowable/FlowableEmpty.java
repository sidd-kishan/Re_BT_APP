/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.fuseable.ScalarCallable
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

public final class FlowableEmpty
extends Flowable<Object>
implements ScalarCallable<Object> {
    public static final Flowable<Object> INSTANCE = new FlowableEmpty();

    private FlowableEmpty() {
    }

    public Object call() {
        return null;
    }

    public void subscribeActual(Subscriber<? super Object> subscriber) {
        EmptySubscription.complete(subscriber);
    }
}
