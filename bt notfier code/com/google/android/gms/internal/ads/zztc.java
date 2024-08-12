/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zztc {
    private static final byte[] zzd = new byte[]{0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[128];
    private boolean zze;

    public zztc(int n) {
    }

    public final void zza() {
        this.zze = false;
        this.zza = 0;
        this.zzb = 0;
    }

    public final boolean zzb(int n, int n2) {
        block4: {
            if (this.zze) {
                this.zza = n2 = this.zza - n2;
                if (this.zzb == 0 && n == 181) {
                    this.zzb = n2;
                    break block4;
                } else {
                    this.zze = false;
                    return true;
                }
            }
            if (n == 179) {
                this.zze = true;
            }
        }
        this.zzc(zzd, 0, 3);
        return false;
    }

    public final void zzc(byte[] byArray, int n, int n2) {
        if (!this.zze) {
            return;
        }
        byte[] byArray2 = this.zzc;
        int n3 = byArray2.length;
        int n4 = this.zza + (n2 -= n);
        if (n3 < n4) {
            this.zzc = Arrays.copyOf(byArray2, n4 + n4);
        }
        System.arraycopy(byArray, n, this.zzc, this.zza, n2);
        this.zza += n2;
    }
}
