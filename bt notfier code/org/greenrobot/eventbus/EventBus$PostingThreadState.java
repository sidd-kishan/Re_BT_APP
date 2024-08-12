/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.Subscription
 */
package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscription;

static final class EventBus.PostingThreadState {
    boolean canceled;
    Object event;
    final List<Object> eventQueue = new ArrayList<Object>();
    boolean isMainThread;
    boolean isPosting;
    Subscription subscription;

    EventBus.PostingThreadState() {
    }
}
