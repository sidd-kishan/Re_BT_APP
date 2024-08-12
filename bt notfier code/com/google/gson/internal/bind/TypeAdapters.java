/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class TypeAdapters {
    public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
    public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER;
    public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
    public static final TypeAdapter<BigInteger> BIG_INTEGER;
    public static final TypeAdapter<BitSet> BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter<Boolean> BOOLEAN;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter<Number> BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter<Calendar> CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter<Character> CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter<Class> CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter<Currency> CURRENCY;
    public static final TypeAdapterFactory CURRENCY_FACTORY;
    public static final TypeAdapter<Number> DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter<Number> FLOAT;
    public static final TypeAdapter<InetAddress> INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter<Number> INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter<Locale> LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter<Number> LONG;
    public static final TypeAdapter<Number> SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter<String> STRING;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapter<URI> URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter<URL> URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter<UUID> UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    static {
        TypeAdapter<Serializable> typeAdapter = new TypeAdapter<Class>(){

            @Override
            public void write(JsonWriter out, Class value) throws IOException {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + value.getName() + ". Forgot to register a type adapter?");
            }

            @Override
            public Class read(JsonReader in) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
        }.nullSafe();
        CLASS = typeAdapter;
        CLASS_FACTORY = TypeAdapters.newFactory(Class.class, typeAdapter);
        typeAdapter = new TypeAdapter<BitSet>(){

            /*
             * Unable to fully structure code
             */
            @Override
            public BitSet read(JsonReader in) throws IOException {
                bitset = new BitSet();
                in.beginArray();
                i = 0;
                tokenType = in.peek();
                block4: while (true) {
                    if (tokenType == JsonToken.END_ARRAY) {
                        in.endArray();
                        return bitset;
                    }
                    switch (35.$SwitchMap$com$google$gson$stream$JsonToken[tokenType.ordinal()]) {
                        case 1: 
                        case 2: {
                            intValue = in.nextInt();
                            if (intValue == 0) {
                                set = false;
                            } else {
                                if (intValue != 1) throw new JsonSyntaxException("Invalid bitset value " + intValue + ", expected 0 or 1; at path " + in.getPreviousPath());
                                set = true;
                            }
                            ** GOTO lbl20
                        }
                        case 3: {
                            set = in.nextBoolean();
lbl20:
                            // 3 sources

                            if (set) {
                                bitset.set(i);
                            }
                            ++i;
                            tokenType = in.peek();
                            continue block4;
                        }
                    }
                    break;
                }
                throw new JsonSyntaxException("Invalid bitset value type: " + (Object)tokenType + "; at path " + in.getPath());
            }

            @Override
            public void write(JsonWriter out, BitSet src) throws IOException {
                out.beginArray();
                int i = 0;
                int length = src.length();
                while (true) {
                    if (i >= length) {
                        out.endArray();
                        return;
                    }
                    int value = src.get(i) ? 1 : 0;
                    out.value(value);
                    ++i;
                }
            }
        }.nullSafe();
        BIT_SET = typeAdapter;
        BIT_SET_FACTORY = TypeAdapters.newFactory(BitSet.class, typeAdapter);
        BOOLEAN = new TypeAdapter<Boolean>(){

            @Override
            public Boolean read(JsonReader in) throws IOException {
                JsonToken peek = in.peek();
                if (peek == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                if (peek != JsonToken.STRING) return in.nextBoolean();
                return Boolean.parseBoolean(in.nextString());
            }

            @Override
            public void write(JsonWriter out, Boolean value) throws IOException {
                out.value(value);
            }
        };
        BOOLEAN_AS_STRING = new TypeAdapter<Boolean>(){

            @Override
            public Boolean read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) return Boolean.valueOf(in.nextString());
                in.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter out, Boolean value) throws IOException {
                out.value(value == null ? "null" : value.toString());
            }
        };
        BOOLEAN_FACTORY = TypeAdapters.newFactory(Boolean.TYPE, Boolean.class, BOOLEAN);
        BYTE = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader in) throws IOException {
                int intValue;
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    intValue = in.nextInt();
                }
                catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
                if (intValue > 255) throw new JsonSyntaxException("Lossy conversion from " + intValue + " to byte; at path " + in.getPreviousPath());
                if (intValue >= -128) return (byte)intValue;
                throw new JsonSyntaxException("Lossy conversion from " + intValue + " to byte; at path " + in.getPreviousPath());
            }

            @Override
            public void write(JsonWriter out, Number value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    out.value(value.byteValue());
                }
            }
        };
        BYTE_FACTORY = TypeAdapters.newFactory(Byte.TYPE, Byte.class, BYTE);
        SHORT = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader in) throws IOException {
                int intValue;
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    intValue = in.nextInt();
                }
                catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
                if (intValue > 65535) throw new JsonSyntaxException("Lossy conversion from " + intValue + " to short; at path " + in.getPreviousPath());
                if (intValue >= Short.MIN_VALUE) return (short)intValue;
                throw new JsonSyntaxException("Lossy conversion from " + intValue + " to short; at path " + in.getPreviousPath());
            }

            @Override
            public void write(JsonWriter out, Number value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    out.value(value.shortValue());
                }
            }
        };
        SHORT_FACTORY = TypeAdapters.newFactory(Short.TYPE, Short.class, SHORT);
        INTEGER = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    return in.nextInt();
                }
                catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override
            public void write(JsonWriter out, Number value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    out.value(value.intValue());
                }
            }
        };
        INTEGER_FACTORY = TypeAdapters.newFactory(Integer.TYPE, Integer.class, INTEGER);
        typeAdapter = new TypeAdapter<AtomicInteger>(){

            @Override
            public AtomicInteger read(JsonReader in) throws IOException {
                try {
                    return new AtomicInteger(in.nextInt());
                }
                catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override
            public void write(JsonWriter out, AtomicInteger value) throws IOException {
                out.value(value.get());
            }
        }.nullSafe();
        ATOMIC_INTEGER = typeAdapter;
        ATOMIC_INTEGER_FACTORY = TypeAdapters.newFactory(AtomicInteger.class, typeAdapter);
        typeAdapter = new TypeAdapter<AtomicBoolean>(){

            @Override
            public AtomicBoolean read(JsonReader in) throws IOException {
                return new AtomicBoolean(in.nextBoolean());
            }

            @Override
            public void write(JsonWriter out, AtomicBoolean value) throws IOException {
                out.value(value.get());
            }
        }.nullSafe();
        ATOMIC_BOOLEAN = typeAdapter;
        ATOMIC_BOOLEAN_FACTORY = TypeAdapters.newFactory(AtomicBoolean.class, typeAdapter);
        typeAdapter = new TypeAdapter<AtomicIntegerArray>(){

            @Override
            public AtomicIntegerArray read(JsonReader in) throws IOException {
                ArrayList<Integer> list = new ArrayList<Integer>();
                in.beginArray();
                while (in.hasNext()) {
                    try {
                        int integer = in.nextInt();
                        list.add(integer);
                    }
                    catch (NumberFormatException e) {
                        throw new JsonSyntaxException(e);
                    }
                }
                in.endArray();
                int length = list.size();
                AtomicIntegerArray array = new AtomicIntegerArray(length);
                int i = 0;
                while (i < length) {
                    array.set(i, (Integer)list.get(i));
                    ++i;
                }
                return array;
            }

            @Override
            public void write(JsonWriter out, AtomicIntegerArray value) throws IOException {
                out.beginArray();
                int i = 0;
                int length = value.length();
                while (true) {
                    if (i >= length) {
                        out.endArray();
                        return;
                    }
                    out.value(value.get(i));
                    ++i;
                }
            }
        }.nullSafe();
        ATOMIC_INTEGER_ARRAY = typeAdapter;
        ATOMIC_INTEGER_ARRAY_FACTORY = TypeAdapters.newFactory(AtomicIntegerArray.class, typeAdapter);
        LONG = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    return in.nextLong();
                }
                catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override
            public void write(JsonWriter out, Number value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    out.value(value.longValue());
                }
            }
        };
        FLOAT = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) return Float.valueOf((float)in.nextDouble());
                in.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter out, Number value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    Number floatNumber = value instanceof Float ? (Number)value : (Number)Float.valueOf(value.floatValue());
                    out.value(floatNumber);
                }
            }
        };
        DOUBLE = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) return in.nextDouble();
                in.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter out, Number value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    out.value(value.doubleValue());
                }
            }
        };
        CHARACTER = new TypeAdapter<Character>(){

            @Override
            public Character read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                String str = in.nextString();
                if (str.length() == 1) return Character.valueOf(str.charAt(0));
                throw new JsonSyntaxException("Expecting character, got: " + str + "; at " + in.getPreviousPath());
            }

            @Override
            public void write(JsonWriter out, Character value) throws IOException {
                out.value(value == null ? null : String.valueOf(value));
            }
        };
        CHARACTER_FACTORY = TypeAdapters.newFactory(Character.TYPE, Character.class, CHARACTER);
        STRING = new TypeAdapter<String>(){

            @Override
            public String read(JsonReader in) throws IOException {
                JsonToken peek = in.peek();
                if (peek == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                if (peek != JsonToken.BOOLEAN) return in.nextString();
                return Boolean.toString(in.nextBoolean());
            }

            @Override
            public void write(JsonWriter out, String value) throws IOException {
                out.value(value);
            }
        };
        BIG_DECIMAL = new TypeAdapter<BigDecimal>(){

            @Override
            public BigDecimal read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                String s = in.nextString();
                try {
                    return new BigDecimal(s);
                }
                catch (NumberFormatException e) {
                    throw new JsonSyntaxException("Failed parsing '" + s + "' as BigDecimal; at path " + in.getPreviousPath(), e);
                }
            }

            @Override
            public void write(JsonWriter out, BigDecimal value) throws IOException {
                out.value(value);
            }
        };
        BIG_INTEGER = new TypeAdapter<BigInteger>(){

            @Override
            public BigInteger read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                String s = in.nextString();
                try {
                    return new BigInteger(s);
                }
                catch (NumberFormatException e) {
                    throw new JsonSyntaxException("Failed parsing '" + s + "' as BigInteger; at path " + in.getPreviousPath(), e);
                }
            }

            @Override
            public void write(JsonWriter out, BigInteger value) throws IOException {
                out.value(value);
            }
        };
        STRING_FACTORY = TypeAdapters.newFactory(String.class, STRING);
        STRING_BUILDER = typeAdapter = new TypeAdapter<LazilyParsedNumber>(){

            @Override
            public LazilyParsedNumber read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) return new LazilyParsedNumber(in.nextString());
                in.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter out, LazilyParsedNumber value) throws IOException {
                out.value(value);
            }
        };
        STRING_BUILDER_FACTORY = TypeAdapters.newFactory(StringBuilder.class, typeAdapter);
        STRING_BUFFER = typeAdapter = new TypeAdapter<StringBuilder>(){

            @Override
            public StringBuilder read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) return new StringBuilder(in.nextString());
                in.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter out, StringBuilder value) throws IOException {
                out.value(value == null ? null : value.toString());
            }
        };
        STRING_BUFFER_FACTORY = TypeAdapters.newFactory(StringBuffer.class, typeAdapter);
        URL = typeAdapter = new TypeAdapter<StringBuffer>(){

            @Override
            public StringBuffer read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) return new StringBuffer(in.nextString());
                in.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter out, StringBuffer value) throws IOException {
                out.value(value == null ? null : value.toString());
            }
        };
        URL_FACTORY = TypeAdapters.newFactory(URL.class, typeAdapter);
        URI = typeAdapter = new TypeAdapter<URL>(){

            @Override
            public URL read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) String nextString;
                return "null".equals(nextString = in.nextString()) ? null : new URL(nextString);
                in.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter out, URL value) throws IOException {
                out.value(value == null ? null : value.toExternalForm());
            }
        };
        URI_FACTORY = TypeAdapters.newFactory(URI.class, typeAdapter);
        INET_ADDRESS = typeAdapter = new TypeAdapter<URI>(){

            @Override
            public URI read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    String nextString = in.nextString();
                    return "null".equals(nextString) ? null : new URI(nextString);
                }
                catch (URISyntaxException e) {
                    throw new JsonIOException(e);
                }
            }

            @Override
            public void write(JsonWriter out, URI value) throws IOException {
                out.value(value == null ? null : value.toASCIIString());
            }
        };
        INET_ADDRESS_FACTORY = TypeAdapters.newTypeHierarchyFactory(InetAddress.class, typeAdapter);
        UUID = typeAdapter = new TypeAdapter<InetAddress>(){

            @Override
            public InetAddress read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) return InetAddress.getByName(in.nextString());
                in.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter out, InetAddress value) throws IOException {
                out.value(value == null ? null : value.getHostAddress());
            }
        };
        UUID_FACTORY = TypeAdapters.newFactory(UUID.class, typeAdapter);
        CURRENCY = typeAdapter = new TypeAdapter<UUID>(){

            @Override
            public UUID read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                String s = in.nextString();
                try {
                    return java.util.UUID.fromString(s);
                }
                catch (IllegalArgumentException e) {
                    throw new JsonSyntaxException("Failed parsing '" + s + "' as UUID; at path " + in.getPreviousPath(), e);
                }
            }

            @Override
            public void write(JsonWriter out, UUID value) throws IOException {
                out.value(value == null ? null : value.toString());
            }
        }.nullSafe();
        CURRENCY_FACTORY = TypeAdapters.newFactory(Currency.class, typeAdapter);
        CALENDAR = typeAdapter = new TypeAdapter<Currency>(){

            @Override
            public Currency read(JsonReader in) throws IOException {
                String s = in.nextString();
                try {
                    return Currency.getInstance(s);
                }
                catch (IllegalArgumentException e) {
                    throw new JsonSyntaxException("Failed parsing '" + s + "' as Currency; at path " + in.getPreviousPath(), e);
                }
            }

            @Override
            public void write(JsonWriter out, Currency value) throws IOException {
                out.value(value.getCurrencyCode());
            }
        };
        CALENDAR_FACTORY = TypeAdapters.newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, typeAdapter);
        LOCALE = typeAdapter = new TypeAdapter<Calendar>(){
            private static final String YEAR = "year";
            private static final String MONTH = "month";
            private static final String DAY_OF_MONTH = "dayOfMonth";
            private static final String HOUR_OF_DAY = "hourOfDay";
            private static final String MINUTE = "minute";
            private static final String SECOND = "second";

            @Override
            public Calendar read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                in.beginObject();
                int year = 0;
                int month = 0;
                int dayOfMonth = 0;
                int hourOfDay = 0;
                int minute = 0;
                int second = 0;
                while (true) {
                    if (in.peek() == JsonToken.END_OBJECT) {
                        in.endObject();
                        return new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
                    }
                    String name = in.nextName();
                    int value = in.nextInt();
                    if (YEAR.equals(name)) {
                        year = value;
                        continue;
                    }
                    if (MONTH.equals(name)) {
                        month = value;
                        continue;
                    }
                    if (DAY_OF_MONTH.equals(name)) {
                        dayOfMonth = value;
                        continue;
                    }
                    if (HOUR_OF_DAY.equals(name)) {
                        hourOfDay = value;
                        continue;
                    }
                    if (MINUTE.equals(name)) {
                        minute = value;
                        continue;
                    }
                    if (!SECOND.equals(name)) continue;
                    second = value;
                }
            }

            @Override
            public void write(JsonWriter out, Calendar value) throws IOException {
                if (value == null) {
                    out.nullValue();
                    return;
                }
                out.beginObject();
                out.name(YEAR);
                out.value(value.get(1));
                out.name(MONTH);
                out.value(value.get(2));
                out.name(DAY_OF_MONTH);
                out.value(value.get(5));
                out.name(HOUR_OF_DAY);
                out.value(value.get(11));
                out.name(MINUTE);
                out.value(value.get(12));
                out.name(SECOND);
                out.value(value.get(13));
                out.endObject();
            }
        };
        LOCALE_FACTORY = TypeAdapters.newFactory(Locale.class, typeAdapter);
        JSON_ELEMENT = typeAdapter = new TypeAdapter<Locale>(){

            @Override
            public Locale read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                String locale = in.nextString();
                StringTokenizer tokenizer = new StringTokenizer(locale, "_");
                String language = null;
                String country = null;
                String variant = null;
                if (tokenizer.hasMoreElements()) {
                    language = tokenizer.nextToken();
                }
                if (tokenizer.hasMoreElements()) {
                    country = tokenizer.nextToken();
                }
                if (tokenizer.hasMoreElements()) {
                    variant = tokenizer.nextToken();
                }
                if (country == null && variant == null) {
                    return new Locale(language);
                }
                if (variant != null) return new Locale(language, country, variant);
                return new Locale(language, country);
            }

            @Override
            public void write(JsonWriter out, Locale value) throws IOException {
                out.value(value == null ? null : value.toString());
            }
        };
        JSON_ELEMENT_FACTORY = TypeAdapters.newTypeHierarchyFactory(JsonElement.class, typeAdapter);
        ENUM_FACTORY = new TypeAdapter<JsonElement>(){

            private JsonElement tryBeginNesting(JsonReader in, JsonToken peeked) throws IOException {
                switch (peeked) {
                    case BEGIN_ARRAY: {
                        in.beginArray();
                        return new JsonArray();
                    }
                    case BEGIN_OBJECT: {
                        in.beginObject();
                        return new JsonObject();
                    }
                }
                return null;
            }

            private JsonElement readTerminal(JsonReader in, JsonToken peeked) throws IOException {
                switch (peeked) {
                    case STRING: {
                        return new JsonPrimitive(in.nextString());
                    }
                    case NUMBER: {
                        String number = in.nextString();
                        return new JsonPrimitive(new LazilyParsedNumber(number));
                    }
                    case BOOLEAN: {
                        return new JsonPrimitive(in.nextBoolean());
                    }
                    case NULL: {
                        in.nextNull();
                        return JsonNull.INSTANCE;
                    }
                }
                throw new IllegalStateException("Unexpected token: " + (Object)((Object)peeked));
            }

            @Override
            public JsonElement read(JsonReader in) throws IOException {
                if (in instanceof JsonTreeReader) {
                    return ((JsonTreeReader)in).nextJsonElement();
                }
                JsonToken peeked = in.peek();
                JsonElement current = this.tryBeginNesting(in, peeked);
                if (current == null) {
                    return this.readTerminal(in, peeked);
                }
                ArrayDeque<JsonElement> stack = new ArrayDeque<JsonElement>();
                while (true) {
                    if (in.hasNext()) {
                        JsonElement value;
                        boolean isNesting;
                        String name = null;
                        if (current instanceof JsonObject) {
                            name = in.nextName();
                        }
                        boolean bl = isNesting = (value = this.tryBeginNesting(in, peeked = in.peek())) != null;
                        if (value == null) {
                            value = this.readTerminal(in, peeked);
                        }
                        if (current instanceof JsonArray) {
                            ((JsonArray)current).add(value);
                        } else {
                            ((JsonObject)current).add(name, value);
                        }
                        if (!isNesting) continue;
                        stack.addLast(current);
                        current = value;
                        continue;
                    }
                    if (current instanceof JsonArray) {
                        in.endArray();
                    } else {
                        in.endObject();
                    }
                    if (stack.isEmpty()) {
                        return current;
                    }
                    current = (JsonElement)stack.removeLast();
                }
            }

            @Override
            public void write(JsonWriter out, JsonElement value) throws IOException {
                if (value == null || value.isJsonNull()) {
                    out.nullValue();
                } else if (value.isJsonPrimitive()) {
                    JsonPrimitive primitive = value.getAsJsonPrimitive();
                    if (primitive.isNumber()) {
                        out.value(primitive.getAsNumber());
                    } else if (primitive.isBoolean()) {
                        out.value(primitive.getAsBoolean());
                    } else {
                        out.value(primitive.getAsString());
                    }
                } else if (value.isJsonArray()) {
                    out.beginArray();
                    for (JsonElement e : value.getAsJsonArray()) {
                        this.write(out, e);
                    }
                    out.endArray();
                } else {
                    if (!value.isJsonObject()) throw new IllegalArgumentException("Couldn't write " + value.getClass());
                    out.beginObject();
                    for (Map.Entry<String, JsonElement> e : value.getAsJsonObject().entrySet()) {
                        out.name(e.getKey());
                        this.write(out, e.getValue());
                    }
                    out.endObject();
                }
            }
        };
    }

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> typeToken, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory(typeToken, typeAdapter){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<T> rawType = typeToken.getRawType();
                if (!Enum.class.isAssignableFrom(rawType)) return null;
                if (rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                EnumTypeAdapter<T> adapter = new EnumTypeAdapter<T>(rawType);
                return adapter;
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> clazz, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory(clazz, typeAdapter){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                return typeToken.equals(clazz) ? typeAdapter : null;
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> clazz, Class<TT> clazz2, TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory(clazz, clazz2, typeAdapter){
            final /* synthetic */ Class val$type;
            final /* synthetic */ TypeAdapter val$typeAdapter;
            {
                this.val$type = clazz;
                this.val$typeAdapter = typeAdapter;
            }

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                return typeToken.getRawType() == this.val$type ? this.val$typeAdapter : null;
            }

            public String toString() {
                return "Factory[type=" + this.val$type.getName() + ",adapter=" + this.val$typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(final Class<TT> clazz, final Class<? extends TT> clazz2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<T> rawType = typeToken.getRawType();
                return rawType == clazz || rawType == clazz2 ? typeAdapter : null;
            }

            public String toString() {
                return "Factory[type=" + clazz2.getName() + "+" + clazz.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(Class<T1> clazz, TypeAdapter<T1> typeAdapter) {
        return new TypeAdapterFactory(clazz, typeAdapter){
            final /* synthetic */ Class val$base;
            final /* synthetic */ Class val$sub;
            final /* synthetic */ TypeAdapter val$typeAdapter;
            {
                this.val$base = clazz;
                this.val$sub = clazz2;
                this.val$typeAdapter = typeAdapter;
            }

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<T> rawType = typeToken.getRawType();
                return rawType == this.val$base || rawType == this.val$sub ? this.val$typeAdapter : null;
            }

            public String toString() {
                return "Factory[type=" + this.val$base.getName() + "+" + this.val$sub.getName() + ",adapter=" + this.val$typeAdapter + "]";
            }
        };
    }

    private static final class EnumTypeAdapter<T extends Enum<T>>
    extends TypeAdapter<T> {
        private final Map<String, T> nameToConstant = new HashMap<String, T>();
        private final Map<String, T> stringToConstant = new HashMap<String, T>();
        private final Map<T, String> constantToName = new HashMap<T, String>();

        public EnumTypeAdapter(final Class<T> classOfT) {
            try {
                Field[] constantFields;
                Field[] fieldArray = constantFields = AccessController.doPrivileged(new PrivilegedAction<Field[]>(){

                    @Override
                    public Field[] run() {
                        Field[] fields = classOfT.getDeclaredFields();
                        ArrayList<Field> constantFieldsList = new ArrayList<Field>(fields.length);
                        Field[] fieldArray = fields;
                        int n = fieldArray.length;
                        int n2 = 0;
                        while (true) {
                            if (n2 >= n) {
                                AccessibleObject[] constantFields = constantFieldsList.toArray(new Field[0]);
                                AccessibleObject.setAccessible(constantFields, true);
                                return constantFields;
                            }
                            Field f = fieldArray[n2];
                            if (f.isEnumConstant()) {
                                constantFieldsList.add(f);
                            }
                            ++n2;
                        }
                    }
                });
                int n = fieldArray.length;
                int n2 = 0;
                while (n2 < n) {
                    Field constantField = fieldArray[n2];
                    Enum constant = (Enum)constantField.get(null);
                    String name = constant.name();
                    String toStringVal = constant.toString();
                    SerializedName annotation = constantField.getAnnotation(SerializedName.class);
                    if (annotation != null) {
                        name = annotation.value();
                        for (String alternate : annotation.alternate()) {
                            this.nameToConstant.put(alternate, constant);
                        }
                    }
                    this.nameToConstant.put(name, constant);
                    this.stringToConstant.put(toStringVal, constant);
                    this.constantToName.put(constant, name);
                    ++n2;
                }
                return;
            }
            catch (IllegalAccessException e) {
                throw new AssertionError((Object)e);
            }
        }

        @Override
        public T read(JsonReader in) throws IOException {
            if (in.peek() != JsonToken.NULL) String key;
            Enum constant;
            return (T)((constant = (Enum)this.nameToConstant.get(key = in.nextString())) == null ? (Enum)this.stringToConstant.get(key) : constant);
            in.nextNull();
            return null;
        }

        @Override
        public void write(JsonWriter out, T value) throws IOException {
            out.value(value == null ? null : this.constantToName.get(value));
        }
    }
}
