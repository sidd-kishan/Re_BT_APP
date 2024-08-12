/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzfuu
 *  com.google.android.gms.internal.ads.zzfxo
 *  com.google.android.gms.internal.ads.zzfxr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzfuu;
import com.google.android.gms.internal.ads.zzfxo;
import com.google.android.gms.internal.ads.zzfxr;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfut
extends zzfts<zzfxr, zzfxo> {
    final zzfuu zza;

    zzfut(zzfuu zzfuu2, Class clazz) {
        this.zza = zzfuu2;
        super(clazz);
    }

    public final Map<String, zzftr<zzfxr>> zze() throws GeneralSecurityException {
        HashMap<String, zzftr> hashMap = new HashMap<String, zzftr>();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzfuu.zzk((int)16, (int)16, (int)32, (int)16, (int)5, (int)1));
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzfuu.zzk((int)16, (int)16, (int)32, (int)16, (int)5, (int)3));
        hashMap.put("AES256_CTR_HMAC_SHA256", zzfuu.zzk((int)32, (int)16, (int)32, (int)32, (int)5, (int)1));
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzfuu.zzk((int)32, (int)16, (int)32, (int)32, (int)5, (int)3));
        return Collections.unmodifiableMap(hashMap);
    }
}
