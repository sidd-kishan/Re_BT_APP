/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzd
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbty
 *  com.google.android.gms.internal.ads.zzbtz
 *  com.google.android.gms.internal.ads.zzbud
 *  com.google.android.gms.internal.ads.zzcfz
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchj
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbud;
import com.google.android.gms.internal.ads.zzcfz;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchj;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zze {
    private Context zza;
    private long zzb = 0L;

    public final void zza(Context context, zzcgz zzcgz2, String string, Runnable runnable) {
        this.zzc(context, zzcgz2, true, null, string, null, runnable);
    }

    public final void zzb(Context context, zzcgz zzcgz2, String string, zzcfz zzcfz2) {
        String string2 = zzcfz2 != null ? zzcfz2.zze() : null;
        this.zzc(context, zzcgz2, false, zzcfz2, string2, string, null);
    }

    final void zzc(Context context, zzcgz zzcgz2, boolean bl, zzcfz zzcfz2, String string, String string2, Runnable runnable) {
        zzbjd zzbjd2;
        if (zzt.zzj().elapsedRealtime() - this.zzb < 5000L) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzt.zzj().elapsedRealtime();
        if (zzcfz2 != null) {
            long l = zzcfz2.zzb();
            long l2 = zzt.zzj().currentTimeMillis();
            zzbjd2 = zzbjl.zzcx;
            if (l2 - l <= (Long)zzbet.zzc().zzc(zzbjd2) && zzcfz2.zzc()) {
                return;
            }
        }
        if (context == null) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty((CharSequence)string) && TextUtils.isEmpty((CharSequence)string2)) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"App settings could not be fetched. Required parameters missing");
            return;
        }
        zzbjd2 = context.getApplicationContext();
        zzcfz2 = zzbjd2;
        if (zzbjd2 == null) {
            zzcfz2 = context;
        }
        this.zza = zzcfz2;
        zzcgz2 = zzt.zzp().zzb(this.zza, zzcgz2).zza("google.afma.config.fetchAppSettings", (zzbtz)zzbud.zza, (zzbty)zzbud.zza);
        try {
            zzcfz2 = new JSONObject();
            if (!TextUtils.isEmpty((CharSequence)string)) {
                zzcfz2.put("app_id", (Object)string);
            } else if (!TextUtils.isEmpty((CharSequence)string2)) {
                zzcfz2.put("ad_unit_id", (Object)string2);
            }
            zzcfz2.put("is_init", bl);
            zzcfz2.put("pn", (Object)context.getPackageName());
            zzcfz2.put("experiment_ids", (Object)TextUtils.join((CharSequence)",", (Iterable)zzbjl.zzc()));
            try {
                string = this.zza.getApplicationInfo();
                if (string != null && (context = Wrappers.packageManager((Context)context).getPackageInfo(((ApplicationInfo)string).packageName, 0)) != null) {
                    zzcfz2.put("version", context.versionCode);
                }
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                com.google.android.gms.ads.internal.util.zze.zza((String)"Error fetching PackageInfo.");
            }
            context = zzcgz2.zzb((Object)zzcfz2);
            zzcgz2 = zzfsd.zzi((zzfsm)context, (zzfrk)zzd.zza, (Executor)zzchg.zzf);
            if (runnable != null) {
                context.zze(runnable, (Executor)zzchg.zzf);
            }
            zzchj.zza((zzfsm)zzcgz2, (String)"ConfigLoader.maybeFetchNewAppSettings");
            return;
        }
        catch (Exception exception) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Error requesting application settings", (Throwable)exception);
            return;
        }
    }
}
