/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.RequestBody
 *  okhttp3.ResponseBody
 *  retrofit2.Converter
 *  retrofit2.Retrofit
 *  retrofit2.Utils
 */
package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.Utils;

public static abstract class Converter.Factory {
    protected static Type getParameterUpperBound(int n, ParameterizedType parameterizedType) {
        return Utils.getParameterUpperBound((int)n, (ParameterizedType)parameterizedType);
    }

    protected static Class<?> getRawType(Type type) {
        return Utils.getRawType((Type)type);
    }

    @Nullable
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArray, Annotation[] annotationArray2, Retrofit retrofit) {
        return null;
    }

    @Nullable
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArray, Retrofit retrofit) {
        return null;
    }

    @Nullable
    public Converter<?, String> stringConverter(Type type, Annotation[] annotationArray, Retrofit retrofit) {
        return null;
    }
}
