/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.time.AbstractDoubleTimeSource
 *  kotlin.time.Duration
 *  kotlin.time.DurationKt
 *  kotlin.time.TimeMark
 */
package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.AbstractDoubleTimeSource;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.TimeMark;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0015\u0010\n\u001a\u00020\u0007H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0007H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0011"}, d2={"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/TimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", "offset", "Lkotlin/time/Duration;", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private static final class AbstractDoubleTimeSource.DoubleTimeMark
extends TimeMark {
    private final long offset;
    private final double startedAt;
    private final AbstractDoubleTimeSource timeSource;

    private AbstractDoubleTimeSource.DoubleTimeMark(double d, AbstractDoubleTimeSource abstractDoubleTimeSource, long l) {
        this.startedAt = d;
        this.timeSource = abstractDoubleTimeSource;
        this.offset = l;
    }

    public /* synthetic */ AbstractDoubleTimeSource.DoubleTimeMark(double d, AbstractDoubleTimeSource abstractDoubleTimeSource, long l, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, abstractDoubleTimeSource, l);
    }

    public long elapsedNow_UwyO8pc() {
        return Duration.minus_LRDsOJo((long)DurationKt.toDuration((double)(this.timeSource.read() - this.startedAt), (TimeUnit)this.timeSource.getUnit()), (long)this.offset);
    }

    public TimeMark plus_LRDsOJo(long l) {
        return new AbstractDoubleTimeSource.DoubleTimeMark(this.startedAt, this.timeSource, Duration.plus_LRDsOJo((long)this.offset, (long)l));
    }
}
