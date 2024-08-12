/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbkp
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzerv
 *  org.json.JSONArray
 *  org.json.JSONException
 */
package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbkp;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzerv;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;

final class zzr {
    private final Context zza;
    private final String zzb;
    private final Map<String, String> zzc;
    private String zzd;
    private String zze;
    private final String zzf;

    public zzr(Context object, String string) {
        this.zza = object.getApplicationContext();
        this.zzb = string;
        this.zzc = new TreeMap<String, String>();
        string = object.getPackageName();
        try {
            String string2 = Wrappers.packageManager((Context)object).getPackageInfo((String)object.getPackageName(), (int)0).versionName;
            int n = String.valueOf(string).length();
            int n2 = String.valueOf(string2).length();
            super(n + 1 + n2);
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append("-");
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Unable to get package version name for reporting", (Throwable)nameNotFoundException);
            object = String.valueOf(string).concat("-missing");
        }
        this.zzf = object;
    }

    public final String zza() {
        return this.zze;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final Map<String, String> zze() {
        return this.zzc;
    }

    public final void zzf(zzbdg object, zzcgz zzcgz2) {
        this.zzd = object.zzj.zza;
        object = object.zzm;
        object = object != null ? object.getBundle(AdMobAdapter.class.getName()) : null;
        if (object == null) {
            return;
        }
        Object object2 = (String)zzbkp.zzc.zze();
        for (String string : object.keySet()) {
            if (((String)object2).equals(string)) {
                this.zze = object.getString(string);
                continue;
            }
            if (!string.startsWith("csa_")) continue;
            this.zzc.put(string.substring(4), object.getString(string));
        }
        this.zzc.put("SDKVersion", zzcgz2.zza);
        if ((Boolean)zzbkp.zza.zze() == false) return;
        try {
            object = new JSONArray((String)zzbkp.zzb.zze());
            zzcgz2 = zzerv.zzb((Context)this.zza, (JSONArray)object);
            object2 = zzcgz2.keySet().iterator();
            while (object2.hasNext()) {
                object = (String)object2.next();
                this.zzc.put((String)object, zzcgz2.get((String)object).toString());
            }
            return;
        }
        catch (JSONException jSONException) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", (Throwable)jSONException);
        }
    }
}
