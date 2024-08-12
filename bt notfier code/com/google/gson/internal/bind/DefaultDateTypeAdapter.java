/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class DefaultDateTypeAdapter<T extends Date>
extends TypeAdapter<T> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats = new ArrayList<DateFormat>();
    private final DateType<T> dateType;

    private DefaultDateTypeAdapter(DateType<T> dateType, int n) {
        this.dateType = $Gson$Preconditions.checkNotNull(dateType);
        this.dateFormats.add(DateFormat.getDateInstance(n, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateInstance(n));
        }
        if (!JavaVersion.isJava9OrLater()) return;
        this.dateFormats.add(PreJava9DateFormatProvider.getUSDateFormat(n));
    }

    private DefaultDateTypeAdapter(DateType<T> dateType, int n, int n2) {
        this.dateType = $Gson$Preconditions.checkNotNull(dateType);
        this.dateFormats.add(DateFormat.getDateTimeInstance(n, n2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(n, n2));
        }
        if (!JavaVersion.isJava9OrLater()) return;
        this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(n, n2));
    }

    private DefaultDateTypeAdapter(DateType<T> dateType, String string) {
        this.dateType = $Gson$Preconditions.checkNotNull(dateType);
        this.dateFormats.add(new SimpleDateFormat(string, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) return;
        this.dateFormats.add(new SimpleDateFormat(string));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private Date deserializeToDate(String string) {
        Object object = this.dateFormats;
        synchronized (object) {
            for (Cloneable cloneable : this.dateFormats) {
                try {
                    return cloneable.parse(string);
                }
                catch (ParseException parseException) {
                }
            }
        }
        try {
            object = new ParsePosition(0);
            return ISO8601Utils.parse(string, (ParsePosition)object);
        }
        catch (ParseException parseException) {
            throw new JsonSyntaxException(string, parseException);
        }
    }

    @Override
    public T read(JsonReader object) throws IOException {
        if (((JsonReader)object).peek() == JsonToken.NULL) {
            ((JsonReader)object).nextNull();
            return null;
        }
        object = this.deserializeToDate(((JsonReader)object).nextString());
        return this.dateType.deserialize((Date)object);
    }

    public String toString() {
        DateFormat dateFormat = this.dateFormats.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DefaultDateTypeAdapter(");
            stringBuilder.append(((SimpleDateFormat)dateFormat).toPattern());
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DefaultDateTypeAdapter(");
        stringBuilder.append(dateFormat.getClass().getSimpleName());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        List<DateFormat> list = this.dateFormats;
        synchronized (list) {
            jsonWriter.value(this.dateFormats.get(0).format(date));
            return;
        }
    }

    public static abstract class DateType<T extends Date> {
        public static final DateType<Date> DATE = new DateType<Date>(Date.class){

            @Override
            protected Date deserialize(Date date) {
                return date;
            }
        };
        private final Class<T> dateClass;

        protected DateType(Class<T> dateClass) {
            this.dateClass = dateClass;
        }

        protected abstract T deserialize(Date var1);

        private TypeAdapterFactory createFactory(DefaultDateTypeAdapter<T> adapter) {
            return TypeAdapters.newFactory(this.dateClass, adapter);
        }

        public final TypeAdapterFactory createAdapterFactory(String datePattern) {
            return this.createFactory(new DefaultDateTypeAdapter(this, datePattern));
        }

        public final TypeAdapterFactory createAdapterFactory(int style) {
            return this.createFactory(new DefaultDateTypeAdapter(this, style));
        }

        public final TypeAdapterFactory createAdapterFactory(int dateStyle, int timeStyle) {
            return this.createFactory(new DefaultDateTypeAdapter(this, dateStyle, timeStyle));
        }

        public final TypeAdapterFactory createDefaultsAdapterFactory() {
            return this.createFactory(new DefaultDateTypeAdapter(this, 2, 2));
        }
    }
}
