/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  com.bumptech.glide.load.engine.EngineJob
 */
package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Message;
import com.bumptech.glide.load.engine.EngineJob;

private static class EngineJob.MainThreadCallback
implements Handler.Callback {
    EngineJob.MainThreadCallback() {
    }

    public boolean handleMessage(Message message) {
        Object object = (EngineJob)message.obj;
        int n = message.what;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Unrecognized message: ");
                    ((StringBuilder)object).append(message.what);
                    throw new IllegalStateException(((StringBuilder)object).toString());
                }
                object.handleCancelledOnMainThread();
            } else {
                object.handleExceptionOnMainThread();
            }
        } else {
            object.handleResultOnMainThread();
        }
        return true;
    }
}
