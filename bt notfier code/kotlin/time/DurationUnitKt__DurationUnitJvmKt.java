/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0001\u001a(\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0001\u001a(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0001*\u001e\b\u0007\u0010\t\"\u00020\u00042\u00020\u0004B\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fB\u0002\b\r\u00a8\u0006\u000e"}, d2={"convertDurationUnit", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "", "convertDurationUnitOverflow", "DurationUnit", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitJvmKt {
    public static /* synthetic */ void DurationUnit$annotations() {
    }

    public static final double convertDurationUnit(double d, TimeUnit timeUnit, TimeUnit timeUnit2) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"sourceUnit");
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit2), (String)"targetUnit");
        long l = timeUnit2.convert(1L, timeUnit);
        if (l > 0L) {
            double d2 = l;
            Double.isNaN(d2);
            return d * d2;
        }
        double d3 = timeUnit.convert(1L, timeUnit2);
        Double.isNaN(d3);
        return d / d3;
    }

    public static final long convertDurationUnit(long l, TimeUnit timeUnit, TimeUnit timeUnit2) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"sourceUnit");
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit2), (String)"targetUnit");
        return timeUnit2.convert(l, timeUnit);
    }

    public static final long convertDurationUnitOverflow(long l, TimeUnit timeUnit, TimeUnit timeUnit2) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"sourceUnit");
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit2), (String)"targetUnit");
        return timeUnit2.convert(l, timeUnit);
    }
}
