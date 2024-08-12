/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.ads.OnPaidEventListener
 *  com.google.android.gms.ads.ResponseInfo
 *  com.google.android.gms.ads.admanager.AdManagerAdRequest
 *  com.google.android.gms.ads.appopen.AppOpenAd$AppOpenAdLoadCallback
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzaye
 */
package com.google.android.gms.ads.appopen;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaye;

public abstract class AppOpenAd {
    public static final int APP_OPEN_AD_ORIENTATION_LANDSCAPE = 2;
    public static final int APP_OPEN_AD_ORIENTATION_PORTRAIT = 1;

    public static void load(Context context, String string, AdRequest adRequest, int n, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.checkNotNull((Object)context, (Object)"Context cannot be null.");
        Preconditions.checkNotNull((Object)string, (Object)"adUnitId cannot be null.");
        Preconditions.checkNotNull((Object)adRequest, (Object)"AdRequest cannot be null.");
        new zzaye(context, string, adRequest.zza(), n, appOpenAdLoadCallback).zza();
    }

    public static void load(Context context, String string, AdManagerAdRequest adManagerAdRequest, int n, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.checkNotNull((Object)context, (Object)"Context cannot be null.");
        Preconditions.checkNotNull((Object)string, (Object)"adUnitId cannot be null.");
        Preconditions.checkNotNull((Object)adManagerAdRequest, (Object)"AdManagerAdRequest cannot be null.");
        new zzaye(context, string, adManagerAdRequest.zza(), n, appOpenAdLoadCallback).zza();
    }

    public abstract String getAdUnitId();

    public abstract FullScreenContentCallback getFullScreenContentCallback();

    public abstract OnPaidEventListener getOnPaidEventListener();

    public abstract ResponseInfo getResponseInfo();

    public abstract void setFullScreenContentCallback(FullScreenContentCallback var1);

    public abstract void setImmersiveMode(boolean var1);

    public abstract void setOnPaidEventListener(OnPaidEventListener var1);

    public abstract void show(Activity var1);
}
