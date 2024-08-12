/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.Type;

class ConstructorConstructor.2
implements ObjectConstructor<T> {
    final ConstructorConstructor this$0;
    final InstanceCreator val$rawTypeCreator;
    final Type val$type;

    ConstructorConstructor.2(ConstructorConstructor constructorConstructor, InstanceCreator instanceCreator, Type type) {
        this.this$0 = constructorConstructor;
        this.val$rawTypeCreator = instanceCreator;
        this.val$type = type;
    }

    @Override
    public T construct() {
        return this.val$rawTypeCreator.createInstance(this.val$type);
    }
}
