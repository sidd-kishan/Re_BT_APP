/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzahf
 *  com.google.android.gms.internal.ads.zzaku
 *  com.google.android.gms.internal.ads.zzalp
 */
package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzahf;
import com.google.android.gms.internal.ads.zzaku;
import com.google.android.gms.internal.ads.zzalp;

public final class zzamh
implements zzalp {
    private final zzaku zza;
    private boolean zzb;
    private long zzc;
    private long zzd;
    private zzahf zze;

    public zzamh(zzaku zzaku2) {
        this.zza = zzaku2;
        this.zze = zzahf.zza;
    }

    public final zzahf zzA() {
        return this.zze;
    }

    public final void zza() {
        if (this.zzb) return;
        this.zzd = SystemClock.elapsedRealtime();
        this.zzb = true;
    }

    public final void zzb() {
        if (!this.zzb) return;
        this.zzc(this.zzy());
        this.zzb = false;
    }

    public final void zzc(long l) {
        this.zzc = l;
        if (!this.zzb) return;
        this.zzd = SystemClock.elapsedRealtime();
    }

    public final long zzy() {
        long l;
        long l2 = l = this.zzc;
        if (!this.zzb) return l2;
        l2 = SystemClock.elapsedRealtime() - this.zzd;
        zzahf zzahf2 = this.zze;
        l2 = zzahf2.zzb == 1.0f ? zzadx.zzb((long)l2) : zzahf2.zza(l2);
        l2 = l + l2;
        return l2;
    }

    public final void zzz(zzahf zzahf2) {
        if (this.zzb) {
            this.zzc(this.zzy());
        }
        this.zze = zzahf2;
    }
}
