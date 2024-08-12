/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanr
 *  com.google.android.gms.internal.ads.zzatg
 *  com.google.android.gms.internal.ads.zzats
 *  com.google.android.gms.internal.ads.zzauc
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanr;
import com.google.android.gms.internal.ads.zzatg;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzauc;
import com.google.android.gms.internal.ads.zzave;

public final class zzcjy {
    private final zzauc zza = new zzauc(true, 65536);
    private long zzb = 15000000L;
    private long zzc = 30000000L;
    private long zzd = 2500000L;
    private long zze = 5000000L;
    private int zzf;
    private boolean zzg;

    zzcjy() {
    }

    public final void zza() {
        this.zzk(false);
    }

    public final void zzb(zzanr[] zzanrArray, zzatg zzatg2, zzats zzats2) {
        int n = 0;
        this.zzf = 0;
        while (true) {
            if (n >= 2) {
                this.zza.zzb(this.zzf);
                return;
            }
            if (zzats2.zza(n) != null) {
                this.zzf += zzave.zzq((int)zzanrArray[n].zza());
            }
            ++n;
        }
    }

    public final void zzc() {
        this.zzk(true);
    }

    public final void zzd() {
        this.zzk(true);
    }

    /*
     * Unable to fully structure code
     */
    public final boolean zze(long var1_1, boolean var3_2) {
        synchronized (this) {
            block4: {
                block5: {
                    if (!var3_2) ** GOTO lbl6
                    var4_3 = this.zze;
                    break block5;
lbl6:
                    // 1 sources

                    var4_3 = this.zzd;
                }
                if (var4_3 <= 0L || var1_1 >= var4_3) break block4;
                var3_2 = false;
lbl13:
                // 2 sources

                return var3_2;
            }
            var3_2 = true;
            ** continue;
        }
    }

    public final boolean zzf(long l) {
        synchronized (this) {
            long l2 = this.zzc;
            boolean bl = true;
            int n = l > l2 ? 0 : (l < this.zzb ? 2 : 1);
            int n2 = this.zza.zzg();
            int n3 = this.zzf;
            boolean bl2 = bl;
            if (n != 2) {
                bl2 = n == 1 && this.zzg && n2 < n3 ? bl : false;
            }
            this.zzg = bl2;
            return bl2;
        }
    }

    public final void zzg(int n) {
        synchronized (this) {
            long l = n;
            this.zzb = l * 1000L;
            return;
        }
    }

    public final void zzh(int n) {
        synchronized (this) {
            long l = n;
            this.zzc = l * 1000L;
            return;
        }
    }

    public final void zzi(int n) {
        synchronized (this) {
            long l = n;
            this.zzd = l * 1000L;
            return;
        }
    }

    public final void zzj(int n) {
        synchronized (this) {
            long l = n;
            this.zze = l * 1000L;
            return;
        }
    }

    final void zzk(boolean bl) {
        this.zzf = 0;
        this.zzg = false;
        if (!bl) return;
        this.zza.zza();
    }

    public final zzauc zzl() {
        return this.zza;
    }
}
