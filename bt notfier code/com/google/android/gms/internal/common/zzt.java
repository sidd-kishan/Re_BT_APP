/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.common.zzl
 *  com.google.android.gms.internal.common.zzu
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzl;
import com.google.android.gms.internal.common.zzu;

final class zzt
extends zzu {
    final transient int zza;
    final transient int zzb;
    final zzu zzc;

    zzt(zzu zzu2, int n, int n2) {
        this.zzc = zzu2;
        this.zza = n;
        this.zzb = n2;
    }

    public final Object get(int n) {
        zzl.zza((int)n, (int)this.zzb, (String)"index");
        return this.zzc.get(n + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

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

    public final zzu zzh(int n, int n2) {
        zzl.zzc((int)n, (int)n2, (int)this.zzb);
        zzu zzu2 = this.zzc;
        int n3 = this.zza;
        return zzu2.zzh(n + n3, n2 + n3);
    }
}
