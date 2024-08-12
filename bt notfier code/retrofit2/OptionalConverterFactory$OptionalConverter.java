/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.ResponseBody
 *  retrofit2.Converter
 */
package retrofit2;

import java.io.IOException;
import java.util.Optional;
import okhttp3.ResponseBody;
import retrofit2.Converter;

static final class OptionalConverterFactory.OptionalConverter<T>
implements Converter<ResponseBody, Optional<T>> {
    final Converter<ResponseBody, T> delegate;

    OptionalConverterFactory.OptionalConverter(Converter<ResponseBody, T> converter) {
        this.delegate = converter;
    }

    public Optional<T> convert(ResponseBody responseBody) throws IOException {
        return Optional.ofNullable(this.delegate.convert((Object)responseBody));
    }
}
