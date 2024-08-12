/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  kotlin.text.FlagEnum
 *  kotlin.text.MatchResult
 *  kotlin.text.MatcherMatchResult
 */
package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.FlagEnum;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002\u00a8\u0006\u0014"}, d2={"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class RegexKt {
    public static final /* synthetic */ MatchResult access$findNext(Matcher matcher, int n, CharSequence charSequence) {
        return RegexKt.findNext(matcher, n, charSequence);
    }

    public static final /* synthetic */ Set access$fromInt(int n) {
        return RegexKt.fromInt(n);
    }

    public static final /* synthetic */ MatchResult access$matchEntire(Matcher matcher, CharSequence charSequence) {
        return RegexKt.matchEntire(matcher, charSequence);
    }

    public static final /* synthetic */ IntRange access$range(java.util.regex.MatchResult matchResult) {
        return RegexKt.range(matchResult);
    }

    public static final /* synthetic */ IntRange access$range(java.util.regex.MatchResult matchResult, int n) {
        return RegexKt.range(matchResult, n);
    }

    public static final /* synthetic */ int access$toInt(Iterable iterable) {
        return RegexKt.toInt(iterable);
    }

    private static final MatchResult findNext(Matcher matcher, int n, CharSequence charSequence) {
        matcher = !matcher.find(n) ? null : (MatchResult)new MatcherMatchResult(matcher, charSequence);
        return matcher;
    }

    private static final /* synthetic */ <T extends Enum<T>> Set<T> fromInt(int n) {
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        Set<Enum> set = EnumSet.allOf(Enum.class);
        CollectionsKt.retainAll((Iterable)set, (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */));
        set = Collections.unmodifiableSet((Set)set);
        Intrinsics.checkNotNullExpressionValue(set, (String)"Collections.unmodifiable\u2026mask == it.value }\n    })");
        return set;
    }

    private static final MatchResult matchEntire(Matcher matcher, CharSequence charSequence) {
        matcher = !matcher.matches() ? null : (MatchResult)new MatcherMatchResult(matcher, charSequence);
        return matcher;
    }

    private static final IntRange range(java.util.regex.MatchResult matchResult) {
        return RangesKt.until((int)matchResult.start(), (int)matchResult.end());
    }

    private static final IntRange range(java.util.regex.MatchResult matchResult, int n) {
        return RangesKt.until((int)matchResult.start(n), (int)matchResult.end(n));
    }

    private static final int toInt(Iterable<? extends FlagEnum> object) {
        object = object.iterator();
        int n = 0;
        while (object.hasNext()) {
            n |= ((FlagEnum)object.next()).getValue();
        }
        return n;
    }
}
