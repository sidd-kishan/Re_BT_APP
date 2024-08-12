/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.EventBus
 */
package org.greenrobot.eventbus;

import org.greenrobot.eventbus.EventBus;

public final class NoSubscriberEvent {
    public final EventBus eventBus;
    public final Object originalEvent;

    public NoSubscriberEvent(EventBus eventBus, Object object) {
        this.eventBus = eventBus;
        this.originalEvent = object;
    }
}
