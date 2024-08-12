/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.util.Log
 *  android.webkit.WebView
 *  com.google.android.gms.internal.ads.zzffz
 *  com.google.android.gms.internal.ads.zzfgw
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzffz;
import com.google.android.gms.internal.ads.zzfgw;
import org.json.JSONObject;

public final class zzfgx {
    private static final zzfgx zza = new zzfgx();

    private zzfgx() {
    }

    public static zzfgx zza() {
        return zza;
    }

    public final void zzb(WebView webView, JSONObject jSONObject) {
        this.zzg(webView, "init", jSONObject);
    }

    public final void zzc(WebView webView, String string, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.zzg(webView, "startSession", string, jSONObject, jSONObject2, jSONObject3);
    }

    public final void zzd(WebView webView) {
        this.zzg(webView, "finishSession", new Object[0]);
    }

    public final void zze(WebView webView, String string) {
        this.zzg(webView, "setNativeViewHierarchy", string);
    }

    public final void zzf(WebView webView, float f) {
        this.zzg(webView, "setDeviceVolume", Float.valueOf(f));
    }

    final void zzg(WebView object, String object2, Object ... object3) {
        StringBuilder stringBuilder;
        block9: {
            int n;
            block10: {
                block8: {
                    if (object == null) break block8;
                    stringBuilder = new StringBuilder(128);
                    stringBuilder.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
                    stringBuilder.append((String)object2);
                    stringBuilder.append("(");
                    n = ((Object[])object3).length;
                    if (n <= 0) break block9;
                    break block10;
                }
                object = ((String)object2).length() != 0 ? "The WebView is null for ".concat((String)object2) : new String("The WebView is null for ");
                if (zzffz.zza == false) return;
                if (TextUtils.isEmpty((CharSequence)object)) return;
                Log.i((String)"OMIDLIB", (String)object);
                return;
            }
            for (int i = 0; i < n; ++i) {
                object2 = object3[i];
                if (object2 == null) {
                    stringBuilder.append("\"\"");
                } else if (object2 instanceof String) {
                    if (((String)(object2 = object2.toString())).startsWith("{")) {
                        stringBuilder.append((String)object2);
                    } else {
                        stringBuilder.append('\"');
                        stringBuilder.append((String)object2);
                        stringBuilder.append('\"');
                    }
                } else {
                    stringBuilder.append(object2);
                }
                stringBuilder.append(",");
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        stringBuilder.append(")}");
        object3 = stringBuilder.toString();
        object2 = object.getHandler();
        if (object2 != null && Looper.myLooper() != object2.getLooper()) {
            object2.post((Runnable)new zzfgw(this, object, (String)object3));
            return;
        }
        object.loadUrl((String)object3);
    }
}
