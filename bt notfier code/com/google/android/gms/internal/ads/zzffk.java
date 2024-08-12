/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgz
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgz;
import java.util.List;
import java.util.Map;

public final class zzffk {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public zzffk(Context context, zzcgz zzcgz2) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = zzcgz2.zza;
    }

    public final void zza(Map<String, String> map) {
        map.put("s", "gmob_sdk");
        map.put("v", "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzt.zzc();
        map.put("device", zzs.zzx());
        map.put("app", this.zzb);
        zzt.zzc();
        String string = true != zzs.zzH((Context)this.zza) ? "0" : "1";
        map.put("is_lite_sdk", string);
        List list = zzbjl.zzd();
        string = zzbjl.zzff;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)string)).booleanValue()) {
            list.addAll(zzt.zzg().zzp().zzn().zzh());
        }
        map.put("e", TextUtils.join((CharSequence)",", (Iterable)list));
        map.put("sdkVersion", this.zzc);
    }
}
