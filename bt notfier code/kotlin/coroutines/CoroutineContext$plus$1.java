/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CombinedContext
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n\u00a2\u0006\u0002\b\u0005"}, d2={"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k=3, mv={1, 5, 1})
static final class CoroutineContext.plus.1
extends Lambda
implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {
    public static final CoroutineContext.plus.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    CoroutineContext.plus.1() {
    }

    public final CoroutineContext invoke(CoroutineContext object, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"acc");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        CoroutineContext coroutineContext = object.minusKey(element.getKey());
        object = coroutineContext == EmptyCoroutineContext.INSTANCE ? (CoroutineContext)element : ((object = (ContinuationInterceptor)coroutineContext.get((CoroutineContext.Key)ContinuationInterceptor.Key)) == null ? new CombinedContext(coroutineContext, element) : ((coroutineContext = coroutineContext.minusKey((CoroutineContext.Key)ContinuationInterceptor.Key)) == EmptyCoroutineContext.INSTANCE ? new CombinedContext((CoroutineContext)element, (CoroutineContext.Element)object) : new CombinedContext((CoroutineContext)new CombinedContext(coroutineContext, element), (CoroutineContext.Element)object)));
        return object;
    }
}
