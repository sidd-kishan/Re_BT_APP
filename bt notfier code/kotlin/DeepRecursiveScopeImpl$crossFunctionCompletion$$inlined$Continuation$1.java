/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.DeepRecursiveScopeImpl
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function3
 */
package kotlin;

import kotlin.DeepRecursiveScopeImpl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b\u00b8\u0006\u0000"}, d2={"kotlin/coroutines/ContinuationKt$Continuation$1", "Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class DeepRecursiveScopeImpl$crossFunctionCompletion$.inlined.Continuation.1
implements Continuation<Object> {
    final Continuation $cont$inlined;
    final CoroutineContext $context;
    final Function3 $currentFunction$inlined;
    final DeepRecursiveScopeImpl this$0;

    public DeepRecursiveScopeImpl$crossFunctionCompletion$.inlined.Continuation.1(CoroutineContext coroutineContext, DeepRecursiveScopeImpl deepRecursiveScopeImpl, Function3 function3, Continuation continuation) {
        this.$context = coroutineContext;
        this.this$0 = deepRecursiveScopeImpl;
        this.$currentFunction$inlined = function3;
        this.$cont$inlined = continuation;
    }

    public CoroutineContext getContext() {
        return this.$context;
    }

    public void resumeWith(Object object) {
        DeepRecursiveScopeImpl.access$setFunction$p((DeepRecursiveScopeImpl)this.this$0, (Function3)this.$currentFunction$inlined);
        DeepRecursiveScopeImpl.access$setCont$p((DeepRecursiveScopeImpl)this.this$0, (Continuation)this.$cont$inlined);
        DeepRecursiveScopeImpl.access$setResult$p((DeepRecursiveScopeImpl)this.this$0, (Object)object);
    }
}
