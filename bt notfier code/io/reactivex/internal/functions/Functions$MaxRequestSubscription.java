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

static final class Functions.MaxRequestSubscription
implements Consumer<Subscription> {
    Functions.MaxRequestSubscription() {
    }

    public void accept(Subscription subscription) throws Exception {
        subscription.request(Long.MAX_VALUE);
    }
}
