/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  com.bumptech.glide.load.resource.gif.GifFrameLoader
 *  com.bumptech.glide.load.resource.gif.GifFrameLoader$DelayTarget
 *  com.bumptech.glide.request.target.Target
 */
package com.bumptech.glide.load.resource.gif;

import android.os.Handler;
import android.os.Message;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.request.target.Target;

private class GifFrameLoader.FrameLoaderCallback
implements Handler.Callback {
    static final int MSG_CLEAR = 2;
    static final int MSG_DELAY = 1;
    final GifFrameLoader this$0;

    GifFrameLoader.FrameLoaderCallback(GifFrameLoader gifFrameLoader) {
        this.this$0 = gifFrameLoader;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            message = (GifFrameLoader.DelayTarget)message.obj;
            this.this$0.onFrameReady((GifFrameLoader.DelayTarget)message);
            return true;
        }
        if (message.what != 2) return false;
        message = (GifFrameLoader.DelayTarget)message.obj;
        this.this$0.requestManager.clear((Target)message);
        return false;
    }
}
