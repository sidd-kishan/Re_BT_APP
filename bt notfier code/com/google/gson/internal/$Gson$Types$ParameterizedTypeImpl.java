/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.$Gson$Types;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

private static final class $Gson$Types.ParameterizedTypeImpl
implements ParameterizedType,
Serializable {
    private static final long serialVersionUID = 0L;
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;

    public $Gson$Types.ParameterizedTypeImpl(Type object, Type type, Type ... typeArray) {
        int n;
        boolean bl = type instanceof Class;
        int n2 = 0;
        if (bl) {
            Class clazz = (Class)type;
            bl = Modifier.isStatic(clazz.getModifiers());
            boolean bl2 = true;
            n = !bl && clazz.getEnclosingClass() != null ? 0 : 1;
            bl = bl2;
            if (object == null) {
                bl = n != 0 ? bl2 : false;
            }
            $Gson$Preconditions.checkArgument(bl);
        }
        object = object == null ? null : $Gson$Types.canonicalize((Type)object);
        this.ownerType = object;
        this.rawType = $Gson$Types.canonicalize(type);
        object = (Type[])typeArray.clone();
        this.typeArguments = object;
        int n3 = ((Type[])object).length;
        n = n2;
        while (n < n3) {
            $Gson$Preconditions.checkNotNull(this.typeArguments[n]);
            $Gson$Types.checkNotPrimitive(this.typeArguments[n]);
            object = this.typeArguments;
            object[n] = $Gson$Types.canonicalize(object[n]);
            ++n;
        }
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof ParameterizedType && $Gson$Types.equals(this, (ParameterizedType)object);
        return bl;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return (Type[])this.typeArguments.clone();
    }

    @Override
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override
    public Type getRawType() {
        return this.rawType;
    }

    public int hashCode() {
        return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ $Gson$Types.hashCodeOrZero((Object)this.ownerType);
    }

    public String toString() {
        int n = this.typeArguments.length;
        if (n == 0) {
            return $Gson$Types.typeToString(this.rawType);
        }
        StringBuilder stringBuilder = new StringBuilder((n + 1) * 30);
        stringBuilder.append($Gson$Types.typeToString(this.rawType));
        stringBuilder.append("<");
        stringBuilder.append($Gson$Types.typeToString(this.typeArguments[0]));
        int n2 = 1;
        while (true) {
            if (n2 >= n) {
                stringBuilder.append(">");
                return stringBuilder.toString();
            }
            stringBuilder.append(", ");
            stringBuilder.append($Gson$Types.typeToString(this.typeArguments[n2]));
            ++n2;
        }
    }
}
