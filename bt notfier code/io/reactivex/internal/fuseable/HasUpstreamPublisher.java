/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.fuseable;

import org.reactivestreams.Publisher;

public interface HasUpstreamPublisher<T> {
    public Publisher<T> source();
}
