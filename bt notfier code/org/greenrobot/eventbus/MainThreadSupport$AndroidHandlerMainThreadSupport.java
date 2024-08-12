/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.HandlerPoster
 *  org.greenrobot.eventbus.MainThreadSupport
 *  org.greenrobot.eventbus.Poster
 */
package org.greenrobot.eventbus;

import android.os.Looper;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.HandlerPoster;
import org.greenrobot.eventbus.MainThreadSupport;
import org.greenrobot.eventbus.Poster;

public static class MainThreadSupport.AndroidHandlerMainThreadSupport
implements MainThreadSupport {
    private final Looper looper;

    public MainThreadSupport.AndroidHandlerMainThreadSupport(Looper looper) {
        this.looper = looper;
    }

    public Poster createPoster(EventBus eventBus) {
        return new HandlerPoster(eventBus, this.looper, 10);
    }

    public boolean isMainThread() {
        boolean bl = this.looper == Looper.myLooper();
        return bl;
    }
}
