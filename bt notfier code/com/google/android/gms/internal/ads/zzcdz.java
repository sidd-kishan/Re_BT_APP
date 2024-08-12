/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  android.preference.PreferenceManager
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcfa
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcfa;

public final class zzcdz
implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final zzg zzc;
    private final zzcfa zzd;
    private String zze = "";

    zzcdz(Context context, zzg zzg2, zzcfa zzcfa2) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences((Context)context);
        this.zzc = zzg2;
        this.zza = context;
        this.zzd = zzcfa2;
    }

    public final void onSharedPreferenceChanged(SharedPreferences object, String string) {
        if (!"IABTCF_PurposeConsents".equals(string)) {
            return;
        }
        if (((String)(object = object.getString("IABTCF_PurposeConsents", ""))).isEmpty()) {
            return;
        }
        if (this.zze.equals(object)) return;
        this.zze = object;
        boolean bl = false;
        if (((String)object).charAt(0) != '1') {
            bl = true;
        }
        object = zzbjl.zzao;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
            this.zzc.zzB(bl);
            object = zzbjl.zzex;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue() && bl && (object = this.zza) != null) {
                object.deleteDatabase("OfflineUpload.db");
            }
        }
        object = zzbjl.zzaj;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
        this.zzd.zza();
    }

    final void zza() {
        this.zzb.registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener)this);
        this.onSharedPreferenceChanged(this.zzb, "IABTCF_PurposeConsents");
    }
}
