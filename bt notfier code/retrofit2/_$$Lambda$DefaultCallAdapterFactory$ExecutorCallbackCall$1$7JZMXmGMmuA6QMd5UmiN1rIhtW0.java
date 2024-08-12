/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Callback
 *  retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1
 */
package retrofit2;

import retrofit2.Callback;
import retrofit2.DefaultCallAdapterFactory;

public final class _$$Lambda$DefaultCallAdapterFactory$ExecutorCallbackCall$1$7JZMXmGMmuA6QMd5UmiN1rIhtW0
implements Runnable {
    private final DefaultCallAdapterFactory.ExecutorCallbackCall.1 f$0;
    private final Callback f$1;
    private final Throwable f$2;

    public /* synthetic */ _$$Lambda$DefaultCallAdapterFactory$ExecutorCallbackCall$1$7JZMXmGMmuA6QMd5UmiN1rIhtW0(DefaultCallAdapterFactory.ExecutorCallbackCall.1 var1_1, Callback callback, Throwable throwable) {
        this.f$0 = var1_1;
        this.f$1 = callback;
        this.f$2 = throwable;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onFailure$1$DefaultCallAdapterFactory$ExecutorCallbackCall$1(this.f$1, this.f$2);
    }
}
