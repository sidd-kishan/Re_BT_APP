/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CombinedContext$Serialized
 *  kotlin.coroutines.CombinedContext$toString$1
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$DefaultImpls
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 */
package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016\u00a2\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0002\u00a2\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class CombinedContext
implements CoroutineContext,
Serializable {
    private final CoroutineContext.Element element;
    private final CoroutineContext left;

    public CombinedContext(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter((Object)coroutineContext, (String)"left");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        this.left = coroutineContext;
        this.element = element;
    }

    private final boolean contains(CoroutineContext.Element element) {
        return Intrinsics.areEqual(this.get(element.getKey()), (Object)element);
    }

    private final boolean containsAll(CombinedContext serializable) {
        do {
            if (this.contains(serializable.element)) continue;
            return false;
        } while ((serializable = serializable.left) instanceof CombinedContext);
        if (serializable != null) {
            return this.contains((CoroutineContext.Element)serializable);
        }
        serializable = new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        throw serializable;
    }

    private final int size() {
        CombinedContext combinedContext = this;
        int n = 2;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.left;
            combinedContext = coroutineContext;
            if (!(coroutineContext instanceof CombinedContext)) {
                combinedContext = null;
            }
            if (combinedContext == null) return n;
            ++n;
        }
    }

    private final Object writeReplace() {
        int n = this.size();
        CoroutineContext[] coroutineContextArray = new CoroutineContext[n];
        Ref.IntRef intRef = new Ref.IntRef();
        boolean bl = false;
        intRef.element = 0;
        this.fold(Unit.INSTANCE, (Function2)new /* Unavailable Anonymous Inner Class!! */);
        if (intRef.element == n) {
            bl = true;
        }
        if (!bl) throw (Throwable)new IllegalStateException("Check failed.".toString());
        return new Serialized(coroutineContextArray);
    }

    public boolean equals(Object object) {
        boolean bl = this == object || object instanceof CombinedContext && super.size() == this.size() && super.containsAll(this);
        return bl;
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, (String)"operation");
        return (R)function2.invoke(this.left.fold(r, function2), (Object)this.element);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        CombinedContext combinedContext = this;
        CoroutineContext.Element element;
        while ((element = combinedContext.element.get(key)) == null) {
            combinedContext = combinedContext.left;
            if (!(combinedContext instanceof CombinedContext)) return (E)combinedContext.get(key);
        }
        return (E)element;
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, (String)"key");
        if (this.element.get(coroutineContext) != null) {
            return this.left;
        }
        coroutineContext = (coroutineContext = this.left.minusKey(coroutineContext)) == this.left ? (CoroutineContext)this : (coroutineContext == EmptyCoroutineContext.INSTANCE ? (CoroutineContext)this.element : (CoroutineContext)new CombinedContext(coroutineContext, this.element));
        return coroutineContext;
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter((Object)coroutineContext, (String)"context");
        return CoroutineContext.DefaultImpls.plus((CoroutineContext)this, (CoroutineContext)coroutineContext);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(this.fold("", (Function2)toString.1.INSTANCE));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
