/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.internal.jdk7.JDK7PlatformImplementations
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  kotlin.random.jdk8.PlatformThreadLocalRandom
 *  kotlin.ranges.IntRange
 *  kotlin.text.MatchGroup
 */
package kotlin.internal.jdk8;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroup;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Lkotlin/internal/jdk8/JDK8PlatformImplementations;", "Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "()V", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "kotlin-stdlib-jdk8"}, k=1, mv={1, 5, 1})
public class JDK8PlatformImplementations
extends JDK7PlatformImplementations {
    public Random defaultPlatformRandom() {
        return (Random)new PlatformThreadLocalRandom();
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult object, String string) {
        Matcher matcher;
        Intrinsics.checkNotNullParameter((Object)object, (String)"matchResult");
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        boolean bl = object instanceof Matcher;
        Object var4_4 = null;
        if (!bl) {
            object = null;
        }
        if ((matcher = (Matcher)object) == null) throw (Throwable)new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        IntRange intRange = new IntRange(matcher.start(string), matcher.end(string) - 1);
        object = var4_4;
        if (intRange.getStart() < 0) return object;
        object = matcher.group(string);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"matcher.group(name)");
        object = new MatchGroup((String)object, intRange);
        return object;
    }
}
