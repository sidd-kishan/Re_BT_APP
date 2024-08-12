/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.reflect.ReflectionAccessor
 */
package com.google.gson.internal.reflect;

import com.google.gson.internal.reflect.ReflectionAccessor;
import java.lang.reflect.AccessibleObject;

final class PreJava9ReflectionAccessor
extends ReflectionAccessor {
    PreJava9ReflectionAccessor() {
    }

    public void makeAccessible(AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}
