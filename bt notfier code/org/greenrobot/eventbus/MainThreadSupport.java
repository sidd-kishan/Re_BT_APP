/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Poster
 */
package org.greenrobot.eventbus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Poster;

public interface MainThreadSupport {
    public Poster createPoster(EventBus var1);

    public boolean isMainThread();
}
