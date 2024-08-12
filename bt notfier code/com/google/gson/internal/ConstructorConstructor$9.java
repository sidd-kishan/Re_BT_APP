/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.util.concurrent.ConcurrentSkipListMap;

class ConstructorConstructor.9
implements ObjectConstructor<T> {
    final ConstructorConstructor this$0;

    ConstructorConstructor.9(ConstructorConstructor constructorConstructor) {
        this.this$0 = constructorConstructor;
    }

    @Override
    public T construct() {
        return new ConcurrentSkipListMap();
    }
}
