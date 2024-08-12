/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscriptions;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscription;

public final class BooleanSubscription
extends AtomicBoolean
implements Subscription {
    private static final long serialVersionUID = -8127758972444290902L;

    public void cancel() {
        this.lazySet(true);
    }

    public boolean isCancelled() {
        return this.get();
    }

    public void request(long l) {
        SubscriptionHelper.validate((long)l);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BooleanSubscription(cancelled=");
        stringBuilder.append(this.get());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
