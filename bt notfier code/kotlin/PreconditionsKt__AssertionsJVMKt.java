/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin._Assertions
 *  kotlin.jvm.functions.Function0
 */
package kotlin;

import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.jvm.functions.Function0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0007"}, d2={"assert", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/PreconditionsKt")
class PreconditionsKt__AssertionsJVMKt {
    private static final void assert(boolean bl) {
        if (!_Assertions.ENABLED) return;
        if (!bl) throw (Throwable)((Object)new AssertionError((Object)"Assertion failed"));
    }

    private static final void assert(boolean bl, Function0<? extends Object> function0) {
        if (!_Assertions.ENABLED) return;
        if (!bl) throw (Throwable)((Object)new AssertionError(function0.invoke()));
    }
}
