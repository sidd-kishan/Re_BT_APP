/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 *  com.google.android.gms.internal.ads.zzamy
 *  com.google.android.gms.internal.ads.zzans
 *  com.google.android.gms.internal.ads.zzant
 *  com.google.android.gms.internal.ads.zzatf
 *  com.google.android.gms.internal.ads.zzatg
 *  com.google.android.gms.internal.ads.zzatk
 *  com.google.android.gms.internal.ads.zzato
 *  com.google.android.gms.internal.ads.zzatp
 *  com.google.android.gms.internal.ads.zzats
 *  com.google.android.gms.internal.ads.zzatu
 *  com.google.android.gms.internal.ads.zzatv
 */
package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.gms.internal.ads.zzamy;
import com.google.android.gms.internal.ads.zzans;
import com.google.android.gms.internal.ads.zzant;
import com.google.android.gms.internal.ads.zzatf;
import com.google.android.gms.internal.ads.zzatg;
import com.google.android.gms.internal.ads.zzatk;
import com.google.android.gms.internal.ads.zzato;
import com.google.android.gms.internal.ads.zzatp;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzatu;
import com.google.android.gms.internal.ads.zzatv;
import java.util.Arrays;
import java.util.Map;

public abstract class zzatq
extends zzatu {
    private final SparseArray<Map<zzatg, zzatp>> zza = new SparseArray();
    private final SparseBooleanArray zzb = new SparseBooleanArray();
    private zzato zzc;

    protected abstract zzatk[] zzb(zzans[] var1, zzatg[] var2, int[][][] var3) throws zzamy;

    public final void zzc(int n, boolean bl) {
        if (this.zzb.get(n) == bl) {
            return;
        }
        this.zzb.put(n, bl);
        this.zzg();
    }

    public final zzatv zzd(zzans[] object, zzatg zzatg2) throws zzamy {
        zzatk[] zzatkArray;
        Object object2;
        zzatf zzatf2;
        int n;
        int n2;
        Object object3 = new int[3];
        zzatf zzatf3 = new zzatf[3][];
        Object object4 = new int[3][][];
        for (n2 = 0; n2 < 3; ++n2) {
            n = zzatg2.zzb;
            zzatf3[n2] = new zzatf[n];
            object4[n2] = new int[n][];
        }
        Object[] objectArray = new int[2];
        for (n2 = 0; n2 < 2; ++n2) {
            object[n2].zzq();
            objectArray[n2] = 4;
        }
        int n3 = 0;
        while (true) {
            int n4;
            if (n3 >= zzatg2.zzb) {
                zzatf2 = new zzatg[2];
                object2 = new int[2];
                for (n2 = 0; n2 < 2; ++n2) {
                    n = object3[n2];
                    zzatf2[n2] = new zzatg(Arrays.copyOf(zzatf3[n2], n));
                    object4[n2] = (int[][])Arrays.copyOf(object4[n2], n);
                    object2[n2] = object[n2].zza();
                }
                n2 = object3[2];
                object3 = new zzatg(Arrays.copyOf(zzatf3[2], n2));
                zzatkArray = this.zzb((zzans[])object, (zzatg[])zzatf2, (int[][][])object4);
                break;
            }
            zzatf2 = zzatg2.zza(n3);
            n2 = 0;
            int n5 = 0;
            n = 2;
            block4: while (true) {
                if (n2 >= 2) {
                    n2 = n;
                    break;
                }
                zzatkArray = object[n2];
                int n6 = 0;
                n4 = n;
                n = n6;
                while (true) {
                    n6 = zzatf2.zza;
                    if (n > 0) break;
                    int n7 = zzatkArray.zzG(zzatf2.zza(n)) & 3;
                    n6 = n5;
                    if (n7 > n5) {
                        if (n7 == 3) break block4;
                        n4 = n2;
                        n6 = n7;
                    }
                    ++n;
                    n5 = n6;
                }
                ++n2;
                n = n4;
            }
            if (n2 == 2) {
                n = zzatf2.zza;
                zzatkArray = (zzatk[])new int[1];
            } else {
                object2 = object[n2];
                n = zzatf2.zza;
                zzatkArray = (zzatk[])new int[1];
                n = 0;
                while (true) {
                    n4 = zzatf2.zza;
                    if (n > 0) break;
                    zzatkArray[n] = (zzatk)object2.zzG(zzatf2.zza(n));
                    ++n;
                }
            }
            n = object3[n2];
            zzatf3[n2][n] = zzatf2;
            object4[n2][n] = (int[])zzatkArray;
            object3[n2] = n + 1;
            ++n3;
        }
        for (n2 = 0; n2 < 2; ++n2) {
            if (this.zzb.get(n2)) {
                zzatkArray[n2] = null;
                continue;
            }
            zzatf3 = zzatf2[n2];
            object = (Map)this.zza.get(n2);
            object = object == null ? null : (zzatp)object.get(zzatf3);
            if (object != null) throw null;
        }
        object4 = new zzato(object2, (zzatg[])zzatf2, objectArray, (int[][][])object4, (zzatg)object3);
        objectArray = new zzant[2];
        n2 = 0;
        while (n2 < 2) {
            object = zzatkArray[n2] != null ? zzant.zza : null;
            objectArray[n2] = (int)object;
            ++n2;
        }
        return new zzatv(zzatg2, new zzats(zzatkArray, null), object4, (zzant[])objectArray);
    }

    public final void zze(Object object) {
        this.zzc = (zzato)object;
    }
}
