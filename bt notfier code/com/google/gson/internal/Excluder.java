/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Excluder
implements TypeAdapterFactory,
Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1.0;
    private List<ExclusionStrategy> deserializationStrategies;
    private int modifiers = 136;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private boolean serializeInnerClasses = true;
    private double version = -1.0;

    public Excluder() {
        this.deserializationStrategies = Collections.emptyList();
    }

    private boolean excludeClassChecks(Class<?> clazz) {
        if (this.version != -1.0 && !this.isValidVersion(clazz.getAnnotation(Since.class), clazz.getAnnotation(Until.class))) {
            return true;
        }
        if (!this.serializeInnerClasses && this.isInnerClass(clazz)) {
            return true;
        }
        if (!this.isAnonymousOrNonStaticLocal(clazz)) return false;
        return true;
    }

    private boolean excludeClassInStrategy(Class<?> clazz, boolean bl) {
        List<ExclusionStrategy> list = bl ? this.serializationStrategies : this.deserializationStrategies;
        list = list.iterator();
        do {
            if (!list.hasNext()) return false;
        } while (!((ExclusionStrategy)list.next()).shouldSkipClass(clazz));
        return true;
    }

    private boolean isAnonymousOrNonStaticLocal(Class<?> clazz) {
        boolean bl = !Enum.class.isAssignableFrom(clazz) && !this.isStatic(clazz) && (clazz.isAnonymousClass() || clazz.isLocalClass());
        return bl;
    }

    private boolean isInnerClass(Class<?> clazz) {
        boolean bl = clazz.isMemberClass() && !this.isStatic(clazz);
        return bl;
    }

    private boolean isStatic(Class<?> clazz) {
        boolean bl = (clazz.getModifiers() & 8) != 0;
        return bl;
    }

    private boolean isValidSince(Since since) {
        if (since == null) return true;
        if (!(since.value() > this.version)) return true;
        return false;
    }

    private boolean isValidUntil(Until until) {
        if (until == null) return true;
        if (!(until.value() <= this.version)) return true;
        return false;
    }

    private boolean isValidVersion(Since since, Until until) {
        boolean bl = this.isValidSince(since) && this.isValidUntil(until);
        return bl;
    }

    protected Excluder clone() {
        try {
            Excluder excluder = (Excluder)super.clone();
            return excluder;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<T> clazz = typeToken.getRawType();
        final boolean bl = this.excludeClassChecks(clazz);
        final boolean bl2 = bl || this.excludeClassInStrategy(clazz, true);
        bl = bl || this.excludeClassInStrategy(clazz, false);
        if (bl2) return new TypeAdapter<T>(){
            private TypeAdapter<T> delegate;

            @Override
            public T read(JsonReader in) throws IOException {
                if (!bl) return this.delegate().read(in);
                in.skipValue();
                return null;
            }

            @Override
            public void write(JsonWriter out, T value) throws IOException {
                if (bl2) {
                    out.nullValue();
                    return;
                }
                this.delegate().write(out, value);
            }

            private TypeAdapter<T> delegate() {
                TypeAdapter d = this.delegate;
                return d != null ? d : (this.delegate = gson.getDelegateAdapter(Excluder.this, typeToken));
            }
        };
        if (bl) return new /* invalid duplicate definition of identical inner class */;
        return null;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder excluder = this.clone();
        excluder.serializeInnerClasses = false;
        return excluder;
    }

    public boolean excludeClass(Class<?> clazz, boolean bl) {
        bl = this.excludeClassChecks(clazz) || this.excludeClassInStrategy(clazz, bl);
        return bl;
    }

    public boolean excludeField(Field object, boolean bl) {
        Object object2;
        if ((this.modifiers & ((Field)object).getModifiers()) != 0) {
            return true;
        }
        if (this.version != -1.0 && !this.isValidVersion(((Field)object).getAnnotation(Since.class), ((Field)object).getAnnotation(Until.class))) {
            return true;
        }
        if (((Field)object).isSynthetic()) {
            return true;
        }
        if (this.requireExpose) {
            object2 = ((Field)object).getAnnotation(Expose.class);
            if (object2 == null) return true;
            if (bl ? !object2.serialize() : !object2.deserialize()) {
                return true;
            }
        }
        if (!this.serializeInnerClasses && this.isInnerClass(((Field)object).getType())) {
            return true;
        }
        if (this.isAnonymousOrNonStaticLocal(((Field)object).getType())) {
            return true;
        }
        object2 = bl ? this.serializationStrategies : this.deserializationStrategies;
        if (object2.isEmpty()) return false;
        object = new FieldAttributes((Field)object);
        object2 = object2.iterator();
        do {
            if (!object2.hasNext()) return false;
        } while (!((ExclusionStrategy)object2.next()).shouldSkipField((FieldAttributes)object));
        return true;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder excluder = this.clone();
        excluder.requireExpose = true;
        return excluder;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean bl, boolean bl2) {
        ArrayList<ExclusionStrategy> arrayList;
        Excluder excluder = this.clone();
        if (bl) {
            arrayList = new ArrayList<ExclusionStrategy>(this.serializationStrategies);
            excluder.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (!bl2) return excluder;
        arrayList = new ArrayList<ExclusionStrategy>(this.deserializationStrategies);
        excluder.deserializationStrategies = arrayList;
        arrayList.add(exclusionStrategy);
        return excluder;
    }

    public Excluder withModifiers(int ... nArray) {
        Excluder excluder = this.clone();
        int n = 0;
        excluder.modifiers = 0;
        int n2 = nArray.length;
        while (n < n2) {
            excluder.modifiers = nArray[n] | excluder.modifiers;
            ++n;
        }
        return excluder;
    }

    public Excluder withVersion(double d) {
        Excluder excluder = this.clone();
        excluder.version = d;
        return excluder;
    }
}
