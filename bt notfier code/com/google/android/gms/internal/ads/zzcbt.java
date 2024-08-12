/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbky
 *  com.google.android.gms.internal.ads.zzbtw
 *  com.google.android.gms.internal.ads.zzcbs
 *  com.google.android.gms.internal.ads.zzcbu
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbky;
import com.google.android.gms.internal.ads.zzbtw;
import com.google.android.gms.internal.ads.zzcbs;
import com.google.android.gms.internal.ads.zzcbu;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcbt
extends zzcbu {
    private final Object zza = new Object();
    private final Context zzb;
    private SharedPreferences zzc;
    private final zzbtw<JSONObject, JSONObject> zzd;

    public zzcbt(Context context, zzbtw<JSONObject, JSONObject> zzbtw2) {
        this.zzb = context.getApplicationContext();
        this.zzd = zzbtw2;
    }

    /*
     * Enabled force condition propagation
     */
    public static JSONObject zzb(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", (Object)zzcgz.zza().zza);
            jSONObject.put("mf", zzbky.zza.zze());
            jSONObject.put("cl", (Object)"407425155");
            jSONObject.put("rapid_rc", (Object)"dev");
            jSONObject.put("rapid_rollup", (Object)"HEAD");
            jSONObject.put("admob_module_version", 12451000);
            jSONObject.put("dynamite_local_version", 213806100);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion((Context)context, (String)"com.google.android.gms.ads.dynamite"));
            jSONObject.put("container_version", 12451000);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            return jSONObject;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final zzfsm<Void> zza() {
        Object object = this.zza;
        synchronized (object) {
            if (this.zzc != null) {
            } else {
                this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        long l = this.zzc.getLong("js_last_update", 0L);
        if (zzt.zzj().currentTimeMillis() - l < (Long)zzbky.zzb.zze()) {
            return zzfsd.zza(null);
        }
        JSONObject jSONObject = zzcbt.zzb(this.zzb);
        return zzfsd.zzj((zzfsm)this.zzd.zzb((Object)jSONObject), (zzfln)new zzcbs(this), (Executor)zzchg.zzf);
    }

    final /* synthetic */ Void zzc(JSONObject jSONObject) {
        zzbjl.zzb((Context)this.zzb, (int)1, (JSONObject)jSONObject);
        this.zzc.edit().putLong("js_last_update", zzt.zzj().currentTimeMillis()).apply();
        return null;
    }
}
