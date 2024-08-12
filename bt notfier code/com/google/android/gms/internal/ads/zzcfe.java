/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  com.google.android.gms.internal.ads.zzcff
 *  com.google.android.gms.internal.ads.zzcfg
 */
package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import com.google.android.gms.internal.ads.zzcff;
import com.google.android.gms.internal.ads.zzcfg;
import java.util.Iterator;

final class zzcfe
implements SharedPreferences.OnSharedPreferenceChangeListener {
    final zzcfg zza;
    private final String zzb;

    public zzcfe(zzcfg zzcfg2, String string) {
        this.zza = zzcfg2;
        this.zzb = string;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String string) {
        zzcfg zzcfg2 = this.zza;
        synchronized (zzcfg2) {
            try {
                Iterator iterator = zzcfg.zza((zzcfg)this.zza).iterator();
                while (iterator.hasNext()) {
                    ((zzcff)iterator.next()).zza(sharedPreferences, this.zzb, string);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
