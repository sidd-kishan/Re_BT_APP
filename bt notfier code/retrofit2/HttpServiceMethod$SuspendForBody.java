/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.coroutines.Continuation
 *  okhttp3.Call$Factory
 *  okhttp3.ResponseBody
 *  retrofit2.Call
 *  retrofit2.CallAdapter
 *  retrofit2.Converter
 *  retrofit2.HttpServiceMethod
 *  retrofit2.KotlinExtensions
 *  retrofit2.RequestFactory
 */
package retrofit2;

import kotlin.coroutines.Continuation;
import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.HttpServiceMethod;
import retrofit2.KotlinExtensions;
import retrofit2.RequestFactory;

static final class HttpServiceMethod.SuspendForBody<ResponseT>
extends HttpServiceMethod<ResponseT, Object> {
    private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
    private final boolean isNullable;

    HttpServiceMethod.SuspendForBody(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter, boolean bl) {
        super(requestFactory, factory, converter);
        this.callAdapter = callAdapter;
        this.isNullable = bl;
    }

    protected Object adapt(Call<ResponseT> object, Object[] continuation) {
        object = (Call)this.callAdapter.adapt(object);
        continuation = (Continuation)continuation[((Object[])continuation).length - 1];
        try {
            object = this.isNullable ? KotlinExtensions.awaitNullable((Call)object, (Continuation)continuation) : KotlinExtensions.await((Call)object, (Continuation)continuation);
            return object;
        }
        catch (Exception exception) {
            return KotlinExtensions.suspendAndThrow((Exception)exception, (Continuation)continuation);
        }
    }
}
