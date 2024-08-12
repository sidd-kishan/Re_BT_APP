/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.os.Message
 *  com.bumptech.glide.request.target.SimpleTarget
 *  com.bumptech.glide.request.transition.Transition
 */
package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

static class GifFrameLoader.DelayTarget
extends SimpleTarget<Bitmap> {
    private final Handler handler;
    final int index;
    private Bitmap resource;
    private final long targetTime;

    GifFrameLoader.DelayTarget(Handler handler, int n, long l) {
        this.handler = handler;
        this.index = n;
        this.targetTime = l;
    }

    Bitmap getResource() {
        return this.resource;
    }

    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        this.resource = bitmap;
        bitmap = this.handler.obtainMessage(1, (Object)this);
        this.handler.sendMessageAtTime((Message)bitmap, this.targetTime);
    }
}
