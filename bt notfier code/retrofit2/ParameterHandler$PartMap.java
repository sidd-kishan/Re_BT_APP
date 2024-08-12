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
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;
import retrofit2.Utils;

static final class ParameterHandler.PartMap<T>
extends ParameterHandler<Map<String, T>> {
    private final Method method;
    private final int p;
    private final String transferEncoding;
    private final Converter<T, RequestBody> valueConverter;

    ParameterHandler.PartMap(Method method, int n, Converter<T, RequestBody> converter, String string) {
        this.method = method;
        this.p = n;
        this.valueConverter = converter;
        this.transferEncoding = string;
    }

    void apply(RequestBuilder object, @Nullable Map<String, T> object2) throws IOException {
        if (object2 == null) {
            object = Utils.parameterError((Method)this.method, (int)this.p, (String)"Part map was null.", (Object[])new Object[0]);
            throw object;
        }
        Object object3 = object2.entrySet().iterator();
        while (object3.hasNext()) {
            Map.Entry<String, T> entry = object3.next();
            object2 = entry.getKey();
            if (object2 == null) throw Utils.parameterError((Method)this.method, (int)this.p, (String)"Part map contained null key.", (Object[])new Object[0]);
            T t = entry.getValue();
            if (t == null) {
                object3 = this.method;
                int n = this.p;
                object = new StringBuilder();
                ((StringBuilder)object).append("Part map contained null value for key '");
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append("'.");
                throw Utils.parameterError((Method)object3, (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
            }
            entry = new StringBuilder();
            ((StringBuilder)((Object)entry)).append("form-data; name=\"");
            ((StringBuilder)((Object)entry)).append((String)object2);
            ((StringBuilder)((Object)entry)).append("\"");
            object.addPart(Headers.of((String[])new String[]{"Content-Disposition", ((StringBuilder)((Object)entry)).toString(), "Content-Transfer-Encoding", this.transferEncoding}), (RequestBody)this.valueConverter.convert(t));
        }
    }
}
