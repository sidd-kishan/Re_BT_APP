/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.util.LinkedHashMap;

class ConstructorConstructor.12
implements ObjectConstructor<T> {
    final ConstructorConstructor this$0;

    ConstructorConstructor.12(ConstructorConstructor constructorConstructor) {
        this.this$0 = constructorConstructor;
    }

    @Override
    public T construct() {
        return new LinkedHashMap();
    }
}
