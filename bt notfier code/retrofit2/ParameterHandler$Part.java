/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Headers
 *  okhttp3.RequestBody
 *  retrofit2.Converter
 *  retrofit2.ParameterHandler
 *  retrofit2.RequestBuilder
 *  retrofit2.Utils
 */
package retrofit2;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;
import retrofit2.Utils;

static final class ParameterHandler.Part<T>
extends ParameterHandler<T> {
    private final Converter<T, RequestBody> converter;
    private final Headers headers;
    private final Method method;
    private final int p;

    ParameterHandler.Part(Method method, int n, Headers headers, Converter<T, RequestBody> converter) {
        this.method = method;
        this.p = n;
        this.headers = headers;
        this.converter = converter;
    }

    void apply(RequestBuilder object, @Nullable T t) {
        RequestBody requestBody;
        if (t == null) {
            return;
        }
        try {
            requestBody = (RequestBody)this.converter.convert(t);
        }
        catch (IOException iOException) {
            object = this.method;
            int n = this.p;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to convert ");
            stringBuilder.append(t);
            stringBuilder.append(" to RequestBody");
            throw Utils.parameterError((Method)object, (int)n, (String)stringBuilder.toString(), (Object[])new Object[]{iOException});
        }
        object.addPart(this.headers, requestBody);
    }
}
