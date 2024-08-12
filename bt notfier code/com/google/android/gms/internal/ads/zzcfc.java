/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;

public final class zzcfc {
    public static String zza(String string, Context context, boolean bl) {
        Object object = zzbjl.zzag;
        if (((Boolean)zzbet.zzc().zzc(object)).booleanValue()) {
            if (!bl) return string;
        }
        object = string;
        if (!zzt.zzA().zzb(context)) return object;
        if (TextUtils.isEmpty((CharSequence)string)) {
            object = string;
        } else {
            String string2 = zzt.zzA().zzl(context);
            if (string2 == null) {
                return string;
            }
            object = zzbjl.zzZ;
            String string3 = (String)zzbet.zzc().zzc(object);
            object = zzbjl.zzY;
            if (((Boolean)zzbet.zzc().zzc(object)).booleanValue() && string.contains(string3)) {
                if (zzt.zzc().zzp(string)) {
                    zzt.zzA().zzn(context, string2);
                    return zzcfc.zzd(string, context).replace(string3, string2);
                }
                object = string;
                if (!zzt.zzc().zzq(string)) return object;
                zzt.zzA().zzo(context, string2);
                return zzcfc.zzd(string, context).replace(string3, string2);
            }
            object = string;
            if (string.contains("fbs_aeid")) return object;
            if (zzt.zzc().zzp(string)) {
                zzt.zzA().zzn(context, string2);
                return zzcfc.zzc(zzcfc.zzd(string, context), "fbs_aeid", string2).toString();
            }
            object = string;
            if (!zzt.zzc().zzq(string)) return object;
            zzt.zzA().zzo(context, string2);
            object = zzcfc.zzc(zzcfc.zzd(string, context), "fbs_aeid", string2).toString();
        }
        return object;
    }

    public static String zzb(Uri object, Context context) {
        if (!zzt.zzA().zzb(context)) {
            return object.toString();
        }
        String string = zzt.zzA().zzl(context);
        if (string == null) {
            return object.toString();
        }
        Object object2 = zzbjl.zzZ;
        String string2 = (String)zzbet.zzc().zzc((zzbjd)object2);
        object2 = object.toString();
        zzbjd zzbjd2 = zzbjl.zzY;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && ((String)object2).contains(string2)) {
            zzt.zzA().zzn(context, string);
            object = zzcfc.zzd((String)object2, context).replace(string2, string);
        } else {
            if (TextUtils.isEmpty((CharSequence)object.getQueryParameter("fbs_aeid"))) {
                object = zzcfc.zzc(zzcfc.zzd((String)object2, context), "fbs_aeid", string).toString();
                zzt.zzA().zzn(context, string);
                return object;
            }
            object = object2;
        }
        return object;
    }

    static Uri zzc(String string, String string2, String string3) {
        int n;
        int n2 = n = string.indexOf("&adurl");
        if (n == -1) {
            n2 = string.indexOf("?adurl");
        }
        if (n2 == -1) return Uri.parse((String)string).buildUpon().appendQueryParameter(string2, string3).build();
        StringBuilder stringBuilder = new StringBuilder(string.substring(0, ++n2));
        stringBuilder.append(string2);
        stringBuilder.append("=");
        stringBuilder.append(string3);
        stringBuilder.append("&");
        stringBuilder.append(string.substring(n2));
        return Uri.parse((String)stringBuilder.toString());
    }

    private static String zzd(String object, Context object2) {
        String string = zzt.zzA().zzj((Context)object2);
        String string2 = zzt.zzA().zzk((Context)object2);
        object2 = object;
        if (!((String)object).contains("gmp_app_id")) {
            object2 = object;
            if (!TextUtils.isEmpty((CharSequence)string)) {
                object2 = zzcfc.zzc((String)object, "gmp_app_id", string).toString();
            }
        }
        object = object2;
        if (((String)object2).contains("fbs_aiid")) return object;
        object = object2;
        if (TextUtils.isEmpty((CharSequence)string2)) return object;
        object = zzcfc.zzc((String)object2, "fbs_aiid", string2).toString();
        return object;
    }
}
