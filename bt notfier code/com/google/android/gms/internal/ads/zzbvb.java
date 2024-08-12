/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbva
 *  com.google.android.gms.internal.ads.zzbvc
 *  com.google.android.gms.internal.ads.zzccl
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbva;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzccl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbvb {
    public final List<zzbva> zza;
    public final List<String> zzb;
    public final List<String> zzc;
    public final List<String> zzd;
    public final List<String> zze;
    public final List<String> zzf;
    public final String zzg;
    public final String zzh;

    public zzbvb(JSONObject jSONObject) throws JSONException {
        Object object;
        if (com.google.android.gms.ads.internal.util.zze.zzm((int)2)) {
            object = String.valueOf(jSONObject.toString(2));
            object = ((String)object).length() != 0 ? "Mediation Response JSON: ".concat((String)object) : new String("Mediation Response JSON: ");
            com.google.android.gms.ads.internal.util.zze.zza((String)object);
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        object = new ArrayList(jSONArray.length());
        int n = -1;
        for (int i = 0; i < jSONArray.length(); ++i) {
            int n2;
            block7: {
                Object object2;
                try {
                    object2 = new zzbva(jSONArray.getJSONObject(i));
                    "banner".equalsIgnoreCase(((zzbva)object2).zzv);
                }
                catch (JSONException jSONException) {
                    n2 = n;
                    break block7;
                }
                object.add(object2);
                n2 = n;
                if (n < 0) {
                    object2 = ((zzbva)object2).zzc.iterator();
                    do {
                        n2 = n;
                        if (!object2.hasNext()) break block7;
                    } while (!((String)object2.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"));
                    n2 = i;
                }
            }
            n = n2;
        }
        jSONArray.length();
        this.zza = Collections.unmodifiableList(object);
        this.zzg = jSONObject.optString("qdata");
        jSONObject.optInt("fs_model_type", -1);
        jSONObject.optLong("timeout_ms", -1L);
        jSONObject = jSONObject.optJSONObject("settings");
        if (jSONObject == null) {
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzf = null;
            this.zzh = null;
            return;
        }
        jSONObject.optLong("ad_network_timeout_millis", -1L);
        zzt.zzu();
        this.zzb = zzbvc.zza((JSONObject)jSONObject, (String)"click_urls");
        zzt.zzu();
        this.zzc = zzbvc.zza((JSONObject)jSONObject, (String)"imp_urls");
        zzt.zzu();
        this.zzd = zzbvc.zza((JSONObject)jSONObject, (String)"downloaded_imp_urls");
        zzt.zzu();
        this.zze = zzbvc.zza((JSONObject)jSONObject, (String)"nofill_urls");
        zzt.zzu();
        this.zzf = zzbvc.zza((JSONObject)jSONObject, (String)"remote_ping_urls");
        jSONObject.optBoolean("render_in_browser", false);
        jSONObject.optLong("refresh", -1L);
        object = zzccl.zza((JSONArray)jSONObject.optJSONArray("rewards"));
        this.zzh = object == null ? null : ((zzccl)object).zza;
        jSONObject.optBoolean("use_displayed_impression", false);
        jSONObject.optBoolean("allow_pub_rendered_attribution", false);
        jSONObject.optBoolean("allow_pub_owned_ad_view", false);
        jSONObject.optBoolean("allow_custom_click_gesture", false);
    }
}
