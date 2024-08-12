/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.webkit.WebView
 *  com.google.android.gms.internal.consent_sdk.zzbd
 *  com.google.android.gms.internal.consent_sdk.zzbh
 *  com.google.android.gms.internal.consent_sdk.zzbj
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.consent_sdk;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;
import com.google.android.gms.internal.consent_sdk.zzbd;
import com.google.android.gms.internal.consent_sdk.zzbh;
import com.google.android.gms.internal.consent_sdk.zzbj;
import org.json.JSONObject;

public final class zzbe
extends WebView {
    private final Handler zza;
    private final zzbj zzb;
    private boolean zzc = false;

    public zzbe(zzbh zzbh2, Handler handler, zzbj zzbj2) {
        super((Context)zzbh2);
        this.zza = handler;
        this.zzb = zzbj2;
    }

    static /* synthetic */ zzbj zza(zzbe zzbe2) {
        return zzbe2.zzb;
    }

    static /* synthetic */ boolean zza(zzbe zzbe2, String string) {
        return zzbe.zza(string);
    }

    static /* synthetic */ boolean zza(zzbe zzbe2, boolean bl) {
        zzbe2.zzc = true;
        return true;
    }

    private static boolean zza(String string) {
        if (string == null) return false;
        if (!string.startsWith("consent://")) return false;
        return true;
    }

    static /* synthetic */ boolean zzb(zzbe zzbe2) {
        return zzbe2.zzc;
    }

    public final void zza(String string, JSONObject object) {
        String string2 = object.toString();
        object = new StringBuilder(String.valueOf(string).length() + 3 + String.valueOf(string2).length());
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append("(");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(");");
        string = ((StringBuilder)object).toString();
        this.zza.post((Runnable)new zzbd(this, string));
    }
}
