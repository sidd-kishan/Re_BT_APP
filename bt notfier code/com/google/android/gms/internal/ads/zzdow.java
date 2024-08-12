/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdoy
 *  com.google.android.gms.internal.ads.zzehs
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfar
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdoy;
import com.google.android.gms.internal.ads.zzehs;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfar;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final class zzdow
implements Callable {
    private final zzdoy zza;
    private final zzfal zzb;
    private final zzezz zzc;
    private final JSONObject zzd;

    zzdow(zzdoy zzdoy2, zzfal zzfal2, zzezz zzezz2, JSONObject jSONObject) {
        this.zza = zzdoy2;
        this.zzb = zzfal2;
        this.zzc = zzezz2;
        this.zzd = jSONObject;
    }

    public final Object call() {
        Object object = this.zzb;
        Object object2 = this.zzc;
        JSONObject jSONObject = this.zzd;
        zzdmm zzdmm2 = new zzdmm();
        zzdmm2.zza(jSONObject.optInt("template_id", -1));
        zzdmm2.zzl(jSONObject.optString("custom_template_id"));
        Object object3 = jSONObject.optJSONObject("omid_settings");
        object3 = object3 != null ? object3.optString("omid_partner_name") : null;
        zzdmm2.zzt((String)object3);
        object3 = object.zza.zza;
        if (!((zzfar)object3).zzg.contains(Integer.toString(zzdmm2.zzv()))) {
            int n = zzdmm2.zzv();
            object3 = new StringBuilder(32);
            ((StringBuilder)object3).append("Invalid template ID: ");
            ((StringBuilder)object3).append(n);
            throw new zzehs(1, ((StringBuilder)object3).toString());
        }
        if (zzdmm2.zzv() == 3) {
            if (zzdmm2.zzQ() == null) throw new zzehs(1, "No custom template id for custom template ad response.");
            if (!((zzfar)object3).zzh.contains(zzdmm2.zzQ())) throw new zzehs(1, "Unexpected custom template id in the response.");
        }
        zzdmm2.zzi(jSONObject.optDouble("rating", -1.0));
        object = jSONObject.optString("headline", null);
        object3 = object;
        if (object2.zzI) {
            zzt.zzc();
            object2 = zzs.zzC();
            object3 = new StringBuilder(String.valueOf(object2).length() + 3 + String.valueOf(object).length());
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(" : ");
            ((StringBuilder)object3).append((String)object);
            object3 = ((StringBuilder)object3).toString();
        }
        zzdmm2.zzq("headline", (String)object3);
        zzdmm2.zzq("body", jSONObject.optString("body", null));
        zzdmm2.zzq("call_to_action", jSONObject.optString("call_to_action", null));
        zzdmm2.zzq("store", jSONObject.optString("store", null));
        zzdmm2.zzq("price", jSONObject.optString("price", null));
        zzdmm2.zzq("advertiser", jSONObject.optString("advertiser", null));
        return zzdmm2;
    }
}
