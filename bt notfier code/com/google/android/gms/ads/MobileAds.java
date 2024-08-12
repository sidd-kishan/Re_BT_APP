/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 *  com.google.android.gms.ads.OnAdInspectorClosedListener
 *  com.google.android.gms.ads.RequestConfiguration
 *  com.google.android.gms.ads.initialization.InitializationStatus
 *  com.google.android.gms.ads.initialization.OnInitializationCompleteListener
 *  com.google.android.gms.ads.mediation.rtb.RtbAdapter
 *  com.google.android.gms.internal.ads.zzbhs
 */
package com.google.android.gms.ads;

import android.content.Context;
import android.webkit.WebView;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.internal.ads.zzbhs;

public class MobileAds {
    public static final String ERROR_DOMAIN = "com.google.android.gms.ads";

    private MobileAds() {
    }

    public static void disableMediationAdapterInitialization(Context context) {
        zzbhs.zze().zzo(context);
    }

    public static InitializationStatus getInitializationStatus() {
        return zzbhs.zze().zzn();
    }

    public static RequestConfiguration getRequestConfiguration() {
        return zzbhs.zze().zzr();
    }

    public static String getVersionString() {
        return zzbhs.zze().zzl();
    }

    public static void initialize(Context context) {
        zzbhs.zze().zzf(context, null, null);
    }

    public static void initialize(Context context, OnInitializationCompleteListener onInitializationCompleteListener) {
        zzbhs.zze().zzf(context, null, onInitializationCompleteListener);
    }

    public static void openAdInspector(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        zzbhs.zze().zzp(context, onAdInspectorClosedListener);
    }

    public static void openDebugMenu(Context context, String string) {
        zzbhs.zze().zzk(context, string);
    }

    public static void registerRtbAdapter(Class<? extends RtbAdapter> clazz) {
        zzbhs.zze().zzm(clazz);
    }

    public static void registerWebView(WebView webView) {
        zzbhs.zze().zzt(webView);
    }

    public static void setAppMuted(boolean bl) {
        zzbhs.zze().zzi(bl);
    }

    public static void setAppVolume(float f) {
        zzbhs.zze().zzg(f);
    }

    public static void setRequestConfiguration(RequestConfiguration requestConfiguration) {
        zzbhs.zze().zzs(requestConfiguration);
    }
}
