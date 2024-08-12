/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.util.AsyncExecutor
 *  org.greenrobot.eventbus.util.AsyncExecutor$RunnableEx
 *  org.greenrobot.eventbus.util.HasExecutionScope
 */
package org.greenrobot.eventbus.util;

import java.util.logging.Level;
import org.greenrobot.eventbus.util.AsyncExecutor;
import org.greenrobot.eventbus.util.HasExecutionScope;

/*
 * Exception performing whole class analysis ignored.
 */
class AsyncExecutor.1
implements Runnable {
    final AsyncExecutor this$0;
    final AsyncExecutor.RunnableEx val$runnable;

    AsyncExecutor.1(AsyncExecutor asyncExecutor, AsyncExecutor.RunnableEx runnableEx) {
        this.this$0 = asyncExecutor;
        this.val$runnable = runnableEx;
    }

    @Override
    public void run() {
        try {
            this.val$runnable.run();
        }
        catch (Exception exception) {
            Object t;
            try {
                t = AsyncExecutor.access$200((AsyncExecutor)this.this$0).newInstance(exception);
            }
            catch (Exception exception2) {
                AsyncExecutor.access$300((AsyncExecutor)this.this$0).getLogger().log(Level.SEVERE, "Original exception:", (Throwable)exception);
                throw new RuntimeException("Could not create failure event", exception2);
            }
            if (t instanceof HasExecutionScope) {
                ((HasExecutionScope)t).setExecutionScope(AsyncExecutor.access$400((AsyncExecutor)this.this$0));
            }
            AsyncExecutor.access$300((AsyncExecutor)this.this$0).post(t);
        }
    }
}
