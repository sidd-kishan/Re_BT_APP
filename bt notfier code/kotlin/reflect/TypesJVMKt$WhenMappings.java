/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.reflect.KVariance
 */
package kotlin.reflect;

import kotlin.Metadata;
import kotlin.reflect.KVariance;

@Metadata(k=3, mv={1, 5, 1})
public final class TypesJVMKt$WhenMappings {
    public static final int[] $EnumSwitchMapping$0;
    public static final int[] $EnumSwitchMapping$1;

    static {
        int[] nArray = new int[KVariance.values().length];
        $EnumSwitchMapping$0 = nArray;
        nArray[KVariance.IN.ordinal()] = 1;
        TypesJVMKt$WhenMappings.$EnumSwitchMapping$0[KVariance.INVARIANT.ordinal()] = 2;
        TypesJVMKt$WhenMappings.$EnumSwitchMapping$0[KVariance.OUT.ordinal()] = 3;
        nArray = new int[KVariance.values().length];
        $EnumSwitchMapping$1 = nArray;
        nArray[KVariance.INVARIANT.ordinal()] = 1;
        TypesJVMKt$WhenMappings.$EnumSwitchMapping$1[KVariance.IN.ordinal()] = 2;
        TypesJVMKt$WhenMappings.$EnumSwitchMapping$1[KVariance.OUT.ordinal()] = 3;
    }
}
