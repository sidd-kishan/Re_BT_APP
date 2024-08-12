/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UInt
 *  kotlin.UnsignedKt
 *  kotlin.internal.UProgressionUtilKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.ranges.UIntProgression$Companion
 *  kotlin.ranges.UIntProgressionIterator
 */
package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.UIntProgressionIterator;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0086\u0002\u00f8\u0001\u0000J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0019\u0010\b\u001a\u00020\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u001a"}, d2={"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-pVg5ArA", "()I", "I", "last", "getLast-pVg5ArA", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public class UIntProgression
implements Iterable<UInt>,
KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final int first;
    private final int last;
    private final int step;

    private UIntProgression(int n, int n2, int n3) {
        if (n3 == 0) throw (Throwable)new IllegalArgumentException("Step must be non-zero.");
        if (n3 == Integer.MIN_VALUE) throw (Throwable)new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        this.first = n;
        this.last = UProgressionUtilKt.getProgressionLastElement_Nkh28Cs((int)n, (int)n2, (int)n3);
        this.step = n3;
    }

    public /* synthetic */ UIntProgression(int n, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        this(n, n2, n3);
    }

    /*
     * Enabled force condition propagation
     */
    public boolean equals(Object object) {
        if (!(object instanceof UIntProgression)) return false;
        if (this.isEmpty()) {
            if (((UIntProgression)object).isEmpty()) return true;
        }
        int n = this.first;
        object = (UIntProgression)object;
        if (n != ((UIntProgression)object).first) return false;
        if (this.last != ((UIntProgression)object).last) return false;
        if (this.step != ((UIntProgression)object).step) return false;
        return true;
    }

    public final int getFirst_pVg5ArA() {
        return this.first;
    }

    public final int getLast_pVg5ArA() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    public int hashCode() {
        int n = this.isEmpty() ? -1 : (this.first * 31 + this.last) * 31 + this.step;
        return n;
    }

    public boolean isEmpty() {
        int n = this.step;
        boolean bl = true;
        if (n > 0 ? UnsignedKt.uintCompare((int)this.first, (int)this.last) > 0 : UnsignedKt.uintCompare((int)this.first, (int)this.last) < 0) return bl;
        bl = false;
        return bl;
    }

    @Override
    public final Iterator<UInt> iterator() {
        return (Iterator)new UIntProgressionIterator(this.first, this.last, this.step, null);
    }

    public String toString() {
        int n;
        StringBuilder stringBuilder;
        if (this.step > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(UInt.toString_impl((int)this.first));
            stringBuilder.append("..");
            stringBuilder.append(UInt.toString_impl((int)this.last));
            stringBuilder.append(" step ");
            n = this.step;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(UInt.toString_impl((int)this.first));
            stringBuilder.append(" downTo ");
            stringBuilder.append(UInt.toString_impl((int)this.last));
            stringBuilder.append(" step ");
            n = -this.step;
        }
        stringBuilder.append(n);
        return stringBuilder.toString();
    }
}
