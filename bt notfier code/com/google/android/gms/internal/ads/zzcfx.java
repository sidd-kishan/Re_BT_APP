/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzcfy
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzcfy;

final class zzcfx {
    final zzcfy zza;
    private long zzb;
    private long zzc;

    public zzcfx(zzcfy zzcfy2) {
        this.zza = zzcfy2;
        this.zzb = -1L;
        this.zzc = -1L;
    }

    public final long zza() {
        return this.zzc;
    }

    public final void zzb() {
        this.zzc = zzcfy.zza((zzcfy)this.zza).elapsedRealtime();
    }

    public final void zzc() {
        this.zzb = zzcfy.zza((zzcfy)this.zza).elapsedRealtime();
    }

    public final Bundle zzd() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzb);
        bundle.putLong("tclose", this.zzc);
        return bundle;
    }
}
