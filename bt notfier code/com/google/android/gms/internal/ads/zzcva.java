/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaxq
 *  com.google.android.gms.internal.ads.zzayd
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcui
 *  com.google.android.gms.internal.ads.zzcxf
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdbp
 *  com.google.android.gms.internal.ads.zzdkm
 *  com.google.android.gms.internal.ads.zzdkn
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfit
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaxq;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcui;
import com.google.android.gms.internal.ads.zzcxf;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdbp;
import com.google.android.gms.internal.ads.zzdkm;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfit;

public final class zzcva
extends zzcxg {
    private final zzcml zzc;
    private final int zzd;
    private final Context zze;
    private final zzcui zzf;
    private final zzdkn zzg;
    private final zzdbp zzh;
    private boolean zzi = false;

    zzcva(zzcxf zzcxf2, Context context, zzcml zzcml2, int n, zzcui zzcui2, zzdkn zzdkn2, zzdbp zzdbp2) {
        super(zzcxf2);
        this.zzc = zzcml2;
        this.zze = context;
        this.zzd = n;
        this.zzf = zzcui2;
        this.zzg = zzdkn2;
        this.zzh = zzdbp2;
    }

    public final void zzT() {
        super.zzT();
        zzcml zzcml2 = this.zzc;
        if (zzcml2 == null) return;
        zzcml2.destroy();
    }

    public final void zza(zzaxq zzaxq2) {
        zzcml zzcml2 = this.zzc;
        if (zzcml2 == null) return;
        zzcml2.zzax(zzaxq2);
    }

    public final void zzb(Activity activity, zzayd zzayd2, boolean bl) throws RemoteException {
        Activity activity2 = activity;
        if (activity == null) {
            activity2 = this.zze;
        }
        activity = zzbjl.zzar;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)activity)).booleanValue()) {
            zzt.zzc();
            if (zzs.zzJ((Context)activity2)) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzh.zzd();
                activity = zzbjl.zzas;
                if ((Boolean)zzbet.zzc().zzc((zzbjd)activity) == false) return;
                new zzfit(activity2.getApplicationContext(), zzt.zzq().zza()).zza(this.zza.zzb.zzb.zzb);
                return;
            }
        }
        if (this.zzi) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"App open interstitial ad is already visible.");
            activity = zzbjl.zzgX;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)activity)).booleanValue()) {
                this.zzh.zza(zzfbm.zzd((int)10, null, null));
            }
        }
        if (this.zzi) return;
        try {
            this.zzg.zza(bl, (Context)activity2, this.zzh);
            this.zzi = true;
            return;
        }
        catch (zzdkm zzdkm2) {
            activity = zzbjl.zzgX;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)activity)).booleanValue()) {
                this.zzh.zzb(zzdkm2);
                return;
            }
            zzayd2.zze(zzfbm.zza((Throwable)zzdkm2));
        }
    }

    public final int zzc() {
        return this.zzd;
    }

    public final void zze(long l, int n) {
        this.zzf.zza(l, n);
    }
}
