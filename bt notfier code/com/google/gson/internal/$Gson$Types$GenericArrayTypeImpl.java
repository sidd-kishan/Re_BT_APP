/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.$Gson$Types;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

private static final class $Gson$Types.GenericArrayTypeImpl
implements GenericArrayType,
Serializable {
    private static final long serialVersionUID = 0L;
    private final Type componentType;

    public $Gson$Types.GenericArrayTypeImpl(Type type) {
        this.componentType = $Gson$Types.canonicalize(type);
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof GenericArrayType && $Gson$Types.equals(this, (GenericArrayType)object);
        return bl;
    }

    @Override
    public Type getGenericComponentType() {
        return this.componentType;
    }

    public int hashCode() {
        return this.componentType.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append($Gson$Types.typeToString(this.componentType));
        stringBuilder.append("[]");
        return stringBuilder.toString();
    }
}
