/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzain
 *  com.google.android.gms.internal.ads.zzaip
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzd
 *  com.google.android.gms.internal.ads.zzgz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzain;
import com.google.android.gms.internal.ads.zzaip;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzd;
import com.google.android.gms.internal.ads.zzgz;

public final class zzha
extends zzaiq {
    private final zzagk zza;

    public zzha(zzagk zzagk2) {
        this.zza = zzagk2;
    }

    public final int zza() {
        return 1;
    }

    public final zzaip zzf(int n, zzaip zzaip2, long l) {
        zzaip2.zza(zzaip.zza, this.zza, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
        zzaip2.zzk = true;
        return zzaip2;
    }

    public final int zzg() {
        return 1;
    }

    public final zzain zzh(int n, zzain zzain2, boolean bl) {
        Object object = null;
        Integer n2 = bl ? Integer.valueOf(0) : null;
        if (bl) {
            object = zzgz.zzb;
        }
        zzain2.zza((Object)n2, object, 0, -9223372036854775807L, 0L, zzd.zza, true);
        return zzain2;
    }

    public final int zzi(Object object) {
        if (object != zzgz.zzb) return -1;
        return 0;
    }

    public final Object zzj(int n) {
        return zzgz.zzb;
    }
}
