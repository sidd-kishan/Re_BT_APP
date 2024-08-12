/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzaeg
 *  com.google.android.gms.internal.ads.zzahw
 *  com.google.android.gms.internal.ads.zzahx
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzalt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzjg
 *  com.google.android.gms.internal.ads.zzjw
 *  com.google.android.gms.internal.ads.zzjz
 *  com.google.android.gms.internal.ads.zzka
 *  com.google.android.gms.internal.ads.zzq
 *  com.google.android.gms.internal.ads.zzs
 */
package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzahw;
import com.google.android.gms.internal.ads.zzahx;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzjg;
import com.google.android.gms.internal.ads.zzjw;
import com.google.android.gms.internal.ads.zzjz;
import com.google.android.gms.internal.ads.zzka;
import com.google.android.gms.internal.ads.zzq;
import com.google.android.gms.internal.ads.zzs;

public abstract class zzjx
extends zzjz {
    private zzjw zza;

    protected abstract Pair<zzahx[], zzjg[]> zze(zzjw var1, int[][][] var2, int[] var3, zzhf var4, zzaiq var5) throws zzaeg;

    public final void zzi(Object object) {
        this.zza = (zzjw)object;
    }

    public final zzka zzj(zzahw[] zzjw2, zzs pair, zzhf zzhf2, zzaiq zzaiq2) throws zzaeg {
        Object object;
        zzq zzq2;
        int n;
        int n2;
        int[] nArray = new int[3];
        zzq[][] zzqArrayArray = new zzq[3][];
        int[][][] nArrayArray = new int[3][][];
        for (n2 = 0; n2 < 3; ++n2) {
            n = pair.zzb;
            zzqArrayArray[n2] = new zzq[n];
            nArrayArray[n2] = new int[n][];
        }
        int[] nArray2 = new int[2];
        for (n2 = 0; n2 < 2; ++n2) {
            nArray2[n2] = zzjw2[n2].zzG();
        }
        for (int i = 0; i < pair.zzb; ++i) {
            zzq2 = pair.zza(i);
            int n3 = zzalt.zzf((String)zzq2.zza((int)0).zzl);
            n2 = 0;
            int n4 = 2;
            int n5 = 0;
            int n6 = 1;
            while (true) {
                int n7;
                int n8;
                int n9 = 0;
                if (n2 >= 2) break;
                object = zzjw2[n2];
                n = 0;
                while (true) {
                    n8 = zzq2.zza;
                    if (n9 > 0) break;
                    n = Math.max(n, object.zzH(zzq2.zza(n9)) & 7);
                    ++n9;
                }
                int n10 = nArray[n2] == 0 ? 1 : 0;
                if (n <= n5) {
                    n7 = n4;
                    n8 = n5;
                    n9 = n6;
                    if (n == n5) {
                        n7 = n4;
                        n8 = n5;
                        n9 = n6;
                        if (n3 == 5) {
                            n7 = n4;
                            n8 = n5;
                            n9 = n6;
                            if (n6 == 0) {
                                n7 = n4;
                                n8 = n5;
                                n9 = n6;
                                if (n10 != 0) {
                                    n7 = n2;
                                    n9 = 1;
                                    n8 = n;
                                }
                            }
                        }
                    }
                } else {
                    n9 = n10;
                    n7 = n2;
                    n8 = n;
                }
                ++n2;
                n4 = n7;
                n5 = n8;
                n6 = n9;
            }
            if (n4 == 2) {
                n2 = zzq2.zza;
                object = new int[1];
            } else {
                zzahw zzahw2 = zzjw2[n4];
                n2 = zzq2.zza;
                object = new int[1];
                n2 = 0;
                while (true) {
                    n = zzq2.zza;
                    if (n2 > 0) break;
                    object[n2] = zzahw2.zzH(zzq2.zza(n2));
                    ++n2;
                }
            }
            n2 = nArray[n4];
            zzqArrayArray[n4][n2] = zzq2;
            nArrayArray[n4][n2] = object;
            nArray[n4] = n2 + 1;
        }
        zzq2 = new zzs[2];
        pair = new String[2];
        object = new int[2];
        n2 = 0;
        while (true) {
            if (n2 >= 2) {
                n2 = nArray[2];
                zzjw2 = new zzjw((String[])pair, object, (zzs[])zzq2, nArray2, (int[][][])nArrayArray, new zzs((zzq[])zzamq.zzf((Object[])zzqArrayArray[2], (int)n2)));
                pair = this.zze(zzjw2, nArrayArray, nArray2, zzhf2, zzaiq2);
                return new zzka((zzahx[])pair.first, (zzjg[])pair.second, (Object)zzjw2, null);
            }
            n = nArray[n2];
            zzq2[n2] = new zzs((zzq[])zzamq.zzf((Object[])zzqArrayArray[n2], (int)n));
            nArrayArray[n2] = (int[][])zzamq.zzf((Object[])nArrayArray[n2], (int)n);
            pair[n2] = zzjw2[n2].zzc();
            object[n2] = zzjw2[n2].zzac();
            ++n2;
        }
    }
}
