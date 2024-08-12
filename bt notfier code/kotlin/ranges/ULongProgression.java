/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ULong
 *  kotlin.UnsignedKt
 *  kotlin.internal.UProgressionUtilKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.ranges.ULongProgression$Companion
 *  kotlin.ranges.ULongProgressionIterator
 */
package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.ULongProgression;
import kotlin.ranges.ULongProgressionIterator;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0012\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0086\u0002\u00f8\u0001\u0000J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0019\u0010\b\u001a\u00020\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u001b"}, d2={"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-s-VKNKU", "()J", "J", "last", "getLast-s-VKNKU", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public class ULongProgression
implements Iterable<ULong>,
KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final long first;
    private final long last;
    private final long step;

    private ULongProgression(long l, long l2, long l3) {
        if (l3 == 0L) throw (Throwable)new IllegalArgumentException("Step must be non-zero.");
        if (l3 == Long.MIN_VALUE) throw (Throwable)new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        this.first = l;
        this.last = UProgressionUtilKt.getProgressionLastElement_7ftBX0g((long)l, (long)l2, (long)l3);
        this.step = l3;
    }

    public /* synthetic */ ULongProgression(long l, long l2, long l3, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, l2, l3);
    }

    /*
     * Enabled force condition propagation
     */
    public boolean equals(Object object) {
        if (!(object instanceof ULongProgression)) return false;
        if (this.isEmpty()) {
            if (((ULongProgression)object).isEmpty()) return true;
        }
        long l = this.first;
        object = (ULongProgression)object;
        if (l != ((ULongProgression)object).first) return false;
        if (this.last != ((ULongProgression)object).last) return false;
        if (this.step != ((ULongProgression)object).step) return false;
        return true;
    }

    public final long getFirst_s_VKNKU() {
        return this.first;
    }

    public final long getLast_s_VKNKU() {
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
            long l = this.first;
            n = (int)ULong.constructor_impl((long)(l ^ ULong.constructor_impl((long)(l >>> 32))));
            l = this.last;
            int n2 = (int)ULong.constructor_impl((long)(l ^ ULong.constructor_impl((long)(l >>> 32))));
            l = this.step;
            n = (int)(l ^ l >>> 32) + (n * 31 + n2) * 31;
        }
        return n;
    }

    public boolean isEmpty() {
        long l = this.step;
        boolean bl = true;
        int n = UnsignedKt.ulongCompare((long)this.first, (long)this.last);
        if (l > 0L ? n > 0 : n < 0) return bl;
        bl = false;
        return bl;
    }

    @Override
    public final Iterator<ULong> iterator() {
        return (Iterator)new ULongProgressionIterator(this.first, this.last, this.step, null);
    }

    public String toString() {
        StringBuilder stringBuilder;
        long l = this.step;
        if (l > 0L) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(ULong.toString_impl((long)this.first));
            stringBuilder.append("..");
            stringBuilder.append(ULong.toString_impl((long)this.last));
            stringBuilder.append(" step ");
            l = this.step;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(ULong.toString_impl((long)this.first));
            stringBuilder.append(" downTo ");
            stringBuilder.append(ULong.toString_impl((long)this.last));
            stringBuilder.append(" step ");
            l = -this.step;
        }
        stringBuilder.append(l);
        return stringBuilder.toString();
    }
}
