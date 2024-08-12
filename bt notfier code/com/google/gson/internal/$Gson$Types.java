/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.$Gson$Preconditions;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

public final class $Gson$Types {
    static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    private $Gson$Types() {
        throw new UnsupportedOperationException();
    }

    public static GenericArrayType arrayOf(Type type) {
        return new GenericArrayTypeImpl(type);
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class clazz = (Class)type;
            type = clazz;
            if (!clazz.isArray()) return type;
            type = new GenericArrayTypeImpl($Gson$Types.canonicalize(clazz.getComponentType()));
            return type;
        }
        if (type instanceof ParameterizedType) {
            type = (ParameterizedType)type;
            return new ParameterizedTypeImpl(type.getOwnerType(), type.getRawType(), type.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new GenericArrayTypeImpl(((GenericArrayType)type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) return type;
        type = (WildcardType)type;
        return new WildcardTypeImpl(type.getUpperBounds(), type.getLowerBounds());
    }

    static void checkNotPrimitive(Type type) {
        boolean bl = !(type instanceof Class) || !((Class)type).isPrimitive();
        $Gson$Preconditions.checkArgument(bl);
    }

    private static Class<?> declaringClassOf(TypeVariable<?> type) {
        type = (type = type.getGenericDeclaration()) instanceof Class ? (Class)type : null;
        return type;
    }

    static boolean equal(Object object, Object object2) {
        boolean bl = object == object2 || object != null && object.equals(object2);
        return bl;
    }

    public static boolean equals(Type type, Type type2) {
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            type = (ParameterizedType)type;
            type2 = (ParameterizedType)type2;
            bl2 = $Gson$Types.equal(type.getOwnerType(), type2.getOwnerType()) && type.getRawType().equals(type2.getRawType()) && Arrays.equals(type.getActualTypeArguments(), type2.getActualTypeArguments()) ? bl3 : false;
            return bl2;
        }
        if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            type = (GenericArrayType)type;
            type2 = (GenericArrayType)type2;
            return $Gson$Types.equals(type.getGenericComponentType(), type2.getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            type = (WildcardType)type;
            type2 = (WildcardType)type2;
            bl2 = Arrays.equals(type.getUpperBounds(), type2.getUpperBounds()) && Arrays.equals(type.getLowerBounds(), type2.getLowerBounds()) ? bl : false;
            return bl2;
        }
        if (!(type instanceof TypeVariable)) return false;
        if (!(type2 instanceof TypeVariable)) {
            return false;
        }
        type = (TypeVariable)type;
        type2 = (TypeVariable)type2;
        if (type.getGenericDeclaration() == type2.getGenericDeclaration() && type.getName().equals(type2.getName())) return bl2;
        bl2 = false;
        return bl2;
    }

    public static Type getArrayComponentType(Type type) {
        type = type instanceof GenericArrayType ? ((GenericArrayType)type).getGenericComponentType() : ((Class)type).getComponentType();
        return type;
    }

    public static Type getCollectionElementType(Type type, Class<?> type2) {
        type = type2 = $Gson$Types.getSupertype(type, type2, Collection.class);
        if (type2 instanceof WildcardType) {
            type = ((WildcardType)type2).getUpperBounds()[0];
        }
        if (!(type instanceof ParameterizedType)) return Object.class;
        return ((ParameterizedType)type).getActualTypeArguments()[0];
    }

    static Type getGenericSupertype(Type object, Class<?> object2, Class<?> clazz) {
        if (clazz == object2) {
            return object;
        }
        if (clazz.isInterface()) {
            object = ((Class)object2).getInterfaces();
            int n = ((Class<?>[])object).length;
            for (int i = 0; i < n; ++i) {
                if (object[i] == clazz) {
                    return ((Class)object2).getGenericInterfaces()[i];
                }
                if (!clazz.isAssignableFrom(object[i])) continue;
                return $Gson$Types.getGenericSupertype(((Class)object2).getGenericInterfaces()[i], object[i], clazz);
            }
        }
        if (((Class)object2).isInterface()) return clazz;
        while (object2 != Object.class) {
            object = ((Class)object2).getSuperclass();
            if (object == clazz) {
                return ((Class)object2).getGenericSuperclass();
            }
            if (clazz.isAssignableFrom((Class<?>)object)) {
                return $Gson$Types.getGenericSupertype(((Class)object2).getGenericSuperclass(), object, clazz);
            }
            object2 = object;
        }
        return clazz;
    }

    public static Type[] getMapKeyAndValueTypes(Type type, Class<?> clazz) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        if (!((type = $Gson$Types.getSupertype(type, clazz, Map.class)) instanceof ParameterizedType)) return new Type[]{Object.class, Object.class};
        return ((ParameterizedType)type).getActualTypeArguments();
    }

