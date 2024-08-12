/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.LongIterator
 *  kotlin.internal.ProgressionUtilKt
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.ranges.LongProgression$Companion
 *  kotlin.ranges.LongProgressionIterator
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.LongIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.LongProgression;
import kotlin.ranges.LongProgressionIterator;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0019"}, d2={"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public class LongProgression
implements Iterable<Long>,
KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final long first;
    private final long last;
    private final long step;

    public LongProgression(long l, long l2, long l3) {
        if (l3 == 0L) throw (Throwable)new IllegalArgumentException("Step must be non-zero.");
        if (l3 == Long.MIN_VALUE) throw (Throwable)new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        this.first = l;
        this.last = ProgressionUtilKt.getProgressionLastElement((long)l, (long)l2, (long)l3);
        this.step = l3;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean equals(Object object) {
        if (!(object instanceof LongProgression)) return false;
        if (this.isEmpty()) {
            if (((LongProgression)object).isEmpty()) return true;
        }
        long l = this.first;
        object = (LongProgression)object;
        if (l != ((LongProgression)object).first) return false;
        if (this.last != ((LongProgression)object).last) return false;
        if (this.step != ((LongProgression)object).step) return false;
        return true;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getLast() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public int hashCode() {
        int n;
        if (this.isEmpty()) {
            n = -1;
        } else {
            long l = 31;
            long l2 = this.first;
            long l3 = this.last;
            long l4 = this.step;
            n = (int)(l * ((l2 ^ l2 >>> 32) * l + (l3 ^ l3 >>> 32)) + (l4 ^ l4 >>> 32));
        }
        return n;
    }

    public boolean isEmpty() {
        long l = this.step;
        boolean bl = true;
        long l2 = this.first;
        long l3 = this.last;
        if (l > 0L ? l2 > l3 : l2 < l3) return bl;
        bl = false;
        return bl;
    }

    public LongIterator iterator() {
        return (LongIterator)new LongProgressionIterator(this.first, this.last, this.step);
    }

    public String toString() {
        StringBuilder stringBuilder;
        long l = this.step;
        if (l > 0L) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.first);
            stringBuilder.append("..");
            stringBuilder.append(this.last);
            stringBuilder.append(" step ");
            l = this.step;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.first);
            stringBuilder.append(" downTo ");
            stringBuilder.append(this.last);
            stringBuilder.append(" step ");
            l = -this.step;
        }
        stringBuilder.append(l);
        return stringBuilder.toString();
    }
}
