/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.ParameterHandler
 *  retrofit2.RequestBuilder
 *  retrofit2.Utils
 */
package retrofit2;

import java.lang.reflect.Method;
import javax.annotation.Nullable;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;
import retrofit2.Utils;

static final class ParameterHandler.RelativeUrl
extends ParameterHandler<Object> {
    private final Method method;
    private final int p;

    ParameterHandler.RelativeUrl(Method method, int n) {
        this.method = method;
        this.p = n;
    }

    void apply(RequestBuilder requestBuilder, @Nullable Object object) {
        if (object == null) throw Utils.parameterError((Method)this.method, (int)this.p, (String)"@Url parameter is null.", (Object[])new Object[0]);
        requestBuilder.setRelativeUrl(object);
    }
}
