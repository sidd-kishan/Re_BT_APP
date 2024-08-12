/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdpl
 *  com.google.android.gms.internal.ads.zzfln
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpl;
import com.google.android.gms.internal.ads.zzfln;
import java.util.List;
import org.json.JSONObject;

final class zzdpf
implements zzfln {
    private final zzdpl zza;
    private final JSONObject zzb;

    zzdpf(zzdpl zzdpl2, JSONObject jSONObject) {
        this.zza = zzdpl2;
        this.zzb = jSONObject;
    }

    public final Object apply(Object object) {
        return this.zza.zzg(this.zzb, (List)object);
    }
}
