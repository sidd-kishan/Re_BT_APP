/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.initialization.InitializationStatus
 *  com.google.android.gms.internal.ads.zzbho
 *  com.google.android.gms.internal.ads.zzbhs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.internal.ads.zzbho;
import com.google.android.gms.internal.ads.zzbhs;
import java.util.HashMap;
import java.util.Map;

final class zzbhn
implements InitializationStatus {
    private final zzbhs zza;

    zzbhn(zzbhs zzbhs2) {
        this.zza = zzbhs2;
    }

    public final Map getAdapterStatusMap() {
        zzbhs zzbhs2 = this.zza;
        HashMap<String, zzbho> hashMap = new HashMap<String, zzbho>();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzbho(zzbhs2));
        return hashMap;
    }
}
