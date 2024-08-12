/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final TypeToken<?> NULL_KEY_SURROGATE = TypeToken.get(Object.class);
    final List<TypeAdapterFactory> builderFactories;
    final List<TypeAdapterFactory> builderHierarchyFactories;
    private final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> calls = new ThreadLocal();
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;
    final String datePattern;
    final int dateStyle;
    final Excluder excluder;
    final List<TypeAdapterFactory> factories;
    final FieldNamingStrategy fieldNamingStrategy;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final Map<Type, InstanceCreator<?>> instanceCreators;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final boolean lenient;
    final LongSerializationPolicy longSerializationPolicy;
    final ToNumberStrategy numberToNumberStrategy;
    final ToNumberStrategy objectToNumberStrategy;
    final boolean prettyPrinting;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    final int timeStyle;
    private final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache = new ConcurrentHashMap();

    public Gson() {
        this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), ToNumberPolicy.DOUBLE, ToNumberPolicy.LAZILY_PARSED_NUMBER);
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> object, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, LongSerializationPolicy object2, String string, int n, int n2, List<TypeAdapterFactory> list, List<TypeAdapterFactory> list2, List<TypeAdapterFactory> list3, ToNumberStrategy toNumberStrategy, ToNumberStrategy toNumberStrategy2) {
        this.excluder = excluder;
        this.fieldNamingStrategy = fieldNamingStrategy;
        this.instanceCreators = object;
        this.constructorConstructor = new ConstructorConstructor(object);
        this.serializeNulls = bl;
        this.complexMapKeySerialization = bl2;
        this.generateNonExecutableJson = bl3;
        this.htmlSafe = bl4;
        this.prettyPrinting = bl5;
        this.lenient = bl6;
        this.serializeSpecialFloatingPointValues = bl7;
        this.longSerializationPolicy = object2;
        this.datePattern = string;
        this.dateStyle = n;
        this.timeStyle = n2;
        this.builderFactories = list;
        this.builderHierarchyFactories = list2;
        this.objectToNumberStrategy = toNumberStrategy;
        this.numberToNumberStrategy = toNumberStrategy2;
        object = new ArrayList();
        object.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        object.add(ObjectTypeAdapter.getFactory(toNumberStrategy));
        object.add(excluder);
        object.addAll(list3);
        object.add(TypeAdapters.STRING_FACTORY);
        object.add(TypeAdapters.INTEGER_FACTORY);
        object.add(TypeAdapters.BOOLEAN_FACTORY);
        object.add(TypeAdapters.BYTE_FACTORY);
        object.add(TypeAdapters.SHORT_FACTORY);
        object2 = Gson.longAdapter(object2);
        object.add(TypeAdapters.newFactory(Long.TYPE, Long.class, object2));
        object.add(TypeAdapters.newFactory(Double.TYPE, Double.class, this.doubleAdapter(bl7)));
        object.add(TypeAdapters.newFactory(Float.TYPE, Float.class, this.floatAdapter(bl7)));
        object.add(NumberTypeAdapter.getFactory(toNumberStrategy2));
        object.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        object.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        object.add(TypeAdapters.newFactory(AtomicLong.class, Gson.atomicLongAdapter((TypeAdapter<Number>)object2)));
        object.add(TypeAdapters.newFactory(AtomicLongArray.class, Gson.atomicLongArrayAdapter((TypeAdapter<Number>)object2)));
        object.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        object.add(TypeAdapters.CHARACTER_FACTORY);
        object.add(TypeAdapters.STRING_BUILDER_FACTORY);
        object.add(TypeAdapters.STRING_BUFFER_FACTORY);
        object.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        object.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        object.add(TypeAdapters.URL_FACTORY);
        object.add(TypeAdapters.URI_FACTORY);
        object.add(TypeAdapters.UUID_FACTORY);
        object.add(TypeAdapters.CURRENCY_FACTORY);
        object.add(TypeAdapters.LOCALE_FACTORY);
        object.add(TypeAdapters.INET_ADDRESS_FACTORY);
        object.add(TypeAdapters.BIT_SET_FACTORY);
        object.add(DateTypeAdapter.FACTORY);
        object.add(TypeAdapters.CALENDAR_FACTORY);
        if (SqlTypesSupport.SUPPORTS_SQL_TYPES) {
            object.add(SqlTypesSupport.TIME_FACTORY);
            object.add(SqlTypesSupport.DATE_FACTORY);
            object.add(SqlTypesSupport.TIMESTAMP_FACTORY);
        }
        object.add(ArrayTypeAdapter.FACTORY);
        object.add(TypeAdapters.CLASS_FACTORY);
        object.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
        object.add(new MapTypeAdapterFactory(this.constructorConstructor, bl2));
        object2 = new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor);
        this.jsonAdapterFactory = object2;
        object.add(object2);
        object.add(TypeAdapters.ENUM_FACTORY);
        object.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, fieldNamingStrategy, excluder, this.jsonAdapterFactory));
        this.factories = Collections.unmodifiableList(object);
    }

    private static void assertFullConsumption(Object object, JsonReader jsonReader) {
        if (object == null) return;
        try {
            if (jsonReader.peek() == JsonToken.END_DOCUMENT) return;
            object = new JsonIOException("JSON document was not fully consumed.");
            throw object;
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
        catch (MalformedJsonException malformedJsonException) {
            throw new JsonSyntaxException(malformedJsonException);
        }
    }

    private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLong>(){

            @Override
            public void write(JsonWriter out, AtomicLong value) throws IOException {
                typeAdapter.write(out, value.get());
            }

            @Override
            public AtomicLong read(JsonReader in) throws IOException {
                Number value = (Number)typeAdapter.read(in);
                return new AtomicLong(value.longValue());
            }
        }.nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLongArray>(){

            @Override
            public void write(JsonWriter out, AtomicLongArray value) throws IOException {
                out.beginArray();
                int i = 0;
                int length = value.length();
                while (true) {
                    if (i >= length) {
                        out.endArray();
                        return;
                    }
                    typeAdapter.write(out, value.get(i));
                    ++i;
                }
            }

            @Override
            public AtomicLongArray read(JsonReader in) throws IOException {
                ArrayList<Long> list = new ArrayList<Long>();
                in.beginArray();
                while (in.hasNext()) {
                    long value = ((Number)typeAdapter.read(in)).longValue();
                    list.add(value);
                }
                in.endArray();
                int length = list.size();
                AtomicLongArray array = new AtomicLongArray(length);
                int i = 0;
                while (i < length) {
                    array.set(i, (Long)list.get(i));
                    ++i;
                }
                return array;
            }
        }.nullSafe();
    }

    static void checkValidFloatingPoint(double d) {
        if (!Double.isNaN(d) && !Double.isInfinite(d)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d);
        stringBuilder.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private TypeAdapter<Number> doubleAdapter(boolean bl) {
        if (!bl) return new TypeAdapter<Number>(){

            @Override
            public Double read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) return in.nextDouble();
                in.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter out, Number value) throws IOException {
                if (value == null) {
                    out.nullValue();
                    return;
                }
                double doubleValue = value.doubleValue();
                Gson.checkValidFloatingPoint(doubleValue);
                out.value(doubleValue);
            }
        };
        return TypeAdapters.DOUBLE;
    }

    private TypeAdapter<Number> floatAdapter(boolean bl) {
        if (!bl) return new TypeAdapter<Number>(){

            @Override
            public Float read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) return Float.valueOf((float)in.nextDouble());
                in.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter out, Number value) throws IOException {
                if (value == null) {
                    out.nullValue();
                    return;
                }
                float floatValue = value.floatValue();
                Gson.checkValidFloatingPoint(floatValue);
                Number floatNumber = value instanceof Float ? (Number)value : (Number)Float.valueOf(floatValue);
                out.value(floatNumber);
            }
        };
        return TypeAdapters.FLOAT;
    }

    private static TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy != LongSerializationPolicy.DEFAULT) return new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader in) throws IOException {
                if (in.peek() != JsonToken.NULL) return in.nextLong();
                in.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter out, Number value) throws IOException {
                if (value == null) {
                    out.nullValue();
                    return;
                }
                out.value(value.toString());
            }
        };
        return TypeAdapters.LONG;
    }

    @Deprecated
    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> clazz) throws JsonSyntaxException {
        jsonElement = this.fromJson(jsonElement, (Type)clazz);
        return Primitives.wrap(clazz).cast(jsonElement);
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        if (jsonElement != null) return this.fromJson(new JsonTreeReader(jsonElement), type);
        return null;
    }

    /*
     * Exception decompiling
     */
    public <T> T fromJson(JsonReader var1_1, Type var2_2) throws JsonIOException, JsonSyntaxException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [10 : 47->127)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public <T> T fromJson(Reader closeable, Class<T> clazz) throws JsonSyntaxException, JsonIOException {
        closeable = this.newJsonReader((Reader)closeable);
        T t = this.fromJson((JsonReader)closeable, clazz);
        Gson.assertFullConsumption(t, (JsonReader)closeable);
        return Primitives.wrap(clazz).cast(t);
    }

    public <T> T fromJson(Reader closeable, Type type) throws JsonIOException, JsonSyntaxException {
        closeable = this.newJsonReader((Reader)closeable);
        type = this.fromJson((JsonReader)closeable, type);
        Gson.assertFullConsumption(type, (JsonReader)closeable);
        return (T)type;
    }

    public <T> T fromJson(String string, Class<T> clazz) throws JsonSyntaxException {
        string = this.fromJson(string, (Type)clazz);
        return Primitives.wrap(clazz).cast(string);
    }

    public <T> T fromJson(String string, Type type) throws JsonSyntaxException {
        if (string != null) return this.fromJson((Reader)new StringReader(string), type);
        return null;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        TypeAdapter<T> typeAdapter;
        Object object = this.typeTokenCache;
        Object object2 = typeToken == null ? NULL_KEY_SURROGATE : typeToken;
        if ((object2 = object.get(object2)) != null) {
            return object2;
        }
        object = this.calls.get();
        boolean bl = false;
        object2 = object;
        if (object == null) {
            object2 = new HashMap();
            this.calls.set((Map<TypeToken<?>, FutureTypeAdapter<?>>)object2);
            bl = true;
        }
        if ((object = (FutureTypeAdapter)object2.get(typeToken)) != null) {
            return object;
        }
        try {
            object = new FutureTypeAdapter();
            object2.put(typeToken, object);
            Iterator<TypeAdapterFactory> iterator = this.factories.iterator();
            while (iterator.hasNext()) {
                typeAdapter = iterator.next().create(this, typeToken);
                if (typeAdapter == null) continue;
                ((FutureTypeAdapter)object).setDelegate(typeAdapter);
                this.typeTokenCache.put(typeToken, typeAdapter);
                object2.remove(typeToken);
            }
        }
        catch (Throwable throwable) {
            object2.remove(typeToken);
            if (!bl) throw throwable;
            this.calls.remove();
            throw throwable;
        }
        {
            if (!bl) return typeAdapter;
            this.calls.remove();
            return typeAdapter;
        }
        typeAdapter = new StringBuilder();
        ((StringBuilder)((Object)typeAdapter)).append("GSON (2.8.9) cannot handle ");
        ((StringBuilder)((Object)typeAdapter)).append(typeToken);
        object = new IllegalArgumentException(((StringBuilder)((Object)typeAdapter)).toString());
        throw object;
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> clazz) {
        return this.getAdapter(TypeToken.get(clazz));
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory object, TypeToken<T> typeToken) {
        TypeAdapterFactory typeAdapterFactory = object;
        if (!this.factories.contains(object)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        boolean bl = false;
        object = this.factories.iterator();
        while (true) {
            if (!object.hasNext()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("GSON cannot serialize ");
                ((StringBuilder)object).append(typeToken);
                object = new IllegalArgumentException(((StringBuilder)object).toString());
                throw object;
            }
            Object object2 = (TypeAdapterFactory)object.next();
            if (!bl) {
                if (object2 != typeAdapterFactory) continue;
                bl = true;
                continue;
            }
            if ((object2 = object2.create(this, typeToken)) != null) return object2;
        }
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    public JsonReader newJsonReader(Reader closeable) {
        closeable = new JsonReader((Reader)closeable);
        ((JsonReader)closeable).setLenient(this.lenient);
        return closeable;
    }

    public JsonWriter newJsonWriter(Writer closeable) throws IOException {
        if (this.generateNonExecutableJson) {
            ((Writer)closeable).write(JSON_NON_EXECUTABLE_PREFIX);
        }
        closeable = new JsonWriter((Writer)closeable);
        if (this.prettyPrinting) {
            ((JsonWriter)closeable).setIndent("  ");
        }
        ((JsonWriter)closeable).setSerializeNulls(this.serializeNulls);
        return closeable;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        this.toJson(jsonElement, (Appendable)stringWriter);
        return stringWriter.toString();
    }

    public String toJson(Object object) {
        if (object != null) return this.toJson(object, object.getClass());
        return this.toJson(JsonNull.INSTANCE);
    }

    public String toJson(Object object, Type type) {
        StringWriter stringWriter = new StringWriter();
        this.toJson(object, type, stringWriter);
        return stringWriter.toString();
    }

    /*
     * Exception decompiling
     */
    public void toJson(JsonElement var1_1, JsonWriter var2_4) throws JsonIOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [3 : 66->134)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            this.toJson(jsonElement, this.newJsonWriter(Streams.writerForAppendable(appendable)));
            return;
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
    }

    public void toJson(Object object, Appendable appendable) throws JsonIOException {
        if (object != null) {
            this.toJson(object, object.getClass(), appendable);
        } else {
            this.toJson((JsonElement)JsonNull.INSTANCE, appendable);
        }
    }

    /*
     * Exception decompiling
     */
    public void toJson(Object var1_1, Type var2_3, JsonWriter var3_6) throws JsonIOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [3 : 78->140)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void toJson(Object object, Type type, Appendable appendable) throws JsonIOException {
        try {
            this.toJson(object, type, this.newJsonWriter(Streams.writerForAppendable(appendable)));
            return;
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
    }

    public JsonElement toJsonTree(Object object) {
        if (object != null) return this.toJsonTree(object, object.getClass());
        return JsonNull.INSTANCE;
    }

    public JsonElement toJsonTree(Object object, Type type) {
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        this.toJson(object, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{serializeNulls:");
        stringBuilder.append(this.serializeNulls);
        stringBuilder.append(",factories:");
        stringBuilder.append(this.factories);
        stringBuilder.append(",instanceCreators:");
        stringBuilder.append(this.constructorConstructor);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static class FutureTypeAdapter<T>
    extends SerializationDelegatingTypeAdapter<T> {
        private TypeAdapter<T> delegate = null;

        FutureTypeAdapter() {
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
                throw new AssertionError((Object)"Delegate is already set");
            }
            this.delegate = typeAdapter;
        }

        private TypeAdapter<T> delegate() {
            TypeAdapter<T> delegate = this.delegate;
            if (delegate != null) return delegate;
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override
        public TypeAdapter<T> getSerializationDelegate() {
            return this.delegate();
        }

        @Override
        public T read(JsonReader in) throws IOException {
            return this.delegate().read(in);
        }

        @Override
        public void write(JsonWriter out, T value) throws IOException {
            this.delegate().write(out, value);
        }
    }
}
