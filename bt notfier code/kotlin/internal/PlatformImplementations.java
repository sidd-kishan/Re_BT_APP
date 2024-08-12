/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.internal.PlatformImplementations$ReflectThrowable
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.FallbackThreadLocalRandom
 *  kotlin.random.Random
 *  kotlin.text.MatchGroup
 */
package kotlin.internal;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0013"}, d2={"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public class PlatformImplementations {
    public void addSuppressed(Throwable throwable, Throwable throwable2) {
        Intrinsics.checkNotNullParameter((Object)throwable, (String)"cause");
        Intrinsics.checkNotNullParameter((Object)throwable2, (String)"exception");
        Method method = ReflectThrowable.addSuppressed;
        if (method == null) return;
        method.invoke(throwable, throwable2);
    }

    public Random defaultPlatformRandom() {
        return (Random)new FallbackThreadLocalRandom();
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult matchResult, String string) {
        Intrinsics.checkNotNullParameter((Object)matchResult, (String)"matchResult");
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        throw (Throwable)new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    public List<Throwable> getSuppressed(Throwable object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"exception");
        Method method = ReflectThrowable.getSuppressed;
        if (method != null && (object = method.invoke(object, new Object[0])) != null) {
            if (object == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Throwable>");
            if ((object = ArraysKt.asList((Object[])((Throwable[])object))) != null) return object;
        }
        object = CollectionsKt.emptyList();
        return object;
    }
}
