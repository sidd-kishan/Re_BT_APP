/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.ads.internal.zzf
 *  com.google.android.gms.internal.ads.zzbkb
 *  com.google.android.gms.internal.ads.zzbkd
 *  com.google.android.gms.internal.ads.zzbkg
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzcvo
 *  com.google.android.gms.internal.ads.zzcwe
 *  com.google.android.gms.internal.ads.zzcxv
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzejf
 *  com.google.android.gms.internal.ads.zzejg
 *  com.google.android.gms.internal.ads.zzejh
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfaa
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfdx
 *  com.google.android.gms.internal.ads.zzfed
 *  com.google.android.gms.internal.ads.zzfek
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzfes
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.internal.ads.zzbkb;
import com.google.android.gms.internal.ads.zzbkd;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzcvo;
import com.google.android.gms.internal.ads.zzcwe;
import com.google.android.gms.internal.ads.zzcxv;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzejf;
import com.google.android.gms.internal.ads.zzejg;
import com.google.android.gms.internal.ads.zzejh;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfaa;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfdx;
import com.google.android.gms.internal.ads.zzfed;
import com.google.android.gms.internal.ads.zzfek;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfes;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;

public final class zzejj
implements zzeec<zzcvh> {
    private final Context zza;
    private final zzcwe zzb;
    private final zzbkg zzc;
    private final zzfsn zzd;
    private final zzfes zze;

    public zzejj(Context context, zzcwe zzcwe2, zzfes zzfes2, zzfsn zzfsn2, zzbkg zzbkg2) {
        this.zza = context;
        this.zzb = zzcwe2;
        this.zze = zzfes2;
        this.zzd = zzfsn2;
        this.zzc = zzbkg2;
    }

    public final boolean zza(zzfal zzfal2, zzezz zzezz2) {
        if (this.zzc == null) return false;
        zzfal2 = zzezz2.zzs;
        if (zzfal2 == null) return false;
        if (zzfal2.zza == null) return false;
        return true;
    }

    public final zzfsm<zzcvh> zzb(zzfal zzfal2, zzezz zzezz2) {
        zzejh zzejh2 = new zzejh(this, new View(this.zza), null, zzejf.zza, (zzfaa)zzezz2.zzu.get(0));
        zzfal2 = this.zzb.zzaa(new zzcxv(zzfal2, zzezz2, null), (zzcvo)zzejh2);
        zzejh2 = zzfal2.zzk();
        zzezz2 = zzezz2.zzs;
        zzbkb zzbkb2 = new zzbkb((zzf)zzejh2, zzezz2.zzb, zzezz2.zza);
        zzejh2 = this.zze;
        zzezz2 = zzfem.zzq;
        return zzfed.zzd((zzfdx)new zzejg(this, zzbkb2), (zzfsn)this.zzd, (Object)zzezz2, (zzfek)zzejh2).zzj((Object)zzfem.zzr).zze(zzfsd.zza((Object)zzfal2.zzh())).zzi();
    }

    final /* synthetic */ void zzc(zzbkb zzbkb2) throws Exception {
        this.zzc.zze((zzbkd)zzbkb2);
    }
}
