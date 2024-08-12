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

final class zzfqb
extends zzfoj<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzfqb(Object[] objectArray, int n, int n2) {
        this.zza = objectArray;
        this.zzb = n;
        this.zzc = n2;
    }

    public final Object get(int n) {
        zzflx.zze((int)n, (int)this.zzc, (String)"index");
        Object object = this.zza[n + n + this.zzb];
        object.getClass();
        return object;
    }

    public final int size() {
        return this.zzc;
    }

    final boolean zzf() {
        return true;
    }
}
