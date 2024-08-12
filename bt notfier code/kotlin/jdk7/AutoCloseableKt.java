/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlin.jdk7;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

@Metadata(d1={"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001aH\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u000b"}, d2={"closeFinally", "", "Ljava/lang/AutoCloseable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k=2, mv={1, 5, 1}, pn="kotlin")
public final class AutoCloseableKt {
    public static final void closeFinally(AutoCloseable autoCloseable, Throwable throwable) {
        if (autoCloseable == null) return;
        if (throwable == null) {
            autoCloseable.close();
        } else {
            try {
                autoCloseable.close();
            }
            catch (Throwable throwable2) {
                ExceptionsKt.addSuppressed((Throwable)throwable, (Throwable)throwable2);
            }
        }
    }

    private static final <T extends AutoCloseable, R> R use(T t, Function1<? super T, ? extends R> object) {
        Throwable throwable = null;
        try {
            object = object.invoke(t);
        }
        catch (Throwable throwable2) {
            try {
                throw throwable2;
            }
            catch (Throwable throwable3) {
                InlineMarker.finallyStart((int)1);
                AutoCloseableKt.closeFinally(t, throwable2);
                InlineMarker.finallyEnd((int)1);
                throw throwable3;
            }
        }
        InlineMarker.finallyStart((int)1);
        AutoCloseableKt.closeFinally(t, throwable);
        InlineMarker.finallyEnd((int)1);
        return (R)object;
    }
}
