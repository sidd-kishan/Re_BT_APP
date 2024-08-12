/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcsc
 *  com.google.android.gms.internal.ads.zzdyc
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcsc;
import com.google.android.gms.internal.ads.zzdyc;
import java.util.Map;

public final class zzcsk
implements zzcsc {
    private final zzdyc zza;

    zzcsk(zzdyc zzdyc2) {
        this.zza = zzdyc2;
    }

    public final void zza(Map<String, String> object) {
        zzbjd zzbjd2 = zzbjl.zzgF;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return;
        }
        if (TextUtils.isEmpty((CharSequence)(object = object.get("policy_violations")))) {
            return;
        }
        this.zza.zzl((String)object);
    }
}
