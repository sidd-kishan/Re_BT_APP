/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.google.android.gms.ads.AdLoadCallback
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.ads.OnPaidEventListener
 *  com.google.android.gms.ads.ResponseInfo
 *  com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbsh
 */
package com.google.android.gms.ads.interstitial;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbsh;

public abstract class InterstitialAd {
    public static void load(Context context, String string, AdRequest adRequest, InterstitialAdLoadCallback interstitialAdLoadCallback) {
        Preconditions.checkNotNull((Object)context, (Object)"Context cannot be null.");
        Preconditions.checkNotNull((Object)string, (Object)"AdUnitId cannot be null.");
        Preconditions.checkNotNull((Object)adRequest, (Object)"AdRequest cannot be null.");
        Preconditions.checkNotNull((Object)interstitialAdLoadCallback, (Object)"LoadCallback cannot be null.");
        new zzbsh(context, string).zza(adRequest.zza(), (AdLoadCallback)interstitialAdLoadCallback);
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
