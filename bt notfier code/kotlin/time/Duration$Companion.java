/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.time.Duration
 *  kotlin.time.DurationKt
 *  kotlin.time.DurationUnitKt
 */
package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnitKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0017J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u0015J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001d\u0010\u0015J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001d\u0010\u0017J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001d\u0010\u0019J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010\u0015J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010\u0019J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\u0015J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\u0017J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\u0019J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b#\u0010\u0015J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b#\u0010\u0017J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b#\u0010\u0019J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b)\u0010'J\u001d\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0002\b+J\u001d\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0002\b-J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b/\u0010\u0015J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b/\u0010\u0017J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b/\u0010\u0019R\u0019\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004X\u0080\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u00060"}, d2={"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "convert", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "days", "days-UwyO8pc", "(D)J", "", "(I)J", "", "(J)J", "hours", "hours-UwyO8pc", "microseconds", "microseconds-UwyO8pc", "milliseconds", "milliseconds-UwyO8pc", "minutes", "minutes-UwyO8pc", "nanoseconds", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds", "seconds-UwyO8pc", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class Duration.Companion {
    private Duration.Companion() {
    }

    public /* synthetic */ Duration.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final double convert(double d, TimeUnit timeUnit, TimeUnit timeUnit2) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"sourceUnit");
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit2), (String)"targetUnit");
        return DurationUnitKt.convertDurationUnit((double)d, (TimeUnit)timeUnit, (TimeUnit)timeUnit2);
    }

    public final long days_UwyO8pc(double d) {
        return DurationKt.toDuration((double)d, (TimeUnit)TimeUnit.DAYS);
    }

    public final long days_UwyO8pc(int n) {
        return DurationKt.toDuration((int)n, (TimeUnit)TimeUnit.DAYS);
    }

    public final long days_UwyO8pc(long l) {
        return DurationKt.toDuration((long)l, (TimeUnit)TimeUnit.DAYS);
    }

    public final long getINFINITE_UwyO8pc() {
        return Duration.access$getINFINITE$cp_UwyO8pc();
    }

    public final long getNEG_INFINITE_UwyO8pc$kotlin_stdlib() {
        return Duration.access$getNEG_INFINITE$cp_UwyO8pc();
    }

    public final long getZERO_UwyO8pc() {
        return Duration.access$getZERO$cp_UwyO8pc();
    }

    public final long hours_UwyO8pc(double d) {
        return DurationKt.toDuration((double)d, (TimeUnit)TimeUnit.HOURS);
    }

    public final long hours_UwyO8pc(int n) {
        return DurationKt.toDuration((int)n, (TimeUnit)TimeUnit.HOURS);
    }

    public final long hours_UwyO8pc(long l) {
        return DurationKt.toDuration((long)l, (TimeUnit)TimeUnit.HOURS);
    }

    public final long microseconds_UwyO8pc(double d) {
        return DurationKt.toDuration((double)d, (TimeUnit)TimeUnit.MICROSECONDS);
    }

    public final long microseconds_UwyO8pc(int n) {
        return DurationKt.toDuration((int)n, (TimeUnit)TimeUnit.MICROSECONDS);
    }

    public final long microseconds_UwyO8pc(long l) {
        return DurationKt.toDuration((long)l, (TimeUnit)TimeUnit.MICROSECONDS);
    }

    public final long milliseconds_UwyO8pc(double d) {
        return DurationKt.toDuration((double)d, (TimeUnit)TimeUnit.MILLISECONDS);
    }

    public final long milliseconds_UwyO8pc(int n) {
        return DurationKt.toDuration((int)n, (TimeUnit)TimeUnit.MILLISECONDS);
    }

    public final long milliseconds_UwyO8pc(long l) {
        return DurationKt.toDuration((long)l, (TimeUnit)TimeUnit.MILLISECONDS);
    }

    public final long minutes_UwyO8pc(double d) {
        return DurationKt.toDuration((double)d, (TimeUnit)TimeUnit.MINUTES);
    }

    public final long minutes_UwyO8pc(int n) {
        return DurationKt.toDuration((int)n, (TimeUnit)TimeUnit.MINUTES);
    }

    public final long minutes_UwyO8pc(long l) {
        return DurationKt.toDuration((long)l, (TimeUnit)TimeUnit.MINUTES);
    }

    public final long nanoseconds_UwyO8pc(double d) {
        return DurationKt.toDuration((double)d, (TimeUnit)TimeUnit.NANOSECONDS);
    }

    public final long nanoseconds_UwyO8pc(int n) {
        return DurationKt.toDuration((int)n, (TimeUnit)TimeUnit.NANOSECONDS);
    }

    public final long nanoseconds_UwyO8pc(long l) {
        return DurationKt.toDuration((long)l, (TimeUnit)TimeUnit.NANOSECONDS);
    }

    public final long parse_UwyO8pc(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"value");
        try {
            long l = DurationKt.access$parseDuration((String)string, (boolean)false);
            return l;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid duration string format: '");
            stringBuilder.append(string);
            stringBuilder.append("'.");
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString(), illegalArgumentException);
        }
    }

    public final long parseIsoString_UwyO8pc(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"value");
        try {
            long l = DurationKt.access$parseDuration((String)string, (boolean)true);
            return l;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid ISO duration string format: '");
            stringBuilder.append(string);
            stringBuilder.append("'.");
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString(), illegalArgumentException);
        }
    }

    public final Duration parseIsoStringOrNull_FghU774(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"value");
        try {
            string = Duration.box_impl((long)DurationKt.access$parseDuration((String)string, (boolean)true));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            string = null;
        }
        return string;
    }

    public final Duration parseOrNull_FghU774(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"value");
        try {
            string = Duration.box_impl((long)DurationKt.access$parseDuration((String)string, (boolean)false));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            string = null;
        }
        return string;
    }

    public final long seconds_UwyO8pc(double d) {
        return DurationKt.toDuration((double)d, (TimeUnit)TimeUnit.SECONDS);
    }

    public final long seconds_UwyO8pc(int n) {
        return DurationKt.toDuration((int)n, (TimeUnit)TimeUnit.SECONDS);
    }

    public final long seconds_UwyO8pc(long l) {
        return DurationKt.toDuration((long)l, (TimeUnit)TimeUnit.SECONDS);
    }
}
