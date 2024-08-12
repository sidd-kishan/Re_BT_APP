/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzfwu
 *  com.google.android.gms.internal.ads.zzfxf
 *  com.google.android.gms.internal.ads.zzfxh
 *  com.google.android.gms.internal.ads.zzfxi
 *  com.google.android.gms.internal.ads.zzfxk
 *  com.google.android.gms.internal.ads.zzfxl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzfwu;
import com.google.android.gms.internal.ads.zzfxf;
import com.google.android.gms.internal.ads.zzfxh;
import com.google.android.gms.internal.ads.zzfxi;
import com.google.android.gms.internal.ads.zzfxk;
import com.google.android.gms.internal.ads.zzfxl;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfwt
extends zzfts<zzfxi, zzfxf> {
    zzfwt(zzfwu zzfwu2, Class clazz) {
        super(clazz);
    }

    public final Map<String, zzftr<zzfxi>> zze() throws GeneralSecurityException {
        HashMap<String, zzftr> hashMap = new HashMap<String, zzftr>();
        zzfxh zzfxh2 = zzfxi.zze();
        zzfxh2.zza(32);
        zzfxk zzfxk2 = zzfxl.zzc();
        zzfxk2.zza(16);
        zzfxh2.zzb((zzfxl)zzfxk2.zzah());
        hashMap.put("AES_CMAC", new zzftr((Object)((zzfxi)zzfxh2.zzah()), 1));
        zzfxk2 = zzfxi.zze();
        zzfxk2.zza(32);
        zzfxh2 = zzfxl.zzc();
        zzfxh2.zza(16);
        zzfxk2.zzb((zzfxl)zzfxh2.zzah());
        hashMap.put("AES256_CMAC", new zzftr((Object)((zzfxi)zzfxk2.zzah()), 1));
        zzfxh2 = zzfxi.zze();
        zzfxh2.zza(32);
        zzfxk2 = zzfxl.zzc();
        zzfxk2.zza(16);
        zzfxh2.zzb((zzfxl)zzfxk2.zzah());
        hashMap.put("AES256_CMAC_RAW", new zzftr((Object)((zzfxi)zzfxh2.zzah()), 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
