/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.RestrictedContinuationImpl
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t\u00b8\u0006\u0000"}, d2={"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$.inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.1
extends RestrictedContinuationImpl {
    final Continuation $completion;
    final Function1 $this_createCoroutineUnintercepted$inlined;
    private int label;

    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$.inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.1(Continuation continuation, Continuation continuation2, Function1 function1) {
        this.$completion = continuation;
        this.$this_createCoroutineUnintercepted$inlined = function1;
        super(continuation2);
    }

    protected Object invokeSuspend(Object object) {
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw (Throwable)new IllegalStateException("This coroutine had already completed".toString());
            this.label = 2;
            ResultKt.throwOnFailure((Object)object);
        } else {
            this.label = 1;
            ResultKt.throwOnFailure((Object)object);
            Continuation continuation = (Continuation)this;
            object = this.$this_createCoroutineUnintercepted$inlined;
            if (object == null) throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            object = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)object, (int)1)).invoke((Object)continuation);
        }
        return object;
    }
}
