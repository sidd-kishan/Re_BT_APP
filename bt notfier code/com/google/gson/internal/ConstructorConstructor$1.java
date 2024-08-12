/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.Type;

class ConstructorConstructor.1
implements ObjectConstructor<T> {
    final ConstructorConstructor this$0;
    final Type val$type;
    final InstanceCreator val$typeCreator;

    ConstructorConstructor.1(ConstructorConstructor constructorConstructor, InstanceCreator instanceCreator, Type type) {
        this.this$0 = constructorConstructor;
        this.val$typeCreator = instanceCreator;
        this.val$type = type;
    }

    @Override
    public T construct() {
        return this.val$typeCreator.createInstance(this.val$type);
    }
}
