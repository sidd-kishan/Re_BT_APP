/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt$WhenMappings
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.SafePublicationLazyImpl
 *  kotlin.SynchronizedLazyImpl
 *  kotlin.UnsafeLazyImpl
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SafePublicationLazyImpl;
import kotlin.SynchronizedLazyImpl;
import kotlin.UnsafeLazyImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u00a8\u0006\t"}, d2={"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/LazyKt")
class LazyKt__LazyJVMKt {
    public static final <T> Lazy<T> lazy(Object object, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, (String)"initializer");
        return (Lazy)new SynchronizedLazyImpl(function0, object);
    }

    public static final <T> Lazy<T> lazy(LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter((Object)lazyThreadSafetyMode, (String)"mode");
        Intrinsics.checkNotNullParameter(function0, (String)"initializer");
        int n = LazyKt.WhenMappings.$EnumSwitchMapping$0[lazyThreadSafetyMode.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) throw new NoWhenBranchMatchedException();
                lazyThreadSafetyMode = (Lazy)new UnsafeLazyImpl(function0);
            } else {
                lazyThreadSafetyMode = (Lazy)new SafePublicationLazyImpl(function0);
            }
        } else {
            lazyThreadSafetyMode = (Lazy)new SynchronizedLazyImpl(function0, null, 2, null);
        }
        return lazyThreadSafetyMode;
    }

    public static final <T> Lazy<T> lazy(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, (String)"initializer");
        return (Lazy)new SynchronizedLazyImpl(function0, null, 2, null);
    }
}
