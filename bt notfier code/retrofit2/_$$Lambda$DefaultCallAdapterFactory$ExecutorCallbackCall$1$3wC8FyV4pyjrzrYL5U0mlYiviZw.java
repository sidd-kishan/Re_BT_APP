/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Callback
 *  retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1
 *  retrofit2.Response
 */
package retrofit2;

import retrofit2.Callback;
import retrofit2.DefaultCallAdapterFactory;
import retrofit2.Response;

public final class _$$Lambda$DefaultCallAdapterFactory$ExecutorCallbackCall$1$3wC8FyV4pyjrzrYL5U0mlYiviZw
implements Runnable {
    private final DefaultCallAdapterFactory.ExecutorCallbackCall.1 f$0;
    private final Callback f$1;
    private final Response f$2;

    public /* synthetic */ _$$Lambda$DefaultCallAdapterFactory$ExecutorCallbackCall$1$3wC8FyV4pyjrzrYL5U0mlYiviZw(DefaultCallAdapterFactory.ExecutorCallbackCall.1 var1_1, Callback callback, Response response) {
        this.f$0 = var1_1;
        this.f$1 = callback;
        this.f$2 = response;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onResponse$0$DefaultCallAdapterFactory$ExecutorCallbackCall$1(this.f$1, this.f$2);
    }
}
