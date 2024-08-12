/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.util.concurrent.Flow$Subscription
 *  org.reactivestreams.Subscription
 */
package org.reactivestreams;

import java.util.concurrent.Flow;
import org.reactivestreams.Subscription;

static final class FlowAdapters.FlowToReactiveSubscription
implements Flow.Subscription {
    final Subscription reactiveStreams;

    public FlowAdapters.FlowToReactiveSubscription(Subscription subscription) {
        this.reactiveStreams = subscription;
    }

    public void cancel() {
        this.reactiveStreams.cancel();
    }

    public void request(long l) {
        this.reactiveStreams.request(l);
    }
}
