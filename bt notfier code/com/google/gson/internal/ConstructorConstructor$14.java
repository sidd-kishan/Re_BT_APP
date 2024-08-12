/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.UnsafeAllocator;
import java.lang.reflect.Type;

class ConstructorConstructor.14
implements ObjectConstructor<T> {
    final ConstructorConstructor this$0;
    private final UnsafeAllocator unsafeAllocator;
    final Class val$rawType;
    final Type val$type;

    ConstructorConstructor.14(ConstructorConstructor constructorConstructor, Class clazz, Type type) {
        this.this$0 = constructorConstructor;
        this.val$rawType = clazz;
        this.val$type = type;
        this.unsafeAllocator = UnsafeAllocator.create();
    }

    @Override
    public T construct() {
        Object t;
        try {
            t = this.unsafeAllocator.newInstance(this.val$rawType);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to invoke no-args constructor for ");
            stringBuilder.append(this.val$type);
            stringBuilder.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
            throw new RuntimeException(stringBuilder.toString(), exception);
        }
        return t;
    }
}
