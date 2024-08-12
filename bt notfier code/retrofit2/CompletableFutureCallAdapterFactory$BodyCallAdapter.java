/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Call
 *  retrofit2.CallAdapter
 *  retrofit2.Callback
 *  retrofit2.CompletableFutureCallAdapterFactory$BodyCallAdapter$BodyCallback
 *  retrofit2.CompletableFutureCallAdapterFactory$CallCancelCompletableFuture
 */
package retrofit2;

import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.CompletableFutureCallAdapterFactory;

private static final class CompletableFutureCallAdapterFactory.BodyCallAdapter<R>
implements CallAdapter<R, CompletableFuture<R>> {
    private final Type responseType;

    CompletableFutureCallAdapterFactory.BodyCallAdapter(Type type) {
        this.responseType = type;
    }

    public CompletableFuture<R> adapt(Call<R> call) {
        CompletableFutureCallAdapterFactory.CallCancelCompletableFuture callCancelCompletableFuture = new CompletableFutureCallAdapterFactory.CallCancelCompletableFuture(call);
        call.enqueue((Callback)new BodyCallback(this, (CompletableFuture)callCancelCompletableFuture));
        return callCancelCompletableFuture;
    }

    public Type responseType() {
        return this.responseType;
    }
}
