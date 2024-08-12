/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbkt
 *  com.google.android.gms.internal.ads.zzcbo
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbkt;
import com.google.android.gms.internal.ads.zzcbo;
import java.util.LinkedHashMap;
import java.util.Map;

public final class zzbjo {
    private final String zza;
    private final Map<String, String> zzb;
    private final Context zzc;
    private final String zzd;

    public zzbjo(Context object, String object2) {
        this.zzc = object;
        this.zzd = object2;
        this.zza = (String)zzbkt.zzb.zze();
        object2 = new LinkedHashMap();
        this.zzb = object2;
        object2.put("s", "gmob_sdk");
        this.zzb.put("v", "3");
        this.zzb.put("os", Build.VERSION.RELEASE);
        this.zzb.put("api_v", Build.VERSION.SDK);
        object2 = this.zzb;
        zzt.zzc();
        object2.put((String)"device", (String)zzs.zzx());
        Map<String, String> map = this.zzb;
        object2 = object.getApplicationContext() != null ? object.getApplicationContext().getPackageName() : object.getPackageName();
        map.put("app", (String)object2);
        object2 = this.zzb;
        zzt.zzc();
        object = true != zzs.zzH((Context)object) ? "0" : "1";
        object2.put((String)"is_lite_sdk", (String)object);
        object = zzt.zzn().zzb(this.zzc);
        try {
            this.zzb.put("network_coarse", Integer.toString(((zzcbo)object.get()).zzk));
            this.zzb.put("network_fine", Integer.toString(((zzcbo)object.get()).zzl));
            return;
        }
        catch (Exception exception) {
            zzt.zzg().zzk((Throwable)exception, "CsiConfiguration.CsiConfiguration");
            return;
        }
    }

    final String zza() {
        return this.zza;
    }

    final Context zzb() {
        return this.zzc;
    }

    final String zzc() {
        return this.zzd;
    }

    final Map<String, String> zzd() {
        return this.zzb;
    }
}
