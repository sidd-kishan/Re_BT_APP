/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.FieldNamingPolicy;
import java.lang.reflect.Field;
import java.util.Locale;

final class FieldNamingPolicy.5
extends FieldNamingPolicy {
    @Override
    public String translateName(Field field) {
        return FieldNamingPolicy.5.separateCamelCase((String)field.getName(), (String)"-").toLowerCase(Locale.ENGLISH);
    }
}
