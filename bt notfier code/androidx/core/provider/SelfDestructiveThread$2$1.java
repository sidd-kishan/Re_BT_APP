/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.provider.SelfDestructiveThread$2
 */
package androidx.core.provider;

import androidx.core.provider.SelfDestructiveThread;

class SelfDestructiveThread.1
implements Runnable {
    final SelfDestructiveThread.2 this$1;
    final Object val$result;

    SelfDestructiveThread.1(SelfDestructiveThread.2 var1_1, Object object) {
        this.this$1 = var1_1;
        this.val$result = object;
    }

    @Override
    public void run() {
        this.this$1.val$reply.onReply(this.val$result);
    }
}
