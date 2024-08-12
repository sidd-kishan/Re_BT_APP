/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaup
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaup;

public final class zzauw {
    public byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    public zzauw() {
    }

    public zzauw(byte[] byArray, int n) {
        this.zza = byArray;
        this.zzd = n;
    }

    public final int zza(int n) {
        boolean bl;
        block10: {
            block11: {
                byte[] byArray;
                int n2;
                boolean bl2 = false;
                int n3 = 0;
                int n4 = 0;
                int n5 = n;
                while (true) {
                    n2 = n5;
                    if (n3 >= n >> 3) break;
                    int n6 = this.zzc;
                    if (n6 != 0) {
                        byArray = this.zza;
                        int n7 = this.zzb;
                        n5 = byArray[n7];
                        n5 = (byArray[n7 + 1] & 0xFF) >>> 8 - n6 | (n5 & 0xFF) << n6;
                    } else {
                        n5 = this.zza[this.zzb];
                    }
                    n4 |= (n5 & 0xFF) << (n2 -= 8);
                    ++this.zzb;
                    ++n3;
                    n5 = n2;
                }
                n = n4;
                if (n2 > 0) {
                    n5 = this.zzc + n2;
                    n = (byte)(255 >> 8 - n2);
                    if (n5 > 8) {
                        byArray = this.zza;
                        n2 = this.zzb;
                        n3 = n2 + 1;
                        n2 = byArray[n2];
                        n = n & ((byArray[n3] & 0xFF) >> 16 - n5 | (n2 & 0xFF) << n5 - 8) | n4;
                        this.zzb = n3;
                    } else {
                        byArray = this.zza;
                        n3 = this.zzb;
                        n = n4 = n & (byArray[n3] & 0xFF) >> 8 - n5 | n4;
                        if (n5 == 8) {
                            this.zzb = n3 + 1;
                            n = n4;
                        }
                    }
                    this.zzc = n5 % 8;
                }
                n4 = this.zzb;
                bl = bl2;
                if (n4 < 0) break block10;
                n3 = this.zzc;
                bl = bl2;
                if (n3 < 0) break block10;
                n5 = this.zzd;
                if (n4 < n5) break block11;
                bl = bl2;
                if (n4 != n5) break block10;
                bl = bl2;
                if (n3 != 0) break block10;
            }
            bl = true;
        }
        zzaup.zzd((boolean)bl);
        return n;
    }
}
