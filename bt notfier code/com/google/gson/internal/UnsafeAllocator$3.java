/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.UnsafeAllocator;
import java.lang.reflect.Method;

class UnsafeAllocator.3
extends UnsafeAllocator {
    final Method val$newInstance;

    UnsafeAllocator.3(Method method) {
        this.val$newInstance = method;
    }

    @Override
    public <T> T newInstance(Class<T> clazz) throws Exception {
        UnsafeAllocator.3.assertInstantiable(clazz);
        return (T)this.val$newInstance.invoke(null, clazz, Object.class);
    }
}
