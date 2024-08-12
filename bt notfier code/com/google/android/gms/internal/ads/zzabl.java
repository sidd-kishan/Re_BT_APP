/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzaav
 *  com.google.android.gms.internal.ads.zzabk
 *  com.google.android.gms.internal.ads.zzaby
 *  com.google.android.gms.internal.ads.zzfik
 *  com.google.android.gms.internal.ads.zzfjb
 *  com.google.android.gms.internal.ads.zzfkh
 *  com.google.android.gms.internal.ads.zzyz
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzaav;
import com.google.android.gms.internal.ads.zzabk;
import com.google.android.gms.internal.ads.zzaby;
import com.google.android.gms.internal.ads.zzfik;
import com.google.android.gms.internal.ads.zzfjb;
import com.google.android.gms.internal.ads.zzfkh;
import com.google.android.gms.internal.ads.zzyz;
import java.util.HashMap;
import java.util.Map;

final class zzabl
implements zzfkh {
    private final zzfik zza;
    private final zzfjb zzb;
    private final zzaby zzc;
    private final zzabk zzd;
    private final zzaav zze;

    zzabl(zzfik zzfik2, zzfjb zzfjb2, zzaby zzaby2, zzabk zzabk2, zzaav zzaav2) {
        this.zza = zzfik2;
        this.zzb = zzfjb2;
        this.zzc = zzaby2;
        this.zzd = zzabk2;
        this.zze = zzaav2;
    }

    private final Map<String, Object> zze() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        zzyz zzyz2 = this.zzb.zzc();
        hashMap.put("v", this.zza.zza());
        hashMap.put("gms", this.zza.zzc());
        hashMap.put("int", zzyz2.zzc());
        hashMap.put("up", this.zzd.zza());
        hashMap.put("t", new Throwable());
        return hashMap;
    }

    final void zza(View view) {
        this.zzc.zza(view);
    }

    public final Map<String, Object> zzb() {
        Map<String, Object> map = this.zze();
        zzyz zzyz2 = this.zzb.zzb();
        map.put("gai", this.zza.zzb());
        map.put("did", zzyz2.zzd());
        map.put("dst", zzyz2.zzag() - 1);
        map.put("doo", zzyz2.zze());
        zzyz2 = this.zze;
        if (zzyz2 == null) return map;
        map.put("nt", zzyz2.zzd());
        return map;
    }

    public final Map<String, Object> zzc() {
        return this.zze();
    }

    public final Map<String, Object> zzd() {
        Map<String, Object> map = this.zze();
        map.put("lts", this.zzc.zzc());
        return map;
    }
}
