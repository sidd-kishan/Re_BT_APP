/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.overlay.zzc
 *  com.google.android.gms.ads.internal.overlay.zzt
 *  com.google.android.gms.ads.internal.overlay.zzv
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;

public final class zza {
    public static final boolean zza(Context context, Intent intent, zzv zzv2, com.google.android.gms.ads.internal.overlay.zzt zzt2, boolean bl) {
        if (bl) {
            return zza.zzc(context, intent.getData(), zzv2, zzt2);
        }
        try {
            String string = String.valueOf(intent.toURI());
            string = string.length() != 0 ? "Launching an intent: ".concat(string) : new String("Launching an intent: ");
            zze.zza((String)string);
            zzt.zzc();
            zzs.zzP((Context)context, (Intent)intent);
            if (zzv2 != null) {
                zzv2.zzg();
            }
            if (zzt2 == null) return true;
            zzt2.zza(true);
            return true;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            zze.zzi((String)activityNotFoundException.getMessage());
            if (zzt2 == null) return false;
            zzt2.zza(false);
            return false;
        }
    }

    public static final boolean zzb(Context object, zzc zzc2, zzv zzv2, com.google.android.gms.ads.internal.overlay.zzt zzt2) {
        zzbjd zzbjd2;
        int n = 0;
        if (zzc2 == null) {
            zze.zzi((String)"No intent data for launcher overlay.");
            return false;
        }
        zzbjl.zza((Context)object);
        Intent intent = zzc2.zzh;
        if (intent != null) {
            return zza.zza((Context)object, intent, zzv2, zzt2, zzc2.zzj);
        }
        intent = new Intent();
        if (TextUtils.isEmpty((CharSequence)zzc2.zzb)) {
            zze.zzi((String)"Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty((CharSequence)zzc2.zzc)) {
            intent.setDataAndType(Uri.parse((String)zzc2.zzb), zzc2.zzc);
        } else {
            intent.setData(Uri.parse((String)zzc2.zzb));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty((CharSequence)zzc2.zzd)) {
            intent.setPackage(zzc2.zzd);
        }
        if (!TextUtils.isEmpty((CharSequence)zzc2.zze)) {
            zzbjd2 = zzc2.zze.split("/", 2);
            if (((String[])zzbjd2).length < 2) {
                object = String.valueOf(zzc2.zze);
                object = ((String)object).length() != 0 ? "Could not parse component name from open GMSG: ".concat((String)object) : new String("Could not parse component name from open GMSG: ");
                zze.zzi((String)object);
                return false;
            }
            intent.setClassName((String)zzbjd2[0], (String)zzbjd2[1]);
        }
        if (!TextUtils.isEmpty((CharSequence)(zzbjd2 = zzc2.zzf))) {
            int n2;
            try {
                n2 = Integer.parseInt((String)zzbjd2);
            }
            catch (NumberFormatException numberFormatException) {
                zze.zzi((String)"Could not parse intent flags.");
                n2 = n;
            }
            intent.addFlags(n2);
        }
        zzbjd2 = zzbjl.zzcU;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            intent.addFlags(0x10000000);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            zzbjd2 = zzbjl.zzcT;
            if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return zza.zza((Context)object, intent, zzv2, zzt2, zzc2.zzj);
            zzt.zzc();
            zzs.zzu((Context)object, (Intent)intent);
        }
        return zza.zza((Context)object, intent, zzv2, zzt2, zzc2.zzj);
    }

    private static final boolean zzc(Context context, Uri uri, zzv zzv2, com.google.android.gms.ads.internal.overlay.zzt zzt2) {
        int n;
        try {
            int n2;
            n = n2 = zzt.zzc().zzs(context, uri);
            if (zzv2 != null) {
                zzv2.zzg();
                n = n2;
            }
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            zze.zzi((String)activityNotFoundException.getMessage());
            n = 6;
        }
        if (zzt2 != null) {
            zzt2.zzb(n);
        }
        if (n == 5) return true;
        return false;
    }
}
