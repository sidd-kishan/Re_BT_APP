/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzoo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzoo;

public final class zzon {
    public int zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public final boolean zza(int n) {
        if (!zzoo.zzj((int)n)) {
            return false;
        }
        int n2 = n >>> 19 & 3;
        if (n2 == 1) {
            return false;
        }
        int n3 = n >>> 17 & 3;
        if (n3 == 0) {
            return false;
        }
        int n4 = n >>> 12 & 0xF;
        if (n4 == 0) return false;
        if (n4 == 15) {
            return false;
        }
        int n5 = n >>> 10 & 3;
        if (n5 == 3) {
            return false;
        }
        this.zza = n2;
        this.zzb = zzoo.zza()[3 - n3];
        this.zzd = n5 = zzoo.zzb()[n5];
        int n6 = 2;
        if (n2 == 2) {
            this.zzd = n5 / 2;
        } else if (n2 == 0) {
            this.zzd = n5 / 4;
        }
        int n7 = n >>> 9 & 1;
        this.zzg = zzoo.zzk((int)n2, (int)n3);
        if (n3 == 3) {
            n5 = n2 == 3 ? zzoo.zzc()[n4 - 1] : zzoo.zzd()[n4 - 1];
            this.zzf = n5;
            this.zzc = (n5 * 12 / this.zzd + n7) * 4;
        } else {
            n5 = 144;
            if (n2 == 3) {
                n5 = n3 == 2 ? zzoo.zze()[n4 - 1] : zzoo.zzf()[n4 - 1];
                this.zzf = n5;
                this.zzc = n5 * 144 / this.zzd + n7;
            } else {
                this.zzf = n2 = zzoo.zzg()[n4 - 1];
                if (n3 == 1) {
                    n5 = 72;
                }
                this.zzc = n5 * n2 / this.zzd + n7;
            }
        }
        n5 = n6;
        if ((n >> 6 & 3) == 3) {
            n5 = 1;
        }
        this.zze = n5;
        return true;
    }
}
