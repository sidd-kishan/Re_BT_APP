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

static final class ParameterHandler.FieldMap<T>
extends ParameterHandler<Map<String, T>> {
    private final boolean encoded;
    private final Method method;
    private final int p;
    private final Converter<T, String> valueConverter;

    ParameterHandler.FieldMap(Method method, int n, Converter<T, String> converter, boolean bl) {
        this.method = method;
        this.p = n;
        this.valueConverter = converter;
        this.encoded = bl;
    }

    void apply(RequestBuilder object, @Nullable Map<String, T> object2) throws IOException {
        if (object2 == null) {
            object = Utils.parameterError((Method)this.method, (int)this.p, (String)"Field map was null.", (Object[])new Object[0]);
            throw object;
        }
        Object object3 = object2.entrySet().iterator();
        while (object3.hasNext()) {
            Map.Entry<String, T> entry = object3.next();
            object2 = entry.getKey();
            if (object2 == null) throw Utils.parameterError((Method)this.method, (int)this.p, (String)"Field map contained null key.", (Object[])new Object[0]);
            if ((entry = entry.getValue()) == null) {
                entry = this.method;
                int n = this.p;
                object = new StringBuilder();
                ((StringBuilder)object).append("Field map contained null value for key '");
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append("'.");
                throw Utils.parameterError((Method)((Object)entry), (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
            }
            String string = (String)this.valueConverter.convert(entry);
            if (string == null) {
                object3 = this.method;
                int n = this.p;
                object = new StringBuilder();
                ((StringBuilder)object).append("Field map value '");
                ((StringBuilder)object).append(entry);
                ((StringBuilder)object).append("' converted to null by ");
                ((StringBuilder)object).append(this.valueConverter.getClass().getName());
                ((StringBuilder)object).append(" for key '");
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append("'.");
                throw Utils.parameterError((Method)object3, (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
            }
            object.addFormField((String)object2, string, this.encoded);
        }
    }
}
