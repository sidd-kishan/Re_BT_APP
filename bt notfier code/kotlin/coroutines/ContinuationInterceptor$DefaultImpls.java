/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.AbstractCoroutineContextKey
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Element$DefaultImpls
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k=3, mv={1, 5, 1})
public static final class ContinuationInterceptor.DefaultImpls {
    public static <R> R fold(ContinuationInterceptor continuationInterceptor, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, (String)"operation");
        return (R)CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)((CoroutineContext.Element)continuationInterceptor), r, function2);
    }

    public static <E extends CoroutineContext.Element> E get(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<E> abstractCoroutineContextKey) {
        Intrinsics.checkNotNullParameter(abstractCoroutineContextKey, (String)"key");
        boolean bl = abstractCoroutineContextKey instanceof AbstractCoroutineContextKey;
        AbstractCoroutineContextKey abstractCoroutineContextKey2 = null;
        AbstractCoroutineContextKey abstractCoroutineContextKey3 = null;
        if (bl) {
            abstractCoroutineContextKey2 = abstractCoroutineContextKey;
            abstractCoroutineContextKey = abstractCoroutineContextKey3;
            if (!abstractCoroutineContextKey2.isSubKey$kotlin_stdlib(continuationInterceptor.getKey())) return (E)abstractCoroutineContextKey;
            abstractCoroutineContextKey = abstractCoroutineContextKey2.tryCast$kotlin_stdlib((CoroutineContext.Element)continuationInterceptor);
            if (abstractCoroutineContextKey instanceof CoroutineContext.Element) return (E)abstractCoroutineContextKey;
            abstractCoroutineContextKey = abstractCoroutineContextKey3;
            return (E)abstractCoroutineContextKey;
        }
        abstractCoroutineContextKey3 = abstractCoroutineContextKey2;
        if (ContinuationInterceptor.Key != abstractCoroutineContextKey) return (E)abstractCoroutineContextKey3;
        if (continuationInterceptor == null) throw new NullPointerException("null cannot be cast to non-null type E");
        abstractCoroutineContextKey3 = (CoroutineContext.Element)continuationInterceptor;
        return (E)abstractCoroutineContextKey3;
    }

    public static CoroutineContext minusKey(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<?> continuationInterceptor2) {
        Intrinsics.checkNotNullParameter(continuationInterceptor2, (String)"key");
        if (continuationInterceptor2 instanceof AbstractCoroutineContextKey) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey)continuationInterceptor2;
            continuationInterceptor2 = continuationInterceptor;
            if (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(continuationInterceptor.getKey())) return (CoroutineContext)continuationInterceptor2;
            continuationInterceptor2 = continuationInterceptor;
            if (abstractCoroutineContextKey.tryCast$kotlin_stdlib((CoroutineContext.Element)continuationInterceptor) == null) return (CoroutineContext)continuationInterceptor2;
            continuationInterceptor2 = EmptyCoroutineContext.INSTANCE;
            return (CoroutineContext)continuationInterceptor2;
        }
        if (ContinuationInterceptor.Key != continuationInterceptor2) return (CoroutineContext)continuationInterceptor;
        continuationInterceptor = EmptyCoroutineContext.INSTANCE;
        return (CoroutineContext)continuationInterceptor;
    }

    public static CoroutineContext plus(ContinuationInterceptor continuationInterceptor, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter((Object)coroutineContext, (String)"context");
        return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)((CoroutineContext.Element)continuationInterceptor), (CoroutineContext)coroutineContext);
    }

    public static void releaseInterceptedContinuation(ContinuationInterceptor continuationInterceptor, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, (String)"continuation");
    }
}
