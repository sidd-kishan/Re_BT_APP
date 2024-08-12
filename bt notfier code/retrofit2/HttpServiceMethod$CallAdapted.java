/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Call$Factory
 *  okhttp3.ResponseBody
 *  retrofit2.Call
 *  retrofit2.CallAdapter
 *  retrofit2.Converter
 *  retrofit2.HttpServiceMethod
 *  retrofit2.RequestFactory
 */
package retrofit2;

import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.HttpServiceMethod;
import retrofit2.RequestFactory;

static final class HttpServiceMethod.CallAdapted<ResponseT, ReturnT>
extends HttpServiceMethod<ResponseT, ReturnT> {
    private final CallAdapter<ResponseT, ReturnT> callAdapter;

    HttpServiceMethod.CallAdapted(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, ReturnT> callAdapter) {
        super(requestFactory, factory, converter);
        this.callAdapter = callAdapter;
    }

    protected ReturnT adapt(Call<ResponseT> call, Object[] objectArray) {
        return (ReturnT)this.callAdapter.adapt(call);
    }
}
