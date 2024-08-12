/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

private static final class TypeAdapters.EnumTypeAdapter<T extends Enum<T>>
extends TypeAdapter<T> {
    private final Map<T, String> constantToName;
    private final Map<String, T> nameToConstant = new HashMap<String, T>();

    /*
     * Enabled unnecessary exception pruning
     */
    public TypeAdapters.EnumTypeAdapter(Class<T> privilegedAction) {
        int n;
        int n2;
        Field[] fieldArray;
        this.constantToName = new HashMap<T, String>();
        try {
            fieldArray = ((Class)((Object)privilegedAction)).getDeclaredFields();
            n2 = fieldArray.length;
            n = 0;
        }
        catch (IllegalAccessException illegalAccessException) {
            AssertionError assertionError = new AssertionError((Object)illegalAccessException);
            throw assertionError;
        }
        while (n < n2) {
            block7: {
                Enum enum_;
                block8: {
                    Object object = fieldArray[n];
                    if (!((Field)object).isEnumConstant()) break block7;
                    privilegedAction = new PrivilegedAction<Field[]>(this, (Field)object){
                        final /* synthetic */ Class val$classOfT;
                        {
                            this.val$classOfT = clazz;
                        }

                        @Override
                        public Field[] run() {
                            Field[] fields = this.val$classOfT.getDeclaredFields();
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
                    };
                    AccessController.doPrivileged(privilegedAction);
                    enum_ = (Enum)((Field)object).get(null);
                    privilegedAction = enum_.name();
                    String[] stringArray = ((Field)object).getAnnotation(SerializedName.class);
                    if (stringArray == null) break block8;
                    object = stringArray.value();
                    stringArray = stringArray.alternate();
                    int n3 = stringArray.length;
                    int n4 = 0;
                    while (true) {
                        privilegedAction = object;
                        if (n4 >= n3) break;
                        privilegedAction = stringArray[n4];
                        this.nameToConstant.put((String)((Object)privilegedAction), enum_);
                        ++n4;
                        continue;
                        break;
                    }
                }
                this.nameToConstant.put((String)((Object)privilegedAction), enum_);
                this.constantToName.put(enum_, (String)((Object)privilegedAction));
            }
            ++n;
        }
        return;
    }

    @Override
    public T read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) return (T)((Enum)this.nameToConstant.get(jsonReader.nextString()));
        jsonReader.nextNull();
        return null;
    }

    @Override
    public void write(JsonWriter jsonWriter, T object) throws IOException {
        object = object == null ? null : this.constantToName.get(object);
        jsonWriter.value((String)object);
    }
}
