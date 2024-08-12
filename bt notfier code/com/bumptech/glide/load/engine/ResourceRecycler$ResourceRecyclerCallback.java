/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  com.bumptech.glide.load.engine.Resource
 */
package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Message;
import com.bumptech.glide.load.engine.Resource;

private static final class ResourceRecycler.ResourceRecyclerCallback
implements Handler.Callback {
    static final int RECYCLE_RESOURCE = 1;

    ResourceRecycler.ResourceRecyclerCallback() {
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) return false;
        ((Resource)message.obj).recycle();
        return true;
    }
}
