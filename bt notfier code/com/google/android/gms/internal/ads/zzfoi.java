/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflx
 *  com.google.android.gms.internal.ads.zzfoj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfoj;
import javax.annotation.CheckForNull;

final class zzfoi
extends zzfoj {
    final transient int zza;
    final transient int zzb;
    final zzfoj zzc;

    zzfoi(zzfoj zzfoj2, int n, int n2) {
        this.zzc = zzfoj2;
        this.zza = n;
        this.zzb = n2;
    }

    public final Object get(int n) {
        zzflx.zze((int)n, (int)this.zzb, (String)"index");
        return this.zzc.get(n + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    @CheckForNull
    final Object[] zzb() {
        return this.zzc.zzb();
    }

    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    final boolean zzf() {
        return true;
    }

    public final zzfoj zzh(int n, int n2) {
        zzflx.zzg((int)n, (int)n2, (int)this.zzb);
        zzfoj zzfoj2 = this.zzc;
        int n3 = this.zza;
        return zzfoj2.zzh(n + n3, n2 + n3);
    }
}
