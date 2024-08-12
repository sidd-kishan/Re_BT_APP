/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.admanager.AdManagerAdView
 *  com.google.android.gms.internal.ads.zzbfn
 *  com.google.android.gms.internal.ads.zzbon
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbon;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbom
implements Runnable {
    final AdManagerAdView zza;
    final zzbfn zzb;
    final zzbon zzc;

    zzbom(zzbon zzbon2, AdManagerAdView adManagerAdView, zzbfn zzbfn2) {
        this.zzc = zzbon2;
        this.zza = adManagerAdView;
        this.zzb = zzbfn2;
    }

    @Override
    public final void run() {
        if (this.zza.zza(this.zzb)) {
            zzbon.zzc((zzbon)this.zzc).onAdManagerAdViewLoaded(this.zza);
            return;
        }
        zzcgt.zzi((String)"Could not bind.");
    }
}
