/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzdtm {
    public static String zza(JSONObject jSONObject, String string, String string2) {
        if (jSONObject == null) {
            return "";
        }
        JSONArray jSONArray = jSONObject.optJSONArray(string2);
        if (jSONArray == null) return "";
        int n = 0;
        while (n < jSONArray.length()) {
            string2 = jSONArray.optJSONObject(n);
            if (string2 != null) {
                JSONArray jSONArray2 = string2.optJSONArray("including");
                jSONObject = string2.optJSONArray("excluding");
                if (zzdtm.zzb(jSONArray2, string) && !zzdtm.zzb((JSONArray)jSONObject, string)) {
                    return string2.optString("effective_ad_unit_id", "");
                }
            }
            ++n;
        }
        return "";
    }

    private static boolean zzb(JSONArray jSONArray, String string) {
        if (jSONArray == null) return false;
        if (string == null) return false;
        int n = 0;
        while (n < jSONArray.length()) {
            String string2 = jSONArray.optString(n);
            try {
                boolean bl = Pattern.compile(string2).matcher(string).lookingAt();
                if (bl) return true;
            }
            catch (PatternSyntaxException patternSyntaxException) {
                zzt.zzg().zzk((Throwable)patternSyntaxException, "RtbAdapterMap.hasAtleastOneRegexMatch");
            }
            ++n;
        }
        return false;
    }
}
