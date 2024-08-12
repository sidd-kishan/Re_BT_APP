/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzf
 *  com.google.android.gms.internal.ads.zzbkb
 *  com.google.android.gms.internal.ads.zzbkd
 *  com.google.android.gms.internal.ads.zzbkg
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzejm
 *  com.google.android.gms.internal.ads.zzejn
 *  com.google.android.gms.internal.ads.zzejt
 *  com.google.android.gms.internal.ads.zzejx
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfdx
 *  com.google.android.gms.internal.ads.zzfed
 *  com.google.android.gms.internal.ads.zzfek
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzfes
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.internal.ads.zzbkb;
import com.google.android.gms.internal.ads.zzbkd;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzejm;
import com.google.android.gms.internal.ads.zzejn;
import com.google.android.gms.internal.ads.zzejt;
import com.google.android.gms.internal.ads.zzejx;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfdx;
import com.google.android.gms.internal.ads.zzfed;
import com.google.android.gms.internal.ads.zzfek;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfes;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;

public final class zzejo<AdT>
implements zzeec<AdT> {
    private final zzbkg zza;
    private final zzfsn zzb;
    private final zzfes zzc;
    private final zzejx zzd;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zzejo(zzfes zzfes2, zzfsn zzfsn2, zzbkg zzbkg2, zzejx zzejx2, byte[] byArray) {
        this.zzc = zzfes2;
        this.zzb = zzfsn2;
        this.zza = zzbkg2;
        this.zzd = zzejx2;
    }

    static /* synthetic */ zzejx zzd(zzejo zzejo2) {
        return zzejo2.zzd;
    }

    public final boolean zza(zzfal zzfal2, zzezz zzezz2) {
        if (this.zza == null) return false;
        zzfal2 = zzezz2.zzs;
        if (zzfal2 == null) return false;
        if (zzfal2.zza == null) return false;
        return true;
    }

    public final zzfsm<AdT> zzb(zzfal zzfal2, zzezz zzezz2) {
        zzchl zzchl2 = new zzchl();
        zzejt zzejt2 = new zzejt();
        zzejt2.zzd((zzf)new zzejn(this, zzchl2, zzfal2, zzezz2, zzejt2));
        zzfal2 = zzezz2.zzs;
        zzejt2 = new zzbkb((zzf)zzejt2, zzfal2.zzb, zzfal2.zza);
        zzfal2 = this.zzc;
        zzezz2 = zzfem.zzq;
        return zzfed.zzd((zzfdx)new zzejm(this, (zzbkb)zzejt2), (zzfsn)this.zzb, (Object)zzezz2, (zzfek)zzfal2).zzj((Object)zzfem.zzr).zze((zzfsm)zzchl2).zzi();
    }

    final /* synthetic */ void zzc(zzbkb zzbkb2) throws Exception {
        this.zza.zze((zzbkd)zzbkb2);
    }
}
