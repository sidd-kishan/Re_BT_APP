/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.overlay.zzv
 *  com.google.android.gms.internal.ads.zzdcj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.internal.ads.zzdcj;

final class zzdrl
implements zzv {
    private final zzdcj zza;

    private zzdrl(zzdcj zzdcj2) {
        this.zza = zzdcj2;
    }

    static zzv zza(zzdcj zzdcj2) {
        return new zzdrl(zzdcj2);
    }

    public final void zzg() {
        this.zza.zzb();
    }
}
