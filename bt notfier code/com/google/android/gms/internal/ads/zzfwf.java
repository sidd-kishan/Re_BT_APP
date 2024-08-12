/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftp
 *  com.google.android.gms.internal.ads.zzftq
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzfwg
 *  com.google.android.gms.internal.ads.zzfzp
 *  com.google.android.gms.internal.ads.zzfzv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftp;
import com.google.android.gms.internal.ads.zzftq;
import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzfwg;
import com.google.android.gms.internal.ads.zzfzp;
import com.google.android.gms.internal.ads.zzfzv;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfwf
extends zzfts<zzfzp, zzfzv> {
    final zzfwg zza;

    zzfwf(zzfwg zzfwg2, Class clazz) {
        this.zza = zzfwg2;
        super(clazz);
    }

    public final Map<String, zzftr<zzfzp>> zze() throws GeneralSecurityException {
        HashMap<String, zzftr> hashMap = new HashMap<String, zzftr>();
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzfwg.zzl((int)4, (int)5, (int)3, (zzftp)zzftq.zza((String)"AES128_GCM"), (byte[])zzfwg.zzk(), (int)1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzfwg.zzl((int)4, (int)5, (int)3, (zzftp)zzftq.zza((String)"AES128_GCM"), (byte[])zzfwg.zzk(), (int)3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzfwg.zzl((int)4, (int)5, (int)4, (zzftp)zzftq.zza((String)"AES128_GCM"), (byte[])zzfwg.zzk(), (int)1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzfwg.zzl((int)4, (int)5, (int)4, (zzftp)zzftq.zza((String)"AES128_GCM"), (byte[])zzfwg.zzk(), (int)3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzfwg.zzl((int)4, (int)5, (int)4, (zzftp)zzftq.zza((String)"AES128_GCM"), (byte[])zzfwg.zzk(), (int)3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzfwg.zzl((int)4, (int)5, (int)3, (zzftp)zzftq.zza((String)"AES128_CTR_HMAC_SHA256"), (byte[])zzfwg.zzk(), (int)1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzfwg.zzl((int)4, (int)5, (int)3, (zzftp)zzftq.zza((String)"AES128_CTR_HMAC_SHA256"), (byte[])zzfwg.zzk(), (int)3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzfwg.zzl((int)4, (int)5, (int)4, (zzftp)zzftq.zza((String)"AES128_CTR_HMAC_SHA256"), (byte[])zzfwg.zzk(), (int)1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzfwg.zzl((int)4, (int)5, (int)4, (zzftp)zzftq.zza((String)"AES128_CTR_HMAC_SHA256"), (byte[])zzfwg.zzk(), (int)3));
        return Collections.unmodifiableMap(hashMap);
    }
}
