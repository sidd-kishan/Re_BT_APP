/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Converter
 */
package retrofit2;

import retrofit2.Converter;

static final class BuiltInConverters.ToStringConverter
implements Converter<Object, String> {
    static final BuiltInConverters.ToStringConverter INSTANCE = new BuiltInConverters.ToStringConverter();

    BuiltInConverters.ToStringConverter() {
    }

    public String convert(Object object) {
        return object.toString();
    }
}
