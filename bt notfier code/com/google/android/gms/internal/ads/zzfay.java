/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcmc
 *  com.google.android.gms.internal.ads.zzcni
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzeds
 *  com.google.android.gms.internal.ads.zzffu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcmc;
import com.google.android.gms.internal.ads.zzcni;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzeds;
import com.google.android.gms.internal.ads.zzffu;
import java.util.Map;

final class zzfay
implements zzbpr {
    private final zzffu zza;
    private final zzedq zzb;

    zzfay(zzffu zzffu2, zzedq zzedq2) {
        this.zza = zzffu2;
        this.zzb = zzedq2;
    }

    public final void zza(Object object, Map object2) {
        zzffu zzffu2 = this.zza;
        zzedq zzedq2 = this.zzb;
        object = (zzcmc)object;
        if ((object2 = (String)object2.get("u")) == null) {
            zze.zzi((String)"URL missing from httpTrack GMSG.");
            return;
        }
        if (!object.zzF().zzaf) {
            zzffu2.zzb((String)object2);
            return;
        }
        zzedq2.zze(new zzeds(zzt.zzj().currentTimeMillis(), ((zzcni)object).zzaB().zzb, (String)object2, 2));
    }
}
