/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.ClassBasedDeclarationContainer
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 */
package kotlin.jvm;

import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u0018\u001a\u00020\u0019\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\r*\u0006\u0012\u0002\b\u00030\u001a\u00a2\u0006\u0002\u0010\u001b\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"-\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G\u00a2\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\u0002H\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000e\";\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018\u00c7\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"-\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b\"+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00078G\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2={"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class JvmClassMappingKt {
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(T object) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$annotationClass");
        object = object.annotationType();
        Intrinsics.checkNotNullExpressionValue(object, (String)"(this as java.lang.annot\u2026otation).annotationType()");
        object = JvmClassMappingKt.getKotlinClass(object);
        if (object == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
        return object;
    }

    public static final <T> Class<T> getJavaClass(T object) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$javaClass");
        object = object.getClass();
        if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
        return object;
    }

    public static final <T> Class<T> getJavaClass(KClass<T> object) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$java");
        object = ((ClassBasedDeclarationContainer)object).getJClass();
        if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
        return object;
    }

    public static /* synthetic */ void getJavaClass$annotations(KClass kClass) {
    }

    public static final <T> Class<T> getJavaObjectType(KClass<T> object) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$javaObjectType");
        object = ((ClassBasedDeclarationContainer)object).getJClass();
        if (!((Class)object).isPrimitive()) {
            if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
            return object;
        }
        String string = ((Class)object).getName();
        if (string != null) {
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 109413500: {
                    if (!string.equals("short")) break;
                    object = Short.class;
                    break;
                }
                case 97526364: {
                    if (!string.equals("float")) break;
                    object = Float.class;
                    break;
                }
                case 64711720: {
                    if (!string.equals("boolean")) break;
                    object = Boolean.class;
                    break;
                }
                case 3625364: {
                    if (!string.equals("void")) break;
                    object = Void.class;
                    break;
                }
                case 3327612: {
                    if (!string.equals("long")) break;
                    object = Long.class;
                    break;
                }
                case 3052374: {
                    if (!string.equals("char")) break;
                    object = Character.class;
                    break;
                }
                case 3039496: {
                    if (!string.equals("byte")) break;
                    object = Byte.class;
                    break;
                }
                case 104431: {
                    if (!string.equals("int")) break;
                    object = Integer.class;
                    break;
                }
                case -1325958191: {
                    if (!string.equals("double")) break;
                    object = Double.class;
                }
            }
        }
        if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
        return object;
    }

    public static final <T> Class<T> getJavaPrimitiveType(KClass<T> object) {
        block13: {
            block12: {
                Intrinsics.checkNotNullParameter(object, (String)"$this$javaPrimitiveType");
                object = ((ClassBasedDeclarationContainer)object).getJClass();
                if (((Class)object).isPrimitive()) {
                    if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
                    return object;
                }
                if ((object = ((Class)object).getName()) == null) break block12;
                switch (((String)object).hashCode()) {
                    default: {
                        break;
                    }
                    case 761287205: {
                        if (!((String)object).equals("java.lang.Double")) break;
                        object = Double.TYPE;
                        break block13;
                    }
                    case 399092968: {
                        if (!((String)object).equals("java.lang.Void")) break;
                        object = Void.TYPE;
                        break block13;
                    }
                    case 398795216: {
                        if (!((String)object).equals("java.lang.Long")) break;
                        object = Long.TYPE;
                        break block13;
                    }
                    case 398507100: {
                        if (!((String)object).equals("java.lang.Byte")) break;
                        object = Byte.TYPE;
                        break block13;
                    }
                    case 344809556: {
                        if (!((String)object).equals("java.lang.Boolean")) break;
                        object = Boolean.TYPE;
                        break block13;
                    }
                    case 155276373: {
                        if (!((String)object).equals("java.lang.Character")) break;
                        object = Character.TYPE;
                        break block13;
                    }
                    case -515992664: {
                        if (!((String)object).equals("java.lang.Short")) break;
                        object = Short.TYPE;
                        break block13;
                    }
                    case -527879800: {
                        if (!((String)object).equals("java.lang.Float")) break;
                        object = Float.TYPE;
                        break block13;
                    }
                    case -2056817302: {
                        if (!((String)object).equals("java.lang.Integer")) break;
                        object = Integer.TYPE;
                        break block13;
                    }
                }
            }
            object = null;
        }
        return object;
    }

    public static final <T> KClass<T> getKotlinClass(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"$this$kotlin");
        return Reflection.getOrCreateKotlinClass(clazz);
    }

    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(KClass<T> object) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$javaClass");
        object = ((Object)object).getClass();
        if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
        return object;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith=@ReplaceWith(expression="(this as Any).javaClass", imports={}))
    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(KClass kClass) {
    }

    public static final /* synthetic */ <T> boolean isArrayOf(Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)objectArray, (String)"$this$isArrayOf");
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        return Object.class.isAssignableFrom(objectArray.getClass().getComponentType());
    }
}
