/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UInt
 *  kotlin.UnsignedKt
 *  kotlin.collections.UIntIterator
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u0015\u0010\r\u001a\u00020\u0003H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u0003X\u0082\u000e\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\t\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0010"}, d2={"Lkotlin/ranges/UIntProgressionIterator;", "Lkotlin/collections/UIntIterator;", "first", "Lkotlin/UInt;", "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", "next", "nextUInt", "nextUInt-pVg5ArA", "()I", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class UIntProgressionIterator
extends UIntIterator {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    private UIntProgressionIterator(int n, int n2, int n3) {
        this.finalElement = n2;
        boolean bl = true;
        n2 = UnsignedKt.uintCompare((int)n, (int)n2);
        if (!(n3 > 0 ? n2 <= 0 : n2 >= 0)) {
            bl = false;
        }
        this.hasNext = bl;
        this.step = UInt.constructor_impl((int)n3);
        if (!this.hasNext) {
            n = this.finalElement;
        }
        this.next = n;
    }

    public /* synthetic */ UIntProgressionIterator(int n, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        this(n, n2, n3);
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public int nextUInt_pVg5ArA() {
        int n = this.next;
        if (n == this.finalElement) {
            if (!this.hasNext) throw (Throwable)new NoSuchElementException();
            this.hasNext = false;
        } else {
            this.next = UInt.constructor_impl((int)(this.step + n));
        }
        return n;
    }
}
