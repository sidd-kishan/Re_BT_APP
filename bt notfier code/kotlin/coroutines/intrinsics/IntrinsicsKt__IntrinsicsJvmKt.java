/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.jvm.internal.BaseContinuationImpl
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0083\b\u00a2\u0006\u0002\b\b\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aA\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001aZ\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001an\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0014\"\u0004\b\u0002\u0010\u0003*)\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0015\u00a2\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0006\u0010\u0016\u001a\u0002H\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0081\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2={"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/coroutines/intrinsics/IntrinsicsKt")
class IntrinsicsKt__IntrinsicsJvmKt {
    private static final <T> Continuation<Unit> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(Continuation<? super T> continuation, Function1<? super Continuation<? super T>, ? extends Object> function1) {
        CoroutineContext coroutineContext = continuation.getContext();
        if (coroutineContext == EmptyCoroutineContext.INSTANCE) {
            if (continuation == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            continuation = (Continuation)new /* Unavailable Anonymous Inner Class!! */;
        } else {
            if (continuation == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            continuation = (Continuation)new /* Unavailable Anonymous Inner Class!! */;
        }
        return continuation;
    }

    public static final <T> Continuation<Unit> createCoroutineUnintercepted(Function1<? super Continuation<? super T>, ? extends Object> continuation, Continuation<? super T> continuation2) {
        Intrinsics.checkNotNullParameter(continuation, (String)"$this$createCoroutineUnintercepted");
        Intrinsics.checkNotNullParameter(continuation2, (String)"completion");
        continuation2 = DebugProbesKt.probeCoroutineCreated(continuation2);
        if (continuation instanceof BaseContinuationImpl) {
            continuation = ((BaseContinuationImpl)continuation).create(continuation2);
        } else {
            CoroutineContext coroutineContext = continuation2.getContext();
            if (coroutineContext == EmptyCoroutineContext.INSTANCE) {
                if (continuation2 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                continuation = (Continuation)new /* Unavailable Anonymous Inner Class!! */;
            } else {
                if (continuation2 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                continuation = (Continuation)new /* Unavailable Anonymous Inner Class!! */;
            }
        }
        return continuation;
    }

    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> continuation, R r, Continuation<? super T> coroutineContext) {
        Intrinsics.checkNotNullParameter(continuation, (String)"$this$createCoroutineUnintercepted");
        Intrinsics.checkNotNullParameter(coroutineContext, (String)"completion");
        Continuation continuation2 = DebugProbesKt.probeCoroutineCreated(coroutineContext);
        if (continuation instanceof BaseContinuationImpl) {
            continuation = ((BaseContinuationImpl)continuation).create(r, continuation2);
        } else {
            coroutineContext = continuation2.getContext();
            if (coroutineContext == EmptyCoroutineContext.INSTANCE) {
                if (continuation2 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                continuation = (Continuation)new /* Unavailable Anonymous Inner Class!! */;
            } else {
                if (continuation2 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                continuation = (Continuation)new /* Unavailable Anonymous Inner Class!! */;
            }
        }
        return continuation;
    }

    public static final <T> Continuation<T> intercepted(Continuation<? super T> continuationImpl) {
        Intrinsics.checkNotNullParameter(continuationImpl, (String)"$this$intercepted");
        ContinuationImpl continuationImpl2 = !(continuationImpl instanceof ContinuationImpl) ? null : continuationImpl;
        ContinuationImpl continuationImpl3 = continuationImpl2;
        continuationImpl2 = continuationImpl;
        if (continuationImpl3 == null) return continuationImpl2;
        continuationImpl3 = continuationImpl3.intercepted();
        continuationImpl2 = continuationImpl;
        if (continuationImpl3 == null) return continuationImpl2;
        continuationImpl2 = continuationImpl3;
        return continuationImpl2;
    }

    private static final <T> Object startCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        if (function1 == null) throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        return ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, (int)1)).invoke(continuation);
    }

    private static final <R, T> Object startCoroutineUninterceptedOrReturn(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        if (function2 == null) throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        return ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, (int)2)).invoke(r, continuation);
    }

    private static final <R, P, T> Object startCoroutineUninterceptedOrReturn(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> function3, R r, P p, Continuation<? super T> continuation) {
        if (function3 == null) throw new NullPointerException("null cannot be cast to non-null type (R, P, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        return ((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, (int)3)).invoke(r, p, continuation);
    }
}
