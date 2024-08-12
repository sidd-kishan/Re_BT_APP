/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzgee {
    private final byte[] zza = new byte[256];
    private int zzb;
    private int zzc;

    public zzgee(byte[] byArray) {
        int n;
        for (n = 0; n < 256; ++n) {
            this.zza[n] = (byte)n;
        }
        int n2 = 0;
        n = 0;
        while (true) {
            if (n2 >= 256) {
                this.zzb = 0;
                this.zzc = 0;
                return;
            }
            byte[] byArray2 = this.zza;
            byte by = byArray2[n2];
            n = n + by + byArray[n2 % byArray.length] & 0xFF;
            byArray2[n2] = byArray2[n];
            byArray2[n] = by;
            ++n2;
        }
    }

    public final void zza(byte[] byArray) {
        int n = this.zzb;
        int n2 = this.zzc;
        int n3 = 0;
        while (true) {
            if (n3 >= 256) {
                this.zzb = n;
                this.zzc = n2;
                return;
            }
            n = n + 1 & 0xFF;
            byte[] byArray2 = this.zza;
            byte by = byArray2[n];
            n2 = n2 + by & 0xFF;
            byArray2[n] = byArray2[n2];
            byArray2[n2] = by;
            byte by2 = byArray[n3];
            byArray[n3] = (byte)(byArray2[byArray2[n] + by & 0xFF] ^ by2);
            ++n3;
        }
    }
}
