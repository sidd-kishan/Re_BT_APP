/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscription;

public static class Functions.BoundedConsumer
implements Consumer<Subscription> {
    final int bufferSize;

    Functions.BoundedConsumer(int n) {
        this.bufferSize = n;
    }

    public void accept(Subscription subscription) throws Exception {
        subscription.request((long)this.bufferSize);
    }
}
