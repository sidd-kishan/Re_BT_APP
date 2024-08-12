/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbcx
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbtw
 *  com.google.android.gms.internal.ads.zzbty
 *  com.google.android.gms.internal.ads.zzbtz
 *  com.google.android.gms.internal.ads.zzbud
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzddv
 *  com.google.android.gms.internal.ads.zzddz
 *  com.google.android.gms.internal.ads.zzdzr
 *  com.google.android.gms.internal.ads.zzdzs
 *  com.google.android.gms.internal.ads.zzdzt
 *  com.google.android.gms.internal.ads.zzdzu
 *  com.google.android.gms.internal.ads.zzehs
 *  com.google.android.gms.internal.ads.zzfai
 *  com.google.android.gms.internal.ads.zzfak
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbcx;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbtw;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbud;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzddv;
import com.google.android.gms.internal.ads.zzddz;
import com.google.android.gms.internal.ads.zzdzr;
import com.google.android.gms.internal.ads.zzdzs;
import com.google.android.gms.internal.ads.zzdzt;
import com.google.android.gms.internal.ads.zzdzu;
import com.google.android.gms.internal.ads.zzehs;
import com.google.android.gms.internal.ads.zzfai;
import com.google.android.gms.internal.ads.zzfak;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.io.Reader;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdzv {
    private final zzcoj zza;
    private final Context zzb;
    private final zzcgz zzc;
    private final zzfar zzd;
    private final Executor zze;
    private final String zzf;
    private final zzddv zzg;
    private final zzddz zzh;

    public zzdzv(zzcoj zzcoj2, Context context, zzcgz zzcgz2, zzfar zzfar2, Executor executor, String string, zzddv zzddv2, zzddz zzddz2) {
        this.zza = zzcoj2;
        this.zzb = context;
        this.zzc = zzcgz2;
        this.zzd = zzfar2;
        this.zze = executor;
        this.zzf = string;
        this.zzg = zzddv2;
        this.zzh = zzddz2;
    }

    static /* synthetic */ zzddv zza(zzdzv zzdzv2) {
        return zzdzv2.zzg;
    }

    static /* synthetic */ zzddz zzb(zzdzv zzdzv2) {
        return zzdzv2.zzh;
    }

    private final zzfsm<zzfal> zze(String string, String string2) {
        zzbtw zzbtw2 = zzt.zzp().zzb(this.zzb, this.zzc).zza("google.afma.response.normalize", (zzbtz)zzbud.zza, (zzbty)zzbud.zza);
        string = zzfsd.zzi((zzfsm)zzfsd.zzi((zzfsm)zzfsd.zzi((zzfsm)zzfsd.zza((Object)""), (zzfrk)new zzdzr(this, string, string2), (Executor)this.zze), (zzfrk)new zzdzs(zzbtw2), (Executor)this.zze), (zzfrk)new zzdzt(this), (Executor)this.zze);
        string2 = zzbjl.zzfl;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)string2) == false) return string;
        zzfsd.zzp((zzfsm)string, (zzfrz)new zzdzu(this), (Executor)zzchg.zzf);
        return string;
    }

    private final String zzf(String string) {
        try {
            Object object = new JSONObject(string);
            JSONArray jSONArray = object.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONArray = new JSONArray();
                object.put("ad_types", (Object)jSONArray.put((Object)this.zzf));
            }
            object = object.toString();
            return object;
        }
        catch (JSONException jSONException) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Failed to update the ad types for rendering. ".concat(((Object)((Object)jSONException)).toString()));
            return string;
        }
    }

    private static final String zzg(String string) {
        try {
            string = new JSONObject(string);
        }
        catch (JSONException jSONException) {
            return "";
        }
        return string.optString("request_id", "");
    }

    public final zzfsm<zzfal> zzc() {
        Object object;
        String string = this.zzd.zzd.zzx;
        if (!TextUtils.isEmpty((CharSequence)string)) {
            object = zzbjl.zzfi;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
                object = zzdzv.zzg(string);
                if (TextUtils.isEmpty((CharSequence)object)) {
                    string = zzbjl.zzfl;
                    if ((Boolean)zzbet.zzc().zzc((zzbjd)string) == false) return zzfsd.zzc((Throwable)new zzehs(15, "Invalid ad string."));
                    this.zzh.zzbB(true);
                    return zzfsd.zzc((Throwable)new zzehs(15, "Invalid ad string."));
                }
                object = this.zza.zzw().zzc((String)object);
                if (!TextUtils.isEmpty((CharSequence)object)) return this.zze(string, this.zzf((String)object));
            }
        }
        if ((string = this.zzd.zzd.zzs) != null) {
            object = zzbjl.zzfg;
            if (!((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) return this.zze(((zzbcx)string).zza, this.zzf(((zzbcx)string).zzb));
            object = zzdzv.zzg(((zzbcx)string).zza);
            String string2 = zzdzv.zzg(((zzbcx)string).zzb);
            if (!TextUtils.isEmpty((CharSequence)string2) && ((String)object).equals(string2)) {
                this.zza.zzw().zzd((String)object);
                return this.zze(((zzbcx)string).zza, this.zzf(((zzbcx)string).zzb));
            }
        }
        string = zzbjl.zzfl;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)string) == false) return zzfsd.zzc((Throwable)new zzehs(14, "Mismatch request IDs."));
        this.zzh.zzbB(true);
        return zzfsd.zzc((Throwable)new zzehs(14, "Mismatch request IDs."));
    }

    final /* synthetic */ zzfsm zzd(JSONObject jSONObject) throws Exception {
        return zzfsd.zza((Object)new zzfal(new zzfai(this.zzd), zzfak.zza((Reader)new StringReader(jSONObject.toString()))));
    }
}
