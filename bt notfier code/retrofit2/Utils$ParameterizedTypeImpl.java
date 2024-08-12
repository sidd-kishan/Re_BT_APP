/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Utils
 */
package retrofit2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.Nullable;
import retrofit2.Utils;

/*
 * Exception performing whole class analysis ignored.
 */
static final class Utils.ParameterizedTypeImpl
implements ParameterizedType {
    @Nullable
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;

    Utils.ParameterizedTypeImpl(@Nullable Type type, Type type2, Type ... typeArray) {
        int n;
        int n2;
        boolean bl = type2 instanceof Class;
        int n3 = 0;
        if (bl) {
            n2 = 1;
            n = type == null ? 1 : 0;
            if (((Class)type2).getEnclosingClass() != null) {
                n2 = 0;
            }
            if (n != n2) throw new IllegalArgumentException();
        }
        n2 = typeArray.length;
        n = n3;
        while (true) {
            if (n >= n2) {
                this.ownerType = type;
                this.rawType = type2;
                this.typeArguments = (Type[])typeArray.clone();
                return;
            }
            Type type3 = typeArray[n];
            Objects.requireNonNull(type3, "typeArgument == null");
            Utils.checkNotPrimitive((Type)type3);
            ++n;
        }
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof ParameterizedType && Utils.equals((Type)this, (Type)((ParameterizedType)object));
        return bl;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return (Type[])this.typeArguments.clone();
    }

    @Override
    @Nullable
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override
    public Type getRawType() {
        return this.rawType;
    }

    public int hashCode() {
        int n = Arrays.hashCode(this.typeArguments);
        int n2 = this.rawType.hashCode();
        Type type = this.ownerType;
        int n3 = type != null ? type.hashCode() : 0;
        return n ^ n2 ^ n3;
    }

    public String toString() {
        Object object = this.typeArguments;
        if (((Type[])object).length == 0) {
            return Utils.typeToString((Type)this.rawType);
        }
        int n = ((Type[])object).length;
        int n2 = 1;
        object = new StringBuilder((n + 1) * 30);
        ((StringBuilder)object).append(Utils.typeToString((Type)this.rawType));
        ((StringBuilder)object).append("<");
        ((StringBuilder)object).append(Utils.typeToString((Type)this.typeArguments[0]));
        while (true) {
            if (n2 >= this.typeArguments.length) {
                ((StringBuilder)object).append(">");
                return ((StringBuilder)object).toString();
            }
            ((StringBuilder)object).append(", ");
            ((StringBuilder)object).append(Utils.typeToString((Type)this.typeArguments[n2]));
            ++n2;
        }
    }
}
