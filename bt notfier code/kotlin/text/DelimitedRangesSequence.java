/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 *  kotlin.sequences.Sequence
 */
package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t\u00a2\u0006\u0002\b\u000e\u00a2\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t\u00a2\u0006\u0002\b\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class DelimitedRangesSequence
implements Sequence<IntRange> {
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> getNextMatch;
    private final CharSequence input;
    private final int limit;
    private final int startIndex;

    public DelimitedRangesSequence(CharSequence charSequence, int n, int n2, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        Intrinsics.checkNotNullParameter(function2, (String)"getNextMatch");
        this.input = charSequence;
        this.startIndex = n;
        this.limit = n2;
        this.getNextMatch = function2;
    }

    public static final /* synthetic */ Function2 access$getGetNextMatch$p(DelimitedRangesSequence delimitedRangesSequence) {
        return delimitedRangesSequence.getNextMatch;
    }

    public static final /* synthetic */ CharSequence access$getInput$p(DelimitedRangesSequence delimitedRangesSequence) {
        return delimitedRangesSequence.input;
    }

    public static final /* synthetic */ int access$getLimit$p(DelimitedRangesSequence delimitedRangesSequence) {
        return delimitedRangesSequence.limit;
    }

    public static final /* synthetic */ int access$getStartIndex$p(DelimitedRangesSequence delimitedRangesSequence) {
        return delimitedRangesSequence.startIndex;
    }

    public Iterator<IntRange> iterator() {
        return (Iterator)new /* Unavailable Anonymous Inner Class!! */;
    }
}
