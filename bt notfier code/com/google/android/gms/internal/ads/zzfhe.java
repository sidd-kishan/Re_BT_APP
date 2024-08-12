/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.webkit.WebView
 *  com.google.android.gms.internal.ads.zzfge
 *  com.google.android.gms.internal.ads.zzfgg
 *  com.google.android.gms.internal.ads.zzfgm
 *  com.google.android.gms.internal.ads.zzfgv
 *  com.google.android.gms.internal.ads.zzfgx
 *  com.google.android.gms.internal.ads.zzfhi
 *  com.google.android.gms.internal.ads.zzfic
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzfge;
import com.google.android.gms.internal.ads.zzfgg;
import com.google.android.gms.internal.ads.zzfgm;
import com.google.android.gms.internal.ads.zzfgv;
import com.google.android.gms.internal.ads.zzfgx;
import com.google.android.gms.internal.ads.zzfhi;
import com.google.android.gms.internal.ads.zzfic;
import org.json.JSONArray;
import org.json.JSONObject;

public class zzfhe {
    private zzfic zza;
    private long zzb;
    private int zzc;

    public zzfhe() {
        this.zzk();
        this.zza = new zzfic(null);
    }

    public void zza() {
    }

    public void zzb() {
        this.zza.clear();
    }

    final void zzc(WebView webView) {
        this.zza = new zzfic(webView);
    }

    public final WebView zzd() {
        return (WebView)this.zza.get();
    }

    public final boolean zze() {
        if (this.zza.get() == null) return false;
        return true;
    }

    public final void zzf(String string, long l) {
        if (l < this.zzb) return;
        this.zzc = 2;
        zzfgx.zza().zze(this.zzd(), string);
    }

    public final void zzg(String string, long l) {
        if (l < this.zzb) return;
        if (this.zzc == 3) return;
        this.zzc = 3;
        zzfgx.zza().zze(this.zzd(), string);
    }

    public void zzh(zzfgg zzfgg2, zzfge zzfge2) {
        this.zzi(zzfgg2, zzfge2, null);
    }

    protected final void zzi(zzfgg object, zzfge object2, JSONObject jSONObject) {
        object = object.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzfhi.zzc((JSONObject)jSONObject2, (String)"environment", (Object)"app");
        zzfhi.zzc((JSONObject)jSONObject2, (String)"adSessionType", (Object)object2.zzi());
        JSONObject jSONObject3 = new JSONObject();
        String string = Build.MANUFACTURER;
        String string2 = Build.MODEL;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 2 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append("; ");
        stringBuilder.append(string2);
        zzfhi.zzc((JSONObject)jSONObject3, (String)"deviceType", (Object)stringBuilder.toString());
        zzfhi.zzc((JSONObject)jSONObject3, (String)"osVersion", (Object)Integer.toString(Build.VERSION.SDK_INT));
        zzfhi.zzc((JSONObject)jSONObject3, (String)"os", (Object)"Android");
        zzfhi.zzc((JSONObject)jSONObject2, (String)"deviceInfo", (Object)jSONObject3);
        string = new JSONArray();
        string.put((Object)"clid");
        string.put((Object)"vlid");
        zzfhi.zzc((JSONObject)jSONObject2, (String)"supports", (Object)string);
        string = new JSONObject();
        zzfhi.zzc((JSONObject)string, (String)"partnerName", (Object)object2.zzc().zzb());
        zzfhi.zzc((JSONObject)string, (String)"partnerVersion", (Object)object2.zzc().zzc());
        zzfhi.zzc((JSONObject)jSONObject2, (String)"omidNativeInfo", (Object)string);
        string = new JSONObject();
        zzfhi.zzc((JSONObject)string, (String)"libraryVersion", (Object)"1.3.3-google_20200416");
        zzfhi.zzc((JSONObject)string, (String)"appId", (Object)zzfgv.zza().zzb().getApplicationContext().getPackageName());
        zzfhi.zzc((JSONObject)jSONObject2, (String)"app", (Object)string);
        if (object2.zzg() != null) {
            zzfhi.zzc((JSONObject)jSONObject2, (String)"contentUrl", (Object)object2.zzg());
        }
        zzfhi.zzc((JSONObject)jSONObject2, (String)"customReferenceData", (Object)object2.zzh());
        string = new JSONObject();
        object2 = object2.zzd().iterator();
        if (!object2.hasNext()) {
            zzfgx.zza().zzc(this.zzd(), (String)object, jSONObject2, (JSONObject)string, jSONObject);
            return;
        }
        object = (zzfgm)object2.next();
        throw null;
    }

    public final void zzj(float f) {
        zzfgx.zza().zzf(this.zzd(), f);
    }

    public final void zzk() {
        this.zzb = System.nanoTime();
        this.zzc = 1;
    }
}
