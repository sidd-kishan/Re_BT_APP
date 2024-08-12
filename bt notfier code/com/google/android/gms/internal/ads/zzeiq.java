/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzeir
 *  com.google.android.gms.internal.ads.zzeit
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzeir;
import com.google.android.gms.internal.ads.zzeit;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;

final class zzeiq
implements Runnable {
    private final zzeir zza;
    private final zzfal zzb;
    private final zzezz zzc;
    private final zzeef zzd;

    zzeiq(zzeir zzeir2, zzfal zzfal2, zzezz zzezz2, zzeef zzeef2) {
        this.zza = zzeir2;
        this.zzb = zzfal2;
        this.zzc = zzezz2;
        this.zzd = zzeef2;
    }

    @Override
    public final void run() {
        zzeir zzeir2 = this.zza;
        zzfal zzfal2 = this.zzb;
        zzezz zzezz2 = this.zzc;
        zzeef zzeef2 = this.zzd;
        zzeit.zzd((zzeit)zzeir2.zzd, (zzfal)zzfal2, (zzezz)zzezz2, (zzeef)zzeef2);
    }
}
