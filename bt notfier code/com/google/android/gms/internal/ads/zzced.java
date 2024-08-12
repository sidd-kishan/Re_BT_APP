/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzbim
 *  com.google.android.gms.internal.ads.zzceb
 *  com.google.android.gms.internal.ads.zzcfb
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbim;
import com.google.android.gms.internal.ads.zzceb;
import com.google.android.gms.internal.ads.zzcfb;

public final class zzced {
    private final Clock zza;
    private final zzceb zzb;

    zzced(Clock clock, zzceb zzceb2) {
        this.zza = clock;
        this.zzb = zzceb2;
    }

    public static zzced zza(Context context) {
        return zzcfb.zzd((Context)context).zzb();
    }

    public final void zzb() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzc(zzbim zzbim2) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd(int n, long l) {
        this.zzb.zza(n, l);
    }

    public final void zze() {
        this.zzb.zzb();
    }
}
