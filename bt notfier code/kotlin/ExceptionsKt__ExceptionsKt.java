/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.internal.PlatformImplementationsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\r\u0010\u0010\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0007\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F\u00a2\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t*\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2={"stackTrace", "", "Ljava/lang/StackTraceElement;", "", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "suppressedExceptions", "", "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "addSuppressed", "", "exception", "printStackTrace", "stream", "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "stackTraceToString", "", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/ExceptionsKt")
class ExceptionsKt__ExceptionsKt {
    public static final void addSuppressed(Throwable throwable, Throwable throwable2) {
        Intrinsics.checkNotNullParameter((Object)throwable, (String)"$this$addSuppressed");
        Intrinsics.checkNotNullParameter((Object)throwable2, (String)"exception");
        if (throwable == throwable2) return;
        PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(throwable, throwable2);
    }

    public static final StackTraceElement[] getStackTrace(Throwable stackTraceElementArray) {
        Intrinsics.checkNotNullParameter((Object)stackTraceElementArray, (String)"$this$stackTrace");
        stackTraceElementArray = stackTraceElementArray.getStackTrace();
        Intrinsics.checkNotNull((Object)stackTraceElementArray);
        return stackTraceElementArray;
    }

    public static /* synthetic */ void getStackTrace$annotations(Throwable throwable) {
    }

    public static final List<Throwable> getSuppressedExceptions(Throwable throwable) {
        Intrinsics.checkNotNullParameter((Object)throwable, (String)"$this$suppressedExceptions");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(throwable);
    }

    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable throwable) {
    }

    private static final void printStackTrace(Throwable throwable) {
        if (throwable == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.Throwable");
        throwable.printStackTrace();
    }

    private static final void printStackTrace(Throwable throwable, PrintStream printStream) {
        if (throwable == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.Throwable");
        throwable.printStackTrace(printStream);
    }

    private static final void printStackTrace(Throwable throwable, PrintWriter printWriter) {
        if (throwable == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.Throwable");
        throwable.printStackTrace(printWriter);
    }

    public static final String stackTraceToString(Throwable object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$stackTraceToString");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ((Throwable)object).printStackTrace(printWriter);
        printWriter.flush();
        object = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"sw.toString()");
        return object;
    }
}
