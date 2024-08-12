/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaup
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaup;

public final class zzaux {
    public byte[] zza;
    private int zzb;
    private int zzc;

    public zzaux() {
    }

    public zzaux(int n) {
        this.zza = new byte[n];
        this.zzc = n;
    }

    public zzaux(byte[] byArray) {
        this.zza = byArray;
        this.zzc = byArray.length;
    }

    public final void zza(int n) {
        byte[] byArray = this.zzh() < n ? new byte[n] : this.zza;
        this.zzb(byArray, n);
    }

    public final void zzb(byte[] byArray, int n) {
        this.zza = byArray;
        this.zzc = n;
        this.zzb = 0;
    }

    public final void zzc() {
        this.zzb = 0;
        this.zzc = 0;
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
        zzaup.zza((boolean)bl2);
        this.zzc = n;
    }

    public final int zzg() {
        return this.zzb;
    }

    public final int zzh() {
        byte[] byArray = this.zza;
        if (byArray != null) return byArray.length;
        return 0;
    }

    public final void zzi(int n) {
        boolean bl;
        boolean bl2 = bl = false;
        if (n >= 0) {
            bl2 = bl;
            if (n <= this.zzc) {
                bl2 = true;
            }
        }
        zzaup.zza((boolean)bl2);
        this.zzb = n;
    }

    public final void zzj(int n) {
        this.zzi(this.zzb + n);
    }

    public final void zzk(byte[] byArray, int n, int n2) {
        System.arraycopy(this.zza, this.zzb, byArray, n, n2);
        this.zzb += n2;
    }

    public final int zzl() {
        byte[] byArray = this.zza;
        int n = this.zzb;
        this.zzb = n + 1;
        return byArray[n] & 0xFF;
    }

    public final int zzm() {
        int n;
        byte[] byArray = this.zza;
        int n2 = this.zzb;
        this.zzb = n = n2 + 1;
        n2 = byArray[n2];
        this.zzb = n + 1;
        return byArray[n] & 0xFF | (n2 & 0xFF) << 8;
    }

    public final int zzn() {
        int n;
        byte[] byArray = this.zza;
        int n2 = this.zzb;
        this.zzb = n = n2 + 1;
        n2 = byArray[n2];
        this.zzb = n + 1;
        return (byArray[n] & 0xFF) << 8 | n2 & 0xFF;
    }

    public final short zzo() {
        int n;
        byte[] byArray = this.zza;
        int n2 = this.zzb;
        this.zzb = n = n2 + 1;
        n2 = byArray[n2];
        this.zzb = n + 1;
        return (short)(byArray[n] & 0xFF | (n2 & 0xFF) << 8);
    }

    public final long zzp() {
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
        return ((long)n3 & 0xFFL) << 16 | (l & 0xFFL) << 24 | ((long)n2 & 0xFFL) << 8 | (long)byArray[n] & 0xFFL;
    }

    public final long zzq() {
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
        return ((long)by & 0xFFL) << 8 | l & 0xFFL | ((long)n & 0xFFL) << 16 | ((long)byArray[n2] & 0xFFL) << 24;
    }

    public final int zzr() {
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
        return byArray[n] & 0xFF | ((n4 & 0xFF) << 24 | (n3 & 0xFF) << 16 | (n2 & 0xFF) << 8);
    }

    public final long zzs() {
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

    public final int zzt() {
        int n;
        int n2;
        byte[] byArray = this.zza;
        int n3 = this.zzb;
        this.zzb = n2 = n3 + 1;
        n3 = byArray[n3];
        this.zzb = n = n2 + 1;
        n2 = byArray[n2];
        this.zzb = n + 2;
        return n2 & 0xFF | (n3 & 0xFF) << 8;
    }

    public final int zzu() {
        int n = this.zzr();
        if (n >= 0) {
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder(29);
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(n);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final long zzv() {
        long l = this.zzs();
        if (l >= 0L) {
            return l;
        }
        StringBuilder stringBuilder = new StringBuilder(38);
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(l);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final String zzw(int n) {
        if (n == 0) {
            return "";
        }
        int n2 = this.zzb;
        int n3 = n2 + n - 1;
        n3 = n3 < this.zzc && this.zza[n3] == 0 ? n - 1 : n;
        String string = new String(this.zza, n2, n3);
        this.zzb += n;
        return string;
    }
}
