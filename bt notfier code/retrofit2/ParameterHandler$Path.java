/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Converter
 *  retrofit2.ParameterHandler
 *  retrofit2.RequestBuilder
 *  retrofit2.Utils
 */
package retrofit2;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;
import javax.annotation.Nullable;
import retrofit2.Converter;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;
import retrofit2.Utils;

static final class ParameterHandler.Path<T>
extends ParameterHandler<T> {
    private final boolean encoded;
    private final Method method;
    private final String name;
    private final int p;
    private final Converter<T, String> valueConverter;

    ParameterHandler.Path(Method method, int n, String string, Converter<T, String> converter, boolean bl) {
        this.method = method;
        this.p = n;
        this.name = Objects.requireNonNull(string, "name == null");
        this.valueConverter = converter;
        this.encoded = bl;
    }

    void apply(RequestBuilder object, @Nullable T object2) throws IOException {
        if (object2 != null) {
            object.addPathParam(this.name, (String)this.valueConverter.convert(object2), this.encoded);
            return;
        }
        object2 = this.method;
        int n = this.p;
        object = new StringBuilder();
        ((StringBuilder)object).append("Path parameter \"");
        ((StringBuilder)object).append(this.name);
        ((StringBuilder)object).append("\" value must not be null.");
        throw Utils.parameterError(object2, (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
    }
}
