/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbph
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbph;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.Map;
import java.util.concurrent.Executor;

final class zzbpb
implements zzbpr {
    private final zzdio zza;

    zzbpb(zzdio zzdio2) {
        this.zza = zzdio2;
    }

    public final void zza(Object object, Map object2) {
        zzdio zzdio2 = this.zza;
        object = (zzcml)object;
        zzbpq.zzc((Map)object2, (zzdio)zzdio2);
        object2 = (String)object2.get("u");
        if (object2 == null) {
            zze.zzi((String)"URL missing from click GMSG.");
            return;
        }
        zzfsd.zzp((zzfsm)zzbpq.zza((zzcml)object, (String)object2), (zzfrz)new zzbph((zzcml)object), (Executor)zzchg.zza);
    }
}
