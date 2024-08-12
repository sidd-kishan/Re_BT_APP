/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import java.util.concurrent.Callable;

class HandlerScheduledExecutorService.2
implements Callable<Void> {
    final HandlerScheduledExecutorService this$0;
    final Runnable val$command;

    HandlerScheduledExecutorService.2(HandlerScheduledExecutorService handlerScheduledExecutorService, Runnable runnable) {
        this.this$0 = handlerScheduledExecutorService;
        this.val$command = runnable;
    }

    @Override
    public Void call() {
        this.val$command.run();
        return null;
    }
}
