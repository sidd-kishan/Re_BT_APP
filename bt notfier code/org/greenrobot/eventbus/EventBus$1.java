/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.EventBus$PostingThreadState
 */
package org.greenrobot.eventbus;

import org.greenrobot.eventbus.EventBus;

class EventBus.1
extends ThreadLocal<EventBus.PostingThreadState> {
    final EventBus this$0;

    EventBus.1(EventBus eventBus) {
        this.this$0 = eventBus;
    }

    @Override
    protected EventBus.PostingThreadState initialValue() {
        return new EventBus.PostingThreadState();
    }
}
