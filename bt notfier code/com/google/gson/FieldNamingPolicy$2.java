/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.FieldNamingPolicy;
import java.lang.reflect.Field;

final class FieldNamingPolicy.2
extends FieldNamingPolicy {
    @Override
    public String translateName(Field field) {
        return FieldNamingPolicy.2.upperCaseFirstLetter(field.getName());
    }
}
