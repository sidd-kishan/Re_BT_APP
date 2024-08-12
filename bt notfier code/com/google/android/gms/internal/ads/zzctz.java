/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcua
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcua;
import org.json.JSONObject;

final class zzctz
implements Runnable {
    private final zzcua zza;
    private final JSONObject zzb;

    zzctz(zzcua zzcua2, JSONObject jSONObject) {
        this.zza = zzcua2;
        this.zzb = jSONObject;
    }

    @Override
    public final void run() {
        this.zza.zzf(this.zzb);
    }
}
