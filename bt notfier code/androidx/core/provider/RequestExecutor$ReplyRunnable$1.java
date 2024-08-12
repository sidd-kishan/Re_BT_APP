/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.provider.RequestExecutor$ReplyRunnable
 *  androidx.core.util.Consumer
 */
package androidx.core.provider;

import androidx.core.provider.RequestExecutor;
import androidx.core.util.Consumer;

class RequestExecutor.ReplyRunnable.1
implements Runnable {
    final RequestExecutor.ReplyRunnable this$0;
    final Consumer val$consumer;
    final Object val$result;

    RequestExecutor.ReplyRunnable.1(RequestExecutor.ReplyRunnable replyRunnable, Consumer consumer, Object object) {
        this.this$0 = replyRunnable;
        this.val$consumer = consumer;
        this.val$result = object;
    }

    @Override
    public void run() {
        this.val$consumer.accept(this.val$result);
    }
}
