/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  androidx.loader.content.ModernAsyncTask$AsyncTaskResult
 */
package androidx.loader.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.loader.content.ModernAsyncTask;

private static class ModernAsyncTask.InternalHandler
extends Handler {
    ModernAsyncTask.InternalHandler() {
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        ModernAsyncTask.AsyncTaskResult asyncTaskResult = (ModernAsyncTask.AsyncTaskResult)message.obj;
        int n = message.what;
        if (n != 1) {
            if (n != 2) return;
            asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
        } else {
            asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
        }
    }
}
