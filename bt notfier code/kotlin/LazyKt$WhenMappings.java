/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 */
package kotlin;

import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Metadata(k=3, mv={1, 5, 1})
public final class LazyKt$WhenMappings {
    public static final int[] $EnumSwitchMapping$0;

    static {
        int[] nArray = new int[LazyThreadSafetyMode.values().length];
        $EnumSwitchMapping$0 = nArray;
        nArray[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
        LazyKt$WhenMappings.$EnumSwitchMapping$0[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
        LazyKt$WhenMappings.$EnumSwitchMapping$0[LazyThreadSafetyMode.NONE.ordinal()] = 3;
    }
}
