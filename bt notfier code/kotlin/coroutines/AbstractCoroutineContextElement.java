/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Element$DefaultImpls
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class AbstractCoroutineContextElement
implements CoroutineContext.Element {
    private final CoroutineContext.Key<?> key;

    public AbstractCoroutineContextElement(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        this.key = key;
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, (String)"operation");
        return (R)CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)this, r, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        return (E)CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)this, key);
    }

    public CoroutineContext.Key<?> getKey() {
        return this.key;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter((Object)coroutineContext, (String)"context");
        return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)this, (CoroutineContext)coroutineContext);
    }
}
