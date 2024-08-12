/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbqg
 *  com.google.android.gms.internal.ads.zzcbw
 *  com.google.android.gms.internal.ads.zzcbz
 *  com.google.android.gms.internal.ads.zzccl
 *  com.google.android.gms.internal.ads.zzdcj
 *  com.google.android.gms.internal.ads.zzezz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqg;
import com.google.android.gms.internal.ads.zzcbw;
import com.google.android.gms.internal.ads.zzcbz;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzdcj;
import com.google.android.gms.internal.ads.zzezz;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzdrt
implements zzbqg {
    private final zzdcj zza;
    private final zzccl zzb;
    private final String zzc;
    private final String zzd;

    public zzdrt(zzdcj zzdcj2, zzezz zzezz2) {
        this.zza = zzdcj2;
        this.zzb = zzezz2.zzm;
        this.zzc = zzezz2.zzk;
        this.zzd = zzezz2.zzl;
    }

    public final void zza() {
        this.zza.zzd();
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzccl object) {
        int n;
        Object object2 = this.zzb;
        if (object2 != null) {
            object = object2;
        }
        if (object != null) {
            object2 = object.zza;
            n = object.zzb;
            object = object2;
        } else {
            n = 1;
            object = "";
        }
        object = new zzcbw((String)object, n);
        this.zza.zze((zzcbz)object, this.zzc, this.zzd);
    }

    public final void zzc() {
        this.zza.zzf();
    }
}
