/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Call
 *  retrofit2.CallAdapter
 *  retrofit2.DefaultCallAdapterFactory
 *  retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall
 */
package retrofit2;

import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.DefaultCallAdapterFactory;

class DefaultCallAdapterFactory.1
implements CallAdapter<Object, Call<?>> {
    final DefaultCallAdapterFactory this$0;
    final Executor val$executor;
    final Type val$responseType;

    DefaultCallAdapterFactory.1() {
        this.this$0 = defaultCallAdapterFactory;
        this.val$responseType = type;
        this.val$executor = executor;
    }

    public Call<Object> adapt(Call<Object> executorCallbackCall) {
        Executor executor = this.val$executor;
        if (executor == null) return executorCallbackCall;
        executorCallbackCall = new DefaultCallAdapterFactory.ExecutorCallbackCall(executor, executorCallbackCall);
        return executorCallbackCall;
    }

    public Type responseType() {
        return this.val$responseType;
    }
}
