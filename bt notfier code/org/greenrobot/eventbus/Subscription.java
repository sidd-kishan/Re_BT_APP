/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.SubscriberMethod
 */
package org.greenrobot.eventbus;

import org.greenrobot.eventbus.SubscriberMethod;

final class Subscription {
    volatile boolean active;
    final Object subscriber;
    final SubscriberMethod subscriberMethod;

    Subscription(Object object, SubscriberMethod subscriberMethod) {
        this.subscriber = object;
        this.subscriberMethod = subscriberMethod;
        this.active = true;
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof Subscription;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (Subscription)object;
        bl3 = bl;
        if (this.subscriber != ((Subscription)object).subscriber) return bl3;
        bl3 = bl;
        if (!this.subscriberMethod.equals((Object)((Subscription)object).subscriberMethod)) return bl3;
        bl3 = true;
        return bl3;
    }

    public int hashCode() {
        return this.subscriber.hashCode() + this.subscriberMethod.methodString.hashCode();
    }
}
