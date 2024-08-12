/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  retrofit2.Utils
 */
package retrofit2;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import javax.annotation.Nullable;
import retrofit2.Utils;

/*
 * Exception performing whole class analysis ignored.
 */
private static final class Utils.WildcardTypeImpl
implements WildcardType {
    @Nullable
    private final Type lowerBound;
    private final Type upperBound;

    Utils.WildcardTypeImpl(Type[] typeArray, Type[] typeArray2) {
        if (typeArray2.length > 1) throw new IllegalArgumentException();
        if (typeArray.length != 1) throw new IllegalArgumentException();
        if (typeArray2.length == 1) {
            if (typeArray2[0] == null) throw null;
            Utils.checkNotPrimitive((Type)typeArray2[0]);
            if (typeArray[0] != Object.class) throw new IllegalArgumentException();
            this.lowerBound = typeArray2[0];
            this.upperBound = Object.class;
        } else {
            if (typeArray[0] == null) throw null;
            Utils.checkNotPrimitive((Type)typeArray[0]);
            this.lowerBound = null;
            this.upperBound = typeArray[0];
        }
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof WildcardType && Utils.equals((Type)this, (Type)((WildcardType)object));
        return bl;
    }

    @Override
    public Type[] getLowerBounds() {
        Type type = this.lowerBound;
        Type[] typeArray = type != null ? new Type[]{type} : Utils.EMPTY_TYPE_ARRAY;
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
            stringBuilder.append(Utils.typeToString((Type)this.lowerBound));
            return stringBuilder.toString();
        }
        if (this.upperBound == Object.class) {
            return "?";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("? extends ");
        stringBuilder.append(Utils.typeToString((Type)this.upperBound));
        return stringBuilder.toString();
    }
}
