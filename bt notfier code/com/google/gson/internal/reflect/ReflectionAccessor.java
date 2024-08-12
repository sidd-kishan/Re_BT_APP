/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.reflect.PreJava9ReflectionAccessor
 *  com.google.gson.internal.reflect.UnsafeReflectionAccessor
 */
package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.reflect.PreJava9ReflectionAccessor;
import com.google.gson.internal.reflect.UnsafeReflectionAccessor;
import java.lang.reflect.AccessibleObject;

public abstract class ReflectionAccessor {
    private static final ReflectionAccessor instance;

    static {
        Object object = JavaVersion.getMajorJavaVersion() < 9 ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor();
        instance = object;
    }

    public static ReflectionAccessor getInstance() {
        return instance;
    }

    public abstract void makeAccessible(AccessibleObject var1);
}
