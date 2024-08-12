/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.ads.internal.overlay.zzm
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzj
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbpu
 *  com.google.android.gms.internal.ads.zzbqg
 *  com.google.android.gms.internal.ads.zzbqh
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcmw
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzdbp
 *  com.google.android.gms.internal.ads.zzdkn
 *  com.google.android.gms.internal.ads.zzdrx
 *  com.google.android.gms.internal.ads.zzdsr
 *  com.google.android.gms.internal.ads.zzdss
 *  com.google.android.gms.internal.ads.zzdsw
 *  com.google.android.gms.internal.ads.zzeik
 *  com.google.android.gms.internal.ads.zzeil
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbpu;
import com.google.android.gms.internal.ads.zzbqg;
import com.google.android.gms.internal.ads.zzbqh;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcmw;
import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzdbp;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzdrx;
import com.google.android.gms.internal.ads.zzdsr;
import com.google.android.gms.internal.ads.zzdss;
import com.google.android.gms.internal.ads.zzdsw;
import com.google.android.gms.internal.ads.zzeik;
import com.google.android.gms.internal.ads.zzeil;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;

final class zzeim
implements zzdkn {
    private final Context zza;
    private final zzdss zzb;
    private final zzfar zzc;
    private final zzcgz zzd;
    private final zzezz zze;
    private final zzfsm<zzdrx> zzf;
    private final zzcml zzg;
    private final zzbpu zzh;
    private final boolean zzi;

    zzeim(Context context, zzdss zzdss2, zzfar zzfar2, zzcgz zzcgz2, zzezz zzezz2, zzfsm<zzdrx> zzfsm2, zzcml zzcml2, zzbpu zzbpu2, boolean bl) {
        this.zza = context;
        this.zzb = zzdss2;
        this.zzc = zzfar2;
        this.zzd = zzcgz2;
        this.zze = zzezz2;
        this.zzf = zzfsm2;
        this.zzg = zzcml2;
        this.zzh = zzbpu2;
        this.zzi = bl;
    }

    public final void zza(boolean bl, Context context, zzdbp zzdbp2) {
        zzdsr zzdsr2;
        zzdsw zzdsw2;
        zzcml zzcml2;
        Object object;
        Object object2;
        zzdrx zzdrx2 = (zzdrx)zzfsd.zzr(this.zzf);
        try {
            object2 = this.zze;
            if (!this.zzg.zzaA()) {
                object = this.zzg;
            } else {
                object = zzbjl.zzay;
                if (!((Boolean)zzbet.zzc().zzc(object)).booleanValue()) {
                    object = this.zzg;
                } else {
                    zzcml2 = this.zzb.zzb(this.zzc.zze, null, null);
                    zzbqh.zzb((zzcml)zzcml2, (zzbqg)zzdrx2.zzk());
                    zzdsw2 = new zzdsw();
                    zzdsw2.zza(this.zza, (View)zzcml2);
                    zzdsr2 = zzdrx2.zzl();
                    object = this.zzi ? this.zzh : null;
                    zzdsr2.zzi(zzcml2, true, (zzbpu)object);
                    object = zzcml2.zzR();
                    zzdsr2 = new zzeik(zzdsw2, zzcml2);
                    object.zzy((zzcnx)zzdsr2);
                    zzcml2.zzR().zzz(zzeil.zza((zzcml)zzcml2));
                    object = object2.zzs;
                    zzcml2.zzat(object.zzb, object.zza, null);
                    object = zzcml2;
                }
            }
        }
        catch (zzcmw zzcmw2) {
            zzcgt.zzg((String)"", (Throwable)zzcmw2);
            return;
        }
        object.zzag(true);
        boolean bl2 = this.zzi ? this.zzh.zzc(false) : false;
        zzt.zzc();
        boolean bl3 = zzs.zzL((Context)this.zza);
        boolean bl4 = this.zzi ? this.zzh.zzd() : false;
        float f = this.zzi ? this.zzh.zze() : 0.0f;
        zzcml2 = this.zze;
        zzcml2 = new zzj(bl2, bl3, bl4, f, -1, bl, zzcml2.zzK, zzcml2.zzL);
        if (zzdbp2 != null) {
            zzdbp2.zze();
        }
        zzt.zzb();
        zzdrx2 = zzdrx2.zzj();
        zzdsr2 = this.zze;
        int n = zzdsr2.zzM;
        zzdsw2 = this.zzd;
        object2 = zzdsr2.zzB;
        zzdsr2 = zzdsr2.zzs;
        zzm.zza((Context)context, (AdOverlayInfoParcel)new AdOverlayInfoParcel(null, (zzo)zzdrx2, null, (zzcml)object, n, (zzcgz)zzdsw2, (String)object2, (zzj)zzcml2, zzdsr2.zzb, zzdsr2.zza, this.zzc.zzf, zzdbp2), (boolean)true);
    }
}
