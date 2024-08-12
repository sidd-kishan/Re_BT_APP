/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzaxd {
    private final float zza;
    private final float zzb;
    private final float zzc;
    private final float zzd;
    private final int zze;

    public zzaxd(float f, float f2, float f3, float f4, int n) {
        this.zza = f;
        this.zzb = f2;
        this.zzc = f + f3;
        this.zzd = f2 + f4;
        this.zze = n;
    }

    final float zza() {
        return this.zza;
    }

    final float zzb() {
        return this.zzb;
    }

    final float zzc() {
        return this.zzc;
    }

    final float zzd() {
        return this.zzd;
    }

    final int zze() {
        return this.zze;
    }
}
