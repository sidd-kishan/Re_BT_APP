/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 *  kotlin.text.MatchGroup
 *  kotlin.text.MatcherMatchResult$groups$1
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchGroup;
import kotlin.text.MatcherMatchResult;

@Metadata(d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2={"<anonymous>", "Lkotlin/text/MatchGroup;", "it", "", "invoke"}, k=3, mv={1, 5, 1})
static final class MatcherMatchResult.groups.iterator.1
extends Lambda
implements Function1<Integer, MatchGroup> {
    final MatcherMatchResult.groups.1 this$0;

    MatcherMatchResult.groups.iterator.1(MatcherMatchResult.groups.1 var1_1) {
        this.this$0 = var1_1;
        super(1);
    }

    public final MatchGroup invoke(int n) {
        return this.this$0.get(n);
    }
}
