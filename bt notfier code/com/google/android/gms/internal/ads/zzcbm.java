/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public final class zzcbm {
    private final List<String> zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final int zzj;
    private final JSONObject zzk;
    private final String zzl;
    private final String zzm;

    public zzcbm(JSONObject jSONObject) {
        this.zzi = jSONObject.optString("url");
        this.zzb = jSONObject.optString("base_uri");
        this.zzc = jSONObject.optString("post_parameters");
        this.zze = zzcbm.zzj(jSONObject.optString("drt_include"));
        this.zzf = zzcbm.zzj(jSONObject.optString("cookies_include", "true"));
        this.zzg = jSONObject.optString("request_id");
        this.zzd = jSONObject.optString("type");
        Object object = jSONObject.optString("errors");
        object = object == null ? null : Arrays.asList(((String)object).split(","));
        this.zza = object;
        int n = jSONObject.optInt("valid", 0);
        int n2 = 1;
        if (n == 1) {
            n2 = -2;
        }
        this.zzj = n2;
        this.zzh = jSONObject.optString("fetched_ad");
        jSONObject.optBoolean("render_test_ad_label");
        JSONObject jSONObject2 = jSONObject.optJSONObject("preprocessor_flags");
        object = jSONObject2;
        if (jSONObject2 == null) {
            object = new JSONObject();
        }
        this.zzk = object;
        this.zzl = jSONObject.optString("analytics_query_ad_event_id");
        jSONObject.optBoolean("is_analytics_logging_enabled");
        this.zzm = jSONObject.optString("pool_key");
    }

    private static boolean zzj(String string) {
        boolean bl = true;
        if (string != null) {
            if (string.equals("1")) return bl;
            if (string.equals("true")) return true;
        }
        bl = false;
        return bl;
    }

    public final int zza() {
        return this.zzj;
    }

    public final List<String> zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzi;
    }

    public final boolean zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        return this.zzf;
    }

    public final JSONObject zzh() {
        return this.zzk;
    }

    public final String zzi() {
        return this.zzm;
    }
}
