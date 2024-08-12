/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.time.Duration
 *  kotlin.time.TimeMark
 */
package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;
import kotlin.time.TimeMark;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0015\u0010\u000b\u001a\u00020\u0004H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\f\u0010\u0007J\u001b\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0004H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0011"}, d2={"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "mark", "adjustment", "Lkotlin/time/Duration;", "(Lkotlin/time/TimeMark;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdjustment-UwyO8pc", "()J", "J", "getMark", "()Lkotlin/time/TimeMark;", "elapsedNow", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class AdjustedTimeMark
extends TimeMark {
    private final long adjustment;
    private final TimeMark mark;

    private AdjustedTimeMark(TimeMark timeMark, long l) {
        this.mark = timeMark;
        this.adjustment = l;
    }

    public /* synthetic */ AdjustedTimeMark(TimeMark timeMark, long l, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeMark, l);
    }

    public long elapsedNow_UwyO8pc() {
        return Duration.minus_LRDsOJo((long)this.mark.elapsedNow_UwyO8pc(), (long)this.adjustment);
    }

    public final long getAdjustment_UwyO8pc() {
        return this.adjustment;
    }

    public final TimeMark getMark() {
        return this.mark;
    }

    public TimeMark plus_LRDsOJo(long l) {
        return new AdjustedTimeMark(this.mark, Duration.plus_LRDsOJo((long)this.adjustment, (long)l));
    }
}
