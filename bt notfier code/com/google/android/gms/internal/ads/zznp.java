/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzah
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznv;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

public final class zznp
implements zznv {
    private final byte[] zza;
    private final zzah zzb;
    private final long zzc;
    private long zzd;
    private byte[] zze;
    private int zzf;
    private int zzg;

    public zznp(zzah zzah2, long l, long l2) {
        this.zzb = zzah2;
        this.zzd = l;
        this.zzc = l2;
        this.zze = new byte[65536];
        this.zza = new byte[4096];
    }

    private final void zzp(int n) {
        int n2 = this.zze.length;
        if ((n = this.zzf + n) <= n2) return;
        n = zzamq.zzx((int)(n2 + n2), (int)(65536 + n), (int)(n + 524288));
        this.zze = Arrays.copyOf(this.zze, n);
    }

    private final int zzq(int n) {
        n = Math.min(this.zzg, n);
        this.zzs(n);
        return n;
    }

    private final int zzr(byte[] byArray, int n, int n2) {
        int n3 = this.zzg;
        if (n3 == 0) {
            return 0;
        }
        n2 = Math.min(n3, n2);
        System.arraycopy(this.zze, 0, byArray, n, n2);
        this.zzs(n2);
        return n2;
    }

    private final void zzs(int n) {
        int n2;
        this.zzg = n2 = this.zzg - n;
        this.zzf = 0;
        byte[] byArray = this.zze;
        byte[] byArray2 = n2 < byArray.length - 524288 ? new byte[65536 + n2] : byArray;
        System.arraycopy(byArray, n, byArray2, 0, n2);
        this.zze = byArray2;
    }

    private final int zzt(byte[] byArray, int n, int n2, int n3, boolean bl) throws IOException {
        if (Thread.interrupted()) throw new InterruptedIOException();
        if ((n = this.zzb.zzg(byArray, n + n3, n2 - n3)) != -1) return n3 + n;
        if (n3 != 0) throw new EOFException();
        if (!bl) throw new EOFException();
        return -1;
    }

    private final void zzu(int n) {
        if (n == -1) return;
        this.zzd += (long)n;
    }

    public final boolean zza(byte[] byArray, int n, int n2, boolean bl) throws IOException {
        int n3 = this.zzr(byArray, n, n2);
        while (n3 < n2 && n3 != -1) {
            n3 = this.zzt(byArray, n, n2, n3, bl);
        }
        this.zzu(n3);
        if (n3 == -1) return false;
        return true;
    }

    public final void zzb(byte[] byArray, int n, int n2) throws IOException {
        this.zza(byArray, n, n2, false);
    }

    public final int zzc(int n) throws IOException {
        int n2;
        n = n2 = this.zzq(1);
        if (n2 == 0) {
            n = this.zzt(this.zza, 0, Math.min(1, 4096), 0, true);
        }
        this.zzu(n);
        return n;
    }

    public final boolean zzd(int n, boolean bl) throws IOException {
        int n2 = this.zzq(n);
        while (n2 < n && n2 != -1) {
            int n3 = Math.min(n, n2 + 4096);
            n2 = this.zzt(this.zza, -n2, n3, n2, false);
        }
        this.zzu(n2);
        if (n2 == -1) return false;
        return true;
    }

    public final void zze(int n) throws IOException {
        this.zzd(n, false);
    }

    public final int zzf(byte[] byArray, int n, int n2) throws IOException {
        this.zzp(n2);
        int n3 = this.zzg;
        int n4 = this.zzf;
        if ((n3 -= n4) == 0) {
            if ((n2 = this.zzt(this.zze, n4, n2, 0, true)) == -1) {
                return -1;
            }
            this.zzg += n2;
        } else {
            n2 = Math.min(n2, n3);
        }
        System.arraycopy(this.zze, this.zzf, byArray, n, n2);
        this.zzf += n2;
        return n2;
    }

    public final int zzg(byte[] byArray, int n, int n2) throws IOException {
        int n3;
        int n4 = n3 = this.zzr(byArray, n, n2);
        if (n3 == 0) {
            n4 = this.zzt(byArray, n, n2, 0, true);
        }
        this.zzu(n4);
        return n4;
    }

    public final boolean zzh(byte[] byArray, int n, int n2, boolean bl) throws IOException {
        if (!this.zzj(n2, bl)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - n2, byArray, n, n2);
        return true;
    }

    public final void zzi(byte[] byArray, int n, int n2) throws IOException {
        this.zzh(byArray, n, n2, false);
    }

    public final boolean zzj(int n, boolean bl) throws IOException {
        this.zzp(n);
        int n2 = this.zzg - this.zzf;
        while (true) {
            if (n2 >= n) {
                this.zzf += n;
                return true;
            }
            if ((n2 = this.zzt(this.zze, this.zzf, n, n2, bl)) == -1) {
                return false;
            }
            this.zzg = this.zzf + n2;
        }
    }

    public final void zzk(int n) throws IOException {
        this.zzj(n, false);
    }

    public final void zzl() {
        this.zzf = 0;
    }

    public final long zzm() {
        return this.zzd + (long)this.zzf;
    }

    public final long zzn() {
        return this.zzd;
    }

    public final long zzo() {
        return this.zzc;
    }
}
