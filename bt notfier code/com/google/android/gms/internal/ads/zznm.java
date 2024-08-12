/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzox
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzox;

public final class zznm {
    public static void zza(long l, zzamf zzamf2, zzox[] zzoxArray) {
        while (true) {
            int n = zzamf2.zzd();
            int n2 = 1;
            if (n <= 1) return;
            int n3 = zznm.zzc(zzamf2);
            int n4 = zznm.zzc(zzamf2);
            int n5 = zzamf2.zzg() + n4;
            if (n4 != -1 && n4 <= zzamf2.zzd()) {
                n = n5;
                if (n3 == 4) {
                    n = n5;
                    if (n4 >= 8) {
                        int n6 = zzamf2.zzn();
                        n = zzamf2.zzo();
                        if (n == 49) {
                            n4 = zzamf2.zzv();
                            n = 49;
                        } else {
                            n4 = 0;
                        }
                        int n7 = zzamf2.zzn();
                        n3 = n;
                        if (n == 47) {
                            zzamf2.zzk(1);
                            n3 = 47;
                        }
                        n = n6 == 181 && (n3 == 49 || n3 == 47) && n7 == 3 ? 1 : 0;
                        n6 = n;
                        if (n3 == 49) {
                            n4 = n4 == 1195456820 ? n2 : 0;
                            n6 = n & n4;
                        }
                        n = n5;
                        if (n6 != 0) {
                            zznm.zzb(l, zzamf2, zzoxArray);
                            n = n5;
                        }
                    }
                }
            } else {
                Log.w((String)"CeaUtil", (String)"Skipping remainder of malformed SEI NAL unit.");
                n = zzamf2.zze();
            }
            zzamf2.zzh(n);
        }
    }

    public static void zzb(long l, zzamf zzamf2, zzox[] zzoxArray) {
        int n = zzamf2.zzn();
        if ((n & 0x40) == 0) return;
        zzamf2.zzk(1);
        int n2 = (n & 0x1F) * 3;
        int n3 = zzamf2.zzg();
        int n4 = zzoxArray.length;
        n = 0;
        while (n < n4) {
            zzox zzox2 = zzoxArray[n];
            zzamf2.zzh(n3);
            zzox2.zzy(zzamf2, n2);
            if (l != -9223372036854775807L) {
                zzox2.zzv(l, 1, n2, 0, null);
            }
            ++n;
        }
    }

    private static int zzc(zzamf zzamf2) {
        int n;
        int n2;
        int n3 = 0;
        do {
            if (zzamf2.zzd() == 0) {
                return -1;
            }
            n2 = zzamf2.zzn();
            n3 = n = n3 + n2;
        } while (n2 == 255);
        return n;
    }
}
