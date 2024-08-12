/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.reflect.ReflectionAccessor
 */
package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory
implements TypeAdapterFactory {
    private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    private BoundField createBoundField(Gson gson, Field field, String string, TypeToken<?> typeToken, boolean bl, boolean bl2) {
        boolean bl3 = Primitives.isPrimitive(typeToken.getRawType());
        Object object = field.getAnnotation(JsonAdapter.class);
        object = object != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, (JsonAdapter)object) : null;
        boolean bl4 = object != null;
        Object object2 = object;
        if (object != null) return new BoundField(this, string, bl, bl2, field, bl4, (TypeAdapter)object2, gson, typeToken, bl3){
            final /* synthetic */ boolean val$blockInaccessible;
            final /* synthetic */ Method val$accessor;
            final /* synthetic */ boolean val$jsonAdapterPresent;
            final /* synthetic */ TypeAdapter val$typeAdapter;
            final /* synthetic */ Gson val$context;
            final /* synthetic */ TypeToken val$fieldType;
            final /* synthetic */ boolean val$isPrimitive;
            final /* synthetic */ boolean val$isStaticFinalField;
            {
                this.val$blockInaccessible = bl;
                this.val$accessor = method;
                this.val$jsonAdapterPresent = bl2;
                this.val$typeAdapter = typeAdapter;
                this.val$context = gson;
                this.val$fieldType = typeToken;
                this.val$isPrimitive = bl3;
                this.val$isStaticFinalField = bl4;
                super(name, field, serialized, deserialized);
            }

            @Override
            void write(JsonWriter writer, Object source) throws IOException, IllegalAccessException {
                Object fieldValue;
                if (!this.serialized) {
                    return;
                }
                if (this.val$blockInaccessible) {
                    if (this.val$accessor == null) {
                        ReflectiveTypeAdapterFactory.access$000((Object)source, (AccessibleObject)this.field);
                    } else {
                        ReflectiveTypeAdapterFactory.access$000((Object)source, (AccessibleObject)this.val$accessor);
                    }
                }
                if (this.val$accessor != null) {
                    try {
                        fieldValue = this.val$accessor.invoke(source, new Object[0]);
                    }
                    catch (InvocationTargetException e) {
                        String accessorDescription = ReflectionHelper.getAccessibleObjectDescription(this.val$accessor, false);
                        throw new JsonIOException("Accessor " + accessorDescription + " threw exception", e.getCause());
                    }
                } else {
                    fieldValue = this.field.get(source);
                }
                if (fieldValue == source) {
                    return;
                }
                writer.name(this.name);
                TypeAdapter t = this.val$jsonAdapterPresent ? this.val$typeAdapter : new TypeAdapterRuntimeTypeWrapper(this.val$context, this.val$typeAdapter, this.val$fieldType.getType());
                t.write(writer, fieldValue);
            }

            @Override
            void readIntoArray(JsonReader reader, int index, Object[] target) throws IOException, JsonParseException {
                Object fieldValue = this.val$typeAdapter.read(reader);
                if (fieldValue == null && this.val$isPrimitive) {
                    throw new JsonParseException("null is not allowed as value for record component '" + this.fieldName + "' of primitive type; at path " + reader.getPath());
                }
                target[index] = fieldValue;
            }

            @Override
            void readIntoField(JsonReader reader, Object target) throws IOException, IllegalAccessException {
                Object fieldValue = this.val$typeAdapter.read(reader);
                if (fieldValue == null) {
                    if (this.val$isPrimitive) return;
                }
                if (this.val$blockInaccessible) {
                    ReflectiveTypeAdapterFactory.access$000((Object)target, (AccessibleObject)this.field);
                } else if (this.val$isStaticFinalField) {
                    String fieldDescription = ReflectionHelper.getAccessibleObjectDescription(this.field, false);
                    throw new JsonIOException("Cannot set value of 'static final' " + fieldDescription);
                }
                this.field.set(target, fieldValue);
            }
        };
        object2 = gson.getAdapter(typeToken);
        return new /* invalid duplicate definition of identical inner class */;
    }

    static boolean excludeField(Field field, boolean bl, Excluder excluder) {
        bl = !excluder.excludeClass(field.getType(), bl) && !excluder.excludeField(field, bl);
        return bl;
    }

    private Map<String, BoundField> getBoundFields(Gson object, TypeToken<?> object2, Class<?> typeToken) {
        LinkedHashMap<String, BoundField> linkedHashMap = new LinkedHashMap<String, BoundField>();
        if (((Class)((Object)typeToken)).isInterface()) {
            return linkedHashMap;
        }
        Type type = ((TypeToken)object2).getType();
        Class<?> clazz = typeToken;
        typeToken = object2;
        while (clazz != Object.class) {
            for (Field field : clazz.getDeclaredFields()) {
                boolean bl = this.excludeField(field, true);
                boolean bl2 = this.excludeField(field, false);
                if (!bl && !bl2) continue;
                this.accessor.makeAccessible((AccessibleObject)field);
                Type type2 = $Gson$Types.resolve(typeToken.getType(), clazz, field.getGenericType());
                List<String> list = this.getFieldNames(field);
                int n = list.size();
                object2 = null;
                for (int i = 0; i < n; ++i) {
                    Object object3 = list.get(i);
                    if (i != 0) {
                        bl = false;
                    }
                    object3 = linkedHashMap.put((String)object3, this.createBoundField((Gson)object, field, (String)object3, TypeToken.get(type2), bl, bl2));
                    if (object2 != null) continue;
                    object2 = object3;
                }
                if (object2 == null) continue;
                object = new StringBuilder();
                ((StringBuilder)object).append(type);
                ((StringBuilder)object).append(" declares multiple JSON fields named ");
                ((StringBuilder)object).append(((BoundField)object2).name);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            typeToken = TypeToken.get($Gson$Types.resolve(typeToken.getType(), clazz, clazz.getGenericSuperclass()));
            clazz = typeToken.getRawType();
        }
        return linkedHashMap;
    }

    private List<String> getFieldNames(Field object) {
        String[] stringArray = ((Field)object).getAnnotation(SerializedName.class);
        if (stringArray == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName((Field)object));
        }
        object = stringArray.value();
        if ((stringArray = stringArray.alternate()).length == 0) {
            return Collections.singletonList(object);
        }
        ArrayList<String> arrayList = new ArrayList<String>(stringArray.length + 1);
        arrayList.add((String)object);
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            arrayList.add(stringArray[n2]);
            ++n2;
        }
        return arrayList;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<T> clazz = typeToken.getRawType();
        if (Object.class.isAssignableFrom(clazz)) return new Adapter(this.constructorConstructor.get(typeToken), this.getBoundFields(gson, typeToken, clazz));
        return null;
    }

    public boolean excludeField(Field field, boolean bl) {
        return ReflectiveTypeAdapterFactory.excludeField(field, bl, this.excluder);
    }

    public static abstract class Adapter<T, A>
    extends TypeAdapter<T> {
        final Map<String, BoundField> boundFields;

        Adapter(Map<String, BoundField> boundFields) {
            this.boundFields = boundFields;
        }

        @Override
        public void write(JsonWriter out, T value) throws IOException {
            if (value == null) {
                out.nullValue();
                return;
            }
            out.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    boundField.write(out, value);
                }
            }
            catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            }
            out.endObject();
        }

        @Override
        public T read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            A accumulator = this.createAccumulator();
            try {
                in.beginObject();
                while (in.hasNext()) {
                    String name = in.nextName();
                    BoundField field = this.boundFields.get(name);
                    if (field == null || !field.deserialized) {
                        in.skipValue();
                        continue;
                    }
                    this.readField(accumulator, in, field);
                }
            }
            catch (IllegalStateException e) {
                throw new JsonSyntaxException(e);
            }
            catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            }
            in.endObject();
            return this.finalize(accumulator);
        }

        abstract A createAccumulator();

        abstract void readField(A var1, JsonReader var2, BoundField var3) throws IllegalAccessException, IOException;

        abstract T finalize(A var1);
    }

    static abstract class BoundField {
        final String name;
        final Field field;
        final String fieldName;
        final boolean serialized;
        final boolean deserialized;

        protected BoundField(String name, Field field, boolean serialized, boolean deserialized) {
            this.name = name;
            this.field = field;
            this.fieldName = field.getName();
            this.serialized = serialized;
            this.deserialized = deserialized;
        }

        abstract void write(JsonWriter var1, Object var2) throws IOException, IllegalAccessException;

        abstract void readIntoArray(JsonReader var1, int var2, Object[] var3) throws IOException, JsonParseException;

        abstract void readIntoField(JsonReader var1, Object var2) throws IOException, IllegalAccessException;
    }
}
