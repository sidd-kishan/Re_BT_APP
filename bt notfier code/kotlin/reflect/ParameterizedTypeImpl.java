/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.ParameterizedTypeImpl$getTypeName$1$1
 *  kotlin.reflect.TypeImpl
 *  kotlin.reflect.TypesJVMKt
 */
package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.ParameterizedTypeImpl;
import kotlin.reflect.TypeImpl;
import kotlin.reflect.TypesJVMKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\u0002\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016\u00a2\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000b\u00a8\u0006\u0019"}, d2={"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "equals", "", "other", "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getOwnerType", "getRawType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class ParameterizedTypeImpl
implements ParameterizedType,
TypeImpl {
    private final Type ownerType;
    private final Class<?> rawType;
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(Class<?> typeArray, Type type, List<? extends Type> list) {
        Intrinsics.checkNotNullParameter(typeArray, (String)"rawType");
        Intrinsics.checkNotNullParameter(list, (String)"typeArguments");
        this.rawType = typeArray;
        this.ownerType = type;
        typeArray = ((Collection)list).toArray(new Type[0]);
        if (typeArray == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        this.typeArguments = typeArray;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        boolean bl = object instanceof ParameterizedType && Intrinsics.areEqual(clazz = this.rawType, (Object)(object = (ParameterizedType)object).getRawType()) && Intrinsics.areEqual((Object)this.ownerType, (Object)object.getOwnerType()) && Arrays.equals(this.getActualTypeArguments(), object.getActualTypeArguments());
        return bl;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override
    public Type getRawType() {
        return this.rawType;
    }

    @Override
    public String getTypeName() {
        CharSequence charSequence = new StringBuilder();
        Type type = this.ownerType;
        if (type != null) {
            charSequence.append(TypesJVMKt.access$typeToString((Type)type));
            charSequence.append("$");
            charSequence.append(this.rawType.getSimpleName());
        } else {
            charSequence.append(TypesJVMKt.access$typeToString((Type)this.rawType));
        }
        boolean bl = this.typeArguments.length == 0;
        if (bl ^ true) {
            ArraysKt.joinTo$default((Object[])this.typeArguments, (Appendable)((Object)charSequence), null, (CharSequence)"<", (CharSequence)">", (int)0, null, (Function1)((Function1)getTypeName.1.1.INSTANCE), (int)50, null);
        }
        charSequence = charSequence.toString();
        Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"StringBuilder().apply(builderAction).toString()");
        return charSequence;
    }

    public int hashCode() {
        int n = this.rawType.hashCode();
        Type type = this.ownerType;
        int n2 = type != null ? type.hashCode() : 0;
        return n ^ n2 ^ Arrays.hashCode(this.getActualTypeArguments());
    }

    public String toString() {
        return this.getTypeName();
    }
}
