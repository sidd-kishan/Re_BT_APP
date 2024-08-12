/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Call
 *  retrofit2.CallAdapter
 *  retrofit2.CallAdapter$Factory
 *  retrofit2.Retrofit
 *  retrofit2.SkipCallbackExecutor
 *  retrofit2.Utils
 */
package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.SkipCallbackExecutor;
import retrofit2.Utils;

final class DefaultCallAdapterFactory
extends CallAdapter.Factory {
    @Nullable
    private final Executor callbackExecutor;

    DefaultCallAdapterFactory(@Nullable Executor executor) {
        this.callbackExecutor = executor;
    }

    @Nullable
    public CallAdapter<?, ?> get(Type object, Annotation[] annotationArray, Retrofit retrofit) {
        Type type = DefaultCallAdapterFactory.getRawType((Type)object);
        retrofit = null;
        if (type != Call.class) {
            return null;
        }
        if (!(object instanceof ParameterizedType)) throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        type = Utils.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)object));
        object = Utils.isAnnotationPresent((Annotation[])annotationArray, SkipCallbackExecutor.class) ? retrofit : this.callbackExecutor;
        return new /* Unavailable Anonymous Inner Class!! */;
    }
}
