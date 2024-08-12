/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractList
 *  kotlin.text.MatcherMatchResult
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.text.MatcherMatchResult;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0096\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class MatcherMatchResult.groupValues.1
extends AbstractList<String> {
    final MatcherMatchResult this$0;

    MatcherMatchResult.groupValues.1(MatcherMatchResult matcherMatchResult) {
        this.this$0 = matcherMatchResult;
    }

    public String get(int n) {
        String string = MatcherMatchResult.access$getMatchResult$p((MatcherMatchResult)this.this$0).group(n);
        if (string != null) return string;
        string = "";
        return string;
    }

    public int getSize() {
        return MatcherMatchResult.access$getMatchResult$p((MatcherMatchResult)this.this$0).groupCount() + 1;
    }
}
