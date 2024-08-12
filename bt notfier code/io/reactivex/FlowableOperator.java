/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.reactivestreams.Subscriber
 */
package io.reactivex;

import org.reactivestreams.Subscriber;

public interface FlowableOperator<Downstream, Upstream> {
    public Subscriber<? super Upstream> apply(Subscriber<? super Downstream> var1) throws Exception;
}
