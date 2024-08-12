/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2={"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getRange", "()Lkotlin/ranges/IntRange;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class MatchGroup {
    private final IntRange range;
    private final String value;

    public MatchGroup(String string, IntRange intRange) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"value");
        Intrinsics.checkNotNullParameter((Object)intRange, (String)"range");
        this.value = string;
        this.range = intRange;
    }

    public static /* synthetic */ MatchGroup copy$default(MatchGroup matchGroup, String string, IntRange intRange, int n, Object object) {
        if ((n & 1) != 0) {
            string = matchGroup.value;
        }
        if ((n & 2) == 0) return matchGroup.copy(string, intRange);
        intRange = matchGroup.range;
        return matchGroup.copy(string, intRange);
    }

    public final String component1() {
        return this.value;
    }

    public final IntRange component2() {
        return this.range;
    }

    public final MatchGroup copy(String string, IntRange intRange) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"value");
        Intrinsics.checkNotNullParameter((Object)intRange, (String)"range");
        return new MatchGroup(string, intRange);
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MatchGroup)) return false;
        object = (MatchGroup)object;
        if (!Intrinsics.areEqual((Object)this.value, (Object)((MatchGroup)object).value)) return false;
        if (!Intrinsics.areEqual((Object)this.range, (Object)((MatchGroup)object).range)) return false;
        return true;
    }

    public final IntRange getRange() {
        return this.range;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String string = this.value;
        int n = 0;
        int n2 = string != null ? string.hashCode() : 0;
        string = this.range;
        if (string == null) return n2 * 31 + n;
        n = string.hashCode();
        return n2 * 31 + n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MatchGroup(value=");
        stringBuilder.append(this.value);
        stringBuilder.append(", range=");
        stringBuilder.append(this.range);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
