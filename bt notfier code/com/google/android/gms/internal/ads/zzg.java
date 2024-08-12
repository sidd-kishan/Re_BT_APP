/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.media.AudioAttributes$Builder
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zze
 *  com.google.android.gms.internal.ads.zzf
 */
package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zze;
import com.google.android.gms.internal.ads.zzf;

public final class zzg {
    public static final zzg zza = new zzg(0, 0, 1, 1, null);
    public static final zzadw<zzg> zzc = zze.zza;
    public final int zzb;
    private AudioAttributes zzd;

    /* synthetic */ zzg(int n, int n2, int n3, int n4, zzf zzf2) {
        this.zzb = 1;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzg)object;
        return true;
    }

    public final int hashCode() {
        return 15699889;
    }

    public final AudioAttributes zza() {
        if (this.zzd != null) return this.zzd;
        AudioAttributes.Builder builder = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        if (zzamq.zza >= 29) {
            builder.setAllowedCapturePolicy(1);
        }
        this.zzd = builder.build();
        return this.zzd;
    }
}
