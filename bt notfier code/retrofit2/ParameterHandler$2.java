/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.ParameterHandler
 *  retrofit2.RequestBuilder
 */
package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import javax.annotation.Nullable;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;

class ParameterHandler.2
extends ParameterHandler<Object> {
    final ParameterHandler this$0;

    ParameterHandler.2(ParameterHandler parameterHandler) {
        this.this$0 = parameterHandler;
    }

    void apply(RequestBuilder requestBuilder, @Nullable Object object) throws IOException {
        if (object == null) {
            return;
        }
        int n = 0;
        int n2 = Array.getLength(object);
        while (n < n2) {
            this.this$0.apply(requestBuilder, Array.get(object, n));
            ++n;
        }
    }
}
