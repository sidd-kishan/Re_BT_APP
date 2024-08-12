/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzcb
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcnn
 *  com.google.android.gms.internal.ads.zzcnv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzcb;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcnn;
import com.google.android.gms.internal.ads.zzcnv;
import java.util.Map;

final class zzbpc
implements zzbpr {
    static final zzbpr zza = new zzbpc();

    private zzbpc() {
    }

    public final void zza(Object object, Map object2) {
        object = (zzcnn)object;
        zzbpr zzbpr2 = zzbpq.zza;
        if ((object2 = (String)object2.get("u")) == null) {
            zze.zzi((String)"URL missing from httpTrack GMSG.");
            return;
        }
        new zzcb(object.getContext(), ((zzcnv)object).zzt().zza, (String)object2).zzc();
    }
}
