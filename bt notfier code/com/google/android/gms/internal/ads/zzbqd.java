/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbqe
 *  com.google.android.gms.internal.ads.zzbqf
 *  com.google.android.gms.internal.ads.zzbtv
 *  com.google.android.gms.internal.ads.zzchl
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqe;
import com.google.android.gms.internal.ads.zzbqf;
import com.google.android.gms.internal.ads.zzbtv;
import com.google.android.gms.internal.ads.zzchl;
import org.json.JSONObject;

final class zzbqd
implements zzbqe {
    final zzchl zza;

    zzbqd(zzbqf zzbqf2, zzchl zzchl2) {
        this.zza = zzchl2;
    }

    public final void zza(JSONObject jSONObject) {
        this.zza.zzc((Object)jSONObject);
    }

    public final void zzb(String string) {
        this.zza.zzd((Throwable)new zzbtv(string));
    }
}
