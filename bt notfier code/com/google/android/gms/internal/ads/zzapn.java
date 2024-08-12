/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzatz
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzave;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class zzapn {
    private static final byte[] zza = new byte[4096];
    private final zzatz zzb;
    private final long zzc;
    private long zzd;
    private byte[] zze;
    private int zzf;
    private int zzg;

    public zzapn(zzatz zzatz2, long l, long l2) {
        this.zzb = zzatz2;
        this.zzd = l;
        this.zzc = l2;
        this.zze = new byte[65536];
    }

    private final int zzj(int n) {
        n = Math.min(this.zzg, n);
        this.zzl(n);
        return n;
    }

    private final int zzk(byte[] byArray, int n, int n2) {
        int n3 = this.zzg;
        if (n3 == 0) {
            return 0;
        }
        n2 = Math.min(n3, n2);
        System.arraycopy(this.zze, 0, byArray, n, n2);
        this.zzl(n2);
        return n2;
    }

    private final void zzl(int n) {
        int n2;
        this.zzg = n2 = this.zzg - n;
        this.zzf = 0;
        byte[] byArray = this.zze;
        byte[] byArray2 = n2 < byArray.length - 524288 ? new byte[65536 + n2] : byArray;
        System.arraycopy(byArray, n, byArray2, 0, n2);
        this.zze = byArray2;
    }

    private final int zzm(byte[] byArray, int n, int n2, int n3, boolean bl) throws InterruptedException, IOException {
        if (Thread.interrupted()) throw new InterruptedException();
        if ((n = this.zzb.zzb(byArray, n + n3, n2 - n3)) != -1) return n3 + n;
        if (n3 != 0) throw new EOFException();
        if (!bl) throw new EOFException();
        return -1;
    }

    private final void zzn(int n) {
        if (n == -1) return;
        this.zzd += (long)n;
    }

    public final int zza(byte[] byArray, int n, int n2) throws IOException, InterruptedException {
        int n3;
        int n4 = n3 = this.zzk(byArray, n, n2);
        if (n3 == 0) {
            n4 = this.zzm(byArray, n, n2, 0, true);
        }
        this.zzn(n4);
        return n4;
    }

    public final boolean zzb(byte[] byArray, int n, int n2, boolean bl) throws IOException, InterruptedException {
        int n3 = this.zzk(byArray, n, n2);
        while (n3 < n2 && n3 != -1) {
            n3 = this.zzm(byArray, n, n2, n3, bl);
        }
        this.zzn(n3);
        if (n3 == -1) return false;
        return true;
    }

    public final int zzc(int n) throws IOException, InterruptedException {
        int n2;
        int n3 = n2 = this.zzj(n);
        if (n2 == 0) {
            n3 = this.zzm(zza, 0, Math.min(n, 4096), 0, true);
        }
        this.zzn(n3);
        return n3;
    }

    public final boolean zzd(int n, boolean bl) throws IOException, InterruptedException {
        int n2 = this.zzj(n);
        while (n2 < n && n2 != -1) {
            n2 = this.zzm(zza, -n2, Math.min(n, n2 + 4096), n2, false);
        }
        this.zzn(n2);
        if (n2 == -1) return false;
        return true;
    }

    public final boolean zze(byte[] byArray, int n, int n2, boolean bl) throws IOException, InterruptedException {
        if (!this.zzf(n2, false)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - n2, byArray, n, n2);
        return true;
    }

    public final boolean zzf(int n, boolean bl) throws IOException, InterruptedException {
        int n2 = this.zzf + n;
        int n3 = this.zze.length;
        if (n2 > n3) {
            n2 = zzave.zzf((int)(n3 + n3), (int)(65536 + n2), (int)(n2 + 524288));
            this.zze = Arrays.copyOf(this.zze, n2);
        }
        n2 = Math.min(this.zzg - this.zzf, n);
        do {
            if (n2 >= n) {
                this.zzf = n = this.zzf + n;
                this.zzg = Math.max(this.zzg, n);
                return true;
            }
            n2 = n3 = this.zzm(this.zze, this.zzf, n, n2, false);
        } while (n3 != -1);
        return false;
    }

    public final void zzg() {
        this.zzf = 0;
    }

    public final long zzh() {
        return this.zzd;
    }

    public final long zzi() {
        return this.zzc;
    }
}
