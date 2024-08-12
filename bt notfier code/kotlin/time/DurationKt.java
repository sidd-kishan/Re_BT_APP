/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.math.MathKt
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  kotlin.time.Duration
 *  kotlin.time.DurationUnitKt
 */
package kotlin.time;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationUnitKt;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&\u001a\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a\u0018\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a\u0018\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a \u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\b2\u0006\u0010?\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010A\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010C\u001a \u0010D\u001a\u00020\u0007*\u00020\b2\n\u0010E\u001a\u00060Fj\u0002`GH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010H\u001a \u0010D\u001a\u00020\u0007*\u00020\u00052\n\u0010E\u001a\u00060Fj\u0002`GH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010I\u001a \u0010D\u001a\u00020\u0007*\u00020\u00012\n\u0010E\u001a\u00060Fj\u0002`GH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010J\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T\u00a2\u0006\u0002\n\u0000\"!\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"!\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"!\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"!\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"!\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"!\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"!\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"!\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"!\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006K"}, d2={"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(DLjava/util/concurrent/TimeUnit;)J", "(ILjava/util/concurrent/TimeUnit;)J", "(JLjava/util/concurrent/TimeUnit;)J", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class DurationKt {
    public static final long MAX_MILLIS = 0x3FFFFFFFFFFFFFFFL;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final /* synthetic */ long access$durationOf(long l, int n) {
        return DurationKt.durationOf(l, n);
    }

    public static final /* synthetic */ long access$durationOfMillis(long l) {
        return DurationKt.durationOfMillis(l);
    }

    public static final /* synthetic */ long access$durationOfMillisNormalized(long l) {
        return DurationKt.durationOfMillisNormalized(l);
    }

    public static final /* synthetic */ long access$durationOfNanos(long l) {
        return DurationKt.durationOfNanos(l);
    }

    public static final /* synthetic */ long access$durationOfNanosNormalized(long l) {
        return DurationKt.durationOfNanosNormalized(l);
    }

    public static final /* synthetic */ long access$millisToNanos(long l) {
        return DurationKt.millisToNanos(l);
    }

    public static final /* synthetic */ long access$nanosToMillis(long l) {
        return DurationKt.nanosToMillis(l);
    }

    public static final /* synthetic */ long access$parseDuration(String string, boolean bl) {
        return DurationKt.parseDuration(string, bl);
    }

    public static final /* synthetic */ int access$skipWhile(String string, int n, Function1 function1) {
        return DurationKt.skipWhile(string, n, (Function1<? super Character, Boolean>)function1);
    }

    private static final long durationOf(long l, int n) {
        return Duration.constructor_impl((long)((l << 1) + (long)n));
    }

    private static final long durationOfMillis(long l) {
        return Duration.constructor_impl((long)((l << 1) + 1L));
    }

    private static final long durationOfMillisNormalized(long l) {
        l = -4611686018426L <= l && 4611686018426L >= l ? DurationKt.durationOfNanos(DurationKt.millisToNanos(l)) : DurationKt.durationOfMillis(RangesKt.coerceIn((long)l, (long)-4611686018427387903L, (long)0x3FFFFFFFFFFFFFFFL));
        return l;
    }

    private static final long durationOfNanos(long l) {
        return Duration.constructor_impl((long)(l << 1));
    }

    private static final long durationOfNanosNormalized(long l) {
        l = -4611686018426999999L <= l && 4611686018426999999L >= l ? DurationKt.durationOfNanos(l) : DurationKt.durationOfMillis(DurationKt.nanosToMillis(l));
        return l;
    }

    public static final long getDays(double d) {
        return DurationKt.toDuration(d, TimeUnit.DAYS);
    }

    public static final long getDays(int n) {
        return DurationKt.toDuration(n, TimeUnit.DAYS);
    }

    public static final long getDays(long l) {
        return DurationKt.toDuration(l, TimeUnit.DAYS);
    }

    @Deprecated(message="Use Duration.days() function instead.", replaceWith=@ReplaceWith(expression="Duration.days(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getDays$annotations(double d) {
    }

    @Deprecated(message="Use Duration.days() function instead.", replaceWith=@ReplaceWith(expression="Duration.days(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getDays$annotations(int n) {
    }

    @Deprecated(message="Use Duration.days() function instead.", replaceWith=@ReplaceWith(expression="Duration.days(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getDays$annotations(long l) {
    }

    public static final long getHours(double d) {
        return DurationKt.toDuration(d, TimeUnit.HOURS);
    }

    public static final long getHours(int n) {
        return DurationKt.toDuration(n, TimeUnit.HOURS);
    }

    public static final long getHours(long l) {
        return DurationKt.toDuration(l, TimeUnit.HOURS);
    }

    @Deprecated(message="Use Duration.hours() function instead.", replaceWith=@ReplaceWith(expression="Duration.hours(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getHours$annotations(double d) {
    }

    @Deprecated(message="Use Duration.hours() function instead.", replaceWith=@ReplaceWith(expression="Duration.hours(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getHours$annotations(int n) {
    }

    @Deprecated(message="Use Duration.hours() function instead.", replaceWith=@ReplaceWith(expression="Duration.hours(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getHours$annotations(long l) {
    }

    public static final long getMicroseconds(double d) {
        return DurationKt.toDuration(d, TimeUnit.MICROSECONDS);
    }

    public static final long getMicroseconds(int n) {
        return DurationKt.toDuration(n, TimeUnit.MICROSECONDS);
    }

    public static final long getMicroseconds(long l) {
        return DurationKt.toDuration(l, TimeUnit.MICROSECONDS);
    }

    @Deprecated(message="Use Duration.microseconds() function instead.", replaceWith=@ReplaceWith(expression="Duration.microseconds(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getMicroseconds$annotations(double d) {
    }

    @Deprecated(message="Use Duration.microseconds() function instead.", replaceWith=@ReplaceWith(expression="Duration.microseconds(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getMicroseconds$annotations(int n) {
    }

    @Deprecated(message="Use Duration.microseconds() function instead.", replaceWith=@ReplaceWith(expression="Duration.microseconds(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getMicroseconds$annotations(long l) {
    }

    public static final long getMilliseconds(double d) {
        return DurationKt.toDuration(d, TimeUnit.MILLISECONDS);
    }

    public static final long getMilliseconds(int n) {
        return DurationKt.toDuration(n, TimeUnit.MILLISECONDS);
    }

    public static final long getMilliseconds(long l) {
        return DurationKt.toDuration(l, TimeUnit.MILLISECONDS);
    }

    @Deprecated(message="Use Duration.milliseconds() function instead.", replaceWith=@ReplaceWith(expression="Duration.milliseconds(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getMilliseconds$annotations(double d) {
    }

    @Deprecated(message="Use Duration.milliseconds() function instead.", replaceWith=@ReplaceWith(expression="Duration.milliseconds(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getMilliseconds$annotations(int n) {
    }

    @Deprecated(message="Use Duration.milliseconds() function instead.", replaceWith=@ReplaceWith(expression="Duration.milliseconds(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getMilliseconds$annotations(long l) {
    }

    public static final long getMinutes(double d) {
        return DurationKt.toDuration(d, TimeUnit.MINUTES);
    }

    public static final long getMinutes(int n) {
        return DurationKt.toDuration(n, TimeUnit.MINUTES);
    }

    public static final long getMinutes(long l) {
        return DurationKt.toDuration(l, TimeUnit.MINUTES);
    }

    @Deprecated(message="Use Duration.minutes() function instead.", replaceWith=@ReplaceWith(expression="Duration.minutes(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getMinutes$annotations(double d) {
    }

    @Deprecated(message="Use Duration.minutes() function instead.", replaceWith=@ReplaceWith(expression="Duration.minutes(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getMinutes$annotations(int n) {
    }

    @Deprecated(message="Use Duration.minutes() function instead.", replaceWith=@ReplaceWith(expression="Duration.minutes(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getMinutes$annotations(long l) {
    }

    public static final long getNanoseconds(double d) {
        return DurationKt.toDuration(d, TimeUnit.NANOSECONDS);
    }

    public static final long getNanoseconds(int n) {
        return DurationKt.toDuration(n, TimeUnit.NANOSECONDS);
    }

    public static final long getNanoseconds(long l) {
        return DurationKt.toDuration(l, TimeUnit.NANOSECONDS);
    }

    @Deprecated(message="Use Duration.nanoseconds() function instead.", replaceWith=@ReplaceWith(expression="Duration.nanoseconds(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getNanoseconds$annotations(double d) {
    }

    @Deprecated(message="Use Duration.nanoseconds() function instead.", replaceWith=@ReplaceWith(expression="Duration.nanoseconds(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getNanoseconds$annotations(int n) {
    }

    @Deprecated(message="Use Duration.nanoseconds() function instead.", replaceWith=@ReplaceWith(expression="Duration.nanoseconds(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getNanoseconds$annotations(long l) {
    }

    public static final long getSeconds(double d) {
        return DurationKt.toDuration(d, TimeUnit.SECONDS);
    }

    public static final long getSeconds(int n) {
        return DurationKt.toDuration(n, TimeUnit.SECONDS);
    }

    public static final long getSeconds(long l) {
        return DurationKt.toDuration(l, TimeUnit.SECONDS);
    }

    @Deprecated(message="Use Duration.seconds() function instead.", replaceWith=@ReplaceWith(expression="Duration.seconds(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getSeconds$annotations(double d) {
    }

    @Deprecated(message="Use Duration.seconds() function instead.", replaceWith=@ReplaceWith(expression="Duration.seconds(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getSeconds$annotations(int n) {
    }

    @Deprecated(message="Use Duration.seconds() function instead.", replaceWith=@ReplaceWith(expression="Duration.seconds(this)", imports={"kotlin.time.Duration"}))
    public static /* synthetic */ void getSeconds$annotations(long l) {
    }

    private static final long millisToNanos(long l) {
        return l * (long)1000000;
    }

    private static final long nanosToMillis(long l) {
        return l / (long)1000000;
    }

    private static final long parseDuration(String object, boolean bl) {
        long l;
        int n;
        long l2;
        block22: {
            int n2;
            Object object2;
            String string;
            int n3;
            int n4;
            int n5;
            int n6;
            block23: {
                int n7;
                Object object3;
                block20: {
                    block21: {
                        block19: {
                            n6 = ((String)object).length();
                            if (n6 == 0) {
                                object = new IllegalArgumentException("The string is empty");
                                throw object;
                            }
                            l2 = Duration.Companion.getZERO_UwyO8pc();
                            n5 = ((String)object).charAt(0);
                            n5 = n5 != 43 && n5 != 45 ? 0 : 1;
                            n4 = n5 > 0 ? 1 : 0;
                            n = n4 != 0 && StringsKt.startsWith$default((CharSequence)((CharSequence)object), (char)'-', (boolean)false, (int)2, null) ? 1 : 0;
                            if (n6 <= n5) throw (Throwable)new IllegalArgumentException("No components");
                            if (((String)object).charAt(n5) != 'P') break block19;
                            if (++n5 == n6) throw (Throwable)new IllegalArgumentException();
                            object3 = null;
                            bl = false;
                            n7 = n6;
                            break block20;
                        }
                        n3 = n;
                        if (bl) throw (Throwable)new IllegalArgumentException();
                        n = Math.max(n6 - n5, 8);
                        string = "Unexpected order of duration components";
                        if (!StringsKt.regionMatches((String)object, (int)n5, (String)"Infinity", (int)0, (int)n, (boolean)true)) break block21;
                        l2 = Duration.Companion.getINFINITE_UwyO8pc();
                        n = n3;
                        break block22;
                    }
                    object2 = null;
                    n = n4 ^ 1;
                    if (n4 != 0 && ((String)object).charAt(n5) == '(' && StringsKt.last((CharSequence)((CharSequence)object)) == ')') {
                        n4 = n6 - 1;
                        if (++n5 == n4) throw (Throwable)new IllegalArgumentException("No components");
                        n6 = 1;
                    } else {
                        n4 = n6;
                        n6 = n;
                    }
                    n2 = 0;
                    l = l2;
                    break block23;
                }
                while (n5 < n7) {
                    char c;
                    if (((String)object).charAt(n5) == 'T') {
                        if (bl) throw (Throwable)new IllegalArgumentException();
                        if (++n5 == n7) throw (Throwable)new IllegalArgumentException();
                        bl = true;
                        continue;
                    }
                    for (n6 = n5; n6 < ((String)object).length() && (n4 = '0' <= (c = ((String)object).charAt(n6)) && '9' >= c || StringsKt.contains$default((CharSequence)"+-.", (char)c, (boolean)false, (int)2, null) ? 1 : 0) != 0; ++n6) {
                    }
                    if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    String string2 = ((String)object).substring(n5, n6);
                    Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    CharSequence charSequence = string2;
                    n6 = charSequence.length() == 0 ? 1 : 0;
                    if (n6 != 0) throw (Throwable)new IllegalArgumentException();
                    Object object4 = (CharSequence)object;
                    if ((n5 += string2.length()) >= 0 && n5 <= StringsKt.getLastIndex((CharSequence)object4)) {
                        c = object4.charAt(n5);
                        ++n5;
                        object4 = DurationUnitKt.durationUnitByIsoChar((char)c, (boolean)bl);
                        if (object3 != null) {
                            if (object3.compareTo((Enum)object4) <= 0) throw (Throwable)new IllegalArgumentException("Unexpected order of duration components");
                        }
                        n6 = StringsKt.indexOf$default((CharSequence)charSequence, (char)'.', (int)0, (boolean)false, (int)6, null);
                        if (object4 == TimeUnit.SECONDS && n6 > 0) {
                            if (string2 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            object3 = string2.substring(0, n6);
                            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                            l2 = Duration.plus_LRDsOJo((long)l2, (long)DurationKt.toDuration(DurationKt.parseOverLongIsoComponent((String)object3), (TimeUnit)((Object)object4)));
                            if (string2 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            object3 = string2.substring(n6);
                            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"(this as java.lang.String).substring(startIndex)");
                            l2 = Duration.plus_LRDsOJo((long)l2, (long)DurationKt.toDuration(Double.parseDouble((String)object3), (TimeUnit)((Object)object4)));
                        } else {
                            l2 = Duration.plus_LRDsOJo((long)l2, (long)DurationKt.toDuration(DurationKt.parseOverLongIsoComponent(string2), (TimeUnit)((Object)object4)));
                        }
                        object3 = object4;
                        continue;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Missing unit for value ");
                    ((StringBuilder)object).append(string2);
                    throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString());
                }
                break block22;
            }
            while (true) {
                l2 = l;
                n = n3;
                if (n5 >= n4) break;
                n = n5;
                if (n2 != 0) {
                    n = n5;
                    if (n6 != 0) {
                        do {
                            n = n5;
                            if (n5 >= ((String)object).length()) break;
                            n2 = ((String)object).charAt(n5) == ' ' ? 1 : 0;
                            n = n5++;
                        } while (n2 != 0);
                    }
                }
                for (n5 = n; n5 < ((String)object).length() && (n2 = 48 <= (n2 = ((String)object).charAt(n5)) && 57 >= n2 || n2 == 46 ? 1 : 0) != 0; ++n5) {
                }
                if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                String string3 = ((String)object).substring(n, n5);
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                CharSequence charSequence = string3;
                n5 = charSequence.length() == 0 ? 1 : 0;
                if (n5 != 0) throw (Throwable)new IllegalArgumentException();
                n5 = n2 = n + string3.length();
                while (n5 < ((String)object).length() && (n = 97 <= (n = (int)((String)object).charAt(n5)) && 122 >= n ? 1 : 0) != 0) {
                    ++n5;
                }
                if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                Object object5 = ((String)object).substring(n2, n5);
                Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                n5 = n2 + object5.length();
                object5 = DurationUnitKt.durationUnitByShortName((String)object5);
                if (object2 != null) {
                    if (object2.compareTo((Enum)object5) <= 0) throw (Throwable)new IllegalArgumentException(string);
                }
                if ((n = StringsKt.indexOf$default((CharSequence)charSequence, (char)'.', (int)0, (boolean)false, (int)6, null)) > 0) {
                    if (string3 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    object2 = string3.substring(0, n);
                    Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    l2 = Duration.plus_LRDsOJo((long)l, (long)DurationKt.toDuration(Long.parseLong((String)object2), (TimeUnit)((Object)object5)));
                    if (string3 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    object2 = string3.substring(n);
                    Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"(this as java.lang.String).substring(startIndex)");
                    l2 = Duration.plus_LRDsOJo((long)l2, (long)DurationKt.toDuration(Double.parseDouble((String)object2), (TimeUnit)((Object)object5)));
                    if (n5 < n4) throw (Throwable)new IllegalArgumentException("Fractional component must be last");
                } else {
                    l2 = Duration.plus_LRDsOJo((long)l, (long)DurationKt.toDuration(Long.parseLong(string3), (TimeUnit)((Object)object5)));
                }
                n2 = 1;
                object2 = object5;
                l = l2;
            }
        }
        l = l2;
        if (n == 0) return l;
        l = Duration.unaryMinus_UwyO8pc((long)l2);
        return l;
    }

    /*
     * Handled impossible loop by adding 'first' condition
     */
    private static final long parseOverLongIsoComponent(String string) {
        Object object;
        block4: {
            int n;
            block3: {
                int n2;
                n = (n2 = string.length()) > 0 && StringsKt.contains$default((CharSequence)"+-", (char)string.charAt(0), (boolean)false, (int)2, null) ? 1 : 0;
                if (n2 - n <= 16) break block4;
                boolean bl = true;
                do {
                    block6: {
                        block5: {
                            if (!bl || (bl = false)) break block5;
                            object = (Iterable)new IntRange(n, StringsKt.getLastIndex((CharSequence)string));
                            if (object instanceof Collection && ((Collection)object).isEmpty()) break block6;
                            object = object.iterator();
                        }
                        if (object.hasNext()) continue;
                    }
                    n = 1;
                    break block3;
                } while ((n = 48 <= (n = (int)string.charAt(((IntIterator)object).nextInt())) && 57 >= n ? 1 : 0) != 0);
                n = 0;
            }
            if (n != 0) {
                if (string.charAt(0) != '-') return Long.MAX_VALUE;
                return Long.MIN_VALUE;
            }
        }
        object = string;
        if (!StringsKt.startsWith$default((String)string, (String)"+", (boolean)false, (int)2, null)) return Long.parseLong((String)object);
        object = StringsKt.drop((String)string, (int)1);
        return Long.parseLong((String)object);
    }

    private static final int skipWhile(String string, int n, Function1<? super Character, Boolean> function1) {
        while (n < string.length()) {
            if ((Boolean)function1.invoke((Object)Character.valueOf(string.charAt(n))) == false) return n;
            ++n;
        }
        return n;
    }

    private static final String substringWhile(String object, int n, Function1<? super Character, Boolean> function1) {
        int n2;
        for (n2 = n; n2 < ((String)object).length() && ((Boolean)function1.invoke((Object)Character.valueOf(((String)object).charAt(n2)))).booleanValue(); ++n2) {
        }
        if (object != null) {
            object = ((String)object).substring(n, n2);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            return object;
        }
        object = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        throw object;
    }

    private static final long times_kIfJnKk(double d, long l) {
        return Duration.times_UwyO8pc((long)l, (double)d);
    }

    private static final long times_mvk6XK0(int n, long l) {
        return Duration.times_UwyO8pc((long)l, (int)n);
    }

    public static final long toDuration(double d, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        double d2 = DurationUnitKt.convertDurationUnit((double)d, (TimeUnit)timeUnit, (TimeUnit)TimeUnit.NANOSECONDS);
        if (!(Double.isNaN(d2) ^ true)) throw (Throwable)new IllegalArgumentException("Duration value cannot be NaN.".toString());
        long l = MathKt.roundToLong((double)d2);
        l = -4611686018426999999L <= l && 4611686018426999999L >= l ? DurationKt.durationOfNanos(l) : DurationKt.durationOfMillisNormalized(MathKt.roundToLong((double)DurationUnitKt.convertDurationUnit((double)d, (TimeUnit)timeUnit, (TimeUnit)TimeUnit.MILLISECONDS)));
        return l;
    }

    public static final long toDuration(int n, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        long l = timeUnit.compareTo((Enum)TimeUnit.SECONDS) <= 0 ? DurationKt.durationOfNanos(DurationUnitKt.convertDurationUnitOverflow((long)n, (TimeUnit)timeUnit, (TimeUnit)TimeUnit.NANOSECONDS)) : DurationKt.toDuration((long)n, timeUnit);
        return l;
    }

    public static final long toDuration(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        long l2 = DurationUnitKt.convertDurationUnitOverflow((long)4611686018426999999L, (TimeUnit)TimeUnit.NANOSECONDS, (TimeUnit)timeUnit);
        if (-l2 > l) {
            return DurationKt.durationOfMillis(RangesKt.coerceIn((long)DurationUnitKt.convertDurationUnit((long)l, (TimeUnit)timeUnit, (TimeUnit)TimeUnit.MILLISECONDS), (long)-4611686018427387903L, (long)0x3FFFFFFFFFFFFFFFL));
        }
        if (l2 < l) return DurationKt.durationOfMillis(RangesKt.coerceIn((long)DurationUnitKt.convertDurationUnit((long)l, (TimeUnit)timeUnit, (TimeUnit)TimeUnit.MILLISECONDS), (long)-4611686018427387903L, (long)0x3FFFFFFFFFFFFFFFL));
        return DurationKt.durationOfNanos(DurationUnitKt.convertDurationUnitOverflow((long)l, (TimeUnit)timeUnit, (TimeUnit)TimeUnit.NANOSECONDS));
    }
}
