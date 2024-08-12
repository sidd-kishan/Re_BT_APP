/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(k=3, mv={1, 5, 1})
public final class DurationUnitKt$WhenMappings {
    public static final int[] $EnumSwitchMapping$0;

    static {
        int[] nArray = new int[TimeUnit.values().length];
        $EnumSwitchMapping$0 = nArray;
        nArray[TimeUnit.NANOSECONDS.ordinal()] = 1;
        DurationUnitKt$WhenMappings.$EnumSwitchMapping$0[TimeUnit.MICROSECONDS.ordinal()] = 2;
        DurationUnitKt$WhenMappings.$EnumSwitchMapping$0[TimeUnit.MILLISECONDS.ordinal()] = 3;
        DurationUnitKt$WhenMappings.$EnumSwitchMapping$0[TimeUnit.SECONDS.ordinal()] = 4;
        DurationUnitKt$WhenMappings.$EnumSwitchMapping$0[TimeUnit.MINUTES.ordinal()] = 5;
        DurationUnitKt$WhenMappings.$EnumSwitchMapping$0[TimeUnit.HOURS.ordinal()] = 6;
        DurationUnitKt$WhenMappings.$EnumSwitchMapping$0[TimeUnit.DAYS.ordinal()] = 7;
    }
}
