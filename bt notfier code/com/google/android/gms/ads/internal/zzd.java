/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import org.json.JSONObject;

final class zzd
implements zzfrk {
    static final zzfrk zza = new zzd();

    private zzd() {
    }

    public final zzfsm zza(Object object) {
        if (!(object = (JSONObject)object).optBoolean("isSuccessful", false)) return zzfsd.zza(null);
        object = object.getString("appSettingsJson");
        zzt.zzg().zzp().zzm((String)object);
        return zzfsd.zza(null);
    }
}
