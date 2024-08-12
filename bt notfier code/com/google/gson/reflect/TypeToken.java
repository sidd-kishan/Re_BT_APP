/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.reflect;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeToken<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    protected TypeToken() {
        Type type;
        this.type = type = TypeToken.getSuperclassTypeParameter(this.getClass());
        this.rawType = $Gson$Types.getRawType(type);
        this.hashCode = this.type.hashCode();
    }

    TypeToken(Type type) {
        this.type = type = $Gson$Types.canonicalize($Gson$Preconditions.checkNotNull(type));
        this.rawType = $Gson$Types.getRawType(type);
        this.hashCode = this.type.hashCode();
    }

    private static AssertionError buildUnexpectedTypeError(Type type, Class<?> ... classArray) {
        StringBuilder stringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
        int n = classArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                stringBuilder.append("but got: ");
                stringBuilder.append(type.getClass().getName());
                stringBuilder.append(", for type token: ");
                stringBuilder.append(type.toString());
                stringBuilder.append('.');
                return new AssertionError((Object)stringBuilder.toString());
            }
            stringBuilder.append(classArray[n2].getName());
            stringBuilder.append(", ");
            ++n2;
        }
    }

    public static <T> TypeToken<T> get(Class<T> clazz) {
        return new TypeToken<T>(clazz);
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken(type);
    }

    public static TypeToken<?> getArray(Type type) {
        return new TypeToken($Gson$Types.arrayOf(type));
    }

    public static TypeToken<?> getParameterized(Type type, Type ... typeArray) {
        return new TypeToken($Gson$Types.newParameterizedTypeWithOwner(null, type, typeArray));
    }

    static Type getSuperclassTypeParameter(Class<?> type) {
        if ((type = type.getGenericSuperclass()) instanceof Class) throw new RuntimeException("Missing type parameter.");
        return $Gson$Types.canonicalize(((ParameterizedType)type).getActualTypeArguments()[0]);
    }

    private static boolean isAssignableFrom(Type clazz, GenericArrayType type) {
        Type type2 = type.getGenericComponentType();
        if (!(type2 instanceof ParameterizedType)) return true;
        if (clazz instanceof GenericArrayType) {
            type = ((GenericArrayType)((Object)clazz)).getGenericComponentType();
            return TypeToken.isAssignableFrom(type, (ParameterizedType)type2, new HashMap<String, Type>());
        }
        type = clazz;
        if (!(clazz instanceof Class)) return TypeToken.isAssignableFrom(type, (ParameterizedType)type2, new HashMap<String, Type>());
        clazz = clazz;
        while (true) {
            type = clazz;
            if (!clazz.isArray()) return TypeToken.isAssignableFrom(type, (ParameterizedType)type2, new HashMap<String, Type>());
            clazz = clazz.getComponentType();
        }
    }

    private static boolean isAssignableFrom(Type object, ParameterizedType parameterizedType, Map<String, Type> map) {
        int n;
        int n2 = 0;
        if (object == null) {
            return false;
        }
        if (parameterizedType.equals(object)) {
            return true;
        }
        Class<?> clazz = $Gson$Types.getRawType((Type)object);
        ParameterizedType parameterizedType2 = null;
        if (object instanceof ParameterizedType) {
            parameterizedType2 = (ParameterizedType)object;
        }
        if (parameterizedType2 != null) {
            Type[] typeArray = parameterizedType2.getActualTypeArguments();
            TypeVariable<Class<?>>[] typeVariableArray = clazz.getTypeParameters();
            for (n = 0; n < typeArray.length; ++n) {
                object = typeArray[n];
                TypeVariable<Class<?>> typeVariable = typeVariableArray[n];
                while (object instanceof TypeVariable) {
                    object = map.get(((TypeVariable)object).getName());
                }
                map.put(typeVariable.getName(), (Type)object);
            }
            if (TypeToken.typeEquals(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        object = clazz.getGenericInterfaces();
        int n3 = ((Type[])object).length;
        n = n2;
        while (n < n3) {
            if (TypeToken.isAssignableFrom(object[n], parameterizedType, new HashMap<String, Type>(map))) {
                return true;
            }
            ++n;
        }
        return TypeToken.isAssignableFrom(clazz.getGenericSuperclass(), parameterizedType, new HashMap<String, Type>(map));
    }

    private static boolean matches(Type type, Type type2, Map<String, Type> map) {
        boolean bl = type2.equals(type) || type instanceof TypeVariable && type2.equals(map.get(((TypeVariable)type).getName()));
        return bl;
    }

    private static boolean typeEquals(ParameterizedType typeArray, ParameterizedType typeArray2, Map<String, Type> map) {
        if (!typeArray.getRawType().equals(typeArray2.getRawType())) return false;
        typeArray = typeArray.getActualTypeArguments();
        typeArray2 = typeArray2.getActualTypeArguments();
        int n = 0;
        while (n < typeArray.length) {
            if (!TypeToken.matches(typeArray[n], typeArray2[n], map)) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public final boolean equals(Object object) {
        boolean bl = object instanceof TypeToken && $Gson$Types.equals(this.type, ((TypeToken)object).type);
        return bl;
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return this.isAssignableFrom(typeToken.getType());
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> clazz) {
        return this.isAssignableFrom((Type)clazz);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        boolean bl = false;
        if (type == null) {
            return false;
        }
        if (this.type.equals(type)) {
            return true;
        }
        Type type2 = this.type;
        if (type2 instanceof Class) {
            return this.rawType.isAssignableFrom($Gson$Types.getRawType(type));
        }
        if (type2 instanceof ParameterizedType) {
            return TypeToken.isAssignableFrom(type, (ParameterizedType)type2, new HashMap<String, Type>());
        }
        if (!(type2 instanceof GenericArrayType)) throw TypeToken.buildUnexpectedTypeError(type2, Class.class, ParameterizedType.class, GenericArrayType.class);
        boolean bl2 = bl;
        if (!this.rawType.isAssignableFrom($Gson$Types.getRawType(type))) return bl2;
        bl2 = bl;
        if (!TypeToken.isAssignableFrom(type, (GenericArrayType)this.type)) return bl2;
        bl2 = true;
        return bl2;
    }

    public final String toString() {
        return $Gson$Types.typeToString(this.type);
    }
}
