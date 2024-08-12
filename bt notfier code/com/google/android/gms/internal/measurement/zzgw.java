/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzge
 *  com.google.android.gms.internal.measurement.zzgi
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzgx
 *  com.google.android.gms.internal.measurement.zzgy
 *  com.google.android.gms.internal.measurement.zzkf
 *  com.google.android.gms.internal.measurement.zzkj
 *  com.google.android.gms.internal.measurement.zzkk
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzgx;
import com.google.android.gms.internal.measurement.zzgy;
import com.google.android.gms.internal.measurement.zzkf;
import com.google.android.gms.internal.measurement.zzkj;
import com.google.android.gms.internal.measurement.zzkk;
import java.io.IOException;

final class zzgw
extends zzgy {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    zzgw(byte[] byArray, int n, int n2) {
        super(null);
        n = byArray.length;
        if ((n - n2 | n2) < 0) throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", n, 0, n2));
        this.zzb = byArray;
        this.zzd = 0;
        this.zzc = n2;
    }

    public final void zza(int n, int n2) throws IOException {
        this.zzl(n << 3 | n2);
    }

    public final void zzb(int n, int n2) throws IOException {
        this.zzl(n << 3);
        this.zzk(n2);
    }

    public final void zzc(int n, int n2) throws IOException {
        this.zzl(n << 3);
        this.zzl(n2);
    }

    public final void zzd(int n, int n2) throws IOException {
        this.zzl(n << 3 | 5);
        this.zzm(n2);
    }

    public final void zze(int n, long l) throws IOException {
        this.zzl(n << 3);
        this.zzn(l);
    }

    public final void zzf(int n, long l) throws IOException {
        this.zzl(n << 3 | 1);
        this.zzo(l);
    }

    public final void zzg(int n, boolean bl) throws IOException {
        this.zzl(n << 3);
        this.zzj((byte)(bl ? 1 : 0));
    }

    public final void zzh(int n, String string) throws IOException {
        this.zzl(n << 3 | 2);
        this.zzr(string);
    }

    public final void zzi(int n, zzgr zzgr2) throws IOException {
        this.zzl(n << 3 | 2);
        this.zzl(zzgr2.zzc());
        zzgr2.zzf((zzgi)this);
    }

    public final void zzj(byte by) throws IOException {
        try {
            byte[] byArray = this.zzb;
            int n = this.zzd;
            this.zzd = n + 1;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new zzgx(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), (Throwable)indexOutOfBoundsException);
        }
        byArray[n] = by;
    }

    public final void zzk(int n) throws IOException {
        if (n >= 0) {
            this.zzl(n);
            return;
        }
        this.zzn(n);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public final void zzl(int var1_1) throws IOException {
        var2_2 = var1_1;
        if (zzgy.zzF()) {
            var2_2 = zzge.zza;
            var2_2 = var1_1;
        }
        while (true) {
            if ((var2_2 & -128) != 0) ** GOTO lbl-1000
            try {
                var3_3 = this.zzb;
                var1_1 = this.zzd;
                this.zzd = var1_1 + 1;
            }
            catch (IndexOutOfBoundsException var3_4) {
                var3_5 = new zzgx(String.format("Pos: %d, limit: %d, len: %d", new Object[]{this.zzd, this.zzc, 1}), (Throwable)var3_4);
                throw var3_5;
            }
            var3_3[var1_1] = (byte)var2_2;
            return;
lbl-1000:
            // 1 sources

            {
                var3_3 = this.zzb;
                var1_1 = this.zzd;
                this.zzd = var1_1 + 1;
            }
            var3_3[var1_1] = (byte)(var2_2 & 127 | 128);
            var2_2 >>>= 7;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void zzm(int n) throws IOException {
        int n2;
        int n3;
        try {
            byte[] byArray = this.zzb;
            n3 = this.zzd;
            this.zzd = n2 = n3 + 1;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new zzgx(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), (Throwable)indexOutOfBoundsException);
        }
        byArray[n3] = (byte)(n & 0xFF);
        n3 = n2 + 1;
        {
            this.zzd = n3;
        }
        byArray[n2] = (byte)(n >> 8 & 0xFF);
        n2 = n3 + 1;
        {
            this.zzd = n2;
        }
        byArray[n3] = (byte)(n >> 16 & 0xFF);
        {
            this.zzd = n2 + 1;
        }
        byArray[n2] = (byte)(n >> 24 & 0xFF);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public final void zzn(long var1_1) throws IOException {
        var4_2 = var1_1;
        if (zzgy.zzF()) {
            var4_2 = var1_1;
            if (this.zzc - this.zzd >= 10) {
                while (true) {
                    if ((var1_1 & -128L) == 0L) {
                        var6_5 = this.zzb;
                        var3_3 = this.zzd;
                        this.zzd = var3_3 + 1;
                        zzkf.zzp((byte[])var6_5, (long)var3_3, (byte)((byte)var1_1));
                        return;
                    }
                    var6_5 = this.zzb;
                    var3_3 = this.zzd;
                    this.zzd = var3_3 + 1;
                    zzkf.zzp((byte[])var6_5, (long)var3_3, (byte)((byte)((int)var1_1 & 127 | 128)));
                    var1_1 >>>= 7;
                }
            }
        }
        while (true) {
            if ((var4_2 & -128L) != 0L) ** GOTO lbl-1000
            try {
                var6_6 = this.zzb;
                var3_4 = this.zzd;
                this.zzd = var3_4 + 1;
            }
            catch (IndexOutOfBoundsException var6_7) {
                var6_8 = new zzgx(String.format("Pos: %d, limit: %d, len: %d", new Object[]{this.zzd, this.zzc, 1}), (Throwable)var6_7);
                throw var6_8;
            }
            var6_6[var3_4] = (byte)var4_2;
            return;
lbl-1000:
            // 1 sources

            {
                var6_6 = this.zzb;
                var3_4 = this.zzd;
                this.zzd = var3_4 + 1;
            }
            var6_6[var3_4] = (byte)((int)var4_2 & 127 | 128);
            var4_2 >>>= 7;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void zzo(long l) throws IOException {
        int n;
        int n2;
        try {
            byte[] byArray = this.zzb;
            n2 = this.zzd;
            this.zzd = n = n2 + 1;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new zzgx(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), (Throwable)indexOutOfBoundsException);
        }
        byArray[n2] = (byte)((int)l & 0xFF);
        n2 = n + 1;
        {
            this.zzd = n2;
        }
        byArray[n] = (byte)((int)(l >> 8) & 0xFF);
        n = n2 + 1;
        {
            this.zzd = n;
        }
        byArray[n2] = (byte)((int)(l >> 16) & 0xFF);
        n2 = n + 1;
        {
            this.zzd = n2;
        }
        byArray[n] = (byte)((int)(l >> 24) & 0xFF);
        n = n2 + 1;
        {
            this.zzd = n;
        }
        byArray[n2] = (byte)((int)(l >> 32) & 0xFF);
        n2 = n + 1;
        {
            this.zzd = n2;
        }
        byArray[n] = (byte)((int)(l >> 40) & 0xFF);
        n = n2 + 1;
        {
            this.zzd = n;
        }
        byArray[n2] = (byte)((int)(l >> 48) & 0xFF);
        {
            this.zzd = n + 1;
        }
        byArray[n] = (byte)((int)(l >> 56) & 0xFF);
    }

    public final void zzp(byte[] byArray, int n, int n2) throws IOException {
        try {
            System.arraycopy(byArray, 0, this.zzb, this.zzd, n2);
            this.zzd += n2;
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new zzgx(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, n2), (Throwable)indexOutOfBoundsException);
        }
    }

    public final void zzq(byte[] byArray, int n, int n2) throws IOException {
        this.zzp(byArray, 0, n2);
    }

    public final void zzr(String string) throws IOException {
        int n = this.zzd;
        try {
            int n2 = zzgw.zzw((int)(string.length() * 3));
            int n3 = zzgw.zzw((int)string.length());
            if (n3 == n2) {
                this.zzd = n2 = n + n3;
                n2 = zzkk.zzd((CharSequence)string, (byte[])this.zzb, (int)n2, (int)(this.zzc - n2));
                this.zzd = n;
                this.zzl(n2 - n - n3);
                this.zzd = n2;
                return;
            }
            this.zzl(zzkk.zzc((CharSequence)string));
            byte[] byArray = this.zzb;
            n3 = this.zzd;
            this.zzd = zzkk.zzd((CharSequence)string, (byte[])byArray, (int)n3, (int)(this.zzc - n3));
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new zzgx((Throwable)indexOutOfBoundsException);
        }
        catch (zzkj zzkj2) {
            this.zzd = n;
            this.zzD(string, zzkj2);
            return;
        }
    }

    public final int zzs() {
        return this.zzc - this.zzd;
    }
}
