/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.CompletableFutureCallAdapterFactory$ResponseCallAdapter
 *  retrofit2.Response
 */
package retrofit2;

import java.util.concurrent.CompletableFuture;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.CompletableFutureCallAdapterFactory;
import retrofit2.Response;

private class CompletableFutureCallAdapterFactory.ResponseCallAdapter.ResponseCallback
implements Callback<R> {
    private final CompletableFuture<Response<R>> future;
    final CompletableFutureCallAdapterFactory.ResponseCallAdapter this$0;

    public CompletableFutureCallAdapterFactory.ResponseCallAdapter.ResponseCallback(CompletableFutureCallAdapterFactory.ResponseCallAdapter responseCallAdapter, CompletableFuture<Response<R>> completableFuture) {
        this.this$0 = responseCallAdapter;
        this.future = completableFuture;
    }

    public void onFailure(Call<R> call, Throwable throwable) {
        this.future.completeExceptionally(throwable);
    }

    public void onResponse(Call<R> call, Response<R> response) {
        this.future.complete(response);
    }
}
