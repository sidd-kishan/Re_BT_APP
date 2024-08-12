/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Converter
 *  retrofit2.ParameterHandler
 *  retrofit2.RequestBuilder
 */
package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import retrofit2.Converter;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;

static final class ParameterHandler.QueryName<T>
extends ParameterHandler<T> {
    private final boolean encoded;
    private final Converter<T, String> nameConverter;

    ParameterHandler.QueryName(Converter<T, String> converter, boolean bl) {
        this.nameConverter = converter;
        this.encoded = bl;
    }

    void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
        if (t == null) {
            return;
        }
        requestBuilder.addQueryParam((String)this.nameConverter.convert(t), null, this.encoded);
    }
}
