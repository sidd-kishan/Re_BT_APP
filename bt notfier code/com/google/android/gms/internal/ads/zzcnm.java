/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.view.View
 *  android.webkit.JavascriptInterface
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.internal.ads.zzaao
 *  com.google.android.gms.internal.ads.zzcnk
 *  com.google.android.gms.internal.ads.zzcnl
 *  com.google.android.gms.internal.ads.zzcnn
 *  com.google.android.gms.internal.ads.zzcnu
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzaao;
import com.google.android.gms.internal.ads.zzcnk;
import com.google.android.gms.internal.ads.zzcnl;
import com.google.android.gms.internal.ads.zzcnn;
import com.google.android.gms.internal.ads.zzcnu;

public final class zzcnm<WebViewT extends zzcnn & zzcnu> {
    private final zzcnl zza;
    private final WebViewT zzb;

    public zzcnm(WebViewT WebViewT, zzcnl zzcnl2) {
        this.zza = zzcnl2;
        this.zzb = WebViewT;
    }

    @JavascriptInterface
    public String getClickSignals(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            zze.zza((String)"Click string is empty, not proceeding.");
            return "";
        }
        Object object = this.zzb.zzU();
        if (object == null) {
            zze.zza((String)"Signal utils is empty, ignoring.");
            return "";
        }
        zzaao zzaao2 = object.zzb();
        if (zzaao2 == null) {
            zze.zza((String)"Signals object is empty, ignoring.");
            return "";
        }
        if (this.zzb.getContext() == null) {
            zze.zza((String)"Context is null, ignoring.");
            return "";
        }
        Context context = this.zzb.getContext();
        object = this.zzb;
        Activity activity = object.zzj();
        return zzaao2.zzl(context, string, (View)object, activity);
    }

    @JavascriptInterface
    public void notify(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            zze.zzi((String)"URL is empty, ignoring message");
            return;
        }
        zzs.zza.post((Runnable)new zzcnk(this, string));
    }

    final /* synthetic */ void zza(String string) {
        this.zza.zza(Uri.parse((String)string));
    }
}
