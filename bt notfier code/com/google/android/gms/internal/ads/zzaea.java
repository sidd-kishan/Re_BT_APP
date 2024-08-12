/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzafy
 *  com.google.android.gms.internal.ads.zzahv
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzjg
 *  com.google.android.gms.internal.ads.zzko
 *  com.google.android.gms.internal.ads.zzs
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzafy;
import com.google.android.gms.internal.ads.zzahv;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzjg;
import com.google.android.gms.internal.ads.zzko;
import com.google.android.gms.internal.ads.zzs;

public final class zzaea
implements zzafy {
    private final zzko zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;
    private int zzg;
    private boolean zzh;

    public zzaea() {
        zzko zzko2 = new zzko(true, 65536);
        zzaea.zzk(2500, 0, "bufferForPlaybackMs", "0");
        zzaea.zzk(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzaea.zzk(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        zzaea.zzk(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzaea.zzk(50000, 50000, "maxBufferMs", "minBufferMs");
        zzaea.zzk(0, 0, "backBufferDurationMs", "0");
        this.zza = zzko2;
        this.zzb = zzadx.zzb((long)50000L);
        this.zzc = zzadx.zzb((long)50000L);
        this.zzd = zzadx.zzb((long)2500L);
        this.zze = zzadx.zzb((long)5000L);
        this.zzg = 0xC80000;
        this.zzf = zzadx.zzb((long)0L);
    }

    private final void zzj(boolean bl) {
        this.zzg = 0xC80000;
        this.zzh = false;
        if (!bl) return;
        this.zza.zza();
    }

    private static void zzk(int n, int n2, String string, String string2) {
        boolean bl = n >= n2;
        StringBuilder stringBuilder = new StringBuilder(string.length() + 21 + string2.length());
        stringBuilder.append(string);
        stringBuilder.append(" cannot be less than ");
        stringBuilder.append(string2);
        zzakt.zzb((boolean)bl, (Object)stringBuilder.toString());
    }

    public final void zza() {
        this.zzj(false);
    }

    public final void zzb() {
        this.zzj(true);
    }

    public final void zzc() {
        this.zzj(true);
    }

    public final long zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return false;
    }

    public final boolean zzf(long l, long l2, float f) {
        long l3;
        int n = this.zza.zzg();
        int n2 = this.zzg;
        l = l3 = this.zzb;
        if (f > 1.0f) {
            l = Math.min(zzamq.zzJ((long)l3, (float)f), this.zzc);
        }
        l = Math.max(l, 500000L);
        boolean bl = false;
        if (l2 < l) {
            if (n < n2) {
                bl = true;
            }
            this.zzh = bl;
            if (bl) return this.zzh;
            if (l2 >= 500000L) return this.zzh;
            Log.w((String)"DefaultLoadControl", (String)"Target buffer size reached with less than 500ms of buffered media data.");
        } else {
            if (l2 < this.zzc) {
                if (n < n2) return this.zzh;
            }
            this.zzh = false;
        }
        return this.zzh;
    }

    public final boolean zzg(long l, float f, boolean bl, long l2) {
        long l3 = zzamq.zzK((long)l, (float)f);
        l = bl ? this.zze : this.zzd;
        long l4 = l;
        if (l2 != -9223372036854775807L) {
            l4 = Math.min(l2 / 2L, l);
        }
        if (l4 <= 0L) return true;
        if (l3 >= l4) return true;
        if (this.zza.zzg() < this.zzg) return false;
        return true;
    }

    public final zzko zzh() {
        return this.zza;
    }

    public final void zzi(zzahv[] zzahvArray, zzs zzs2, zzjg[] zzjgArray) {
        int n = 0;
        int n2 = 0;
        while (true) {
            int n3 = 0xC80000;
            if (n >= 2) {
                this.zzg = n = Math.max(0xC80000, n2);
                this.zza.zzb(n);
                return;
            }
            int n4 = n2;
            if (zzjgArray[n] != null) {
                n4 = n3;
                if (zzahvArray[n].zzac() != 1) {
                    n4 = 0x7D00000;
                }
                n4 = n2 + n4;
            }
            ++n;
            n2 = n4;
        }
    }
}
