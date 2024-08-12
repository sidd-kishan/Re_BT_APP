/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nativead.NativeCustomFormatAd
 *  com.google.android.gms.ads.nativead.NativeCustomFormatAd$OnCustomClickListener
 *  com.google.android.gms.ads.nativead.NativeCustomFormatAd$OnCustomFormatAdLoadedListener
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbnl
 *  com.google.android.gms.internal.ads.zzbno
 *  com.google.android.gms.internal.ads.zzbyw
 *  com.google.android.gms.internal.ads.zzbyx
 *  com.google.android.gms.internal.ads.zzbyz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzbno;
import com.google.android.gms.internal.ads.zzbyw;
import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzbyz;

public final class zzbyy {
    private final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zza;
    private final NativeCustomFormatAd.OnCustomClickListener zzb;
    private NativeCustomFormatAd zzc;

    public zzbyy(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomFormatAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    static /* synthetic */ NativeCustomFormatAd.OnCustomFormatAdLoadedListener zza(zzbyy zzbyy2) {
        return zzbyy2.zza;
    }

    static /* synthetic */ NativeCustomFormatAd.OnCustomClickListener zzb(zzbyy zzbyy2) {
        return zzbyy2.zzb;
    }

    static /* synthetic */ NativeCustomFormatAd zze(zzbyy zzbyy2, zzbnb zzbnb2) {
        return zzbyy2.zzf(zzbnb2);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final NativeCustomFormatAd zzf(zzbnb zzbnb2) {
        synchronized (this) {
            NativeCustomFormatAd nativeCustomFormatAd = this.zzc;
            if (nativeCustomFormatAd != null) {
                return nativeCustomFormatAd;
            }
            this.zzc = nativeCustomFormatAd = new zzbyz(zzbnb2);
            return nativeCustomFormatAd;
        }
    }

    public final zzbno zzc() {
        return new zzbyx(this, null);
    }

    public final zzbnl zzd() {
        if (this.zzb != null) return new zzbyw(this, null);
        return null;
    }
}
