/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UInt
 *  kotlin.UnsignedKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.ranges.ClosedRange
 *  kotlin.ranges.UIntProgression
 *  kotlin.ranges.UIntRange$Companion
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.UIntRange;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0018"}, d2={"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "start", "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive-pVg5ArA", "()I", "getStart-pVg5ArA", "contains", "", "value", "contains-WZ4Q5Ns", "(I)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class UIntRange
extends UIntProgression
implements ClosedRange<UInt> {
    public static final Companion Companion = new Companion(null);
    private static final UIntRange EMPTY = new UIntRange(-1, 0);

    private UIntRange(int n, int n2) {
        super(n, n2, 1, null);
    }

    public /* synthetic */ UIntRange(int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        this(n, n2);
    }

    public static final /* synthetic */ UIntRange access$getEMPTY$cp() {
        return EMPTY;
    }

    public boolean contains_WZ4Q5Ns(int n) {
        boolean bl = UnsignedKt.uintCompare((int)this.getFirst_pVg5ArA(), (int)n) <= 0 && UnsignedKt.uintCompare((int)n, (int)this.getLast_pVg5ArA()) <= 0;
        return bl;
    }

    public boolean equals(Object object) {
        int n;
        boolean bl = object instanceof UIntRange && (this.isEmpty() && ((UIntRange)((Object)object)).isEmpty() || (n = this.getFirst_pVg5ArA()) == (object = (UIntRange)((Object)object)).getFirst_pVg5ArA() && this.getLast_pVg5ArA() == object.getLast_pVg5ArA());
        return bl;
    }

    public int getEndInclusive_pVg5ArA() {
        return this.getLast_pVg5ArA();
    }

    public int getStart_pVg5ArA() {
        return this.getFirst_pVg5ArA();
    }

    public int hashCode() {
        int n = this.isEmpty() ? -1 : this.getFirst_pVg5ArA() * 31 + this.getLast_pVg5ArA();
        return n;
    }

    public boolean isEmpty() {
        boolean bl = UnsignedKt.uintCompare((int)this.getFirst_pVg5ArA(), (int)this.getLast_pVg5ArA()) > 0;
        return bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(UInt.toString_impl((int)this.getFirst_pVg5ArA()));
        stringBuilder.append("..");
        stringBuilder.append(UInt.toString_impl((int)this.getLast_pVg5ArA()));
        return stringBuilder.toString();
    }
}
