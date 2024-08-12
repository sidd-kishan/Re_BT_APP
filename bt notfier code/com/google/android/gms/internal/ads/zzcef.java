/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzceg
 *  com.google.android.gms.internal.ads.zzceh
 *  com.google.android.gms.internal.ads.zzcfa
 *  com.google.android.gms.internal.ads.zzcfb
 *  com.google.android.gms.internal.ads.zzgli
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzceg;
import com.google.android.gms.internal.ads.zzceh;
import com.google.android.gms.internal.ads.zzcfa;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.internal.ads.zzgli;

final class zzcef {
    private Context zza;
    private Clock zzb;
    private zzg zzc;
    private zzcfa zzd;

    private zzcef() {
    }

    /* synthetic */ zzcef(zzceg zzceg2) {
    }

    public final zzcef zza(Context context) {
        if (context == null) throw null;
        this.zza = context;
        return this;
    }

    public final zzcef zzb(Clock clock) {
        if (clock == null) throw null;
        this.zzb = clock;
        return this;
    }

    public final zzcef zzc(zzg zzg2) {
        this.zzc = zzg2;
        return this;
    }

    public final zzcef zzd(zzcfa zzcfa2) {
        this.zzd = zzcfa2;
        return this;
    }

    public final zzcfb zze() {
        zzgli.zzc((Object)this.zza, Context.class);
        zzgli.zzc((Object)this.zzb, Clock.class);
        zzgli.zzc((Object)this.zzc, zzg.class);
        zzgli.zzc((Object)this.zzd, zzcfa.class);
        return new zzceh(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
