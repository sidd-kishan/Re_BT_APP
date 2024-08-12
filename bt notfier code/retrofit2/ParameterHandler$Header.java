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
import java.util.Objects;
import javax.annotation.Nullable;
import retrofit2.Converter;
import retrofit2.ParameterHandler;
import retrofit2.RequestBuilder;

static final class ParameterHandler.Header<T>
extends ParameterHandler<T> {
    private final String name;
    private final Converter<T, String> valueConverter;

    ParameterHandler.Header(String string, Converter<T, String> converter) {
        this.name = Objects.requireNonNull(string, "name == null");
        this.valueConverter = converter;
    }

    void apply(RequestBuilder requestBuilder, @Nullable T object) throws IOException {
        if (object == null) {
            return;
        }
        if ((object = (String)this.valueConverter.convert(object)) == null) {
            return;
        }
        requestBuilder.addHeader(this.name, object);
    }
}
