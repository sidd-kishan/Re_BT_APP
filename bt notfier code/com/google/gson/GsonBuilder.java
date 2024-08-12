/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GsonBuilder {
    private boolean complexMapKeySerialization = false;
    private String datePattern;
    private int dateStyle = 2;
    private boolean escapeHtmlChars = true;
    private Excluder excluder = Excluder.DEFAULT;
    private final List<TypeAdapterFactory> factories;
    private FieldNamingStrategy fieldNamingPolicy;
    private boolean generateNonExecutableJson = false;
    private final List<TypeAdapterFactory> hierarchyFactories;
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private boolean lenient = false;
    private LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
    private ToNumberStrategy numberToNumberStrategy;
    private ToNumberStrategy objectToNumberStrategy;
    private boolean prettyPrinting = false;
    private boolean serializeNulls = false;
    private boolean serializeSpecialFloatingPointValues = false;
    private int timeStyle = 2;

    public GsonBuilder() {
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList<TypeAdapterFactory>();
        this.hierarchyFactories = new ArrayList<TypeAdapterFactory>();
        this.objectToNumberStrategy = ToNumberPolicy.DOUBLE;
        this.numberToNumberStrategy = ToNumberPolicy.LAZILY_PARSED_NUMBER;
    }

    GsonBuilder(Gson gson) {
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList<TypeAdapterFactory>();
        this.hierarchyFactories = new ArrayList<TypeAdapterFactory>();
        this.objectToNumberStrategy = ToNumberPolicy.DOUBLE;
        this.numberToNumberStrategy = ToNumberPolicy.LAZILY_PARSED_NUMBER;
        this.excluder = gson.excluder;
        this.fieldNamingPolicy = gson.fieldNamingStrategy;
        this.instanceCreators.putAll(gson.instanceCreators);
        this.serializeNulls = gson.serializeNulls;
        this.complexMapKeySerialization = gson.complexMapKeySerialization;
        this.generateNonExecutableJson = gson.generateNonExecutableJson;
        this.escapeHtmlChars = gson.htmlSafe;
        this.prettyPrinting = gson.prettyPrinting;
        this.lenient = gson.lenient;
        this.serializeSpecialFloatingPointValues = gson.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = gson.longSerializationPolicy;
        this.datePattern = gson.datePattern;
        this.dateStyle = gson.dateStyle;
        this.timeStyle = gson.timeStyle;
        this.factories.addAll(gson.builderFactories);
        this.hierarchyFactories.addAll(gson.builderHierarchyFactories);
        this.objectToNumberStrategy = gson.objectToNumberStrategy;
        this.numberToNumberStrategy = gson.numberToNumberStrategy;
    }

    /*
     * Unable to fully structure code
     */
    private void addTypeAdaptersForDate(String var1_1, int var2_2, int var3_3, List<TypeAdapterFactory> var4_4) {
        block3: {
            block2: {
                var5_5 = SqlTypesSupport.SUPPORTS_SQL_TYPES;
                var7_6 = null;
                if (var1_1 == null || var1_1.trim().isEmpty()) break block2;
                var6_8 = var8_7 = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory((String)var1_1);
                if (!var5_5) ** GOTO lbl-1000
                var6_8 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory((String)var1_1);
                var7_6 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory((String)var1_1);
                var1_1 = var6_8;
                var6_8 = var8_7;
                break block3;
            }
            if (var2_2 == 2) return;
            if (var3_3 == 2) return;
            var6_8 = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(var2_2, var3_3);
            if (var5_5) {
                var1_1 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(var2_2, var3_3);
                var7_6 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(var2_2, var3_3);
            } else lbl-1000:
            // 2 sources

            {
                var8_7 = null;
                var1_1 = var7_6;
                var7_6 = var8_7;
            }
        }
        var4_4.add(var6_8);
        if (var5_5 == false) return;
        var4_4.add((TypeAdapterFactory)var1_1);
        var4_4.add(var7_6);
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }

    public Gson create() {
        ArrayList<TypeAdapterFactory> arrayList = new ArrayList<TypeAdapterFactory>(this.factories.size() + this.hierarchyFactories.size() + 3);
        arrayList.addAll(this.factories);
        Collections.reverse(arrayList);
        ArrayList<TypeAdapterFactory> arrayList2 = new ArrayList<TypeAdapterFactory>(this.hierarchyFactories);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        this.addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, arrayList);
        return new Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, this.factories, this.hierarchyFactories, arrayList, this.objectToNumberStrategy, this.numberToNumberStrategy);
    }

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int ... nArray) {
        this.excluder = this.excluder.withModifiers(nArray);
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object object) {
        boolean bl = object instanceof JsonSerializer;
        boolean bl2 = bl || object instanceof JsonDeserializer || object instanceof InstanceCreator || object instanceof TypeAdapter;
        $Gson$Preconditions.checkArgument(bl2);
        if (object instanceof InstanceCreator) {
            this.instanceCreators.put(type, (InstanceCreator)object);
        }
        if (bl || object instanceof JsonDeserializer) {
            TypeToken<?> typeToken = TypeToken.get(type);
            this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(typeToken, object));
        }
        if (!(object instanceof TypeAdapter)) return this;
        this.factories.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter)object));
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory typeAdapterFactory) {
        this.factories.add(typeAdapterFactory);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> clazz, Object object) {
        boolean bl = object instanceof JsonSerializer;
        boolean bl2 = bl || object instanceof JsonDeserializer || object instanceof TypeAdapter;
        $Gson$Preconditions.checkArgument(bl2);
        if (object instanceof JsonDeserializer || bl) {
            this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(clazz, object));
        }
        if (!(object instanceof TypeAdapter)) return this;
        this.factories.add(TypeAdapters.newTypeHierarchyFactory(clazz, (TypeAdapter)object));
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public GsonBuilder setDateFormat(int n) {
        this.dateStyle = n;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int n, int n2) {
        this.dateStyle = n;
        this.timeStyle = n2;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(String string) {
        this.datePattern = string;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy ... exclusionStrategyArray) {
        int n = exclusionStrategyArray.length;
        int n2 = 0;
        while (n2 < n) {
            ExclusionStrategy exclusionStrategy = exclusionStrategyArray[n2];
            this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, true);
            ++n2;
        }
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        this.fieldNamingPolicy = fieldNamingPolicy;
        return this;
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.fieldNamingPolicy = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        this.longSerializationPolicy = longSerializationPolicy;
        return this;
    }

    public GsonBuilder setNumberToNumberStrategy(ToNumberStrategy toNumberStrategy) {
        this.numberToNumberStrategy = toNumberStrategy;
        return this;
    }

    public GsonBuilder setObjectToNumberStrategy(ToNumberStrategy toNumberStrategy) {
        this.objectToNumberStrategy = toNumberStrategy;
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public GsonBuilder setVersion(double d) {
        this.excluder = this.excluder.withVersion(d);
        return this;
    }
}
