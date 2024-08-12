/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzcdj
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcxf
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzcya
 *  com.google.android.gms.internal.ads.zzdbp
 *  com.google.android.gms.internal.ads.zzdcw
 *  com.google.android.gms.internal.ads.zzdhy
 *  com.google.android.gms.internal.ads.zzdkm
 *  com.google.android.gms.internal.ads.zzdkn
 *  com.google.android.gms.internal.ads.zzdrv
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfit
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzcdj;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcxf;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzcya;
import com.google.android.gms.internal.ads.zzdbp;
import com.google.android.gms.internal.ads.zzdcw;
import com.google.android.gms.internal.ads.zzdhy;
import com.google.android.gms.internal.ads.zzdkm;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzdrv;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfit;
import java.lang.ref.WeakReference;

public final class zzdrw
extends zzcxg {
    private final Context zzc;
    private final WeakReference<zzcml> zzd;
    private final zzdkn zze;
    private final zzdhy zzf;
    private final zzdbp zzg;
    private final zzdcw zzh;
    private final zzcya zzi;
    private final zzccp zzj;
    private final zzfit zzk;
    private boolean zzl = false;

    zzdrw(zzcxf object, Context context, zzcml zzcml2, zzdkn zzdkn2, zzdhy zzdhy2, zzdbp zzdbp2, zzdcw zzdcw2, zzcya zzcya2, zzezz zzezz2, zzfit zzfit2) {
        super(object);
        this.zzc = context;
        this.zze = zzdkn2;
        this.zzd = new WeakReference<zzcml>(zzcml2);
        this.zzf = zzdhy2;
        this.zzg = zzdbp2;
        this.zzh = zzdcw2;
        this.zzi = zzcya2;
        this.zzk = zzfit2;
        context = zzezz2.zzm;
        object = context != null ? context.zza : "";
        int n = context != null ? context.zzb : 1;
        this.zzj = new zzcdj((String)object, n);
    }

    public final void finalize() throws Throwable {
        try {
            zzcml zzcml2 = (zzcml)this.zzd.get();
            zzbjd zzbjd2 = zzbjl.zzeZ;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                if (this.zzl) return;
                if (zzcml2 == null) return;
                zzchg.zze.execute(zzdrv.zza((zzcml)zzcml2));
            } else {
                if (zzcml2 == null) return;
                zzcml2.destroy();
            }
            return;
        }
        finally {
            super.finalize();
        }
    }

    public final boolean zza(boolean bl, Activity activity) {
        zzbjd zzbjd2 = zzbjl.zzar;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zzt.zzc();
            if (zzs.zzJ((Context)this.zzc)) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzd();
                activity = zzbjl.zzas;
                if ((Boolean)zzbet.zzc().zzc((zzbjd)activity) == false) return false;
                this.zzk.zza(this.zza.zzb.zzb.zzb);
                return false;
            }
        }
        if (this.zzl) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"The rewarded ad have been showed.");
            this.zzg.zza(zzfbm.zzd((int)10, null, null));
            return false;
        }
        this.zzl = true;
        this.zzf.zza();
        zzbjd2 = activity;
        if (activity == null) {
            zzbjd2 = this.zzc;
        }
        try {
            this.zze.zza(bl, (Context)zzbjd2, this.zzg);
            this.zzf.zzb();
            return true;
        }
        catch (zzdkm zzdkm2) {
            this.zzg.zzb(zzdkm2);
            return false;
        }
    }

    public final boolean zzb() {
        return this.zzl;
    }

    public final zzccp zzc() {
        return this.zzj;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        zzcml zzcml2 = (zzcml)this.zzd.get();
        if (zzcml2 == null) return false;
        if (zzcml2.zzaA()) return false;
        return true;
    }

    public final Bundle zzg() {
        return this.zzh.zzb();
    }
}
