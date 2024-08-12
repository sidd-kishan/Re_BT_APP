/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.FunctionReferenceImpl
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.TypesJVMKt
 */
package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.TypesJVMKt;

@Metadata(d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\b\u0004"}, d2={"<anonymous>", "", "p1", "Ljava/lang/reflect/Type;", "invoke"}, k=3, mv={1, 5, 1})
static final class ParameterizedTypeImpl.getTypeName.1.1
extends FunctionReferenceImpl
implements Function1<Type, String> {
    public static final ParameterizedTypeImpl.getTypeName.1.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    ParameterizedTypeImpl.getTypeName.1.1() {
    }

    public final String invoke(Type type) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"p1");
        return TypesJVMKt.access$typeToString((Type)type);
    }
}
