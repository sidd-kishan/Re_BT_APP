/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbdp
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbgy
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzeeh
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  org.json.JSONException
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbdp;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbgy;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzeeh;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import java.util.List;
import org.json.JSONException;

public final class zzdav
extends zzbgy {
    private final String zza;
    private final String zzb;
    private final List<zzbdp> zzc;
    private final long zzd;
    private final String zze;

    public zzdav(zzezz object, String string, zzeeh zzeeh2, zzfac zzfac2) {
        String string2;
        block7: {
            Object var6_6;
            block6: {
                var6_6 = null;
                string2 = object == null ? null : object.zzX;
                this.zzb = string2;
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(string)) break block6;
                string2 = var6_6;
                if (!"com.google.ads.mediation.customevent.CustomEventAdapter".equals(string)) break block7;
            }
            try {
                string2 = object.zzv.getString("class_name");
            }
            catch (JSONException jSONException) {
                string2 = var6_6;
            }
        }
        if (string2 != null) {
            string = string2;
        }
        this.zza = string;
        this.zzc = zzeeh2.zze();
        this.zzd = zzt.zzj().currentTimeMillis() / 1000L;
        object = zzbjl.zzgG;
        object = ((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue() && zzfac2 != null && !TextUtils.isEmpty((CharSequence)zzfac2.zzh) ? zzfac2.zzh : "";
        this.zze = object;
    }

    public final long zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zze;
    }

    public final String zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzb;
    }

    public final List<zzbdp> zzg() {
        zzbjd zzbjd2 = zzbjl.zzfX;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) != false) return this.zzc;
        return null;
    }
}
