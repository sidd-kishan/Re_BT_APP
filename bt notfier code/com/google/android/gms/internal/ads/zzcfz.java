/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbvb
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbvb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcfz {
    private final List<String> zza;
    private final List<String> zzb;
    private final Map<String, zzbvb> zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private JSONObject zzg;
    private boolean zzh;
    private final List<String> zzi;
    private boolean zzj;

    /*
     * Enabled unnecessary exception pruning
     */
    public zzcfz(String string, long l) {
        block13: {
            this.zza = new ArrayList<String>();
            this.zzb = new ArrayList<String>();
            this.zzc = new HashMap<String, zzbvb>();
            this.zzh = false;
            this.zzi = new ArrayList<String>();
            this.zzj = false;
            this.zze = string;
            this.zzf = l;
            if (TextUtils.isEmpty((CharSequence)string)) {
                return;
            }
            try {
                int n;
                JSONObject jSONObject;
                this.zzg = jSONObject = new JSONObject(string);
                if (jSONObject.optInt("status", -1) != 1) {
                    this.zzh = false;
                    com.google.android.gms.ads.internal.util.zze.zzi((String)"App settings could not be fetched successfully.");
                    return;
                }
                this.zzh = true;
                this.zzd = this.zzg.optString("app_id");
                string = this.zzg.optJSONArray("ad_unit_id_settings");
                if (string != null) {
                    for (n = 0; n < string.length(); ++n) {
                        JSONObject jSONObject2 = string.getJSONObject(n);
                        String string2 = jSONObject2.optString("format");
                        String string3 = jSONObject2.optString("ad_unit_id");
                        if (TextUtils.isEmpty((CharSequence)string2) || TextUtils.isEmpty((CharSequence)string3)) continue;
                        if ("interstitial".equalsIgnoreCase(string2)) {
                            this.zzb.add(string3);
                            continue;
                        }
                        if (!"rewarded".equalsIgnoreCase(string2) && !"rewarded_interstitial".equals(string2) || (jSONObject2 = jSONObject2.optJSONObject("mediation_config")) == null) continue;
                        super(jSONObject2);
                        this.zzc.put(string3, (zzbvb)string2);
                    }
                }
                if ((string = this.zzg.optJSONArray("persistable_banner_ad_unit_ids")) != null) {
                    for (n = 0; n < string.length(); ++n) {
                        String string4 = string.optString(n);
                        this.zza.add(string4);
                    }
                }
                string = zzbjl.zzff;
                boolean bl = (Boolean)zzbet.zzc().zzc((zzbjd)string);
                if (!bl || (string = this.zzg.optJSONObject("common_settings")) == null || (string = string.optJSONArray("loeid")) == null) break block13;
                for (n = 0; n < string.length(); ++n) {
                    this.zzi.add(string.get(n).toString());
                }
            }
            catch (JSONException jSONException) {
                com.google.android.gms.ads.internal.util.zze.zzj((String)"Exception occurred while processing app setting json", (Throwable)jSONException);
                zzt.zzg().zzk((Throwable)jSONException, "AppSettings.parseAppSettingsJson");
                return;
            }
        }
        string = zzbjl.zzeD;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)string) == false) return;
        string = this.zzg.optJSONObject("common_settings");
        if (string == null) return;
        this.zzj = string.optBoolean("is_prefetching_enabled", false);
    }

    public final void zza(long l) {
        this.zzf = l;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final boolean zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zze;
    }

    public final String zze() {
        return this.zzd;
    }

    public final Map<String, zzbvb> zzf() {
        return this.zzc;
    }

    public final JSONObject zzg() {
        return this.zzg;
    }

    public final List<String> zzh() {
        return this.zzi;
    }

    public final boolean zzi() {
        return this.zzj;
    }
}
