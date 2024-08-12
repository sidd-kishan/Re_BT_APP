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

static final class HttpServiceMethod.SuspendForResponse<ResponseT>
extends HttpServiceMethod<ResponseT, Object> {
    private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

    HttpServiceMethod.SuspendForResponse(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter) {
        super(requestFactory, factory, converter);
        this.callAdapter = callAdapter;
    }

    protected Object adapt(Call<ResponseT> continuation, Object[] object) {
        Call call = (Call)this.callAdapter.adapt(continuation);
        continuation = (Continuation)object[((Object[])object).length - 1];
        try {
            object = KotlinExtensions.awaitResponse((Call)call, (Continuation)continuation);
            return object;
        }
        catch (Exception exception) {
            return KotlinExtensions.suspendAndThrow((Exception)exception, (Continuation)continuation);
        }
    }
}
