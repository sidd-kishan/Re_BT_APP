/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzeag
 *  com.google.android.gms.internal.ads.zzeay
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzeag;
import com.google.android.gms.internal.ads.zzeay;
import com.google.android.gms.internal.ads.zzfsm;

final class zzeat
implements zzeay {
    private final zzeag zza;

    private zzeat(zzeag zzeag2) {
        this.zza = zzeag2;
    }

    static zzeay zza(zzeag zzeag2) {
        return new zzeat(zzeag2);
    }

    public final zzfsm zzb(zzcbj zzcbj2) {
        return this.zza.zzb(zzcbj2);
    }
}
