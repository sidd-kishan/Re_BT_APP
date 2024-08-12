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

static final class BuiltInConverters.VoidResponseBodyConverter
implements Converter<ResponseBody, Void> {
    static final BuiltInConverters.VoidResponseBodyConverter INSTANCE = new BuiltInConverters.VoidResponseBodyConverter();

    BuiltInConverters.VoidResponseBodyConverter() {
    }

    public Void convert(ResponseBody responseBody) {
        responseBody.close();
        return null;
    }
}
