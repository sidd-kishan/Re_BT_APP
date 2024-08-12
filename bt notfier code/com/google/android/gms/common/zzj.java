/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.zzi
 */
package com.google.android.gms.common;

import com.google.android.gms.common.zzi;
import java.util.Arrays;

final class zzj
extends zzi {
    private final byte[] zza;

    zzj(byte[] byArray) {
        super(Arrays.copyOfRange(byArray, 0, 25));
        this.zza = byArray;
    }

    final byte[] zzc() {
        return this.zza;
    }
}
