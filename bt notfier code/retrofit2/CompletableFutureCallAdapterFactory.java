/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.CallAdapter
 *  retrofit2.CallAdapter$Factory
 *  retrofit2.CompletableFutureCallAdapterFactory$BodyCallAdapter
 *  retrofit2.CompletableFutureCallAdapterFactory$ResponseCallAdapter
 *  retrofit2.Response
 *  retrofit2.Retrofit
 */
package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.CompletableFutureCallAdapterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

final class CompletableFutureCallAdapterFactory
extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = new CompletableFutureCallAdapterFactory();

    CompletableFutureCallAdapterFactory() {
    }

    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArray, Retrofit retrofit) {
        if (CompletableFutureCallAdapterFactory.getRawType((Type)type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        if (CompletableFutureCallAdapterFactory.getRawType((Type)(type = CompletableFutureCallAdapterFactory.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)type)))) != Response.class) {
            return new BodyCallAdapter(type);
        }
        if (!(type instanceof ParameterizedType)) throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        return new ResponseCallAdapter(CompletableFutureCallAdapterFactory.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)type)));
    }
}
