/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzauj
 *  com.google.android.gms.internal.ads.zzauk
 *  com.google.android.gms.internal.ads.zzaul
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzauj;
import com.google.android.gms.internal.ads.zzauk;
import com.google.android.gms.internal.ads.zzaul;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzave;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class zzaun {
    private final ExecutorService zza = zzave.zzb((String)"Loader:ExtractorMediaPeriod");
    private zzauk<? extends zzaul> zzb;
    private IOException zzc;

    public zzaun(String string) {
    }

    static /* synthetic */ ExecutorService zza(zzaun zzaun2) {
        return zzaun2.zza;
    }

    static /* synthetic */ zzauk zzb(zzaun zzaun2) {
        return zzaun2.zzb;
    }

    static /* synthetic */ zzauk zzc(zzaun zzaun2, zzauk zzauk2) {
        zzaun2.zzb = zzauk2;
        return zzauk2;
    }

    static /* synthetic */ IOException zzd(zzaun zzaun2, IOException iOException) {
        zzaun2.zzc = iOException;
        return iOException;
    }

    public final <T extends zzaul> long zze(T t, zzauj<T> zzauj2, int n) {
        Looper looper = Looper.myLooper();
        boolean bl = looper != null;
        zzaup.zzd((boolean)bl);
        long l = SystemClock.elapsedRealtime();
        new zzauk(this, looper, t, zzauj2, n, l).zzb(0L);
        return l;
    }

    public final boolean zzf() {
        if (this.zzb == null) return false;
        return true;
    }

    public final void zzg() {
        this.zzb.zzc(false);
    }

    public final void zzh(Runnable runnable) {
        zzauk<? extends zzaul> zzauk2 = this.zzb;
        if (zzauk2 != null) {
            zzauk2.zzc(true);
        }
        this.zza.execute(runnable);
        this.zza.shutdown();
    }

    public final void zzi(int n) throws IOException {
        zzauk<? extends zzaul> zzauk2 = this.zzc;
        if (zzauk2 != null) throw zzauk2;
        zzauk2 = this.zzb;
        if (zzauk2 == null) return;
        zzauk2.zza(zzauk2.zza);
    }
}
