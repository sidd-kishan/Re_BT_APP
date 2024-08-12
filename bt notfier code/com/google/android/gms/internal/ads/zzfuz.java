/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzfva
 *  com.google.android.gms.internal.ads.zzfyd
 *  com.google.android.gms.internal.ads.zzfyg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzfva;
import com.google.android.gms.internal.ads.zzfyd;
import com.google.android.gms.internal.ads.zzfyg;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfuz
extends zzfts<zzfyg, zzfyd> {
    final zzfva zza;

    zzfuz(zzfva zzfva2, Class clazz) {
        this.zza = zzfva2;
        super(clazz);
    }

    public final Map<String, zzftr<zzfyg>> zze() throws GeneralSecurityException {
        HashMap<String, zzftr> hashMap = new HashMap<String, zzftr>();
        hashMap.put("AES128_EAX", zzfva.zzk((int)16, (int)16, (int)1));
        hashMap.put("AES128_EAX_RAW", zzfva.zzk((int)16, (int)16, (int)3));
        hashMap.put("AES256_EAX", zzfva.zzk((int)32, (int)16, (int)1));
        hashMap.put("AES256_EAX_RAW", zzfva.zzk((int)32, (int)16, (int)3));
        return Collections.unmodifiableMap(hashMap);
    }
}
