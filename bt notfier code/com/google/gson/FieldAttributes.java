/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.internal.$Gson$Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

public final class FieldAttributes {
    private final Field field;

    public FieldAttributes(Field field) {
        $Gson$Preconditions.checkNotNull(field);
        this.field = field;
    }

    Object get(Object object) throws IllegalAccessException {
        return this.field.get(object);
    }

    public <T extends Annotation> T getAnnotation(Class<T> clazz) {
        return this.field.getAnnotation(clazz);
    }

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.field.getAnnotations());
    }

    public Class<?> getDeclaredClass() {
        return this.field.getType();
    }

    public Type getDeclaredType() {
        return this.field.getGenericType();
    }

    public Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public String getName() {
        return this.field.getName();
    }

    public boolean hasModifier(int n) {
        boolean bl = (n & this.field.getModifiers()) != 0;
        return bl;
    }

    boolean isSynthetic() {
        return this.field.isSynthetic();
    }
}
