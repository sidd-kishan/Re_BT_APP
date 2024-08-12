/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Headers
 *  retrofit2.ParameterHandler
 *  retrofit2.RequestBuilder
 *  retrofit2.Utils
 */
package retrofit2;

import java.lang.reflect.Method;
import javax.annotation.Nullable;
import okhttp3.Headers;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;
import retrofit2.Utils;

static final class ParameterHandler.Headers
extends ParameterHandler<Headers> {
    private final Method method;
    private final int p;

    ParameterHandler.Headers(Method method, int n) {
        this.method = method;
        this.p = n;
    }

    void apply(RequestBuilder requestBuilder, @Nullable Headers headers) {
        if (headers == null) throw Utils.parameterError((Method)this.method, (int)this.p, (String)"Headers parameter must not be null.", (Object[])new Object[0]);
        requestBuilder.addHeaders(headers);
    }
}
