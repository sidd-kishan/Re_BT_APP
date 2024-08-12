/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  com.bumptech.glide.request.target.PreloadTarget
 */
package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Message;
import com.bumptech.glide.request.target.PreloadTarget;

class PreloadTarget.1
implements Handler.Callback {
    PreloadTarget.1() {
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) return false;
        ((PreloadTarget)message.obj).clear();
        return true;
    }
}
