/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.ResourceRecycler$ResourceRecyclerCallback
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.ResourceRecycler;
import com.bumptech.glide.util.Util;

class ResourceRecycler {
    private final Handler handler = new Handler(Looper.getMainLooper(), (Handler.Callback)new ResourceRecyclerCallback());
    private boolean isRecycling;

    ResourceRecycler() {
    }

    void recycle(Resource<?> resource) {
        Util.assertMainThread();
        if (this.isRecycling) {
            this.handler.obtainMessage(1, resource).sendToTarget();
        } else {
            this.isRecycling = true;
            resource.recycle();
            this.isRecycling = false;
        }
    }
}
