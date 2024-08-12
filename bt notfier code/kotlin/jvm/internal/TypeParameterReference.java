/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.TypeParameterReference$Companion
 *  kotlin.reflect.KType
 *  kotlin.reflect.KTypeParameter
 *  kotlin.reflect.KVariance
 */
package kotlin.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0004\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006 "}, d2={"Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/reflect/KTypeParameter;", "container", "", "name", "", "variance", "Lkotlin/reflect/KVariance;", "isReified", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "bounds", "", "Lkotlin/reflect/KType;", "()Z", "getName", "()Ljava/lang/String;", "upperBounds", "getUpperBounds$annotations", "()V", "getUpperBounds", "()Ljava/util/List;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "hashCode", "", "setUpperBounds", "", "toString", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class TypeParameterReference
implements KTypeParameter {
    public static final Companion Companion = new Companion(null);
    private volatile List<? extends KType> bounds;
    private final Object container;
    private final boolean isReified;
    private final String name;
    private final KVariance variance;

    public TypeParameterReference(Object object, String string, KVariance kVariance, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)kVariance, (String)"variance");
        this.container = object;
        this.name = string;
        this.variance = kVariance;
        this.isReified = bl;
    }

    public static /* synthetic */ void getUpperBounds$annotations() {
    }

    /*
     * Enabled force condition propagation
     */
    public boolean equals(Object object) {
        if (!(object instanceof TypeParameterReference)) return false;
        Object object2 = this.container;
        object = (TypeParameterReference)object;
        if (!Intrinsics.areEqual((Object)object2, (Object)((TypeParameterReference)object).container)) return false;
        if (!Intrinsics.areEqual((Object)this.getName(), (Object)((TypeParameterReference)object).getName())) return false;
        return true;
    }

    public String getName() {
        return this.name;
    }

    public List<KType> getUpperBounds() {
        List list = this.bounds;
        if (list != null) return list;
        this.bounds = list = CollectionsKt.listOf((Object)Reflection.nullableTypeOf(Object.class));
        return list;
    }

    public KVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        Object object = this.container;
        int n = object != null ? object.hashCode() : 0;
        return n * 31 + this.getName().hashCode();
    }

    public boolean isReified() {
        return this.isReified;
    }

    public final void setUpperBounds(List<? extends KType> object) {
        Intrinsics.checkNotNullParameter(object, (String)"upperBounds");
        if (this.bounds == null) {
            this.bounds = object;
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Upper bounds of type parameter '");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append("' have already been initialized.");
        throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
    }

    public String toString() {
        return Companion.toString((KTypeParameter)this);
    }
}
