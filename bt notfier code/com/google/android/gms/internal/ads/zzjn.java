/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzjk
 *  com.google.android.gms.internal.ads.zzjm
 *  com.google.android.gms.internal.ads.zzjo
 *  com.google.android.gms.internal.ads.zzjq
 *  com.google.android.gms.internal.ads.zzs
 *  com.google.android.gms.internal.ads.zzv
 *  com.google.android.gms.internal.ads.zzw
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzjk;
import com.google.android.gms.internal.ads.zzjm;
import com.google.android.gms.internal.ads.zzjo;
import com.google.android.gms.internal.ads.zzjq;
import com.google.android.gms.internal.ads.zzs;
import com.google.android.gms.internal.ads.zzv;
import com.google.android.gms.internal.ads.zzw;
import java.util.Map;

public final class zzjn
extends zzw {
    public static final zzjn zzA;
    @Deprecated
    public static final zzjn zzB;
    public static final zzadw<zzjn> zzN;
    public final int zzC;
    public final boolean zzD;
    public final boolean zzE;
    public final boolean zzF;
    public final boolean zzG;
    public final boolean zzH;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    private final SparseArray<Map<zzs, zzjq>> zzO;
    private final SparseBooleanArray zzP;

    static {
        zzjn zzjn2;
        zzA = zzjn2 = new zzjn(new zzjo());
        zzB = zzjn2;
        zzN = zzjm.zza;
    }

    private zzjn(zzjo zzjo2) {
        super((zzv)zzjo2);
        this.zzD = zzjo.zzl((zzjo)zzjo2);
        this.zzE = false;
        this.zzF = zzjo.zzm((zzjo)zzjo2);
        this.zzG = zzjo.zzn((zzjo)zzjo2);
        this.zzH = false;
        this.zzI = false;
        this.zzJ = false;
        this.zzC = 0;
        this.zzK = zzjo.zzo((zzjo)zzjo2);
        this.zzL = false;
        this.zzM = zzjo.zzp((zzjo)zzjo2);
        this.zzO = zzjo.zzq((zzjo)zzjo2);
        this.zzP = zzjo.zzr((zzjo)zzjo2);
    }

    /* synthetic */ zzjn(zzjo zzjo2, zzjk zzjk2) {
        this(zzjo2);
    }

    static /* synthetic */ SparseArray zza(zzjn zzjn2) {
        return zzjn2.zzO;
    }

    static /* synthetic */ SparseBooleanArray zzb(zzjn zzjn2) {
        return zzjn2.zzP;
    }

    public static zzjn zzc(Context context) {
        return new zzjn(new zzjo(context));
    }

    /*
     * Enabled force condition propagation
     */
    public final boolean equals(Object sparseArray) {
        int n;
        if (this == sparseArray) {
            return true;
        }
        if (sparseArray == null) return false;
        if (((Object)((Object)this)).getClass() != sparseArray.getClass()) {
            return false;
        }
        zzjn zzjn2 = (zzjn)sparseArray;
        if (!super.equals((Object)zzjn2)) return false;
        if (this.zzD != zzjn2.zzD) return false;
        if (this.zzF != zzjn2.zzF) return false;
        if (this.zzG != zzjn2.zzG) return false;
        if (this.zzK != zzjn2.zzK) return false;
        if (this.zzM != zzjn2.zzM) return false;
        sparseArray = this.zzP;
        SparseArray<Map<zzs, zzjq>> sparseArray2 = zzjn2.zzP;
        int n2 = sparseArray.size();
        if (sparseArray2.size() != n2) return false;
        for (n = 0; n < n2; ++n) {
            if (sparseArray2.indexOfKey(sparseArray.keyAt(n)) >= 0) continue;
            return false;
        }
        sparseArray = this.zzO;
        sparseArray2 = zzjn2.zzO;
        n2 = sparseArray.size();
        if (sparseArray2.size() != n2) return false;
        n = 0;
        while (n < n2) {
            int n3 = sparseArray2.indexOfKey(sparseArray.keyAt(n));
            if (n3 < 0) return false;
            Map map = (Map)sparseArray.valueAt(n);
            Map map2 = (Map)sparseArray2.valueAt(n3);
            n3 = map.size();
            if (map2.size() != n3) return false;
            for (Map.Entry entry : map.entrySet()) {
                map = (zzs)entry.getKey();
                if (!map2.containsKey(map)) return false;
                if (zzamq.zzc(entry.getValue(), map2.get(map))) continue;
                return false;
            }
            ++n;
        }
        return true;
    }

    public final int hashCode() {
        return (((((super.hashCode() + 31) * 31 + this.zzD) * 961 + this.zzF) * 31 + this.zzG) * 28629151 + this.zzK) * 961 + this.zzM;
    }

    public final boolean zzd(int n) {
        return this.zzP.get(n);
    }

    public final boolean zze(int n, zzs zzs2) {
        Map map = (Map)this.zzO.get(n);
        if (map == null) return false;
        if (!map.containsKey(zzs2)) return false;
        return true;
    }

    public final zzjq zzf(int n, zzs zzs2) {
        Map map = (Map)this.zzO.get(n);
        if (map == null) return null;
        return (zzjq)map.get(zzs2);
    }

    public final zzjo zzg() {
        return new zzjo(this, null);
    }
}
