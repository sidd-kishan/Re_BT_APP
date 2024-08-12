/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.view.View
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzazj
 *  com.google.android.gms.internal.ads.zzcbz
 *  com.google.android.gms.internal.ads.zzcei
 *  com.google.android.gms.internal.ads.zzcfa
 *  com.google.android.gms.internal.ads.zzdbc
 *  com.google.android.gms.internal.ads.zzdhz
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzcbz;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzcfa;
import com.google.android.gms.internal.ads.zzdbc;
import com.google.android.gms.internal.ads.zzdhz;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzdks
implements zzdbc,
zzdhz {
    private final zzcei zza;
    private final Context zzb;
    private final zzcfa zzc;
    private final View zzd;
    private String zze;
    private final zzazj zzf;

    public zzdks(zzcei zzcei2, Context context, zzcfa zzcfa2, View view, zzazj zzazj2) {
        this.zza = zzcei2;
        this.zzb = context;
        this.zzc = zzcfa2;
        this.zzd = view;
        this.zzf = zzazj2;
    }

    public final void zzb() {
    }

    public final void zzd() {
        String string;
        this.zze = string = this.zzc.zzh(this.zzb);
        String string2 = String.valueOf(string);
        string = this.zzf == zzazj.zzh ? "/Rewarded" : "/Interstitial";
        string = string.length() != 0 ? string2.concat(string) : new String(string2);
        this.zze = string;
    }

    public final void zzh() {
        View view = this.zzd;
        if (view != null && this.zze != null) {
            this.zzc.zzi(view.getContext(), this.zze);
        }
        this.zza.zza(true);
    }

    public final void zzi() {
        this.zza.zza(false);
    }

    public final void zzj() {
    }

    @ParametersAreNonnullByDefault
    public final void zzk(zzcbz zzcbz2, String string, String string2) {
        if (!this.zzc.zzb(this.zzb)) return;
        try {
            string = this.zzc;
            string2 = this.zzb;
            string.zzr((Context)string2, string.zzl((Context)string2), this.zza.zzb(), zzcbz2.zzb(), zzcbz2.zzc());
            return;
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Remote Exception to get reward item.", (Throwable)remoteException);
        }
    }

    public final void zzl() {
    }

    public final void zzm() {
    }
}
