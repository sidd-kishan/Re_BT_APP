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

static final class FlowAdapters.ReactiveToFlowSubscription
implements Subscription {
    final Flow.Subscription flow;

    public FlowAdapters.ReactiveToFlowSubscription(Flow.Subscription subscription) {
        this.flow = subscription;
    }

    public void cancel() {
        this.flow.cancel();
    }

    public void request(long l) {
        this.flow.request(l);
    }
}
