/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  android.preference.PreferenceManager
 *  com.google.android.gms.internal.ads.zzced
 *  com.google.android.gms.internal.ads.zzcfe
 *  com.google.android.gms.internal.ads.zzcff
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.internal.ads.zzced;
import com.google.android.gms.internal.ads.zzcfe;
import com.google.android.gms.internal.ads.zzcff;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzcfg {
    private final Map<String, zzcfe> zza = new HashMap<String, zzcfe>();
    private final List<zzcff> zzb = new ArrayList<zzcff>();
    private final Context zzc;
    private final zzced zzd;

    zzcfg(Context context, zzced zzced2) {
        this.zzc = context;
        this.zzd = zzced2;
    }

    static /* synthetic */ List zza(zzcfg zzcfg2) {
        return zzcfg2.zzb;
    }

    final void zzb(zzcff zzcff2) {
        synchronized (this) {
            this.zzb.add(zzcff2);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    final void zzc(String string) {
        synchronized (this) {
            boolean bl = this.zza.containsKey(string);
            if (bl) {
                return;
            }
            SharedPreferences sharedPreferences = "__default__".equals(string) ? PreferenceManager.getDefaultSharedPreferences((Context)this.zzc) : this.zzc.getSharedPreferences(string, 0);
            zzcfe zzcfe2 = new zzcfe(this, string);
            this.zza.put(string, zzcfe2);
            sharedPreferences.registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener)zzcfe2);
            return;
        }
    }

    final /* synthetic */ void zzd(Map map, SharedPreferences sharedPreferences, String string, String string2) {
        if (!map.containsKey(string)) {
            return;
        }
        if (!((Set)map.get(string)).contains(string2)) {
            return;
        }
        this.zzd.zzb();
    }
}
