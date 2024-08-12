/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.State
 */
package kotlin.collections;

import kotlin.Metadata;
import kotlin.collections.State;

@Metadata(k=3, mv={1, 5, 1})
public final class AbstractIterator$WhenMappings {
    public static final int[] $EnumSwitchMapping$0;

    static {
        int[] nArray = new int[State.values().length];
        $EnumSwitchMapping$0 = nArray;
        nArray[State.Done.ordinal()] = 1;
        AbstractIterator$WhenMappings.$EnumSwitchMapping$0[State.Ready.ordinal()] = 2;
    }
}
