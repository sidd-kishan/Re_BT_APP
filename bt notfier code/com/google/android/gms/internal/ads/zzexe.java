/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdal
 *  com.google.android.gms.internal.ads.zzexd
 *  com.google.android.gms.internal.ads.zzexn
 *  com.google.android.gms.internal.ads.zzexo
 *  com.google.android.gms.internal.ads.zzexp
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdal;
import com.google.android.gms.internal.ads.zzexd;
import com.google.android.gms.internal.ads.zzexn;
import com.google.android.gms.internal.ads.zzexo;
import com.google.android.gms.internal.ads.zzexp;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzexe<RequestComponentT extends zzdal<AdT>, AdT>
implements zzexo<RequestComponentT, AdT> {
    private final zzexo<RequestComponentT, AdT> zza;
    private RequestComponentT zzb;

    public zzexe(zzexo<RequestComponentT, AdT> zzexo2) {
        this.zza = zzexo2;
    }

    public final RequestComponentT zza() {
        RequestComponentT RequestComponentT;
        synchronized (this) {
            RequestComponentT = this.zzb;
        }
        return RequestComponentT;
    }

    public final zzfsm<AdT> zzb(zzexp zzexp2, zzexn<RequestComponentT> zzcyj2, RequestComponentT RequestComponentT) {
        synchronized (this) {
            this.zzb = RequestComponentT;
            if (zzexp2.zza != null) {
                zzcyj2 = this.zzb.zzP();
                zzexp2 = zzcyj2.zzd(zzcyj2.zzb(zzfsd.zza((Object)zzexp2.zza)));
                return zzexp2;
            }
            zzexp2 = ((zzexd)this.zza).zzb(zzexp2, (zzexn)zzcyj2, RequestComponentT);
            return zzexp2;
        }
    }
}
