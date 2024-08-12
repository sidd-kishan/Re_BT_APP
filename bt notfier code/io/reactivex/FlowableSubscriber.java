/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public interface FlowableSubscriber<T>
extends Subscriber<T> {
    public void onSubscribe(Subscription var1);
}
