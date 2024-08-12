/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgep
 *  com.google.android.gms.internal.ads.zzger
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzghx
 *  com.google.android.gms.internal.ads.zzghy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgep;
import com.google.android.gms.internal.ads.zzger;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzghx;
import com.google.android.gms.internal.ads.zzghy;
import java.util.NoSuchElementException;

final class zzghu
extends zzgep {
    final zzghx zza;
    zzger zzb;
    final zzghy zzc;

    zzghu(zzghy zzghy2) {
        this.zzc = zzghy2;
        this.zza = new zzghx((zzgex)this.zzc, null);
        this.zzb = this.zzb();
    }

    private final zzger zzb() {
        if (!this.zza.hasNext()) return null;
        return this.zza.zza().zzq();
    }

    public final boolean hasNext() {
        if (this.zzb == null) return false;
        return true;
    }

    public final byte zza() {
        zzger zzger2 = this.zzb;
        if (zzger2 == null) throw new NoSuchElementException();
        byte by = zzger2.zza();
        if (this.zzb.hasNext()) return by;
        this.zzb = this.zzb();
        return by;
    }
}
