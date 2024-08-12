/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzfvd
 *  com.google.android.gms.internal.ads.zzfym
 *  com.google.android.gms.internal.ads.zzfyp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzfvd;
import com.google.android.gms.internal.ads.zzfym;
import com.google.android.gms.internal.ads.zzfyp;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfvc
extends zzfts<zzfyp, zzfym> {
    final zzfvd zza;

    zzfvc(zzfvd zzfvd2, Class clazz) {
        this.zza = zzfvd2;
        super(clazz);
    }

    public final Map<String, zzftr<zzfyp>> zze() throws GeneralSecurityException {
        HashMap<String, zzftr> hashMap = new HashMap<String, zzftr>();
        hashMap.put("AES128_GCM", zzfvd.zzk((int)16, (int)1));
        hashMap.put("AES128_GCM_RAW", zzfvd.zzk((int)16, (int)3));
        hashMap.put("AES256_GCM", zzfvd.zzk((int)32, (int)1));
        hashMap.put("AES256_GCM_RAW", zzfvd.zzk((int)32, (int)3));
        return Collections.unmodifiableMap(hashMap);
    }
}
