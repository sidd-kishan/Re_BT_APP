/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.RequestBody
 *  retrofit2.Converter
 */
package retrofit2;

import okhttp3.RequestBody;
import retrofit2.Converter;

static final class BuiltInConverters.RequestBodyConverter
implements Converter<RequestBody, RequestBody> {
    static final BuiltInConverters.RequestBodyConverter INSTANCE = new BuiltInConverters.RequestBodyConverter();

    BuiltInConverters.RequestBodyConverter() {
    }

    public RequestBody convert(RequestBody requestBody) {
        return requestBody;
    }
}
