/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcja {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final int zzk;
    public final boolean zzl;
    public final boolean zzm;
    public final boolean zzn;

    public zzcja(String string) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = jSONObject = null;
        if (string != null) {
            try {
                jSONObject2 = new JSONObject(string);
            }
            catch (JSONException jSONException) {
                jSONObject2 = jSONObject;
            }
        }
        this.zza = zzcja.zza(jSONObject2, "aggressive_media_codec_release", (zzbjd<Boolean>)zzbjl.zzD);
        this.zzb = zzcja.zzb(jSONObject2, "byte_buffer_precache_limit", (zzbjd<Integer>)zzbjl.zzj);
        this.zzc = zzcja.zzb(jSONObject2, "exo_cache_buffer_size", (zzbjd<Integer>)zzbjl.zzr);
        this.zzd = zzcja.zzb(jSONObject2, "exo_connect_timeout_millis", (zzbjd<Integer>)zzbjl.zzf);
        jSONObject = zzbjl.zze;
        if (jSONObject2 != null) {
            try {
                string = jSONObject2.getString("exo_player_version");
            }
            catch (JSONException jSONException) {}
        }
        string = (String)zzbet.zzc().zzc((zzbjd)jSONObject);
        this.zze = string;
        this.zzf = zzcja.zzb(jSONObject2, "exo_read_timeout_millis", (zzbjd<Integer>)zzbjl.zzg);
        this.zzg = zzcja.zzb(jSONObject2, "load_check_interval_bytes", (zzbjd<Integer>)zzbjl.zzh);
        this.zzh = zzcja.zzb(jSONObject2, "player_precache_limit", (zzbjd<Integer>)zzbjl.zzi);
        this.zzi = zzcja.zzb(jSONObject2, "socket_receive_buffer_size", (zzbjd<Integer>)zzbjl.zzk);
        this.zzj = zzcja.zza(jSONObject2, "use_cache_data_source", (zzbjd<Boolean>)zzbjl.zzcH);
        this.zzk = zzcja.zzb(jSONObject2, "min_retry_count", (zzbjd<Integer>)zzbjl.zzl);
        this.zzl = zzcja.zza(jSONObject2, "treat_load_exception_as_non_fatal", (zzbjd<Boolean>)zzbjl.zzo);
        this.zzm = zzcja.zza(jSONObject2, "using_official_simple_exo_player", (zzbjd<Boolean>)zzbjl.zzbm);
        this.zzn = zzcja.zza(jSONObject2, "enable_multiple_video_playback", (zzbjd<Boolean>)zzbjl.zzbn);
    }

    private static final boolean zza(JSONObject jSONObject, String string, zzbjd<Boolean> zzbjd2) {
        boolean bl;
        boolean bl2 = bl = ((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue();
        if (jSONObject == null) return bl2;
        try {
            bl2 = jSONObject.getBoolean(string);
        }
        catch (JSONException jSONException) {
            bl2 = bl;
        }
        return bl2;
    }

    private static final int zzb(JSONObject jSONObject, String string, zzbjd<Integer> zzbjd2) {
        if (jSONObject == null) return (Integer)zzbet.zzc().zzc(zzbjd2);
        try {
            int n = jSONObject.getInt(string);
            return n;
        }
        catch (JSONException jSONException) {
        }
        return (Integer)zzbet.zzc().zzc(zzbjd2);
    }
}
