/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  kotlin.text.MatchResult
 *  kotlin.text.Regex
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2={"<anonymous>", "Lkotlin/text/MatchResult;", "invoke"}, k=3, mv={1, 5, 1})
static final class Regex.findAll.1
extends Lambda
implements Function0<MatchResult> {
    final CharSequence $input;
    final int $startIndex;
    final Regex this$0;

    Regex.findAll.1(Regex regex, CharSequence charSequence, int n) {
        this.this$0 = regex;
        this.$input = charSequence;
        this.$startIndex = n;
        super(0);
    }

    public final MatchResult invoke() {
        return this.this$0.find(this.$input, this.$startIndex);
    }
}
