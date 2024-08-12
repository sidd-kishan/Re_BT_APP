/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.UnsafeAllocator;

class UnsafeAllocator.4
extends UnsafeAllocator {
    UnsafeAllocator.4() {
    }

    @Override
    public <T> T newInstance(Class<T> clazz) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot allocate ");
        stringBuilder.append(clazz);
        throw new UnsupportedOperationException(stringBuilder.toString());
    }
}
