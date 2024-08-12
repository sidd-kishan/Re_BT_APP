/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeParameterReference$Companion$WhenMappings
 *  kotlin.reflect.KTypeParameter
 *  kotlin.reflect.KVariance
 */
package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/jvm/internal/TypeParameterReference$Companion;", "", "()V", "toString", "", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class TypeParameterReference.Companion {
    private TypeParameterReference.Companion() {
    }

    public /* synthetic */ TypeParameterReference.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String toString(KTypeParameter object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"typeParameter");
        StringBuilder stringBuilder = new StringBuilder();
        KVariance kVariance = object.getVariance();
        int n = WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()];
        if (n != 2) {
            if (n == 3) {
                stringBuilder.append("out ");
            }
        } else {
            stringBuilder.append("in ");
        }
        stringBuilder.append(object.getName());
        object = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"StringBuilder().apply(builderAction).toString()");
        return object;
    }
}
