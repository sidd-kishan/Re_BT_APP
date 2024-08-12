/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  androidx.asynclayoutinflater.view.AsyncLayoutInflater
 *  androidx.asynclayoutinflater.view.AsyncLayoutInflater$InflateRequest
 */
package androidx.asynclayoutinflater.view;

import android.os.Handler;
import android.os.Message;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;

class AsyncLayoutInflater.1
implements Handler.Callback {
    final AsyncLayoutInflater this$0;

    AsyncLayoutInflater.1(AsyncLayoutInflater asyncLayoutInflater) {
        this.this$0 = asyncLayoutInflater;
    }

    public boolean handleMessage(Message message) {
        message = (AsyncLayoutInflater.InflateRequest)message.obj;
        if (message.view == null) {
            message.view = this.this$0.mInflater.inflate(message.resid, message.parent, false);
        }
        message.callback.onInflateFinished(message.view, message.resid, message.parent);
        this.this$0.mInflateThread.releaseRequest((AsyncLayoutInflater.InflateRequest)message);
        return true;
    }
}
