/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd$OnCustomClickListener
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd$OnCustomTemplateAdLoadedListener
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbnc
 *  com.google.android.gms.internal.ads.zzbnl
 *  com.google.android.gms.internal.ads.zzbno
 *  com.google.android.gms.internal.ads.zzboj
 *  com.google.android.gms.internal.ads.zzbok
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbnc;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzbno;
import com.google.android.gms.internal.ads.zzboj;
import com.google.android.gms.internal.ads.zzbok;

public final class zzbol {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zza;
    private final NativeCustomTemplateAd.OnCustomClickListener zzb;
    private NativeCustomTemplateAd zzc;

    public zzbol(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomTemplateAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    static /* synthetic */ NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zza(zzbol zzbol2) {
        return zzbol2.zza;
    }

    static /* synthetic */ NativeCustomTemplateAd.OnCustomClickListener zzb(zzbol zzbol2) {
        return zzbol2.zzb;
    }

    static /* synthetic */ NativeCustomTemplateAd zze(zzbol zzbol2, zzbnb zzbnb2) {
        return zzbol2.zzf(zzbnb2);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final NativeCustomTemplateAd zzf(zzbnb zzbnb2) {
        synchronized (this) {
            NativeCustomTemplateAd nativeCustomTemplateAd = this.zzc;
            if (nativeCustomTemplateAd != null) {
                return nativeCustomTemplateAd;
            }
            this.zzc = nativeCustomTemplateAd = new zzbnc(zzbnb2);
            return nativeCustomTemplateAd;
        }
    }

    public final zzbno zzc() {
        return new zzbok(this, null);
    }

    public final zzbnl zzd() {
        if (this.zzb != null) return new zzboj(this, null);
        return null;
    }
}
