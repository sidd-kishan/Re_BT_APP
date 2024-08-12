/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.sequences.GeneratorSequence
 */
package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.GeneratorSequence;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0002J\u000e\u0010\u0012\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2={"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class GeneratorSequence.iterator.1
implements Iterator<T>,
KMappedMarker {
    private T nextItem;
    private int nextState;
    final GeneratorSequence this$0;

    GeneratorSequence.iterator.1(GeneratorSequence generatorSequence) {
        this.this$0 = generatorSequence;
        this.nextState = -2;
    }

    private final void calcNext() {
        Object object;
        if (this.nextState == -2) {
            object = GeneratorSequence.access$getGetInitialValue$p((GeneratorSequence)this.this$0).invoke();
        } else {
            object = GeneratorSequence.access$getGetNextValue$p((GeneratorSequence)this.this$0);
            Object t = this.nextItem;
            Intrinsics.checkNotNull(t);
            object = object.invoke(t);
        }
        this.nextItem = object;
        int n = object == null ? 0 : 1;
        this.nextState = n;
    }

    public final T getNextItem() {
        return this.nextItem;
    }

    public final int getNextState() {
        return this.nextState;
    }

    @Override
    public boolean hasNext() {
        if (this.nextState < 0) {
            this.calcNext();
        }
        int n = this.nextState;
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    @Override
    public T next() {
        if (this.nextState < 0) {
            this.calcNext();
        }
        if (this.nextState == 0) throw (Throwable)new NoSuchElementException();
        Object t = this.nextItem;
        if (t == null) throw new NullPointerException("null cannot be cast to non-null type T");
        this.nextState = -1;
        return t;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNextItem(T t) {
        this.nextItem = t;
    }

    public final void setNextState(int n) {
        this.nextState = n;
    }
}
