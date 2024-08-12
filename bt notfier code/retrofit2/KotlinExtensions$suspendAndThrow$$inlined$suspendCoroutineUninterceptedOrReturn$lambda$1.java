/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 */
package retrofit2;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(bv={1, 0, 3}, d1={"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2={"<anonymous>", "", "run", "retrofit2/KotlinExtensions$suspendAndThrow$2$1"}, k=3, mv={1, 1, 15})
static final class KotlinExtensions$suspendAndThrow$.inlined.suspendCoroutineUninterceptedOrReturn.lambda.1
implements Runnable {
    final Continuation $continuation;
    final Exception $this_suspendAndThrow$inlined;

    KotlinExtensions$suspendAndThrow$.inlined.suspendCoroutineUninterceptedOrReturn.lambda.1(Continuation continuation, Exception exception) {
        this.$continuation = continuation;
        this.$this_suspendAndThrow$inlined = exception;
    }

    @Override
    public final void run() {
        Continuation continuation = IntrinsicsKt.intercepted((Continuation)this.$continuation);
        Throwable throwable = this.$this_suspendAndThrow$inlined;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.constructor_impl((Object)ResultKt.createFailure((Throwable)throwable)));
    }
}
