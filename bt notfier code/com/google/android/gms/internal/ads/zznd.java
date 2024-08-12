/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznc;

public final class zznd {
    public static final int zza = 0;
    private static final int[] zzb = new int[]{2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    public static zznc zza(zzame zzame2) {
        int n;
        int n2;
        int n3;
        int n4;
        block11: {
            block12: {
                int n5;
                block16: {
                    int n6;
                    block13: {
                        block14: {
                            block15: {
                                block10: {
                                    n4 = zzame2.zzh(16);
                                    n3 = zzame2.zzh(16);
                                    if (n3 == 65535) {
                                        n3 = zzame2.zzh(24);
                                        n2 = 7;
                                    } else {
                                        n2 = 4;
                                    }
                                    n3 = n2 = n3 + n2;
                                    if (n4 == 44097) {
                                        n3 = n2 + 2;
                                    }
                                    n4 = n2 = zzame2.zzh(2);
                                    if (n2 == 3) {
                                        n2 = 0;
                                        while (true) {
                                            n2 += zzame2.zzh(2);
                                            if (!zzame2.zzg()) {
                                                n4 = n2 + 3;
                                                break;
                                            }
                                            n2 = n2 + 1 << 2;
                                        }
                                    }
                                    n2 = zzame2.zzh(10);
                                    if (zzame2.zzg() && zzame2.zzh(3) > 0) {
                                        zzame2.zzf(2);
                                    }
                                    n = true != zzame2.zzg() ? 44100 : 48000;
                                    n6 = zzame2.zzh(4);
                                    if (n != 44100 || n6 != 13) break block10;
                                    n2 = zzb[13];
                                    break block11;
                                }
                                if (n != 48000 || n6 >= 14) break block12;
                                n5 = zzb[n6];
                                if ((n2 %= 5) == 1) break block13;
                                if (n2 == 2) break block14;
                                if (n2 == 3) break block13;
                                if (n2 == 4) break block15;
                                n2 = n5;
                                break block11;
                            }
                            if (n6 != 3 && n6 != 8) {
                                n2 = n5;
                                if (n6 != 11) return new zznc(n4, 2, n, n3, n2, null);
                            }
                            break block16;
                        }
                        if (n6 != 8) {
                            n2 = n5;
                            if (n6 != 11) return new zznc(n4, 2, n, n3, n2, null);
                        }
                        break block16;
                    }
                    if (n6 != 3) {
                        n2 = n5;
                        if (n6 != 8) return new zznc(n4, 2, n, n3, n2, null);
                    }
                }
                n2 = n5 + 1;
                break block11;
            }
            n2 = 0;
        }
        return new zznc(n4, 2, n, n3, n2, null);
    }

    public static void zzb(int n, zzamf object) {
        object.zza(7);
        object = object.zzi();
        object[0] = (zzamf)-84;
        object[1] = (zzamf)64;
        object[2] = (zzamf)-1;
        object[3] = (zzamf)-1;
        object[4] = (zzamf)((byte)(n >> 16 & 0xFF));
        object[5] = (zzamf)((byte)(n >> 8 & 0xFF));
        object[6] = (zzamf)((byte)(n & 0xFF));
    }
}
