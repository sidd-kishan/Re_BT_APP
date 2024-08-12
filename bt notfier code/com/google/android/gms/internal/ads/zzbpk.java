/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbpr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbpr;
import java.util.Map;

final class zzbpk
implements zzbpr<Object> {
    zzbpk() {
    }

    public final void zza(Object object, Map<String, String> map) {
        object = String.valueOf(map.get("string"));
        object = ((String)object).length() != 0 ? "Received log message: ".concat((String)object) : new String("Received log message: ");
        zze.zzh((String)object);
    }
}
