/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result$Companion
 *  kotlin.Result$Failure
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \"*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\"#B\u0016\b\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00d6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00018\u0000H\u0087\b\u00a2\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001fH\u0016\u00a2\u0006\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0005\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2={"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "getValue$annotations", "()V", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
@JvmInline
public final class Result<T>
implements Serializable {
    public static final Companion Companion = new Companion(null);
    private final Object value;

    private /* synthetic */ Result(Object object) {
        this.value = object;
    }

    public static final /* synthetic */ Result box_impl(Object object) {
        return new Result(object);
    }

    public static Object constructor_impl(Object object) {
        return object;
    }

    public static boolean equals_impl(Object object, Object object2) {
        if (!(object2 instanceof Result)) return false;
        if (!Intrinsics.areEqual((Object)object, (Object)((Result)object2).unbox_impl())) return false;
        return true;
    }

    public static final boolean equals_impl0(Object object, Object object2) {
        return Intrinsics.areEqual((Object)object, (Object)object2);
    }

    public static final Throwable exceptionOrNull_impl(Object object) {
        object = object instanceof Failure ? ((Failure)object).exception : null;
        return object;
    }

    private static final T getOrNull_impl(Object object) {
        Object object2 = object;
        if (!Result.isFailure_impl(object)) return object2;
        object2 = null;
        return object2;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public static int hashCode_impl(Object object) {
        int n = object != null ? object.hashCode() : 0;
        return n;
    }

    public static final boolean isFailure_impl(Object object) {
        return object instanceof Failure;
    }

    public static final boolean isSuccess_impl(Object object) {
        return object instanceof Failure ^ true;
    }

    public static String toString_impl(Object object) {
        if (object instanceof Failure) {
            object = object.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Success(");
            stringBuilder.append(object);
            stringBuilder.append(')');
            object = stringBuilder.toString();
        }
        return object;
    }

    public boolean equals(Object object) {
        return Result.equals_impl(this.value, object);
    }

    public int hashCode() {
        return Result.hashCode_impl(this.value);
    }

    public String toString() {
        return Result.toString_impl(this.value);
    }

    public final /* synthetic */ Object unbox_impl() {
        return this.value;
    }
}
