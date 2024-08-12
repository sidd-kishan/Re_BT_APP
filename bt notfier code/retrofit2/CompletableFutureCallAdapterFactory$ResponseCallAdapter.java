/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Call
 *  retrofit2.CallAdapter
 *  retrofit2.Callback
 *  retrofit2.CompletableFutureCallAdapterFactory$CallCancelCompletableFuture
 *  retrofit2.CompletableFutureCallAdapterFactory$ResponseCallAdapter$ResponseCallback
 *  retrofit2.Response
 */
package retrofit2;

import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.CompletableFutureCallAdapterFactory;
import retrofit2.Response;

private static final class CompletableFutureCallAdapterFactory.ResponseCallAdapter<R>
implements CallAdapter<R, CompletableFuture<Response<R>>> {
    private final Type responseType;

    CompletableFutureCallAdapterFactory.ResponseCallAdapter(Type type) {
        this.responseType = type;
    }

    public CompletableFuture<Response<R>> adapt(Call<R> call) {
        CompletableFutureCallAdapterFactory.CallCancelCompletableFuture callCancelCompletableFuture = new CompletableFutureCallAdapterFactory.CallCancelCompletableFuture(call);
        call.enqueue((Callback)new ResponseCallback(this, (CompletableFuture)callCancelCompletableFuture));
        return callCancelCompletableFuture;
    }

    public Type responseType() {
        return this.responseType;
    }
}
