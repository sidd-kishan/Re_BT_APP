/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.EventBus
 */
package org.greenrobot.eventbus;

import org.greenrobot.eventbus.EventBus;

public final class SubscriberExceptionEvent {
    public final Object causingEvent;
    public final Object causingSubscriber;
    public final EventBus eventBus;
    public final Throwable throwable;

    public SubscriberExceptionEvent(EventBus eventBus, Throwable throwable, Object object, Object object2) {
        this.eventBus = eventBus;
        this.throwable = throwable;
        this.causingEvent = object;
        this.causingSubscriber = object2;
    }
}
