/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.core.provider.SelfDestructiveThread
 *  androidx.core.provider.SelfDestructiveThread$ReplyCallback
 */
package androidx.core.provider;

import android.os.Handler;
import androidx.core.provider.SelfDestructiveThread;
import java.util.concurrent.Callable;

class SelfDestructiveThread.2
implements Runnable {
    final SelfDestructiveThread this$0;
    final Callable val$callable;
    final Handler val$calleeHandler;
    final SelfDestructiveThread.ReplyCallback val$reply;

    SelfDestructiveThread.2(SelfDestructiveThread selfDestructiveThread, Callable callable, Handler handler, SelfDestructiveThread.ReplyCallback replyCallback) {
        this.this$0 = selfDestructiveThread;
        this.val$callable = callable;
        this.val$calleeHandler = handler;
        this.val$reply = replyCallback;
    }

    @Override
    public void run() {
        Object v;
        try {
            v = this.val$callable.call();
        }
        catch (Exception exception) {
            v = null;
        }
        this.val$calleeHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
