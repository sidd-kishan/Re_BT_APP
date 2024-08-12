/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;

public interface FlowablePublishClassic<T> {
    public int publishBufferSize();

    public Publisher<T> publishSource();
}
