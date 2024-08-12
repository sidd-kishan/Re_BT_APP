/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.ParameterHandler
 *  retrofit2.RequestBuilder
 */
package retrofit2;

import java.io.IOException;
import java.util.Iterator;
import javax.annotation.Nullable;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;

class ParameterHandler.1
extends ParameterHandler<Iterable<T>> {
    final ParameterHandler this$0;

    ParameterHandler.1(ParameterHandler parameterHandler) {
        this.this$0 = parameterHandler;
    }

    void apply(RequestBuilder requestBuilder, @Nullable Iterable<T> iterable) throws IOException {
        if (iterable == null) {
            return;
        }
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            iterable = iterator.next();
            this.this$0.apply(requestBuilder, iterable);
        }
    }
}
