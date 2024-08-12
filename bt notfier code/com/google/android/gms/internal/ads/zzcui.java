/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzffb
 *  com.google.android.gms.internal.ads.zzffc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzffb;
import com.google.android.gms.internal.ads.zzffc;

public final class zzcui {
    private final zzffc zza;
    private final zzdvi zzb;
    private final zzfal zzc;

    public zzcui(zzdvi zzdvi2, zzfal zzfal2, zzffc zzffc2) {
        this.zza = zzffc2;
        this.zzb = zzdvi2;
        this.zzc = zzfal2;
    }

    private static String zzb(int n) {
        if (--n == 0) return "h";
        if (n == 1) return "bb";
        if (n == 2) return "cc";
        if (n == 3) return "cb";
        if (n == 4) return "ac";
        return "u";
    }

    public final void zza(long l, int n) {
        zzbjd zzbjd2 = zzbjl.zzgi;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zzbjd2 = this.zza;
            zzffb zzffb2 = zzffb.zza((String)"ad_closed");
            zzffb2.zzh(this.zzc.zzb.zzb);
            zzffb2.zzc("show_time", String.valueOf(l));
            zzffb2.zzc("ad_format", "app_open_ad");
            zzffb2.zzc("acr", zzcui.zzb(n));
            zzbjd2.zza(zzffb2);
            return;
        }
        zzbjd2 = this.zzb.zzd();
        zzbjd2.zzb(this.zzc.zzb.zzb);
        zzbjd2.zzd("action", "ad_closed");
        zzbjd2.zzd("show_time", String.valueOf(l));
        zzbjd2.zzd("ad_format", "app_open_ad");
        zzbjd2.zzd("acr", zzcui.zzb(n));
        zzbjd2.zze();
    }
}
