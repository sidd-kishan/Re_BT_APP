/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.time.TimeMark
 *  kotlin.time.TimeSource
 *  kotlin.time.TimeSource$Monotonic
 *  kotlin.time.TimedValue
 */
package kotlin.time;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0002\u0010\u0005\u001a3\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\b\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0002\u0010\n\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\b\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006\u000b"}, d2={"measureTime", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)J", "measureTimedValue", "Lkotlin/time/TimedValue;", "T", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)J", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class MeasureTimeKt {
    public static final long measureTime(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, (String)"block");
        TimeMark timeMark = ((TimeSource)TimeSource.Monotonic.INSTANCE).markNow();
        function0.invoke();
        return timeMark.elapsedNow_UwyO8pc();
    }

    public static final long measureTime(TimeSource timeSource, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter((Object)timeSource, (String)"$this$measureTime");
        Intrinsics.checkNotNullParameter(function0, (String)"block");
        timeSource = timeSource.markNow();
        function0.invoke();
        return timeSource.elapsedNow_UwyO8pc();
    }

    public static final <T> TimedValue<T> measureTimedValue(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, (String)"block");
        TimeMark timeMark = ((TimeSource)TimeSource.Monotonic.INSTANCE).markNow();
        return new TimedValue(function0.invoke(), timeMark.elapsedNow_UwyO8pc(), null);
    }

    public static final <T> TimedValue<T> measureTimedValue(TimeSource timeSource, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter((Object)timeSource, (String)"$this$measureTimedValue");
        Intrinsics.checkNotNullParameter(function0, (String)"block");
        timeSource = timeSource.markNow();
        return new TimedValue(function0.invoke(), timeSource.elapsedNow_UwyO8pc(), null);
    }
}
