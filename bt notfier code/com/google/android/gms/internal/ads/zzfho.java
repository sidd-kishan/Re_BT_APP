/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfhw
 *  com.google.android.gms.internal.ads.zzfhx
 *  com.google.android.gms.internal.ads.zzfhy
 *  com.google.android.gms.internal.ads.zzfhz
 *  com.google.android.gms.internal.ads.zzfia
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfhw;
import com.google.android.gms.internal.ads.zzfhx;
import com.google.android.gms.internal.ads.zzfhy;
import com.google.android.gms.internal.ads.zzfhz;
import com.google.android.gms.internal.ads.zzfia;
import java.util.HashSet;
import org.json.JSONObject;

public final class zzfho {
    private JSONObject zza;
    private final zzfhx zzb;

    public zzfho(zzfhx zzfhx2) {
        this.zzb = zzfhx2;
    }

    public final void zza(JSONObject jSONObject, HashSet<String> hashSet, long l) {
        this.zzb.zza((zzfhw)new zzfia(this, hashSet, jSONObject, l, null));
    }

    public final void zzb(JSONObject jSONObject, HashSet<String> hashSet, long l) {
        this.zzb.zza((zzfhw)new zzfhz(this, hashSet, jSONObject, l, null));
    }

    public final void zzc() {
        this.zzb.zza((zzfhw)new zzfhy(this, null));
    }

    public final JSONObject zzd() {
        return this.zza;
    }

    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}
