/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbvc
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbvc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzbva {
    public final String zza;
    public final String zzb;
    public final List<String> zzc;
    public final String zzd;
    public final String zze;
    public final List<String> zzf;
    public final List<String> zzg;
    public final List<String> zzh;
    public final List<String> zzi;
    public final List<String> zzj;
    public final String zzk;
    public final List<String> zzl;
    public final List<String> zzm;
    public final List<String> zzn;
    public final String zzo;
    public final String zzp;
    public final String zzq;
    public final String zzr;
    public final String zzs;
    public final List<String> zzt;
    public final String zzu;
    public final String zzv;

    public zzbva(JSONObject jSONObject) throws JSONException {
        this.zzb = jSONObject.optString("id");
        Object object = jSONObject.getJSONArray("adapters");
        JSONObject jSONObject2 = new ArrayList(object.length());
        for (int i = 0; i < object.length(); ++i) {
            jSONObject2.add(object.getString(i));
        }
        this.zzc = Collections.unmodifiableList(jSONObject2);
        this.zzd = jSONObject.optString("allocation_id", null);
        com.google.android.gms.ads.internal.zzt.zzu();
        this.zzf = zzbvc.zza((JSONObject)jSONObject, (String)"clickurl");
        com.google.android.gms.ads.internal.zzt.zzu();
        this.zzg = zzbvc.zza((JSONObject)jSONObject, (String)"imp_urls");
        com.google.android.gms.ads.internal.zzt.zzu();
        this.zzh = zzbvc.zza((JSONObject)jSONObject, (String)"downloaded_imp_urls");
        com.google.android.gms.ads.internal.zzt.zzu();
        this.zzj = zzbvc.zza((JSONObject)jSONObject, (String)"fill_urls");
        com.google.android.gms.ads.internal.zzt.zzu();
        this.zzl = zzbvc.zza((JSONObject)jSONObject, (String)"video_start_urls");
        com.google.android.gms.ads.internal.zzt.zzu();
        this.zzn = zzbvc.zza((JSONObject)jSONObject, (String)"video_complete_urls");
        com.google.android.gms.ads.internal.zzt.zzu();
        this.zzm = zzbvc.zza((JSONObject)jSONObject, (String)"video_reward_urls");
        this.zzo = jSONObject.optString("transaction_id");
        this.zzp = jSONObject.optString("valid_from_timestamp");
        jSONObject2 = jSONObject.optJSONObject("ad");
        if (jSONObject2 != null) {
            com.google.android.gms.ads.internal.zzt.zzu();
            object = zzbvc.zza((JSONObject)jSONObject2, (String)"manual_impression_urls");
        } else {
            object = null;
        }
        this.zzi = object;
        object = jSONObject2 != null ? jSONObject2.toString() : null;
        this.zza = object;
        jSONObject2 = jSONObject.optJSONObject("data");
        object = jSONObject2 != null ? jSONObject2.toString() : null;
        this.zzk = object;
        object = jSONObject2 != null ? jSONObject2.optString("class_name") : null;
        this.zze = object;
        this.zzq = jSONObject.optString("html_template", null);
        this.zzr = jSONObject.optString("ad_base_url", null);
        object = jSONObject.optJSONObject("assets");
        object = object != null ? object.toString() : null;
        this.zzs = object;
        com.google.android.gms.ads.internal.zzt.zzu();
        this.zzt = zzbvc.zza((JSONObject)jSONObject, (String)"template_ids");
        object = jSONObject.optJSONObject("ad_loader_options");
        object = object != null ? object.toString() : null;
        this.zzu = object;
        this.zzv = jSONObject.optString("response_type", null);
        jSONObject.optLong("ad_network_timeout_millis", -1L);
    }
}
