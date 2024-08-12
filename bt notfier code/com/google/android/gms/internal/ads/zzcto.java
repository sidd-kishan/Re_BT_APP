/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcml
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcml;
import org.json.JSONObject;

final class zzcto
implements Runnable {
    private final zzcml zza;
    private final JSONObject zzb;

    zzcto(zzcml zzcml2, JSONObject jSONObject) {
        this.zza = zzcml2;
        this.zzb = jSONObject;
    }

    @Override
    public final void run() {
        this.zza.zzr("AFMA_updateActiveView", this.zzb);
    }
}
