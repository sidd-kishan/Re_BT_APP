/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaku
 *  com.google.android.gms.internal.ads.zzfog
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfoy
 *  com.google.android.gms.internal.ads.zzfpr
 *  com.google.android.gms.internal.ads.zzfpw
 *  com.google.android.gms.internal.ads.zzjc
 *  com.google.android.gms.internal.ads.zzjg
 *  com.google.android.gms.internal.ads.zzju
 *  com.google.android.gms.internal.ads.zzki
 *  com.google.android.gms.internal.ads.zzq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaku;
import com.google.android.gms.internal.ads.zzfog;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfoy;
import com.google.android.gms.internal.ads.zzfpr;
import com.google.android.gms.internal.ads.zzfpw;
import com.google.android.gms.internal.ads.zzjc;
import com.google.android.gms.internal.ads.zzjg;
import com.google.android.gms.internal.ads.zzju;
import com.google.android.gms.internal.ads.zzki;
import com.google.android.gms.internal.ads.zzq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public final class zzje
extends zzjg {
    private final zzki zzd;
    private final zzfoj<zzjc> zze;
    private final zzaku zzf;

    protected zzje(zzq zzq2, int[] nArray, int n, zzki zzki2, long l, long l2, long l3, float f, float f2, List<zzjc> list, zzaku zzaku2) {
        super(zzq2, nArray, 0);
        this.zzd = zzki2;
        this.zze = zzfoj.zzp(list);
        this.zzf = zzaku2;
    }

    static /* synthetic */ zzfoj<zzfoj<zzjc>> zza(zzju[] zzfog2) {
        long l;
        Object object;
        int n;
        Object object2;
        Object object3;
        int n2;
        ArrayList<zzfog<zzjc>> arrayList = new ArrayList<zzfog<zzjc>>();
        for (n2 = 0; n2 < 2; ++n2) {
            object3 = zzfog2[n2];
            if (object3 != null && object3.zzb.length > 1) {
                object3 = zzfoj.zzu();
                object3.zze((Object)new zzjc(0L, 0L));
                arrayList.add((zzfog<zzjc>)object3);
                continue;
            }
            arrayList.add(null);
        }
        object3 = new long[2][];
        for (n2 = 0; n2 < 2; ++n2) {
            object2 = zzfog2[n2];
            if (object2 == null) {
                object3[n2] = new long[0];
                continue;
            }
            object3[n2] = new long[object2.zzb.length];
            for (n = 0; n < ((long[])(object = (Object)object2.zzb)).length; ++n) {
                object3[n2][n] = object2.zza.zza((int)object[n]).zzh;
            }
            Arrays.sort(object3[n2]);
        }
        object2 = new int[2];
        zzfog2 = (zzfog)new long[2];
        for (n2 = 0; n2 < 2; ++n2) {
            object = object3[n2];
            l = ((long[])object).length == 0 ? 0L : object[0];
            zzfog2[n2] = (zzju)l;
        }
        zzje.zzf(arrayList, (long[])zzfog2);
        zzfoy zzfoy2 = zzfpr.zzc((Comparator)zzfpw.zzb()).zzb(2).zza();
        n2 = 0;
        while (true) {
            block14: {
                double d;
                int n3;
                int n4;
                block15: {
                    block13: {
                        if (n2 >= 2) break block13;
                        n4 = object3[n2].length;
                        if (n4 <= 1) break block14;
                        break block15;
                    }
                    object = zzfoj.zzp((Collection)zzfoy2.zzt());
                    for (n2 = 0; n2 < object.size(); ++n2) {
                        n4 = (Integer)object.get(n2);
                        object2[n4] = n = object2[n4] + 1;
                        zzfog2[n4] = (zzju)object3[n4][n];
                        zzje.zzf(arrayList, (long[])zzfog2);
                    }
                    for (n2 = 0; n2 < 2; ++n2) {
                        if (arrayList.get(n2) == null) continue;
                        l = (long)zzfog2[n2];
                        zzfog2[n2] = (zzju)(l + l);
                    }
                    break;
                }
                double[] dArray = new double[n4];
                n = 0;
                while (true) {
                    object = object3[n2];
                    n3 = ((long[])object).length;
                    d = 0.0;
                    if (n >= n3) break;
                    l = object[n];
                    if (l != -1L) {
                        d = Math.log(l);
                    }
                    dArray[n] = d;
                    ++n;
                }
                n3 = n4 - 1;
                double d2 = dArray[n3] - dArray[0];
                n = 0;
                while (n < n3) {
                    n4 = n + 1;
                    double d3 = dArray[n];
                    d = dArray[n4];
                    d = d2 == 0.0 ? 1.0 : ((d3 + d) * 0.5 - dArray[0]) / d2;
                    zzfoy2.zzh((Object)d, (Object)n2);
                    n = n4;
                }
            }
            ++n2;
        }
        zzje.zzf(arrayList, (long[])zzfog2);
        object3 = zzfoj.zzu();
        n2 = 0;
        while (n2 < arrayList.size()) {
            zzfog2 = (zzfog)arrayList.get(n2);
            zzfog2 = zzfog2 == null ? zzfoj.zzi() : zzfog2.zzf();
            object3.zze((Object)zzfog2);
            ++n2;
        }
        return object3.zzf();
    }

    private static void zzf(List<zzfog<zzjc>> list, long[] lArray) {
        int n;
        int n2 = 0;
        long l = 0L;
        int n3 = 0;
        while (true) {
            n = n2;
            if (n3 >= 2) break;
            l += lArray[n3];
            ++n3;
        }
        while (n < list.size()) {
            zzfog<zzjc> zzfog2 = list.get(n);
            if (zzfog2 != null) {
                zzfog2.zze((Object)new zzjc(l, lArray[n]));
            }
            ++n;
        }
    }
}
