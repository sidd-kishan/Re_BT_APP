/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzfvg
 *  com.google.android.gms.internal.ads.zzfys
 *  com.google.android.gms.internal.ads.zzfyv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzfvg;
import com.google.android.gms.internal.ads.zzfys;
import com.google.android.gms.internal.ads.zzfyv;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfvf
extends zzfts<zzfyv, zzfys> {
    final zzfvg zza;

    zzfvf(zzfvg zzfvg2, Class clazz) {
        this.zza = zzfvg2;
        super(clazz);
    }

    public final Map<String, zzftr<zzfyv>> zze() throws GeneralSecurityException {
        HashMap<String, zzftr> hashMap = new HashMap<String, zzftr>();
        hashMap.put("AES128_GCM_SIV", zzfvg.zzl((int)16, (int)1));
        hashMap.put("AES128_GCM_SIV_RAW", zzfvg.zzl((int)16, (int)3));
        hashMap.put("AES256_GCM_SIV", zzfvg.zzl((int)32, (int)1));
        hashMap.put("AES256_GCM_SIV_RAW", zzfvg.zzl((int)32, (int)3));
        return Collections.unmodifiableMap(hashMap);
    }
}
