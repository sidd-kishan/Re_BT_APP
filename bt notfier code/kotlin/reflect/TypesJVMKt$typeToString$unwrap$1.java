/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.FunctionReferenceImpl
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0001\u00a2\u0006\u0002\b\u0004"}, d2={"<anonymous>", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "p1", "invoke"}, k=3, mv={1, 5, 1})
static final class TypesJVMKt.typeToString.unwrap.1
extends FunctionReferenceImpl
implements Function1<Class<? extends Object>, Class<?>> {
    public static final TypesJVMKt.typeToString.unwrap.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    TypesJVMKt.typeToString.unwrap.1() {
    }

    public final Class<?> invoke(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"p1");
        return clazz.getComponentType();
    }
}
