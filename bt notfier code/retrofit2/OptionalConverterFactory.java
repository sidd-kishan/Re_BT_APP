/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.ResponseBody
 *  retrofit2.Converter
 *  retrofit2.Converter$Factory
 *  retrofit2.OptionalConverterFactory$OptionalConverter
 *  retrofit2.Retrofit
 */
package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.OptionalConverterFactory;
import retrofit2.Retrofit;

final class OptionalConverterFactory
extends Converter.Factory {
    static final Converter.Factory INSTANCE = new OptionalConverterFactory();

    OptionalConverterFactory() {
    }

    @Nullable
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArray, Retrofit retrofit) {
        if (OptionalConverterFactory.getRawType((Type)type) == Optional.class) return new OptionalConverter(retrofit.responseBodyConverter(OptionalConverterFactory.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)type)), annotationArray));
        return null;
    }
}
