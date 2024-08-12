/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ranges.ClosedRange
 *  kotlin.ranges.LongProgression
 *  kotlin.ranges.LongRange$Companion
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.LongProgression;
import kotlin.ranges.LongRange;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0016"}, d2={"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(JJ)V", "getEndInclusive", "()Ljava/lang/Long;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class LongRange
extends LongProgression
implements ClosedRange<Long> {
    public static final Companion Companion = new Companion(null);
    private static final LongRange EMPTY = new LongRange(1L, 0L);

    public LongRange(long l, long l2) {
        super(l, l2, 1L);
    }

    public static final /* synthetic */ LongRange access$getEMPTY$cp() {
        return EMPTY;
    }

    public boolean contains(long l) {
        boolean bl = this.getFirst() <= l && l <= this.getLast();
        return bl;
    }

    public boolean equals(Object object) {
        long l;
        boolean bl = object instanceof LongRange && (this.isEmpty() && ((LongRange)((Object)object)).isEmpty() || (l = this.getFirst()) == (object = (LongRange)((Object)object)).getFirst() && this.getLast() == object.getLast());
        return bl;
    }

    public Long getEndInclusive() {
        return this.getLast();
    }

    public Long getStart() {
        return this.getFirst();
    }

    public int hashCode() {
        int n = this.isEmpty() ? -1 : (int)((long)31 * (this.getFirst() ^ this.getFirst() >>> 32) + (this.getLast() ^ this.getLast() >>> 32));
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
