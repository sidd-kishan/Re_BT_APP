/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.CompletableFutureCallAdapterFactory$BodyCallAdapter
 *  retrofit2.HttpException
 *  retrofit2.Response
 */
package retrofit2;

import java.util.concurrent.CompletableFuture;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.CompletableFutureCallAdapterFactory;
import retrofit2.HttpException;
import retrofit2.Response;

private class CompletableFutureCallAdapterFactory.BodyCallAdapter.BodyCallback
implements Callback<R> {
    private final CompletableFuture<R> future;
    final CompletableFutureCallAdapterFactory.BodyCallAdapter this$0;

    public CompletableFutureCallAdapterFactory.BodyCallAdapter.BodyCallback(CompletableFutureCallAdapterFactory.BodyCallAdapter bodyCallAdapter, CompletableFuture<R> completableFuture) {
        this.this$0 = bodyCallAdapter;
        this.future = completableFuture;
    }

    public void onFailure(Call<R> call, Throwable throwable) {
        this.future.completeExceptionally(throwable);
    }

    public void onResponse(Call<R> call, Response<R> response) {
        if (response.isSuccessful()) {
            this.future.complete(response.body());
        } else {
            this.future.completeExceptionally((Throwable)new HttpException(response));
        }
    }
}
