/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzfwa
 *  com.google.android.gms.internal.ads.zzfyy
 *  com.google.android.gms.internal.ads.zzfza
 *  com.google.android.gms.internal.ads.zzfzb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzfwa;
import com.google.android.gms.internal.ads.zzfyy;
import com.google.android.gms.internal.ads.zzfza;
import com.google.android.gms.internal.ads.zzfzb;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfvz
extends zzfts<zzfzb, zzfyy> {
    final zzfwa zza;

    zzfvz(zzfwa zzfwa2, Class clazz) {
        this.zza = zzfwa2;
        super(clazz);
    }

    public final Map<String, zzftr<zzfzb>> zze() throws GeneralSecurityException {
        HashMap<String, zzftr> hashMap = new HashMap<String, zzftr>();
        zzfza zzfza2 = zzfzb.zzd();
        zzfza2.zza(64);
        hashMap.put("AES256_SIV", new zzftr((Object)((zzfzb)zzfza2.zzah()), 1));
        zzfza2 = zzfzb.zzd();
        zzfza2.zza(64);
        hashMap.put("AES256_SIV_RAW", new zzftr((Object)((zzfzb)zzfza2.zzah()), 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
