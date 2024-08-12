/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KType
 *  kotlin.reflect.KTypeProjection$Companion
 *  kotlin.reflect.KTypeProjection$WhenMappings
 *  kotlin.reflect.KVariance
 */
package kotlin.reflect;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2={"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class KTypeProjection {
    public static final Companion Companion = new Companion(null);
    public static final KTypeProjection star = new KTypeProjection(null, null);
    private final KType type;
    private final KVariance variance;

    public KTypeProjection(KVariance object, KType kType) {
        this.variance = object;
        this.type = kType;
        boolean bl = true;
        boolean bl2 = object == null;
        boolean bl3 = this.type == null;
        bl2 = bl2 == bl3 ? bl : false;
        if (bl2) return;
        if (this.variance == null) {
            object = "Star projection must have no type specified.";
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("The projection variance ");
            ((StringBuilder)object).append(this.variance);
            ((StringBuilder)object).append(" requires type to be specified.");
            object = ((StringBuilder)object).toString();
        }
        throw (Throwable)new IllegalArgumentException(object.toString());
    }

    @JvmStatic
    public static final KTypeProjection contravariant(KType kType) {
        return Companion.contravariant(kType);
    }

    public static /* synthetic */ KTypeProjection copy$default(KTypeProjection kTypeProjection, KVariance kVariance, KType kType, int n, Object object) {
        if ((n & 1) != 0) {
            kVariance = kTypeProjection.variance;
        }
        if ((n & 2) == 0) return kTypeProjection.copy(kVariance, kType);
        kType = kTypeProjection.type;
        return kTypeProjection.copy(kVariance, kType);
    }

    @JvmStatic
    public static final KTypeProjection covariant(KType kType) {
        return Companion.covariant(kType);
    }

    @JvmStatic
    public static final KTypeProjection invariant(KType kType) {
        return Companion.invariant(kType);
    }

    public final KVariance component1() {
        return this.variance;
    }

    public final KType component2() {
        return this.type;
    }

    public final KTypeProjection copy(KVariance kVariance, KType kType) {
        return new KTypeProjection(kVariance, kType);
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof KTypeProjection)) return false;
        object = (KTypeProjection)object;
        if (!Intrinsics.areEqual((Object)this.variance, (Object)((KTypeProjection)object).variance)) return false;
        if (!Intrinsics.areEqual((Object)this.type, (Object)((KTypeProjection)object).type)) return false;
        return true;
    }

    public final KType getType() {
        return this.type;
    }

    public final KVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        KVariance kVariance = this.variance;
        int n = 0;
        int n2 = kVariance != null ? kVariance.hashCode() : 0;
        kVariance = this.type;
        if (kVariance == null) return n2 * 31 + n;
        n = kVariance.hashCode();
        return n2 * 31 + n;
    }

    public String toString() {
        Object object = this.variance;
        if (object == null) {
            object = "*";
        } else {
            int n = WhenMappings.$EnumSwitchMapping$0[object.ordinal()];
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) throw new NoWhenBranchMatchedException();
                    object = new StringBuilder();
                    ((StringBuilder)object).append("out ");
                    ((StringBuilder)object).append(this.type);
                    object = ((StringBuilder)object).toString();
                } else {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("in ");
                    ((StringBuilder)object).append(this.type);
                    object = ((StringBuilder)object).toString();
                }
            } else {
                object = String.valueOf(this.type);
            }
        }
        return object;
    }
}
