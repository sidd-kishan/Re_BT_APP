/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.CharProgression
 *  kotlin.ranges.CharRange$Companion
 *  kotlin.ranges.ClosedRange
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharProgression;
import kotlin.ranges.CharRange;
import kotlin.ranges.ClosedRange;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0016"}, d2={"Lkotlin/ranges/CharRange;", "Lkotlin/ranges/CharProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(CC)V", "getEndInclusive", "()Ljava/lang/Character;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class CharRange
extends CharProgression
implements ClosedRange<Character> {
    public static final Companion Companion = new Companion(null);
    private static final CharRange EMPTY = new CharRange((char)1, (char)0);

    public CharRange(char c, char c2) {
        super(c, c2, 1);
    }

    public static final /* synthetic */ CharRange access$getEMPTY$cp() {
        return EMPTY;
    }

    public boolean contains(char c) {
        boolean bl = Intrinsics.compare((int)this.getFirst(), (int)c) <= 0 && Intrinsics.compare((int)c, (int)this.getLast()) <= 0;
        return bl;
    }

    public boolean equals(Object object) {
        char c;
        boolean bl = object instanceof CharRange && (this.isEmpty() && ((CharRange)((Object)object)).isEmpty() || (c = this.getFirst()) == (object = (CharRange)((Object)object)).getFirst() && this.getLast() == object.getLast());
        return bl;
    }

    public Character getEndInclusive() {
        return Character.valueOf(this.getLast());
    }

    public Character getStart() {
        return Character.valueOf(this.getFirst());
    }

    public int hashCode() {
        int n = this.isEmpty() ? -1 : this.getFirst() * 31 + this.getLast();
        return n;
    }

    public boolean isEmpty() {
        boolean bl = Intrinsics.compare((int)this.getFirst(), (int)this.getLast()) > 0;
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
