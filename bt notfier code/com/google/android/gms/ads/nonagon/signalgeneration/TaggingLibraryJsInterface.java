/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.MotionEvent
 *  android.view.View
 *  android.webkit.JavascriptInterface
 *  android.webkit.WebView
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.AdFormat
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.AdRequest$Builder
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzai
 *  com.google.android.gms.ads.query.QueryInfo
 *  com.google.android.gms.ads.query.QueryInfoGenerationCallback
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzbjl
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zzai;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzbjl;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

final class TaggingLibraryJsInterface {
    private final Context zza;
    private final WebView zzb;
    private final zzaas zzc;

    TaggingLibraryJsInterface(WebView webView, zzaas zzaas2) {
        this.zzb = webView;
        this.zza = webView.getContext();
        this.zzc = zzaas2;
    }

    static /* synthetic */ WebView zza(TaggingLibraryJsInterface taggingLibraryJsInterface) {
        return taggingLibraryJsInterface.zzb;
    }

    @JavascriptInterface
    public String getClickSignals(String string) {
        zzbjl.zza((Context)this.zza);
        try {
            string = this.zzc.zzb().zzm(this.zza, string, (View)this.zzb);
            return string;
        }
        catch (RuntimeException runtimeException) {
            zze.zzg((String)"Exception getting click signals. ", (Throwable)runtimeException);
            zzt.zzg().zzk((Throwable)runtimeException, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    @JavascriptInterface
    public String getQueryInfo() {
        zzt.zzc();
        String string = UUID.randomUUID().toString();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        Context context = this.zza;
        AdFormat adFormat = AdFormat.BANNER;
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        QueryInfo.generate((Context)context, (AdFormat)adFormat, (AdRequest)builder.build(), (QueryInfoGenerationCallback)new zzai(this, string));
        return string;
    }

    @JavascriptInterface
    public String getViewSignals() {
        zzbjl.zza((Context)this.zza);
        try {
            String string = this.zzc.zzb().zzo(this.zza, (View)this.zzb, null);
            return string;
        }
        catch (RuntimeException runtimeException) {
            zze.zzg((String)"Exception getting view signals. ", (Throwable)runtimeException);
            zzt.zzg().zzk((Throwable)runtimeException, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    /*
     * WARNING - void declaration
     */
    @JavascriptInterface
    public void reportTouchEvent(String string) {
        void var1_4;
        zzbjl.zza((Context)this.zza);
        try {
            JSONObject jSONObject = new JSONObject(string);
            int n = jSONObject.getInt("x");
            int n2 = jSONObject.getInt("y");
            int n3 = jSONObject.getInt("duration_ms");
            float f = (float)jSONObject.getDouble("force");
            int n4 = jSONObject.getInt("type");
            n4 = n4 != 0 ? (n4 != 1 ? (n4 != 2 ? (n4 != 3 ? -1 : 3) : 2) : 1) : 0;
            string = MotionEvent.obtain((long)0L, (long)n3, (int)n4, (float)n, (float)n2, (float)f, (float)1.0f, (int)0, (float)1.0f, (float)1.0f, (int)0, (int)0);
            this.zzc.zzd((MotionEvent)string);
            return;
        }
        catch (JSONException jSONException) {
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        zze.zzg((String)"Failed to parse the touch string. ", (Throwable)var1_4);
        zzt.zzg().zzk((Throwable)var1_4, "TaggingLibraryJsInterface.reportTouchEvent");
    }
}
