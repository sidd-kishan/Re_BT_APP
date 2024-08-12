/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.AdLoadCallback
 *  com.google.android.gms.ads.admanager.AdManagerAdRequest
 *  com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback
 *  com.google.android.gms.ads.admanager.AppEventListener
 *  com.google.android.gms.ads.interstitial.InterstitialAd
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbsh
 */
package com.google.android.gms.ads.admanager;

import android.content.Context;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbsh;

public abstract class AdManagerInterstitialAd
extends InterstitialAd {
    public static void load(Context context, String string, AdManagerAdRequest adManagerAdRequest, AdManagerInterstitialAdLoadCallback adManagerInterstitialAdLoadCallback) {
        Preconditions.checkNotNull((Object)context, (Object)"Context cannot be null.");
        Preconditions.checkNotNull((Object)string, (Object)"AdUnitId cannot be null.");
        Preconditions.checkNotNull((Object)adManagerAdRequest, (Object)"AdManagerAdRequest cannot be null.");
        Preconditions.checkNotNull((Object)adManagerInterstitialAdLoadCallback, (Object)"LoadCallback cannot be null.");
        new zzbsh(context, string).zza(adManagerAdRequest.zza(), (AdLoadCallback)adManagerInterstitialAdLoadCallback);
    }

    public abstract AppEventListener getAppEventListener();

    public abstract void setAppEventListener(AppEventListener var1);
}
