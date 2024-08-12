/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzfvj
 *  com.google.android.gms.internal.ads.zzfze
 *  com.google.android.gms.internal.ads.zzfzh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzfze;
import com.google.android.gms.internal.ads.zzfzh;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfvi
extends zzfts<zzfzh, zzfze> {
    final zzfvj zza;

    zzfvi(zzfvj zzfvj2, Class clazz) {
        this.zza = zzfvj2;
        super(clazz);
    }

    public final Map<String, zzftr<zzfzh>> zze() throws GeneralSecurityException {
        HashMap<String, zzftr> hashMap = new HashMap<String, zzftr>();
        hashMap.put("CHACHA20_POLY1305", new zzftr((Object)zzfzh.zzc(), 1));
        hashMap.put("CHACHA20_POLY1305_RAW", new zzftr((Object)zzfzh.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
