/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzi
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzi;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final class zzf
implements Callable {
    private final zzi zza;
    private final String zzb;
    private final JSONObject zzc;

    zzf(zzi zzi2, String string, JSONObject jSONObject) {
        this.zza = zzi2;
        this.zzb = string;
        this.zzc = jSONObject;
    }

    public final Object call() {
        return this.zza.zza(this.zzb, this.zzc);
    }
}
