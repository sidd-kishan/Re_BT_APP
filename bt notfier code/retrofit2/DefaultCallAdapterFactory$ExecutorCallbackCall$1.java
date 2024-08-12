/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall
 *  retrofit2.Response
 *  retrofit2._$$Lambda$DefaultCallAdapterFactory$ExecutorCallbackCall$1$3wC8FyV4pyjrzrYL5U0mlYiviZw
 *  retrofit2._$$Lambda$DefaultCallAdapterFactory$ExecutorCallbackCall$1$7JZMXmGMmuA6QMd5UmiN1rIhtW0
 */
package retrofit2;

import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.DefaultCallAdapterFactory;
import retrofit2.Response;
import retrofit2._$;

class DefaultCallAdapterFactory.ExecutorCallbackCall.1
implements Callback<T> {
    final DefaultCallAdapterFactory.ExecutorCallbackCall this$0;
    final Callback val$callback;

    DefaultCallAdapterFactory.ExecutorCallbackCall.1() {
        this.this$0 = executorCallbackCall;
        this.val$callback = callback;
    }

    public /* synthetic */ void lambda$onFailure$1$DefaultCallAdapterFactory$ExecutorCallbackCall$1(Callback callback, Throwable throwable) {
        callback.onFailure((Call)this.this$0, throwable);
    }

    public /* synthetic */ void lambda$onResponse$0$DefaultCallAdapterFactory$ExecutorCallbackCall$1(Callback callback, Response response) {
        if (this.this$0.delegate.isCanceled()) {
            callback.onFailure((Call)this.this$0, (Throwable)new IOException("Canceled"));
        } else {
            callback.onResponse((Call)this.this$0, response);
        }
    }

    public void onFailure(Call<T> call, Throwable throwable) {
        this.this$0.callbackExecutor.execute((Runnable)new _$.Lambda.DefaultCallAdapterFactory.ExecutorCallbackCall.1.7JZMXmGMmuA6QMd5UmiN1rIhtW0(this, this.val$callback, throwable));
    }

    public void onResponse(Call<T> call, Response<T> response) {
        this.this$0.callbackExecutor.execute((Runnable)new _$.Lambda.DefaultCallAdapterFactory.ExecutorCallbackCall.1.3wC8FyV4pyjrzrYL5U0mlYiviZw(this, this.val$callback, response));
    }
}
