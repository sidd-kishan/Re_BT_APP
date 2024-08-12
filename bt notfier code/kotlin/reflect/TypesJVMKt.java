/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.KTypeBase
 *  kotlin.reflect.GenericArrayTypeImpl
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KType
 *  kotlin.reflect.KTypeParameter
 *  kotlin.reflect.KTypeProjection
 *  kotlin.reflect.KVariance
 *  kotlin.reflect.ParameterizedTypeImpl
 *  kotlin.reflect.TypeVariableImpl
 *  kotlin.reflect.TypesJVMKt$WhenMappings
 *  kotlin.reflect.TypesJVMKt$typeToString$unwrap$1
 *  kotlin.reflect.WildcardTypeImpl
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.StringsKt
 */
package kotlin.reflect;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.reflect.GenericArrayTypeImpl;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.ParameterizedTypeImpl;
import kotlin.reflect.TypeVariableImpl;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.WildcardTypeImpl;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t\u00a8\u0006\u0015"}, d2={"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class TypesJVMKt {
    public static final /* synthetic */ Type access$computeJavaType(KType kType, boolean bl) {
        return TypesJVMKt.computeJavaType(kType, bl);
    }

    public static final /* synthetic */ String access$typeToString(Type type) {
        return TypesJVMKt.typeToString(type);
    }

    private static final Type computeJavaType(KType object, boolean bl) {
        int n;
        Object object2 = object.getClassifier();
        if (object2 instanceof KTypeParameter) {
            return (Type)new TypeVariableImpl((KTypeParameter)object2);
        }
        if (!(object2 instanceof KClass)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unsupported type classifier: ");
            ((StringBuilder)object2).append(object);
            throw (Throwable)new UnsupportedOperationException(((StringBuilder)object2).toString());
        }
        object2 = (KClass)object2;
        object2 = bl ? JvmClassMappingKt.getJavaObjectType((KClass)object2) : JvmClassMappingKt.getJavaClass((KClass)object2);
        List list = object.getArguments();
        if (list.isEmpty()) {
            return (Type)object2;
        }
        if (!((Class)object2).isArray()) return TypesJVMKt.createPossiblyInnerType(object2, list);
        KTypeProjection kTypeProjection = ((Class)object2).getComponentType();
        Intrinsics.checkNotNullExpressionValue(kTypeProjection, (String)"jClass.componentType");
        if (kTypeProjection.isPrimitive()) {
            return (Type)object2;
        }
        kTypeProjection = (KTypeProjection)CollectionsKt.singleOrNull((List)list);
        if (kTypeProjection == null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("kotlin.Array must have exactly one type argument: ");
            ((StringBuilder)object2).append(object);
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object2).toString());
        }
        object = kTypeProjection.component1();
        kTypeProjection = kTypeProjection.component2();
        if (object != null && (n = WhenMappings.$EnumSwitchMapping$0[object.ordinal()]) != 1) {
            if (n != 2) {
                if (n != 3) throw new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNull((Object)kTypeProjection);
            object = TypesJVMKt.computeJavaType$default((KType)kTypeProjection, false, 1, null);
            if (!(object instanceof Class)) {
                object2 = new GenericArrayTypeImpl((Type)object);
            }
            object = (Type)object2;
        } else {
            object = (Type)object2;
        }
        return object;
    }

    static /* synthetic */ Type computeJavaType$default(KType kType, boolean bl, int n, Object object) {
        if ((n & 1) == 0) return TypesJVMKt.computeJavaType(kType, bl);
        bl = false;
        return TypesJVMKt.computeJavaType(kType, bl);
    }

    private static final Type createPossiblyInnerType(Class<?> clazz, List<KTypeProjection> collection) {
        Class<?> clazz2 = clazz.getDeclaringClass();
        if (clazz2 != null) {
            if (Modifier.isStatic(clazz.getModifiers())) {
                clazz2 = clazz2;
                Object object = collection;
                collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
                object = object.iterator();
                while (object.hasNext()) {
                    collection.add(TypesJVMKt.getJavaType((KTypeProjection)object.next()));
                }
                return (Type)new ParameterizedTypeImpl(clazz, (Type)clazz2, (List)collection);
            }
            int n = clazz.getTypeParameters().length;
            clazz2 = TypesJVMKt.createPossiblyInnerType(clazz2, collection.subList(n, collection.size()));
            Object object = collection.subList(0, n);
            collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
            object = object.iterator();
            while (object.hasNext()) {
                collection.add(TypesJVMKt.getJavaType((KTypeProjection)object.next()));
            }
            return (Type)new ParameterizedTypeImpl(clazz, (Type)clazz2, (List)collection);
        }
        clazz2 = collection;
        collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)((Object)clazz2), (int)10));
        clazz2 = clazz2.iterator();
        while (clazz2.hasNext()) {
            collection.add(TypesJVMKt.getJavaType((KTypeProjection)clazz2.next()));
        }
        return (Type)new ParameterizedTypeImpl(clazz, null, (List)collection);
    }

    public static final Type getJavaType(KType kType) {
        Intrinsics.checkNotNullParameter((Object)kType, (String)"$this$javaType");
        if (!(kType instanceof KTypeBase)) return TypesJVMKt.computeJavaType$default(kType, false, 1, null);
        Type type = ((KTypeBase)kType).getJavaType();
        if (type == null) return TypesJVMKt.computeJavaType$default(kType, false, 1, null);
        return type;
    }

    private static final Type getJavaType(KTypeProjection object) {
        KVariance kVariance = object.getVariance();
        if (kVariance == null) return (Type)WildcardTypeImpl.Companion.getSTAR();
        object = object.getType();
        Intrinsics.checkNotNull((Object)object);
        int n = WhenMappings.$EnumSwitchMapping$1[kVariance.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) throw new NoWhenBranchMatchedException();
                object = (Type)new WildcardTypeImpl(TypesJVMKt.computeJavaType((KType)object, true), null);
            } else {
                object = (Type)new WildcardTypeImpl(null, TypesJVMKt.computeJavaType((KType)object, true));
            }
        } else {
            object = TypesJVMKt.computeJavaType((KType)object, true);
        }
        return object;
    }

    public static /* synthetic */ void getJavaType$annotations(KType kType) {
    }

    private static /* synthetic */ void getJavaType$annotations(KTypeProjection kTypeProjection) {
    }

    private static final String typeToString(Type object) {
        if (object instanceof Class) {
            Serializable serializable = (Class)object;
            if (((Class)serializable).isArray()) {
                object = SequencesKt.generateSequence((Object)object, (Function1)((Function1)typeToString.unwrap.1.INSTANCE));
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append(((Class)SequencesKt.last((Sequence)object)).getName());
                ((StringBuilder)serializable).append(StringsKt.repeat((CharSequence)"[]", (int)SequencesKt.count((Sequence)object)));
                object = ((StringBuilder)serializable).toString();
            } else {
                object = ((Class)serializable).getName();
            }
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"if (type.isArray) {\n    \u2026\n        } else type.name");
        } else {
            object = object.toString();
        }
        return object;
    }
}
