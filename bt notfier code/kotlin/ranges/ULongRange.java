/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ULong
 *  kotlin.UnsignedKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.ranges.ClosedRange
 *  kotlin.ranges.ULongProgression
 *  kotlin.ranges.ULongRange$Companion
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.ULongProgression;
import kotlin.ranges.ULongRange;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0018"}, d2={"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive-s-VKNKU", "()J", "getStart-s-VKNKU", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class ULongRange
extends ULongProgression
implements ClosedRange<ULong> {
    public static final Companion Companion = new Companion(null);
    private static final ULongRange EMPTY = new ULongRange(-1L, 0L);

    private ULongRange(long l, long l2) {
        super(l, l2, 1L, null);
    }

    public /* synthetic */ ULongRange(long l, long l2, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, l2);
    }

    public static final /* synthetic */ ULongRange access$getEMPTY$cp() {
        return EMPTY;
    }

    public boolean contains_VKZWuLQ(long l) {
        boolean bl = UnsignedKt.ulongCompare((long)this.getFirst_s_VKNKU(), (long)l) <= 0 && UnsignedKt.ulongCompare((long)l, (long)this.getLast_s_VKNKU()) <= 0;
        return bl;
    }

    public boolean equals(Object object) {
        long l;
        boolean bl = object instanceof ULongRange && (this.isEmpty() && ((ULongRange)((Object)object)).isEmpty() || (l = this.getFirst_s_VKNKU()) == (object = (ULongRange)((Object)object)).getFirst_s_VKNKU() && this.getLast_s_VKNKU() == object.getLast_s_VKNKU());
        return bl;
    }

    public long getEndInclusive_s_VKNKU() {
        return this.getLast_s_VKNKU();
    }

    public long getStart_s_VKNKU() {
        return this.getFirst_s_VKNKU();
    }

    public int hashCode() {
        int n;
        if (this.isEmpty()) {
            n = -1;
        } else {
            n = (int)ULong.constructor_impl((long)(this.getFirst_s_VKNKU() ^ ULong.constructor_impl((long)(this.getFirst_s_VKNKU() >>> 32))));
            n = (int)ULong.constructor_impl((long)(this.getLast_s_VKNKU() ^ ULong.constructor_impl((long)(this.getLast_s_VKNKU() >>> 32)))) + n * 31;
        }
        return n;
    }

    public boolean isEmpty() {
        boolean bl = UnsignedKt.ulongCompare((long)this.getFirst_s_VKNKU(), (long)this.getLast_s_VKNKU()) > 0;
        return bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ULong.toString_impl((long)this.getFirst_s_VKNKU()));
        stringBuilder.append("..");
        stringBuilder.append(ULong.toString_impl((long)this.getLast_s_VKNKU()));
        return stringBuilder.toString();
    }
}
