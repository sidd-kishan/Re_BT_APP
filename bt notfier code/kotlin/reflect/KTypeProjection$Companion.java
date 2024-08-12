/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KType
 *  kotlin.reflect.KTypeProjection
 *  kotlin.reflect.KVariance
 */
package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002\u00a8\u0006\u000e"}, d2={"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "star", "getStar$annotations", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class KTypeProjection.Companion {
    private KTypeProjection.Companion() {
    }

    public /* synthetic */ KTypeProjection.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void getStar$annotations() {
    }

    @JvmStatic
    public final KTypeProjection contravariant(KType kType) {
        Intrinsics.checkNotNullParameter((Object)kType, (String)"type");
        return new KTypeProjection(KVariance.IN, kType);
    }

    @JvmStatic
    public final KTypeProjection covariant(KType kType) {
        Intrinsics.checkNotNullParameter((Object)kType, (String)"type");
        return new KTypeProjection(KVariance.OUT, kType);
    }

    public final KTypeProjection getSTAR() {
        return KTypeProjection.star;
    }

    @JvmStatic
    public final KTypeProjection invariant(KType kType) {
        Intrinsics.checkNotNullParameter((Object)kType, (String)"type");
        return new KTypeProjection(KVariance.INVARIANT, kType);
    }
}
