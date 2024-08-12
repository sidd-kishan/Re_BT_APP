/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Looper
 *  android.security.NetworkSecurityPolicy
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.ads.internal.util.zzh
 *  com.google.android.gms.ads.internal.util.zzi
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.internal.ads.zzaxc
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbks
 *  com.google.android.gms.internal.ads.zzcfz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzh;
import com.google.android.gms.ads.internal.util.zzi;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzaxc;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbks;
import com.google.android.gms.internal.ads.zzcfz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzj
implements zzg {
    private long zzA = 0L;
    private final Object zza = new Object();
    private boolean zzb;
    private final List<Runnable> zzc = new ArrayList<Runnable>();
    private zzfsm<?> zzd;
    private zzaxc zze = null;
    private SharedPreferences zzf;
    private SharedPreferences.Editor zzg;
    private boolean zzh = true;
    private String zzi;
    private String zzj;
    private boolean zzk = true;
    private zzcfz zzl = new zzcfz("", 0L);
    private long zzm = 0L;
    private long zzn = 0L;
    private int zzo = -1;
    private int zzp = 0;
    private Set<String> zzq = Collections.emptySet();
    private JSONObject zzr = new JSONObject();
    private boolean zzs = true;
    private boolean zzt = true;
    private String zzu = null;
    private String zzv = "";
    private boolean zzw = false;
    private String zzx = "";
    private int zzy = -1;
    private int zzz = -1;

    /*
     * WARNING - void declaration
     */
    private final void zzN() {
        void var1_5;
        zzfsm<?> zzfsm2 = this.zzd;
        if (zzfsm2 == null) {
            return;
        }
        if (zzfsm2.isDone()) {
            return;
        }
        try {
            this.zzd.get(1L, TimeUnit.SECONDS);
            return;
        }
        catch (TimeoutException timeoutException) {
        }
        catch (ExecutionException executionException) {
        }
        catch (CancellationException cancellationException) {
            // empty catch block
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Interrupted while waiting for preferences loaded.", (Throwable)interruptedException);
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zzg((String)"Fail to initialize AdSharedPreferenceManager.", (Throwable)var1_5);
    }

    private final void zzO() {
        zzchg.zza.execute((Runnable)new zzi(this));
    }

    public final void zzA(String string) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            if (TextUtils.equals((CharSequence)this.zzu, (CharSequence)string)) {
                return;
            }
            this.zzu = string;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("display_cutout", string);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final void zzB(boolean bl) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            if (bl == this.zzk) {
                return;
            }
            this.zzk = bl;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putBoolean("gad_idless", bl);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final boolean zzC() {
        Object object = zzbjl.zzao;
        if (!((Boolean)zzbet.zzc().zzc(object)).booleanValue()) {
            return false;
        }
        this.zzN();
        object = this.zza;
        synchronized (object) {
            boolean bl = this.zzk;
            return bl;
        }
    }

    public final void zzD(int n) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            if (this.zzz == n) {
                return;
            }
            this.zzz = n;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putInt("sd_app_measure_npa", n);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final long zzE() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            long l = this.zzA;
            return l;
        }
    }

    public final void zzF(long l) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            if (this.zzA == l) {
                return;
            }
            this.zzA = l;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putLong("sd_app_measure_npa_ts", l);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final String zzG() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            String string = this.zzv;
            return string;
        }
    }

    public final void zzH(String string) {
        Object object = zzbjl.zzgp;
        if (!((Boolean)zzbet.zzc().zzc(object)).booleanValue()) {
            return;
        }
        this.zzN();
        object = this.zza;
        synchronized (object) {
            if (this.zzv.equals(string)) {
                return;
            }
            this.zzv = string;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("inspector_info", string);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final boolean zzI() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            boolean bl = this.zzw;
            return bl;
        }
    }

    public final void zzJ(boolean bl) {
        Object object = zzbjl.zzgE;
        if (!((Boolean)zzbet.zzc().zzc(object)).booleanValue()) {
            return;
        }
        this.zzN();
        object = this.zza;
        synchronized (object) {
            if (this.zzw == bl) {
                return;
            }
            this.zzw = bl;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putBoolean("linked_device", bl);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final String zzK() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            String string = this.zzx;
            return string;
        }
    }

    public final void zzL(String string) {
        Object object = zzbjl.zzgE;
        if (!((Boolean)zzbet.zzc().zzc(object)).booleanValue()) {
            return;
        }
        this.zzN();
        object = this.zza;
        synchronized (object) {
            if (this.zzx.equals(string)) {
                return;
            }
            this.zzx = string;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("linked_ad_unit", string);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    final /* synthetic */ void zzM(Context object, String string) {
        string = object.getSharedPreferences("admob", 0);
        SharedPreferences.Editor editor = string.edit();
        object = this.zza;
        synchronized (object) {
            this.zzf = string;
            this.zzg = editor;
            if (PlatformVersion.isAtLeastM()) {
                NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            }
            this.zzh = this.zzf.getBoolean("use_https", this.zzh);
            this.zzs = this.zzf.getBoolean("content_url_opted_out", this.zzs);
            this.zzi = this.zzf.getString("content_url_hashes", this.zzi);
            this.zzk = this.zzf.getBoolean("gad_idless", this.zzk);
            this.zzt = this.zzf.getBoolean("content_vertical_opted_out", this.zzt);
            this.zzj = this.zzf.getString("content_vertical_hashes", this.zzj);
            this.zzp = this.zzf.getInt("version_code", this.zzp);
            string = this.zzf.getString("app_settings_json", this.zzl.zzd());
            long l = this.zzf.getLong("app_settings_last_update_ms", this.zzl.zzb());
            editor = new zzcfz(string, l);
            this.zzl = editor;
            this.zzm = this.zzf.getLong("app_last_background_time_ms", this.zzm);
            this.zzo = this.zzf.getInt("request_in_session_count", this.zzo);
            this.zzn = this.zzf.getLong("first_ad_req_time_ms", this.zzn);
            this.zzq = this.zzf.getStringSet("never_pool_slots", this.zzq);
            this.zzu = this.zzf.getString("display_cutout", this.zzu);
            this.zzy = this.zzf.getInt("app_measurement_npa", this.zzy);
            this.zzz = this.zzf.getInt("sd_app_measure_npa", this.zzz);
            this.zzA = this.zzf.getLong("sd_app_measure_npa_ts", this.zzA);
            this.zzv = this.zzf.getString("inspector_info", this.zzv);
            this.zzw = this.zzf.getBoolean("linked_device", this.zzw);
            this.zzx = this.zzf.getString("linked_ad_unit", this.zzx);
            try {
                string = new JSONObject(this.zzf.getString("native_advanced_settings", "{}"));
                this.zzr = string;
            }
            catch (JSONException jSONException) {
                com.google.android.gms.ads.internal.util.zze.zzj((String)"Could not convert native advanced settings to json object", (Throwable)jSONException);
            }
            this.zzO();
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(Context context) {
        Object object = this.zza;
        synchronized (object) {
            if (this.zzf != null) {
                return;
            }
        }
        this.zzd = zzchg.zza.zza((Runnable)new zzh(this, context, "admob"));
        this.zzb = true;
    }

    public final zzaxc zzb() {
        if (!this.zzb) {
            return null;
        }
        if (this.zzd()) {
            if (this.zzh()) return null;
        }
        if (!((Boolean)zzbks.zzb.zze()).booleanValue()) {
            return null;
        }
        Object object = this.zza;
        synchronized (object) {
            zzaxc zzaxc2;
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zze == null) {
                this.zze = zzaxc2 = new zzaxc();
            }
            this.zze.zza();
            com.google.android.gms.ads.internal.util.zze.zzh((String)"start fetching content...");
            zzaxc2 = this.zze;
            return zzaxc2;
        }
    }

    public final void zzc(boolean bl) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            if (this.zzs == bl) {
                return;
            }
            this.zzs = bl;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putBoolean("content_url_opted_out", bl);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final boolean zzd() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            boolean bl = this.zzs;
            return bl;
        }
    }

    public final void zze(String string) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            if (string.equals(this.zzi)) {
                return;
            }
            this.zzi = string;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("content_url_hashes", string);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final String zzf() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            String string = this.zzi;
            return string;
        }
    }

    public final void zzg(boolean bl) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            if (this.zzt == bl) {
                return;
            }
            this.zzt = bl;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putBoolean("content_vertical_opted_out", bl);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final boolean zzh() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            boolean bl = this.zzt;
            return bl;
        }
    }

    public final void zzi(String string) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            if (string.equals(this.zzj)) {
                return;
            }
            this.zzj = string;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("content_vertical_hashes", string);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final String zzj() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            String string = this.zzj;
            return string;
        }
    }

    public final void zzk(int n) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            if (this.zzp == n) {
                return;
            }
            this.zzp = n;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putInt("version_code", n);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final int zzl() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            int n = this.zzp;
            return n;
        }
    }

    public final void zzm(String object) {
        this.zzN();
        Object object2 = this.zza;
        synchronized (object2) {
            try {
                long l = com.google.android.gms.ads.internal.zzt.zzj().currentTimeMillis();
                if (object != null && !((String)object).equals(this.zzl.zzd())) {
                    zzcfz zzcfz2;
                    this.zzl = zzcfz2 = new zzcfz((String)object, l);
                    zzcfz2 = this.zzg;
                    if (zzcfz2 != null) {
                        zzcfz2.putString("app_settings_json", (String)object);
                        this.zzg.putLong("app_settings_last_update_ms", l);
                        this.zzg.apply();
                    }
                    this.zzO();
                    object = this.zzc.iterator();
                    while (object.hasNext()) {
                        ((Runnable)object.next()).run();
                    }
                    return;
                }
                this.zzl.zza(l);
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final zzcfz zzn() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            zzcfz zzcfz2 = this.zzl;
            return zzcfz2;
        }
    }

    public final zzcfz zzo() {
        Object object = this.zza;
        synchronized (object) {
            zzcfz zzcfz2 = this.zzl;
            return zzcfz2;
        }
    }

    public final void zzp(Runnable runnable) {
        this.zzc.add(runnable);
    }

    public final void zzq(long l) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            if (this.zzm == l) {
                return;
            }
            this.zzm = l;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putLong("app_last_background_time_ms", l);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final long zzr() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            long l = this.zzm;
            return l;
        }
    }

    public final void zzs(int n) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            if (this.zzo == n) {
                return;
            }
            this.zzo = n;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putInt("request_in_session_count", n);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final int zzt() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            int n = this.zzo;
            return n;
        }
    }

    public final void zzu(long l) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            if (this.zzn == l) {
                return;
            }
            this.zzn = l;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putLong("first_ad_req_time_ms", l);
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final long zzv() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            long l = this.zzn;
            return l;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void zzw(String string, String string2, boolean bl) {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            int n;
            JSONArray jSONArray;
            JSONArray jSONArray2 = jSONArray = this.zzr.optJSONArray(string);
            if (jSONArray == null) {
                jSONArray2 = new JSONArray();
            }
            int n2 = jSONArray2.length();
            int n3 = 0;
            while (true) {
                n = n2;
                if (n3 >= jSONArray2.length()) break;
                jSONArray = jSONArray2.optJSONObject(n3);
                if (jSONArray == null) {
                    return;
                }
                if (string2.equals(jSONArray.optString("template_id"))) {
                    if (bl) {
                        if (jSONArray.optBoolean("uses_media_view", false)) return;
                    }
                    n = n3;
                    break;
                }
                ++n3;
            }
            try {
                jSONArray = new JSONObject();
                jSONArray.put("template_id", (Object)string2);
                jSONArray.put("uses_media_view", bl);
                jSONArray.put("timestamp_ms", com.google.android.gms.ads.internal.zzt.zzj().currentTimeMillis());
                jSONArray2.put(n, (Object)jSONArray);
                this.zzr.put(string, (Object)jSONArray2);
            }
            catch (JSONException jSONException) {
                com.google.android.gms.ads.internal.util.zze.zzj((String)"Could not update native advanced settings", (Throwable)jSONException);
            }
            string = this.zzg;
            if (string != null) {
                string.putString("native_advanced_settings", this.zzr.toString());
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final JSONObject zzx() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            JSONObject jSONObject = this.zzr;
            return jSONObject;
        }
    }

    public final void zzy() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            JSONObject jSONObject;
            this.zzr = jSONObject = new JSONObject();
            jSONObject = this.zzg;
            if (jSONObject != null) {
                jSONObject.remove("native_advanced_settings");
                this.zzg.apply();
            }
            this.zzO();
            return;
        }
    }

    public final String zzz() {
        this.zzN();
        Object object = this.zza;
        synchronized (object) {
            String string = this.zzu;
            return string;
        }
    }
}
