/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.reflect.KVariance
 */
package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KVariance;

@Metadata(k=3, mv={1, 5, 1})
public final class TypeReference$WhenMappings {
    public static final int[] $EnumSwitchMapping$0;

    static {
        int[] nArray = new int[KVariance.values().length];
        $EnumSwitchMapping$0 = nArray;
        nArray[KVariance.INVARIANT.ordinal()] = 1;
        TypeReference$WhenMappings.$EnumSwitchMapping$0[KVariance.IN.ordinal()] = 2;
        TypeReference$WhenMappings.$EnumSwitchMapping$0[KVariance.OUT.ordinal()] = 3;
    }
}
