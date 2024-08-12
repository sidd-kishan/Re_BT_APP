/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzgiz
 *  com.google.android.gms.internal.ads.zzgja
 *  com.google.android.gms.internal.ads.zzgjd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzgiz;
import com.google.android.gms.internal.ads.zzgja;
import com.google.android.gms.internal.ads.zzgjd;

final class zzgjb
extends zzgja {
    zzgjb() {
    }

    final int zzb(int n, byte[] byArray, int n2, int n3) {
        int n4 = 0;
        int n5 = n2;
        if (n != 0) {
            int n6;
            if (n2 >= n3) {
                return n;
            }
            byte by = (byte)n;
            if (by < -32) {
                if (by < -62) return -1;
                n = n2 + 1;
                if (byArray[n2] > -65) return -1;
            } else if (by < -16) {
                n6 = ~(n >> 8);
                n = n6;
                n5 = n2;
                if (n6 == 0) {
                    n5 = n2 + 1;
                    n = byArray[n2];
                    if (n5 >= n3) return zzgjd.zzd((int)by, (int)n);
                }
                if (n > -65) return -1;
                if (by == -32) {
                    if (n < -96) return -1;
                }
                if (by == -19) {
                    if (n >= -96) return -1;
                }
                n = n5 + 1;
                if (byArray[n5] > -65) return -1;
            } else {
                n5 = (byte)(~(n >> 8));
                if (n5 == 0) {
                    n = n2 + 1;
                    n5 = byArray[n2];
                    if (n >= n3) return zzgjd.zzd((int)by, (int)n5);
                    n2 = n;
                    n = 0;
                } else {
                    n >>= 16;
                }
                n6 = n;
                int n7 = n2;
                if (n == 0) {
                    n7 = n2 + 1;
                    n6 = byArray[n2];
                    if (n7 >= n3) return zzgjd.zze((int)by, (int)n5, (int)n6);
                }
                if (n5 > -65) return -1;
                if ((by << 28) + (n5 + 112) >> 30 != 0) return -1;
                if (n6 > -65) return -1;
                n = n7 + 1;
                if (byArray[n7] > -65) return -1;
            }
            n5 = n;
        }
        while (n5 < n3 && byArray[n5] >= 0) {
            ++n5;
        }
        n = n5;
        if (n5 >= n3) {
            n = n4;
        } else {
            while (true) {
                if (n >= n3) {
                    n = n4;
                    break;
                }
                n2 = n + 1;
                if ((n = byArray[n]) < 0) {
                    if (n < -32) {
                        if (n2 >= n3) return n;
                        if (n >= -62) {
                            n = n2 + 1;
                            if (byArray[n2] <= -65) continue;
                        }
                    } else if (n < -16) {
                        if (n2 >= n3 - 1) {
                            n = zzgjd.zzf((byte[])byArray, (int)n2, (int)n3);
                            break;
                        }
                        n5 = n2 + 1;
                        if (!((n2 = byArray[n2]) > -65 || n == -32 && n2 < -96 || n == -19 && n2 >= -96)) {
                            n = n5 + 1;
                            if (byArray[n5] <= -65) continue;
                        }
                    } else {
                        if (n2 >= n3 - 2) {
                            n = zzgjd.zzf((byte[])byArray, (int)n2, (int)n3);
                            break;
                        }
                        n5 = n2 + 1;
                        if ((n2 = byArray[n2]) <= -65 && (n << 28) + (n2 + 112) >> 30 == 0) {
                            n2 = n5 + 1;
                            if (byArray[n5] <= -65) {
                                n = n2 + 1;
                                if (byArray[n2] <= -65) continue;
                            }
                        }
                    }
                    n = -1;
                    break;
                }
                n = n2;
            }
        }
        return n;
    }

    final String zzc(byte[] object, int n, int n2) throws zzggm {
        byte by;
        int n3 = ((byte[])object).length;
        if ((n | n2 | n3 - n - n2) < 0) {
            object = new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", n3, n, n2));
            throw object;
        }
        int n4 = n + n2;
        char[] cArray = new char[n2];
        n3 = 0;
        int n5 = n;
        while (true) {
            n = ++n3;
            n2 = ++n5;
            if (n5 >= n4) break;
            by = object[n5];
            if (!zzgiz.zza((byte)by)) {
                n = n3;
                n2 = n5;
                break;
            }
            cArray[n3] = (char)by;
        }
        block1: while (n2 < n4) {
            n3 = n2 + 1;
            by = object[n2];
            if (!zzgiz.zza((byte)by)) {
                if (zzgiz.zzb((byte)by)) {
                    if (n3 >= n4) throw zzggm.zzl();
                    zzgiz.zzd((byte)by, (byte)object[n3], (char[])cArray, (int)n);
                    n2 = n3 + 1;
                    ++n;
                    continue;
                }
                if (zzgiz.zzc((byte)by)) {
                    if (n3 >= n4 - 1) throw zzggm.zzl();
                    n2 = n3 + 1;
                    zzgiz.zze((byte)by, (byte)object[n3], (byte)object[n2], (char[])cArray, (int)n);
                    ++n2;
                    ++n;
                    continue;
                }
                if (n3 >= n4 - 2) throw zzggm.zzl();
                n5 = n3 + 1;
                n2 = n5 + 1;
                zzgiz.zzf((byte)by, (byte)object[n3], (byte)object[n5], (byte)object[n2], (char[])cArray, (int)n);
                n += 2;
                ++n2;
                continue;
            }
            n2 = n + 1;
            cArray[n] = (char)by;
            n = n2;
            while (true) {
                n = n5 = n;
                n2 = ++n3;
                if (n3 >= n4) continue block1;
                by = object[n3];
                if (!zzgiz.zza((byte)by)) {
                    n = n5;
                    n2 = n3;
                    continue block1;
                }
                n = n5 + 1;
                cArray[n5] = (char)by;
            }
            break;
        }
        return new String(cArray, 0, n);
    }
}
