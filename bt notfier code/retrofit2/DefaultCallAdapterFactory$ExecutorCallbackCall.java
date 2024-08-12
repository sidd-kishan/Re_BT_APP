/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Request
 *  okio.Timeout
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.Response
 */
package retrofit2;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

static final class DefaultCallAdapterFactory.ExecutorCallbackCall<T>
implements Call<T> {
    final Executor callbackExecutor;
    final Call<T> delegate;

    DefaultCallAdapterFactory.ExecutorCallbackCall(Executor executor, Call<T> call) {
        this.callbackExecutor = executor;
        this.delegate = call;
    }

    public void cancel() {
        this.delegate.cancel();
    }

    public Call<T> clone() {
        return new DefaultCallAdapterFactory.ExecutorCallbackCall<T>(this.callbackExecutor, this.delegate.clone());
    }

    public void enqueue(Callback<T> callback) {
        Objects.requireNonNull(callback, "callback == null");
        this.delegate.enqueue((Callback)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Response<T> execute() throws IOException {
        return this.delegate.execute();
    }

    public boolean isCanceled() {
        return this.delegate.isCanceled();
    }

    public boolean isExecuted() {
        return this.delegate.isExecuted();
    }

    public Request request() {
        return this.delegate.request();
    }

    public Timeout timeout() {
        return this.delegate.timeout();
    }
}
