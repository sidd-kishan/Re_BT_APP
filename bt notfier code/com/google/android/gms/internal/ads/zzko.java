/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzkb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzkb;
import java.util.Arrays;

public final class zzko {
    private final zzkb[] zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;
    private zzkb[] zze = new zzkb[100];

    public zzko(boolean bl, int n) {
        this.zza = new zzkb[1];
    }

    public final void zza() {
        synchronized (this) {
            this.zzb(0);
            return;
        }
    }

    public final void zzb(int n) {
        synchronized (this) {
            int n2 = this.zzb;
            this.zzb = n;
            if (n >= n2) return;
            this.zzf();
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final zzkb zzc() {
        synchronized (this) {
            ++this.zzc;
            int n = this.zzd;
            if (n <= 0) return new zzkb(new byte[65536], 0);
            zzkb[] zzkbArray = this.zze;
            {
                this.zzd = --n;
            }
            zzkb zzkb2 = zzkbArray[n];
            if (zzkb2 == null) throw null;
            zzkbArray[n] = null;
            return zzkb2;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void zzd(zzkb zzkb2) {
        synchronized (this) {
            zzkb[] zzkbArray = this.zza;
            zzkbArray[0] = zzkb2;
            {
                this.zze(zzkbArray);
                return;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void zze(zzkb[] zzkbArray) {
        synchronized (this) {
            int n;
            int n2 = this.zzd;
            int n3 = zzkbArray.length;
            int n4 = n2 + n3;
            zzkb[] zzkbArray2 = this.zze;
            int n5 = zzkbArray2.length;
            n2 = n = 0;
            if (n4 >= n5) {
                this.zze = Arrays.copyOf(zzkbArray2, Math.max(n5 + n5, n4));
                n2 = n;
            }
            while (n2 < n3) {
                zzkb zzkb2 = zzkbArray[n2];
                {
                    zzkbArray2 = this.zze;
                    n = this.zzd;
                    this.zzd = n + 1;
                    zzkbArray2[n] = zzkb2;
                    ++n2;
                }
            }
            {
                this.zzc -= zzkbArray.length;
                this.notifyAll();
                return;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzf() {
        synchronized (this) {
            int n = Math.max(0, zzamq.zzw((int)this.zzb, (int)65536) - this.zzc);
            int n2 = this.zzd;
            if (n >= n2) {
                return;
            }
            Arrays.fill(this.zze, n, n2, null);
            this.zzd = n;
            return;
        }
    }

    public final int zzg() {
        synchronized (this) {
            int n = this.zzc;
            return n * 65536;
        }
    }
}
