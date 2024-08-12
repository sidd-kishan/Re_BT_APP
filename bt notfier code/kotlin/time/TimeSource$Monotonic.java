/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.time.MonotonicTimeSource
 *  kotlin.time.TimeMark
 *  kotlin.time.TimeSource
 */
package kotlin.time;

import kotlin.Metadata;
import kotlin.time.MonotonicTimeSource;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0096\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource;", "()V", "markNow", "Lkotlin/time/TimeMark;", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class TimeSource.Monotonic
implements TimeSource {
    public static final TimeSource.Monotonic INSTANCE = new TimeSource.Monotonic();
    private final MonotonicTimeSource $$delegate_0 = MonotonicTimeSource.INSTANCE;

    private TimeSource.Monotonic() {
    }

    public TimeMark markNow() {
        return this.$$delegate_0.markNow();
    }

    public String toString() {
        return MonotonicTimeSource.INSTANCE.toString();
    }
}
