/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdal
 *  com.google.android.gms.internal.ads.zzewp
 *  com.google.android.gms.internal.ads.zzewt
 *  com.google.android.gms.internal.ads.zzexn
 *  com.google.android.gms.internal.ads.zzexo
 *  com.google.android.gms.internal.ads.zzfcl
 *  com.google.android.gms.internal.ads.zzfcw
 *  com.google.android.gms.internal.ads.zzfcx
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdal;
import com.google.android.gms.internal.ads.zzewp;
import com.google.android.gms.internal.ads.zzewt;
import com.google.android.gms.internal.ads.zzexn;
import com.google.android.gms.internal.ads.zzexo;
import com.google.android.gms.internal.ads.zzfcl;
import com.google.android.gms.internal.ads.zzfcw;
import com.google.android.gms.internal.ads.zzfcx;
import com.google.android.gms.internal.ads.zzfsm;

final class zzews<R extends zzdal<AdT>, AdT extends zzcxg>
implements zzfcw<R, AdT> {
    private final zzexo<R, zzfcl<R, AdT>> zza;

    public zzews(zzexo<R, zzfcl<R, AdT>> zzexo2) {
        this.zza = zzexo2;
    }

    public final zzfsm<zzfcl<R, AdT>> zza(zzfcx<R, AdT> zzexp2) {
        zzewt zzewt2 = (zzewt)zzexp2;
        zzexo<R, zzfcl<R, AdT>> zzexo2 = this.zza;
        zzexp2 = zzewt2.zzb;
        zzewt2 = zzewt2.zza;
        return ((zzewp)zzexo2).zzb(zzexp2, (zzexn)zzewt2, null);
    }

    public final void zzb(zzfcl<R, AdT> zzfcl2) {
        zzfcl2.zza = ((zzewp)this.zza).zza();
    }
}
