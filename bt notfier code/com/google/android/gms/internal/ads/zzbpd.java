/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcnu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcnu;
import java.util.Map;

final class zzbpd
implements zzbpr {
    static final zzbpr zza = new zzbpd();

    private zzbpd() {
    }

    public final void zza(Object object, Map object2) {
        object = (zzcnu)object;
        Object object3 = zzbpq.zza;
        object3 = (String)object2.get("tx");
        String string = (String)object2.get("ty");
        object2 = (String)object2.get("td");
        try {
            int n = Integer.parseInt((String)object3);
            int n2 = Integer.parseInt(string);
            int n3 = Integer.parseInt((String)object2);
            object = object.zzU();
            if (object == null) return;
            object.zzb().zzk(n, n2, n3);
            return;
        }
        catch (NumberFormatException numberFormatException) {
            zze.zzi((String)"Could not parse touch parameters from gmsg.");
            return;
        }
    }
}
