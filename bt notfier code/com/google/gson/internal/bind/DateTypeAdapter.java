/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class DateTypeAdapter
extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory(){

        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            return typeToken.getRawType() == Date.class ? new DateTypeAdapter() : null;
        }
    };
    private final List<DateFormat> dateFormats;

    public DateTypeAdapter() {
        ArrayList<DateFormat> arrayList = new ArrayList<DateFormat>();
        this.dateFormats = arrayList;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (!JavaVersion.isJava9OrLater()) return;
        this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private Date deserializeToDate(String string) {
        synchronized (this) {
            Object object;
            for (DateFormat dateFormat : this.dateFormats) {
                try {
                    return dateFormat.parse(string);
                }
                catch (ParseException parseException) {
                }
            }
            try {
                object = new ParsePosition(0);
                return ISO8601Utils.parse(string, (ParsePosition)object);
            }
            catch (ParseException parseException) {
                object = new JsonSyntaxException(string, parseException);
                throw object;
            }
        }
    }

    @Override
    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) return this.deserializeToDate(jsonReader.nextString());
        jsonReader.nextNull();
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    @Override
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        synchronized (this) {
            void var2_2;
            if (var2_2 == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.value(this.dateFormats.get(0).format((Date)var2_2));
            return;
        }
    }
}
