/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.$Gson$Types;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

private static final class $Gson$Types.WildcardTypeImpl
implements WildcardType,
Serializable {
    private static final long serialVersionUID = 0L;
    private final Type lowerBound;
    private final Type upperBound;

    public $Gson$Types.WildcardTypeImpl(Type[] typeArray, Type[] typeArray2) {
        int n = typeArray2.length;
        boolean bl = true;
        boolean bl2 = n <= 1;
        $Gson$Preconditions.checkArgument(bl2);
        bl2 = typeArray.length == 1;
        $Gson$Preconditions.checkArgument(bl2);
        if (typeArray2.length == 1) {
            $Gson$Preconditions.checkNotNull(typeArray2[0]);
            $Gson$Types.checkNotPrimitive(typeArray2[0]);
            bl2 = typeArray[0] == Object.class ? bl : false;
            $Gson$Preconditions.checkArgument(bl2);
            this.lowerBound = $Gson$Types.canonicalize(typeArray2[0]);
            this.upperBound = Object.class;
        } else {
            $Gson$Preconditions.checkNotNull(typeArray[0]);
            $Gson$Types.checkNotPrimitive(typeArray[0]);
            this.lowerBound = null;
            this.upperBound = $Gson$Types.canonicalize(typeArray[0]);
        }
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof WildcardType && $Gson$Types.equals(this, (WildcardType)object);
        return bl;
    }

    @Override
    public Type[] getLowerBounds() {
        Type type = this.lowerBound;
        Type[] typeArray = type != null ? new Type[]{type} : EMPTY_TYPE_ARRAY;
        return typeArray;
    }

    @Override
    public Type[] getUpperBounds() {
        return new Type[]{this.upperBound};
    }

    public int hashCode() {
        Type type = this.lowerBound;
        int n = type != null ? type.hashCode() + 31 : 1;
        return n ^ this.upperBound.hashCode() + 31;
    }

    public String toString() {
        if (this.lowerBound != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("? super ");
            stringBuilder.append($Gson$Types.typeToString(this.lowerBound));
            return stringBuilder.toString();
        }
        if (this.upperBound == Object.class) {
            return "?";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("? extends ");
        stringBuilder.append($Gson$Types.typeToString(this.upperBound));
        return stringBuilder.toString();
    }
}
