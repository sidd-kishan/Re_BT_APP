/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzfwx
 *  com.google.android.gms.internal.ads.zzgai
 *  com.google.android.gms.internal.ads.zzgal
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzfwx;
import com.google.android.gms.internal.ads.zzgai;
import com.google.android.gms.internal.ads.zzgal;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfww
extends zzfts<zzgal, zzgai> {
    final zzfwx zza;

    zzfww(zzfwx zzfwx2, Class clazz) {
        this.zza = zzfwx2;
        super(clazz);
    }

    public final Map<String, zzftr<zzgal>> zze() throws GeneralSecurityException {
        HashMap<String, zzftr> hashMap = new HashMap<String, zzftr>();
        hashMap.put("HMAC_SHA256_128BITTAG", zzfwx.zzm((int)32, (int)16, (int)5, (int)1));
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzfwx.zzm((int)32, (int)16, (int)5, (int)3));
        hashMap.put("HMAC_SHA256_256BITTAG", zzfwx.zzm((int)32, (int)32, (int)5, (int)1));
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzfwx.zzm((int)32, (int)32, (int)5, (int)3));
        hashMap.put("HMAC_SHA512_128BITTAG", zzfwx.zzm((int)64, (int)16, (int)6, (int)1));
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzfwx.zzm((int)64, (int)16, (int)6, (int)3));
        hashMap.put("HMAC_SHA512_256BITTAG", zzfwx.zzm((int)64, (int)32, (int)6, (int)1));
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzfwx.zzm((int)64, (int)32, (int)6, (int)3));
        hashMap.put("HMAC_SHA512_512BITTAG", zzfwx.zzm((int)64, (int)64, (int)6, (int)1));
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzfwx.zzm((int)64, (int)64, (int)6, (int)3));
        return Collections.unmodifiableMap(hashMap);
    }
}
