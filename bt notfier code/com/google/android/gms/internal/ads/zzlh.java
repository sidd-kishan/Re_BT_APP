/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzkz
 *  com.google.android.gms.internal.ads.zzla
 *  com.google.android.gms.internal.ads.zzlb
 *  com.google.android.gms.internal.ads.zzlc
 *  com.google.android.gms.internal.ads.zzle
 *  com.google.android.gms.internal.ads.zzlf
 */
package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzkz;
import com.google.android.gms.internal.ads.zzla;
import com.google.android.gms.internal.ads.zzlb;
import com.google.android.gms.internal.ads.zzlc;
import com.google.android.gms.internal.ads.zzle;
import com.google.android.gms.internal.ads.zzlf;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class zzlh {
    public static final zzla zza = new zzla(0, -9223372036854775807L, null);
    public static final zzla zzb = new zzla(1, -9223372036854775807L, null);
    public static final zzla zzc = new zzla(2, -9223372036854775807L, null);
    public static final zzla zzd = new zzla(3, -9223372036854775807L, null);
    private final ExecutorService zze = zzamq.zzl((String)"ExoPlayer:Loader:ProgressiveMediaPeriod");
    private zzlb<? extends zzlc> zzf;
    private IOException zzg;

    public zzlh(String string) {
    }

    static /* synthetic */ ExecutorService zza(zzlh zzlh2) {
        return zzlh2.zze;
    }

    static /* synthetic */ zzlb zzb(zzlh zzlh2) {
        return zzlh2.zzf;
    }

    static /* synthetic */ zzlb zzc(zzlh zzlh2, zzlb zzlb2) {
        zzlh2.zzf = zzlb2;
        return zzlb2;
    }

    static /* synthetic */ IOException zzd(zzlh zzlh2, IOException iOException) {
        zzlh2.zzg = iOException;
        return iOException;
    }

    public static zzla zze(boolean bl, long l) {
        return new zzla(bl ? 1 : 0, l, null);
    }

    public final boolean zzf() {
        if (this.zzg == null) return false;
        return true;
    }

    public final void zzg() {
        this.zzg = null;
    }

    public final <T extends zzlc> long zzh(T t, zzkz<T> zzkz2, int n) {
        Looper looper = Looper.myLooper();
        zzakt.zze((Object)looper);
        this.zzg = null;
        long l = SystemClock.elapsedRealtime();
        new zzlb(this, looper, t, zzkz2, n, l).zzb(0L);
        return l;
    }

    public final boolean zzi() {
        if (this.zzf == null) return false;
        return true;
    }

    public final void zzj() {
        zzlb<? extends zzlc> zzlb2 = this.zzf;
        zzakt.zze(zzlb2);
        zzlb2.zzc(false);
    }

    public final void zzk(zzle zzle2) {
        zzlb<? extends zzlc> zzlb2 = this.zzf;
        if (zzlb2 != null) {
            zzlb2.zzc(true);
        }
        this.zze.execute((Runnable)new zzlf(zzle2));
        this.zze.shutdown();
    }

    public final void zzl(int n) throws IOException {
        zzlb<? extends zzlc> zzlb2 = this.zzg;
        if (zzlb2 != null) throw zzlb2;
        zzlb2 = this.zzf;
        if (zzlb2 == null) return;
        zzlb2.zza(n);
    }
}
