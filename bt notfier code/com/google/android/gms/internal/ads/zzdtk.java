/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdth
 *  com.google.android.gms.internal.ads.zzdti
 *  com.google.android.gms.internal.ads.zzdtj
 *  com.google.android.gms.internal.ads.zzdtm
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdth;
import com.google.android.gms.internal.ads.zzdti;
import com.google.android.gms.internal.ads.zzdtj;
import com.google.android.gms.internal.ads.zzdtm;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzdtk {
    private final Map<String, Map<String, JSONObject>> zza = new ConcurrentHashMap<String, Map<String, JSONObject>>();
    private JSONObject zzb;
    private final Executor zzc;
    private boolean zzd;
    private JSONObject zze;

    public zzdtk(Executor executor) {
        this.zzc = executor;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final void zzg() {
        synchronized (this) {
            this.zzd = true;
            Object object = zzt.zzg().zzp().zzn();
            if (object == null) {
                return;
            }
            JSONObject jSONObject = object.zzg();
            if (jSONObject == null) {
                return;
            }
            object = zzbjl.zzcv;
            object = (Boolean)zzbet.zzc().zzc((zzbjd)object) != false ? jSONObject.optJSONObject("common_settings") : null;
            this.zzb = object;
            this.zze = jSONObject.optJSONObject("ad_unit_patterns");
            JSONArray jSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
            if (jSONArray == null) return;
            int n = 0;
            while (n < jSONArray.length()) {
                object = jSONArray.optJSONObject(n);
                if (object != null) {
                    String string = object.optString("ad_unit_id");
                    String string2 = object.optString("format");
                    JSONObject jSONObject2 = object.optJSONObject("request_signals");
                    if (string != null && jSONObject2 != null && string2 != null) {
                        if (this.zza.containsKey(string2)) {
                            object = this.zza.get(string2);
                        } else {
                            object = new ConcurrentHashMap();
                            this.zza.put(string2, (Map<String, JSONObject>)object);
                        }
                        object.put(string, jSONObject2);
                    }
                }
                ++n;
            }
            return;
        }
    }

    public final void zza() {
        zzt.zzg().zzp().zzp((Runnable)new zzdth(this));
        this.zzc.execute((Runnable)new zzdti(this));
    }

    @CheckForNull
    public final JSONObject zzb(String string, String string2) {
        Object object = zzbjl.zzcu;
        if (!((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
            return null;
        }
        if (string == null) return null;
        if (string2 == null) {
            return null;
        }
        if (!this.zzd) {
            this.zzg();
        }
        if ((object = this.zza.get(string2)) == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject)object.get(string);
        if (jSONObject != null) {
            return jSONObject;
        }
        if ((string = zzdtm.zza((JSONObject)this.zze, (String)string, (String)string2)) != null) return (JSONObject)object.get(string);
        return null;
    }

    @CheckForNull
    public final JSONObject zzc() {
        zzbjd zzbjd2 = zzbjl.zzcv;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) != false) return this.zzb;
        return null;
    }

    final /* synthetic */ void zzd() {
        this.zzg();
    }

    final /* synthetic */ void zze() {
        this.zzc.execute((Runnable)new zzdtj(this));
    }

    final /* synthetic */ void zzf() {
        this.zzg();
    }
}
