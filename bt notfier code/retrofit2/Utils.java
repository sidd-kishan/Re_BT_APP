/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.MediaType
 *  okhttp3.ResponseBody
 *  okio.Buffer
 *  okio.BufferedSource
 *  okio.Sink
 *  retrofit2.Utils$GenericArrayTypeImpl
 *  retrofit2.Utils$ParameterizedTypeImpl
 *  retrofit2.Utils$WildcardTypeImpl
 */
package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import retrofit2.Utils;

final class Utils {
    static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    private Utils() {
    }

    static ResponseBody buffer(ResponseBody responseBody) throws IOException {
        Buffer buffer = new Buffer();
        responseBody.source().readAll((Sink)buffer);
        return ResponseBody.create((MediaType)responseBody.contentType(), (long)responseBody.contentLength(), (BufferedSource)buffer);
    }

    static void checkNotPrimitive(Type type) {
        if (!(type instanceof Class)) return;
        if (((Class)type).isPrimitive()) throw new IllegalArgumentException();
    }

    @Nullable
    private static Class<?> declaringClassOf(TypeVariable<?> type) {
        type = (type = type.getGenericDeclaration()) instanceof Class ? (Class)type : null;
        return type;
    }

    static boolean equals(Type type, Type type2) {
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
            ParameterizedType parameterizedType = (ParameterizedType)type2;
            Type type3 = type.getOwnerType();
            bl2 = (type3 == (type2 = parameterizedType.getOwnerType()) || type3 != null && type3.equals(type2)) && type.getRawType().equals(parameterizedType.getRawType()) && Arrays.equals(type.getActualTypeArguments(), parameterizedType.getActualTypeArguments()) ? bl3 : false;
            return bl2;
        }
        if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            type = (GenericArrayType)type;
            type2 = (GenericArrayType)type2;
            return Utils.equals(type.getGenericComponentType(), type2.getGenericComponentType());
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
                return Utils.getGenericSupertype(((Class)object2).getGenericInterfaces()[i], object[i], clazz);
            }
        }
        if (((Class)object2).isInterface()) return clazz;
        while (object2 != Object.class) {
            object = ((Class)object2).getSuperclass();
            if (object == clazz) {
                return ((Class)object2).getGenericSuperclass();
            }
            if (clazz.isAssignableFrom((Class<?>)object)) {
                return Utils.getGenericSupertype(((Class)object2).getGenericSuperclass(), object, clazz);
            }
            object2 = object;
        }
        return clazz;
    }

    static Type getParameterLowerBound(int n, ParameterizedType type) {
        Type type2 = type.getActualTypeArguments()[n];
        type = type2;
        if (!(type2 instanceof WildcardType)) return type;
        type = ((WildcardType)type2).getLowerBounds()[0];
        return type;
    }

    static Type getParameterUpperBound(int n, ParameterizedType type) {
        Type[] typeArray = type.getActualTypeArguments();
        if (n >= 0 && n < typeArray.length) {
            Type type2 = typeArray[n];
            type = type2;
            if (!(type2 instanceof WildcardType)) return type;
            type = ((WildcardType)type2).getUpperBounds()[0];
            return type;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index ");
        stringBuilder.append(n);
        stringBuilder.append(" not in range [0,");
        stringBuilder.append(typeArray.length);
        stringBuilder.append(") for ");
        stringBuilder.append(type);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static Class<?> getRawType(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            if (!((type = ((ParameterizedType)type).getRawType()) instanceof Class)) throw new IllegalArgumentException();
            return (Class)type;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(Utils.getRawType(((GenericArrayType)type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return Utils.getRawType(((WildcardType)type).getUpperBounds()[0]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append(type);
        stringBuilder.append("> is of type ");
        stringBuilder.append(type.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static Type getSupertype(Type type, Class<?> clazz, Class<?> clazz2) {
        if (!clazz2.isAssignableFrom(clazz)) throw new IllegalArgumentException();
        return Utils.resolve(type, clazz, Utils.getGenericSupertype(type, clazz, clazz2));
    }

    static boolean hasUnresolvableType(@Nullable Type object) {
        if (object instanceof Class) {
            return false;
        }
        if (!(object instanceof ParameterizedType)) {
            if (object instanceof GenericArrayType) {
                return Utils.hasUnresolvableType(((GenericArrayType)object).getGenericComponentType());
            }
            if (object instanceof TypeVariable) {
                return true;
            }
            if (object instanceof WildcardType) {
                return true;
            }
            String string = object == null ? "null" : object.getClass().getName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
            stringBuilder.append(object);
            stringBuilder.append("> is of type ");
            stringBuilder.append(string);
            object = new IllegalArgumentException(stringBuilder.toString());
            throw object;
        }
        object = ((ParameterizedType)object).getActualTypeArguments();
        int n = ((Type[])object).length;
        int n2 = 0;
        while (n2 < n) {
            if (Utils.hasUnresolvableType(object[n2])) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    private static int indexOf(Object[] object, Object object2) {
        int n = 0;
        while (true) {
            if (n >= ((Object[])object).length) {
                object = new NoSuchElementException();
                throw object;
            }
            if (object2.equals(object[n])) {
                return n;
            }
            ++n;
        }
    }

    static boolean isAnnotationPresent(Annotation[] annotationArray, Class<? extends Annotation> clazz) {
        int n = annotationArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (clazz.isInstance(annotationArray[n2])) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    static RuntimeException methodError(Method method, String string, Object ... objectArray) {
        return Utils.methodError(method, null, string, objectArray);
    }

    static RuntimeException methodError(Method method, @Nullable Throwable throwable, String string, Object ... object) {
        string = String.format(string, (Object[])object);
        object = new StringBuilder();
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append("\n    for method ");
        ((StringBuilder)object).append(method.getDeclaringClass().getSimpleName());
        ((StringBuilder)object).append(".");
        ((StringBuilder)object).append(method.getName());
        return new IllegalArgumentException(((StringBuilder)object).toString(), throwable);
    }

    static RuntimeException parameterError(Method method, int n, String string, Object ... objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" (parameter #");
        stringBuilder.append(n + 1);
        stringBuilder.append(")");
        return Utils.methodError(method, stringBuilder.toString(), objectArray);
    }

    static RuntimeException parameterError(Method method, Throwable throwable, int n, String string, Object ... objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" (parameter #");
        stringBuilder.append(n + 1);
        stringBuilder.append(")");
        return Utils.methodError(method, throwable, stringBuilder.toString(), objectArray);
    }

    static Type resolve(Type object, Class<?> typeArray, Type type) {
        Type type2;
        while (type instanceof TypeVariable) {
            type2 = (TypeVariable)type;
            if ((type = Utils.resolveTypeVariable((Type)object, typeArray, type2)) != type2) continue;
            return type;
        }
        if (type instanceof Class && ((Class)(type2 = (Class)type)).isArray()) {
            type = ((Class)type2).getComponentType();
            object = type == (object = Utils.resolve((Type)object, typeArray, type)) ? type2 : new GenericArrayTypeImpl(object);
            return object;
        }
        if (type instanceof GenericArrayType) {
            type2 = (type = (GenericArrayType)type).getGenericComponentType();
            object = type2 == (object = Utils.resolve((Type)object, typeArray, type2)) ? type : new GenericArrayTypeImpl(object);
            return object;
        }
        boolean bl = type instanceof ParameterizedType;
        int n = 0;
        if (bl) {
            ParameterizedType parameterizedType = (ParameterizedType)type;
            Type type3 = Utils.resolve(object, typeArray, type = parameterizedType.getOwnerType());
            boolean bl2 = type3 != type;
            type = parameterizedType.getActualTypeArguments();
            int n2 = ((Type)type).length;
            while (true) {
                if (n >= n2) {
                    object = parameterizedType;
                    if (!bl2) return object;
                    object = new ParameterizedTypeImpl(type3, parameterizedType.getRawType(), (Type[])type);
                    return object;
                }
                Type type4 = Utils.resolve((Type)object, typeArray, type[n]);
                boolean bl3 = bl2;
                type2 = type;
                if (type4 != type[n]) {
                    bl3 = bl2;
                    type2 = type;
                    if (!bl2) {
                        type2 = (Type[])type.clone();
                        bl3 = true;
                    }
                    type2[n] = type4;
                }
                ++n;
                bl2 = bl3;
                type = type2;
            }
        }
        type2 = type;
        if (!(type instanceof WildcardType)) return type2;
        type = (WildcardType)type;
        Type[] typeArray2 = type.getLowerBounds();
        Type[] typeArray3 = type.getUpperBounds();
        if (typeArray2.length == 1) {
            object = Utils.resolve((Type)object, typeArray, typeArray2[0]);
            type2 = type;
            if (object == typeArray2[0]) return type2;
            return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{object});
        }
        type2 = type;
        if (typeArray3.length != 1) return type2;
        type2 = typeArray3[0];
        object = Utils.resolve((Type)object, typeArray, type2);
        type2 = type;
        if (object == typeArray3[0]) return type2;
        typeArray = EMPTY_TYPE_ARRAY;
        return new WildcardTypeImpl(new Type[]{object}, typeArray);
    }

    private static Type resolveTypeVariable(Type type, Class<?> clazz, TypeVariable<?> typeVariable) {
        Class<?> clazz2 = Utils.declaringClassOf(typeVariable);
        if (clazz2 == null) {
            return typeVariable;
        }
        if (!((type = Utils.getGenericSupertype(type, clazz, clazz2)) instanceof ParameterizedType)) return typeVariable;
        int n = Utils.indexOf(clazz2.getTypeParameters(), typeVariable);
        return ((ParameterizedType)type).getActualTypeArguments()[n];
    }

    static void throwIfFatal(Throwable throwable) {
        if (throwable instanceof VirtualMachineError) throw (VirtualMachineError)throwable;
        if (throwable instanceof ThreadDeath) throw (ThreadDeath)throwable;
        if (throwable instanceof LinkageError) throw (LinkageError)throwable;
    }

    static String typeToString(Type object) {
        object = object instanceof Class ? ((Class)object).getName() : object.toString();
        return object;
    }
}
