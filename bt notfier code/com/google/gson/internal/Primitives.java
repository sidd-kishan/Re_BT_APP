/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.lang.reflect.Type;

public final class Primitives {
    private Primitives() {
    }

    public static boolean isPrimitive(Type type) {
        boolean bl = type instanceof Class && ((Class)type).isPrimitive();
        return bl;
    }

    public static boolean isWrapperType(Type type) {
        boolean bl = type == Integer.class || type == Float.class || type == Byte.class || type == Double.class || type == Long.class || type == Character.class || type == Boolean.class || type == Short.class || type == Void.class;
        return bl;
    }

    public static <T> Class<T> unwrap(Class<T> clazz) {
        if (clazz == Integer.class) {
            return Integer.TYPE;
        }
        if (clazz == Float.class) {
            return Float.TYPE;
        }
        if (clazz == Byte.class) {
            return Byte.TYPE;
        }
        if (clazz == Double.class) {
            return Double.TYPE;
        }
        if (clazz == Long.class) {
            return Long.TYPE;
        }
        if (clazz == Character.class) {
            return Character.TYPE;
        }
        if (clazz == Boolean.class) {
            return Boolean.TYPE;
        }
        if (clazz == Short.class) {
            return Short.TYPE;
        }
        Class<Object> clazz2 = clazz;
        if (clazz != Void.class) return clazz2;
        clazz2 = Void.TYPE;
        return clazz2;
    }

    public static <T> Class<T> wrap(Class<T> clazz) {
        if (clazz == Integer.TYPE) {
            return Integer.class;
        }
        if (clazz == Float.TYPE) {
            return Float.class;
        }
        if (clazz == Byte.TYPE) {
            return Byte.class;
        }
        if (clazz == Double.TYPE) {
            return Double.class;
        }
        if (clazz == Long.TYPE) {
            return Long.class;
        }
        if (clazz == Character.TYPE) {
            return Character.class;
        }
        if (clazz == Boolean.TYPE) {
            return Boolean.class;
        }
        if (clazz == Short.TYPE) {
            return Short.class;
        }
        Class<Object> clazz2 = clazz;
        if (clazz != Void.TYPE) return clazz2;
        clazz2 = Void.class;
        return clazz2;
    }
}
