/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamq;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzamf {
    private byte[] zza;
    private int zzb;
    private int zzc;

    public zzamf() {
        this.zza = zzamq.zzf;
    }

    public zzamf(int n) {
        this.zza = new byte[n];
        this.zzc = n;
    }

    public zzamf(byte[] byArray) {
        this.zza = byArray;
        this.zzc = byArray.length;
    }

    public zzamf(byte[] byArray, int n) {
        this.zza = byArray;
        this.zzc = n;
    }

    public final int zzA() {
        return this.zzn() << 21 | this.zzn() << 14 | this.zzn() << 7 | this.zzn();
    }

    public final int zzB() {
        int n = this.zzv();
        if (n >= 0) {
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder(29);
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(n);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final int zzC() {
        int n = this.zzw();
        if (n >= 0) {
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder(29);
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(n);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final long zzD() {
        long l = this.zzx();
        if (l >= 0L) {
            return l;
        }
        StringBuilder stringBuilder = new StringBuilder(38);
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(l);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final String zzE(int n, Charset object) {
        object = new String(this.zza, this.zzb, n, (Charset)object);
        this.zzb += n;
        return object;
    }

    public final String zzF(int n) {
        if (n == 0) {
            return "";
        }
        int n2 = this.zzb;
        int n3 = n2 + n - 1;
        n3 = n3 < this.zzc && this.zza[n3] == 0 ? n - 1 : n;
        String string = zzamq.zzr((byte[])this.zza, (int)n2, (int)n3);
        this.zzb += n;
        return string;
    }

    public final String zzG(char c) {
        int n = this.zzc;
        c = (char)this.zzb;
        if (n - c == 0) return null;
        while (c < this.zzc && this.zza[c] != 0) {
            c = (char)(c + 1);
        }
        Object object = this.zza;
        n = this.zzb;
        object = zzamq.zzr((byte[])object, (int)n, (int)(c - n));
        this.zzb = c;
        if (c >= this.zzc) return object;
        this.zzb = c + '\u0001';
        return object;
    }

    public final long zzH() {
        int n;
        long l;
        int n2;
        long l2 = this.zza[this.zzb];
        int n3 = 7;
        while (true) {
            int n4 = 0;
            n2 = 1;
            l = l2;
            n = n4;
            if (n3 < 0) break;
            n = 1 << n3;
            if (((long)n & l2) == 0L) {
                if (n3 < 6) {
                    l = l2 & (long)(n - 1);
                    n = 7 - n3;
                    break;
                }
                l = l2;
                n = n4;
                if (n3 != 7) break;
                n = 1;
                l = l2;
                break;
            }
            --n3;
        }
        if (n == 0) {
            Serializable serializable = new StringBuilder(55);
            serializable.append("Invalid UTF-8 sequence first byte: ");
            serializable.append(l);
            serializable = new NumberFormatException(serializable.toString());
            throw serializable;
        }
        n3 = n2;
        while (true) {
            if (n3 >= n) {
                this.zzb += n;
                return l;
            }
            n2 = this.zza[this.zzb + n3];
            if ((n2 & 0xC0) != 128) {
                StringBuilder stringBuilder = new StringBuilder(62);
                stringBuilder.append("Invalid UTF-8 sequence continuation byte: ");
                stringBuilder.append(l);
                throw new NumberFormatException(stringBuilder.toString());
            }
            l = l << 6 | (long)(n2 & 0x3F);
            ++n3;
        }
    }

    public final void zza(int n) {
        byte[] byArray;
        byte[] byArray2 = byArray = this.zza;
        if (byArray.length < n) {
            byArray2 = new byte[n];
        }
        this.zzb(byArray2, n);
    }

    public final void zzb(byte[] byArray, int n) {
        this.zza = byArray;
        this.zzc = n;
        this.zzb = 0;
    }

    public final void zzc(int n) {
        byte[] byArray = this.zza;
        if (n <= byArray.length) return;
        this.zza = Arrays.copyOf(byArray, n);
    }

    public final int zzd() {
        return this.zzc - this.zzb;
    }

    public final int zze() {
        return this.zzc;
    }

    public final void zzf(int n) {
        boolean bl;
        boolean bl2 = bl = false;
        if (n >= 0) {
            bl2 = bl;
            if (n <= this.zza.length) {
                bl2 = true;
            }
        }
        zzakt.zza((boolean)bl2);
        this.zzc = n;
    }

    public final int zzg() {
        return this.zzb;
    }

    public final void zzh(int n) {
        boolean bl;
        boolean bl2 = bl = false;
        if (n >= 0) {
            bl2 = bl;
            if (n <= this.zzc) {
                bl2 = true;
            }
        }
        zzakt.zza((boolean)bl2);
        this.zzb = n;
    }

    public final byte[] zzi() {
        return this.zza;
    }

    public final int zzj() {
        return this.zza.length;
    }

    public final void zzk(int n) {
        this.zzh(this.zzb + n);
    }

    public final void zzl(zzame zzame2, int n) {
        this.zzm(zzame2.zza, 0, n);
        zzame2.zzd(0);
    }

    public final void zzm(byte[] byArray, int n, int n2) {
        System.arraycopy(this.zza, this.zzb, byArray, n, n2);
        this.zzb += n2;
    }

    public final int zzn() {
        byte[] byArray = this.zza;
        int n = this.zzb;
        this.zzb = n + 1;
        return byArray[n] & 0xFF;
    }

    public final int zzo() {
        int n;
        byte[] byArray = this.zza;
        int n2 = this.zzb;
        this.zzb = n = n2 + 1;
        n2 = byArray[n2];
        this.zzb = n + 1;
        return byArray[n] & 0xFF | (n2 & 0xFF) << 8;
    }

    public final int zzp() {
        int n;
        byte[] byArray = this.zza;
        int n2 = this.zzb;
        this.zzb = n = n2 + 1;
        n2 = byArray[n2];
        this.zzb = n + 1;
        return (byArray[n] & 0xFF) << 8 | n2 & 0xFF;
    }

    public final short zzq() {
        int n;
        byte[] byArray = this.zza;
        int n2 = this.zzb;
        this.zzb = n = n2 + 1;
        n2 = byArray[n2];
        this.zzb = n + 1;
        return (short)(byArray[n] & 0xFF | (n2 & 0xFF) << 8);
    }

    public final int zzr() {
        int n;
        int n2;
        byte[] byArray = this.zza;
        int n3 = this.zzb;
        this.zzb = n2 = n3 + 1;
        n3 = byArray[n3];
        this.zzb = n = n2 + 1;
        n2 = byArray[n2];
        this.zzb = n + 1;
        return byArray[n] & 0xFF | ((n3 & 0xFF) << 16 | (n2 & 0xFF) << 8);
    }

    public final int zzs() {
        int n;
        byte[] byArray = this.zza;
        int n2 = this.zzb;
        this.zzb = n = n2 + 1;
        byte by = byArray[n2];
        this.zzb = n2 = n + 1;
        n = byArray[n];
        this.zzb = n2 + 1;
        return byArray[n2] & 0xFF | ((by & 0xFF) << 24 >> 8 | (n & 0xFF) << 8);
    }

    public final long zzt() {
        int n;
        int n2;
        byte[] byArray = this.zza;
        int n3 = this.zzb;
        this.zzb = n2 = n3 + 1;
        n3 = byArray[n3];
        this.zzb = n = n2 + 1;
        byte by = byArray[n2];
        this.zzb = n2 = n + 1;
        n = byArray[n];
        this.zzb = n2 + 1;
        long l = n3;
        return ((long)by & 0xFFL) << 16 | (l & 0xFFL) << 24 | ((long)n & 0xFFL) << 8 | (long)byArray[n2] & 0xFFL;
    }

    public final long zzu() {
        int n;
        int n2;
        int n3;
        byte[] byArray = this.zza;
        int n4 = this.zzb;
        this.zzb = n3 = n4 + 1;
        n4 = byArray[n4];
        this.zzb = n2 = n3 + 1;
        n3 = byArray[n3];
        this.zzb = n = n2 + 1;
        n2 = byArray[n2];
        this.zzb = n + 1;
        long l = n4;
        return ((long)n3 & 0xFFL) << 8 | l & 0xFFL | ((long)n2 & 0xFFL) << 16 | ((long)byArray[n] & 0xFFL) << 24;
    }

    public final int zzv() {
        int n;
        int n2;
        byte[] byArray = this.zza;
        int n3 = this.zzb;
        this.zzb = n2 = n3 + 1;
        n3 = byArray[n3];
        this.zzb = n = n2 + 1;
        byte by = byArray[n2];
        this.zzb = n2 = n + 1;
        n = byArray[n];
        this.zzb = n2 + 1;
        return byArray[n2] & 0xFF | ((n3 & 0xFF) << 24 | (by & 0xFF) << 16 | (n & 0xFF) << 8);
    }

    public final int zzw() {
        int n;
        int n2;
        byte[] byArray = this.zza;
        int n3 = this.zzb;
        this.zzb = n2 = n3 + 1;
        n3 = byArray[n3];
        this.zzb = n = n2 + 1;
        byte by = byArray[n2];
        this.zzb = n2 = n + 1;
        n = byArray[n];
        this.zzb = n2 + 1;
        return (byArray[n2] & 0xFF) << 24 | (n3 & 0xFF | (by & 0xFF) << 8 | (n & 0xFF) << 16);
    }

    public final long zzx() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        byte[] byArray = this.zza;
        int n8 = this.zzb;
        this.zzb = n7 = n8 + 1;
        n8 = byArray[n8];
        this.zzb = n6 = n7 + 1;
        n7 = byArray[n7];
        this.zzb = n5 = n6 + 1;
        n6 = byArray[n6];
        this.zzb = n4 = n5 + 1;
        n5 = byArray[n5];
        this.zzb = n3 = n4 + 1;
        n4 = byArray[n4];
        this.zzb = n2 = n3 + 1;
        n3 = byArray[n3];
        this.zzb = n = n2 + 1;
        n2 = byArray[n2];
        this.zzb = n + 1;
        long l = n8;
        return ((long)n7 & 0xFFL) << 48 | (l & 0xFFL) << 56 | ((long)n6 & 0xFFL) << 40 | ((long)n5 & 0xFFL) << 32 | ((long)n4 & 0xFFL) << 24 | ((long)n3 & 0xFFL) << 16 | ((long)n2 & 0xFFL) << 8 | (long)byArray[n] & 0xFFL;
    }

    public final long zzy() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        byte[] byArray = this.zza;
        int n8 = this.zzb;
        this.zzb = n7 = n8 + 1;
        n8 = byArray[n8];
        this.zzb = n6 = n7 + 1;
        n7 = byArray[n7];
        this.zzb = n5 = n6 + 1;
        n6 = byArray[n6];
        this.zzb = n4 = n5 + 1;
        n5 = byArray[n5];
        this.zzb = n3 = n4 + 1;
        n4 = byArray[n4];
        this.zzb = n2 = n3 + 1;
        n3 = byArray[n3];
        this.zzb = n = n2 + 1;
        n2 = byArray[n2];
        this.zzb = n + 1;
        long l = n8;
        return ((long)n7 & 0xFFL) << 8 | l & 0xFFL | ((long)n6 & 0xFFL) << 16 | ((long)n5 & 0xFFL) << 24 | ((long)n4 & 0xFFL) << 32 | ((long)n3 & 0xFFL) << 40 | ((long)n2 & 0xFFL) << 48 | ((long)byArray[n] & 0xFFL) << 56;
    }

    public final int zzz() {
        int n;
        byte[] byArray = this.zza;
        int n2 = this.zzb;
        this.zzb = n = n2 + 1;
        byte by = byArray[n2];
        this.zzb = n2 = n + 1;
        n = byArray[n];
        this.zzb = n2 + 2;
        return n & 0xFF | (by & 0xFF) << 8;
    }
}
