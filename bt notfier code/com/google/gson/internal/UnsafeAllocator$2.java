/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.UnsafeAllocator;
import java.lang.reflect.Method;

class UnsafeAllocator.2
extends UnsafeAllocator {
    final int val$constructorId;
    final Method val$newInstance;

    UnsafeAllocator.2(Method method, int n) {
        this.val$newInstance = method;
        this.val$constructorId = n;
    }

    @Override
    public <T> T newInstance(Class<T> clazz) throws Exception {
        UnsafeAllocator.2.assertInstantiable(clazz);
        return (T)this.val$newInstance.invoke(null, clazz, this.val$constructorId);
    }
}
