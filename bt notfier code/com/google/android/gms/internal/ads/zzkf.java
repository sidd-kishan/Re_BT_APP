/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzkh
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.google.android.gms.internal.ads.zzkh;

final class zzkf {
    private final Handler zza;
    private final zzkh zzb;
    private boolean zzc;

    public zzkf(Handler handler, zzkh zzkh2) {
        this.zza = handler;
        this.zzb = zzkh2;
    }

    static /* synthetic */ Handler zza(zzkf zzkf2) {
        return zzkf2.zza;
    }

    static /* synthetic */ zzkh zzb(zzkf zzkf2) {
        return zzkf2.zzb;
    }

    static /* synthetic */ boolean zzc(zzkf zzkf2) {
        return zzkf2.zzc;
    }

    public final void zzd() {
        this.zzc = true;
    }
}
