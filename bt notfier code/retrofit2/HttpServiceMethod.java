/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Call$Factory
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 *  retrofit2.Call
 *  retrofit2.CallAdapter
 *  retrofit2.Converter
 *  retrofit2.HttpServiceMethod$CallAdapted
 *  retrofit2.HttpServiceMethod$SuspendForBody
 *  retrofit2.HttpServiceMethod$SuspendForResponse
 *  retrofit2.OkHttpCall
 *  retrofit2.RequestFactory
 *  retrofit2.Response
 *  retrofit2.Retrofit
 *  retrofit2.ServiceMethod
 *  retrofit2.SkipCallbackExecutorImpl
 *  retrofit2.Utils
 *  retrofit2.Utils$ParameterizedTypeImpl
 */
package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.HttpServiceMethod;
import retrofit2.OkHttpCall;
import retrofit2.RequestFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.ServiceMethod;
import retrofit2.SkipCallbackExecutorImpl;
import retrofit2.Utils;

abstract class HttpServiceMethod<ResponseT, ReturnT>
extends ServiceMethod<ReturnT> {
    private final Call.Factory callFactory;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, ResponseT> responseConverter;

    HttpServiceMethod(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter) {
        this.requestFactory = requestFactory;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit retrofit, Method method, Type type, Annotation[] annotationArray) {
        try {
            retrofit = retrofit.callAdapter(type, annotationArray);
            return retrofit;
        }
        catch (RuntimeException runtimeException) {
            throw Utils.methodError((Method)method, (Throwable)runtimeException, (String)"Unable to create call adapter for %s", (Object[])new Object[]{type});
        }
    }

    private static <ResponseT> Converter<ResponseBody, ResponseT> createResponseConverter(Retrofit retrofit, Method method, Type type) {
        Annotation[] annotationArray = method.getAnnotations();
        try {
            retrofit = retrofit.responseBodyConverter(type, annotationArray);
            return retrofit;
        }
        catch (RuntimeException runtimeException) {
            throw Utils.methodError((Method)method, (Throwable)runtimeException, (String)"Unable to create converter for %s", (Object[])new Object[]{type});
        }
    }

    static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit object, Method converter, RequestFactory requestFactory) {
        boolean bl;
        Utils.ParameterizedTypeImpl parameterizedTypeImpl;
        boolean bl2 = requestFactory.isKotlinSuspendFunction;
        Annotation[] annotationArray = converter.getAnnotations();
        if (bl2) {
            parameterizedTypeImpl = converter.getGenericParameterTypes();
            if (Utils.getRawType(parameterizedTypeImpl = Utils.getParameterLowerBound((int)0, (ParameterizedType)((ParameterizedType)parameterizedTypeImpl[((Type[])parameterizedTypeImpl).length - 1]))) == Response.class && parameterizedTypeImpl instanceof ParameterizedType) {
                parameterizedTypeImpl = Utils.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)parameterizedTypeImpl));
                bl = true;
            } else {
                bl = false;
            }
            parameterizedTypeImpl = new Utils.ParameterizedTypeImpl(null, Call.class, new Type[]{parameterizedTypeImpl});
            annotationArray = SkipCallbackExecutorImpl.ensurePresent((Annotation[])annotationArray);
        } else {
            parameterizedTypeImpl = converter.getGenericReturnType();
            bl = false;
        }
        parameterizedTypeImpl = HttpServiceMethod.createCallAdapter((Retrofit)object, (Method)converter, (Type)parameterizedTypeImpl, annotationArray);
        annotationArray = parameterizedTypeImpl.responseType();
        if (annotationArray == okhttp3.Response.class) {
            object = new StringBuilder();
            ((StringBuilder)object).append("'");
            ((StringBuilder)object).append(Utils.getRawType((Type)annotationArray).getName());
            ((StringBuilder)object).append("' is not a valid response body type. Did you mean ResponseBody?");
            throw Utils.methodError(converter, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        }
        if (annotationArray == Response.class) throw Utils.methodError((Method)converter, (String)"Response must include generic type (e.g., Response<String>)", (Object[])new Object[0]);
        if (requestFactory.httpMethod.equals("HEAD")) {
            if (!Void.class.equals((Object)annotationArray)) throw Utils.methodError(converter, (String)"HEAD method must use Void as response type.", (Object[])new Object[0]);
        }
        converter = HttpServiceMethod.createResponseConverter((Retrofit)object, (Method)converter, (Type)annotationArray);
        object = ((Retrofit)object).callFactory;
        if (!bl2) {
            return new CallAdapted(requestFactory, (Call.Factory)object, converter, (CallAdapter)parameterizedTypeImpl);
        }
        if (!bl) return new SuspendForBody(requestFactory, (Call.Factory)object, converter, (CallAdapter)parameterizedTypeImpl, false);
        return new SuspendForResponse(requestFactory, (Call.Factory)object, converter, (CallAdapter)parameterizedTypeImpl);
    }

    @Nullable
    protected abstract ReturnT adapt(Call<ResponseT> var1, Object[] var2);

    @Nullable
    final ReturnT invoke(Object[] objectArray) {
        return this.adapt((Call<ResponseT>)new OkHttpCall(this.requestFactory, objectArray, this.callFactory, this.responseConverter), objectArray);
    }
}
