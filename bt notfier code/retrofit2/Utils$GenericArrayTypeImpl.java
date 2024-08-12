/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Utils
 */
package retrofit2;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import retrofit2.Utils;

/*
 * Exception performing whole class analysis ignored.
 */
private static final class Utils.GenericArrayTypeImpl
implements GenericArrayType {
    private final Type componentType;

    Utils.GenericArrayTypeImpl(Type type) {
        this.componentType = type;
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof GenericArrayType && Utils.equals((Type)this, (Type)((GenericArrayType)object));
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
        stringBuilder.append(Utils.typeToString((Type)this.componentType));
        stringBuilder.append("[]");
        return stringBuilder.toString();
    }
}
