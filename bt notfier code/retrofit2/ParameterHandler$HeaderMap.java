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
import java.util.Map;
import javax.annotation.Nullable;
import retrofit2.Converter;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;
import retrofit2.Utils;

static final class ParameterHandler.HeaderMap<T>
extends ParameterHandler<Map<String, T>> {
    private final Method method;
    private final int p;
    private final Converter<T, String> valueConverter;

    ParameterHandler.HeaderMap(Method method, int n, Converter<T, String> converter) {
        this.method = method;
        this.p = n;
        this.valueConverter = converter;
    }

    void apply(RequestBuilder object, @Nullable Map<String, T> object2) throws IOException {
        if (object2 == null) {
            object = Utils.parameterError((Method)this.method, (int)this.p, (String)"Header map was null.", (Object[])new Object[0]);
            throw object;
        }
        Object object3 = object2.entrySet().iterator();
        while (object3.hasNext()) {
            Map.Entry<String, Object> entry = object3.next();
            object2 = entry.getKey();
            if (object2 == null) throw Utils.parameterError((Method)this.method, (int)this.p, (String)"Header map contained null key.", (Object[])new Object[0]);
            if ((entry = entry.getValue()) == null) {
                object = this.method;
                int n = this.p;
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Header map contained null value for key '");
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append("'.");
                throw Utils.parameterError((Method)object, (int)n, (String)((StringBuilder)object3).toString(), (Object[])new Object[0]);
            }
            object.addHeader((String)object2, (String)this.valueConverter.convert(entry));
        }
    }
}
