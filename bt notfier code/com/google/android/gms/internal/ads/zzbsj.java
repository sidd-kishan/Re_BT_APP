/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbsk
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbsk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbsj {
    public static void zza(zzbsk zzbsk2, String string, JSONObject jSONObject) {
        zzbsk2.zzbl(string, jSONObject.toString());
    }

    public static void zzb(zzbsk zzbsk2, String string, String string2) {
        int n = String.valueOf(string2).length();
        StringBuilder stringBuilder = new StringBuilder(string.length() + 3 + n);
        stringBuilder.append(string);
        stringBuilder.append("(");
        stringBuilder.append(string2);
        stringBuilder.append(");");
        zzbsk2.zza(stringBuilder.toString());
    }

    public static void zzc(zzbsk zzbsk2, String string, JSONObject object) {
        String string2 = object.toString();
        object = new StringBuilder();
        ((StringBuilder)object).append("(window.AFMA_ReceiveMessage || function() {})('");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append("',");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(");");
        string = ((StringBuilder)object).toString();
        string = string.length() != 0 ? "Dispatching AFMA event: ".concat(string) : new String("Dispatching AFMA event: ");
        zze.zzd((String)string);
        zzbsk2.zza(((StringBuilder)object).toString());
    }

    public static void zzd(zzbsk zzbsk2, String string, Map map) {
        try {
            map = zzt.zzc().zzj(map);
        }
        catch (JSONException jSONException) {
            zze.zzi((String)"Could not convert parameters to JSON.");
            return;
        }
        zzbsk2.zzd(string, (JSONObject)map);
    }
}
