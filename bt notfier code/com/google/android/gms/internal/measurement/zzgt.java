/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgs
 *  com.google.android.gms.internal.measurement.zzgu
 *  com.google.android.gms.internal.measurement.zzib
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzgu;
import com.google.android.gms.internal.measurement.zzib;

final class zzgt
extends zzgu {
    private final byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd = Integer.MAX_VALUE;

    /* synthetic */ zzgt(byte[] byArray, int n, int n2, boolean bl, zzgs zzgs2) {
        super(null);
        this.zza = byArray;
        this.zzb = 0;
    }

    public final int zza(int n) throws zzib {
        int n2;
        n = this.zzd;
        this.zzd = 0;
        this.zzb = n2 = this.zzb + this.zzc;
        if (n2 > 0) {
            this.zzc = n2;
            this.zzb = 0;
        } else {
            this.zzc = 0;
        }
        return n;
    }
}
