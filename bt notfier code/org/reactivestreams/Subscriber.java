/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.reactivestreams.Subscription
 */
package org.reactivestreams;

import org.reactivestreams.Subscription;

public interface Subscriber<T> {
    public void onComplete();

    public void onError(Throwable var1);

    public void onNext(T var1);

    public void onSubscribe(Subscription var1);
}
