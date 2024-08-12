/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

class ConstructorConstructor.5
implements ObjectConstructor<T> {
    final ConstructorConstructor this$0;
    final Type val$type;

    ConstructorConstructor.5(ConstructorConstructor constructorConstructor, Type type) {
        this.this$0 = constructorConstructor;
        this.val$type = type;
    }

    @Override
    public T construct() {
        Object object = this.val$type;
        if (!(object instanceof ParameterizedType)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Invalid EnumSet type: ");
            ((StringBuilder)object).append(this.val$type.toString());
            throw new JsonIOException(((StringBuilder)object).toString());
        }
        if ((object = ((ParameterizedType)object).getActualTypeArguments()[0]) instanceof Class) {
            return EnumSet.noneOf((Class)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid EnumSet type: ");
        ((StringBuilder)object).append(this.val$type.toString());
        throw new JsonIOException(((StringBuilder)object).toString());
    }
}
