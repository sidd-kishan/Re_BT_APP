/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzeki
 *  com.google.android.gms.internal.ads.zzeqy
 *  com.google.android.gms.internal.ads.zzfrj
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzeki;
import com.google.android.gms.internal.ads.zzeqy;
import com.google.android.gms.internal.ads.zzfrj;
import com.google.android.gms.internal.ads.zzfsm;

final class zzeqv
implements zzfrj {
    private final zzeqy zza;
    private final String zzb;
    private final zzeki zzc;
    private final Bundle zzd;

    zzeqv(zzeqy zzeqy2, String string, zzeki zzeki2, Bundle bundle) {
        this.zza = zzeqy2;
        this.zzb = string;
        this.zzc = zzeki2;
        this.zzd = bundle;
    }

    public final zzfsm zza() {
        return this.zza.zzb(this.zzb, this.zzc, this.zzd);
    }
}
