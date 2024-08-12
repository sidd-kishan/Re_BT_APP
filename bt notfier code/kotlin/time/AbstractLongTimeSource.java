/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.time.AbstractLongTimeSource$LongTimeMark
 *  kotlin.time.Duration
 *  kotlin.time.TimeMark
 *  kotlin.time.TimeSource
 */
package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.AbstractLongTimeSource;
import kotlin.time.Duration;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\fB\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH$R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2={"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource;", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "markNow", "Lkotlin/time/TimeMark;", "read", "", "LongTimeMark", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class AbstractLongTimeSource
implements TimeSource {
    private final TimeUnit unit;

    public AbstractLongTimeSource(TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        this.unit = timeUnit;
    }

    protected final TimeUnit getUnit() {
        return this.unit;
    }

    public TimeMark markNow() {
        return (TimeMark)new LongTimeMark(this.read(), this, Duration.Companion.getZERO_UwyO8pc(), null);
    }

    protected abstract long read();
}
