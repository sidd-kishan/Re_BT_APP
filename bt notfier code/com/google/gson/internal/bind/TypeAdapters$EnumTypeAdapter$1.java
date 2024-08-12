/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.internal.bind.TypeAdapters;
import java.lang.reflect.Field;
import java.security.PrivilegedAction;

class TypeAdapters.EnumTypeAdapter.1
implements PrivilegedAction<Void> {
    final TypeAdapters.EnumTypeAdapter this$0;
    final Field val$field;

    TypeAdapters.EnumTypeAdapter.1(TypeAdapters.EnumTypeAdapter enumTypeAdapter, Field field) {
        this.this$0 = enumTypeAdapter;
        this.val$field = field;
    }

    @Override
    public Void run() {
        this.val$field.setAccessible(true);
        return null;
    }
}
