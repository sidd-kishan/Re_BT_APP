/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ConstructorConstructor.3
implements ObjectConstructor<T> {
    final ConstructorConstructor this$0;
    final Constructor val$constructor;

    ConstructorConstructor.3(ConstructorConstructor constructorConstructor, Constructor constructor) {
        this.this$0 = constructorConstructor;
        this.val$constructor = constructor;
    }

    @Override
    public T construct() {
        Object t;
        try {
            t = this.val$constructor.newInstance(null);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError((Object)illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to invoke ");
            stringBuilder.append(this.val$constructor);
            stringBuilder.append(" with no args");
            throw new RuntimeException(stringBuilder.toString(), invocationTargetException.getTargetException());
        }
        catch (InstantiationException instantiationException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to invoke ");
            stringBuilder.append(this.val$constructor);
            stringBuilder.append(" with no args");
            throw new RuntimeException(stringBuilder.toString(), instantiationException);
        }
        return t;
    }
}
