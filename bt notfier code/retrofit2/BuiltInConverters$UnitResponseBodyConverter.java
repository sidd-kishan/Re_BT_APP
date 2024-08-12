/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Unit
 *  okhttp3.ResponseBody
 *  retrofit2.Converter
 */
package retrofit2;

import kotlin.Unit;
import okhttp3.ResponseBody;
import retrofit2.Converter;

static final class BuiltInConverters.UnitResponseBodyConverter
implements Converter<ResponseBody, Unit> {
    static final BuiltInConverters.UnitResponseBodyConverter INSTANCE = new BuiltInConverters.UnitResponseBodyConverter();

    BuiltInConverters.UnitResponseBodyConverter() {
    }

    public Unit convert(ResponseBody responseBody) {
        responseBody.close();
        return Unit.INSTANCE;
    }
}
