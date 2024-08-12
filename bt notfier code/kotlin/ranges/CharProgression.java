/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CharIterator
 *  kotlin.internal.ProgressionUtilKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.ranges.CharProgression$Companion
 *  kotlin.ranges.CharProgressionIterator
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.CharProgression;
import kotlin.ranges.CharProgressionIterator;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\b\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2={"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "step", "", "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/CharIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public class CharProgression
implements Iterable<Character>,
KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final char first;
    private final char last;
    private final int step;

    public CharProgression(char c, char c2, int n) {
        if (n == 0) throw (Throwable)new IllegalArgumentException("Step must be non-zero.");
        if (n == Integer.MIN_VALUE) throw (Throwable)new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        this.first = c;
        this.last = (char)ProgressionUtilKt.getProgressionLastElement((int)c, (int)c2, (int)n);
        this.step = n;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean equals(Object object) {
        if (!(object instanceof CharProgression)) return false;
        if (this.isEmpty()) {
            if (((CharProgression)object).isEmpty()) return true;
        }
        char c = this.first;
        object = (CharProgression)object;
        if (c != ((CharProgression)object).first) return false;
        if (this.last != ((CharProgression)object).last) return false;
        if (this.step != ((CharProgression)object).step) return false;
        return true;
    }

    public final char getFirst() {
        return this.first;
    }

    public final char getLast() {
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
        if (n > 0 ? Intrinsics.compare((int)this.first, (int)this.last) > 0 : Intrinsics.compare((int)this.first, (int)this.last) < 0) return bl;
        bl = false;
        return bl;
    }

    public CharIterator iterator() {
        return (CharIterator)new CharProgressionIterator(this.first, this.last, this.step);
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
