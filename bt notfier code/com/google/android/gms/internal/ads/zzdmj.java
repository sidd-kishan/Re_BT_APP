/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbme
 *  com.google.android.gms.internal.ads.zzdly
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzdly;

public final class zzdmj {
    private zzbme zza;

    public zzdmj(zzdly zzdly2) {
        this.zza = zzdly2;
    }

    public final zzbme zza() {
        synchronized (this) {
            zzbme zzbme2 = this.zza;
            return zzbme2;
        }
    }

    public final void zzb(zzbme zzbme2) {
        synchronized (this) {
            this.zza = zzbme2;
            return;
        }
    }
}
