/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.time.Duration
 */
package kotlin.time.jdk8;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

@Metadata(d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0007"}, d2={"toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)J", "kotlin-stdlib-jdk8"}, k=2, mv={1, 5, 1}, pn="kotlin.time")
public final class DurationConversionsJDK8Kt {
    private static final java.time.Duration toJavaDuration_LRDsOJo(long l) {
        java.time.Duration duration = java.time.Duration.ofSeconds(Duration.getInWholeSeconds_impl((long)l), Duration.getNanosecondsComponent_impl((long)l));
        Intrinsics.checkNotNullExpressionValue((Object)duration, (String)"toComponents { seconds, \u2026, nanoseconds.toLong()) }");
        return duration;
    }

    private static final long toKotlinDuration(java.time.Duration duration) {
        return Duration.plus_LRDsOJo((long)Duration.Companion.seconds_UwyO8pc(duration.getSeconds()), (long)Duration.Companion.nanoseconds_UwyO8pc(duration.getNano()));
    }
}
