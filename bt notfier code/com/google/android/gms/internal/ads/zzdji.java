/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcxf
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzcya
 *  com.google.android.gms.internal.ads.zzdbp
 *  com.google.android.gms.internal.ads.zzdhy
 *  com.google.android.gms.internal.ads.zzdjh
 *  com.google.android.gms.internal.ads.zzdkm
 *  com.google.android.gms.internal.ads.zzdkn
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfit
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcxf;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzcya;
import com.google.android.gms.internal.ads.zzdbp;
import com.google.android.gms.internal.ads.zzdhy;
import com.google.android.gms.internal.ads.zzdjh;
import com.google.android.gms.internal.ads.zzdkm;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfit;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

public final class zzdji
extends zzcxg {
    private final Context zzc;
    private final WeakReference<zzcml> zzd;
    private final zzdhy zze;
    private final zzdkn zzf;
    private final zzcya zzg;
    private final zzfit zzh;
    private final zzdbp zzi;
    private boolean zzj = false;

    zzdji(zzcxf zzcxf2, Context context, @Nullable zzcml zzcml2, zzdhy zzdhy2, zzdkn zzdkn2, zzcya zzcya2, zzfit zzfit2, zzdbp zzdbp2) {
        super(zzcxf2);
        this.zzc = context;
        this.zzd = new WeakReference<zzcml>(zzcml2);
        this.zze = zzdhy2;
        this.zzf = zzdkn2;
        this.zzg = zzcya2;
        this.zzh = zzfit2;
        this.zzi = zzdbp2;
    }

    public final void finalize() throws Throwable {
        try {
            zzcml zzcml2 = (zzcml)this.zzd.get();
            zzbjd zzbjd2 = zzbjl.zzeZ;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                if (this.zzj) return;
                if (zzcml2 == null) return;
                zzchg.zze.execute(zzdjh.zza((zzcml)zzcml2));
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

    /*
     * Enabled force condition propagation
     */
    public final boolean zza(boolean bl, @Nullable Activity activity) {
        zzbjd zzbjd2 = zzbjl.zzar;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zzt.zzc();
            if (zzs.zzJ((Context)this.zzc)) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzi.zzd();
                activity = zzbjl.zzas;
                if ((Boolean)zzbet.zzc().zzc((zzbjd)activity) == false) return false;
                this.zzh.zza(this.zza.zzb.zzb.zzb);
                return false;
            }
        }
        zzbjd2 = zzbjl.zzgX;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && this.zzj) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"The interstitial ad has been showed.");
            this.zzi.zza(zzfbm.zzd((int)10, null, null));
        }
        if (this.zzj) return false;
        this.zze.zza();
        zzbjd2 = activity;
        if (activity == null) {
            zzbjd2 = this.zzc;
        }
        try {
            this.zzf.zza(bl, (Context)zzbjd2, this.zzi);
            this.zze.zzb();
            this.zzj = true;
            return true;
        }
        catch (zzdkm zzdkm2) {
            this.zzi.zzb(zzdkm2);
        }
        return false;
    }

    public final boolean zzb() {
        return this.zzg.zzg();
    }
}
