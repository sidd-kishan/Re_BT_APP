/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.internal.ClassReference
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.reflect.KClass
 *  kotlin.text.StringsKt
 */
package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005R&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class ClassReference.Companion {
    private ClassReference.Companion() {
    }

    public /* synthetic */ ClassReference.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String getClassQualifiedName(Class<?> object) {
        Intrinsics.checkNotNullParameter(object, (String)"jClass");
        boolean bl = ((Class)object).isAnonymousClass();
        Object object2 = null;
        String string = null;
        if (bl) {
            object = object2;
        } else if (((Class)object).isLocalClass()) {
            object = object2;
        } else if (((Class)object).isArray()) {
            object2 = ((Class)object).getComponentType();
            Intrinsics.checkNotNullExpressionValue(object2, (String)"componentType");
            object = string;
            if (((Class)object2).isPrimitive()) {
                object2 = (String)ClassReference.access$getClassFqNames$cp().get(((Class)object2).getName());
                object = string;
                if (object2 != null) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append("Array");
                    object = ((StringBuilder)object).toString();
                }
            }
            if (object != null) return object;
            object = "kotlin.Array";
        } else {
            string = (String)ClassReference.access$getClassFqNames$cp().get(((Class)object).getName());
            object = string != null ? string : ((Class)object).getCanonicalName();
        }
        return object;
    }

    /*
     * Unable to fully structure code
     */
    public final String getClassSimpleName(Class<?> var1_1) {
        block9: {
            block8: {
                Intrinsics.checkNotNullParameter(var1_1, (String)"jClass");
                var2_2 = var1_1.isAnonymousClass();
                var4_3 = "Array";
                var5_4 = null;
                var3_5 = null;
                if (var2_2) ** GOTO lbl52
                if (!var1_1.isLocalClass()) break block8;
                var4_3 = var1_1.getSimpleName();
                var5_4 = var1_1.getEnclosingMethod();
                if (var5_4 == null) ** GOTO lbl-1000
                Intrinsics.checkNotNullExpressionValue((Object)var4_3, (String)"name");
                var3_5 = new StringBuilder();
                var3_5.append(var5_4.getName());
                var3_5.append("$");
                var3_5 = StringsKt.substringAfter$default((String)var4_3, (String)var3_5.toString(), null, (int)2, null);
                if (var3_5 != null) {
                    var1_1 = var3_5;
                } else if ((var3_5 = var1_1.getEnclosingConstructor()) != null) {
                    Intrinsics.checkNotNullExpressionValue((Object)var4_3, (String)"name");
                    var1_1 = new StringBuilder();
                    var1_1.append(var3_5.getName());
                    var1_1.append("$");
                    var1_1 = StringsKt.substringAfter$default((String)var4_3, (String)var1_1.toString(), null, (int)2, null);
                } else {
                    var1_1 = null;
                }
                if (var1_1 != null) return var1_1;
                Intrinsics.checkNotNullExpressionValue((Object)var4_3, (String)"name");
                var1_1 = StringsKt.substringAfter$default((String)var4_3, (char)'$', null, (int)2, null);
                break block9;
            }
            if (var1_1.isArray()) {
                var1_1 = var1_1.getComponentType();
                Intrinsics.checkNotNullExpressionValue(var1_1, (String)"componentType");
                var3_5 = var5_4;
                if (var1_1.isPrimitive()) {
                    var1_1 = (String)ClassReference.access$getSimpleNames$cp().get(var1_1.getName());
                    var3_5 = var5_4;
                    if (var1_1 != null) {
                        var3_5 = new StringBuilder();
                        var3_5.append((String)var1_1);
                        var3_5.append("Array");
                        var3_5 = var3_5.toString();
                    }
                }
                var1_1 = var4_3;
                if (var3_5 == null) return var1_1;
lbl52:
                // 2 sources

                var1_1 = var3_5;
            } else {
                var3_5 = (String)ClassReference.access$getSimpleNames$cp().get(var1_1.getName());
                var1_1 = var3_5 != null ? var3_5 : var1_1.getSimpleName();
            }
        }
        return var1_1;
    }

    public final boolean isInstance(Object object, Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"jClass");
        Class clazz2 = ClassReference.access$getFUNCTION_CLASSES$cp();
        if (clazz2 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        if ((clazz2 = (Integer)clazz2.get(clazz)) != null) {
            return TypeIntrinsics.isFunctionOfArity((Object)object, (int)((Number)((Object)clazz2)).intValue());
        }
        clazz2 = clazz;
        if (!clazz.isPrimitive()) return clazz2.isInstance(object);
        clazz2 = JvmClassMappingKt.getJavaObjectType((KClass)JvmClassMappingKt.getKotlinClass(clazz));
        return clazz2.isInstance(object);
    }
}
