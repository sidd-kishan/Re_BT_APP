/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzdcl
 *  com.google.android.gms.internal.ads.zzdcm
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzeee
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzeek
 *  com.google.android.gms.internal.ads.zzehe
 *  com.google.android.gms.internal.ads.zzeiz
 *  com.google.android.gms.internal.ads.zzeja
 *  com.google.android.gms.internal.ads.zzejb
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfdw
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

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzdcl;
import com.google.android.gms.internal.ads.zzdcm;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzeee;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzeek;
import com.google.android.gms.internal.ads.zzehe;
import com.google.android.gms.internal.ads.zzeiz;
import com.google.android.gms.internal.ads.zzeja;
import com.google.android.gms.internal.ads.zzejb;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfdw;
import com.google.android.gms.internal.ads.zzfdx;
import com.google.android.gms.internal.ads.zzfed;
import com.google.android.gms.internal.ads.zzfek;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfes;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;

public final class zzejc<AdT, AdapterT, ListenerT extends zzdcm>
implements zzeec<AdT> {
    private final zzeee<AdapterT, ListenerT> zza;
    private final zzeek<AdT, AdapterT, ListenerT> zzb;
    private final zzfes zzc;
    private final zzfsn zzd;

    public zzejc(zzfes zzfes2, zzfsn zzfsn2, zzeee<AdapterT, ListenerT> zzeee2, zzeek<AdT, AdapterT, ListenerT> zzeek2) {
        this.zzc = zzfes2;
        this.zzd = zzfsn2;
        this.zzb = zzeek2;
        this.zza = zzeee2;
    }

    static final String zze(String string, int n) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 31);
        stringBuilder.append("Error from: ");
        stringBuilder.append(string);
        stringBuilder.append(", code: ");
        stringBuilder.append(n);
        return stringBuilder.toString();
    }

    public final boolean zza(zzfal zzfal2, zzezz zzezz2) {
        if (zzezz2.zzt.isEmpty()) return false;
        return true;
    }

    public final zzfsm<AdT> zzb(zzfal zzfal2, zzezz zzezz2) {
        zzfem zzfem2;
        String string2;
        block6: {
            for (String string2 : zzezz2.zzt) {
                try {
                    string2 = this.zza.zza(string2, zzezz2.zzv);
                    break block6;
                }
                catch (zzfaw zzfaw2) {
                }
            }
            string2 = null;
        }
        if (string2 == null) {
            return zzfsd.zzc((Throwable)new zzehe("Unable to instantiate mediation adapter class."));
        }
        zzchl zzchl2 = new zzchl();
        zzejb zzejb2 = new zzejb(this, (zzeef)string2, zzchl2);
        ((zzeef)string2).zzc.zza((zzdcl)zzejb2);
        if (zzezz2.zzI) {
            Bundle bundle = zzfal2.zza.zza.zzd.zzm;
            zzfem2 = bundle.getBundle(AdMobAdapter.class.getName());
            zzejb2 = zzfem2;
            if (zzfem2 == null) {
                zzejb2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), (Bundle)zzejb2);
            }
            zzejb2.putBoolean("render_test_ad_label", true);
        }
        zzejb2 = this.zzc;
        zzfem2 = zzfem.zzn;
        return zzfed.zzd((zzfdx)new zzeiz(this, zzfal2, zzezz2, (zzeef)string2), (zzfsn)this.zzd, (Object)zzfem2, (zzfek)zzejb2).zzj((Object)zzfem.zzo).zze((zzfsm)zzchl2).zzj((Object)zzfem.zzp).zzb((zzfdw)new zzeja(this, zzfal2, zzezz2, (zzeef)string2)).zzi();
    }

    final /* synthetic */ Object zzc(zzfal zzfal2, zzezz zzezz2, zzeef zzeef2, Void void_) throws Exception {
        return this.zzb.zzb(zzfal2, zzezz2, zzeef2);
    }

    final /* synthetic */ void zzd(zzfal zzfal2, zzezz zzezz2, zzeef zzeef2) throws Exception {
        this.zzb.zza(zzfal2, zzezz2, zzeef2);
    }
}
