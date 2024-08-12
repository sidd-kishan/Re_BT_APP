/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzatw
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzatw;
import com.google.android.gms.internal.ads.zzave;
import java.util.Arrays;

public final class zzauc {
    private final zzatw[] zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;
    private zzatw[] zze = new zzatw[100];

    public zzauc(boolean bl, int n) {
        this.zza = new zzatw[1];
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
    public final zzatw zzc() {
        synchronized (this) {
            ++this.zzc;
            int n = this.zzd;
            if (n <= 0) return new zzatw(new byte[65536], 0);
            zzatw[] zzatwArray = this.zze;
            {
                this.zzd = --n;
            }
            zzatw zzatw2 = zzatwArray[n];
            zzatwArray[n] = null;
            return zzatw2;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void zzd(zzatw zzatw2) {
        synchronized (this) {
            zzatw[] zzatwArray = this.zza;
            zzatwArray[0] = zzatw2;
            {
                this.zze(zzatwArray);
                return;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void zze(zzatw[] zzatwArray) {
        synchronized (this) {
            int n;
            int n2 = this.zzd;
            int n3 = zzatwArray.length;
            int n4 = n2 + n3;
            zzatw zzatw2 = this.zze;
            int n5 = ((zzatw[])zzatw2).length;
            n2 = n = 0;
            if (n4 >= n5) {
                this.zze = (zzatw[])Arrays.copyOf(zzatw2, Math.max(n5 + n5, n4));
                n2 = n;
            }
            while (n2 < n3) {
                zzatw2 = zzatwArray[n2];
                {
                    Object[] objectArray = zzatw2.zza;
                    objectArray = this.zze;
                    n = this.zzd;
                    this.zzd = n + 1;
                }
                objectArray[n] = (byte)zzatw2;
                ++n2;
            }
            {
                this.zzc -= zzatwArray.length;
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
            int n = Math.max(0, zzave.zze((int)this.zzb, (int)65536) - this.zzc);
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
