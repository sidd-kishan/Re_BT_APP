/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 *  kotlin.text.MatchGroupCollection
 *  kotlin.text.MatchResult
 *  kotlin.text.MatchResult$DefaultImpls
 *  kotlin.text.MatchResult$Destructured
 *  kotlin.text.RegexKt
 */
package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.RegexKt;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2={"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class MatcherMatchResult
implements MatchResult {
    private List<String> groupValues_;
    private final MatchGroupCollection groups;
    private final CharSequence input;
    private final Matcher matcher;

    public MatcherMatchResult(Matcher matcher, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)matcher, (String)"matcher");
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        this.matcher = matcher;
        this.input = charSequence;
        this.groups = (MatchGroupCollection)new /* Unavailable Anonymous Inner Class!! */;
    }

    public static final /* synthetic */ java.util.regex.MatchResult access$getMatchResult$p(MatcherMatchResult matcherMatchResult) {
        return matcherMatchResult.getMatchResult();
    }

    private final java.util.regex.MatchResult getMatchResult() {
        return this.matcher;
    }

    public MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured((MatchResult)this);
    }

    public List<String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = (List)new /* Unavailable Anonymous Inner Class!! */;
        }
        List<String> list = this.groupValues_;
        Intrinsics.checkNotNull(list);
        return list;
    }

    public MatchGroupCollection getGroups() {
        return this.groups;
    }

    public IntRange getRange() {
        return RegexKt.access$range((java.util.regex.MatchResult)this.getMatchResult());
    }

    public String getValue() {
        String string = this.getMatchResult().group();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"matchResult.group()");
        return string;
    }

    public MatchResult next() {
        Matcher matcher;
        int n = this.getMatchResult().end();
        int n2 = this.getMatchResult().end() == this.getMatchResult().start() ? 1 : 0;
        if ((n2 = n + n2) <= this.input.length()) {
            matcher = this.matcher.pattern().matcher(this.input);
            Intrinsics.checkNotNullExpressionValue((Object)matcher, (String)"matcher.pattern().matcher(input)");
            matcher = RegexKt.access$findNext((Matcher)matcher, (int)n2, (CharSequence)this.input);
        } else {
            matcher = null;
        }
        return matcher;
    }
}
