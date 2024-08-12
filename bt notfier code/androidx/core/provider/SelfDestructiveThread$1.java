/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  androidx.core.provider.SelfDestructiveThread
 */
package androidx.core.provider;

import android.os.Handler;
import android.os.Message;
import androidx.core.provider.SelfDestructiveThread;

class SelfDestructiveThread.1
implements Handler.Callback {
    final SelfDestructiveThread this$0;

    SelfDestructiveThread.1(SelfDestructiveThread selfDestructiveThread) {
        this.this$0 = selfDestructiveThread;
    }

    public boolean handleMessage(Message message) {
        int n = message.what;
        if (n == 0) {
            this.this$0.onDestruction();
            return true;
        }
        if (n != 1) {
            return true;
        }
        this.this$0.onInvokeRunnable((Runnable)message.obj);
        return true;
    }
}
