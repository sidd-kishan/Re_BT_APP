/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdpl
 *  com.google.android.gms.internal.ads.zzdpn
 *  com.google.android.gms.internal.ads.zzdpo
 *  com.google.android.gms.internal.ads.zzdpp
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpl;
import com.google.android.gms.internal.ads.zzdpn;
import com.google.android.gms.internal.ads.zzdpo;
import com.google.android.gms.internal.ads.zzdpp;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzdpq {
    private final Executor zza;
    private final zzdpl zzb;

    public zzdpq(Executor executor, zzdpl zzdpl2) {
        this.zza = executor;
        this.zzb = zzdpl2;
    }

    public final zzfsm<List<zzdpp>> zza(JSONObject object, String string) {
        string = object.optJSONArray("custom_assets");
        if (string == null) {
            return zzfsd.zza(Collections.emptyList());
        }
        ArrayList<JSONObject> arrayList = new ArrayList<JSONObject>();
        int n = string.length();
        int n2 = 0;
        while (n2 < n) {
            String string2;
            JSONObject jSONObject = string.optJSONObject(n2);
            object = jSONObject == null ? zzfsd.zza(null) : ((object = jSONObject.optString("name")) == null ? zzfsd.zza(null) : ("string".equals(string2 = jSONObject.optString("type")) ? zzfsd.zza((Object)new zzdpp((String)object, jSONObject.optString("string_value"))) : ("image".equals(string2) ? zzfsd.zzj((zzfsm)this.zzb.zza(jSONObject, "image_value"), (zzfln)new zzdpo((String)object), (Executor)this.zza) : zzfsd.zza(null))));
            arrayList.add((JSONObject)object);
            ++n2;
        }
        return zzfsd.zzj((zzfsm)zzfsd.zzk(arrayList), (zzfln)zzdpn.zza, (Executor)this.zza);
    }
}
