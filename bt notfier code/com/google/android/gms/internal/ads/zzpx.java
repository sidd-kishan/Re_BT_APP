/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzpw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzpw;

public final class zzpx
implements zznx {
    private final long zzb;
    private final zznx zzc;

    public zzpx(long l, zznx zznx2) {
        this.zzb = l;
        this.zzc = zznx2;
    }

    static /* synthetic */ long zza(zzpx zzpx2) {
        return zzpx2.zzb;
    }

    public final zzox zzB(int n, int n2) {
        return this.zzc.zzB(n, n2);
    }

    public final void zzC() {
        this.zzc.zzC();
    }

    public final void zzD(zzot zzot2) {
        this.zzc.zzD((zzot)new zzpw(this, zzot2));
    }
}
