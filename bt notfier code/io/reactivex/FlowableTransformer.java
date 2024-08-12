/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  org.reactivestreams.Publisher
 */
package io.reactivex;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

public interface FlowableTransformer<Upstream, Downstream> {
    public Publisher<Downstream> apply(Flowable<Upstream> var1);
}
