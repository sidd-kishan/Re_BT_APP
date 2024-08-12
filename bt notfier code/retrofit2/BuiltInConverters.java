/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Unit
 *  okhttp3.RequestBody
 *  okhttp3.ResponseBody
 *  retrofit2.BuiltInConverters$BufferingResponseBodyConverter
 *  retrofit2.BuiltInConverters$RequestBodyConverter
 *  retrofit2.BuiltInConverters$StreamingResponseBodyConverter
 *  retrofit2.BuiltInConverters$UnitResponseBodyConverter
 *  retrofit2.BuiltInConverters$VoidResponseBodyConverter
 *  retrofit2.Converter
 *  retrofit2.Converter$Factory
 *  retrofit2.Retrofit
 *  retrofit2.Utils
 *  retrofit2.http.Streaming
 */
package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.BuiltInConverters;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.Utils;
import retrofit2.http.Streaming;

final class BuiltInConverters
extends Converter.Factory {
    private boolean checkForKotlinUnit = true;

    BuiltInConverters() {
    }

    @Nullable
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArray, Annotation[] annotationArray2, Retrofit retrofit) {
        if (!RequestBody.class.isAssignableFrom(Utils.getRawType((Type)type))) return null;
        return RequestBodyConverter.INSTANCE;
    }

    @Nullable
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArray, Retrofit retrofit) {
        if (type == ResponseBody.class) {
            type = Utils.isAnnotationPresent((Annotation[])annotationArray, Streaming.class) ? StreamingResponseBodyConverter.INSTANCE : BufferingResponseBodyConverter.INSTANCE;
            return type;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        }
        if (!this.checkForKotlinUnit) return null;
        if (type != Unit.class) return null;
        try {
            type = UnitResponseBodyConverter.INSTANCE;
            return type;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            this.checkForKotlinUnit = false;
        }
        return null;
    }
}
