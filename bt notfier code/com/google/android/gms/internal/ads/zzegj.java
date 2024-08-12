/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzbx
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzdbp
 *  com.google.android.gms.internal.ads.zzdji
 *  com.google.android.gms.internal.ads.zzdkf
 *  com.google.android.gms.internal.ads.zzdkm
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzeek
 *  com.google.android.gms.internal.ads.zzefy
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfae
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfbi
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzdbp;
import com.google.android.gms.internal.ads.zzdji;
import com.google.android.gms.internal.ads.zzdkf;
import com.google.android.gms.internal.ads.zzdkm;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzeek;
import com.google.android.gms.internal.ads.zzefy;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfae;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfbi;
import java.util.concurrent.Executor;

public final class zzegj
implements zzeek<zzdji, zzfbi, zzefy> {
    private final Context zza;
    private final zzdkf zzb;
    private final zzcgz zzc;
    private final Executor zzd;

    public zzegj(Context context, zzcgz zzcgz2, zzdkf zzdkf2, Executor executor) {
        this.zza = context;
        this.zzc = zzcgz2;
        this.zzb = zzdkf2;
        this.zzd = executor;
    }

    public final void zza(zzfal zzfal2, zzezz zzezz2, zzeef<zzfbi, zzefy> zzeef2) throws zzfaw {
        ((zzfbi)zzeef2.zzb).zzh(this.zza, zzfal2.zza.zza.zzd, zzezz2.zzv.toString(), zzbx.zzl((zzfae)zzezz2.zzs), (zzbvm)zzeef2.zzc);
    }

    final /* synthetic */ void zzc(zzeef zzeef2, boolean bl, Context context, zzdbp zzdbp2) throws zzdkm {
        try {
            ((zzfbi)zzeef2.zzb).zzs(bl);
            int n = this.zzc.zzc;
            zzdbp2 = zzbjl.zzau;
            if (n < (Integer)zzbet.zzc().zzc((zzbjd)zzdbp2)) {
                ((zzfbi)zzeef2.zzb).zzd();
                return;
            }
            ((zzfbi)zzeef2.zzb).zze(context);
            return;
        }
        catch (zzfaw zzfaw2) {
            zze.zzh((String)"Cannot show interstitial.");
            throw new zzdkm(zzfaw2.getCause());
        }
    }
}
