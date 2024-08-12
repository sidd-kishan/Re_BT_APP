/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.os.Build$VERSION
 *  android.view.WindowManager
 *  com.google.android.gms.internal.ads.zzfgu
 *  com.google.android.gms.internal.ads.zzfhj
 *  com.google.android.gms.internal.ads.zzfhm
 *  com.google.android.gms.internal.ads.zzged
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzfgu;
import com.google.android.gms.internal.ads.zzfhj;
import com.google.android.gms.internal.ads.zzfhm;
import com.google.android.gms.internal.ads.zzged;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzfhi {
    static float zza;
    private static WindowManager zzb;
    private static final String[] zzc;

    static {
        zzc = new String[]{"x", "y", "width", "height"};
        zza = Resources.getSystem().getDisplayMetrics().density;
    }

    public static void zza(Context context) {
        if (context == null) return;
        zza = context.getResources().getDisplayMetrics().density;
        zzb = (WindowManager)context.getSystemService("window");
    }

    public static JSONObject zzb(int n, int n2, int n3, int n4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double)((float)n / zza));
            jSONObject.put("y", (double)((float)n2 / zza));
            jSONObject.put("width", (double)((float)n3 / zza));
            jSONObject.put("height", (double)((float)n4 / zza));
        }
        catch (JSONException jSONException) {
            zzfhj.zza((String)"Error with creating viewStateObject", (Exception)((Object)jSONException));
        }
        return jSONObject;
    }

    public static void zzc(JSONObject object, String string, Object object2) {
        try {
            object.put(string, object2);
            return;
        }
        catch (JSONException jSONException) {
            object = new StringBuilder(String.valueOf(string).length() + 47);
            ((StringBuilder)object).append("JSONException during JSONObject.put for name [");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append("]");
            zzfhj.zza((String)((StringBuilder)object).toString(), (Exception)((Object)jSONException));
            return;
        }
    }

    public static void zzd(JSONObject jSONObject, String string) {
        try {
            jSONObject.put("adSessionId", (Object)string);
            return;
        }
        catch (JSONException jSONException) {
            zzfhj.zza((String)"Error with setting ad session id", (Exception)((Object)jSONException));
            return;
        }
    }

    public static void zze(JSONObject jSONObject, String string) {
        try {
            jSONObject.put("notVisibleReason", (Object)string);
            return;
        }
        catch (JSONException jSONException) {
            zzfhj.zza((String)"Error with setting not visible reason", (Exception)((Object)jSONException));
            return;
        }
    }

    public static void zzf(JSONObject jSONObject, zzfhm object) {
        zzfgu zzfgu2 = object.zzb();
        JSONArray jSONArray = new JSONArray();
        object = object.zzc();
        int n = object.size();
        for (int i = 0; i < n; ++i) {
            jSONArray.put((Object)((String)object.get(i)));
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", (Object)jSONArray);
            jSONObject.put("friendlyObstructionClass", (Object)zzfgu2.zzb());
            jSONObject.put("friendlyObstructionPurpose", (Object)zzfgu2.zzc());
            jSONObject.put("friendlyObstructionReason", (Object)zzfgu2.zzd());
            return;
        }
        catch (JSONException jSONException) {
            zzfhj.zza((String)"Error with setting friendly obstruction", (Exception)((Object)jSONException));
            return;
        }
    }

    public static void zzg(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray jSONArray;
            JSONArray jSONArray2 = jSONArray = jSONObject.optJSONArray("childViews");
            if (jSONArray == null) {
                jSONArray2 = new JSONArray();
                jSONObject.put("childViews", (Object)jSONArray2);
            }
            jSONArray2.put((Object)jSONObject2);
            return;
        }
        catch (JSONException jSONException) {
            zzged.zzb((Throwable)jSONException);
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void zzh(JSONObject var0) {
        block7: {
            block6: {
                var14_2 = Build.VERSION.SDK_INT;
                var11_4 = 0.0f;
                var9_5 = 0.0f;
                if (var14_2 < 17) break block6;
                if (zzfhi.zzb == null) ** GOTO lbl-1000
                var15_6 = new Point(0, 0);
                zzfhi.zzb.getDefaultDisplay().getRealSize(var15_6);
                var9_5 = (float)var15_6.x / zzfhi.zza;
                var10_8 = (float)var15_6.y / zzfhi.zza;
                break block7;
            }
            var15_7 = var0.optJSONArray("childViews");
            if (var15_7 != null) {
                var14_2 = var15_7.length();
                var10_8 = 0.0f;
                for (var13_3 = 0; var13_3 < var14_2; ++var13_3) {
                    var16_14 = var15_7.optJSONObject(var13_3);
                    var12_13 = var9_5;
                    var11_4 = var10_8;
                    if (var16_14 != null) {
                        var3_10 = var16_14.optDouble("x");
                        var5_11 = var16_14.optDouble("y");
                        var7_12 = var16_14.optDouble("width");
                        var1_9 = var16_14.optDouble("height");
                        var12_13 = Math.max(var9_5, (float)(var3_10 + var7_12));
                        var11_4 = Math.max(var10_8, (float)(var5_11 + var1_9));
                    }
                    var9_5 = var12_13;
                    var10_8 = var11_4;
                }
            } else lbl-1000:
            // 2 sources

            {
                var10_8 = 0.0f;
                var9_5 = var11_4;
            }
        }
        var1_9 = var9_5;
        try {
            var0.put("width", var1_9);
            var0.put("height", (double)var10_8);
            return;
        }
        catch (JSONException var0_1) {
            zzged.zzb((Throwable)var0_1);
            return;
        }
    }

    public static boolean zzi(JSONObject jSONObject, JSONObject jSONObject2) {
        String string;
        int n;
        if (jSONObject == null) {
            if (jSONObject2 == null) return true;
        }
        if (jSONObject == null) return false;
        if (jSONObject2 == null) return false;
        JSONArray jSONArray = zzc;
        for (n = 0; n < 4; ++n) {
            string = jSONArray[n];
            if (jSONObject.optDouble(string) != jSONObject2.optDouble(string)) return false;
        }
        if (!jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""))) return false;
        jSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        string = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (jSONArray != null || string != null) {
            if (!zzfhi.zzj(jSONArray, (JSONArray)string)) return false;
            for (n = 0; n < jSONArray.length(); ++n) {
                if (!jSONArray.optString(n, "").equals(string.optString(n, ""))) return false;
            }
        }
        jSONObject = jSONObject.optJSONArray("childViews");
        jSONObject2 = jSONObject2.optJSONArray("childViews");
        if (jSONObject == null) {
            if (jSONObject2 == null) return true;
        }
        if (!zzfhi.zzj((JSONArray)jSONObject, (JSONArray)jSONObject2)) return false;
        n = 0;
        while (n < jSONObject.length()) {
            if (!zzfhi.zzi(jSONObject.optJSONObject(n), jSONObject2.optJSONObject(n))) return false;
            ++n;
        }
        return true;
    }

    private static boolean zzj(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null) {
            if (jSONArray2 == null) return true;
        }
        if (jSONArray == null) return false;
        if (jSONArray2 == null) {
            return false;
        }
        if (jSONArray.length() != jSONArray2.length()) return false;
        return true;
    }
}
