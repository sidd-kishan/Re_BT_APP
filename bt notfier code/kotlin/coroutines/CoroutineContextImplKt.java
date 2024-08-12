/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.AbstractCoroutineContextKey
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0007\u00a2\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007\u00a8\u0006\b"}, d2={"getPolymorphicElement", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class CoroutineContextImplKt {
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(CoroutineContext.Element element, CoroutineContext.Key<E> element2) {
        Intrinsics.checkNotNullParameter((Object)element, (String)"$this$getPolymorphicElement");
        Intrinsics.checkNotNullParameter(element2, (String)"key");
        boolean bl = element2 instanceof AbstractCoroutineContextKey;
        Object var3_3 = null;
        if (bl) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey)element2;
            element2 = var3_3;
            if (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(element.getKey())) return (E)element2;
            element2 = abstractCoroutineContextKey.tryCast$kotlin_stdlib(element);
            if (element2 instanceof CoroutineContext.Element) return (E)element2;
            element2 = var3_3;
            return (E)element2;
        }
        if (element.getKey() == element2) return (E)element;
        element = null;
        return (E)element;
    }

    public static final CoroutineContext minusPolymorphicKey(CoroutineContext.Element element, CoroutineContext.Key<?> element2) {
        Intrinsics.checkNotNullParameter((Object)element, (String)"$this$minusPolymorphicKey");
        Intrinsics.checkNotNullParameter(element2, (String)"key");
        if (element2 instanceof AbstractCoroutineContextKey) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey)element2;
            element2 = element;
            if (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(element.getKey())) return (CoroutineContext)element2;
            element2 = element;
            if (abstractCoroutineContextKey.tryCast$kotlin_stdlib(element) == null) return (CoroutineContext)element2;
            element2 = EmptyCoroutineContext.INSTANCE;
            return (CoroutineContext)element2;
        }
        CoroutineContext.Element element3 = element;
        if (element.getKey() != element2) return (CoroutineContext)element3;
        element3 = EmptyCoroutineContext.INSTANCE;
        return (CoroutineContext)element3;
    }
}
