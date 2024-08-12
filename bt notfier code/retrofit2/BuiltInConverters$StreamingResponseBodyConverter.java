/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.ResponseBody
 *  retrofit2.Converter
 */
package retrofit2;

import okhttp3.ResponseBody;
import retrofit2.Converter;

static final class BuiltInConverters.StreamingResponseBodyConverter
implements Converter<ResponseBody, ResponseBody> {
    static final BuiltInConverters.StreamingResponseBodyConverter INSTANCE = new BuiltInConverters.StreamingResponseBodyConverter();

    BuiltInConverters.StreamingResponseBodyConverter() {
    }

    public ResponseBody convert(ResponseBody responseBody) {
        return responseBody;
    }
}
