/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ranges.ClosedRange
 *  kotlin.ranges.IntProgression
 *  kotlin.ranges.IntRange$Companion
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0015"}, d2={"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class IntRange
extends IntProgression
implements ClosedRange<Integer> {
    public static final Companion Companion = new Companion(null);
    private static final IntRange EMPTY = new IntRange(1, 0);

    public IntRange(int n, int n2) {
        super(n, n2, 1);
    }

    public static final /* synthetic */ IntRange access$getEMPTY$cp() {
        return EMPTY;
    }

    public boolean contains(int n) {
        boolean bl = this.getFirst() <= n && n <= this.getLast();
        return bl;
    }

    public boolean equals(Object object) {
        int n;
        boolean bl = object instanceof IntRange && (this.isEmpty() && ((IntRange)((Object)object)).isEmpty() || (n = this.getFirst()) == (object = (IntRange)((Object)object)).getFirst() && this.getLast() == object.getLast());
        return bl;
    }

    public Integer getEndInclusive() {
        return this.getLast();
    }

    public Integer getStart() {
        return this.getFirst();
    }

    public int hashCode() {
        int n = this.isEmpty() ? -1 : this.getFirst() * 31 + this.getLast();
        return n;
    }

    public boolean isEmpty() {
        boolean bl = this.getFirst() > this.getLast();
        return bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getFirst());
        stringBuilder.append("..");
        stringBuilder.append(this.getLast());
        return stringBuilder.toString();
    }
}
