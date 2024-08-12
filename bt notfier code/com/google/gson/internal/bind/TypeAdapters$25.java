/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

class TypeAdapters.25
extends TypeAdapter<Calendar> {
    private static final String DAY_OF_MONTH = "dayOfMonth";
    private static final String HOUR_OF_DAY = "hourOfDay";
    private static final String MINUTE = "minute";
    private static final String MONTH = "month";
    private static final String SECOND = "second";
    private static final String YEAR = "year";

    TypeAdapters.25() {
    }

    @Override
    public Calendar read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        jsonReader.beginObject();
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        while (true) {
            if (jsonReader.peek() == JsonToken.END_OBJECT) {
                jsonReader.endObject();
                return new GregorianCalendar(n, n2, n3, n4, n5, n6);
            }
            String string = jsonReader.nextName();
            int n7 = jsonReader.nextInt();
            if (YEAR.equals(string)) {
                n = n7;
                continue;
            }
            if (MONTH.equals(string)) {
                n2 = n7;
                continue;
            }
            if (DAY_OF_MONTH.equals(string)) {
                n3 = n7;
                continue;
            }
            if (HOUR_OF_DAY.equals(string)) {
                n4 = n7;
                continue;
            }
            if (MINUTE.equals(string)) {
                n5 = n7;
                continue;
            }
            if (!SECOND.equals(string)) continue;
            n6 = n7;
        }
    }

    @Override
    public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
        if (calendar == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.name(YEAR);
        jsonWriter.value(calendar.get(1));
        jsonWriter.name(MONTH);
        jsonWriter.value(calendar.get(2));
        jsonWriter.name(DAY_OF_MONTH);
        jsonWriter.value(calendar.get(5));
        jsonWriter.name(HOUR_OF_DAY);
        jsonWriter.value(calendar.get(11));
        jsonWriter.name(MINUTE);
        jsonWriter.value(calendar.get(12));
        jsonWriter.name(SECOND);
        jsonWriter.value(calendar.get(13));
        jsonWriter.endObject();
    }
}
