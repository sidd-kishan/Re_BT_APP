/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  com.bumptech.glide.load.engine.ActiveResources
 *  com.bumptech.glide.load.engine.ActiveResources$ResourceWeakReference
 */
package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Message;
import com.bumptech.glide.load.engine.ActiveResources;

class ActiveResources.1
implements Handler.Callback {
    final ActiveResources this$0;

    ActiveResources.1(ActiveResources activeResources) {
        this.this$0 = activeResources;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) return false;
        this.this$0.cleanupActiveReference((ActiveResources.ResourceWeakReference)message.obj);
        return true;
    }
}
