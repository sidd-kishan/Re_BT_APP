/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzjk
 *  com.google.android.gms.internal.ads.zzjn
 *  com.google.android.gms.internal.ads.zzjq
 *  com.google.android.gms.internal.ads.zzs
 *  com.google.android.gms.internal.ads.zzv
 *  com.google.android.gms.internal.ads.zzw
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzjk;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzjq;
import com.google.android.gms.internal.ads.zzs;
import com.google.android.gms.internal.ads.zzv;
import com.google.android.gms.internal.ads.zzw;
import java.util.HashMap;
import java.util.Map;

public final class zzjo
extends zzv {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final SparseArray<Map<zzs, zzjq>> zzf;
    private final SparseBooleanArray zzg;

    @Deprecated
    public zzjo() {
        this.zzf = new SparseArray();
        this.zzg = new SparseBooleanArray();
        this.zzt();
    }

    public zzjo(Context context) {
        super.zzk(context);
        context = zzamq.zzaa((Context)context);
        this.zzj(context.x, context.y, true);
        this.zzf = new SparseArray();
        this.zzg = new SparseBooleanArray();
        this.zzt();
    }

    /* synthetic */ zzjo(zzjn zzjn2, zzjk zzjk2) {
        super((zzw)zzjn2);
        this.zza = zzjn2.zzD;
        this.zzb = zzjn2.zzF;
        this.zzc = zzjn2.zzG;
        this.zzd = zzjn2.zzK;
        this.zze = zzjn2.zzM;
        zzjk2 = zzjn.zza((zzjn)zzjn2);
        SparseArray sparseArray = new SparseArray();
        int n = 0;
        while (true) {
            if (n >= zzjk2.size()) {
                this.zzf = sparseArray;
                this.zzg = zzjn.zzb((zzjn)zzjn2).clone();
                return;
            }
            sparseArray.put(zzjk2.keyAt(n), new HashMap((Map)zzjk2.valueAt(n)));
            ++n;
        }
    }

    static /* synthetic */ boolean zzl(zzjo zzjo2) {
        return zzjo2.zza;
    }

    static /* synthetic */ boolean zzm(zzjo zzjo2) {
        return zzjo2.zzb;
    }

    static /* synthetic */ boolean zzn(zzjo zzjo2) {
        return zzjo2.zzc;
    }

    static /* synthetic */ boolean zzo(zzjo zzjo2) {
        return zzjo2.zzd;
    }

    static /* synthetic */ boolean zzp(zzjo zzjo2) {
        return zzjo2.zze;
    }

    static /* synthetic */ SparseArray zzq(zzjo zzjo2) {
        return zzjo2.zzf;
    }

    static /* synthetic */ SparseBooleanArray zzr(zzjo zzjo2) {
        return zzjo2.zzg;
    }

    private final void zzt() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
    }

    public final zzjo zzs(int n, boolean bl) {
        if (this.zzg.get(n) == bl) {
            return this;
        }
        if (bl) {
            this.zzg.put(n, true);
        } else {
            this.zzg.delete(n);
        }
        return this;
    }
}
