/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.IntIterator
 *  kotlin.internal.ProgressionUtilKt
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.ranges.IntProgression$Companion
 *  kotlin.ranges.IntProgressionIterator
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntProgressionIterator;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2={"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public class IntProgression
implements Iterable<Integer>,
KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final int first;
    private final int last;
    private final int step;

    public IntProgression(int n, int n2, int n3) {
        if (n3 == 0) throw (Throwable)new IllegalArgumentException("Step must be non-zero.");
        if (n3 == Integer.MIN_VALUE) throw (Throwable)new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        this.first = n;
        this.last = ProgressionUtilKt.getProgressionLastElement((int)n, (int)n2, (int)n3);
        this.step = n3;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean equals(Object object) {
        if (!(object instanceof IntProgression)) return false;
        if (this.isEmpty()) {
            if (((IntProgression)object).isEmpty()) return true;
        }
        int n = this.first;
        object = (IntProgression)object;
        if (n != ((IntProgression)object).first) return false;
        if (this.last != ((IntProgression)object).last) return false;
        if (this.step != ((IntProgression)object).step) return false;
        return true;
    }

    public final int getFirst() {
        return this.first;
    }

    public final int getLast() {
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
        if (n > 0 ? this.first > this.last : this.first < this.last) return bl;
        bl = false;
        return bl;
    }

    public IntIterator iterator() {
        return (IntIterator)new IntProgressionIterator(this.first, this.last, this.step);
    }

    public String toString() {
        int n;
        StringBuilder stringBuilder;
        if (this.step > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.first);
            stringBuilder.append("..");
            stringBuilder.append(this.last);
            stringBuilder.append(" step ");
            n = this.step;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.first);
            stringBuilder.append(" downTo ");
            stringBuilder.append(this.last);
            stringBuilder.append(" step ");
            n = -this.step;
        }
        stringBuilder.append(n);
        return stringBuilder.toString();
    }
}
