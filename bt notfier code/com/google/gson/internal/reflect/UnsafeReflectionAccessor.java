/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.reflect.ReflectionAccessor
 */
package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionAccessor;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

final class UnsafeReflectionAccessor
extends ReflectionAccessor {
    private static Class unsafeClass;
    private final Field overrideField;
    private final Object theUnsafe = UnsafeReflectionAccessor.getUnsafeInstance();

    UnsafeReflectionAccessor() {
        this.overrideField = UnsafeReflectionAccessor.getOverrideField();
    }

    private static Field getOverrideField() {
        try {
            Field field = AccessibleObject.class.getDeclaredField("override");
            return field;
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     */
    private static Object getUnsafeInstance() {
        Object object = null;
        try {
            Object object2 = Class.forName("sun.misc.Unsafe");
            unsafeClass = object2;
            object2 = ((Class)object2).getDeclaredField("theUnsafe");
            ((AccessibleObject)object2).setAccessible(true);
            return object2 = ((Field)object2).get(null);
        }
        catch (Exception exception) {
            return object;
        }
    }

    public void makeAccessible(AccessibleObject accessibleObject) {
        if (this.makeAccessibleWithUnsafe(accessibleObject)) return;
        try {
            accessibleObject.setAccessible(true);
        }
        catch (SecurityException securityException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Gson couldn't modify fields for ");
            stringBuilder.append(accessibleObject);
            stringBuilder.append("\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.");
            throw new JsonIOException(stringBuilder.toString(), securityException);
        }
    }

    boolean makeAccessibleWithUnsafe(AccessibleObject accessibleObject) {
        if (this.theUnsafe == null) return false;
        if (this.overrideField == null) return false;
        try {
            long l = (Long)unsafeClass.getMethod("objectFieldOffset", Field.class).invoke(this.theUnsafe, this.overrideField);
            unsafeClass.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.theUnsafe, accessibleObject, l, true);
            return true;
        }
        catch (Exception exception) {
        }
        return false;
    }
}
