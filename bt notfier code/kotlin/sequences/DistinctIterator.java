/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractIterator
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0014R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00028\u00010\nj\b\u0012\u0004\u0012\u00028\u0001`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lkotlin/sequences/DistinctIterator;", "T", "K", "Lkotlin/collections/AbstractIterator;", "source", "", "keySelector", "Lkotlin/Function1;", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "observed", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "computeNext", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class DistinctIterator<T, K>
extends AbstractIterator<T> {
    private final Function1<T, K> keySelector;
    private final HashSet<K> observed;
    private final Iterator<T> source;

    public DistinctIterator(Iterator<? extends T> iterator, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iterator, (String)"source");
        Intrinsics.checkNotNullParameter(function1, (String)"keySelector");
        this.source = iterator;
        this.keySelector = function1;
        this.observed = new HashSet();
    }

    protected void computeNext() {
        T t;
        Object object;
        do {
            if (this.source.hasNext()) continue;
            this.done();
            return;
        } while (!this.observed.add(object = this.keySelector.invoke(t = this.source.next())));
        this.setNext(t);
    }
}
