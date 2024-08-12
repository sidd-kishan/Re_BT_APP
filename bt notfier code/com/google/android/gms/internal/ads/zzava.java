/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzamx
 *  com.google.android.gms.internal.ads.zzanq
 *  com.google.android.gms.internal.ads.zzaut
 */
package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzamx;
import com.google.android.gms.internal.ads.zzanq;
import com.google.android.gms.internal.ads.zzaut;

public final class zzava
implements zzaut {
    private boolean zza;
    private long zzb;
    private long zzc;
    private zzanq zzd = zzanq.zza;

    public final long zzP() {
        long l;
        long l2 = l = this.zzb;
        if (!this.zza) return l2;
        l2 = SystemClock.elapsedRealtime() - this.zzc;
        zzanq zzanq2 = this.zzd;
        l2 = zzanq2.zzb == 1.0f ? zzamx.zzb((long)l2) : zzanq2.zza(l2);
        l2 = l + l2;
        return l2;
    }

    public final zzanq zzQ(zzanq zzanq2) {
        if (this.zza) {
            this.zzc(this.zzP());
        }
        this.zzd = zzanq2;
        return zzanq2;
    }

    public final zzanq zzR() {
        throw null;
    }

    public final void zza() {
        if (this.zza) return;
        this.zzc = SystemClock.elapsedRealtime();
        this.zza = true;
    }

    public final void zzb() {
        if (!this.zza) return;
        this.zzc(this.zzP());
        this.zza = false;
    }

    public final void zzc(long l) {
        this.zzb = l;
        if (!this.zza) return;
        this.zzc = SystemClock.elapsedRealtime();
    }

    public final void zzd(zzaut zzaut2) {
        this.zzc(zzaut2.zzP());
        this.zzd = zzaut2.zzR();
    }
}
