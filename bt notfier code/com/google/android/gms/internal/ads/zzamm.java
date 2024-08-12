/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import java.util.Arrays;

public final class zzamm<V> {
    private long[] zza = new long[10];
    private V[] zzb = new Object[10];
    private int zzc;
    private int zzd;

    public zzamm() {
        this(10);
    }

    public zzamm(int n) {
    }

    private final V zzf() {
        boolean bl = this.zzd > 0;
        zzakt.zzd((boolean)bl);
        V[] VArray = this.zzb;
        int n = this.zzc;
        V v = VArray[n];
        VArray[n] = null;
        this.zzc = (n + 1) % VArray.length;
        --this.zzd;
        return v;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(long l, V v) {
        synchronized (this) {
            int n;
            int n2;
            int n3 = this.zzd;
            if (n3 > 0 && l <= this.zza[((n2 = this.zzc) + n3 - 1) % (n = this.zzb.length)]) {
                this.zzb();
            }
            if (this.zzd >= (n2 = this.zzb.length)) {
                n3 = n2 + n2;
                long[] lArray = new long[n3];
                Object[] objectArray = new Object[n3];
                n3 = this.zzc;
                System.arraycopy(this.zza, n3, lArray, 0, n2 -= n3);
                System.arraycopy(this.zzb, this.zzc, objectArray, 0, n2);
                n3 = this.zzc;
                if (n3 > 0) {
                    System.arraycopy(this.zza, 0, lArray, n2, n3);
                    System.arraycopy(this.zzb, 0, objectArray, n2, this.zzc);
                }
                this.zza = lArray;
                this.zzb = objectArray;
                this.zzc = 0;
            }
            n3 = this.zzc;
            n2 = this.zzd;
            V[] VArray = this.zzb;
            n3 = (n3 + n2) % VArray.length;
            this.zza[n3] = l;
            VArray[n3] = v;
            this.zzd = n2 + 1;
            return;
        }
    }

    public final void zzb() {
        synchronized (this) {
            this.zzc = 0;
            this.zzd = 0;
            Arrays.fill(this.zzb, null);
            return;
        }
    }

    public final int zzc() {
        synchronized (this) {
            int n = this.zzd;
            return n;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final V zzd() {
        synchronized (this) {
            int n = this.zzd;
            if (n == 0) {
                return null;
            }
            V v = this.zzf();
            return v;
        }
    }

    public final V zze(long l) {
        V v;
        synchronized (this) {
            v = null;
            while (this.zzd > 0) {
                if (l - this.zza[this.zzc] < 0L) {
                    break;
                }
                v = this.zzf();
            }
            return v;
        }
        return v;
    }
}
