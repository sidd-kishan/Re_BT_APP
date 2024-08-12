/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.RequestBuilder
 */
package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import retrofit2.RequestBuilder;

abstract class ParameterHandler<T> {
    ParameterHandler() {
    }

    abstract void apply(RequestBuilder var1, @Nullable T var2) throws IOException;

    final ParameterHandler<Object> array() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    final ParameterHandler<Iterable<T>> iterable() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }
}
