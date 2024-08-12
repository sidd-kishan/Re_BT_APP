/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.jvm.internal.BaseContinuationImpl
 *  kotlin.coroutines.jvm.internal.CompletedContinuation
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.CompletedContinuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005B!\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class ContinuationImpl
extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient Continuation<Object> intercepted;

    public ContinuationImpl(Continuation<Object> continuation) {
        CoroutineContext coroutineContext = continuation != null ? continuation.getContext() : null;
        this(continuation, coroutineContext);
    }

    public ContinuationImpl(Continuation<Object> continuation, CoroutineContext coroutineContext) {
        super(continuation);
        this._context = coroutineContext;
    }

    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        Intrinsics.checkNotNull((Object)coroutineContext);
        return coroutineContext;
    }

    public final Continuation<Object> intercepted() {
        ContinuationInterceptor continuationInterceptor = this.intercepted;
        if (continuationInterceptor != null) return continuationInterceptor;
        continuationInterceptor = (ContinuationInterceptor)this.getContext().get((CoroutineContext.Key)ContinuationInterceptor.Key);
        if (continuationInterceptor == null || (continuationInterceptor = continuationInterceptor.interceptContinuation((Continuation)this)) == null) {
            continuationInterceptor = (Continuation)this;
        }
        this.intercepted = continuationInterceptor;
        return continuationInterceptor;
    }

    protected void releaseIntercepted() {
        Continuation<Object> continuation = this.intercepted;
        if (continuation != null && continuation != this) {
            CoroutineContext.Element element = this.getContext().get((CoroutineContext.Key)ContinuationInterceptor.Key);
            Intrinsics.checkNotNull((Object)element);
            ((ContinuationInterceptor)element).releaseInterceptedContinuation(continuation);
        }
        this.intercepted = (Continuation)CompletedContinuation.INSTANCE;
    }
}
