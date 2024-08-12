/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.ResponseBody
 *  retrofit2.Converter
 *  retrofit2.Utils
 */
package retrofit2;

import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Utils;

static final class BuiltInConverters.BufferingResponseBodyConverter
implements Converter<ResponseBody, ResponseBody> {
    static final BuiltInConverters.BufferingResponseBodyConverter INSTANCE = new BuiltInConverters.BufferingResponseBodyConverter();

    BuiltInConverters.BufferingResponseBodyConverter() {
    }

    public ResponseBody convert(ResponseBody responseBody) throws IOException {
        try {
            ResponseBody responseBody2 = Utils.buffer((ResponseBody)responseBody);
            return responseBody2;
        }
        finally {
            responseBody.close();
        }
    }
}