    public static Class<?> getRawType(Type type) {
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType)type).getRawType();
            $Gson$Preconditions.checkArgument(type instanceof Class);
            return (Class)type;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance($Gson$Types.getRawType(((GenericArrayType)type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return $Gson$Types.getRawType(((WildcardType)type).getUpperBounds()[0]);
        }
        String string = type == null ? "null" : type.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append(type);
        stringBuilder.append("> is of type ");
        stringBuilder.append(string);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static Type getSupertype(Type type, Class<?> clazz, Class<?> clazz2) {
        Type type2 = type;
        if (type instanceof WildcardType) {
            type2 = ((WildcardType)type).getUpperBounds()[0];
        }
        $Gson$Preconditions.checkArgument(clazz2.isAssignableFrom(clazz));
        return $Gson$Types.resolve(type2, clazz, $Gson$Types.getGenericSupertype(type2, clazz, clazz2));
    }

    static int hashCodeOrZero(Object object) {
        int n = object != null ? object.hashCode() : 0;
        return n;
    }

    private static int indexOf(Object[] object, Object object2) {
        int n = ((Object[])object).length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                object = new NoSuchElementException();
                throw object;
            }
            if (object2.equals(object[n2])) {
                return n2;
            }
            ++n2;
        }
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type ... typeArray) {
        return new ParameterizedTypeImpl(type, type2, typeArray);
    }

    public static Type resolve(Type type, Class<?> clazz, Type type2) {
        return $Gson$Types.resolve(type, clazz, type2, new HashMap());
    }

    private static Type resolve(Type type, Class<?> clazz, Type object, Map<TypeVariable<?>, Type> map) {
        Type type2;
        block16: {
            Type type3;
            block17: {
                Type[] typeArray;
                Type type4;
                block23: {
                    block20: {
                        block21: {
                            block22: {
                                block18: {
                                    block19: {
                                        type4 = null;
                                        type2 = object;
                                        while (type2 instanceof TypeVariable) {
                                            type3 = (TypeVariable)type2;
                                            object = map.get(type3);
                                            if (object != null) {
                                                if (object == Void.TYPE) return type2;
                                                type2 = object;
                                                break block16;
                                            }
                                            map.put((TypeVariable<?>)type3, Void.TYPE);
                                            object = type4;
                                            if (type4 == null) {
                                                object = type3;
                                            }
                                            typeArray = $Gson$Types.resolveTypeVariable(type, clazz, type3);
                                            type4 = object;
                                            type2 = typeArray;
                                            if (typeArray != type3) continue;
                                            type3 = object;
                                            object = typeArray;
                                            break block17;
                                        }
                                        if (!(type2 instanceof Class) || !(object = (Class)type2).isArray()) break block18;
                                        type2 = object.getComponentType();
                                        if (!$Gson$Types.equal(type2, type = $Gson$Types.resolve(type, clazz, type2, map))) break block19;
                                        type3 = type4;
                                        break block17;
                                    }
                                    type = $Gson$Types.arrayOf(type);
                                    break block20;
                                }
                                if (!(type2 instanceof GenericArrayType)) break block21;
                                object = (GenericArrayType)type2;
                                if (!$Gson$Types.equal(type2 = object.getGenericComponentType(), type = $Gson$Types.resolve(type, clazz, type2, map))) break block22;
                                type3 = type4;
                                break block17;
                            }
                            type = $Gson$Types.arrayOf(type);
                            break block20;
                        }
                        boolean bl = type2 instanceof ParameterizedType;
                        if (!bl) break block23;
                        typeArray = (ParameterizedType)type2;
                        object = typeArray.getOwnerType();
                        Type type5 = $Gson$Types.resolve(type, clazz, object, map);
                        boolean bl2 = $Gson$Types.equal(type5, object) ^ true;
                        type2 = typeArray.getActualTypeArguments();
                        int n = ((Type)type2).length;
                        for (int i = 0; i < n; ++i) {
                            type3 = $Gson$Types.resolve(type, clazz, type2[i], map);
                            boolean bl3 = bl2;
                            object = type2;
                            if (!$Gson$Types.equal(type3, type2[i])) {
                                bl3 = bl2;
                                object = type2;
                                if (!bl2) {
                                    object = (Type[])type2.clone();
                                    bl3 = true;
                                }
                                object[i] = type3;
                            }
                            bl2 = bl3;
                            type2 = object;
                        }
                        type3 = type4;
                        object = typeArray;
                        if (!bl2) break block17;
                        type = $Gson$Types.newParameterizedTypeWithOwner(type5, typeArray.getRawType(), (Type[])type2);
                    }
                    type3 = type4;
                    object = type;
                    break block17;
                }
                type3 = type4;
                object = type2;
                if (type2 instanceof WildcardType) {
                    type2 = (WildcardType)type2;
                    Type[] typeArray2 = type2.getLowerBounds();
                    typeArray = type2.getUpperBounds();
                    if (typeArray2.length == 1) {
                        type = $Gson$Types.resolve(type, clazz, typeArray2[0], map);
                        type3 = type4;
                        object = type2;
                        if (type != typeArray2[0]) {
                            object = $Gson$Types.supertypeOf(type);
                            type3 = type4;
                        }
                    } else {
                        type3 = type4;
                        object = type2;
                        if (typeArray.length == 1) {
                            object = typeArray[0];
                            type = $Gson$Types.resolve(type, clazz, (Type)object, map);
                            type3 = type4;
                            object = type2;
                            if (type != typeArray[0]) {
                                object = $Gson$Types.subtypeOf(type);
                                type3 = type4;
                            }
                        }
                    }
                }
            }
            if (type3 == null) return object;
            map.put((TypeVariable<?>)type3, (Type)object);
            return object;
        }
        return type2;
    }

    static Type resolveTypeVariable(Type type, Class<?> clazz, TypeVariable<?> typeVariable) {
        Class<?> clazz2 = $Gson$Types.declaringClassOf(typeVariable);
        if (clazz2 == null) {
            return typeVariable;
        }
        if (!((type = $Gson$Types.getGenericSupertype(type, clazz, clazz2)) instanceof ParameterizedType)) return typeVariable;
        int n = $Gson$Types.indexOf(clazz2.getTypeParameters(), typeVariable);
        return ((ParameterizedType)type).getActualTypeArguments()[n];
    }

    public static WildcardType subtypeOf(Type typeArray) {
        typeArray = typeArray instanceof WildcardType ? ((WildcardType)typeArray).getUpperBounds() : new Type[]{typeArray};
        return new WildcardTypeImpl(typeArray, EMPTY_TYPE_ARRAY);
    }

    public static WildcardType supertypeOf(Type typeArray) {
        typeArray = typeArray instanceof WildcardType ? ((WildcardType)typeArray).getLowerBounds() : new Type[]{typeArray};
        return new WildcardTypeImpl(new Type[]{Object.class}, typeArray);
    }

    public static String typeToString(Type object) {
        object = object instanceof Class ? ((Class)object).getName() : object.toString();
        return object;
    }

    private static final class GenericArrayTypeImpl
    implements GenericArrayType,
    Serializable {
        private final Type componentType;
        private static final long serialVersionUID = 0L;

        public GenericArrayTypeImpl(Type componentType) {
            Objects.requireNonNull(componentType);
            this.componentType = $Gson$Types.canonicalize(componentType);
        }

        @Override
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public boolean equals(Object o) {
            return o instanceof GenericArrayType && $Gson$Types.equals(this, (GenericArrayType)o);
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return $Gson$Types.typeToString(this.componentType) + "[]";
        }
    }

    private static final class ParameterizedTypeImpl
    implements ParameterizedType,
    Serializable {
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;
        private static final long serialVersionUID = 0L;

        public ParameterizedTypeImpl(Type ownerType, Type rawType, Type ... typeArguments) {
            Objects.requireNonNull(rawType);
            if (rawType instanceof Class) {
                Class rawTypeAsClass = (Class)rawType;
                boolean isStaticOrTopLevelClass = Modifier.isStatic(rawTypeAsClass.getModifiers()) || rawTypeAsClass.getEnclosingClass() == null;
                $Gson$Preconditions.checkArgument(ownerType != null || isStaticOrTopLevelClass);
            }
            this.ownerType = ownerType == null ? null : $Gson$Types.canonicalize(ownerType);
            this.rawType = $Gson$Types.canonicalize(rawType);
            this.typeArguments = (Type[])typeArguments.clone();
            int t = 0;
            int length = this.typeArguments.length;
            while (t < length) {
                Objects.requireNonNull(this.typeArguments[t]);
                $Gson$Types.checkNotPrimitive(this.typeArguments[t]);
                this.typeArguments[t] = $Gson$Types.canonicalize(this.typeArguments[t]);
                ++t;
            }
        }

        @Override
        public Type[] getActualTypeArguments() {
            return (Type[])this.typeArguments.clone();
        }

        @Override
        public Type getRawType() {
            return this.rawType;
        }

        @Override
        public Type getOwnerType() {
            return this.ownerType;
        }

        public boolean equals(Object other) {
            return other instanceof ParameterizedType && $Gson$Types.equals(this, (ParameterizedType)other);
        }

        private static int hashCodeOrZero(Object o) {
            return o != null ? o.hashCode() : 0;
        }

        public int hashCode() {
            return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ ParameterizedTypeImpl.hashCodeOrZero(this.ownerType);
        }

        public String toString() {
            int length = this.typeArguments.length;
            if (length == 0) {
                return $Gson$Types.typeToString(this.rawType);
            }
            StringBuilder stringBuilder = new StringBuilder(30 * (length + 1));
            stringBuilder.append($Gson$Types.typeToString(this.rawType)).append("<").append($Gson$Types.typeToString(this.typeArguments[0]));
            int i = 1;
            while (i < length) {
                stringBuilder.append(", ").append($Gson$Types.typeToString(this.typeArguments[i]));
                ++i;
            }
            return stringBuilder.append(">").toString();
        }
    }

    private static final class WildcardTypeImpl
    implements WildcardType,
    Serializable {
        private final Type upperBound;
        private final Type lowerBound;
        private static final long serialVersionUID = 0L;

        public WildcardTypeImpl(Type[] upperBounds, Type[] lowerBounds) {
            $Gson$Preconditions.checkArgument(lowerBounds.length <= 1);
            $Gson$Preconditions.checkArgument(upperBounds.length == 1);
            if (lowerBounds.length == 1) {
                Objects.requireNonNull(lowerBounds[0]);
                $Gson$Types.checkNotPrimitive(lowerBounds[0]);
                $Gson$Preconditions.checkArgument(upperBounds[0] == Object.class);
                this.lowerBound = $Gson$Types.canonicalize(lowerBounds[0]);
                this.upperBound = Object.class;
            } else {
                Objects.requireNonNull(upperBounds[0]);
                $Gson$Types.checkNotPrimitive(upperBounds[0]);
                this.lowerBound = null;
                this.upperBound = $Gson$Types.canonicalize(upperBounds[0]);
            }
        }

        @Override
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        @Override
        public Type[] getLowerBounds() {
            Type[] typeArray;
            if (this.lowerBound != null) {
                Type[] typeArray2 = new Type[1];
                typeArray = typeArray2;
                typeArray2[0] = this.lowerBound;
            } else {
                typeArray = EMPTY_TYPE_ARRAY;
            }
            return typeArray;
        }

        public boolean equals(Object other) {
            return other instanceof WildcardType && $Gson$Types.equals(this, (WildcardType)other);
        }

        public int hashCode() {
            return (this.lowerBound != null ? 31 + this.lowerBound.hashCode() : 1) ^ 31 + this.upperBound.hashCode();
        }

        public String toString() {
            if (this.lowerBound != null) {
                return "? super " + $Gson$Types.typeToString(this.lowerBound);
            }
            if (this.upperBound != Object.class) return "? extends " + $Gson$Types.typeToString(this.upperBound);
            return "?";
        }
    }
}
