/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.reactivestreams.Subscriber
 */
package com.uber.autodispose;

import org.reactivestreams.Subscriber;

public interface ParallelFlowableSubscribeProxy<T> {
    public void subscribe(Subscriber<? super T>[] var1);
}
