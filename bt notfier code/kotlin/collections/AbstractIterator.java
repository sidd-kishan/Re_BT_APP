/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractIterator$WhenMappings
 *  kotlin.collections.State
 *  kotlin.jvm.internal.markers.KMappedMarker
 */
package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.AbstractIterator;
import kotlin.collections.State;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH$J\b\u0010\n\u001a\u00020\tH\u0004J\t\u0010\u000b\u001a\u00020\fH\u0096\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\fH\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lkotlin/collections/AbstractIterator;", "T", "", "()V", "nextValue", "Ljava/lang/Object;", "state", "Lkotlin/collections/State;", "computeNext", "", "done", "hasNext", "", "next", "()Ljava/lang/Object;", "setNext", "value", "(Ljava/lang/Object;)V", "tryToComputeNext", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class AbstractIterator<T>
implements Iterator<T>,
KMappedMarker {
    private T nextValue;
    private State state = State.NotReady;

    private final boolean tryToComputeNext() {
        this.state = State.Failed;
        this.computeNext();
        boolean bl = this.state == State.Ready;
        return bl;
    }

    protected abstract void computeNext();

    protected final void done() {
        this.state = State.Done;
    }

    @Override
    public boolean hasNext() {
        State state = this.state;
        State state2 = State.Failed;
        boolean bl = false;
        int n = state != state2 ? 1 : 0;
        if (n == 0) throw (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        state2 = this.state;
        n = WhenMappings.$EnumSwitchMapping$0[state2.ordinal()];
        if (n == 1) return bl;
        bl = n != 2 ? this.tryToComputeNext() : true;
        return bl;
    }

    @Override
    public T next() {
        if (!this.hasNext()) throw (Throwable)new NoSuchElementException();
        this.state = State.NotReady;
        return this.nextValue;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected final void setNext(T t) {
        this.nextValue = t;
        this.state = State.Ready;
    }
}
