/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.util;

import java.io.Serializable;
import org.reactivestreams.Subscription;

static final class NotificationLite.SubscriptionNotification
implements Serializable {
    private static final long serialVersionUID = -1322257508628817540L;
    final Subscription upstream;

    NotificationLite.SubscriptionNotification(Subscription subscription) {
        this.upstream = subscription;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NotificationLite.Subscription[");
        stringBuilder.append(this.upstream);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
