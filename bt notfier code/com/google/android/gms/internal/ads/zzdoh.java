/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ArrayMap
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdmr
 */
package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdmr;
import java.util.Map;

public final class zzdoh
implements zzdbw {
    private final zzdmm zza;
    private final zzdmr zzb;

    public zzdoh(zzdmm zzdmm2, zzdmr zzdmr2) {
        this.zza = zzdmm2;
        this.zzb = zzdmr2;
    }

    public final void zzg() {
        if (this.zza.zzU() == null) {
            return;
        }
        zzcml zzcml2 = this.zza.zzT();
        zzcml zzcml3 = this.zza.zzR();
        if (zzcml2 != null) {
            zzcml3 = zzcml2;
        } else if (zzcml3 == null) {
            zzcml3 = null;
        }
        if (!this.zzb.zzd()) return;
        if (zzcml3 == null) return;
        zzcml3.zze("onSdkImpression", (Map)new ArrayMap());
    }
}
