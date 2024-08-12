/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzcsc
 *  com.google.android.gms.internal.ads.zzdyc
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzcsc;
import com.google.android.gms.internal.ads.zzdyc;
import java.util.Map;

public final class zzcsu
implements zzcsc {
    private final zzdyc zza;

    zzcsu(zzdyc zzdyc2) {
        this.zza = zzdyc2;
    }

    public final void zza(Map<String, String> object) {
        if (TextUtils.isEmpty((CharSequence)(object = object.get("test_mode_enabled")))) {
            return;
        }
        this.zza.zzc(((String)object).equals("true"));
    }
}
