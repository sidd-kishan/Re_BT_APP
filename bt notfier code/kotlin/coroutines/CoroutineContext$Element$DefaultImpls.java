/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$DefaultImpls
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(k=3, mv={1, 5, 1})
public static final class CoroutineContext.Element.DefaultImpls {
    public static <R> R fold(CoroutineContext.Element element, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, (String)"operation");
        return (R)function2.invoke(r, (Object)element);
    }

    public static <E extends CoroutineContext.Element> E get(CoroutineContext.Element element, CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        if (Intrinsics.areEqual((Object)element.getKey(), key)) {
            if (element == null) throw new NullPointerException("null cannot be cast to non-null type E");
        } else {
            element = null;
        }
        return (E)element;
    }

    public static CoroutineContext minusKey(CoroutineContext.Element element, CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        CoroutineContext.Element element2 = element;
        if (!Intrinsics.areEqual((Object)element.getKey(), key)) return (CoroutineContext)element2;
        element2 = EmptyCoroutineContext.INSTANCE;
        return (CoroutineContext)element2;
    }

    public static CoroutineContext plus(CoroutineContext.Element element, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter((Object)coroutineContext, (String)"context");
        return CoroutineContext.DefaultImpls.plus((CoroutineContext)((CoroutineContext)element), (CoroutineContext)coroutineContext);
    }
}
