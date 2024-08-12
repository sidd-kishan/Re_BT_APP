/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractCollection
 *  kotlin.collections.CollectionsKt
 *  kotlin.internal.PlatformImplementationsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.MatchGroup
 *  kotlin.text.MatchNamedGroupCollection
 *  kotlin.text.MatcherMatchResult
 *  kotlin.text.RegexKt
 */
package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchNamedGroupCollection;
import kotlin.text.MatcherMatchResult;
import kotlin.text.RegexKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0096\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2={"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class MatcherMatchResult.groups.1
extends AbstractCollection<MatchGroup>
implements MatchNamedGroupCollection {
    final MatcherMatchResult this$0;

    MatcherMatchResult.groups.1(MatcherMatchResult matcherMatchResult) {
        this.this$0 = matcherMatchResult;
    }

    public MatchGroup get(int n) {
        IntRange intRange = RegexKt.access$range((MatchResult)MatcherMatchResult.access$getMatchResult$p((MatcherMatchResult)this.this$0), (int)n);
        if (intRange.getStart() >= 0) {
            String string = MatcherMatchResult.access$getMatchResult$p((MatcherMatchResult)this.this$0).group(n);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"matchResult.group(index)");
            intRange = new MatchGroup(string, intRange);
        } else {
            intRange = null;
        }
        return intRange;
    }

    public MatchGroup get(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getMatchResultNamedGroup(MatcherMatchResult.access$getMatchResult$p((MatcherMatchResult)this.this$0), string);
    }

    public int getSize() {
        return MatcherMatchResult.access$getMatchResult$p((MatcherMatchResult)this.this$0).groupCount() + 1;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<MatchGroup> iterator() {
        return SequencesKt.map((Sequence)CollectionsKt.asSequence((Iterable)((Iterable)CollectionsKt.getIndices((Collection)((Object)this)))), (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */)).iterator();
    }
}
