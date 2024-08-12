/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzduq
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzfet
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzduq;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfet;
import java.util.Map;

public final class zzdur
implements zzfet {
    private final Map<zzfem, zzduq> zza;
    private final zzazb zzb;

    zzdur(zzazb zzazb2, Map<zzfem, zzduq> map) {
        this.zza = map;
        this.zzb = zzazb2;
    }

    public final void zzbE(zzfem zzfem2, String string) {
    }

    public final void zzbF(zzfem zzfem2, String string) {
        if (!this.zza.containsKey(zzfem2)) return;
        this.zzb.zzc(this.zza.get((Object)zzfem2).zza);
    }

    public final void zzc(zzfem zzfem2, String string, Throwable throwable) {
        if (!this.zza.containsKey(zzfem2)) return;
        this.zzb.zzc(this.zza.get((Object)zzfem2).zzc);
    }

    public final void zzd(zzfem zzfem2, String string) {
        if (!this.zza.containsKey(zzfem2)) return;
        this.zzb.zzc(this.zza.get((Object)zzfem2).zzb);
    }
}
