/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.ads.internal.overlay.zzm
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzj
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbpu
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcus
 *  com.google.android.gms.internal.ads.zzdbp
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
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbpu;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcus;
import com.google.android.gms.internal.ads.zzdbp;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;

final class zzeer
implements zzdkn {
    private final zzcgz zza;
    private final zzfsm<zzcus> zzb;
    private final zzezz zzc;
    private final zzcml zzd;
    private final zzfar zze;
    private final zzbpu zzf;
    private final boolean zzg;

    zzeer(zzcgz zzcgz2, zzfsm<zzcus> zzfsm2, zzezz zzezz2, zzcml zzcml2, zzfar zzfar2, boolean bl, zzbpu zzbpu2) {
        this.zza = zzcgz2;
        this.zzb = zzfsm2;
        this.zzc = zzezz2;
        this.zzd = zzcml2;
        this.zze = zzfar2;
        this.zzg = bl;
        this.zzf = zzbpu2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zza(boolean var1_1, Context var2_2, zzdbp var3_3) {
        block5: {
            var9_4 = (zzcus)zzfsd.zzr(this.zzb);
            this.zzd.zzag(true);
            var6_5 = this.zzg != false ? this.zzf.zzc(true) : true;
            var7_6 = this.zzg != false ? this.zzf.zzd() : false;
            var4_7 = this.zzg != false ? this.zzf.zze() : 0.0f;
            var8_8 = new zzj(var6_5, true, var7_6, var4_7, -1, var1_1, this.zzc.zzK, false);
            if (var3_3 != null) {
                var3_3.zze();
            }
            zzt.zzb();
            var9_4 = var9_4.zzj();
            var10_9 = this.zzd;
            var5_10 = this.zzc.zzM;
            if (var5_10 != -1) break block5;
            var11_11 /* !! */  = this.zze.zzj;
            if (var11_11 /* !! */  == null) ** GOTO lbl-1000
            var5_10 = var11_11 /* !! */ .zza;
            if (var5_10 == 1) {
                var5_10 = 7;
            } else if (var5_10 == 2) {
                var5_10 = 6;
            } else lbl-1000:
            // 2 sources

            {
                com.google.android.gms.ads.internal.util.zze.zzd((String)"Error setting app open orientation; no targeting orientation available.");
                var5_10 = this.zzc.zzM;
            }
        }
        var12_12 = this.zza;
        var13_13 = this.zzc;
        var11_11 /* !! */  = var13_13.zzB;
        var13_13 = var13_13.zzs;
        zzm.zza((Context)var2_2, (AdOverlayInfoParcel)new AdOverlayInfoParcel(null, (zzo)var9_4, null, var10_9, var5_10, var12_12, (String)var11_11 /* !! */ , var8_8, var13_13.zzb, var13_13.zza, this.zze.zzf, var3_3), (boolean)true);
    }
}
