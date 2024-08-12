/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzcbt
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzetj
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzcbt;
import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzetj;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import org.json.JSONException;
import org.json.JSONObject;

final class zzetk
implements zzery<zzerx<JSONObject>> {
    private final JSONObject zza;

    zzetk(Context context) {
        this.zza = zzcbt.zzb((Context)context);
    }

    public final zzfsm<zzerx<JSONObject>> zza() {
        return zzfsd.zza((Object)new zzetj(this));
    }

    final /* synthetic */ void zzb(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", (Object)this.zza);
            return;
        }
        catch (JSONException jSONException) {
            zze.zza((String)"Failed putting version constants.");
            return;
        }
    }
}
