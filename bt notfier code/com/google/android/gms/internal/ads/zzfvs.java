/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzfvt
 *  com.google.android.gms.internal.ads.zzgcb
 *  com.google.android.gms.internal.ads.zzgce
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzfvt;
import com.google.android.gms.internal.ads.zzgcb;
import com.google.android.gms.internal.ads.zzgce;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfvs
extends zzfts<zzgce, zzgcb> {
    final zzfvt zza;

    zzfvs(zzfvt zzfvt2, Class clazz) {
        this.zza = zzfvt2;
        super(clazz);
    }

    public final Map<String, zzftr<zzgce>> zze() throws GeneralSecurityException {
        HashMap<String, zzftr> hashMap = new HashMap<String, zzftr>();
        hashMap.put("XCHACHA20_POLY1305", new zzftr((Object)zzgce.zzc(), 1));
        hashMap.put("XCHACHA20_POLY1305_RAW", new zzftr((Object)zzgce.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
