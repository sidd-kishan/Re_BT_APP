/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdal
 *  com.google.android.gms.internal.ads.zzexn
 *  com.google.android.gms.internal.ads.zzexo
 *  com.google.android.gms.internal.ads.zzexp
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdal;
import com.google.android.gms.internal.ads.zzexn;
import com.google.android.gms.internal.ads.zzexo;
import com.google.android.gms.internal.ads.zzexp;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzexd<RequestComponentT extends zzdal<AdT>, AdT>
implements zzexo<RequestComponentT, AdT> {
    private RequestComponentT zza;

    public final RequestComponentT zza() {
        RequestComponentT RequestComponentT;
        synchronized (this) {
            RequestComponentT = this.zza;
        }
        return RequestComponentT;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final zzfsm<AdT> zzb(zzexp zzexp2, zzexn<RequestComponentT> zzexn2, RequestComponentT RequestComponentT) {
        synchronized (this) {
            void var2_2;
            void var3_3;
            this.zza = var3_3 != null ? var3_3 : (zzdal)var2_2.zza(zzexp2.zzb).zzf();
            zzexp2 = this.zza.zzP();
            return zzexp2.zzd(zzexp2.zzc());
        }
    }
}
