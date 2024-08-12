/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result$Failure
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.SafeContinuation$Companion
 *  kotlin.coroutines.intrinsics.CoroutineSingletons
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001a*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001aB\u0015\b\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0001J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2={"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class SafeContinuation<T>
implements Continuation<T>,
CoroutineStackFrame {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    private final Continuation<T> delegate;
    private volatile Object result;

    public SafeContinuation(Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, (String)"delegate");
        this(continuation, CoroutineSingletons.UNDECIDED);
    }

    public SafeContinuation(Continuation<? super T> continuation, Object object) {
        Intrinsics.checkNotNullParameter(continuation, (String)"delegate");
        this.delegate = continuation;
        this.result = object;
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation;
        Continuation<T> continuation2 = continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) return (CoroutineStackFrame)continuation2;
        continuation2 = null;
        return (CoroutineStackFrame)continuation2;
    }

    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    public final Object getOrThrow() {
        Object object;
        Object object2 = object = this.result;
        if (object == CoroutineSingletons.UNDECIDED) {
            if (RESULT.compareAndSet(this, CoroutineSingletons.UNDECIDED, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            object2 = this.result;
        }
        if (object2 == CoroutineSingletons.RESUMED) {
            object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        } else if (object2 instanceof Result.Failure) throw ((Result.Failure)object2).exception;
        return object2;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public void resumeWith(Object object) {
        while (true) {
            Object object2;
            if ((object2 = this.result) == CoroutineSingletons.UNDECIDED) {
                if (!RESULT.compareAndSet(this, CoroutineSingletons.UNDECIDED, object)) continue;
                return;
            }
            if (object2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                object = new IllegalStateException("Already resumed");
                throw object;
            }
            if (RESULT.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), CoroutineSingletons.RESUMED)) break;
        }
        this.delegate.resumeWith(object);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SafeContinuation for ");
        stringBuilder.append(this.delegate);
        return stringBuilder.toString();
    }
}
