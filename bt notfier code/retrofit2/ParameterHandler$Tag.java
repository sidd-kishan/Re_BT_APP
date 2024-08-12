/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.ParameterHandler
 *  retrofit2.RequestBuilder
 */
package retrofit2;

import javax.annotation.Nullable;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;

static final class ParameterHandler.Tag<T>
extends ParameterHandler<T> {
    final Class<T> cls;

    ParameterHandler.Tag(Class<T> clazz) {
        this.cls = clazz;
    }

    void apply(RequestBuilder requestBuilder, @Nullable T t) {
        requestBuilder.addTag(this.cls, t);
    }
}
