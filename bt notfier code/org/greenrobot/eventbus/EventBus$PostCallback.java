/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.SubscriberExceptionEvent
 */
package org.greenrobot.eventbus;

import java.util.List;
import org.greenrobot.eventbus.SubscriberExceptionEvent;

static interface EventBus.PostCallback {
    public void onPostCompleted(List<SubscriberExceptionEvent> var1);
}
