/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzcml
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzcml;
import org.json.JSONException;
import org.json.JSONObject;

public class zzbyp {
    private final zzcml zza;
    private final String zzb;

    public zzbyp(zzcml zzcml2, String string) {
        this.zza = zzcml2;
        this.zzb = string;
    }

    public final void zzf(String string) {
        try {
            JSONObject jSONObject = new JSONObject();
            string = jSONObject.put("message", (Object)string).put("action", (Object)this.zzb);
            jSONObject = this.zza;
            if (jSONObject == null) return;
            jSONObject.zzd("onError", (JSONObject)string);
            return;
        }
        catch (JSONException jSONException) {
            zze.zzg((String)"Error occurred while dispatching error event.", (Throwable)jSONException);
            return;
        }
    }

    public final void zzg(String string) {
        try {
            JSONObject jSONObject = new JSONObject();
            string = jSONObject.put("js", (Object)string);
            this.zza.zzd("onReadyEventReceived", (JSONObject)string);
            return;
        }
        catch (JSONException jSONException) {
            zze.zzg((String)"Error occurred while dispatching ready Event.", (Throwable)jSONException);
            return;
        }
    }

    public final void zzh(int n, int n2, int n3, int n4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject = jSONObject.put("x", n).put("y", n2).put("width", n3).put("height", n4);
            this.zza.zzd("onSizeChanged", jSONObject);
            return;
        }
        catch (JSONException jSONException) {
            zze.zzg((String)"Error occurred while dispatching size change.", (Throwable)jSONException);
            return;
        }
    }

    public final void zzi(int n, int n2, int n3, int n4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject = jSONObject.put("x", n).put("y", n2).put("width", n3).put("height", n4);
            this.zza.zzd("onDefaultPositionReceived", jSONObject);
            return;
        }
        catch (JSONException jSONException) {
            zze.zzg((String)"Error occurred while dispatching default position.", (Throwable)jSONException);
            return;
        }
    }

    public final void zzj(String string) {
        try {
            JSONObject jSONObject = new JSONObject();
            string = jSONObject.put("state", (Object)string);
            this.zza.zzd("onStateChanged", (JSONObject)string);
            return;
        }
        catch (JSONException jSONException) {
            zze.zzg((String)"Error occurred while dispatching state change.", (Throwable)jSONException);
            return;
        }
    }

    public final void zzk(int n, int n2, int n3, int n4, float f, int n5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject = jSONObject.put("width", n).put("height", n2).put("maxSizeWidth", n3).put("maxSizeHeight", n4).put("density", (double)f).put("rotation", n5);
            this.zza.zzd("onScreenInfoChanged", jSONObject);
            return;
        }
        catch (JSONException jSONException) {
            zze.zzg((String)"Error occurred while obtaining screen information.", (Throwable)jSONException);
            return;
        }
    }
}
