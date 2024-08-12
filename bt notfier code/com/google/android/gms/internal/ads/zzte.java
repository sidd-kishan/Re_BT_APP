/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import java.util.Arrays;

final class zzte {
    private static final byte[] zzd = new byte[]{0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[128];
    private boolean zze;
    private int zzf;

    public zzte(int n) {
    }

    public final void zza() {
        this.zze = false;
        this.zza = 0;
        this.zzf = 0;
    }

    public final boolean zzb(int n, int n2) {
        int n3 = this.zzf;
        if (n3 != 0) {
            if (n3 != 1) {
                if (n3 != 2) {
                    if (n3 != 3) {
                        if (n == 179 || n == 181) {
                            this.zza -= n2;
                            this.zze = false;
                            return true;
                        }
                    } else if ((n & 0xF0) != 32) {
                        Log.w((String)"H263Reader", (String)"Unexpected start code value");
                        this.zza();
                    } else {
                        this.zzb = this.zza;
                        this.zzf = 4;
                    }
                } else if (n > 31) {
                    Log.w((String)"H263Reader", (String)"Unexpected start code value");
                    this.zza();
                } else {
                    this.zzf = 3;
                }
            } else if (n != 181) {
                Log.w((String)"H263Reader", (String)"Unexpected start code value");
                this.zza();
            } else {
                this.zzf = 2;
            }
        } else if (n == 176) {
            this.zzf = 1;
            this.zze = true;
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
        int n4 = n2 - n;
        if (n3 < (n2 = this.zza + n4)) {
            this.zzc = Arrays.copyOf(byArray2, n2 + n2);
        }
        System.arraycopy(byArray, n, this.zzc, this.zza, n4);
        this.zza += n4;
    }
}
