/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.ads.internal.overlay.zzm
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzj
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbpu
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdbp
 *  com.google.android.gms.internal.ads.zzdjj
 *  com.google.android.gms.internal.ads.zzdkc
 *  com.google.android.gms.internal.ads.zzdkn
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbpu;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdbp;
import com.google.android.gms.internal.ads.zzdjj;
import com.google.android.gms.internal.ads.zzdkc;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;

final class zzege
implements zzdkn {
    private final Context zza;
    private final zzcgz zzb;
    private final zzfsm<zzdjj> zzc;
    private final zzezz zzd;
    private final zzcml zze;
    private final zzfar zzf;
    private final zzbpu zzg;
    private final boolean zzh;

    zzege(Context context, zzcgz zzcgz2, zzfsm<zzdjj> zzfsm2, zzezz zzezz2, zzcml zzcml2, zzfar zzfar2, boolean bl, zzbpu zzbpu2) {
        this.zza = context;
        this.zzb = zzcgz2;
        this.zzc = zzfsm2;
        this.zzd = zzezz2;
        this.zze = zzcml2;
        this.zzf = zzfar2;
        this.zzg = zzbpu2;
        this.zzh = bl;
    }

    public final void zza(boolean bl, Context context, zzdbp zzdbp2) {
        zzdjj zzdjj2 = (zzdjj)zzfsd.zzr(this.zzc);
        this.zze.zzag(true);
        boolean bl2 = this.zzh ? this.zzg.zzc(false) : false;
        zzt.zzc();
        boolean bl3 = zzs.zzL((Context)this.zza);
        boolean bl4 = this.zzh ? this.zzg.zzd() : false;
        float f = this.zzh ? this.zzg.zze() : 0.0f;
        zzj zzj2 = new zzj(bl2, bl3, bl4, f, -1, bl, this.zzd.zzK, false);
        if (zzdbp2 != null) {
            zzdbp2.zze();
        }
        zzt.zzb();
        zzdkc zzdkc2 = zzdjj2.zzj();
        zzcml zzcml2 = this.zze;
        zzezz zzezz2 = this.zzd;
        int n = zzezz2.zzM;
        zzdjj2 = this.zzb;
        String string = zzezz2.zzB;
        zzezz2 = zzezz2.zzs;
        zzm.zza((Context)context, (AdOverlayInfoParcel)new AdOverlayInfoParcel(null, (zzo)zzdkc2, null, zzcml2, n, (zzcgz)zzdjj2, string, zzj2, zzezz2.zzb, zzezz2.zza, this.zzf.zzf, zzdbp2), (boolean)true);
    }
}
