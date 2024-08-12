/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;
import retrofit2.Utils;

static final class ParameterHandler.Body<T>
extends ParameterHandler<T> {
    private final Converter<T, RequestBody> converter;
    private final Method method;
    private final int p;

    ParameterHandler.Body(Method method, int n, Converter<T, RequestBody> converter) {
        this.method = method;
        this.p = n;
        this.converter = converter;
    }

    void apply(RequestBuilder requestBuilder, @Nullable T t) {
        RequestBody requestBody;
        if (t == null) throw Utils.parameterError((Method)this.method, (int)this.p, (String)"Body parameter value must not be null.", (Object[])new Object[0]);
        try {
            requestBody = (RequestBody)this.converter.convert(t);
        }
        catch (IOException iOException) {
            Method method = this.method;
            int n = this.p;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to convert ");
            stringBuilder.append(t);
            stringBuilder.append(" to RequestBody");
            throw Utils.parameterError((Method)method, (Throwable)iOException, (int)n, (String)stringBuilder.toString(), (Object[])new Object[0]);
        }
        requestBuilder.setBody(requestBody);
    }
}
