/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService$HandlerScheduledFuture$1
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;

class HandlerScheduledExecutorService.HandlerScheduledFuture.1
implements Runnable {
    final HandlerScheduledExecutorService.HandlerScheduledFuture.1 this$1;

    HandlerScheduledExecutorService.HandlerScheduledFuture.1(HandlerScheduledExecutorService.HandlerScheduledFuture.1 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    public void run() {
        if (this.this$1.this$0.mCompleter.getAndSet(null) == null) return;
        this.this$1.val$handler.removeCallbacks((Runnable)this.this$1.this$0);
    }
}
