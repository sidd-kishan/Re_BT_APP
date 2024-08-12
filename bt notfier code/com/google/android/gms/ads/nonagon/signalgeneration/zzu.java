/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzah
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzv
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zzah;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.internal.ads.zzfrz;

final class zzu
implements zzfrz<zzah> {
    final zzv zza;

    zzu(zzv zzv2) {
        this.zza = zzv2;
    }

    public final void zza(Throwable throwable) {
        zzt.zzg().zzk(throwable, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        zzv.zzy((zzv)this.zza, (String)"sgf", (String)"sgf_reason", (String)throwable.getMessage());
        zze.zzg((String)"Failed to initialize webview for loading SDKCore. ", (Throwable)throwable);
    }
}
