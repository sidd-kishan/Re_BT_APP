/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.UnsafeAllocator;
import java.lang.reflect.Method;

class UnsafeAllocator.1
extends UnsafeAllocator {
    final Method val$allocateInstance;
    final Object val$unsafe;

    UnsafeAllocator.1(Method method, Object object) {
        this.val$allocateInstance = method;
        this.val$unsafe = object;
    }

    @Override
    public <T> T newInstance(Class<T> clazz) throws Exception {
        UnsafeAllocator.1.assertInstantiable(clazz);
        return (T)this.val$allocateInstance.invoke(this.val$unsafe, clazz);
    }
}
