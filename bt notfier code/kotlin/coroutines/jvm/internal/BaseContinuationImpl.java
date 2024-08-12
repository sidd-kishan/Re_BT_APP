/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.coroutines.jvm.internal.DebugMetadataKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadataKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0006J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H$\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014J\u001e\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2={"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class BaseContinuationImpl
implements Continuation<Object>,
CoroutineStackFrame,
Serializable {
    private final Continuation<Object> completion;

    public BaseContinuationImpl(Continuation<Object> continuation) {
        this.completion = continuation;
    }

    public Continuation<Unit> create(Object object, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, (String)"completion");
        throw (Throwable)new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, (String)"completion");
        throw (Throwable)new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> continuation;
        Continuation<Object> continuation2 = continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) return (CoroutineStackFrame)continuation2;
        continuation2 = null;
        return (CoroutineStackFrame)continuation2;
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return DebugMetadataKt.getStackTraceElement((BaseContinuationImpl)this);
    }

    protected abstract Object invokeSuspend(Object var1);

    protected void releaseIntercepted() {
    }

    public final void resumeWith(Object object) {
        BaseContinuationImpl baseContinuationImpl = this;
        while (true) {
            Result.Companion companion;
            DebugProbesKt.probeCoroutineResumed((Continuation)baseContinuationImpl);
            Continuation<Object> continuation = baseContinuationImpl.completion;
            Intrinsics.checkNotNull(continuation);
            try {
                object = baseContinuationImpl.invokeSuspend(object);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return;
                }
                companion = Result.Companion;
                object = Result.constructor_impl((Object)object);
            }
            catch (Throwable throwable) {
                companion = Result.Companion;
                object = Result.constructor_impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            baseContinuationImpl.releaseIntercepted();
            if (!(continuation instanceof BaseContinuationImpl)) {
                continuation.resumeWith(object);
                return;
            }
            baseContinuationImpl = (BaseContinuationImpl)continuation;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Continuation at ");
        Object object = this.getStackTraceElement();
        if (object == null) {
            object = this.getClass().getName();
        }
        stringBuilder.append((Serializable)object);
        return stringBuilder.toString();
    }
}
